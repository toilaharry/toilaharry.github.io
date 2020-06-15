package qlyte.dao;

import java.sql.Connection;
import java.sql.SQLException;

public interface KetnoiInterface {
	Connection connectionInfo() throws SQLException;
	Connection getConnection(String hostName, String dbName, String userName, String password) throws SQLException;	
}
