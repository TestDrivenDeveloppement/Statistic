package mathematical;

import java.util.ArrayList;
import model.Employe;
import model.Intermediaire;

public class MathematicalStatsCalculator
{
    /**
	 * @author Kolawole
	 * @param idIndustrie
	 * @return la somme d'heures travaille par l'ensemble des employs dans une industrie
	 */
	public int getSomHeureEmpInd(int idIndustrie, ArrayList<Employe> employeList)
	{

		int somme = 0;
		for (Employe employe: employeList)
		{
			if (employe.getIndustrie().getId_ind() == idIndustrie)
			{
				somme += employe.getNb_heure();
			}
		}

		return somme;
	}


	/**
	 * @author Kolawole
	 * @param idProjet
	 * @return le nombre d'heures passes par tous les employes sur un même projet
	 */
	public int getSomHeureEmpPro(int idProjet, ArrayList<Intermediaire> intermediaireList)
	{
		int somme = 0;

		for (Intermediaire intermediaire : intermediaireList)
		{
			if (intermediaire.getProjet().getId_projet() == idProjet)
			{
				somme += intermediaire.getEmploye().getNb_heure();
			}
		}

		return somme;
	}

	/**
	 * @author Kolawole
	 * @param id
	 * @return la moyenne d'heures travaill�e par l'ensemble des employ�s dans une industrie
	 */
	public double getMoyHeureEmpInd(int id, ArrayList<Employe> employeList)
	{

		int total = 0;
		double moyenne = 0;
		for (Employe employe: employeList)
		{
			if (employe.getIndustrie().getId_ind() == id)
			{
				moyenne += employe.getNb_heure();
				total++;
			}
		}

		moyenne = moyenne/total;

		return moyenne;
	}

	/**
	 * @author Kolawole
	 * @param idProjet
	 * @return la moyenne d'heures pass�s par tous les employ�s sur un même projet
	 */
	public double getMoyHeureEmpPro(int idProjet, ArrayList<Intermediaire> intermediaireList)
	{

		int total = 0;
		double moyenne = 0;
		for (Intermediaire intermediaire : intermediaireList)
		{
			if (intermediaire.getProjet().getId_projet() == idProjet)
			{
				moyenne += intermediaire.getEmploye().getNb_heure();
				total++;
			}
		}

		moyenne = moyenne/total;

		return moyenne;
	}

	/**
	 * @author Kolawole
	 * @param idIndustrie
	 * @return la variance d'heures travaill�es par l'ensemble des employ�s dans une industrie
	 */
	public double getVarianceHeureEmpInd(int idIndustrie, ArrayList<Employe> employeList)
	{
		double variance = 0;
		int total = 0;
		for (Employe employe: employeList)
		{
			if (employe.getIndustrie().getId_ind() == idIndustrie)
			{
				variance += Math.pow(employe.getNb_heure() - getMoyHeureEmpInd(idIndustrie, employeList), 2);
				total++;
			}
		}
		variance = variance / total;

		return variance;
	}


	/**
	 * @author Kolawole
	 * @param idProjet
	 * @return la variance d'heures travaill�es par l'ensemble des employ�s sur un projet
	 */
	public double getVarianceHeureEmpPro(int idProjet, ArrayList<Intermediaire> intermediaireList)
	{

		int total = 0;
		double variance = 0;
		for (Intermediaire intermediaire : intermediaireList)
		{
			if (intermediaire.getProjet().getId_projet() == idProjet)
			{
				variance += Math.pow(intermediaire.getEmploye().getNb_heure() -
						getMoyHeureEmpPro(idProjet, intermediaireList), 2);
				total++;
			}
		}

		variance = variance / total;

		return variance;
	}

	/**
	 * @author Kolawole
	 * @param idIndustrie
	 * @return l'ecart type d'heures travaillees par l'ensemble des employes dans une industrie
	 */
	public double getEcartTypeHeureEmpInd(int idIndustrie, ArrayList<Employe> employeList)
	{
		double ecarType = 0;

		ecarType = Math.sqrt(getVarianceHeureEmpInd(idIndustrie, employeList));

		return ecarType;
	}

	/**
	 * @author Kolawole
	 * @param inProjet
	 * @return l'ecart type d'heures travaillees par l'ensemble des employes sur un projet
	 */
	public double getEcartTypeHeureEmpPro(int inProjet, ArrayList<Intermediaire> intermediaireList)
	{
		double ecarType = 0;

		ecarType = Math.sqrt(getVarianceHeureEmpPro(inProjet, intermediaireList));

		return ecarType;
	}
}
