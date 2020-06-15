package qlyte.dao;
import qlyte.model.Phong_Kham;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PhongKhamDao {
	public List<Phong_Kham> getAll_PK(int option, String diadiem) throws ClassNotFoundException, SQLException{
		List<Phong_Kham> phongkham = new ArrayList<Phong_Kham>();
		Connection conn = (new Ketnoi()).connectionInfo();
		String sql = "";
		if(option == 0) {
			sql = "Select * from phongkham";
		}
		else {
			sql = "select * from phongkham where lower (diachi) like '%" + diadiem.toLowerCase() + "%'";
		}
		
		try {
			PreparedStatement prestate = conn.prepareStatement(sql);
			ResultSet rs = prestate.executeQuery();
			
			while(rs.next()) {
				Phong_Kham pk = new Phong_Kham();
				
				pk.setMa_pk(rs.getString("ma_pk"));
				pk.setTen_pk(rs.getString("ten_pk"));
				pk.setDiachi(rs.getString("diachi"));
				pk.setSdt(rs.getString("sdt"));
				pk.setTg_hoatdong(rs.getString("tg_hoatdong"));
				phongkham.add(pk);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return phongkham;
	}
}
