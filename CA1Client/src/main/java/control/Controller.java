package control;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Observable;
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

    public void doSomething() throws IOException {
        sendMessage("LOGIN#joacim");
        sendMessage("MSG#joacim#HEJ");
        readMessage();
    }

    public void sendMessage(String message) throws IOException {
        OutputStream output = clientSocket.getOutputStream();
        PrintWriter writer = new PrintWriter(output, true);
        writer.println(message);
    }

    public void readMessage() throws IOException {
        InputStream input = clientSocket.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        String line;
        while ((line = reader.readLine()) != null) {
            setChanged();
            notifyObservers(line);
        }
    }
}
