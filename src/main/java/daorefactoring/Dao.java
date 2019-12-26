package daorefactoring;

import java.sql.Connection;

public abstract class Dao<T> {

    protected Connection connect = null;

    public Dao(Connection conn){
        this.connect = conn;
    }

    /**
     * Méthode de recherche des informations
     * @param id
     * @return T
     */
    public abstract T find(int id);
}
