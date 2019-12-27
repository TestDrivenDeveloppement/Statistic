package daorefactoring;

import dao.DAOconnexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

public abstract class Dao<T> {

    protected Connection connect = null;

    public Dao(Connection conn){
        this.connect = conn;
    }

    /**
     * Méthode de recherche des informations
     * @param id
     * @return T
     */
    public abstract T find(int id);

    /**
     * Méthode de recherche des informations
     * @return T
     */
    public abstract ArrayList<T> findAll();

    /**
     * Afficher les lignes de la table sélectionnée
     */
    public static void afficheTable(String table){

        // creation d'une ArrayList de String
        ArrayList<String> champList;
        champList = new ArrayList<String>();

        try {
            // récupération de l'ordre de la requete
            ResultSet rset = DAOconnexion.getInstance().createStatement().
                    executeQuery("select * from " + table);

            // récupération du résultat de l'ordre
            ResultSetMetaData rsetMeta = rset.getMetaData();

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

                // ajouter les champs de la ligne dans l'ArrayList
                champList.add(champs.toString());
            }
            rset.close();

        }catch (SQLException e){
            e.printStackTrace();
        }

        // afficher les lignes de la requete selectionnee a partir de la liste
        for (String champ : champList) {
            System.out.println(champ);
        }
    }
}
