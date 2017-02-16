
import server.ChatServer;
import client.MyClient;
import java.io.IOException;
import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author zaeemshafiq
 */
public class TestServer {

    public TestServer() {
    }

    @BeforeClass
    public static void setUpClass() {
        new Thread(() -> {
            ChatServer cs = new ChatServer();
            cs.setClientConnection();
        }).start();
    }

//    @Test
//    public void testLogin() throws InterruptedException, IOException {
//        MyClient client = new MyClient("localhost", 8081);        
//        client.sendMessage("LOGIN#Lars");
//        String msg = client.readMessage();
//               System.out.println(msg);
//        assertEquals("OK#Lars", msg);
//    }

//    @Test
//    public void testMSGToOne() throws InterruptedException, IOException {
//        MyClient sender = new MyClient("localhost", 8081);
//      
//
//        MyClient reciever = new MyClient("localhost", 8081);
//      
//        
//        sender.sendMessage("LOGIN#Ole");
//        reciever.sendMessage("LOGIN#Peter");
//        sender.sendMessage("MSG#Peter#Hej Peter");
//        System.out.println(reciever.readMessage());
//        System.out.println(reciever.readMessage());
//        System.out.println("1");
//        String msg = "hej";
//        if(reciever.readMessage() != null) {
//            System.out.println("123");
//         msg= reciever.readMessage();
//            System.out.println(msg);
//        }
//        System.out.println(msg);
//        
//        assertEquals("MSG#Ole#Hej Peter", msg);
//    }
    
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
//        reciever2.sendMessage("LOGIN#Sam");
//        
//        sender.sendMessage("MSG#ALL#Hej allesammen");
//        
//        reciever.readMessage();
//        reciever.readMessage();
//        reciever2.readMessage();
//        reciever2.readMessage(); 
//        
//        String msg = reciever.readMessage();
//        String msg2 = reciever.readMessage();
//        
//        assertEquals("MSG#Klaus#Hej allesammen", msg);
//        assertEquals("MSG#Klaus#Hej allsammen", msg2);
//    }
}
