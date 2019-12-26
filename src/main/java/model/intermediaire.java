package model;

public class intermediaire {
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id=id;
  }

  public int getFK_id_emp() {
    return FK_id_emp;
  }

  public void setFK_id_emp(int FK_id_emp) {
    this.FK_id_emp=FK_id_emp;
  }

  public int getFK_id_projet() {
    return FK_id_projet;
  }

  public void setFK_id_projet(int FK_id_projet) {
    this.FK_id_projet=FK_id_projet;
  }

  private int id;
 private int FK_id_emp;
 private int FK_id_projet;

}
