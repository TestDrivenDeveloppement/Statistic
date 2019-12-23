package mathematical;

import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import dao.DAOrequester;
import dao.DAOverification;

public class MathematicalStatsCalculator {

	private DAOrequester dr = new DAOrequester();

	/**Retourne la somme d'heures travaille par l'ensemble des employs dans une industrei
	 *
	 * @author Loic
	 * @param idEntreprise
	 * @return
	 * @throws //ClassNotFoundException
	 */
	public static String getSommeHeureEmployeEntreprise(int idEntreprise){

		String resultStatement = null;
		DAOrequester dr = new DAOrequester();
		// recuperer la liste de la table selectionnee
		String requeteSelectionnee = "SELECT SUM(nb_heure) AS somme FROM employe INNER JOIN industrie ON id_ind='"+idEntreprise+"'";
		resultStatement = dr.recupResultatRequete(requeteSelectionnee);

		// afficher les lignes de la requete selectionnee a partir de la liste


		return resultStatement;
	}


	/**Retourne le nombre d'heures passes par tous les employes sur un même projet
	 *
	 * @author Loic
	 * @param idProj
	 * @return
	 * @throws ClassNotFoundException
	 */
	public static String getSommeHeureEmployeProjet(int idProj){

		String resultStatement = null;

		DAOrequester dr = new DAOrequester();
		// recuperer la liste de la table s�lectionn�e
		String requeteSelectionnee = "SELECT SUM(nb_heure) AS somme FROM projet INNER JOIN intermediaire ON fk_id_projet='"+idProj+"' INNER JOIN employe ON fk_id_emp = id_emp";
		resultStatement = dr.recupResultatRequete(requeteSelectionnee);

		// afficher les lignes de la requete selectionnee a partir de la liste


		return resultStatement;
	}

	/**Retourne la moyenne d'heures travaill�e par l'ensemble des employ�s dans une industrei
	 *
	 * @author Loic
	 * @param idEntreprise
	 * @return
	 * @throws ClassNotFoundException
	 */
	public static String getMoyenneHeureEmployeEntreprise(int idEntreprise){

		String resultStatement = null;

		DAOrequester dr = new DAOrequester();
		// recuperer la liste de la table s�lectionn�e
		String requeteSelectionnee = "SELECT AVG(nb_heure) AS somme FROM employe INNER JOIN industrie ON id_ind='"+idEntreprise+"'";
		resultStatement = dr.recupResultatRequete(requeteSelectionnee);

		// afficher les lignes de la requete selectionnee a partir de la liste


		return resultStatement;
	}

	/**Retourne la moyenne d'heures pass�s par tous les employ�s sur un même projet
	 *
	 * @author Loic
	 * @param idProj
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static String getMoyenneHeureEmployeProjet(int idProj){


		String resultStatement = null;
		DAOrequester dr = new DAOrequester();
		// recuperer la liste de la table s�lectionn�e
		String requeteSelectionnee = "SELECT AVG(nb_heure) AS somme FROM projet INNER JOIN intermediaire ON fk_id_projet='"+idProj+"' INNER JOIN employe ON fk_id_emp = id_emp";
		resultStatement = dr.recupResultatRequete(requeteSelectionnee);

		// afficher les lignes de la requete selectionnee a partir de la liste


		return resultStatement;
	}

	/**
	 * @author Loic
	 * @param idEntreprise
	 * @return la variance d'heures travaill�es par l'ensemble des employ�s dans une industrie
	 * @throws NumberFormatException
	 */
	public String getVarianceHeureEmployeEntreprise(int idEntreprise) throws NumberFormatException{

		String resultStatement = null;

		ArrayList<String> listeHeure;
		// recuperer la liste de la table s�lectionn�e
		String requeteSelectionnee = "SELECT nb_heure FROM employe INNER JOIN industrie ON id_ind='"+idEntreprise+"'";

		listeHeure = dr.remplirChampsRequete(requeteSelectionnee);
		double somme=0;
		double moyenneHeure = Double.parseDouble(getMoyenneHeureEmployeEntreprise(idEntreprise));
		// afficher les lignes de la requete selectionnee a partir de la liste

		for (String s : listeHeure) {
			somme = Math.pow((Double.parseDouble(s) - moyenneHeure), 2) + somme;
		}

		resultStatement=Double.toString(somme/listeHeure.size());

		return resultStatement;
	}

	/**
	 * @author Loic
	 * @param idProj
	 * @return la variance d'heures travaill�es par l'ensemble des employ�s sur un projet
	 */
	public String getVarianceHeureEmployeProjet(int idProj){

		String resultStatement = null;

		ArrayList<String> listeHeure;
		// recuperer la liste de la table s�lectionn�e
		String requeteSelectionnee = "SELECT nb_heure FROM projet " +
				"INNER JOIN intermediaire ON fk_id_projet='"+idProj+"' INNER JOIN employe ON fk_id_emp = id_emp";

		listeHeure = dr.remplirChampsRequete(requeteSelectionnee);
		double somme=0;
		double moyenneHeure = Double.parseDouble(getMoyenneHeureEmployeProjet(idProj));
		// afficher les lignes de la requete selectionnee a partir de la liste

		for (String s : listeHeure) {
			somme = Math.pow((Double.parseDouble(s) - moyenneHeure), 2) + somme;
		}

		resultStatement=Double.toString(somme/listeHeure.size());

		return resultStatement;
	}

	/**
	 * @author Loic
	 * @param idEntreprise
	 * @return l'ecart type d'heures travaillees par l'ensemble des employes dans une industrie
	 * @throws NumberFormatException
	 */
	public String getEcartTypeHeureEmployeEntreprise(int idEntreprise) throws NumberFormatException{

		String resultStatement = null;
		resultStatement=Double.toString(Math.sqrt(
				Double.parseDouble(getVarianceHeureEmployeEntreprise(idEntreprise))));
		return resultStatement;
	}

	/**
	 * @author Loic
	 * @param idProjet
	 * @return l'ecart type d'heures travaillees par l'ensemble des employes sur un projet
	 * @throws NumberFormatException
	 */
	public String getEcartTypeHeureEmployeProjet(int idProjet) throws NumberFormatException{

		String resultStatement = null;
		resultStatement=Double.toString(Math.sqrt(Double.parseDouble(getVarianceHeureEmployeProjet(idProjet))));
		return resultStatement;
	}

	/**Affiche les statistiques avancees pour une entreprise
	 * @param idInd
	 * @author Loic
	 */
	public void superStatInd(int idInd){
		DecimalFormat df = new DecimalFormat("########.00");
		SalaireCalculator sal = new SalaireCalculator();
		int nbreEmploye=Integer.parseInt(dr.recupResultatRequete("SELECT COUNT(id_emp) FROM employe INNER JOIN industrie ON (fk_id_ind=id_ind) WHERE id_ind="+idInd));
		int nbreEmployeM=Integer.parseInt(dr.recupResultatRequete("SELECT COUNT(id_emp) FROM employe INNER JOIN industrie ON (fk_id_ind=id_ind) WHERE (sexe='M') AND id_ind="+idInd));
		int nbreEmployeF=Integer.parseInt(dr.recupResultatRequete("SELECT COUNT(id_emp) FROM employe INNER JOIN industrie ON (fk_id_ind=id_ind) WHERE (sexe='F')AND id_ind="+idInd));

		System.out.println("Votre entreprise compte : "+nbreEmploye+" employes");
		System.out.println("Parmis ces employes, vous comptez "+nbreEmployeM+" hommes ("+df.format((((float)nbreEmployeM/(float)nbreEmploye)*100))+"%) et "+nbreEmployeF+" femmes ("+df.format((((float)nbreEmployeF/(float)nbreEmploye)*100))+"%)");

		System.out.println("\t ........................... \t");
		System.out.println("Salaire moyen au sein de l'entreprise :"+df.format(sal.salaire_entreprise("employe", idInd)));
		System.out.println("Salaire par statut : "
				+ "\n 1. Stagiaire : "+df.format(sal.salaire_cond("employe", "statut", "stagiaire", idInd))
				+" \n \t => Un stagiaire touche en moyenne "+df.format(((float)+sal.salaire_cond("employe", "statut", "stagiaire", idInd)/(float)sal.autre_salaire_cond("employe", "statut", "stagiaire", idInd))*100)+"% que dans une autre entreprise"
				+" \n 2. Employe :"+df.format(sal.salaire_cond("employe", "statut", "employe", idInd ))+" euros"
				+" \n \t => Un employe touche en moyenne "+df.format(((float)+sal.salaire_cond("employe", "statut", "employe", idInd)/(float)sal.autre_salaire_cond("employe", "statut", "employe", idInd))*100)+"% que dans une autre entreprise"
				+" \n 3. Cadre : "+ df.format(sal.salaire_cond("employe", "statut", "cadre", idInd))+" euros"
				+" \n \t => Un cadre touche en moyenne "+df.format(((float)+sal.salaire_cond("employe", "statut", "cadre", idInd)/(float)sal.autre_salaire_cond("employe", "statut", "cadre", idInd))*100)+"% que dans une autre entreprise");

		System.out.println("\t ........................... \t");
		System.out.println("Un homme touche en moyenne "+df.format(sal.salaire_cond("employe", "sexe", "M", idInd))+" euros au sein de votre entreprise"
				+" \n \t => Une difference de "+df.format(((float)sal.salaire_cond("employe", "sexe", "M", idInd)/(float)sal.autre_salaire_cond("employe", "sexe", "M", idInd))*100)+"% que dans une autre entreprise"
				+"\nUne femme touche en moyenne "+df.format(sal.salaire_cond("employe", "sexe", "F", idInd))+"  euros au sein de votre entreprise"
				+" \n \t => Une difference de "+df.format(((float)sal.salaire_cond("employe", "sexe", "F", idInd)/(float)sal.autre_salaire_cond("employe", "sexe", "F", idInd))*100)+"% que dans une autre entreprise"
				+"\nIl ya une difference de "+df.format(((float)sal.salaire_cond("employe", "sexe", "M", idInd)/(float)sal.salaire_cond("employe", "sexe", "F", idInd))*100)+"% entre le salaire d'un homme et d'une femme dans votre entreprise");
	}

}
