/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import control.Controller;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author joaci
 */
public class MessageHandler extends Observable {
    
    private final Socket SOCKET;
    
    public MessageHandler(Socket socket){
        this.SOCKET = socket;
    }
    
    public void login(String username)  {
        sendMessage("LOGIN#"+username);        
    }    
    
    public void sendMessage(String message) {
        OutputStream output = null;
        try {
            output = SOCKET.getOutputStream();
        } catch (IOException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        PrintWriter writer = new PrintWriter(output, true);
        writer.println(message);
    }
    
    public void readMessage()  {
        try {
            InputStream input = SOCKET.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            String line;
            while ((line = reader.readLine()) != null) {
                setChanged();
                notifyObservers(line);
            }
        } catch (IOException ex) {
            System.out.println("ingen forbindelse");    
        }
    }
}