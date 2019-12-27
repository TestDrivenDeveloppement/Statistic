package menuPrincipal;

import dao.DAOconnexion;
import daorefactoring.Dao;
import daorefactoring.EmployeDAO;
import daorefactoring.IndustrieDAO;
import daorefactoring.IntermediaireDAO;
import mathematical.MathematicalStatsCalculator;
import mathematical.SalaireCalculator;
import model.Employe;
import model.Industrie;
import model.Intermediaire;

import java.util.ArrayList;
import java.util.Scanner;

public class StatFacade {

    private Scanner scan;
    private MathematicalStatsCalculator msc;
    private SalaireCalculator sc;

    private Dao<Employe> employeDao = new EmployeDAO(DAOconnexion.getInstance());
    private Dao<Intermediaire> intermediaireDao = new IntermediaireDAO(DAOconnexion.getInstance());

    public StatFacade(){
        this.msc = new MathematicalStatsCalculator();
        this.sc = new SalaireCalculator();
        this.scan = new Scanner(System.in);
    }

    public int start(){

        int menuChoice;
        System.out.println("\n \t Menu"
                + "\n 1. Voir les données des employés d'une entreprise"
                + "\n 2. Voir les données des employés pour un projet"
                + "\n 3. Voir les informations sur le salaire"
                + "\n 4. Comparer les entreprises selon des caractères précis"
                +" \n 5. Obtenir des statistiques avancés sur votre entreprise ou projet"
                +" \n 6. Quitter l'application\n");
        System.out.print("Votre choix: ");
        menuChoice=scan.nextInt();
        return menuChoice;
    }

    public void menuDataEmpInd(){
        System.out.println("Sélectionnez l'entreprise souhaitée (entrez l'id):\n");

        Dao.afficheTable("Industrie");//Afficher la liste des industries

        int indChoice = scan.nextInt();

        System.out.println("\n Moyenne d'heure des employés pour l'entreprise :"
                + msc.getMoyHeureEmpInd(indChoice, employeDao.findAll()));

        System.out.println("\n Somme d'heure des employés pour l'entreprise : "+
                msc.getSomHeureEmpInd(indChoice, employeDao.findAll()));

        System.out.println("\n Variance d'heure des employés pour l'entreprise :"+
                msc.getVarianceHeureEmpInd(indChoice, employeDao.findAll()));

        System.out.println("\n Ecart-Type d'heure des employés pour l'entreprise : "+
                msc.getEcartTypeHeureEmpInd(indChoice, employeDao.findAll()));

    }

    public void menuDataEmpPro(){
        System.out.println("Séléctionnez le projet souhaité (entrez l'id) ");

        Dao.afficheTable("Projet"); //Afficher la liste des projets

        int proChoice = scan.nextInt();

        System.out.println("\n Moyenne d'heure des employés pour le projet :"+
                msc.getMoyHeureEmpPro(proChoice, intermediaireDao.findAll()));

        System.out.println("\n Somme d'heure des employés pour le projet : "+
                msc.getSomHeureEmpPro(proChoice, intermediaireDao.findAll()));

        System.out.println("\n Variance d'heure des employés pour le projet :"+
                msc.getVarianceHeureEmpPro(proChoice, intermediaireDao.findAll()));

        System.out.println("\n Ecart-Type d'heure des employés pour le projet : "+
                msc.getEcartTypeHeureEmpPro(proChoice, intermediaireDao.findAll()));



    }

    public int menuSalaire(){
        int menuSalaireChoice;

        System.out.println("1. Retour au menu principal");
        System.out.println("2. Calcul des primes par employé");
        System.out.println("3. Salaire mensuel moyen par entreprise");
        System.out.println("4. Salaire mensuel moyen par sexe");
        System.out.println("5. Salaire mensuel moyen par statut");
        System.out.println("6. Salaire par employé\n");
        System.out.print("Votre choix: ");

        menuSalaireChoice = scan.nextInt();
        return menuSalaireChoice;
    }

    public void primeEmp(){
        sc.primeEmp();
    }

    public void salaireMenInd(){
        Dao.afficheTable("industrie");

        System.out.print("Saisissez l'Id de l'entreprise: ");
        int indChoice = scan.nextInt();

        double result_moy = sc.salaireMoyInd(indChoice);
        System.out.println("\nLe salaire mensuel moyen de l'entreprise est de: " + result_moy + "€\n");

    }


    public int menuSalaireSexe(){
        int sexeChoice;
        System.out.println("1. Masculin");
        System.out.println("2. Féminin\n");
        System.out.print("Votre choix: ");

        sexeChoice = scan.nextInt();

        return sexeChoice;
    }

    public void salaireSexeInd(int sexe){

        Dao.afficheTable("industrie");
        System.out.print("Saisissez l'Id de l'entreprise: ");

        int indChoice = scan.nextInt();

        switch(sexe){
            case 1:
                double result_masculin = sc.salaireMoyIndGenre(indChoice, "M");

                System.out.println("Le salaire mensuel moyen de l'entreprise pour un homme est de: " +
                        result_masculin + "€\n");
                break;
            case 2:
                double result_feminin = sc.salaireMoyIndGenre(indChoice, "F");

                System.out.println("Le salaire mensuel moyen de l'entreprise pour une femme est de: " +
                            result_feminin + "€\n");
                break;

            default :
                System.out.println("Ce choix n'exite pas");
                break;
        }
    }

    public int menuSalaireStatus(){
        int statusChoice;

        System.out.println("1. Cadre");
        System.out.println("2. Employe");
        System.out.println("3. Stagiaire\n");
        System.out.print("Votre choix: ");

        statusChoice = scan.nextInt();

        return statusChoice;
    }

    public void salaireStatusInd(int status){

        Dao.afficheTable("industrie");
        System.out.print("Saisissez l'Id de l'entreprise: ");

        int indChoice = scan.nextInt();

        switch(status){
            case 1:
                double result_cadre = sc.salaireMoyIndGenre(indChoice, "Cadre");

                System.out.println("Le salaire mensuel moyen de l'entreprise pour un cadre est de: " +
                        result_cadre + "€\n");
                break;
            case 2:
                double result_emp = sc.salaireMoyIndGenre(indChoice, "Employe");

                System.out.println("Le salaire mensuel moyen de l'entreprise pour un employé est de: " +
                        result_emp + "€\n");
                break;
            case 3:
                double result_stagiaire = sc.salaireMoyIndGenre(indChoice, "Stagiaire");

                System.out.println("Le salaire mensuel moyen de l'entreprise pour un stagiaire est de: " +
                        result_stagiaire + "€\n");
                break;
        }
    }

    public int menuSalaireEmp(){
        int choice;

        System.out.println("1. Salaire de tous les employés");
        System.out.println("2. Salaire d'un seul employé\n");
        System.out.print("Votre choix: ");

        choice = scan.nextInt();

        return choice;
    }

    public void salaireEmp(int emp){

        switch(emp){
            case 1:
                sc.salaireAllEmp();
                break;

            case 2:
                Dao.afficheTable("employe");

                System.out.print("\nSaisissez l'id de l'employé: ");

                int idEmp = scan.nextInt(); // choix employe

                double result = sc.salaireOneEmp(idEmp);
                System.out.println("Salaire: " + result + " €/mois");
                break;
        }
    }

    public int menuComparison(){
        int choice;

        System.out.println("\n Comparer les différences de salaire selon :"
                + "\n 1. Le statut dans l'entreprise"
                + "\n 2. Le genre des employés"
                + "\n 3. Back");

        choice = scan.nextInt();

        return choice;
    }


    public void menuCompStatut(){
        System.out.println("Veuillez entrer le numéro du statut dont vous souhaitez faire la comparaison :"
                + "\n 1. Stagiaire"
                + "\n 2. Employe"
                + "\n 3. Cadre");

        System.out.println("Comparaison des salaires selon le statut :");

        Dao<Industrie> industrieDao = new IndustrieDAO(DAOconnexion.getInstance());

        ArrayList<Industrie> industrieList = industrieDao.findAll();

        switch(new Scanner(System.in).nextInt()) {

            case 1:
                for (Industrie industrie : industrieList) {
                    System.out.println("L'entreprise : " + industrie.getNom_ind() +
                            " offre comme salaire moyen a ses stagiaires : " +
                            sc.salaireMoyIndGenre(industrie.getId_ind(), "Stagiaire") + " euros");
                }
                break;

            case 2:
                for (Industrie industrie : industrieList) {
                    System.out.println("L'entreprise : " + industrie.getNom_ind() +
                            " offre comme salaire moyen a ses employes : " +
                            sc.salaireMoyIndGenre(industrie.getId_ind(), "Employe") + " euros");
                }
                break;

            case 3:
                for (Industrie industrie : industrieList) {
                    System.out.println("L'entreprise : " + industrie.getNom_ind() +
                            " offre comme salaire moyen a ses cadres : " +
                            sc.salaireMoyIndGenre(industrie.getId_ind(), "Cadre") + " euros");
                }
                break;

            default :
                break;
        }
    }


    public void menuCompGenre(){
        System.out.println("Sélectionnez le genre dont vous souhaitez comparer les salaires entre entreprises :"
                + "\n 1. Hommes"
                + "\n 2. Femmes");

        System.out.println("Comparaison des salaires selon le genre :");

        Dao<Industrie> industrieDao = new IndustrieDAO(DAOconnexion.getInstance());

        ArrayList<Industrie> industrieList = industrieDao.findAll();
        switch(new Scanner(System.in).nextInt()) {

            case 1:

                for (Industrie industrie : industrieList) {
                    System.out.println("L'entreprise : " + industrie.getNom_ind() +
                            " offre comme salaire moyen a ses hommes : " +
                            sc.salaireMoyIndGenre(industrie.getId_ind(), "M") + " euros");
                }
                break;

            case 2:
                for (Industrie industrie : industrieList) {
                    System.out.println("L'entreprise : " + industrie.getNom_ind() +
                            " offre comme salaire moyen a ses femmes : " +
                            sc.salaireMoyIndGenre(industrie.getId_ind(), "F") + " euros");
                }
                break;

            default:
                break;
        }
    }

    public void statAvance(){
        System.out.println("Voulez-vous des statistiques avancées sur votre entreprise ou votre projet ?"
                + "\n1. Entreprise."
                + "\n2. Projet.");

        switch(new Scanner(System.in).nextInt()) {

            case 1:

                System.out.println("Veuillez sélectionnez votre entreprise :");

                Dao.afficheTable("industrie");

                sc.superSatInd(new Scanner(System.in).nextInt());

                break;

            case 2 :
                System.out.println("Non disponible");
                break;

            default:
                break;

        }
    }

}
