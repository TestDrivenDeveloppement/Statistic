package daorefactoring;

import model.Intermediaire;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class IntermediaireDAO extends Dao<Intermediaire> {

    public IntermediaireDAO(Connection conn) {
        super(conn);
    }

    public Intermediaire find(int id) {
        Intermediaire intermediaire = new Intermediaire();

        try {
            ResultSet result = this.connect.createStatement()
                    .executeQuery("SELECT * FROM intermediaire WHERE id = "+ id
                    );

            if (result.next()){
                ProjetDAO projet = new ProjetDAO(this.connect);
                EmployeDAO employe = new EmployeDAO(this.connect);

                intermediaire = new Intermediaire(id, employe.find(result.getInt("FK_id_emp")),
                        projet.find(result.getInt("FK_id_projet"))
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return intermediaire;
    }

    public ArrayList<Intermediaire> findAll(){
        Intermediaire intermediaire;
        ArrayList<Intermediaire> interList = new ArrayList<Intermediaire>();

        try {
            ResultSet result = this.connect.createStatement()
                    .executeQuery("SELECT * FROM intermediaire"
                    );

            while (result.next()){
                ProjetDAO projet = new ProjetDAO(this.connect);
                EmployeDAO employe = new EmployeDAO(this.connect);

                intermediaire = new Intermediaire(result.getInt("id"),
                        employe.find(result.getInt("FK_id_emp")),
                        projet.find(result.getInt("FK_id_projet"))
                );
                interList.add(intermediaire);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return interList;
    }
}
