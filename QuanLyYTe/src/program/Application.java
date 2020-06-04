package program;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.Scanner;

import javax.swing.JFrame;

import dang_nhap.Login;
import tra_cuu.CheckInfo;
import tra_cuu.Chiso_dd;
import tra_cuu.LS_TiemChung;
import tra_cuu.TT_PhongKham;
import tra_cuu.TT_ThaiKy;
import tra_cuu.TT_VacXin;


public class Application {
	
	public static int opt;
	public static int opt2;
	
	static Scanner s = new Scanner(System.in);
	
	public static void option() {
		System.out.println("Lua chon chuc nang:");
		System.out.println("1 - Tra cuu");
		System.out.println("2 - abc");
		System.out.println("3 - Tat chuong trinh");
		opt = Integer.parseInt(s.nextLine());
		if(opt == 1) traCuu();
	}
	
	public static void traCuu() {
		try {
			System.out.println("Ban da chon chuc nang tra cuu");
			System.out.println("1 - Tra cuu thong tin ba me");
			System.out.println("2 - Tra cuu thong tin thai ky");
			System.out.println("3 - Tra cuu thong tin tiem chung ");
			System.out.println("4 - Tra cuu chi so dinh duong");
			System.out.println("5 - Tra cuu thong tin phong kham");
			System.out.println("6 - Tra cuu thong tin vacxin");
			System.out.println("7 - Exit");
			opt2 = Integer.parseInt(s.nextLine());
		}
		catch(NumberFormatException e) {
			System.out.println("Nhap sai roi\n");
			traCuu();
		}
	}
	

	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		Login log = new Login();
		log.login();
		while(true) {
			option();
			if(opt == 1) {
				if(opt2 == 1) {
					CheckInfo c = new CheckInfo();
					c.enterOption();
				}
				if(opt2 == 2) {
					TT_ThaiKy t = new TT_ThaiKy();
					t.enterOption();
				}
				if(opt2 == 3) {
					LS_TiemChung l = new LS_TiemChung();
					l.enterOption();
				}
				if(opt2 == 4) {
					Chiso_dd c = new Chiso_dd();
					c.enterOption();
					System.out.println("Ban co muon xem bang chi so dinh duong chuan?\n1 - Co, 2 - Khong");
					int opt = Integer.parseInt(s.nextLine());
					if(opt == 1) {
						Canvas canvas = new Canvas() {
							public void paint(Graphics g) {  
						        Toolkit t = Toolkit.getDefaultToolkit();  
						        Image i = t.getImage("E://cccn.jpg");  
						        g.drawImage(i, 250,10,this);  
						    }
						};
						JFrame f = new JFrame();  
					    f.add(canvas);  
					    f.setSize(400,400);  
					    f.setVisible(true); 
					    f.setLocationRelativeTo(null);
					}  
				}
				if(opt2 == 5) {
					TT_PhongKham t = new TT_PhongKham();
					t.timKiemPK();
				}
				if(opt2 == 6) {
					TT_VacXin t = new TT_VacXin();
					t.tracuuVX();
				}
				if(opt2 == 7) {
					System.out.println("Da tat chuong trinh");
					break;
				}
			}
			if(opt == 2) {
				System.out.println("hihi");
			}
			if(opt == 3) {
				System.out.println("Da tat chuong trinh");
				break;
			}
		}

	}
}