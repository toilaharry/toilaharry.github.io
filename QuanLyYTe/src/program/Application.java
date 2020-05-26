package program;
import java.sql.SQLException;

import dang_nhap.Login;
import dang_nhap.Login2;
import tra_cuu.CheckInfo;
import tra_cuu.Chiso_dd;
import tra_cuu.LS_TiemChung;
import tra_cuu.TT_PhongKham;
import tra_cuu.TT_ThaiKy;
import tra_cuu.TT_VacXin;

public class Application {

	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		Login2 log = new Login2();
		log.login();
		log.setPassWord();
		log.login();
		
		//CheckInfo c = new CheckInfo();		
		//c.enterOption();
		
		/*int i = 0;
		LS_TiemChung l = new LS_TiemChung();
		l.enterOption();
		i++;
		
		Chiso_dd dd = new Chiso_dd();
		dd.enterOption();*/
		
		//TT_PhongKham tt = new TT_PhongKham();
		//tt.timKiemPK();
		
		//TT_VacXin tt2 = new TT_VacXin();
		//tt2.tracuuVX();
		//TT_ThaiKy tt3 = new TT_ThaiKy();
		//tt3.enterOption();
	}

}
