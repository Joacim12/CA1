package client;

import java.io.IOException;

public class StartClient {

    public static void main(String[] args) throws IOException, InterruptedException {
        MyClient myClient = new MyClient("vetterlain.dk", 8081);
        myClient.start();
        myClient.sendMessage("LOGIN#test");
        myClient.sendMessage("MSG#ALL#HEJ1");
        myClient.sendMessage("MSG#ALL#HEJ2");
        myClient.sendMessage("MSG#ALL#HEJ3");
        myClient.sendMessage("MSG#ALL#HEJ4");
        myClient.sendMessage("MSG#ALL#HEJ5");
        myClient.sendMessage("MSG#ALL#HEJ6");
        myClient.sendMessage("MSG#ALL#HEJ7");
        myClient.sendMessage("MSG#ALL#HEJ8");
        myClient.sleep(1000);
        myClient.isRunning = false;

    }
}
