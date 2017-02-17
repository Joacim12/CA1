package server;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ChatServer {

    private boolean running = true;
    public static List<ClientConnection> clients;
    private static PrintWriter writer;

    public ChatServer() {
        clients = new CopyOnWriteArrayList<>();
    }

    public void setClientConnection() {
        try (ServerSocket socket = new ServerSocket(8081)) {
            while (running) {
                new ClientConnection(socket.accept()).start();
            }
        } catch (IOException e) {
            System.out.println("en exception");
        }
    }

    public synchronized static void sendCommandToAll(String newUser, String command) throws IOException {
        for (ClientConnection client : clients) {
            OutputStream output = client.getSocket().getOutputStream();
            writer = new PrintWriter(output);
            writer.println(command + "#" + newUser);
            writer.flush();
        }
    }

    public synchronized static void sendMsgToAll(String message, String sender) throws IOException {
        for (ClientConnection client : clients) {
            OutputStream output = client.getSocket().getOutputStream();
            writer = new PrintWriter(output, true);
            writer.println("MSG#" + sender + "#" + message);
            if (writer.checkError()) {
                sendCommandToAll(client.getUsername(), "DELETE");
                clients.remove(client);
            }
        }
    }

    public synchronized static void sendMsgToUser(String message, String reciever, String sender) throws IOException {
        for (ClientConnection client : clients) {
            if (client.getUsername().equals(reciever)) {
                OutputStream output = client.getSocket().getOutputStream();
                writer = new PrintWriter(output);
                writer.println("MSG#" + sender + "#" + message);
                writer.flush();
            }
        }
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

}
