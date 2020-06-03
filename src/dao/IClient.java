package dao;

import java.util.List;

import entities.Client;

public interface IClient {
	//penta
	public void ajoutClient(Client c);
	public Client getClient(String id_c);
	public boolean login(String nom, String mdp);
	public Client getClient(String nom, String mdp);
	public List<Client> ListClient();
	public void deleteClient(int idd);
	public void editClient(Client nouveauClient);
}
