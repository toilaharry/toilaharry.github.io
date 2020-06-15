package qlyte.dao;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class Ketnoi {
	
	public static Connection getPostgresqlConnection() throws SQLException,	ClassNotFoundException{
		String hostName = "localhost";
		String dbName = "quan_ly_yte";
		String userName = "postgres";
		String password = "123456";
		return getPostgresqlConnection(hostName, dbName, userName, password);
	}
	
	public static Connection getPostgresqlConnection(String hostName, String dbName,
		String userName, String password) throws SQLException, ClassNotFoundException{
		String connectionURL = "jdbc:postgresql://" + hostName + ":5432/" + dbName;
		Connection con = DriverManager.getConnection(connectionURL, userName, password);
		return con;
	}
}
