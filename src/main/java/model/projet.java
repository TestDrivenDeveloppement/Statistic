package model;

public class projet {


  private int id_projet;
  private String nom_projet;
  private int FK_id_ind;

  public int getId_projet() {
    return id_projet;
  }

  public void setId_projet(int id_projet) {
    this.id_projet=id_projet;
  }

  public String getNom_projet() {
    return nom_projet;
  }

  public void setNom_projet(String nom_projet) {
    this.nom_projet=nom_projet;
  }

  public int getFK_id_ind() {
    return FK_id_ind;
  }

  public void setFK_id_ind(int FK_id_ind) {
    this.FK_id_ind=FK_id_ind;
  }

}
