/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

/**
 *
 * @author ablo1
 */
public class DAOverificationTest {
    private DAOverification verif;
    public DAOverificationTest() throws SQLException, ClassNotFoundException {
        verif = new DAOverification("db_tdd", "root", "");
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
     * Test of verifValiditeID method, of class DAOverification.
     */
    @Test
    public void testVerifValiditeID() throws Exception {
        System.out.println("verifValiditeID");
        int id = 2;
        String table = "industrie";
        boolean result = verif.verifValiditeID(id, table);
        assertTrue(result);
    }

    /**
     * Test of verifDataInDB method, of class DAOverification.
     */
    @Test
    public void testVerifDataInDB() throws Exception {
        System.out.println("verifDataInDB");
        int id = 2;
        String table = "industrie";
        boolean result = verif.verifValiditeID(id, table);
        assertTrue(result);
    }
    
}
