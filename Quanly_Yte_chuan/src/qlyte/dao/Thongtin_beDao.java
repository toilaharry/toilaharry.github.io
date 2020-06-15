package qlyte.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import qlyte.model.Thongtin_be;

public class Thongtin_beDao {
	public List<Thongtin_be> getTT_be(int option, String cmnd) throws ClassNotFoundException, SQLException{
		List<Thongtin_be> list = new ArrayList<Thongtin_be>();
		Connection con = (new Ketnoi()).connectionInfo();
		String sql = "";
		if(option == 0) {
			sql = "select * from thongtin_be";
		}
		
		else {
			sql = "select * from thongtin_be where cmnd_me like '" + cmnd + "%'";
		}
		
		try {
			PreparedStatement prestate = con.prepareStatement(sql);
			ResultSet rs = prestate.executeQuery();
			 while(rs.next()) {
				 Thongtin_be t = new Thongtin_be();
				 t.setMa_be(rs.getString("ma_be"));
				 t.setCmnd_me(rs.getString("cmnd_me"));
				 t.setMa_bh_me(rs.getString("ma_bh_me"));
				 t.setTenbe(rs.getString("tenbe"));
				 t.setNgaysinh(rs.getString("ngaysinh"));				 
				 list.add(t);
			 }
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
}