package mathematical;

import java.util.ArrayList;

import dao.DAOconnexion;
import daorefactoring.Dao;
import daorefactoring.EmployeDAO;
import model.Employe;

public class SalaireCalculator {

	/**
	 * Permet de calculer les primes en fonction du nombre d'heures travaillées et du statut
	 * @author Vick
	 * Ecriture de la fonction
	 * @author Loic
	 * Modification
	 */
	public String primeEmp(ArrayList<Employe> employeList){

		String result = "";

		for (Employe employe : employeList) {
			double prime = 0;
			int surplusHoraire = 0;

			switch (employe.getStatut()) {
				case "Stagiaire":
					surplusHoraire = employe.getNb_heure() - 175;

					if (surplusHoraire > 0) {
						prime = surplusHoraire * (3.75 * 1.25);
					}

					break;

				case "Employe":
					surplusHoraire = employe.getNb_heure() - 200;

					if (surplusHoraire > 0) {
						prime = surplusHoraire * (7.93 * 1.25);
					}

					break;

				case "Cadre":
					surplusHoraire = employe.getNb_heure() - 225;

					if (surplusHoraire > 0) {
						prime = surplusHoraire * (9.13 * 1.25);
					}

					break;

				default:
					System.out.println("Erreur ");
					break;
			}

			result += employe.getNom() + " " + employe.getPrenom() +
					" ---> Prime: " + prime + "€/mois\n";

		}
		return result;
	}

	/**
	 * Permet d'afficher le salaire employés présents dans la BDD
	 * @author Vick
	 * Ecriture de la fonction
	 * @author Loic
	 * Modifications
	 */
	public String salaireAllEmp(ArrayList<Employe> employeList){

		double salaire = 0;

		String result = "";

		for (Employe employe : employeList){
			switch (employe.getStatut()) {
				case "Stagiaire" :
					salaire = employe.getNb_heure() * 3.75;
					break;

				case "Employe" :
					salaire = employe.getNb_heure() * 7.93;
					break;

				case "Cadre" :
					salaire = employe.getNb_heure() * 9.13;
					break;

				default :
					System.out.println("Erreur ");
					break;
			}
			result += employe.getNom() + " " + employe.getPrenom() +
					" ---> Salaire: " + salaire + "€/mois\n";
		}

		return result;
	}


	/**
	 * Permet d'afficher le salaire d'un employé dans la BDD
	 * @author Vick
	 * Ecriture de la fonction
	 * @author Loic
	 * Modification
	 */
	public double salaireOneEmp(Employe employe){
		double salaire = 0;

		switch (employe.getStatut()) {
			case "Stagiaire" :
				salaire = employe.getNb_heure() * 3.75;
				break;

			case "Employe" :
				salaire = employe.getNb_heure() * 7.93;
				break;

			case "Cadre" :
				salaire = employe.getNb_heure() * 9.13;
				break;

			default :
				System.out.println("Erreur ");
				break;
		}
		return salaire;
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
	public double salaireMoyInd(int idIndustrie, ArrayList<Employe> employeList){
		double salaireMoy = 0;
		int total = 0;

		for (Employe employe : employeList){
			if (employe.getIndustrie().getId_ind() == idIndustrie){
				switch (employe.getStatut()) {
					case "Stagiaire" :
						salaireMoy += employe.getNb_heure() * 3.75;
						total++;
						break;

					case "Employe" :
						salaireMoy += employe.getNb_heure() * 7.93;
						total++;
						break;

					case "Cadre" :
						salaireMoy += employe.getNb_heure() * 9.13;
						total++;
						break;

					default :
						System.out.println("Erreur ");
						break;
				}
			}
		}

		salaireMoy = salaireMoy/total;

		return salaireMoy;
	}

	/**
	 * Permet d'afficher le salaire moyen selon le genre ou le statut dans une entreprise
	 *
	 *@author Vick
	 *Ecriture de la fonction
	 *@author Loic
	 *Ré-ecriture
	 */
	public double salaireMoyIndGenre(int idIndustrie, String condition, ArrayList<Employe> employeList){

		double salaireMoy = 0;
		int total = 0;

		for (Employe employe : employeList){
			// selon le statut
			if (employe.getIndustrie().getId_ind() == idIndustrie &&
					employe.getStatut().equals(condition)){
				salaireMoy += employe.getNb_heure() * 3.75;
				total++;
			}

			// selon le genre
			else if (employe.getIndustrie().getId_ind() == idIndustrie &&
					employe.getSexe().equals(condition)){
				switch (employe.getStatut()){
					case "Stagiaire" :
						salaireMoy += employe.getNb_heure() * 3.75;
						total++;
						break;

					case "Employe" :
						salaireMoy += employe.getNb_heure() * 7.93;
						total++;
						break;

					case "Cadre" :
						salaireMoy += employe.getNb_heure() * 9.13;
						total++;
						break;

					default :
						System.out.println("Erreur ");
						break;
				}
			}
		}

		salaireMoy = salaireMoy/total;

		return salaireMoy;

	}

	/**
	 * Permet d'afficher le salaire moyen selon le genre ou le statut dans les autres entreprises que celle sélectionée
	 *
	 *@author Loic
	 *Ecriture
	 */
	public double salaireMoyAutreIndGenre(int idIndustrie, String condition, ArrayList<Employe> employeList){

		double salaireMoy = 0;
		int total = 0;

		for (Employe employe : employeList){
			// selon le statut
			if (employe.getIndustrie().getId_ind() != idIndustrie &&
					employe.getStatut().equals(condition)){
				salaireMoy += employe.getNb_heure() * 3.75;
				total++;
			}

			// selon le genre
			else if (employe.getIndustrie().getId_ind() != idIndustrie &&
					employe.getSexe().equals(condition)){
				switch (employe.getStatut()){
					case "Stagiaire" :
						salaireMoy += employe.getNb_heure() * 3.75;
						total++;
						break;

					case "Employe" :
						salaireMoy += employe.getNb_heure() * 7.93;
						total++;
						break;

					case "Cadre" :
						salaireMoy += employe.getNb_heure() * 9.13;
						total++;
						break;

					default :
						System.out.println("Erreur ");
						break;
				}
			}
		}

		salaireMoy = salaireMoy/total;

		return salaireMoy;

	}


	/**Affiche les statistiques avancees pour une entreprise
	 * @param idIndustrie
	 * @author Kolawole
	 */
	public String superSatInd(int idIndustrie, ArrayList<Employe> employeList){

		String result = "";
		double nbreEmploye = nombreEmpGenreInd(idIndustrie, "", employeList);
		double nbreEmployeM = nombreEmpGenreInd(idIndustrie, "M", employeList);
		double nbreEmployeF = nombreEmpGenreInd(idIndustrie, "F", employeList);

		double salaireMoyStagiaire = salaireMoyIndGenre(idIndustrie, "Stagiaire", employeList);
		double salaireMoyEmploye = salaireMoyIndGenre(idIndustrie, "Employe", employeList);
		double salaireMoyCadre = salaireMoyIndGenre(idIndustrie, "Cadre", employeList);

		double salaireMoyAutreStagiaire = salaireMoyAutreIndGenre(idIndustrie, "Stagiaire", employeList);
		double salaireMoyAutreEmploye = salaireMoyAutreIndGenre(idIndustrie, "Employe", employeList);
		double salaireMoyAutreCadre = salaireMoyAutreIndGenre(idIndustrie, "Cadre", employeList);

		result += "Votre entreprise compte : " + nbreEmploye + " employes\n";

		result += "Parmis ces employes, vous comptez " + nbreEmployeM + " hommes ("
				+ ((nbreEmployeM/nbreEmploye)*100) + "%) et "+nbreEmployeF
				+ " femmes (" + (((float)nbreEmployeF/(float)nbreEmploye)*100)+"%)\n";

		result += "\t ........................... \t\n";
		result += "Salaire moyen au sein de l'entreprise :"+ salaireMoyInd(idIndustrie, employeList) + "\n";

		result += "Salaire par statut : " +
				"\n 1. Stagiaire : " + salaireMoyStagiaire + " euros" +
				" \n \t => Un stagiaire touche en moyenne " +
				((float) salaireMoyStagiaire / (float)salaireMoyAutreStagiaire) * 100 +
				"% que dans une autre entreprise" +
				" \n 2. Employe :" + salaireMoyEmploye + " euros" +
				" \n \t => Un employe touche en moyenne "+
				((float) salaireMoyEmploye/ (float) salaireMoyAutreEmploye)*100 +
				"% que dans une autre entreprise" +
				" \n 3. Cadre : " + salaireMoyCadre + " euros" +
				" \n \t => Un cadre touche en moyenne " +
				((float) salaireMoyCadre / (float)salaireMoyAutreCadre)*100 +
				"% que dans une autre entreprise\n";

		return result;

	}

	public int nombreEmpGenreInd(int inIndustrie, String genre, ArrayList<Employe> employeList){

		int nombreEmp = 0;

		for (Employe employe : employeList){
			if (employe.getIndustrie().getId_ind() == inIndustrie && employe.getSexe().equals(genre)){
				nombreEmp++;
			}
			else if (employe.getIndustrie().getId_ind() == inIndustrie && genre.equals("")){
				nombreEmp++;
			}
		}

		return nombreEmp;
	}


}
