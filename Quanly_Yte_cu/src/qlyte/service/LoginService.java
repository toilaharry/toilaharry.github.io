package qlyte.service;

import java.sql.SQLException;
import java.util.List;

import qlyte.dao.LoginDao;
import qlyte.model.Login;

public class LoginService {
	private LoginDao loginDao;
	public LoginService() {
		loginDao = new LoginDao();
	}
	
	public List<Login> getAll_User() throws ClassNotFoundException, SQLException{
		return loginDao.getAll_User();
	}
}
