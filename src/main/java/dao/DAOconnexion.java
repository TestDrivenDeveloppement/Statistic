/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/*
 * 
 * Librairies importées
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * 
 * Connexion a votre BDD locale ou Ã  distance sur le serveur de l'ECE via le tunnel SSH
 * 
 * @author segado
 */
public final class DAOconnexion
{

	//Objet Connection
	private static Connection connect;

	/**
	 * private constructor
	 */
	private DAOconnexion()
	{
		try
		{
			Class.forName("org.sqlite.JDBC");
			// db parameters
			String url = "jdbc:sqlite:db_tdd.db";
			// create a connection to the database
			connect = DriverManager.getConnection(url);
		} catch (SQLException | ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}

	// to get only one instance connexion
	/**Initiate only one connection to the DB
	 *
	 */
	public synchronized static Connection getInstance()
	{
		if(connect == null)
		{
			new DAOconnexion();
		}
		return connect;
	}

	/**Close the connection to the DB
	 *
	 */
	public static void closeConnection()
	{
		try
		{
			connect.close();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
}
