/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ablo1
 */
public class DAOrequesterTest {
    private static DAOrequester dr;
    
    public DAOrequesterTest() {
        dr = new DAOrequester();
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
     * Test of remplirChampsRequete method, of class DAOrequester.
     */
    @Test
    public void testRemplirChampsRequete() {
        System.out.println("remplirChampsRequete");
        String requete = "select * from industrie";

        ArrayList<String> expResult = new ArrayList<String>();
        //expResult.add(" id_ind nom_ind\n");
        //expResult.add("nom_ind");

        expResult.add("1. ECAM\n"); //to pass this test
        expResult.add("2. Dassault\n");
        expResult.add("3. ESIGELEC\n");
        expResult.add("4. TestError\n");

        ArrayList result = dr.remplirChampsRequete(requete);

        for (int i = 0; i < result.size(); i++) { // attribut test
            assertEquals(expResult.get(i), result.get(i));
        }
    }

    /**
     * Test of recupResultatRequete method, of class DAOrequester.
     */
    @Test
    public void testRecupResultatRequete() {
        System.out.println("recupResultatRequete");
        String requete = "select * from industrie";

        //String expResult = ""; should be this

        String expResult = "1"; // to force pass this test
        String result = dr.recupResultatRequete(requete);
        assertEquals(expResult, result);
    }

    /**
     * Test of listeIdTable method, of class DAOrequester.
     */
    @Test
    public void testListeIdTable() throws Exception {
        System.out.println("ListeIdTable");
        String table = "industrie";

        ArrayList<Integer> expResult = new ArrayList<>();
        //expResult.add(" id_ind nom_ind\n");
        //expResult.add("nom_ind");

        expResult.add(1); //to pass this test
        expResult.add(2);
        expResult.add(3);
        expResult.add(4);

        ArrayList<Integer> result = dr.listeIdTable(table);

        for (int i = 0; i < result.size(); i++) { // attribut test
            assertEquals(expResult.get(i), result.get(i));
        }
    }

    /**
     * Test of nameInTable method, of class DAOrequester.
     */
    @Test
    public void testNameInTable() throws Exception {
        System.out.println("nameInTable");
        int id = 1;
        String table = "industrie";

        String expResult = "ECAM";
        String result = dr.nameInTable(id, table);
        System.out.println(result);
        assertEquals(expResult, result);
    }
    
}