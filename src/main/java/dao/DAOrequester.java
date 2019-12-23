package dao;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DAOrequester{

	/**
	 * Attributs prives : connexion JDBC, statement, ordre requete et resultat
	 * requete
	 */
	private Statement stmt;
	private ResultSet rset;
	private ResultSetMetaData rsetMeta;

	public DAOrequester(){
		try {
			stmt = DAOconnexion.getInstance().createStatement();
		}catch (SQLException e){
			e.printStackTrace();
		}
	}

	/**
	 * @param requete
	 * @return ArrayList des champs de la requete en parametre
	 */
	public ArrayList<String> remplirChampsRequete(String requete){
		// creation d'une ArrayList de String
		ArrayList<String> liste;
		liste = new ArrayList<String>();

		try {
			// récupération de l'ordre de la requete
			rset = stmt.executeQuery(requete);

			// récupération du résultat de l'ordre
			rsetMeta = rset.getMetaData();

			// calcul du nombre de colonnes du resultat
			int nbColonne = rsetMeta.getColumnCount();

			// tant qu'il reste une ligne 
			while (rset.next()) {
				StringBuilder champs;
				champs = new StringBuilder(rset.getString(1)); // ajouter premier champ

				// Concatener les champs de la ligne separes par ,
				for (int i = 1; i < nbColonne; i++) {
					champs.append(". ").append(rset.getString(i + 1));
				}

				// ajouter un "\n" Ã  la ligne des champs
				champs.append("\n");

				// ajouter les champs de la ligne dans l'ArrayList
				liste.add(champs.toString());
			}

			rset.close();

		}catch (SQLException e){
			e.printStackTrace();
		}
		// Retourner l'ArrayList
		return liste;
	}

	/**
	 * @author Loic
	 * @param requete
	 * @return LA VALEUR D'UNE COLONNE
	 */
	public String recupResultatRequete(String requete){
		String resultStatement=null;

		try {
			// récupération de l'ordre de la requete
			rset = stmt.executeQuery(requete);



			// récupération du résultat de l'ordre
			rsetMeta = rset.getMetaData();

			rset.next();
			resultStatement=rset.getString(1);

			rset.close();

		}catch (SQLException e){
			e.printStackTrace();
		}

		// Retourner l'ArrayList
		return resultStatement;

	}

	/**
	 * @return la liste des ID d'une table
	 * @author Loic
	 */
	public ArrayList<Integer> listeIdTable(String table){
		ArrayList<Integer> listeID = new ArrayList<Integer>();

		try {

			// récupération de l'ordre de la requete
			rset = stmt.executeQuery("SELECT id_ind FROM " + table);

			// récupération du résultat de l'ordre
			rsetMeta = rset.getMetaData();

			while(rset.next()) {
				listeID.add(rset.getInt(1));
			}

			rset.close();

		}catch (SQLException e){
			e.printStackTrace();
		}

		// Retourner l'ArrayList
		return listeID;
	}

	/**
	 * @return le nom en fonction de l'ID d'une table
	 * @author Loic
	 */
	public String nameInTable(int id, String table){
		String nameOfElement = null;

		try {
			// récupération de l'ordre de la requete
			rset = stmt.executeQuery("SELECT nom_ind FROM "+table+" WHERE id_ind="+id);
			// récupération du résultat de l'ordre
			rsetMeta = rset.getMetaData();
			rset.next();
			nameOfElement=rset.getString(1);

			rset.close();

		}catch (SQLException e){
			e.printStackTrace();
		}

		return nameOfElement;
	}

	/**
	 * @author Loic
	 * @param idEntreprise
	 * @return la somme d'heures de travail de l'ensemble des employés dans une meme industrie
	 */
	public String getSommeHeureEmployeEntreprise(int idEntreprise){

		// recuperer la liste de la table selectionnee
		String requeteSelectionnee = "SELECT SUM(nb_heure) AS somme FROM employe " +
				"INNER JOIN industrie ON id_ind='"+idEntreprise+"'";

		return recupResultatRequete(requeteSelectionnee);
	}


	/**
	 * @author Loic
	 * @param idProj
	 * @return le nombre d'heures passé par tous les employés sur un même projet
	 */
	public String getSommeHeureEmployeProjet(int idProj){

		String requeteSelectionnee = "SELECT SUM(nb_heure) AS somme FROM projet " +
				"INNER JOIN intermediaire ON fk_id_projet='"+idProj+"' INNER JOIN employe ON fk_id_emp = id_emp";

		return recupResultatRequete(requeteSelectionnee);
	}

	/**
	 * @author Loic
	 * @param idEntreprise
	 * @return la moyenne d'heures travaillée par l'ensemble des employés dans une meme industrie
	 */
	public String getMoyenneHeureEmployeEntreprise(int idEntreprise){

		String requeteSelectionnee = "SELECT AVG(nb_heure) AS somme FROM employe " +
				"INNER JOIN industrie ON id_ind='"+idEntreprise+"'";

		return recupResultatRequete(requeteSelectionnee);
	}

	/**
	 * @author Loic
	 * @param idProj
	 * @return la moyenne d'heures pass�s par tous les employ�s sur un même projet
	 */
	public String getMoyenneHeureEmployeProjet(int idProj){

		// recuperer la liste de la table s�lectionn�e
		String requeteSelectionnee = "SELECT AVG(nb_heure) AS somme FROM projet " +
				"INNER JOIN intermediaire ON fk_id_projet='"+idProj+"' INNER JOIN employe ON fk_id_emp = id_emp";

		return recupResultatRequete(requeteSelectionnee);
	}
}
