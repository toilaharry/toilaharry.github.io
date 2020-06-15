package qlyte.service;

import java.sql.SQLException;
import java.util.List;

import qlyte.dao.Thongtin_beDao;
import qlyte.model.Thongtin_be;

public class Thongtin_beService {
private Thongtin_beDao ttBeDao;
	
	public Thongtin_beService() {
		ttBeDao = new Thongtin_beDao();
	}
	
	public List<Thongtin_be> getTT_be(int option, String cmnd) throws ClassNotFoundException, SQLException{
		return ttBeDao.getTT_be(option, cmnd);
	}
}
