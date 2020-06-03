package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Client;
import entities.Depot;

public class ClientImpl implements IClient{
	//penta
	@Override
	public void ajoutClient(Client c) {
		Connection conn=DBconnect.getConnection();
		try {
			PreparedStatement st=conn.prepareStatement("insert into client values (null,?,?,?,?)");
			st.setString(1, c.getNom());
			st.setString(2, c.getEmail());
			st.setString(3, c.getPassword());
			st.setString(4, c.getTel());
			
			st.executeUpdate();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}
	//penta
	@Override
	public Client getClient(String id_c) {
		Client c=null;
		Connection conn=DBconnect.getConnection();
		try {
			PreparedStatement st=conn.prepareStatement("select * from Client where Id_client=?");
			st.setString(1, id_c);
			ResultSet rs=st.executeQuery();
			if(rs.next()){
				c=new Client();
				c.setId_client(rs.getInt("Id_Client"));
				c.setNom(rs.getString("Nom"));
				c.setEmail(rs.getString("Email"));
				c.setPassword(rs.getString("Password"));
				c.setTel(rs.getString("Tel"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return c;
	}
	//penta
	@Override
	public boolean login(String nom, String mdp) {
		Connection conn=DBconnect.getConnection();
		boolean b=false;
		try {
			PreparedStatement st=conn.prepareStatement("select Password from Client where nom=?");
			st.setString(1, nom);
		ResultSet rs=st.executeQuery();
		
		if(rs.next() && rs.getString("Password").equals(mdp)){
			b=true;
		}
		
	}catch (SQLException e) {
	}
		return b;
	}

	@Override
	public Client getClient(String nom, String mdp) {
		Connection conn=DBconnect.getConnection();
		Client c=new Client();
		try {
			PreparedStatement st=conn.prepareStatement("select * from Client where nom=? and Password=?");
			st.setString(1, nom);
			st.setString(2, mdp);
			ResultSet rs=st.executeQuery();
			if(rs.next()){
				c.setId_client(rs.getInt("Id_Client"));
				c.setNom(nom);
				c.setEmail(rs.getString("Email"));
				c.setPassword(mdp);
				c.setTel(rs.getString("Tel"));
			}
			st.close();
		
	}catch (SQLException e) {
		e.printStackTrace();
	}
		return c;
}

	@Override
	public List<Client> ListClient() {
		List<Client> container= new ArrayList();
		Connection conn = DBconnect.getConnection();
		PreparedStatement st;
		try{
		st = conn.prepareStatement("select * from client");
		ResultSet rs = st.executeQuery();
		while(rs.next()){
			Client v = new Client();
			v.setId_client(rs.getInt("id_client"));
			v.setNom(rs.getString("nom"));
			v.setEmail(rs.getString("email"));
			v.setPassword(rs.getString("password"));
			v.setTel(rs.getString("tel"));
			container.add(v);
		}
		st.close();
		
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return container;
	}

	@Override
	public void deleteClient(int idd) {
		Connection conn = DBconnect.getConnection();
		PreparedStatement st;
		try{
			st = conn.prepareStatement("delete from Client where id_client = ?");
			st.setInt(1, idd);
			st.executeUpdate();
			st.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void editClient(Client c) {
		Connection conn=DBconnect.getConnection();
		try {
			PreparedStatement st=conn.prepareStatement("UPDATE client SET nom = ? , email = ? , password = ? , tel = ? where id_client = ?");
			st.setString(1, c.getNom());
			st.setString(2, c.getEmail());
			st.setString(3, c.getPassword());
			st.setString(4, c.getTel());
			st.setInt(5, c.getId_client());
			
			st.executeUpdate();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}

}
