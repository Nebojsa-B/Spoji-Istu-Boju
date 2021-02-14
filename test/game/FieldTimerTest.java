package game;

import javafx.application.Application;
import javafx.stage.Stage;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class FieldTimerTest {
    
    public FieldTimerTest() {
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
     * Test of run method, of class FieldTimer.
     */
    @Test
    public void testRun() {
        class AppTest extends Application
        {
            @Override
            public void start(Stage primaryStage) throws Exception {
                System.out.println("run");
                FieldTimer instance = new FieldTimer(new Field("","", new Game()), 100);
                instance.run();
            }
        }
    }
    
}
