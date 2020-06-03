package dao;

import java.util.List;

import entities.Conteneur;

public interface IConteneur {
	
	public Conteneur getConteneur(String id_c);
	public void addConteneur(Conteneur v);
	public void editConteneur(Conteneur v);
	public void deleteConteneur(int id_c);
	public List<Conteneur> ListConteneur();
	public List<Conteneur> ListParMC(String MC);
	List<Conteneur> ListParType(String type);  

}
