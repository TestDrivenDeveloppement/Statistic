package menuPrincipal;

import dao.DAOrequester;
import dao.DAOverification;
import mathematical.MathematicalStatsCalculator;
import mathematical.SalaireCalculator;

import java.util.ArrayList;
import java.util.Scanner;

public class StatFacade {

    private Scanner scan;
    private MathematicalStatsCalculator msc;
    private SalaireCalculator sc;
    private DAOverification verif;

    public StatFacade(){
        this.msc = new MathematicalStatsCalculator();
        this.verif = new DAOverification();
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

        DAOrequester.afficherLignes("Industrie");//Afficher la liste des industries

        int indChoice = scan.nextInt();

        //On vérifie que l'ID est bien présent dans la table
        if (verif.verifValiditeID(indChoice, "industrie") && verif.verifDataInDB(indChoice, "industrie")){

            System.out.println("\n Moyenne d'heure des employés pour l'entreprise :"
                    + msc.getMoyenneHeureEmployeEntreprise(indChoice));

            System.out.println("\n Somme d'heure des employés pour l'entreprise : "+
                    msc.getSommeHeureEmployeEntreprise(indChoice));

            System.out.println("\n Variance d'heure des employés pour l'entreprise :"+
                    msc.getVarianceHeureEmployeEntreprise(indChoice));

            System.out.println("\n Ecart-Type d'heure des employés pour l'entreprise : "+
                    msc.getEcartTypeHeureEmployeEntreprise(indChoice));
        }

    }

    public void menuDataEmpPro(){
        System.out.println("Séléctionnez le projet souhaité (entrez l'id) ");

        DAOrequester.afficherLignes("Projet"); //Afficher la liste des projets

        int proChoice = scan.nextInt();

        //On vérifie que l'ID est bien présent dans la table
        if (verif.verifValiditeID(proChoice, "projet") && verif.verifDataInDB(proChoice, "projet")){

            System.out.println("\n Moyenne d'heure des employés pour le projet :"+
                    msc.getMoyenneHeureEmployeProjet(proChoice));

            System.out.println("\n Somme d'heure des employés pour le projet : "+
                    msc.getSommeHeureEmployeProjet(proChoice));

            System.out.println("\n Variance d'heure des employés pour le projet :"+
                    msc.getVarianceHeureEmployeProjet(proChoice));

            System.out.println("\n Ecart-Type d'heure des employés pour le projet : "+
                    msc.getEcartTypeHeureEmployeProjet(proChoice));

        }

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
        sc.calcul_prime();
    }

    public void salaireMenInd(){
        DAOrequester.afficherLignes("industrie");

        System.out.print("Saisissez l'Id de l'entreprise: ");
        int indChoice = scan.nextInt();

        if(verif.verifValiditeID(indChoice, "industrie") && verif.verifDataInDB(indChoice, "industrie")) {
            double result_moy = sc.salaire_entreprise(indChoice);
            System.out.println("\nLe salaire mensuel moyen de l'entreprise est de: " + result_moy + "€\n");
        }

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

        DAOrequester.afficherLignes("industrie");
        System.out.print("Saisissez l'Id de l'entreprise: ");

        int indChoice = scan.nextInt();

        switch(sexe){
            case 1:
                if(verif.verifValiditeID(indChoice, "industrie") &&
                        verif.verifDataInDB(indChoice, "industrie")) {

                    double result_masculin = sc.salaire_cond("sexe", "M", indChoice);

                    System.out.println("Le salaire mensuel moyen de l'entreprise pour un homme est de: " +
                            result_masculin + "€\n");}
                break;
            case 2:
                if(verif.verifValiditeID(indChoice, "industrie") &&
                        verif.verifDataInDB(indChoice, "industrie")) {

                    double result_feminin = sc.salaire_cond("sexe","F", indChoice);

                    System.out.println("Le salaire mensuel moyen de l'entreprise pour une femme est de: " +
                            result_feminin + "€\n");}
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

        DAOrequester.afficherLignes("industrie");
        System.out.print("Saisissez l'Id de l'entreprise: ");

        int indChoice = scan.nextInt();

        switch(status){
            case 1:
                if(verif.verifValiditeID(indChoice, "industrie") &&
                        verif.verifDataInDB(indChoice, "industrie")) {

                    double result_cadre = sc.salaire_cond("statut", "Cadre", indChoice);

                    System.out.println("Le salaire mensuel moyen de l'entreprise pour un cadre est de: " +
                            result_cadre + "€\n");}
                break;
            case 2:
                if(verif.verifValiditeID(indChoice, "industrie") &&
                        verif.verifDataInDB(indChoice, "industrie")) {

                    double result_emp = sc.salaire_cond("statut", "Employe", indChoice);

                    System.out.println("Le salaire mensuel moyen de l'entreprise pour un employé est de: " +
                            result_emp + "€\n");}
                break;
            case 3:

                if(verif.verifValiditeID(indChoice, "industrie") &&
                        verif.verifDataInDB(indChoice, "industrie")) {

                    double result_stagiaire = sc.salaire_cond("statut",
                            "Stagiaire", indChoice);

                    System.out.println("Le salaire mensuel moyen de l'entreprise pour un stagiaire est de: " +
                            result_stagiaire + "€\n");}
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
                sc.sal_employes();
                break;

            case 2:
                DAOrequester.afficherLignes("employe");

                System.out.print("\nSaisissez l'id de l'employé: ");

                int idEmp = scan.nextInt(); // choix employe

                if(verif.verifValiditeID(idEmp, "employe")&&verif.verifDataInDB(idEmp, "employe")) {
                    double result = sc.sal_employe(idEmp);
                    System.out.println("Salaire: " + result + " €/mois");}
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

        ArrayList<Integer> listOfId= DAOrequester.listeIdTable("industrie");

        switch(new Scanner(System.in).nextInt()) {

            case 1:

                for (Integer integer : listOfId) {
                    System.out.println("L'entreprise : " + DAOrequester.nameInTable(integer,
                            "industrie") + " offre comme salaire moyen a ses stagiaires : " +
                            sc.salaire_cond("statut", "stagiaire", integer) + " euros");
                }
                break;

            case 2:
                for (Integer value : listOfId) {
                    System.out.println("L'entreprise : " + DAOrequester.nameInTable(value,
                            "industrie") + " offre comme salaire moyen a ses employes : " +
                            sc.salaire_cond("statut", "employe", value) + " euros");
                }
                break;

            case 3:
                for (Integer integer : listOfId) {
                    System.out.println("L'entreprise : " + DAOrequester.nameInTable(integer,
                            "industrie") + " offre comme salaire moyen a ses cadres : " +
                            sc.salaire_cond("statut", "cadre", integer) + " euros");
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

        ArrayList<Integer> listOfId = DAOrequester.listeIdTable("industrie");
        switch(new Scanner(System.in).nextInt()) {

            case 1:

                for (Integer integer : listOfId) {
                    System.out.println("L'entreprise : " + DAOrequester.nameInTable(integer,
                            "industrie") + " offre comme salaire moyen a ses hommes : " +
                            sc.salaire_cond("sexe", "M", integer) + " euros");
                }
                break;

            case 2:
                for (Integer integer : listOfId) {
                    System.out.println("L'entreprise : " + DAOrequester.nameInTable(integer,
                            "industrie") + " offre comme salaire moyen a ses femmes : " +
                            sc.salaire_cond("sexe", "F", integer) + " euros");
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
                ArrayList<Integer> listOfId = DAOrequester.listeIdTable("industrie");
                System.out.println("Veuillez sélectionnez votre entreprise :");
                for (Integer integer : listOfId) {
                    System.out.println(integer + ". " + DAOrequester.nameInTable(integer, "industrie"));
                }

                sc.superStatInd(new Scanner(System.in).nextInt());

                break;

            case 2 :
                System.out.println("Non disponible");
                break;

            default:
                break;

        }
    }

}
