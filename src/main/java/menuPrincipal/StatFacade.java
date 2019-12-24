package menuPrincipal;

import dao.DAOrequester;
import dao.DAOverification;
import mathematical.MathematicalStatsCalculator;
import mathematical.SalaireCalculator;

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
                + "\n 1. Voir les données des employés d'une entreprise."
                + "\n 2. Voir les données des employés pour un projet."
                + "\n 3. Voir les informations sur le salaire"
                + "\n 4. Comparer les entreprises selon des caractères précis."
                +" \n 5. Obtenir des statistiques avancés sur votre entreprise ou projet."
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
        if (verif.verifValiditeID(indChoice, "industrie")){

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
        if (verif.verifValiditeID(proChoice, "projet")){

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

        if(verif.verifValiditeID(indChoice, "industrie") &&
                verif.verifDataInDB(indChoice, "industrie")) {
            double result_moy = sc.salaire_entreprise("employe", indChoice);
            System.out.println("Le salaire mensuel moyen de l'entreprise est de: " + result_moy + "€\n");
        }

    }






}
