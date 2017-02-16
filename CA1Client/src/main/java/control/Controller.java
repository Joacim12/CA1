package control;

import java.net.Socket;
import model.Connection;
import model.MessageHandler;

/**
 *
 * @author joacim
 */
public class Controller   {

    private final Connection CONNECTION;
    private final Socket CLIENTSOCKET;
    private final MessageHandler MESSAGEHANDLER; 

    public Controller(String host, int port) {
        CONNECTION = new Connection(host, port);
        CLIENTSOCKET = CONNECTION.getSocket();
        MESSAGEHANDLER = new MessageHandler(CLIENTSOCKET);     
    }

    public void login(String username)  {
        MESSAGEHANDLER.login(username);
    }

    public void sendMessage(String message) {
        MESSAGEHANDLER.sendMessage(message);
    }

    public void readMessage()  {
        MESSAGEHANDLER.readMessage();
    }
    
    public MessageHandler getMessageHandler(){
        return MESSAGEHANDLER;
    }  
}