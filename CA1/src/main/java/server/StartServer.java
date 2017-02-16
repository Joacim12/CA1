package server;

public class StartServer {

    public static void main(String[] args) {
        ChatServer c = new ChatServer();
        c.setClientConnection();
    }
}
