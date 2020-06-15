package qlyte.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import qlyte.model.Login;

public class LoginDao {
	public List<Login> getAll_User() throws ClassNotFoundException, SQLException{
		List<Login> log = new ArrayList<Login>();
		Connection conn = (new Ketnoi()).connectionInfo();
		String sql = "select * from login";
		
		try {
			PreparedStatement prestate = conn.prepareStatement(sql);
			ResultSet rs = prestate.executeQuery();
			
			while(rs.next()) {
				Login login = new Login();
				
				login.setUsername(rs.getString("username"));
				login.setPass(rs.getString("pass"));
				log.add(login);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return log;
	}
}
