package dao;
import static org.junit.jupiter.api.Assertions.*;

import dao.DAOrequester;
import org.dbunit.DatabaseUnitException;
import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.ext.mysql.MySqlConnection;
import org.dbunit.ext.mysql.MySqlConnection;
import org.dbunit.JdbcDatabaseTester;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.function.BooleanSupplier;

class DAOconnexionTest {

    void innitConn() throws Exception {
       // Connection conne=DriverManager.getConnection("db_tdd", "root", "");
        //Statement stmte=conne.createStatement();
        //assertTrue((BooleanSupplier) stmte);

       // Connection jdbcConnection = DriverManager.getConnection(
        //    "jdbc:mysql://localhost:3306/db_tdd", "root", "");
        //IDatabaseConnection connection = new MySqlConnection(jdbcConnection, null);

        IDatabaseTester databaseTester;
        databaseTester = new JdbcDatabaseTester("com.mysql.jdbc.Driver","jdbc:mysql://localhost/db_tdd","root", "");
        IDataSet dataSet = new FlatXmlDataSetBuilder().build(new FileInputStream("../db_tdd.xml"));
        databaseTester.setDataSet(dataSet);
        databaseTester.onSetup();
    }


    void closeConn() {
    }
}