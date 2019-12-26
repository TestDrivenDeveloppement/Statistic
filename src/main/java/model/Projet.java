package model;

public class Projet {

  private int id_projet = 0;
  private String nom_projet = "";
  private int FK_id_ind = 0;

  public Projet(int id_projet, String nom_projet, int FK_id_ind) {
    this.id_projet = id_projet;
    this.nom_projet = nom_projet;
    this.FK_id_ind = FK_id_ind;
  }

  public int getId_projet() {
    return id_projet;
  }

  public String getNom_projet() {
    return nom_projet;
  }

  public int getFK_id_ind() {
    return FK_id_ind;
  }
}
