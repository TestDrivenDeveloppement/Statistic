package dao;
import static org.junit.jupiter.api.Assertions.*;

import dao.DAOrequester;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.function.BooleanSupplier;

class DAOconnexionTest {

    void innitConn() throws SQLException {
        Connection conne=DriverManager.getConnection("db_tdd", "root", "");
        Statement stmte=conne.createStatement();
        assertTrue((BooleanSupplier) stmte);
    }
    void closeConn() {
    }
}