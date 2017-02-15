
import server.ChatServer;
import client.MyClient;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author zaeemshafiq
 */
public class TestServer implements Observer {

    
    public TestServer() {
    }

    @BeforeClass
    public static void setUpClass() {
        new Thread(() -> {
            ChatServer cs = new ChatServer();
            cs.setClientConnection();
        }).start();

       // client = new MyClient("localhost", 8081);
        //client.start();
        
        //client2 = new MyClient("localhost", 8081);
        //client2.start();
        
       // client3 = new MyClient("localhost", 8081);
        //client3.start();
    }

//    @Before
//    public void setUp()  {
//        new Thread(() -> {
//            ChatServer cs = new ChatServer();
//            cs.setClientConnection();
//        }).start();
//    }
    
//    @Test
//    public void testLogin() throws InterruptedException, IOException {
//        MyClient client = new MyClient("localhost",8081);
//        client.open();
//        client.sendMessage("LOGIN#Lars");
//        String line = client.readMessage();
//        assertEquals("OK#Lars", line);
//    }
 
    @Test
    public void testMSGToOne() throws InterruptedException, IOException {
    MyClient client = new MyClient("localhost",8081);
        client.addObserver(this);
                client.open();
                client.readMessage();
  
        MyClient sender = new MyClient("localhost",8081);
        sender.open();
        sender.sendMessage("hej");
        
    }

    @Override
    public void update(Observable o, Object arg) {
        String msg = (String) arg;
        System.out.println(msg);
        switch(msg){
           
        }
    }

}
