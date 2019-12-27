package mock;

import daorefactoring.Dao;
import model.Employe;
import model.Industrie;
import model.Projet;

import java.sql.Connection;
import java.util.ArrayList;

public class ProjetDaoMock extends Dao<Projet> {

    private Industrie industrie1 = new Industrie(1, "Veolia");
    private Industrie industrie2 = new Industrie(2, "Google");

    private Projet projet1 = new Projet(1, "Symfony", industrie1);
    private Projet projet2 = new Projet(2, "Angular", industrie2);

    public ProjetDaoMock(Connection conn) {
        super(conn);
    }

    @Override
    public Projet find(int id) {
        return projet1;
    }

    @Override
    public ArrayList<Projet> findAll() {
        ArrayList<Projet> projetList = new ArrayList<Projet>();

        projetList.add(projet1);
        projetList.add(projet2);

        return projetList;
    }
}
