package client;

import java.io.IOException;

public class StartClient {

    public static void main(String[] args) throws IOException, InterruptedException {
        MyClient myClient = new MyClient("localhost", 8081);
        MyClient myClient1 = new MyClient("localhost", 8081);      
        
        myClient.sendMessage("LOGIN#afbry1d"); 
        System.out.println(myClient.readMessage());
        System.out.println(myClient.readMessage());
        
        myClient1.sendMessage("LOGIN#1P");
        System.out.println(myClient1.readMessage());
        System.out.println(myClient1.readMessage());   
        myClient1.sendMessage("MSG#ALL#HEJ");
        System.out.println(myClient1.readMessage());
        Thread.sleep(100);
        myClient1.sendMessage("MSG#ALL#HEJ");
        System.out.println(myClient1.readMessage());
        Thread.sleep(100);
        System.out.println(myClient1.readMessage());
        
        
        

    }
}
