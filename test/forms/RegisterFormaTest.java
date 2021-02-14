package forms;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class RegisterFormaTest {
    
    public RegisterFormaTest() {
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
     * Test of getRegisterFormaTest method, of class RegisterForma.
     */
    @Test
    public void testGetRegisterFormaTest() {
       class AppTest extends Application
       {
            @Override
            public void start(Stage primaryStage) throws Exception {
                System.out.println("getRegisterFormaTest");
                Scene expResult = null;
                Scene result = RegisterForma.getRegisterFormaTest();
                assertEquals(expResult, result);
            }
       }
    }

    /**
     * Test of getRegisterForma method, of class RegisterForma.
     */
    @Test
    public void testGetRegisterForma() {
       class AppTest extends Application
       {
            @Override
            public void start(Stage primaryStage) throws Exception {
                System.out.println("getRegisterForma");
                Scene scene = null;
                Scene expResult = null;
                Scene result = RegisterForma.getRegisterForma(scene);
                assertEquals(expResult, result);
            }
       }
    }
    
}
