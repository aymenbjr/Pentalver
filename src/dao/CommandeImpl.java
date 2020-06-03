package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Commande; 
import entities.Commande;

public class CommandeImpl implements ICommande {

	@Override
	public List<Commande> ListCommande() {
		List<Commande> container= new ArrayList();
		Connection conn = DBconnect.getConnection();
		PreparedStatement st;
		try{
		st = conn.prepareStatement("select * from Commande");
		ResultSet rs = st.executeQuery();
		while(rs.next()){
			Commande v = new Commande();
			v.setId_commande(rs.getInt("id_commande"));
			v.setId_client(rs.getInt("id_client"));
			v.setId_conteneur(rs.getInt("id_conteneur"));
			v.setNom_cl(rs.getString("nom_cl")); 
			v.setTitre(rs.getString("titre"));
			v.setType(rs.getString("type"));
			v.setPrix(rs.getDouble("prix"));
			v.setTaille(rs.getDouble("taille"));
			container.add(v);
		}
		st.close();
		
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return container;
	}

	@Override
	public void deleteCommande(int id_c) {
		Connection conn = DBconnect.getConnection();
		PreparedStatement st;
		try{
			st = conn.prepareStatement("delete from Commande where id_commande = ?");
			st.setInt(1, id_c);
			st.executeUpdate();
			st.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void addCommande(String idC, String idR,String nom_cl, String titre2,
			 String type2, Double prix2, Double taille2) {
		Connection conn=DBconnect.getConnection();
		int idc=Integer.parseInt(idC);
		int idu=Integer.parseInt(idR);
		try {
			PreparedStatement st=conn.prepareStatement("insert into commande values (null,?,?,?,?,?,?,?)");
			st.setInt(1, idu);
			st.setInt(2, idc);
			st.setString(3, nom_cl);
			st.setString(4, titre2);
			st.setString(5, type2);
			st.setDouble(6, prix2);
			st.setDouble(7, taille2);
			
			st.executeUpdate();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}

	@Override
	public List<Commande> ListCommandeClient(int idU) {
		List<Commande> container= new ArrayList();
		Connection conn = DBconnect.getConnection();
		PreparedStatement st;
		try{
		st = conn.prepareStatement("select * from Commande where id_client = ?");
		st.setInt(1, idU);
		ResultSet rs = st.executeQuery();
		while(rs.next()){
			Commande v = new Commande();
			v.setId_commande(rs.getInt("id_commande"));
			v.setId_client(rs.getInt("id_client"));
			v.setId_conteneur(rs.getInt("id_conteneur"));
			v.setNom_cl(rs.getString("nom_cl")); 
			v.setTitre(rs.getString("titre"));
			v.setType(rs.getString("type"));
			v.setPrix(rs.getDouble("prix"));
			v.setTaille(rs.getDouble("taille"));
			container.add(v);
		}
		st.close();
		
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return container;
	}

	@Override
	public Commande getCmd(String idCmd) {
		Commande v=new Commande();
		int id = Integer.parseInt(idCmd);
		Connection conn=DBconnect.getConnection();
		try {
			PreparedStatement st=conn.prepareStatement("select * from Commande where id_commande=?");
			st.setInt(1,  id);
			ResultSet rs=st.executeQuery();
			if(rs.next()){ 
				v.setId_commande(rs.getInt("id_commande"));
				v.setId_client(rs.getInt("id_client"));
				v.setId_conteneur(rs.getInt("id_conteneur"));
				v.setNom_cl(rs.getString("nom_cl")); 
				v.setTitre(rs.getString("titre"));
				v.setType(rs.getString("type"));
				v.setPrix(rs.getDouble("prix"));
				v.setTaille(rs.getDouble("taille")); 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return v;
	}

	@Override
	public void editCommande(Commande v) {
		Connection conn=DBconnect.getConnection(); 
		try {
			PreparedStatement st=conn.prepareStatement("UPDATE Commande SET id_client = ? , id_conteneur = ? , nom_cl = ? , titre = ?, type = ? ,prix = ? , taille = ? where id_commande = ?");
			st.setInt(1, v.getId_client());
			st.setInt(2, v.getId_conteneur());
			st.setString(3, v.getNom_cl());
			st.setString(4, v.getTitre());
			st.setString(5, v.getType());
			st.setDouble(6, v.getPrix());
			st.setDouble(7, v.getTaille());
			st.setInt(8, v.getId_commande());
			
			st.executeUpdate();
			st.close();
			}
		catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	@Override
	public void editCommande(int parseInt, int parseInt2, int parseInt3,
			String nom_cl, String titre, String type, double pri, double tail) {
		Connection conn=DBconnect.getConnection(); 
		try {
			PreparedStatement st=conn.prepareStatement("UPDATE Commande SET id_client = ? , id_conteneur = ? , nom_cl = ? , titre = ?, type = ? ,prix = ? , taille = ? where id_commande = ?");
			st.setInt(1, parseInt2);
			st.setInt(2, parseInt3);
			st.setString(3, nom_cl);
			st.setString(4, titre);
			st.setString(5, type);
			st.setDouble(6, pri);
			st.setDouble(7, tail);
			st.setInt(8, parseInt);
			
			st.executeUpdate();
			st.close();
			}
		catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

}
