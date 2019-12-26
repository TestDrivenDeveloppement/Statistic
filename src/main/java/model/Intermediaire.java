package model;

public class Intermediaire {

  private int id = 0;
  private int FK_id_emp = 0;
  private int FK_id_projet = 0;

  public Intermediaire(int id, int FK_id_emp, int FK_id_projet) {
    this.id = id;
    this.FK_id_emp = FK_id_emp;
    this.FK_id_projet = FK_id_projet;
  }

  public int getId() {
    return id;
  }

  public int getFK_id_emp() {
    return FK_id_emp;
  }

  public int getFK_id_projet() {
    return FK_id_projet;
  }
}
