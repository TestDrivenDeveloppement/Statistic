package Factory;

import daorefactoring.*;
import model.Employe;
import model.Industrie;
import model.Intermediaire;
import model.Projet;

public class XMLDAOFactory extends AbstractDAOFactory
{

    //Retourne un objet Industrie interagissant avec la BDD
    public Dao<Industrie> getIndustrieDao()
    {
        return null;
    }

    //Retourne un objet Employe interagissant avec la BDD
    public Dao<Employe> getEmployeDao()
    {
        return null;
    }

    //Retourne un objet Intermediaire interagissant avec la BDD
    public Dao<Intermediaire> getIntermediaireDao()
    {
        return null;
    }

    //Retourne un objet Projet interagissant avec la BDD
    public Dao<Projet> getProjetDao()
    {
        return null;
    }
}
