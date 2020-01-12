package Factory;

import dao.DAOconnexion;
import daorefactoring.*;
import model.Employe;
import model.Industrie;
import model.Intermediaire;
import model.Projet;

import java.sql.Connection;

public class DaoFactory extends AbstractDAOFactory
{
    protected static final Connection CONN = DAOconnexion.getInstance();

    //Retourne un objet Industrie interagissant avec la BDD
    public Dao<Industrie> getIndustrieDao()
    {
        return new IndustrieDAO(CONN);
    }

    //Retourne un objet Employe interagissant avec la BDD
    public Dao<Employe> getEmployeDao()
    {
        return new EmployeDAO(CONN);
    }

    //Retourne un objet Intermediaire interagissant avec la BDD
    public Dao<Intermediaire> getIntermediaireDao()
    {
        return  new IntermediaireDAO(CONN);
    }

    //Retourne un objet Projet interagissant avec la BDD
    public Dao<Projet> getProjetDao()
    {
        return new ProjetDAO(CONN);
    }
}
