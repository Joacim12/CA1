package client;

import java.io.IOException;

/**
 *
 * @author joaci
 */
public class StartClient {

    public static void main(String[] args) throws IOException, InterruptedException {
        MyClient myClient = new MyClient("localhost", 8081);
        myClient.sendMessage("LOGIN#b\nMSG#ALL#HEJ\nMSG#ALL#HEJSA");

    }
}
