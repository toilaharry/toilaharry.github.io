package tra_cuu;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Truy_van {
	public static void main(String[] args) throws ClassNotFoundException,
    SQLException {
		Connection connection = Ket_noi_DB.getPostgresqlConnection();
		Statement statement = connection.createStatement();
		String sql = "Select hoten,cmnd,ma_bhyt from quanlytt";
		ResultSet rs = statement.executeQuery(sql);
		
		while(rs.next()) {
			String hoten = rs.getString(1);
			String cmnd = rs.getString(2);
			String ma_bhyt = rs.getString(3);
			System.out.println("-----------");
			System.out.println("Ten: " + hoten);
			System.out.println("CMND: " + cmnd);
			System.out.println("Ma BHYT: " + ma_bhyt);
		}
		connection.close();
	}
}
