package game;

import javafx.application.Application;
import javafx.scene.control.Hyperlink;
import javafx.stage.Stage;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class FieldTest {
    
    public FieldTest() {
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
     * Test of getColor method, of class Field.
     */
    @Test
    public void testGetColor() {
        class AppTest extends Application
        {
            @Override
            public void start(Stage primaryStage) throws Exception {
                System.out.println("getColor");
                Field instance = new Field("","",new Game());
                String expResult = "";
                String result = instance.getColor();
                assertEquals(expResult, result);
            }
        }
    }

    /**
     * Test of setColor method, of class Field.
     */
    @Test
    public void testSetColor() {
        class AppTest extends Application
        {
            @Override
            public void start(Stage primaryStage) throws Exception {
                System.out.println("setColor");
                String color = "";
                Field instance = new Field("","",new Game());
                instance.setColor(color);
            }
        }
    }

    /**
     * Test of setPolje method, of class Field.
     */
    @Test
    public void testSetPolje() {
        class AppTest extends Application
        {
            @Override
            public void start(Stage primaryStage) throws Exception {
                System.out.println("setPolje");
                Hyperlink polje = null;
                Field instance = new Field("","",new Game());
                instance.setPolje(polje);
            }
        }
    }

    /**
     * Test of getPolje method, of class Field.
     */
    @Test
    public void testGetPolje() {
        class AppTest extends Application
        {
            @Override
            public void start(Stage primaryStage) throws Exception {
                System.out.println("getPolje");
                Field instance = new Field("","",new Game());
                Hyperlink expResult = null;
                Hyperlink result = instance.getPolje();
                assertEquals(expResult, result);
            }
        }
    }

    /**
     * Test of isClicked method, of class Field.
     */
    @Test
    public void testIsClicked() {
        class AppTest extends Application
        {
            @Override
            public void start(Stage primaryStage) throws Exception {
                System.out.println("isClicked");
                Field instance = null;
                boolean expResult = false;
                boolean result = instance.isClicked();
                assertEquals(expResult, result);
            }
        }
    }

    /**
     * Test of setClicked method, of class Field.
     */
    @Test
    public void testSetClicked() {
        class AppTest extends Application
        {
            @Override
            public void start(Stage primaryStage) throws Exception {
                System.out.println("setClicked");
                boolean clicked = false;
                Field instance = null;
                instance.setClicked(clicked);
            }
        }
    }

    /**
     * Test of isSolved method, of class Field.
     */
    @Test
    public void testIsSolved() {
        class AppTest extends Application
        {
            @Override
            public void start(Stage primaryStage) throws Exception {
                System.out.println("isSolved");
                Field instance = new Field("","",new Game());
                boolean expResult = false;
                boolean result = instance.isSolved();
                assertEquals(expResult, result);
            }
        }
    }
    
}
