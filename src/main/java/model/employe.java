package model;

public class employe {


  private int id_emp;
  private  String nom;
  private String statut;
  private int nb_heure;
  private int FK_id_ind;
  private String sexe;


  public int getId_emp() {
    return id_emp;
  }

  public void setId_emp(int id_emp) {
    this.id_emp=id_emp;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom=nom;
  }

  public String getStatut() {
    return statut;
  }

  public void setStatut(String statut) {
    this.statut=statut;
  }

  public int getNb_heure() {
    return nb_heure;
  }

  public void setNb_heure(int nb_heure) {
    this.nb_heure=nb_heure;
  }

  public int getFK_id_ind() {
    return FK_id_ind;
  }

  public void setFK_id_ind(int FK_id_ind) {
    this.FK_id_ind=FK_id_ind;
  }

  public String getSexe() {
    return sexe;
  }

  public void setSexe(String sexe) {
    this.sexe=sexe;
  }

}
