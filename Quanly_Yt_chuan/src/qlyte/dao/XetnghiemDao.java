package qlyte.dao;
import qlyte.model.Xetnghiem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class XetnghiemDao {
	public List<Xetnghiem> getAllXetnghiem(int option, String tenxetnghiem) throws ClassNotFoundException, SQLException{
		List<Xetnghiem> list = new ArrayList<Xetnghiem>();
		Connection con = Ketnoi.getPostgresqlConnection();
		String sql = "";
		if(option == 0) {
			sql = "select * from xetnghiem";
		}
		
		else {
			sql = "select * from xetnghiem where lower(tenxn) like '%" + tenxetnghiem.toLowerCase() + "%'";
		}
		
		try {
			PreparedStatement prestate = con.prepareStatement(sql);
			ResultSet rs = prestate.executeQuery();
			
			while(rs.next()) {
				Xetnghiem v = new Xetnghiem();
				v.setMaxn(rs.getString("maxn"));
				v.setTenxn(rs.getString("tenxn"));
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
