package qlyte.dao;
import qlyte.model.Vacxin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VacxinDao {
	public List<Vacxin> getAllVacxin(int option, String tenvacxin) throws ClassNotFoundException, SQLException{
		List<Vacxin> list = new ArrayList<Vacxin>();
		Connection con = Ketnoi.getPostgresqlConnection();
		String sql = "";
		if(option == 0) {
			sql = "select * from vacxin";
		}
		else {
			sql = "select * from vacxin where lower(ten_vacxin) like '%" + tenvacxin.toLowerCase() + "%'";
		}
		
		try {
			PreparedStatement prestate = con.prepareStatement(sql);
			ResultSet rs = prestate.executeQuery();
			
			while(rs.next()) {
				Vacxin v = new Vacxin();
				v.setMa_vacxin(rs.getString("ma_vacxin"));
				v.setTen_vacxin(rs.getString("ten_vacxin"));
				v.setChitiet(rs.getString("chitiet"));
				
				list.add(v);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
