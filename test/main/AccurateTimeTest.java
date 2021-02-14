package main;

import forms.RegisterForma;
import game.Game;
import game.Timer;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class AccurateTimeTest {
    
    public AccurateTimeTest() {
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

    @Test
    public void testRun() throws IOException, InterruptedException {
        System.out.println("run");
        
        class AppTest extends Application
        {
            @Override
            public void start(Stage primaryStage) throws Exception {
                        System.out.println("end");
                        Label n = new Label();
                        AccurateTime instance = new AccurateTime(new Game(), 1);
                        instance.run();
            }
        }
        
        AppTest n = new AppTest();
    }
    
}
