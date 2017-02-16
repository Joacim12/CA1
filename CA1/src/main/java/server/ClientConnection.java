package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import static server.ChatServer.clients;
import static server.ChatServer.sendCommandToAll;

/**
 * 
 * @author joaci
 */
class ClientConnection extends Thread {

    public Socket socket = new Socket();
    public String username;
    private InputStream input;
    private OutputStream output;
    private PrintWriter writer;

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

    public void handleConnection()  {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            String readBuffer;
            while((readBuffer = reader.readLine()) != null) {
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
            }
        } catch (IOException ex) {
            try {
                sendCommandToAll(username, "DELETE");
            } catch (IOException ex1) {
                ex.printStackTrace();
            }
                clients.remove(this);
        }
    }

    private void loginCase(String reader) throws IOException {
        username = reader.split("#")[1];
        int counter = 0;        
        for (ClientConnection cc : ChatServer.clients) {
            if (!cc.username.equals(username)) {
                counter++;
            }
        }
        if (counter == ChatServer.clients.size()) {
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

    private void messageCase(String reader) throws IOException {
        if(reader.split("#")[1].toLowerCase().equals("all")) {           
            ChatServer.sendMsgToAll(reader.split("#")[2], username);
        } else {           
            ChatServer.sendMsgToUser(reader.split("#")[2], reader.split("#")[1], username);               
        }        
    }  
    
}