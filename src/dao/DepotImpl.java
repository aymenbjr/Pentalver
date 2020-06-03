package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Conteneur;
import entities.Depot;


public class DepotImpl implements IDepot {

	@Override
	public List<Depot> ListDepot() {
		List<Depot> container= new ArrayList();
		Connection conn = DBconnect.getConnection();
		PreparedStatement st;
		try{
		st = conn.prepareStatement("select * from depot");
		ResultSet rs = st.executeQuery();
		while(rs.next()){
			Depot v = new Depot();
			v.setId_depot(rs.getInt("id_depot"));
			v.setLocation(rs.getString("location"));
			v.setCapacite(rs.getDouble("capacite"));
			container.add(v);
		}
		st.close();
		
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return container;
	}

	@Override
	public Depot getDep(String idDep) {
		Depot v=new Depot();
		int id = Integer.parseInt(idDep);
		Connection conn=DBconnect.getConnection();
		try {
			PreparedStatement st=conn.prepareStatement("select * from Depot where id_depot=?");
			st.setInt(1,  id);
			ResultSet rs=st.executeQuery();
			if(rs.next()){
				v.setId_depot(rs.getInt("id_depot"));
				v.setLocation(rs.getString("location"));
				v.setCapacite(rs.getDouble("capacite"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return v;
	}

	@Override
	public void deleteDep(int idd) {
		Connection conn = DBconnect.getConnection();
		PreparedStatement st;
		try{
			st = conn.prepareStatement("delete from depot where id_depot = ?");
			st.setInt(1, idd);
			st.executeUpdate();
			st.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void editDep(Depot c) {
		Connection conn=DBconnect.getConnection();
		try {
			PreparedStatement st=conn.prepareStatement("UPDATE depot SET location = ? , capacite = ?  where id_depot = ?");
			st.setString(1, c.getLocation());
			st.setDouble(2, c.getCapacite());
			st.setInt(3, c.getId_depot());
			
			st.executeUpdate();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}

	@Override
	public void addDep(Depot c) {
		Connection conn=DBconnect.getConnection();
		try {
			PreparedStatement st=conn.prepareStatement("insert into depot values (null,?,?)");
			st.setString(1, c.getLocation());
			st.setDouble(2, c.getCapacite());
			
			st.executeUpdate();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}

}
