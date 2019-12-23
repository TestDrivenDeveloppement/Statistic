package dao;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DAOrequester{

	/**
	 * ArrayList public pour les tables
	 */
	public ArrayList<String> tables = new ArrayList<>();
	/**
	 * ArrayList public pour les requètes de sélection
	 */
	public ArrayList<String> requetes = new ArrayList<>();
	/**
	 * ArrayList public pour les requÃªtes de MAJ
	 */
	public ArrayList<String> requetesMaj = new ArrayList<>();

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
	 * Méthode qui ajoute la table en parametre dans son ArrayList
	 *
	 * @param table
	 */
	public void ajouterTable(String table) {
		tables.add(table);
	}

	/**
	 * Méthode qui ajoute la requete de selection en parametre dans son
	 * ArrayList
	 *
	 * @param requete
	 */
	public void ajouterRequete(String requete) {
		requetes.add(requete);
	}

	/**
	 * Méthode qui ajoute la requete de MAJ en parametre dans son
	 * ArrayList
	 *
	 * @param requete
	 */
	public void ajouterRequeteMaj(String requete) {
		requetesMaj.add(requete);
	}

	/**
	 * Méthode qui retourne l'ArrayList des champs de la table en parametre
	 *
	 * @param table
	 * @return
	 */
	/*public ArrayList remplirChampsTable(String table){
		// creation d'une ArrayList de String
		ArrayList<String> liste;
		liste = new ArrayList<>();

		try {
			// récupération de l'ordre de la requete
			rset = stmt.executeQuery("select * from " + table);

			// récupération du résultat de l'ordre
			rsetMeta = rset.getMetaData();

			// calcul du nombre de colonnes du resultat
			int nbColonne = rsetMeta.getColumnCount();


			String champs = "";
			// Ajouter tous les champs du resultat dans l'ArrayList
			for (int i = 0; i < nbColonne; i++) {
				champs = champs + " " + rsetMeta.getColumnLabel(i + 1);
			}

			// ajouter un "\n" Ã  la ligne des champs
			champs = champs + "\n";

			// ajouter les champs de la ligne dans l'ArrayList
			liste.add(champs);

			rset.close();

		}catch (SQLException e){
			e.printStackTrace();
		}

		// Retourner l'ArrayList
		return liste;
	} NEST JAMAIS UTILISE DONC DOIT ETRE SUPPRIMEE*/

	/**
	 * Methode qui retourne l'ArrayList des champs de la requete en parametre
	 * @param requete
	 * @return
	 */
	public ArrayList remplirChampsRequete(String requete){
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
				String champs;
				champs = rset.getString(1); // ajouter premier champ

				// Concatener les champs de la ligne separes par ,
				for (int i = 1; i < nbColonne; i++) {
					champs = champs + ". " + rset.getString(i + 1);
				}

				// ajouter un "\n" Ã  la ligne des champs
				champs = champs + "\n";

				// ajouter les champs de la ligne dans l'ArrayList
				liste.add(champs);
			}

			rset.close();

		}catch (SQLException e){
			e.printStackTrace();
		}
		// Retourner l'ArrayList
		return liste;
	}

	/** Retourne le résultat de la requÃªte unique
	 * PLUTOT METHODE QUI RETOURNE LA VALEUR D'UNE COLONNE
	 * 
	 * @author Loic
	 * @param requete
	 * @return
	 * @throws SQLException
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
	 * Renvoi la liste des ID d'une table
	 * @return 
	 * @throws java.sql.SQLException
	 * @author Loic
	 */
	public ArrayList<Integer> listeIdTable(String table) throws SQLException {
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
	 * Renvoi le nom en fonction de l'ID d'une table
	 * @return 
	 * @throws java.sql.SQLException
	 * @author Loic
	 */
	public String nameInTable(int id, String table) throws SQLException {
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
	 * Méthode qui execute une requete de MAJ en parametre
	 * @param requeteMaj
	 * @throws java.sql.SQLException
	 */
	/*public void executeUpdate(String requeteMaj) throws SQLException {
		stmt.executeUpdate(requeteMaj);
	} NEST JAMAIS UTILISE DONC DOIT ETRE SUPPRIMEE*/

}
