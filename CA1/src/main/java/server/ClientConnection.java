package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import static server.ChatServer.clients;
import static server.ChatServer.sendCommandToAll;

class ClientConnection extends Thread {

    private Socket socket = new Socket();
    private String username;
    private final InputStream input;
    private final OutputStream output;
    final PrintWriter writer;

    public ClientConnection(Socket socket) throws IOException {
        output = socket.getOutputStream();
        input = socket.getInputStream();
        writer = new PrintWriter(output);
        this.socket = socket;
    }

    @Override
    public void run() {
        handleConnection();
    }

    public void handleConnection() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(input, "UTF-8"));
            String readBuffer = reader.readLine();            
            while (readBuffer != null) {                
                switch (readBuffer.split("#")[0].toLowerCase()) {
                    case "login":
                        loginCase(readBuffer);
                        break;
                    case "msg":
                        messageCase(readBuffer);
                        break;
                    default:
                        System.out.println(readBuffer);
                        break;
                }
                readBuffer = reader.readLine();
            }
        } catch (IOException ex) {
            try {
                sendCommandToAll(username, "DELETE");
                System.out.println("delete exception");
            } catch (IOException ex1) {
                System.out.println("delete exception");
            }
            clients.remove(this);
        }
    }

    private synchronized void loginCase(String reader) throws IOException {
        username = reader.split("#")[1];
        int counter = 0;
        int clientArraySize = ChatServer.clients.size();
        for (ClientConnection cc : ChatServer.clients) {
            if (!cc.username.equals(username)) {
                counter++;
            }
        }
        if (counter == clientArraySize) {
            ChatServer.clients.add(this);
            String respond = "OK";
            for (ClientConnection cc : ChatServer.clients) {
                respond += "#" + cc.username;
            }
            writer.println(respond);
            writer.flush();
            ChatServer.sendCommandToAll(username, "UPDATE");

        } else {
            String respond = "FAIL";
            writer.println(respond);
            writer.flush();
        }
    }

    private synchronized void messageCase(String reader) throws IOException {
        if (reader.split("#")[1].toLowerCase().equals("all")) {
            ChatServer.sendMsgToAll(reader.split("#")[2], username);
        } else {
            ChatServer.sendMsgToUser(reader.split("#")[2], reader.split("#")[1], username);
        }
    }

    public Socket getSocket() {
        return socket;
    }

    public String getUsername() {
        return username;
    }

}
