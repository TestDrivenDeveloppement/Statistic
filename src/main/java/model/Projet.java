package model;

public class Projet {

  private int id_projet;
  private String nom_projet;
  private Industrie industrie;

  public Projet(int id_projet, String nom_projet, Industrie industrie) {
    this.id_projet = id_projet;
    this.nom_projet = nom_projet;
    this.industrie = industrie;
  }

  public Projet(){}

  public int getId_projet() {
    return id_projet;
  }

  public String getNom_projet() {
    return nom_projet;
  }

  public Industrie getIndustrie() {
    return industrie;
  }
}
