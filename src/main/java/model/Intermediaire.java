package model;

public class Intermediaire {

  private int id;
  private Employe employe;
  private Projet projet;

  public Intermediaire(int id, Employe employe, Projet projet) {
    this.id = id;
    this.employe = employe;
    this.projet = projet;
  }

  public Intermediaire(){}

  public int getId() {
    return id;
  }

  public Employe getEmploye() {
    return employe;
  }

  public Projet getProjet() {
    return projet;
  }
}
