package qlyte.service;
import qlyte.model.Thongtin_me;

import java.sql.SQLException;
import java.util.List;

import qlyte.dao.Thongtin_meDao;

public class Thongtin_meService {
	private Thongtin_meDao ttMeDao;
	
	public Thongtin_meService() {
		ttMeDao = new Thongtin_meDao();
	}
	
	public List<Thongtin_me> getTT_Me(int option, String cmnd) throws ClassNotFoundException, SQLException{
		return ttMeDao.getTT_me(option, cmnd);
	}
	
}
