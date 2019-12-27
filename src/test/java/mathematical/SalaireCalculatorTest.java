/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mathematical;

import java.util.ArrayList;

import daorefactoring.Dao;
import mock.EmployeDAOMock;
import model.Employe;
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
public class SalaireCalculatorTest {

    private static SalaireCalculator sctest;
    private static Dao<Employe> empDaotest =  new EmployeDAOMock(null);
    private static ArrayList<Employe> employeListest;

    public SalaireCalculatorTest() {
        sctest = new SalaireCalculator();
    }

    @BeforeClass
    public static void setUpClass() {
        employeListest = empDaotest.findAll();
    }

    @AfterClass
    public static void tearDownClass() {
        employeListest.clear();
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of primeEmp method, of class SalaireCalculator.
     */
    @Test
    public void testPrimeEmp() {
        System.out.println("primeEmp");
        String expResult = "Louis Rudy ---> Prime: 855.9375000000001€/mois\nAlex Koolwx ---> Prime: 0.0€/mois\n" +
                "Michelle Laura ---> Prime: 351.5625€/mois\nSolange Sara ---> Prime: 2478.125€/mois\n" +
                "Romaric Didier ---> Prime: 820.3125€/mois\n";
        String result = sctest.primeEmp(employeListest);
        assertEquals(expResult, result);
    }

    /**
     * Test of salaireAllEmp method, of class SalaireCalculator.
     */
    @Test
    public void testSalaireAllEmp() {
        System.out.println("salaireAllEmp");
        String expResult = "Louis Rudy ---> Salaire: 2739.0000000000005€/mois\n" +
                "Alex Koolwx ---> Salaire: 1415.15€/mois\n" +
                "Michelle Laura ---> Salaire: 937.5€/mois\n" +
                "Solange Sara ---> Salaire: 3568.5€/mois\n" +
                "Romaric Didier ---> Salaire: 1312.5€/mois\n";
        String result = sctest.salaireAllEmp(employeListest);
        assertEquals(expResult, result);
    }

    /**
     * Test of salaireOneEmp method, of class SalaireCalculator.
     */
    @Test
    public void testSalaireOneEmp() {
        System.out.println("salaireOneEmp");
        double expResult = 1415.15;
        double result = sctest.salaireOneEmp(empDaotest.find(2));
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of salaireMoyInd method, of class SalaireCalculator.
     */
    @Test
    public void testSalaireMoyInd() {
        System.out.println("salaireMoyInd");
        double expResult = 1312.5;
        double result = sctest.salaireMoyInd(2, employeListest);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of salaireMoyIndGenre method, of class SalaireCalculator.
     */
    @Test
    public void testSalaireMoyIndGenre() {
        System.out.println("salaireMoyIndGenre");

        double expResult = 1415.15;
        double result = sctest.salaireMoyIndGenre(3, "M", employeListest);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of salaireMoyAutreIndGenre method, of class SalaireCalculator.
     */
    @Test
    public void testSalaireMoyAutreIndGenre() {
        System.out.println("salaireMoyAutreIndGenre");

        double expResult = 1687.5;
        double result = sctest.salaireMoyAutreIndGenre(2, "Employe", employeListest);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of superSatInd method, of class SalaireCalculator.
     */
    @Test
    public void testSuperSatInd() {
        System.out.println("superSatInd");

        String expResult = "Votre entreprise compte : 2.0 employes\n" +
                "Parmis ces employes, vous comptez 1.0 hommes (50.0%) et 1.0 femmes (50.0%)\n" +
                "\t ........................... \t\n" +
                "Salaire moyen au sein de l'entreprise :1838.2500000000002\n" +
                "Salaire par statut : \n" +
                " 1. Stagiaire : 937.5 euros \n" +
                " \t => Un stagiaire touche en moyenne 71.42857% que dans une autre entreprise \n" +
                " 2. Employe :NaN euros \n" +
                " \t => Un employe touche en moyenne NaN% que dans une autre entreprise \n" +
                " 3. Cadre : 1125.0 euros \n" +
                " \t => Un cadre touche en moyenne 193.54839% que dans une autre entreprise\n";
        String result = sctest.superSatInd(1, employeListest);
        assertEquals(expResult, result);

    }

    /**
     * Test of nombreEmpGenreInd method, of class SalaireCalculator.
     */
    @Test
    public void testNombreEmpGenreInd() {
        System.out.println("nombreEmpGenreInd");

        int expResult = 1;
        int result = sctest.nombreEmpGenreInd(1, "M", employeListest);
        assertEquals(expResult, result);
    }
    
}
