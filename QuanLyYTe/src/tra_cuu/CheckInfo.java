package tra_cuu;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class CheckInfo extends Tracuu {
	private String personal_id;
	private String health_ins_id;
	
	Scanner s = new Scanner(System.in);
	
	public void enterOption() throws ClassNotFoundException, SQLException {
		System.out.println("\nBan da chon tra cuu thong tin cua me!");
		System.out.println("Ban co tra cuu hay xem danh sach?");
		System.out.println("1 - Tra cuu, 2 - Danh sach");
		int opt = Integer.parseInt(s.nextLine());
		if(opt == 2) returnInfo("","cmnd");
		else {
			System.out.println("Ban muon tim kiem theo: 1 - CMND; 2 - Ma BHYT");
			int option;
			option = Integer.parseInt(s.nextLine());
			if(option == 1) {
				System.out.println("Nhap so CMND");
				personal_id = s.nextLine();
				returnInfo(personal_id, "cmnd");
			}
			else {
				System.out.println("Nhap ma BHYT");
				health_ins_id = s.nextLine();
				returnInfo(health_ins_id, "ma_bhyt");
			}
		}
	}
	
	private void returnInfo(String s, String column) throws SQLException, ClassNotFoundException {
		String sql = "Select hoten,ngaysinh,cmnd,ma_bhyt,diachi from quanlytt";
		ResultSet rs = connectDB(sql);	
		int count = 0;
		while(rs.next()) {
			if(rs.getString(column).contains(s)) {
				String hoten = rs.getString("hoten");
				String ngaysinh = rs.getString("ngaysinh");
				String cmnd = rs.getString("cmnd");
				String ma_bhyt = rs.getString("ma_bhyt");
				String diachi = rs.getString("diachi");
				System.out.println("-----------");
				System.out.println("Ten: " + hoten);
				System.out.println("Ngay sinh: " + ngaysinh);
				System.out.println("CMND: " + cmnd);
				System.out.println("Ma BHYT: " + ma_bhyt);
				System.out.println("Dia chi: " + diachi);
				count ++;
			}
		}
		if(count == 0) {
			System.out.println("Khong tim thay!");
		}
	}
}