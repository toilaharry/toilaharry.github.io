package qlyte.service;
import qlyte.model.Xetnghiem;

import java.sql.SQLException;
import java.util.List;

import qlyte.dao.XetnghiemDao;

public class XetnghiemService {
	private XetnghiemDao xnDao;
	
	public XetnghiemService() {
		xnDao = new XetnghiemDao();
	}
	
	public List<Xetnghiem> getAllXetnghiem(int option, String tenxetnghiem) throws ClassNotFoundException, SQLException{
		return xnDao.getAllXetnghiem(option, tenxetnghiem);
	}
}
