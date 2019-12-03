package dao;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class DAOverification{

	/**
	 * Attributs prives : connexion JDBC, statement, ordre requete et resultat
	 * requete
	 */
	private Statement stmt;
	private ResultSet rset;
	private ResultSetMetaData rsetMeta;

	public DAOverification() {
		try {
			stmt = DAOconnexion.getInstance().createStatement();
		}catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	 /**
     * Methode qui verifie l'integrité de l'id en entrée pour la table donnée
     * @return
     * @author Loic
     */
	public boolean verifValiditeID(int id, String table){
    	boolean validity=false;
    	
    	try {
			// récupération de l'ordre de la requete
			switch(table) {

				case "industrie":
				rset = stmt.executeQuery("SELECT id_ind FROM industrie");
				break;

				case "projet":
				rset = stmt.executeQuery("SELECT id_projet FROM projet");
				break;

				case "employe":
				rset = stmt.executeQuery("SELECT id_emp FROM employe");
				break;
			}
			// récupération du résultat de l'ordre
			rsetMeta = rset.getMetaData();


			// tant qu'il reste une ligne
			while (rset.next()) {

				if(Integer.parseInt(rset.getString(1))==id) {
					validity=true;
				}
			}

			if(!validity) {
				System.out.println("Erreur, veuillez entrer un id valide.");
			}

			rset.close();

    	}catch (SQLException e){
    		e.printStackTrace();
		}

		// Retourner l'ArrayList
		return validity;
	}
	
	/**
     * Methode qui verifie l'integrité de l'id en entrée pour la table donnée
     * @return 
     * @throws java.sql.SQLException
     * @author Loic
     */
    public boolean verifDataInDB(int id, String table) throws SQLException {

    	boolean validity=false;

        // récupération de l'ordre de la requete
    	try {
			switch(table) {
				case "industrie":
				rset = stmt.executeQuery("SELECT id_emp FROM (employe)"
						+ "WHERE (FK_id_ind="+id+");");
				break;

				case "projet":
				rset = stmt.executeQuery("SELECT fk_id_projet FROM intermediaire "
						+ "WHERE fk_id_projet="+id+";");
				break;

				case "employe":
				rset = stmt.executeQuery("SELECT id_emp FROM employe WHERE id_emp="+id+";");
				break;

			}
			// récupération du résultat de l'ordre
			rsetMeta = rset.getMetaData();


			// tant qu'il reste une ligne
			if(rset.next()) {

				return true;
			} else {
				System.out.println("Erreur veuillez entrer des valeurs dans la BDD.");
			}

			rset.close();

    	}catch (SQLException e){
        	e.printStackTrace();
    	}

		// Retourner l'ArrayList
		return validity;
    }

}
