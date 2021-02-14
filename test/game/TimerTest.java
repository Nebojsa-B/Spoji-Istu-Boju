package game;

import forms.LoginForma;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TimerTest {
    
    public TimerTest() {
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
     * Test of end method, of class Timer.
     */
    @Test
    public void testEnd() throws IOException {

        class AppTest extends Application
        {
            @Override
            public void start(Stage primaryStage) throws Exception {
                        System.out.println("end");
                        Label n = new Label();
                        Timer instance = new Timer(n);
                        float expResult = 0.0F;
                        float result = instance.end();
                        assertEquals(expResult, result, 0.0);
            }
        }
        
        AppTest n = new AppTest();
    }

    /**
     * Test of run method, of class Timer.
     */
    @Test
    public void testRun() {
        System.out.println("run");
        
        class AppTest extends Application
        {
            @Override
            public void start(Stage primaryStage) throws Exception {
                        System.out.println("end");
                        Label n = new Label();
                        Timer instance = new Timer(n);
                        instance.run();
            }
        }
        
        AppTest n = new AppTest();
    }
    
}
