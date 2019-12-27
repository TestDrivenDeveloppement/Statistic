package mock;

import daorefactoring.Dao;
import model.Industrie;

import java.sql.Connection;
import java.util.ArrayList;

public class IndustrieDaoMock extends Dao<Industrie> {

    private Industrie industrie1 = new Industrie(1, "Veolia");
    private Industrie industrie2 = new Industrie(2, "Google");
    private Industrie industrie3 = new Industrie(3, "Facebook");

    public IndustrieDaoMock(Connection conn) {
        super(conn);
    }

    @Override
    public Industrie find(int id){
        return industrie1;
    }

    @Override
    public ArrayList<Industrie> findAll(){
        ArrayList<Industrie> industrieList = new ArrayList<Industrie>();

        industrieList.add(industrie1);
        industrieList.add(industrie2);
        industrieList.add(industrie3);

        return industrieList;
    }
}
