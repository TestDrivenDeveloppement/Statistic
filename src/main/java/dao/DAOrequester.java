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
	private static Statement stmt;
	private static ResultSet rset;
	private static ResultSetMetaData rsetMeta;

	public DAOrequester(){
		try {
			stmt = DAOconnexion.getInstance().createStatement();
		}catch (SQLException e){
			e.printStackTrace();
		}
	}

	/**
	 * @param requete
	 * @return ArrayList des champs (nr id + nom de colonne) de la requete en parametre
	 */
	public static ArrayList<String> remplirChampsRequete(String requete){
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

				// Concatener les champs de la ligne separes par .
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
	public static String recupResultatRequete(String requete){
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
	public static ArrayList<Integer> listeIdTable(String table){
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
	public static String nameInTable(int id, String table){
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
	 * Afficher les lignes de la table sélectionnée
	 */
	public static void afficherLignes(String nomTable){

		ArrayList<String> liste;
		// recuperer la liste de la table sélectionnée
		String requeteSelectionnee = "select * from " + nomTable + ";";
		liste = remplirChampsRequete(requeteSelectionnee);

		// afficher les lignes de la requete selectionnee a partir de la liste

		for (String s : liste) {
			System.out.println(s);
		}

	}

}
