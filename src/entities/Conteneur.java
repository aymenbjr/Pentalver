package entities;

public class Conteneur {
	
	private int id_conteneur;
	private String titre;
	private String type;
	private Double prix;
	private String description;
	private String image;
	private Double taille;
	public int getid_conteneur() {
		return id_conteneur;
	}
	
	public int getId_conteneur() {
		return id_conteneur;
	}

	public void setId_conteneur(int id_conteneur) {
		this.id_conteneur = id_conteneur;
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

	public Double getPrix() {
		return prix;
	}

	public void setPrix(Double prix) {
		this.prix = prix;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Double getTaille() {
		return taille;
	}

	public void setTaille(Double taille) {
		this.taille = taille;
	}

	@Override
	public String toString() {
		return "Conteneur [id_conteneur=" + id_conteneur + ", titre=" + titre
				+ ", type=" + type + ", prix=" + prix + ", description="
				+ description + ", image=" + image + ", taille=" + taille + "]";
	}
	public Conteneur(int id_conteneur, String titre, String type, Double prix,
			String description, String image, Double taille) {
		super();
		this.id_conteneur = id_conteneur;
		this.titre = titre;
		this.type = type;
		this.prix = prix;
		this.description = description;
		this.image = image;
		this.taille = taille;
	}
	public Conteneur(String titre, String type, Double prix,
			String description, String image, Double taille) {
		super();
		this.titre = titre;
		this.type = type;
		this.prix = prix;
		this.description = description;
		this.image = image;
		this.taille = taille;
	}
	public Conteneur() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
