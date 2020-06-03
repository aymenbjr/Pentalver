package dao;

import java.util.List;

import entities.Depot;

public interface IDepot {

	public List<Depot> ListDepot();
	public Depot getDep(String idDep);
	public void deleteDep(int idd);
	public void editDep(Depot nouveauDepot);
	public void addDep(Depot nouveauDepot);

}
