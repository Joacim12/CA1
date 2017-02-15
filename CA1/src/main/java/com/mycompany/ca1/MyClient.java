package com.mycompany.ca1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyClient extends Observable{

    private String host;
    private int port;
    private Socket clientSocket;

    public MyClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void open() throws IOException {
        clientSocket = new Socket();
        clientSocket.connect(new InetSocketAddress(host, port));
    }

    public void sendMessage(String message) {
        OutputStream output = null;
        try {
            output = clientSocket.getOutputStream();
        } catch (IOException ex) {
            Logger.getLogger(MyClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        PrintWriter writer = new PrintWriter(output, true);
        writer.println(message);
        System.out.println("hallo");
    }

    public String readMessage() throws IOException {
        InputStream input = clientSocket.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        String line;
        while((line = reader.readLine()) != null){
            setChanged();
            notifyObservers(line);
        }
        return line;

    }
}
