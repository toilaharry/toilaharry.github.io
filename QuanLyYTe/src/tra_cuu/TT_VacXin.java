package tra_cuu;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class TT_VacXin {
	public String ten_vacxin;
	public int count = 0;
	
	Scanner s = new Scanner(System.in);
	
	public void tracuuVX() throws ClassNotFoundException, SQLException{
		Connection conn = Ket_noi_DB.getPostgresqlConnection();
		Statement state = conn.createStatement();
		String sql = "select * from vacxin";
		ResultSet rs = state.executeQuery(sql);
		
		System.out.println("Ten vacxin muon tim:");
		ten_vacxin = s.nextLine();
		String tenVX1 = ten_vacxin.toLowerCase();
		
		while(rs.next()) {
			String tenVX2 = rs.getString("ten_vacxin").toLowerCase();
			if(tenVX2.contains(tenVX1)) {
				String tenVX = rs.getString("ten_vacxin");
				String chitiet = rs.getString("chitiet");
				System.out.println("Ten vacxin: " + tenVX);
				System.out.println("Thong tin chi tiet: " + chitiet);
				count ++;
			}
		}
		if(count == 0) {
			System.out.println("Khong tim thay vacxin ban can!");
		}
	}
	
}
