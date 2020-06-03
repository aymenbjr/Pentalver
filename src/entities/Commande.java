package entities;

public class Commande {
	private int id_commande;
	private int id_client;
	private int id_conteneur;
	private String nom_cl;
	private String titre;
	private String type;
	private double prix;
	private double taille;
	public int getId_commande() {
		return id_commande;
	}
	public void setId_commande(int id_commande) {
		this.id_commande = id_commande;
	}
	public int getId_client() {
		return id_client;
	}
	public void setId_client(int id_client) {
		this.id_client = id_client;
	}
	public int getId_conteneur() {
		return id_conteneur;
	}
	public void setId_conteneur(int id_conteneur) {
		this.id_conteneur = id_conteneur;
	}
	public String getNom_cl() {
		return nom_cl;
	}
	public void setNom_cl(String nom_cl) {
		this.nom_cl = nom_cl;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public double getTaille() {
		return taille;
	}
	public void setTaille(double taille) {
		this.taille = taille;
	}
	@Override
	public String toString() {
		return "Commande [id_commande=" + id_commande + ", id_client="
				+ id_client + ", id_conteneur=" + id_conteneur + ", nom_cl="
				+ nom_cl + ", titre=" + titre + ", type=" + type + ", prix="
				+ prix + ", taille=" + taille + "]";
	} 
	public Commande(int id_commande, int id_client, int id_conteneur,
			String nom_cl, String titre, String type, double prix, double taille) {
		super(); 
		this.id_commande = id_commande;
		this.id_client = id_client;
		this.id_conteneur = id_conteneur;
		this.nom_cl = nom_cl;
		this.titre = titre;
		this.type = type;
		this.prix = prix;
		this.taille = taille;
	}
	public Commande( int id_client, int id_conteneur,
			String nom_cl, String titre, String type, double prix, double taille) {
		super();  
		this.id_client = id_client;
		this.id_conteneur = id_conteneur;
		this.nom_cl = nom_cl;
		this.titre = titre;
		this.type = type;
		this.prix = prix;
		this.taille = taille;
	}
	public Commande() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	


}
