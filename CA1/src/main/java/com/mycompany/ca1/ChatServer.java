package com.mycompany.ca1;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {

    private boolean running = true;
    public static List<ClientConnection> clients;
    
    
    public ChatServer(){
        clients = new ArrayList();    
     
    }
    public void setClientConnection() {
        try (ServerSocket socket = new ServerSocket(8081)) {
            while (running) {
                ClientConnection client = new ClientConnection(socket.accept());
                client.start();
            }
        } catch (IOException e) {
        }
    }
    
    public static void sendCommandToAll(String newUser, String command) throws IOException {
        for (ClientConnection client : clients) {
            OutputStream output = client.socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output);
            writer.println(command + "#" + newUser);
            writer.flush();
        }
    }
    
    public static void sendMsgToAll(String message, String sender) throws IOException {
        for (ClientConnection client : clients) {
            OutputStream output = client.socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output);
            writer.println("MSG#" + sender + "#" + message);
            writer.flush();
        }
    }
    
    public static void sendMsgToUser(String message, String reciever, String sender) throws IOException {
        for (ClientConnection client : clients) {
            if(client.username.equals(reciever)) {
                OutputStream output = client.socket.getOutputStream();
                PrintWriter writer = new PrintWriter(output);
                writer.println("MSG#" + sender + "#" + message);
                writer.flush();
            }
        }
    }
    

    public void setRunning(boolean running) {
        this.running = running;
    }

}