package dao;

import java.util.List;

import entities.Commande;

public interface ICommande {
	public List<Commande> ListCommande();

	public void deleteCommande(int id_c);

	public void addCommande(String idC, String idR, String titre2,
			String desc2, String type2, Double taille2, Double prix2);

	public List<Commande> ListCommandeClient(int idU);

	public Commande getCmd(String idCmd);

	public void editCommande(Commande nouvelleCommande);

	public void editCommande(int parseInt, int parseInt2, int parseInt3,
			String nom_cl, String titre, String type, double pri, double tail);
}
