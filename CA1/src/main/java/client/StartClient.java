/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author joaci
 */
public class StartClient {
    public static void main(String[] args) {
        try {
            MyClient myClient = new MyClient("localhost",8081);
            myClient.open();            
        } catch (IOException ex) {
            Logger.getLogger(StartClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
