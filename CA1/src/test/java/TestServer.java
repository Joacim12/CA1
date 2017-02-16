
import server.ChatServer;
import client.MyClient;
import java.io.IOException;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author zaeemshafiq
 */
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