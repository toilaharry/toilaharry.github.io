package qlyte.view;

import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.List;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import qlyte.model.Xetnghiem;
import qlyte.service.XetnghiemService;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import javax.swing.JScrollPane;

public class ListXnFrame extends ListFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListXnFrame window = new ListXnFrame();
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
	public ListXnFrame() throws ClassNotFoundException, SQLException {
		super();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	protected void initialize() throws ClassNotFoundException, SQLException {
		super.initialize();
		frame.setTitle("Thông tin các loại xét nghiệm");
		nhapttLabel.setText("Tên xét nghiệm   ");
		nhapttLabel.setToolTipText("Nhập tên xét nghiệm muốn tra cứu, ví dụ : Rubella");
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
				def.addColumn("Mã xét nghiệm");
				def.addColumn("Tên xét nghiệm");
				def.addColumn("Chi tiết");
				XetnghiemService vcService = new XetnghiemService();
				
				try {
					List<Xetnghiem> xn = vcService.getAllXetnghiem(2, nhapttText.getText());
					for (Xetnghiem x : xn) {
						def.addRow(new Object[] {x.getMaxn(), x.getTenxn(), x.getChitiet()});
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
	
		mainTitle.setText("TRA CỨU THÔNG TIN XÉT NGHIỆM");
	}
}
