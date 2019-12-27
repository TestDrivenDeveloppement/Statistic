package mock;

import daorefactoring.Dao;
import model.Employe;
import model.Industrie;
import model.Intermediaire;
import model.Projet;

import java.sql.Connection;
import java.util.ArrayList;

public class IntermediaireDaoMock extends Dao<Intermediaire> {

    private Industrie industrie1 = new Industrie(1, "Veolia");
    private Industrie industrie2 = new Industrie(2, "Google");
    private Industrie industrie3 = new Industrie(3, "Facebook");

    private Employe employe1 = new Employe(1, "Louis", "Rudy",
            "Cadre", 355, industrie1, "M" );

    private Employe employe2 = new Employe(2, "Alex", "Koolwx",
            "Cadre", 200, industrie3, "M" );

    private Employe employe3 = new Employe(3, "Michelle", "Laura",
            "Stagiaire", 255, industrie1, "F" );

    private Projet projet1 = new Projet(1, "Symfony", industrie1);

    private Intermediaire intermediaire1 = new Intermediaire(1, employe1, projet1);
    private Intermediaire intermediaire2 = new Intermediaire(2, employe3, projet1);

    public IntermediaireDaoMock(Connection conn) {
        super(conn);
    }

    @Override
    public Intermediaire find(int id) {
        return intermediaire1;
    }

    @Override
    public ArrayList<Intermediaire> findAll() {
        ArrayList<Intermediaire> intermediaireList = new ArrayList<Intermediaire>();

        intermediaireList.add(intermediaire1);
        intermediaireList.add(intermediaire2);

        return intermediaireList;
    }
}
