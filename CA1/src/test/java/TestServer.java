
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

    @Test
    public void testLogin() throws InterruptedException, IOException {
        MyClient client = new MyClient("localhost", 8081);
        client.open();
        client.sendMessage("LOGIN#Lars");
        String msg = client.readMessage();
        System.out.println(msg);
        assertEquals("OK#Lars", msg);
    }

    @Test
    public void testMSGToOne() throws InterruptedException, IOException {
        MyClient sender = new MyClient("localhost", 8081);
        sender.open();

        MyClient reciever = new MyClient("localhost", 8081);
        reciever.open();

        sender.sendMessage("LOGIN#Ole");
        reciever.sendMessage("LOGIN#Peter");
        Thread.sleep(250);
        sender.sendMessage("MSG#Peter#Hej Peter");

        reciever.readMessage();
        String msg = reciever.readMessage();
        System.out.println(msg);

        assertEquals("MSG#Ole#Hej Peter", msg);
    }

    @Test
    public void testMSGToAll() throws InterruptedException, IOException {
        MyClient sender = new MyClient("localhost", 8081);
        sender.open();

        MyClient reciever = new MyClient("localhost", 8081);
        reciever.open();
        
        MyClient reciever2 = new MyClient("localhost", 8081);
        reciever2.open();
        
        sender.sendMessage("LOGIN#Klaus");
        System.out.println("1");
        reciever.sendMessage("LOGIN#Tulle");
        System.out.println("2");
        reciever2.sendMessage("LOGIN#Sam");
        Thread.sleep(1000);
        System.out.println(reciever2.readMessage());
        System.out.println("3");
        
        System.out.println(reciever.readMessage());
        sender.sendMessage("MSG#ALL#Hej allesammen");
        System.out.println("4");
        
        String msg = reciever.readMessage();
        System.out.println("5");
        String msg2 = reciever2.readMessage();
        
        assertEquals("MSG#Klaus#Hej allesammen", msg);
        assertEquals("MSG#Klaus#Hej allesammen", msg2);
    }
}
