package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

public class MyClient  {
   
    private final Socket CLIENTSOCKET;

    public MyClient(String host, int port) {  
            CLIENTSOCKET = new Socket();
        try {
            CLIENTSOCKET.connect(new InetSocketAddress(host, port));
        } catch (IOException ex) {  
            System.out.println("exception!");
        }        
    }
    
    public void sendMessage(String message) throws IOException, InterruptedException  {         
        OutputStream output = CLIENTSOCKET.getOutputStream();
        PrintWriter writer = new PrintWriter(output,true);
        writer.println(message);  
        System.out.println(message);
    }

    public String readMessage() throws IOException  {
        InputStream input = CLIENTSOCKET.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));       
        return reader.readLine();
    }
    
    public Socket getSocket(){
        return CLIENTSOCKET;
    }

}
