package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

public class MyClient extends Thread {

    private Socket CLIENTSOCKET;
    private PrintWriter writer;
    public boolean isRunning = true;
    public MyClient(String host, int port) {
        CLIENTSOCKET = new Socket();
        try {
            CLIENTSOCKET.connect(new InetSocketAddress(host, port));
            writer = new PrintWriter(CLIENTSOCKET.getOutputStream(), true);
        } catch (IOException ex) {
            System.out.println("exception!");      
        }
        
    }
    
    @Override
    public void run(){
        while(isRunning){
        }
    }

    public void sendMessage(String message) throws IOException, InterruptedException {
        writer.println(message);
        writer.flush();
    }

    public String readMessage() throws IOException {
        InputStream input = CLIENTSOCKET.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        return reader.readLine();
    }
}
