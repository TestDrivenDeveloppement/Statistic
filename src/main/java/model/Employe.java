package model;

public class Employe {

  private int id_emp = 0;
  private String nom = "";
  private String statut = "";
  private int nb_heure = 0;
  private int FK_id_ind = 0;
  private String sexe = "";

  public Employe(int id_emp, String nom, String statut, int nb_heure, int FK_id_ind, String sexe) {
    this.id_emp = id_emp;
    this.nom = nom;
    this.statut = statut;
    this.nb_heure = nb_heure;
    this.FK_id_ind = FK_id_ind;
    this.sexe = sexe;
  }

  public int getId_emp() {
    return id_emp;
  }

  public String getNom() {
    return nom;
  }

  public String getStatut() {
    return statut;
  }

  public int getNb_heure() {
    return nb_heure;
  }

  public int getFK_id_ind() {
    return FK_id_ind;
  }

  public String getSexe() {
    return sexe;
  }
}
