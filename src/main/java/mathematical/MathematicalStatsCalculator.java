package mathematical;

import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import dao.DAOrequester;
import dao.DAOverification;

public class MathematicalStatsCalculator extends DAOrequester{

	/**
	 * @author Loic
	 * @param idEntreprise
	 * @return la somme d'heures travaille par l'ensemble des employs dans une industrie
	 */
	public String getSommeHeureEmployeEntreprise(int idEntreprise){

		try{
			// recuperer la liste de la table selectionnee
			String requeteSelectionnee = "SELECT SUM(nb_heure) AS somme FROM employe " +
					"INNER JOIN industrie ON id_ind='"+idEntreprise+"'";
			return recupResultatRequete(requeteSelectionnee);
		}catch (Exception e){return e.getMessage();}

	}


	/**
	 * @author Loic
	 * @param idProj
	 * @return le nombre d'heures passes par tous les employes sur un même projet
	 */
	public String getSommeHeureEmployeProjet(int idProj){

		try{
			// recuperer la liste de la table s�lectionn�e
			String requeteSelectionnee = "SELECT SUM(nb_heure) AS somme FROM projet " +
					"INNER JOIN intermediaire ON fk_id_projet='"+idProj+"' " +
					"INNER JOIN employe ON fk_id_emp = id_emp";
			return recupResultatRequete(requeteSelectionnee);
		}catch (Exception e){return e.getMessage();}

	}

	/**
	 * @author Loic
	 * @param idEntreprise
	 * @return la moyenne d'heures travaill�e par l'ensemble des employ�s dans une industrie
	 */
	public String getMoyenneHeureEmployeEntreprise(int idEntreprise){

		try{
			// recuperer la liste de la table s�lectionn�e
			String requeteSelectionnee = "SELECT AVG(nb_heure) AS somme FROM employe " +
					"INNER JOIN industrie ON id_ind='"+idEntreprise+"'";
			return recupResultatRequete(requeteSelectionnee);
		}catch (Exception e){return e.getMessage();}
	}

	/**
	 * @author Loic
	 * @param idProj
	 * @return la moyenne d'heures pass�s par tous les employ�s sur un même projet
	 */
	public String getMoyenneHeureEmployeProjet(int idProj){

		try{
			// recuperer la liste de la table s�lectionn�e
			String requeteSelectionnee = "SELECT AVG(nb_heure) AS somme FROM projet " +
					"INNER JOIN intermediaire ON fk_id_projet='"+idProj+"' " +
					"INNER JOIN employe ON fk_id_emp = id_emp";
			return recupResultatRequete(requeteSelectionnee);
		}catch (Exception e){return e.getMessage();}
	}

	/**
	 * @author Loic
	 * @param idEntreprise
	 * @return la variance d'heures travaill�es par l'ensemble des employ�s dans une industrie
	 * @throws NumberFormatException
	 */
	public String getVarianceHeureEmployeEntreprise(int idEntreprise) throws NumberFormatException{

		try{
			ArrayList<String> listeHeure;
			// recuperer la liste de la table s�lectionn�e
			String requeteSelectionnee = "SELECT nb_heure FROM employe " +
					"INNER JOIN industrie ON id_ind='"+idEntreprise+"'";

			listeHeure = remplirChampsRequete(requeteSelectionnee);
			double somme=0;
			double moyenneHeure = Double.parseDouble(getMoyenneHeureEmployeEntreprise(idEntreprise));
			// afficher les lignes de la requete selectionnee a partir de la liste

			for (String s : listeHeure) {
				somme = Math.pow((Double.parseDouble(s) - moyenneHeure), 2) + somme;
			}

			return Double.toString(somme/listeHeure.size());
		}catch (Exception e){return e.getMessage();}

	}

	/**
	 * @author Loic
	 * @param idProj
	 * @return la variance d'heures travaill�es par l'ensemble des employ�s sur un projet
	 */
	public String getVarianceHeureEmployeProjet(int idProj){

		try{
			ArrayList<String> listeHeure;
			// recuperer la liste de la table s�lectionn�e
			String requeteSelectionnee = "SELECT nb_heure FROM projet " +
					"INNER JOIN intermediaire ON fk_id_projet='"+idProj+"' " +
					"INNER JOIN employe ON fk_id_emp = id_emp";

			listeHeure = remplirChampsRequete(requeteSelectionnee);
			double somme=0;
			double moyenneHeure = Double.parseDouble(getMoyenneHeureEmployeProjet(idProj));
			// afficher les lignes de la requete selectionnee a partir de la liste

			for (String s : listeHeure) {
				somme = Math.pow((Double.parseDouble(s) - moyenneHeure), 2) + somme;
			}

			return Double.toString(somme/listeHeure.size());
		}catch (Exception e){return e.getMessage();}

	}

	/**
	 * @author Loic
	 * @param idEntreprise
	 * @return l'ecart type d'heures travaillees par l'ensemble des employes dans une industrie
	 * @throws NumberFormatException
	 */
	public String getEcartTypeHeureEmployeEntreprise(int idEntreprise) throws NumberFormatException{

		try{
			return Double.toString(Math.sqrt(
					Double.parseDouble(getVarianceHeureEmployeEntreprise(idEntreprise))));
		}catch (Exception e){return e.getMessage();}

	}

	/**
	 * @author Loic
	 * @param idProjet
	 * @return l'ecart type d'heures travaillees par l'ensemble des employes sur un projet
	 * @throws NumberFormatException
	 */
	public String getEcartTypeHeureEmployeProjet(int idProjet) throws NumberFormatException{


		try{
			return Double.toString(Math.sqrt(Double.parseDouble(getVarianceHeureEmployeProjet(idProjet))));
		}catch (Exception e){return e.getMessage();}
	}

}
