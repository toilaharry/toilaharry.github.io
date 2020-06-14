package qlyte.view;

import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.List;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import qlyte.model.Phong_Kham;
import qlyte.service.PhongKhamService;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import javax.swing.JScrollPane;

public class ListPKFrame extends ListFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListPKFrame window = new ListPKFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public ListPKFrame() throws ClassNotFoundException, SQLException {
		super();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	protected void initialize() throws ClassNotFoundException, SQLException {
		super.initialize();
		frame.setTitle("Thông tin phòng khám");
		nhapttLabel.setText("Khu vực muốn tìm   ");
		nhapttLabel.setToolTipText("Nhập khu vực bạn muốn tìm kiếm, ví dụ : Hoàng Mai");
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
				def.addColumn("Mã phòng khám");
				def.addColumn("Tên phòng khám");
				def.addColumn("Địa chỉ");
				def.addColumn("Số điện thoại");
				def.addColumn("Thời gian làm việc");
				PhongKhamService pkService = new PhongKhamService();
				
				try {
					List<Phong_Kham> pk = pkService.getAll_PK(2, nhapttText.getText());
					for (Phong_Kham s : pk) {
						def.addRow(new Object[] {s.getMa_pk(), s.getTen_pk(), s.getDiachi(), s.getSdt(), s.getTg_hoatdong()});
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
	
		mainTitle.setText("TRA CỨU THÔNG TIN PHÒNG KHÁM");
	}
}
