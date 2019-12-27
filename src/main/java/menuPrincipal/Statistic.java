package menuPrincipal;

import dao.DAOconnexion;
import daorefactoring.*;
import mathematical.MathematicalStatsCalculator;
import mathematical.SalaireCalculator;
import model.Employe;
import model.Industrie;
import model.Intermediaire;
import model.Projet;

import java.util.ArrayList;

public class Statistic {

    public static void main(String[] args){

        boolean main = true;

        while(main){ // tant qu'on est dans le menu principal
            StatFacade stat = new StatFacade();

            int menuChoice; // choix de menu
            menuChoice = stat.start(); // start le menu principal

            // menu 1 (Voir les données des employés d'une entreprise.)
            if (menuChoice == 1){stat.menuDataEmpInd();}

            // menu 2 (Voir les données des employés pour un projet.)
            else if(menuChoice == 2){stat.menuDataEmpPro();}

            // menu 3 (Voir les informations sur le salaire)
            else if(menuChoice == 3){
                boolean infoSalaire = true;

                while (infoSalaire){ // tant qu'on est dans le menu 3
                    int menuSalaire = stat.menuSalaire(); // choix de menu + start menu salaire

                    if(menuSalaire == 1){infoSalaire = false; } // revenir menu principal

                    // Calcul des primes par employé
                    else if (menuSalaire == 2){stat.primeEmp();}

                    // Salaire mensuel moyen par entreprise
                    else if (menuSalaire == 3){stat.salaireMenInd();}

                    // menu salaire mensuel moyen par sexe
                    else if (menuSalaire == 4){

                        int sexeChoice = stat.menuSalaireSexe(); // print les choix + return le choix
                        if (sexeChoice == 1 || sexeChoice == 2){
                            stat.salaireSexeInd(sexeChoice);
                        }

                        // Mauvais choix
                        else{System.out.println("\n Entrer un numero de choix valide");}

                    }

                    // menu salaire mensuel moyen par statut
                    else if (menuSalaire == 5){

                        int statutChoice = stat.menuSalaireStatus(); // print les choix + return le choix
                        if (statutChoice == 1 || statutChoice == 2 || statutChoice == 3){
                            stat.salaireStatusInd(statutChoice);
                        }

                        // Mauvais choix
                        else{System.out.println("\n Entrer un numero de choix valide");}

                    }

                    // menu salaire mensuel employe
                    else if (menuSalaire == 6){

                        int choice = stat.menuSalaireEmp(); // print les choix + return le choix
                        if (choice == 1 || choice == 2){
                            stat.salaireEmp(choice);
                        }

                        // Mauvais choix
                        else{System.out.println("\n Entrer un numero de choix valide");}

                    }
                }

            }

            // menu 4 (Comparer les entreprises selon des caractères précis)
            else if(menuChoice == 4){
                boolean comparison = true;

                while (comparison){
                    int compChoice = stat.menuComparison();

                    // Comparer les différences de salaire selon le statut dans l'entreprise
                    if (compChoice == 1){ stat.menuCompStatut();}

                    // Comparer les différences de salaire selon le genre des employés
                    else if (compChoice == 2){ stat.menuCompGenre();}

                    // back menu principal
                    else if (compChoice == 3){ comparison = false;}
                }
            }

            // menu 5 (Obtenir des statistiques avancés sur votre entreprise ou projet)
            else if (menuChoice == 5){stat.statAvance();}

            // Quitter l'app
            else if(menuChoice == 6){main = false;}

            // Mauvais choix
            else{System.out.println("\n Entrer un numero de choix valide");}

        }
        System.out.println("\t Merci et a bientot");
        DAOconnexion.closeConnection();

        /*IndustrieDAO indDao = new IndustrieDAO(DAOconnexion.getInstance());

        Industrie ind = indDao.find(1);

        /*for (Industrie industrie: ind){
            System.out.println(industrie.getNom_ind());
        }*/
        //System.out.println(ind.getNom_ind());
        //System.out.println(ind);

        /*SalaireCalculator sc = new SalaireCalculator();
        //System.out.println(sc.nombreEmpGenreInd(1, "M"));
        sc.superSatInd(1);
        DAOconnexion.closeConnection();*/

    }
}
