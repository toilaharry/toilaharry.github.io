package qlyte.view;

import java.sql.SQLException;
import java.util.List;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import qlyte.model.Thongtin_me;
import qlyte.service.Thongtin_meService;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import javax.swing.JScrollPane;

public class ListMomFrame extends ListFrame {
	private Thongtin_meService ttMeService;
	/**
	 * Create the application.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public ListMomFrame() throws ClassNotFoundException, SQLException {
		super();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	protected void initialize() throws ClassNotFoundException, SQLException {
		super.initialize();
		frame.setTitle("Tra cứu thông tin mẹ");
		nhapttLabel.setText("Nhập số CMND   ");
		nhapttLabel.setToolTipText("Nhập CMND để tìm kiếm");
		
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
				def.addColumn("Họ tên");
				def.addColumn("Ngày sinh");
				def.addColumn("Số CMND");
				def.addColumn("Mã BHYT");
				def.addColumn("Địa chỉ");
				def.addColumn("Số điện thoại");
				ttMeService = new Thongtin_meService();
				try {
					List<Thongtin_me> tt = ttMeService.getTT_Me(2, nhapttText.getText());
					for (Thongtin_me s : tt) {
						def.addRow(new Object[] {s.getHoten(), s.getNgaysinh(), s.getCmnd(), 
								s.getMa_bhyt(), s.getDiachi(), s.getSdt()});
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
	
		mainTitle.setText("TRA CỨU THÔNG TIN MẸ");
	}
}
