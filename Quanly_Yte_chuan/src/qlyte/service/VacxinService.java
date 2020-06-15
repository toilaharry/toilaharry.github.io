package qlyte.service;
import qlyte.model.Vacxin;

import java.sql.SQLException;
import java.util.List;

import qlyte.dao.VacxinDao;

public class VacxinService {
	private VacxinDao vxDao;
	
	public VacxinService() {
		vxDao = new VacxinDao();
	}
	
	public List<Vacxin> getAllVacxin(int option, String tenvacxin) throws ClassNotFoundException, SQLException{
		return vxDao.getAllVacxin(option, tenvacxin);
	}
}
