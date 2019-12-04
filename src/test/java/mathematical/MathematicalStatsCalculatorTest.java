package mathematical;

import dao.DAOconnexion;
import dao.DAOrequester;
import dao.DAOverification;
import jdk.nashorn.internal.AssertsEnabled;
import menuPrincipal.Salaire;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.sql.ResultSet;
import java.sql.SQLException;


import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.junit.Before;


class MathematicalStatsCalculatorTest {

  @Mock
  private DAOconnexion dc;
  @Mock
  private DAOrequester dr;
  @Mock
  private DAOverification dv;
  @Mock
  private Salaire s;

  @Test
  void getSommeHeureEmployeEntreprise() throws SQLException, ClassNotFoundException {
    DAOrequester drq = new DAOrequester("db_tdd", "root", "");
    String requeteSelectionne = "SELECT nb_heure FROM employe INNER JOIN industrie ON id_ind='"+1+"'";
    drq.remplirChampsRequete(requeteSelectionne);

  }

  @Test
  void getSommeHeureEmployeProjet() {
  }

  @Test
  void getMoyenneHeureEmployeEntreprise() {
  }

  @Test
  void getMoyenneHeureEmployeProjet() {
  }

  @Test
  void getVarianceHeureEmployeEntreprise() {
  }

  @Test
  void getVarianceHeureEmployeProjet() {
  }

  @Test
  void getEcartTypeHeureEmployeEntreprise() {
  }

  @Test
  void getEcartTypeHeureEmployeProjet() {
  }

  @Test
  void superStatInd() {
  }
}