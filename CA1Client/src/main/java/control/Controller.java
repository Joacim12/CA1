package control;

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
import model.Connection;


/**
 *
 * @author joacim
 */
public class Controller extends Observable {

    Connection con;
    Socket clientSocket;
   

    public Controller() {
        con = new Connection("vetterlain.dk", 8081);
        clientSocket = con.getSocket();
    }

    public void login(String username)  {
        sendMessage("LOGIN#"+username);        
    }

    public void sendMessage(String message) {
        OutputStream output = null;
        try {
            output = clientSocket.getOutputStream();
        } catch (IOException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        PrintWriter writer = new PrintWriter(output, true);
        writer.println(message);
    }

    public void readMessage()  {
        try {
            InputStream input = clientSocket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            String line;
            while ((line = reader.readLine()) != null) {
                setChanged();
                notifyObservers(line);
            }
        } catch (IOException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
