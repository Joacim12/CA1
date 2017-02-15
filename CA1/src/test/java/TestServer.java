
import com.mycompany.ca1.ChatServer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author zaeemshafiq
 */
public class TestServer {
    
    public TestServer() {
    }
    
    @BeforeClass
    public static void setUpClass() {
//        new Thread(() -> {
//            ChatServer cs = new ChatServer();
//        }).start();
    }
    
    @Before
    public void setUp() throws IOException {
//        new Thread(() -> {
//            ChatServer cs = new ChatServer();
//        }).start();
    }

     @Test
     public void testLogin() throws IOException {
        Socket socket = new Socket();

        socket.connect(new InetSocketAddress("vetterlain.dk", 8081));
        OutputStream os = socket.getOutputStream();
        PrintWriter out = new PrintWriter(os);
        
        out.println("LOGIN#Tom");
        out.flush();
        
        
        
        InputStream is = socket.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        
        String line = reader.readLine();
        
         System.out.println(line);
        
         assertEquals("OK#Tom", line);
     }
     
     @Test
     public void testMSGToOne() throws IOException {
        Socket socket = new Socket();

        socket.connect(new InetSocketAddress("vetterlain.dk", 8081));
        OutputStream os = socket.getOutputStream();
        PrintWriter out = new PrintWriter(os);
        
        out.println("LOGIN#Tom");
        out.println("LOGIN#Tim");
        
        out.println("MSG#Tom#Hey!");
        out.flush();
        
        InputStream is = socket.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        
        String line = reader.readLine();
        
         System.out.println(line);
        
         assertEquals("OK#Tom", line);
     }
}
    
