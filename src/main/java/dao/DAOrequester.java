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
	public ArrayList remplirChampsTable(String table){
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
	}

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
					champs = champs + "," + rset.getString(i + 1);
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
	 * Methode qui compte le nombre d'élèments dans une table de la BDD
	 * @return 
	 * @throws java.sql.SQLException
	 * @author Loic
	 */
	public int countElementInDB(String table){
		int number=0;

		try {
			// récupération de l'ordre de la requete
			switch(table) {
				case "industrie":
					rset = stmt.executeQuery("SELECT COUNT(id_ind) FROM (industrie)");
					System.out.println("OK");
					break;

				case "projet":
					rset = stmt.executeQuery("SELECT COUNT(id_projet) FROM (projet)");
					System.out.println("OK");
					break;

				case "employe":
					rset = stmt.executeQuery("SELECT COUNT(id_emp )FROM employe");
					System.out.println("OK");
					break;

				default:
					break;
			}
			// récupération du résultat de l'ordre
			rsetMeta = rset.getMetaData();

			rset.next();
			number= rset.getInt(1);

			rset.close();

		}catch (SQLException e){
			e.printStackTrace();
		}

		// Retourner l'ArrayList
		return number;
	}

	/**
	 * Methode qui compte le nombre d'élèments dans une table de la BDD
	 * @return 
	 * @throws java.sql.SQLException
	 * @author Loic
	 */
	public int countElementInDBWithCond(String table){
		int number=0;

		try {


			// récupération de l'ordre de la requete
			switch(table) {

				case "industrie":
					rset = stmt.executeQuery("SELECT COUNT(id_ind) FROM (industrie)");
					System.out.println("OK");
					break;

				case "projet":
					rset = stmt.executeQuery("SELECT COUNT(id_projet) FROM (projet)");
					System.out.println("OK");
					break;

				case "employe":
					rset = stmt.executeQuery("SELECT COUNT(id_emp )FROM employe");
					System.out.println("OK");
					break;

				default:
					break;
			}
			// récupération du résultat de l'ordre
			rsetMeta = rset.getMetaData();

			rset.next();
			number= rset.getInt(1);

			rset.close();

		}catch (SQLException e){
			e.printStackTrace();
		}

		// Retourner l'ArrayList
		return number;
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
			switch(table) {
				case "industrie":
					rset = stmt.executeQuery("SELECT id_ind FROM industrie");
					break;

				case "projet":
					rset = stmt.executeQuery("SELECT id_projet FROM (projet)");
					break;

				case "employe":
					rset = stmt.executeQuery("SELECT id_emp FROM employe");
					break;

				default:
					break;
			}
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
			switch(table) {
				case "industrie":
					rset = stmt.executeQuery("SELECT nom_ind FROM industrie WHERE id_ind="+id);
					break;

				case "projet":
					rset = stmt.executeQuery("SELECT nom_projet FROM (projet) WHERE id_projet="+id);
					break;

				case "employe":
					rset = stmt.executeQuery("SELECT nom FROM employe where id_emp="+id);
					break;

				default:
					break;
			}
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
	public void executeUpdate(String requeteMaj) throws SQLException {
		stmt.executeUpdate(requeteMaj);
	}

}
