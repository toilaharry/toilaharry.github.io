package dang_nhap;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import tra_cuu.Ket_noi_DB;

public class Login2 {
	
	private String username;
	private String password;
	
	Scanner s = new Scanner(System.in);

	private boolean user_pass() throws ClassNotFoundException, SQLException {
		Connection connection = Ket_noi_DB.getPostgresqlConnection();
		Statement statement = connection.createStatement();
		String sql = "select * from login";
		ResultSet rs = statement.executeQuery(sql);
		
		while(rs.next()) {
			if(rs.getString("username").compareTo(username) == 0 && rs.getString("pass").compareTo(password) == 0) {
				return true;
			}
		}
		return false;
	}
	
	public void setPassWord() throws ClassNotFoundException, SQLException {
		System.out.println("Moi ban doi mat khau!");
		System.out.println("Mat khau moi:");
		password = s.nextLine();
		Connection connection = Ket_noi_DB.getPostgresqlConnection();
		Statement statement = connection.createStatement();
		String sql = "update login set pass = " + "'" + password + "'" + "where username = " + "'" + username + "'";
		statement.execute(sql);
		
		System.out.println("Ban da doi thanh cong!");
		System.out.println("Moi ban dang nhap lai!");
	}
	
	
	public void login() throws ClassNotFoundException, SQLException {
		System.out.println("Ten dang nhap:");
		username = s.nextLine();
		System.out.println("Nhap mat khau:");
		password = s.nextLine();
		
		while (! user_pass()) {
			System.out.println("Ban da nhap sai ten dang nhap hoac mat khau!");
			System.out.println("Moi ban nhap lai!");
			System.out.println("Ten dang nhap:");
			username = s.nextLine();
			System.out.println("Nhap mat khau:");
			password = s.nextLine();
		} 
		System.out.println("Ban da dang nhap thanh cong!");
	}
}

