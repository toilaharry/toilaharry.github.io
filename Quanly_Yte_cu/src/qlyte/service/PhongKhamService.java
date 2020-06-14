package qlyte.service;
import qlyte.model.Phong_Kham;
import qlyte.dao.PhongKhamDao;

import java.sql.SQLException;
import java.util.List;

public class PhongKhamService {
	private PhongKhamDao pkDao;
	
	public PhongKhamService() {
		pkDao = new PhongKhamDao();
	}
	
	public List<Phong_Kham> getAll_PK(int option, String diadiem) throws ClassNotFoundException, SQLException{
		return pkDao.getAll_PK(option, diadiem);
	}
}
