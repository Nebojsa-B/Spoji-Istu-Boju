package forms;

import javafx.application.Application;
import javafx.stage.Stage;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class LoginFormaTest {
    
    public LoginFormaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of start method, of class LoginForma.
     */
    @Test
    public void testStart() throws Exception {
       class AppTest extends Application
       {
            @Override
            public void start(Stage primaryStage) throws Exception {
                System.out.println("start");
                LoginForma instance = new LoginForma();
                instance.start(primaryStage);
            }
       }
    }
    
}
