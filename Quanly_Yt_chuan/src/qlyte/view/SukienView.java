package qlyte.view;

import java.sql.SQLException;
import java.util.List;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import qlyte.model.Sukien;
import qlyte.service.SukienService;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import javax.swing.JScrollPane;

public class SukienView extends ListFrame {

	private SukienService skService;

	/**
	 * Create the application.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public SukienView() throws ClassNotFoundException, SQLException {
		super();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	protected void initialize() throws ClassNotFoundException, SQLException {
		super.initialize();
		frame.setTitle("Thông tin sự kiện");
		nhapttLabel.setVisible(false);
		nhapttText.setVisible(false);
		timkiemButton.setText("Tìm kiếm");
		timkiemButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				table = new JTable();
				table.setFillsViewportHeight(true);
				table.setCellSelectionEnabled(true);
				table.setColumnSelectionAllowed(true);
				table.setAutoCreateRowSorter(true);
				table.setFont(new Font("Calibri", Font.PLAIN, 16));
				table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
				centerPanel.add(table, BorderLayout.CENTER);
				table.setSelectionBackground(Color.WHITE);
				table.setSelectionForeground(Color.WHITE);
				table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				table.setRowHeight(25);
				table.setGridColor(Color.black);
				
				DefaultTableModel def = new DefaultTableModel();
				table.setModel(def);	
				def.addColumn("Mã sự kiện");
				def.addColumn("Nội dung");
				def.addColumn("Thời gian");
				def.addColumn("Địa điểm");
				def.addColumn("Liên hệ");
				skService = new SukienService();
				
				try {
					List<Sukien> sk = skService.getAllSuKien();
					for (Sukien s : sk) {
						def.addRow(new Object[] {s.getMask(), s.getNoidungsk(), s.getThoigian(), s.getDiadiem(), s.getLienhe()});
					}
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				centerPanel.add(table);
				table.getAutoResizeMode();
				JScrollPane jsp = new JScrollPane(table);
				frame.getContentPane().add(jsp);
			}
		});
	
		mainTitle.setText("TRA CỨU SỰ KIỆN");
	}
}
