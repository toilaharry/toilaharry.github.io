package tra_cuu;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Tracuu {
	
	public ResultSet connectDB(String sql) throws ClassNotFoundException, SQLException {
		Connection conn = Ket_noi_DB.getPostgresqlConnection();
		Statement state = conn.createStatement();
		ResultSet rs = state.executeQuery(sql);
		return rs;
	}
	
	public void enterOption() throws ClassNotFoundException, SQLException{
		
	}
}
