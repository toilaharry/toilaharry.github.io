package qlyte.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import qlyte.model.Sukien;

public class SukienDao {
	public List<Sukien> getAllSukien() throws ClassNotFoundException, SQLException{
		List<Sukien> list = new ArrayList<Sukien>();
		Connection con = (new Ketnoi()).connectionInfo();
		String sql = "select * from sukien";
		try {
			PreparedStatement prestate = con.prepareStatement(sql);
			ResultSet rs = prestate.executeQuery();
			
			while(rs.next()) {
				Sukien s = new Sukien();
				s.setMask(rs.getString("mask"));
				s.setNoidungsk(rs.getString(("noidungsk")));
				s.setThoigian(rs.getString("thoigian"));
				s.setDiadiem(rs.getString("diadiem"));
				s.setLienhe(rs.getString("lienhe"));
				
				list.add(s);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
}
