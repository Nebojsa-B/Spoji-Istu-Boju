package main;

import java.sql.ResultSet;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class DBTest {
    
    public DBTest() {
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
     * Test of execute method, of class DB.
     */
    @Test
    public void testExecute() throws Exception {
        System.out.println("execute");
        String sql = "UPDATE korisnik SET idKorisnika = 1 WHERE idKorisnika = 1";
        DB instance = new DB();
        instance.execute(sql);
    }

    /**
     * Test of query method, of class DB.
     */
    @Test
    public void testQuery() throws Exception {
        System.out.println("query");
        String sql = "SELECT * FROM korisnik";
        DB instance = new DB();
        ResultSet result = instance.query(sql);
    }

    /**
     * Test of close method, of class DB.
     */
    @Test
    public void testClose() throws Exception {
        System.out.println("close");
        DB instance = new DB();
        instance.close();
    }
    
}
