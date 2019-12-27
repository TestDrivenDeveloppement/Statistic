package model;

public class Employe {

  private int id_emp;
  private String nom;
  private String prenom;
  private String statut;
  private int nb_heure;
  private Industrie industrie;
  private String sexe;

  public Employe(int id_emp, String nom, String prenom, String statut, int nb_heure, Industrie industrie, String sexe) {
    this.id_emp = id_emp;
    this.nom = nom;
    this.prenom = prenom;
    this.statut = statut;
    this.nb_heure = nb_heure;
    this.industrie = industrie;
    this.sexe = sexe;
  }

  public Employe(){}

  public int getId_emp() {
    return id_emp;
  }

  public String getNom() {
    return nom;
  }

  public String getPrenom() {
    return prenom;
  }

  public String getStatut() {
    return statut;
  }

  public int getNb_heure() {
    return nb_heure;
  }

  public Industrie getIndustrie() {
    return industrie;
  }

  public String getSexe() {
    return sexe;
  }
}
