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

public class GameFormaTest {
    
    public GameFormaTest() {
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
     * Test of getGameForma method, of class GameForma.
     */
    @Test
    public void testGetGameForma() throws Exception {
       class AppTest extends Application
       {
            @Override
            public void start(Stage primaryStage) throws Exception {
                System.out.println("getGameForma");
                int userID = 0;
                int num_of_fields = 0;
                Stats stats = null;
                Stage stage = null;
                Scene scene = null;
                Scene expResult = null;
                Scene result = GameForma.getGameForma(userID, num_of_fields, stats, stage, scene);
                assertEquals(expResult, result);
            }
       }
    }
    
}
