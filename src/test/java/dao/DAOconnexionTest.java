package dao;
import static org.junit.jupiter.api.Assertions.*;

import dao.DAOrequester;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class DAOconnexionTest {

    void innitConn() throws SQLException {
        Connection conne=DriverManager.getConnection("db_tdd", "root", "");
        stmte = conne.createStatement();
        assertTrue(stmte);
    }
    void closeConn() {
    }
}