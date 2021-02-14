package forms;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.Stats;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class MainFormaTest {
    
    public MainFormaTest() {
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
     * Test of getMainForma method, of class MainForma.
     */
    @Test
    public void testGetMainForma() throws Exception {
       class AppTest extends Application
       {
            @Override
            public void start(Stage primaryStage) throws Exception {
                System.out.println("getMainForma");
                String user = "";
                Stats stats = null;
                Scene scene = null;
                Scene expResult = null;
                Scene result = MainForma.getMainForma(user, stats, scene);
                assertEquals(expResult, result);
            }
       }
    }
    
}
