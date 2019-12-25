package mathematical;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import dao.DAOrequester;
import dao.DAOverification;

public class SalaireCalculator extends DAOrequester {

	/**
	 * Permet de calculer les primes en fonction du nombre d'heures travaillées et du statut
	 * @author Vick
	 * Ecriture de la fonction
	 * @author Loic
	 * Modification
	 */
	public void calcul_prime(){
		ArrayList<String> heure;
		ArrayList<String> statut;
		ArrayList<String> liste;
		double prime = 0;


		// recuperer la liste de la table sélectionnée
		String requeteSelectionnee = "select nb_heure from employe";
		heure = remplirChampsRequete(requeteSelectionnee);

		String reqSelectionnee = "select statut from employe";
		statut = remplirChampsRequete(reqSelectionnee);

		String req = "select nom, prenom, statut from employe";
		liste = remplirChampsRequete(req);

		// afficher les lignes de la requete selectionnee a partir de la liste

		for(int i = 0; i < heure.size(); i++)
		{
			double surplusHoraire=0;

			switch (statut.get(i)) {
				case "Stagiaire\n" :
					surplusHoraire = Double.parseDouble(heure.get(i)) - 175;
					if(surplusHoraire<=0){ prime = 0;}
					else{
						prime = surplusHoraire*(3.75*1.25);}
					break;

				case "Employe\n" :
					surplusHoraire = Double.parseDouble(heure.get(i)) - 200;
					if(surplusHoraire<=0){ prime = 0;}
					else{
						prime = surplusHoraire*(7.93*1.25);
					}
					break;

				case "Cadre\n" :
					surplusHoraire = Double.parseDouble(heure.get(i)) - 225;
					if(surplusHoraire<=0){ prime = 0;}
					else{
						prime = surplusHoraire*(9.13*1.25);
					}
					break;

				default :
					System.out.println("Erreur");
					break;
			}
			System.out.println(liste.get(i) + "Prime: " + prime + "€/mois\n");

		}

	}

	/**
	 * Permet d'afficher les employés présents dans la BDD
	 * @author Vick
	 * Ecriture de la fonction
	 * @author Loic
	 * Modifications
	 */
	public void sal_employes(){
		ArrayList<Double> liste_sal;
		liste_sal = new ArrayList<Double>();
		ArrayList<String> heure;
		ArrayList<String> statut;
		ArrayList<String> liste;
		double sal = 0;


		// recuperer la liste de la table sélectionnée
		String requeteSelectionnee = "select nb_heure from employe";
		heure = remplirChampsRequete(requeteSelectionnee);

		String reqSelectionnee = "select statut from employe";
		statut = remplirChampsRequete(reqSelectionnee);

		String req = "select nom, prenom, statut from employe";
		liste = remplirChampsRequete(req);

		// afficher les lignes de la requete selectionnee a partir de la liste
		for(int i = 0; i < heure.size(); i++)
		{

			switch (statut.get(i)) {
				case "Stagiaire\n" :
					sal = Double.parseDouble(heure.get(i))*3.75;
					liste_sal.add(sal);
					break;

				case "Employe\n" :
					sal = Double.parseDouble(heure.get(i))*7.93;
					liste_sal.add(sal);
					break;

				case "Cadre\n" :
					sal = Double.parseDouble(heure.get(i))*9.13;
					liste_sal.add(sal);
					break;

				default :
					System.out.println("Erreur");
					break;
			}
			System.out.println(liste.get(i) + sal + "€/mois\n");

		}
	}


	/**
	 * Permet d'afficher le salaire d'un employé dans la BDD
	 * @author Vick
	 * Ecriture de la fonction
	 * @author Loic
	 * Modification
	 */
	public double sal_employe(int id){
		double sal = 0;
		ArrayList<String> heure;
		ArrayList<String> statut;
		ArrayList<String> liste;


		// recuperer la liste de la table sélectionnée
		String requeteSelectionnee = "select nb_heure from employe where id_emp="+id;
		heure = remplirChampsRequete(requeteSelectionnee);

		String reqSelectionnee = "select statut from employe where id_emp="+id;
		statut = remplirChampsRequete(reqSelectionnee);

		String req = "select nom, prenom, statut from employe where id_emp="+id;
		liste = remplirChampsRequete(req);


		for(int i = 0; i < heure.size(); i++)
		{
			switch (statut.get(i)) {
				case "Stagiaire\n" :
					sal = Double.parseDouble(heure.get(i))*3.75;
					break;

				case "Employe\n" :
					sal = Double.parseDouble(heure.get(i))*7.93;
					break;

				case "Cadre\n" :
					sal = Double.parseDouble(heure.get(i))*9.13;
					break;

				default :
					System.out.println("Erreur");
					break;
			}
			System.out.print(liste.get(i));

		}
		return sal;
	}



	/**
	 * Permet d'afficher le salaire moyen dans une entreprise
	 *
	 * @author Vick
	 * Ecriture de la fonction
	 *
	 * @author Loic
	 * Modification
	 */
	public double salaire_entreprise(int id){

		double sal = 0, sal_moy = 0;

		ArrayList<String> heure;
		ArrayList<String> statut;

		double n = 0;

		// recuperer la liste de la table sélectionnée
		String requeteSelectionnee = "select nb_heure from employe where fk_id_ind="+id+";";
		heure = remplirChampsRequete(requeteSelectionnee);

		String reqSelectionnee = "select statut from employe where fk_id_ind="+id+";";
		statut = remplirChampsRequete(reqSelectionnee);


		// afficher les lignes de la requete selectionnee a partir de la liste
		for(int i = 0; i < heure.size(); i++)
		{
			switch (statut.get(i)) {
			case "Stagiaire\n" :
				sal += Double.parseDouble(heure.get(i))*3.75;
				n+=1;
				break;

			case "Employe\n" :
				sal += Double.parseDouble(heure.get(i))*7.93;
				n+=1;
				break;

			case "Cadre\n" :
				sal += Double.parseDouble(heure.get(i))*9.13;
				n+=1;
				break;

			default :
				System.out.println("Erreur");
				break;

			}
		}
		sal_moy = (sal/n);

		return(sal_moy);
	}

	/**
	 * Permet d'afficher le salaire moyen selon le genre ou le statut dans une entreprise
	 *
	 *@author Vick
	 *Ecriture de la fonction
	 *@author Loic
	 *Ré-ecriture
	 */
	public double salaire_cond(String condColumnName, String condColumnInput, int id){

		double sal=0, sal_moyen=0;
		ArrayList<String> heure;
		ArrayList<String> statut;

		int n=0;

		String choice="WHERE "+condColumnName+"='"+condColumnInput+"' AND fk_id_ind ="+id;

		String requeteSelectionnee = "select nb_heure from employe "+ choice+";";
		heure = remplirChampsRequete(requeteSelectionnee);

		String reqSelectionnee = "select statut from employe "+ choice+";";
		statut = remplirChampsRequete(reqSelectionnee);


		for(int i = 0; i < heure.size(); i++)
		{

			switch (statut.get(i)) {
			case "Stagiaire\n" :
				sal += Double.parseDouble(heure.get(i))*3.75;
				n+=1;
				break;

			case "Employe\n" :
				sal += Double.parseDouble(heure.get(i))*7.93;
				n+=1;
				break;

			case "Cadre\n" :
				sal += Double.parseDouble(heure.get(i))*9.13;
				n+=1;
				break;

			default :
				System.out.println("Erreur");
				break;

			}

		}
		sal_moyen = (sal/n);


		return sal_moyen;
	}

	/**
	 * Permet d'afficher le salaire moyen selon le genre ou le statut dans les autres entreprises que celle sélectionée
	 *
	 *@author Loic
	 *Ecriture
	 */
	public double autre_salaire_cond(String condColumnName, String condColumnInput, int id){

		double sal=0, sal_moyen=0;

		ArrayList<String> heure;
		ArrayList<String> statut;

		int n=0;

		String choice="WHERE "+condColumnName+"='"+condColumnInput+"' AND fk_id_ind !="+id;

		String requeteSelectionnee = "select nb_heure from employe " + choice+";";
		heure = remplirChampsRequete(requeteSelectionnee);

		String reqSelectionnee = "select statut from employe " + choice+";";
		statut = remplirChampsRequete(reqSelectionnee);


		for(int i = 0; i < heure.size(); i++)
		{
			switch (statut.get(i)) {
			case "Stagiaire\n" :
				sal += Double.parseDouble(heure.get(i))*3.75;
				n+=1;
				break;

			case "Employe\n" :
				sal += Double.parseDouble(heure.get(i))*7.93;
				n+=1;
				break;

			case "Cadre\n" :
				sal += Double.parseDouble(heure.get(i))*9.13;
				n+=1;
				break;

			default :
				System.out.println("Erreur");
				break;

			}

		}
		sal_moyen = (sal/n);


		return(sal_moyen);
	}


	/**Affiche les statistiques avancees pour une entreprise
	 * @param idInd
	 * @author Loic
	 */
	public void superStatInd(int idInd){
		int nbreEmploye=Integer.parseInt(recupResultatRequete("SELECT COUNT(id_emp) FROM employe " +
				"INNER JOIN industrie ON (fk_id_ind=id_ind) WHERE id_ind="+ idInd));

		int nbreEmployeM=Integer.parseInt(recupResultatRequete("SELECT COUNT(id_emp) FROM employe " +
				"INNER JOIN industrie ON (fk_id_ind=id_ind) WHERE (sexe='M') AND id_ind="+ idInd));

		int nbreEmployeF=Integer.parseInt(recupResultatRequete("SELECT COUNT(id_emp) FROM employe " +
				"INNER JOIN industrie ON (fk_id_ind=id_ind) WHERE (sexe='F')AND id_ind=" +idInd));

		System.out.println("Votre entreprise compte : " + nbreEmploye+" employes");

		System.out.println("Parmis ces employes, vous comptez " + nbreEmployeM+" hommes ("
				+ (((float)nbreEmployeM/(float)nbreEmploye)*100) + "%) et "+nbreEmployeF
				+ " femmes (" + (((float)nbreEmployeF/(float)nbreEmploye)*100)+"%)");

		System.out.println("\t ........................... \t");
		System.out.println("Salaire moyen au sein de l'entreprise :"+ salaire_entreprise(idInd));

		System.out.println("Salaire par statut : "
				+ "\n 1. Stagiaire : " + salaire_cond("statut", "stagiaire", idInd)
				+" \n \t => Un stagiaire touche en moyenne "
				+ ((float) + salaire_cond("statut", "stagiaire", idInd)
				/(float)autre_salaire_cond("statut", "stagiaire", idInd))*100
				+ "% que dans une autre entreprise"
				+" \n 2. Employe :" + salaire_cond("statut", "employe", idInd) +" euros"
				+" \n \t => Un employe touche en moyenne "+ ((float)
				+
				salaire_cond("statut", "employe", idInd)
				/(float)autre_salaire_cond("statut", "employe", idInd))*100
				+ "% que dans une autre entreprise"
				+" \n 3. Cadre : " + salaire_cond("statut", "cadre", idInd) + " euros"
				+" \n \t => Un cadre touche en moyenne " + ((float)
				+ salaire_cond("statut", "cadre", idInd)
				/(float)autre_salaire_cond("statut", "cadre", idInd))*100
				+ "% que dans une autre entreprise");

		System.out.println("\t ........................... \t");
		System.out.println("Un homme touche en moyenne "
				+ salaire_cond("sexe", "M", idInd)
				+ " euros au sein de votre entreprise"
				+" \n \t => Une difference de "
				+ ((float)salaire_cond("sexe", "M", idInd)
				/(float)autre_salaire_cond("sexe", "M", idInd))*100
				+ "% que dans une autre entreprise"
				+"\nUne femme touche en moyenne " +
				salaire_cond("sexe", "F", idInd)
				+ "  euros au sein de votre entreprise"
				+" \n \t => Une difference de "
				+ ((float)salaire_cond("sexe", "F", idInd)
				/(float)autre_salaire_cond("sexe", "F", idInd))*100
				+ "% que dans une autre entreprise"
				+"\nIl ya une difference de " +
				((float)salaire_cond("sexe", "M", idInd)
						/(float)salaire_cond("sexe", "F", idInd))*100
				+ "% entre le salaire d'un homme et d'une femme dans votre entreprise");
	}

}
