
import server.ChatServer;
import client.MyClient;
import java.io.IOException;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestServer {

    @BeforeClass
    public static void setUpClass() {
        new Thread(() -> {
            ChatServer cs = new ChatServer();
            cs.setClientConnection();
        }).start();
    }

    @Test
    public void testLogin() throws InterruptedException, IOException {
        MyClient client = new MyClient("localhost", 8081);        
        client.sendMessage("LOGIN#Lars");
        String msg = client.readMessage();
        assertEquals("OK#Lars", msg);
    }

    @Test
    public void testMSGToOne() throws InterruptedException, IOException, Exception {      
       MyClient client = new MyClient("localhost",8081); 
       client.sendMessage("LOGIN#Peter\nMSG#Peter#Hej Peter");           
       client.readMessage();       
       client.readMessage();
       String messageWeWant = client.readMessage();    
       assertTrue(messageWeWant.equals("MSG#Peter#Hej Peter"));        
    }
    
    @Test
    public void testMSGToAll() throws InterruptedException, IOException {
        MyClient client = new MyClient("localhost", 8081);       
        client.sendMessage("LOGIN#Klaus\nMSG#ALL#Hej allesammen");
        client.readMessage();
        client.readMessage();
        String messageWeWant = client.readMessage();        
        assertEquals("MSG#Klaus#Hej allesammen", messageWeWant);       
    }
}







//import server.ChatServer;
//import client.MyClient;
//import java.io.IOException;
//import static org.junit.Assert.assertEquals;
//import org.junit.BeforeClass;
//import org.junit.Test;
//
//public class TestServer {
//
//    public TestServer() {
//    }
//
//    @BeforeClass
//    public static void setUpClass() {
//        new Thread(() -> {
//            ChatServer cs = new ChatServer();
//            cs.setClientConnection();
//        }).start();
//    }
//
//    @Test
//    public void testLogin() throws InterruptedException, IOException {
//        MyClient client = new MyClient("localhost", 8081);
//        client.open();
//        client.sendMessage("LOGIN#Lars");
//        String msg = client.readMessage();
//        assertEquals("OK#Lars", msg);
//    }
//
//    @Test
//    public void testMSGToOne() throws InterruptedException, IOException {
//        MyClient sender = new MyClient("localhost", 8081);
//        sender.open();
//
//        MyClient reciever = new MyClient("localhost", 8081);
//        reciever.open();
//
//        sender.sendMessage("LOGIN#Ole");
//        reciever.sendMessage("LOGIN#Peter");
//        Thread.sleep(250);
//        sender.sendMessage("MSG#Peter#Hej Peter");
//
//        reciever.readMessage();
//        String msg = reciever.readMessage();
//
//        assertEquals("MSG#Ole#Hej Peter", msg);
//    }
//
//    @Test
//    public void testMSGToAll() throws InterruptedException, IOException {
//        MyClient sender = new MyClient("localhost", 8081);
//        sender.open();
//
//        MyClient reciever = new MyClient("localhost", 8081);
//        reciever.open();
//        
//        MyClient reciever2 = new MyClient("localhost", 8081);
//        reciever2.open();
//        
//        sender.sendMessage("LOGIN#Klaus");
//        reciever.sendMessage("LOGIN#Tulle");
//        System.out.println(reciever.readMessage());
//        reciever2.sendMessage("LOGIN#Sam");
//        System.out.println(reciever2.readMessage());
//        System.out.println(reciever2.readMessage());
//        System.out.println(reciever.readMessage());
//        
//        sender.sendMessage("MSG#ALL#Hej allesammen");
//        
//        String msg = reciever.readMessage();
//        String msg2 = reciever2.readMessage();
//        
//        assertEquals("MSG#Klaus#Hej allesammen", msg);
//        assertEquals("MSG#Klaus#Hej allesammen", msg2);
//    }
//}

