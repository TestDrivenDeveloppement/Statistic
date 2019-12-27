/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mathematical;

import java.util.ArrayList;

import daorefactoring.Dao;
import daorefactoring.IntermediaireDAO;
import mock.EmployeDAOMock;
import mock.IntermediaireDaoMock;
import model.Employe;
import model.Intermediaire;
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
public class MathematicalStatsCalculatorTest {
    private static MathematicalStatsCalculator msctest;
    private static Dao<Employe> empDaotest =  new EmployeDAOMock(null);
    private static Dao<Intermediaire> intermediaireDaotest = new IntermediaireDaoMock(null);
    private static ArrayList<Employe> employeListest;
    private static ArrayList<Intermediaire> intermediaireListest;

    public MathematicalStatsCalculatorTest() {
        msctest = new MathematicalStatsCalculator();
    }
    
    @BeforeClass
    public static void setUpClass() {
        intermediaireListest  = intermediaireDaotest.findAll();
        employeListest = empDaotest.findAll();
    }
    
    @AfterClass
    public static void tearDownClass() {
        employeListest.clear();
        intermediaireListest.clear();
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getSomHeureEmpInd method, of class MathematicalStatsCalculator.
     */
    @Test
    public void testGetSomHeureEmpInd() {
        System.out.println("getSomHeureEmpInd");
        int idIndustrie = 1;
        int expResult = 550;
        int result = msctest.getSomHeureEmpInd(idIndustrie, employeListest);
        assertEquals(expResult, result);
    }

    /**
     * Test of getSomHeureEmpPro method, of class MathematicalStatsCalculator.
     */
    @Test
    public void testGetSomHeureEmpPro() {
        System.out.println("getSomHeureEmpPro");
        int idIndustrie = 1;
        int expResult = 610;
        int result = msctest.getSomHeureEmpPro(idIndustrie, intermediaireListest);
        assertEquals(expResult, result);
    }

    /**
     * Test of getMoyHeureEmpInd method, of class MathematicalStatsCalculator.
     */
    @Test
    public void testGetMoyHeureEmpInd() {
        System.out.println("getMoyHeureEmpInd");
        int idIndustrie = 1;
        int expResult = 275;
        int result = (int)msctest.getMoyHeureEmpInd(idIndustrie, employeListest);
        assertEquals(expResult, result);
    }

    /**
     * Test of getMoyHeureEmpPro method, of class MathematicalStatsCalculator.
     */
    @Test
    public void testGetMoyHeureEmpPro() {
        System.out.println("getMoyHeureEmpPro");
        int idIndustrie = 1;
        int expResult = 305;
        int result = (int)msctest.getMoyHeureEmpPro(idIndustrie, intermediaireListest);
        assertEquals(expResult, result);
    }

    /**
     * Test of getVarianceHeureEmpInd method, of class MathematicalStatsCalculator.
     */
    @Test
    public void testGetVarianceHeureEmpInd() {
        System.out.println("getVarianceHeureEmpInd");
        int idIndustrie = 1;
        int expResult = 625;
        int result = (int)msctest.getVarianceHeureEmpInd(idIndustrie, employeListest);
        assertEquals(expResult, result);
    }

    /**
     * Test of getVarianceHeureEmpPro method, of class MathematicalStatsCalculator.
     */
    @Test
    public void testGetVarianceHeureEmpPro() {
        System.out.println("getVarianceHeureEmpPro");
        int idIndustrie = 1;
        int expResult = 2500;
        int result = (int)msctest.getVarianceHeureEmpPro(idIndustrie, intermediaireListest);
        assertEquals(expResult, result);
    }

    /**
     * Test of getEcartTypeHeureEmpInd method, of class MathematicalStatsCalculator.
     */
    @Test
    public void testGetEcartTypeHeureEmpInd() {
        System.out.println("getEcartTypeHeureEmpInd");
        int idIndustrie = 1;
        int expResult = 25;
        int result = (int)msctest.getEcartTypeHeureEmpInd(idIndustrie, employeListest);
        assertEquals(expResult, result);
    }

    /**
     * Test of getEcartTypeHeureEmpPro method, of class MathematicalStatsCalculator.
     */
    @Test
    public void testGetEcartTypeHeureEmpPro() {
        System.out.println("getEcartTypeHeureEmpPro");
        int idIndustrie = 1;
        int expResult = 50;
        int result = (int)msctest.getEcartTypeHeureEmpPro(idIndustrie, intermediaireListest);
        assertEquals(expResult, result);
    }
    
}
