package Factory;

import daorefactoring.Dao;
import model.Employe;
import model.Industrie;
import model.Intermediaire;
import model.Projet;

public abstract class AbstractDAOFactory
{

    public static final int DAO_FACTORY = 0;
    public static final int XML_DAO_FACTORY = 1;

    //Retourne un objet Industrie interagissant avec la BDD
    public abstract Dao<Industrie> getIndustrieDao();

    //Retourne un objet Employe interagissant avec la BDD
    public abstract Dao<Employe> getEmployeDao();

    //Retourne un objet Intermediaire interagissant avec la BDD
    public abstract Dao<Intermediaire> getIntermediaireDao();

    //Retourne un objet Projet interagissant avec la BDD
    public abstract Dao<Projet> getProjetDao();

    //Méthode permettant de récupérer les Factory
    public static AbstractDAOFactory getFactory(int type)
    {
        switch(type)
        {
            case DAO_FACTORY:
                return new DaoFactory();

            case XML_DAO_FACTORY:
                return new XMLDAOFactory();

            default:
                return null;
        }
    }
}
