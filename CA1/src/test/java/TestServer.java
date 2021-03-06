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
    public void testLoginFail() throws IOException, InterruptedException {
        MyClient client1 = new MyClient("localhost", 8081);
        MyClient client2 = new MyClient("localhost", 8081);
        client1.sendMessage("LOGIN#Jens");
        Thread.sleep(100);
        client2.sendMessage("LOGIN#Jens");
        String msg = client2.readMessage();      
        assertEquals("FAIL", msg);
    }

    @Test
    public void testMSGToOne() throws InterruptedException, IOException, Exception {
        MyClient client = new MyClient("localhost", 8081);
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
//    @Test
//    public void testDelete() throws IOException, InterruptedException {
//        MyClient client1 = new MyClient("localhost", 8081);
//        MyClient client2 = new MyClient("localhost", 8081);
//        client1.start();
//        client1.sendMessage("LOGIN#Hans");
//        client2.sendMessage("LOGIN#Bob");
//        
//        client2 = null;
////        client2.sendMessage("MSG#ALL#empty");
//  //      client2.sendMessage("MSG#ALL#empty1");
//        client1.readMessage();
//        client1.readMessage();
//        String msg = client1.readMessage();
//        assertEquals("DELETE#Bob", msg);
//        client1.sleep(100);
//        client1.isRunning = false;
//    }
//}

//    @Test
//    public void testLogin() throws InterruptedException, IOException {
//        MyClient client = new MyClient("localhost", 8081);        
//        client.sendMessage("LOGIN#Lars");
//        String msg = client.readMessage();
//        assertEquals("OK#Lars", msg);
//    }
//
//    @Test
//    public void testMSGToOne() throws InterruptedException, IOException, Exception {      
//       MyClient client = new MyClient("localhost",8081); 
//       client.sendMessage("LOGIN#Peter\nMSG#Peter#Hej Peter");           
//       client.readMessage();       
//       client.readMessage();
//       String messageWeWant = client.readMessage();    
//       assertTrue(messageWeWant.equals("MSG#Peter#Hej Peter"));        
//    }
//    
//    @Test
//    public void testMSGToAll() throws InterruptedException, IOException {
//        MyClient client = new MyClient("localhost", 8081);       
//        client.sendMessage("LOGIN#Klaus\nMSG#ALL#Hej allesammen");
//        client.readMessage();
//        client.readMessage();
//        String messageWeWant = client.readMessage();        
//        assertEquals("MSG#Klaus#Hej allesammen", messageWeWant);       

//    }
//}   




//    @Test
//    public void testLogin() throws InterruptedException, IOException {
//        MyClient client = new MyClient("localhost", 8081);
//        client.sendMessage("LOGIN#Lars");
//        String msg = client.readMessage();
//        assertEquals("OK#Lars", msg);
//    }
//
//    @Test
//    public void testMSGToOne() throws InterruptedException, IOException {
//        MyClient sender = new MyClient("localhost", 8081);
//        MyClient reciever = new MyClient("localhost", 8081);
//
//        sender.sendMessage("LOGIN#Ole");
//        reciever.sendMessage("LOGIN#Peter");
//        System.out.println("123 " + reciever.readMessage());
//        Thread.sleep(1000);
//        sender.sendMessage("MSG#Peter#Hej Peter");
//        System.out.println("123 " + reciever.readMessage());
//        String msg = reciever.readMessage();
//        System.out.println("123 " + msg);
//        assertEquals("MSG#Ole#Hej Peter", msg);
//    }


//    @Test
//    public void testMSGToAll() throws InterruptedException, IOException {
//        MyClient sender = new MyClient("localhost", 8081);
//        MyClient reciever = new MyClient("localhost", 8081); 
//        MyClient reciever2 = new MyClient("localhost", 8081);
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
//
//    }  
//    
//    @Test
//    public void testfLogin() throws InterruptedException, IOException {
//        MyClient client = new MyClient("localhost", 8081);
//        client.start();
//        client.sendMessage("LOGIN#Lars");
//        String msg = client.readMessage();
//        assertEquals("OK#Lars", msg);
//        client.isRunning = false;
//    }
//
//    @Test
//    public void testMSGToOne() throws InterruptedException, IOException {
//        MyClient sender = new MyClient("localhost", 8081);
//        MyClient reciever = new MyClient("localhost", 8081);
//        sender.start();
//        reciever.start();
//        sender.sendMessage("LOGIN#Ole");
//        reciever.sendMessage("LOGIN#Peter");
//        System.out.println("123 " + reciever.readMessage());
//        
//        sender.sendMessage("MSG#Peter#Hej Peter");
//        //sender.sleep(100);
//       // reciever.sleep(10);
//        System.out.println("123 " + reciever.readMessage());
//        String msg = reciever.readMessage();
//        System.out.println("123 " + msg);
//        assertEquals("MSG#Ole#Hej Peter", msg);
//        sender.isRunning = false;
//        reciever.isRunning = false;
//    }
//    @Test
//    public void testMSGToAll() throws InterruptedException, IOException {
//        MyClient sender = new MyClient("localhost", 8081);
//        MyClient reciever = new MyClient("localhost", 8081); 
//        MyClient reciever2 = new MyClient("localhost", 8081);
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