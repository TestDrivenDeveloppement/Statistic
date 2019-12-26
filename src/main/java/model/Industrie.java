package model;

public class Industrie {

  private int id_ind = 0;
  private String nom_ind ="";

  public Industrie(int id_ind, String nom_ind) {
    this.id_ind = id_ind;
    this.nom_ind = nom_ind;
  }

  public Industrie(){}

  public int getId_ind() {
    return id_ind;
  }

  public String getNom_ind() {
    return nom_ind;
  }



}
