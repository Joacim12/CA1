package model;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author joaci
 */
public class Connection  {

    private final String host;
    private final int port;
    private Socket clientSocket;

    public Connection(String host, int port)  {
        this.host = host;
        this.port = port;
        clientSocket = new Socket();
        try {
            clientSocket.connect(new InetSocketAddress(host, port));
        } catch (IOException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   

    public Socket getSocket() {
        return clientSocket;
    }

}
