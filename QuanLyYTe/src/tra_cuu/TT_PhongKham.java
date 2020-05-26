package tra_cuu;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class TT_PhongKham {
	public String diachi;
	public int count = 0;
	
	Scanner s = new Scanner(System.in);
	
	public void timKiemPK() throws ClassNotFoundException, SQLException{
		System.out.println("Ban muon tim kiem phong kham o khu vuc nao?");
		diachi = s.nextLine();
		String diachi1 = diachi.toLowerCase();
		Connection connection = Ket_noi_DB.getPostgresqlConnection();
		Statement statement = connection.createStatement();
		String sql = "select * from phongkham";
		ResultSet rs = statement.executeQuery(sql);
		
		while(rs.next()) {
			String diachi2 = rs.getString("diachi").toLowerCase();
			if(diachi2.contains(diachi1)) {
				String tenpk = rs.getString("ten_pk");
				String diachi = rs.getString("diachi");
				String sdt = rs.getString("sdt");
				String tg_hoatdong = rs.getString("tg_hoatdong");
				
				System.out.println("-------------------");
				System.out.println("Phong kham: " + tenpk);
				System.out.println("Dia chi: " + diachi);
				System.out.println("So dien thoai lien he: " + sdt);
				System.out.println("Thoi gian hoat dong: " + tg_hoatdong);
				count ++;
			}
		}
		if(count == 0) {
			System.out.println("Khong tim thay phong kham ban can!");
		}
	}
}
