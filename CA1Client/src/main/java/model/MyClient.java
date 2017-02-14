package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 *
 * @author joaci
 */
public class MyClient {

    private final String host;
    private final int port;
    private Socket clientSocket;

    public MyClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        MyClient client = new MyClient("vetterlain.dk", 8081);
        client.open();
        client.sendMessage("LOGIN#joacim");
        client.sendMessage("MSG#joacim#HEJ");
        String message = client.readMessage();
        System.out.println(message);
    }    

    public void open() throws IOException {
        clientSocket = new Socket();
        clientSocket.connect(new InetSocketAddress(host, port));
    }

    public void sendMessage(String message) throws IOException, InterruptedException {          
        OutputStream output = clientSocket.getOutputStream();
        PrintWriter writer = new PrintWriter(output,true);
        writer.println(message);       
    }

    public String readMessage() throws IOException {
        InputStream input = clientSocket.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        return line;
    }
}
