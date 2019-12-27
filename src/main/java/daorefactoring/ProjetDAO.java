package daorefactoring;

import model.Employe;
import model.Projet;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProjetDAO extends Dao<Projet> {

    public ProjetDAO(Connection conn) {
        super(conn);
    }

    public Projet find(int id) {
        Projet projet = new Projet();

        try {
            ResultSet result = this.connect.createStatement()
                    .executeQuery("SELECT * FROM projet WHERE id_projet = "+ id
                    );

            if (result.next()){
                IndustrieDAO industrie = new IndustrieDAO(this.connect);
                projet = new Projet(id, result.getString("nom_projet"),
                        industrie.find(result.getInt("FK_id_ind"))
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return projet;
    }

    public ArrayList<Projet> findAll(){
        Projet projet;
        ArrayList<Projet> proList = new ArrayList<Projet>();

        try {
            ResultSet result = this.connect.createStatement()
                    .executeQuery("SELECT * FROM projet"
                    );

            while (result.next()){
                IndustrieDAO industrie = new IndustrieDAO(this.connect);
                projet = new Projet(result.getInt("id_projet"),
                        result.getString("nom_projet"),
                        industrie.find(result.getInt("FK_id_ind"))
                );
                proList.add(projet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return proList;
    }
}
