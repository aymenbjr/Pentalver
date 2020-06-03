package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Conteneur;

public class ConteneurImpl implements IConteneur {

	@Override
	public Conteneur getConteneur(String id_c) {
		Conteneur v=new Conteneur();
		int id = Integer.parseInt(id_c);
		Connection conn=DBconnect.getConnection();
		try {
			PreparedStatement st=conn.prepareStatement("select * from Conteneur where id_conteneur=?");
			st.setInt(1,  id);
			ResultSet rs=st.executeQuery();
			if(rs.next()){
				v.setId_conteneur(rs.getInt("id_conteneur"));
				v.setTitre(rs.getString("titre"));
				v.setType(rs.getString("type"));
				v.setPrix(rs.getDouble("prix"));
				v.setDescription(rs.getString("description"));
				v.setImage(rs.getString("image"));
				v.setTaille(rs.getDouble("taille"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return v;
	}

	@Override
	public void addConteneur(Conteneur v) {
		Connection conn = DBconnect.getConnection();
		PreparedStatement st;
		try {
			st = conn.prepareStatement("insert into conteneur values (null,?,?,?,?,?,?)");
			st.setString(1, v.getTitre());
			st.setString(2, v.getType());
			st.setDouble(3, v.getPrix());
			st.setString(4, v.getDescription());
			st.setString(5, v.getImage());
			st.setDouble(6, v.getTaille());
			st.executeUpdate();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteConteneur(int id_c) {
		Connection conn = DBconnect.getConnection();
		PreparedStatement st;
		try{
			st = conn.prepareStatement("delete from conteneur where id_conteneur = ?");
			st.setInt(1, id_c);
			st.executeUpdate();
			st.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Conteneur> ListConteneur() {
		List<Conteneur> container= new ArrayList();
		Connection conn = DBconnect.getConnection();
		PreparedStatement st;
		try{
		st = conn.prepareStatement("select * from Conteneur");
		ResultSet rs = st.executeQuery();
		while(rs.next()){
			Conteneur v = new Conteneur();
			v.setId_conteneur(rs.getInt("id_conteneur"));
			v.setTitre(rs.getString("titre"));
			v.setType(rs.getString("type"));
			v.setPrix(rs.getDouble("prix"));
			v.setDescription(rs.getString("description"));
			v.setImage(rs.getString("image"));
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
	public List<Conteneur> ListParMC(String MC) {
		List<Conteneur> container= new ArrayList();
		Connection conn = DBconnect.getConnection();
		PreparedStatement st;
		try{
		st = conn.prepareStatement("select * from Conteneur where titre like ?");
		st.setString(1,'%' + MC + '%');
		ResultSet rs = st.executeQuery();
		while(rs.next()){
			Conteneur v = new Conteneur();
			v.setId_conteneur(rs.getInt("id_conteneur"));
			v.setTitre(rs.getString("titre"));
			v.setType(rs.getString("type"));
			v.setPrix(rs.getDouble("prix"));
			v.setDescription(rs.getString("description"));
			v.setImage(rs.getString("image"));
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
	public List<Conteneur> ListParType(String type) {
		List<Conteneur> container= new ArrayList();
		Connection conn = DBconnect.getConnection();
		PreparedStatement st;
		try{
		st = conn.prepareStatement("select * from Conteneur where type like ?");
		st.setString(1,'%' + type + '%');
		ResultSet rs = st.executeQuery();
		while(rs.next()){
			Conteneur v = new Conteneur();
			v.setId_conteneur(rs.getInt("id_conteneur"));
			v.setTitre(rs.getString("titre"));
			v.setType(rs.getString("type"));
			v.setPrix(rs.getDouble("prix"));
			v.setDescription(rs.getString("description"));
			v.setImage(rs.getString("image"));
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
	public void editConteneur(Conteneur v) {
		Connection conn=DBconnect.getConnection(); 
		try {
			PreparedStatement st=conn.prepareStatement("UPDATE Conteneur SET titre = ? , type = ? , prix = ? , description = ?, image = ? , taille = ? where id_conteneur = ?");
			st.setString(1, v.getTitre());
			st.setString(2, v.getType());
			st.setDouble(3, v.getPrix());
			st.setString(4, v.getDescription());
			st.setString(5, v.getImage());
			st.setDouble(6, v.getTaille());
			st.setInt(7, v.getid_conteneur());
			
			st.executeUpdate();
			st.close();
			}
		catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	} 
}
