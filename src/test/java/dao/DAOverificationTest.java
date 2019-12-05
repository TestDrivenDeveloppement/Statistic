/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import org.dbunit.DBTestCase;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.database.DatabaseDataSourceConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.dbunit.dataset.ReplacementDataSet;
import org.dbunit.operation.DatabaseOperation;

import javax.naming.InitialContext;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.Assert.*;

/**
 *
 * @author ablo1
 */
public class DAOverificationTest extends DBTestCase {
    private static DAOverification verif;
    public DAOverificationTest(String name){
        super(name);

        try {
            Class.forName("cdata.jdbc.xml.XMLDriver");
            /*System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS, "com.mysql.jdbc.Driver" );
            System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL, "jdbc:mysql://localhost/db_tdd" );
            System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME, "root" );
            System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD, "" );
            // System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_SCHEMA, "" );*/

            Connection conn = DriverManager.getConnection("jdbc:xml:DataModel=Relational;URI=C:\\db_tdd_test.xml");
            verif = new DAOverification();
            verif.setStmt(conn.createStatement());

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    protected IDataSet getDataSet() throws Exception
    {
        return new FlatXmlDataSetBuilder().build(new FileInputStream("src/test/java/db/db_tdd_test.xml"));
    }

    @BeforeClass
    public void setUpClass(){

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
    public void testVerifValiditeID(){
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
    public void testVerifDataInDB(){
        System.out.println("verifDataInDB");
        int id = 2;
        String table = "industrie";
        boolean result = verif.verifValiditeID(id, table);
        assertTrue(result);
    }
    
}
