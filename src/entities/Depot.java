package entities;

public class Depot {
	private int id_depot;
	private String location;
	private Double capacite;
	public int getId_depot() {
		return id_depot;
	}
	public void setId_depot(int id_depot) {
		this.id_depot = id_depot;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Double getCapacite() {
		return capacite;
	}
	public void setCapacite(Double capacite) {
		this.capacite = capacite;
	}
	@Override
	public String toString() {
		return "Depot [id_depot=" + id_depot + ", location=" + location
				+ ", capacite=" + capacite + "]";
	}
	public Depot(int id_depot, String location, Double capacite) {
		super();
		this.id_depot = id_depot;
		this.location = location;
		this.capacite = capacite;
	}
	
	public Depot(String location, Double capacite) {
		super();
		this.location = location;
		this.capacite = capacite;
	}
	public Depot() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
