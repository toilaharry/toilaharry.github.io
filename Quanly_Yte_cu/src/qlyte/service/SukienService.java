package qlyte.service;

import java.sql.SQLException;
import java.util.List;

import qlyte.dao.SukienDao;
import qlyte.model.Sukien;

public class SukienService {
	private SukienDao sukienDao;
	public SukienService() {
		sukienDao = new SukienDao();
	}
	
	public List<Sukien> getAllSuKien() throws ClassNotFoundException, SQLException{
		return sukienDao.getAllSukien();
	}
}
