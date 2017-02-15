
import com.mycompany.ca1.ChatServer;
import com.mycompany.ca1.MyClient;
import java.io.IOException;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
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

//    @Before
//    public void setUp()  {
//        new Thread(() -> {
//            ChatServer cs = new ChatServer();
//            cs.setClientConnection();
//        }).start();
//    }

    
    @Test
    public void testLogin() throws  InterruptedException, IOException {
        MyClient mc = new MyClient("localhost", 8081);
        mc.open();
        mc.sendMessage("LOGIN#Tom");
        String line = mc.readMessage();
        
        assertEquals("OK#Tom", line);
    }
    
    @Test
    public void testMSGToOne() throws  InterruptedException, IOException {
        MyClient mc = new MyClient("localhost", 8081);
        mc.open();
        mc.sendMessage("LOGIN#Tim");
        String line = mc.readMessage();
        
        assertEquals("OK#Kim7", line);
    }

//     @Test
//     public void testMSGToOne() throws IOException {
//        Socket socket = new Socket();
//
//        socket.connect(new InetSocketAddress("vetterlain.dk", 8081));
//        OutputStream os = socket.getOutputStream();
//        PrintWriter out = new PrintWriter(os);
//        
//        out.println("LOGIN#Tom");
//        out.println("LOGIN#Tim");
//        
//        out.println("MSG#Tom#Hey!");
//        out.flush();
//        
//        InputStream is = socket.getInputStream();
//        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
//        
//        String line = reader.readLine();
//        
//         System.out.println(line);
//        
//         assertEquals("OK#Tom", line);
//     }
}
