package daorefactoring;

import model.Employe;
import model.Industrie;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeDAO extends Dao<Employe>{

    public EmployeDAO(Connection conn) {
        super(conn);
    }

    public Employe find(int id) {
        Employe employe = new Employe();

        try {
            ResultSet result = this.connect.createStatement()
                    .executeQuery("SELECT * FROM employe WHERE id_emp = "+ id
                            );

            if (result.next()){
                IndustrieDAO industrie = new IndustrieDAO(this.connect);
                employe = new Employe(id, result.getString("nom"),
                        result.getString("prenom"), result.getString("statut"),
                        result.getInt("nb_heure"), industrie.find(result.getInt("FK_id_ind")),
                        result.getString("sexe")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employe;
    }

    public ArrayList<Employe> findAll(){
        Employe employe;
        ArrayList<Employe> empList = new ArrayList<Employe>();

        try {
            ResultSet result = this.connect.createStatement()
                    .executeQuery("SELECT * FROM employe"
                    );

            while (result.next()){
                IndustrieDAO industrie = new IndustrieDAO(this.connect);
                employe = new Employe(result.getInt("id_emp"), result.getString("nom"),
                        result.getString("prenom"), result.getString("statut"),
                        result.getInt("nb_heure"), industrie.find(result.getInt("FK_id_ind")),
                        result.getString("sexe")
                );
                empList.add(employe);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return empList;
    }
}
