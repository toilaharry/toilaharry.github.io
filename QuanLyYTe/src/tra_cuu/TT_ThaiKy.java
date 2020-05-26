package tra_cuu;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class TT_ThaiKy extends Tracuu {
	private String cmnd_me;
	private String bhyt_me;
	
	Scanner s = new Scanner(System.in);
	
	public void enterOption() throws ClassNotFoundException, SQLException {
		System.out.println("Ban da chon tra cuu thong tin thai ky!");
		System.out.println("Ban muon tra cuu hay xem danh sach?");
		System.out.println("Chon 1 - Tra cuu, 2 - Danh sach");
		int opt = Integer.parseInt(s.nextLine());
		if(opt == 2) ttThaiKy("cmnd", "", "cmnd_me");
		else {
			System.out.println("Chon 1 - CMND, 2 - BHYT");
			int option = Integer.parseInt(s.nextLine());
			if(option == 1) {
				System.out.println("Nhap so CMND");
				cmnd_me = s.nextLine();
				ttThaiKy("cmnd",cmnd_me,"cmnd_me");
			}
			
			if(option == 2) {
				System.out.println("Nhap ma BHYT");
				bhyt_me = s.nextLine();
				ttThaiKy("ma_bhyt",bhyt_me,"bhyt_me");
			}
		}
	}
	
	private void ttThaiKy(String column, String code, String tracuu) throws ClassNotFoundException, SQLException {
		String sql = "select ql.cmnd, ql.ma_bhyt, ql.hoten, mt.thang, mt.solan_kham from tt_mangthai mt,quanlytt ql "
				+ "where ql.cmnd = mt.cmnd_me";
		ResultSet rs = connectDB(sql);
		int count = 0;
		while(rs.next()) {
			String col = rs.getString(column);
			if(col.contains(code)) {
				String cmnd = rs.getString("cmnd");
				String hoten = rs.getString("hoten");
				String thang = rs.getString("thang");
				String solan_kham = rs.getString("solan_kham");
				System.out.println("----------------------------");
				System.out.println("Ho ten: " + hoten);
				System.out.println("CMND: " + cmnd);
				System.out.println("Thai thang thu: " + thang);
				System.out.println("Da kham thai: " + solan_kham + " lan");
				System.out.println("Da lam cac xet nghiem: ");
				String sql2 = "select xn.tenxn from thongtin_xn tt, xetnghiem xn "
								+ "where xn.maxn = tt.maxn_dalam and tt." + tracuu + " = " + "'" + col + "'";
				ResultSet rs2 = connectDB(sql2);
				while(rs2.next()) {
					System.out.println("\t-" + rs2.getString("tenxn"));
				}				
				count ++;
			}
		}
		if(count == 0) {
				System.out.println("Khong tim thay!");
		}
		
	}
}
