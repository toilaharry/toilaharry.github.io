package qlyte.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import qlyte.model.Thongtin_me;
public class Thongtin_meDao {
	public List<Thongtin_me> getTT_me(int option, String cmnd) throws ClassNotFoundException, SQLException{
		List<Thongtin_me> list = new ArrayList<Thongtin_me>();
		Connection con = Ketnoi.getPostgresqlConnection();
		String sql = "";
		if(option == 1) {
			sql = "select * from quanlytt";
		}
		else {
			sql = "select * from quanlytt where cmnd like '" + cmnd + "%'";
		}
		try {
			PreparedStatement prestate = con.prepareStatement(sql);
			ResultSet rs = prestate.executeQuery();
			 while(rs.next()) {
				 Thongtin_me t = new Thongtin_me();
				 t.setHoten(rs.getString("hoten"));
				 t.setNgaysinh(rs.getString("ngaysinh"));
				 t.setCmnd(rs.getString("cmnd"));
				 t.setMa_bhyt(rs.getString("ma_bhyt"));
				 t.setSdt(rs.getString("sdt"));
				 t.setDiachi(rs.getString("diachi"));
				 
				 list.add(t);
			 }
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
}
