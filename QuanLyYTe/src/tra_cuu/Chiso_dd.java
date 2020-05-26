package tra_cuu;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ListIterator;

public class Chiso_dd extends Tracuu_be {
	
	public Chiso_dd() {
		loaiTraCuu = "chi so dinh duong";
	}

		@Override
		protected void showInfo(String code, String ten, String column) throws ClassNotFoundException, SQLException {
			String sql = "select t.ma_be, t.tenbe, t.cmnd_me, c.cannang, c.chieucao from chiso_dd c, thongtin_be t where c.ma_be = t.ma_be";
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
						String sql2 = "select cannang, chieucao, ngaydo from chiso_dd where ma_be = " + duyetMaBe;
						ResultSet rs2 = connectDB(sql2);
						while(rs2.next()) {
							String ngaydo = rs2.getString("ngaydo");
							Float cannang = rs2.getFloat("cannang");
							Float chieucao = rs2.getFloat("chieucao");
							System.out.println("Ngay do: " + ngaydo + ", can nang: " + cannang + " kg"+ ", chieucao: "+ chieucao + " cm");
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
		
		public String nhanXet() {
			System.out.println("Nhan xet cua ban:");
			String nhanXet = s.nextLine();
			return nhanXet;
		}
	}

