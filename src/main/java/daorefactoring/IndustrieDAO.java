package daorefactoring;

import model.Industrie;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class IndustrieDAO extends Dao<Industrie>{

    public IndustrieDAO(Connection conn) {
        super(conn);
    }

    public Industrie find(int id) {
        Industrie industrie = new Industrie();

        try {
            ResultSet result = this.connect.createStatement()
                    .executeQuery("SELECT * FROM industrie WHERE id_ind = " + id);

            if(result.next()){
                industrie = new Industrie(id, result.getString("nom_ind"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return industrie;
    }

    public ArrayList<Industrie> findAll(){
        Industrie industrie;
        ArrayList<Industrie> indList = new ArrayList<Industrie>();

        try {
            ResultSet result = this.connect.createStatement().executeQuery("SELECT * FROM industrie");
            while (result.next()){ // tant que y a des elements
                industrie = new Industrie(
                        result.getInt("id_ind"),
                        result.getString("nom_ind"));
                indList.add(industrie);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return indList;
    }
}
