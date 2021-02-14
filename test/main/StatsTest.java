package main;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class StatsTest {
    
    public StatsTest() {
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
     * Test of getId method, of class Stats.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Stats instance = new Stats();
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setId method, of class Stats.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 1;
        Stats instance = new Stats();
        instance.setId(id);
        assertEquals(id, instance.getId());
    }

    /**
     * Test of getBestScoreEasy method, of class Stats.
     */
    @Test
    public void testGetBestScoreEasy() {
        System.out.println("getBestScoreEasy");
        Stats instance = new Stats();
        float expResult = 0.0F;
        float result = instance.getBestScoreEasy();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setBestScoreEasy method, of class Stats.
     */
    @Test
    public void testSetBestScoreEasy() {
        System.out.println("setBestScoreEasy");
        float bestScoreEasy = 0.0F;
        Stats instance = new Stats();
        instance.setBestScoreEasy(bestScoreEasy);
        assertEquals(bestScoreEasy, instance.getBestScoreEasy(), 0.0);
    }

    /**
     * Test of getBestScoreMed method, of class Stats.
     */
    @Test
    public void testGetBestScoreMed() {
        System.out.println("getBestScoreMed");
        Stats instance = new Stats();
        float expResult = 0.0F;
        float result = instance.getBestScoreMed();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setBestScoreMed method, of class Stats.
     */
    @Test
    public void testSetBestScoreMed() {
        System.out.println("setBestScoreMed");
        float bestScoreMed = 0.0F;
        Stats instance = new Stats();
        instance.setBestScoreMed(bestScoreMed);
        assertEquals(bestScoreMed, instance.getBestScoreMed(), 0.0);
    }

    /**
     * Test of getBestScoreHard method, of class Stats.
     */
    @Test
    public void testGetBestScoreHard() {
        System.out.println("getBestScoreHard");
        Stats instance = new Stats();
        float expResult = 0.0F;
        float result = instance.getBestScoreHard();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setBestScoreHard method, of class Stats.
     */
    @Test
    public void testSetBestScoreHard() {
        System.out.println("setBestScoreHard");
        float bestScoreHard = 0.0F;
        Stats instance = new Stats();
        instance.setBestScoreHard(bestScoreHard);
        assertEquals(bestScoreHard, instance.getBestScoreHard(), 0.0);
    }

    /**
     * Test of getGamesPlayedEasy method, of class Stats.
     */
    @Test
    public void testGetGamesPlayedEasy() {
        System.out.println("getGamesPlayedEasy");
        Stats instance = new Stats();
        int expResult = 0;
        int result = instance.getGamesPlayedEasy();
        assertEquals(expResult, result);
    }

    /**
     * Test of setGamesPlayedEasy method, of class Stats.
     */
    @Test
    public void testSetGamesPlayedEasy() {
        System.out.println("setGamesPlayedEasy");
        int gamesPlayedEasy = 0;
        Stats instance = new Stats();
        instance.setGamesPlayedEasy(gamesPlayedEasy);
        assertEquals(gamesPlayedEasy, instance.getGamesPlayedEasy());
    }

    /**
     * Test of getGamesPlayedMed method, of class Stats.
     */
    @Test
    public void testGetGamesPlayedMed() {
        System.out.println("getGamesPlayedMed");
        Stats instance = new Stats();
        int expResult = 0;
        int result = instance.getGamesPlayedMed();
        assertEquals(expResult, result);
    }

    /**
     * Test of setGamesPlayedMed method, of class Stats.
     */
    @Test
    public void testSetGamesPlayedMed() {
        System.out.println("setGamesPlayedMed");
        int gamesPlayedMed = 0;
        Stats instance = new Stats();
        instance.setGamesPlayedMed(gamesPlayedMed);
        assertEquals(gamesPlayedMed, instance.getGamesPlayedMed(), 0.0);
    }

    /**
     * Test of getGamesPlayedHard method, of class Stats.
     */
    @Test
    public void testGetGamesPlayedHard() {
        System.out.println("getGamesPlayedHard");
        Stats instance = new Stats();
        int expResult = 0;
        int result = instance.getGamesPlayedHard();
        assertEquals(expResult, result);
    }

    /**
     * Test of setGamesPlayedHard method, of class Stats.
     */
    @Test
    public void testSetGamesPlayedHard() {
        System.out.println("setGamesPlayedHard");
        int gamesPlayedHard = 0;
        Stats instance = new Stats();
        instance.setGamesPlayedHard(gamesPlayedHard);
        assertEquals(gamesPlayedHard, instance.getGamesPlayedHard(), 0.0);
    }

    /**
     * Test of saveStats method, of class Stats.
     */
    @Test
    public void testSaveStats() throws Exception {
        System.out.println("saveStats");
        Stats instance = new Stats();
        instance.saveStats();
    }
    
}
