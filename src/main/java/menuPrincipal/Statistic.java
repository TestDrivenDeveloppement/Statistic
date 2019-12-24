package menuPrincipal;

import dao.DAOconnexion;

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

                    if(menuSalaire == 1){infoSalaire = false; }

                    else if (menuSalaire == 2){stat.primeEmp();}

                    else if (menuSalaire == 3){stat.salaireMenInd();}
                }

            }

            // Quitter l'app
            else if(menuChoice == 6){main = false;}

            // Mauvais choix
            else{System.out.println("\n Entrer un numero de choix valide");}

        }
        System.out.println("\t Merci et a bientot");
        DAOconnexion.closeConnection();

    }
}
