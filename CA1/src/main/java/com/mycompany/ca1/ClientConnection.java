package com.mycompany.ca1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

class ClientConnection extends Thread {

    Socket socket = new Socket();
    String username;
    InputStream input;
    OutputStream output;
    PrintWriter writer;

    public ClientConnection(Socket socket) throws IOException {
        output = socket.getOutputStream();
        input = socket.getInputStream();
        writer = new PrintWriter(output);
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            handleConnection();
        } catch (IOException ex) {
            try {
                ChatServer.sendCommandToAll(username, "DELETE");
            } catch (IOException ex1) {
            }
            ChatServer.clients.remove(this);
        }
    }

    public void handleConnection() throws IOException {
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
                    break;
            }
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
    
    private void printAllMsg() throws IOException {
        OutputStream output = socket.getOutputStream();
        PrintWriter writer = new PrintWriter(output);
        for (String s : ChatServer.chatMsg) {
            writer.println(s);
        }
        writer.flush();

    }
}