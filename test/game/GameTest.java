package game;

import javafx.application.Application;
import javafx.stage.Stage;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class GameTest {
    
    public GameTest() {
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
     * Test of setStartTime method, of class Game.
     */
    @Test
    public void testSetStartTime() {
        System.out.println("setStartTime");
        long startTime = 0L;
        Game instance = new Game();
        instance.setStartTime(startTime);
    }

    /**
     * Test of setEndTime method, of class Game.
     */
    @Test
    public void testSetEndTime() {
        System.out.println("setEndTime");
        long endTime = 0L;
        Game instance = new Game();
        instance.setEndTime(endTime);
    }

    /**
     * Test of getTimer method, of class Game.
     */
    @Test
    public void testGetTimer() {
        System.out.println("getTimer");
        Game instance = new Game();
        Timer expResult = null;
        Timer result = instance.getTimer();
        assertEquals(expResult, result);
    }

    /**
     * Test of getScore method, of class Game.
     */
    @Test
    public void testGetScore() {
        System.out.println("getScore");
        Game instance = new Game();
        int expResult = 0;
        int result = instance.getScore();
        assertEquals(expResult, result);
    }

    /**
     * Test of setScore method, of class Game.
     */
    @Test
    public void testSetScore() throws Exception {
       class AppTest extends Application
       {
            @Override
            public void start(Stage primaryStage) throws Exception {
                System.out.println("setScore");
                Game instance = new Game();
                Field f = new Field("Test","Test", instance);
                instance.addField(f);
                int points = 0;
                instance.setScore(points);

            }
        }
    }

    /**
     * Test of getOpenField method, of class Game.
     */
    @Test
    public void testGetOpenField() {
        System.out.println("getOpenField");
        Game instance = new Game();
        Field expResult = null;
        Field result = instance.getOpenField();
        assertEquals(expResult, result);
    }

    /**
     * Test of setOpenField method, of class Game.
     */
    @Test
    public void testSetOpenField() {
        System.out.println("setOpenField");
        Field openField = null;
        Game instance = new Game();
        instance.setOpenField(openField);
    }

    /**
     * Test of clearOpenField method, of class Game.
     */
    @Test
    public void testClearOpenField() {
        System.out.println("clearOpenField");
        Game instance = new Game();
        instance.clearOpenField();
    }

    /**
     * Test of addField method, of class Game.
     */
    @Test
    public void testAddField() {
        class AppTest extends Application
        {
            @Override
            public void start(Stage primaryStage) throws Exception {
                System.out.println("addField");
                Game instance = new Game();
                Field f = new Field("Test","Test", instance);
                instance.addField(f);

            }
        }
    }

    /**
     * Test of check method, of class Game.
     */
    @Test
    public void testCheck() {
        class AppTest extends Application
        {
            @Override
            public void start(Stage primaryStage) throws Exception {
                System.out.println("check");
                Game instance = new Game();
                Field f = new Field("Test","Test", instance);
                instance.addField(f);
                instance.check();
            }
        }
    }
    
}
