package tra_cuu;

import java.sql.SQLException;
import java.util.Scanner;

public class Tracuu_be extends Tracuu {
	protected String ma_bh_me;
	protected String cmnd_me;
	protected String ten_be = "";
	public int count = 0;
	public String loaiTraCuu;
	
	Scanner s = new Scanner(System.in);
	
	@Override
	public void enterOption() throws ClassNotFoundException, SQLException {
		System.out.println("\nBan da chon tra cuu " + loaiTraCuu);
		System.out.println("Ban muon tra cuu hay xem danh sach?");
		System.out.println("Chon 1 - Tra cuu, 2 - Xem danh sach");
		int opt = Integer.parseInt(s.nextLine());
		if(opt == 2) showInfo("",ten_be, "cmnd_me");
		else {
			System.out.println("Ban muon tra cuu theo CMND hay BHYT ?");
			System.out.println("Chon 1 - CMND, 2 - BHYT");
			int option1 = Integer.parseInt(s.nextLine());
			System.out.println("Nhap them ten cua be?");
			System.out.println("Nhap 1 - Yes, 2 - No");
			int option2;
			option2 = Integer.parseInt(s.nextLine());
			if(option1 == 1) {
				System.out.println("Nhap so CMND");
				cmnd_me = s.nextLine();
				if(option2 == 1) {
					System.out.println("Nhap ten cua be");
					ten_be = s.nextLine();
				}
				showInfo(cmnd_me,ten_be,"cmnd_me");
			}
			
			if(option1 == 2) {
				System.out.println("Nhap ma BHYT");
				ma_bh_me = s.nextLine();
				if(option2 == 1) {
					System.out.println("Nhap ten cua be");
					ten_be = s.nextLine();
				}
				showInfo(ma_bh_me,ten_be,"ma_bh_me");
			}
		}
	}
	
	protected void showInfo(String code, String ten, String column) throws ClassNotFoundException, SQLException {
		
	}
}
