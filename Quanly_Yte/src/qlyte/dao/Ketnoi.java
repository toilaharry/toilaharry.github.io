package qlyte.dao;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class Ketnoi implements KetnoiInterface {
	
	@Override
	public Connection connectionInfo() throws SQLException {
		String hostName = "localhost";
		String dbName = "quan_ly_yte";
		String userName = "postgres";
		String password = "123456";
		return getConnection(hostName, dbName, userName, password);
	}

	@Override
	public Connection getConnection(String hostName, String dbName, String userName, String password) throws SQLException {
		String connectionURL = "jdbc:postgresql://" + hostName + ":5432/" + dbName;
		Connection con = DriverManager.getConnection(connectionURL, userName, password);
		return con;

	}
}