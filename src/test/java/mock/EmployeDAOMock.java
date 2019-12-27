package mock;

import daorefactoring.Dao;
import model.Employe;
import model.Industrie;

import java.sql.Connection;
import java.util.ArrayList;

public class EmployeDAOMock extends Dao<Employe> {

    private Industrie industrie1 = new Industrie(1, "Veolia");
    private Industrie industrie2 = new Industrie(2, "Google");
    private Industrie industrie3 = new Industrie(3, "Facebook");

    private Employe employe1 = new Employe(1, "Louis", "Rudy",
            "Cadre", 300, industrie1, "M" );

    private Employe employe2 = new Employe(2, "Alex", "Koolwx",
            "Cadre", 155, industrie3, "M" );

    private Employe employe3 = new Employe(3, "Michelle", "Laura",
            "Stagiaire", 250, industrie1, "F" );

    private Employe employe4 = new Employe(4, "Solange", "Sara",
            "Employe", 450, industrie3, "F" );

    private Employe employe5 = new Employe(2, "Romaric", "Didier",
            "Stagiaire", 350, industrie2, "M" );

    public EmployeDAOMock(Connection conn) {
        super(conn);
    }

    @Override
    public Employe find(int id){
        return employe1;
    }

    @Override
    public ArrayList<Employe> findAll(){
        ArrayList<Employe> employeList = new ArrayList<Employe>();

        employeList.add(employe1);
        employeList.add(employe2);
        employeList.add(employe3);
        employeList.add(employe4);
        employeList.add(employe5);

        return employeList;
    }

}
