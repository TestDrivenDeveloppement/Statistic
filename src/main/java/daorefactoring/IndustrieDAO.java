package daorefactoring;

import model.Industrie;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class IndustrieDAO extends Dao<Industrie>{

    public IndustrieDAO(Connection conn) {
        super(conn);
    }

    public Industrie find(int id) {
        Industrie industrie = new Industrie();

        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM industrie WHERE id_ind = " + id);
            if(result.first())
                industrie = new Industrie(
                        id,
                        result.getString("nom_ind"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return industrie;
    }
}
