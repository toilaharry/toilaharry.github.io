package tra_cuu;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ListIterator;


public class LS_TiemChung extends Tracuu_be {
	
	public LS_TiemChung() {
		loaiTraCuu = "lich su tiem chung";
	}
	
	@Override
	protected void showInfo(String code, String ten, String column) throws ClassNotFoundException, SQLException {
		String sql = "select t.ma_be, t.cmnd_me, t.ma_bh_me, t.tenbe"
				+ " from thongtin_be t, tiemchung tc, vacxin v where tc.ma_vacxin = v.ma_vacxin"
				+ " and t.ma_be = tc.ma_be";
		ResultSet rs = connectDB(sql);
		ArrayList<Integer> ma_be = new ArrayList<Integer>();
		while(rs.next()) {
			int duyetMaBe = rs.getInt("ma_be");
			ListIterator<Integer> iterator = ma_be.listIterator();
			int dem = 0;
			while(iterator.hasNext()) {
				if(duyetMaBe == iterator.next()) dem ++;
			}
			if(dem != 0) continue;
			else {
				ma_be.add(duyetMaBe);
				String tenbe1 = rs.getString("tenbe").toLowerCase();
				String tenbe2 = ten.toLowerCase();
				if(rs.getString(column).contains(code) && tenbe1.contains(tenbe2)) {
					String cmnd = rs.getString("cmnd_me");
					String tenbe = rs.getString("tenbe");
					System.out.println("Be ten la: " + tenbe);
					System.out.println("CMND cua me: " + cmnd);
					String sql2 = "select v.ten_vacxin, tc.ngaytiem from tiemchung tc, vacxin v where tc.ma_vacxin = v.ma_vacxin and ma_be = " + duyetMaBe;
					ResultSet rs2 = connectDB(sql2);
					int i = 0;
					while(rs2.next()) {
						System.out.println("Vacxin " + (i + 1) + ": " + rs2.getString("ten_vacxin") + ", tiem ngay: " + rs2.getString("ngaytiem"));
						i ++;
					}
					rs2.close();
					System.out.println("-----------------");
					count ++;
				}
			}
		}
		rs.close();
			
		if(count == 0) {
			System.out.println("Khong tim thay!");
		}
	}
}
