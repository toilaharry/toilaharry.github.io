package qlyte.view;

import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import qlyte.model.Thongtin_be;
import qlyte.service.Thongtin_beService;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
public class ListChildFrame extends ListFrame {

	private JFrame frame;
	private JTextField nhapcmnd;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListChildFrame window = new ListChildFrame();
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
	public ListChildFrame() throws ClassNotFoundException, SQLException {
		super();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	protected void initialize() throws ClassNotFoundException, SQLException {
		super.initialize();
		frame.setTitle("Tra cứu thông tin bé");
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
				def.addColumn("Mã bé");
				def.addColumn("Tên bé");
				def.addColumn("Ngày sinh");
				def.addColumn("CMND mẹ");
				def.addColumn("Mã BHYT của mẹ");
				Thongtin_beService ttBeService = new Thongtin_beService();
				try {
					List<Thongtin_be> tt = ttBeService.getTT_be(2, nhapcmnd.getText());
					for (Thongtin_be s : tt) {
						def.addRow(new Object[] {s.getMa_be(), s.getTenbe(), s.getNgaysinh(), 
								s.getCmnd_me(), s.getMa_bh_me()});
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
	
		mainTitle.setText("TRA CỨU THÔNG TIN BÉ");
	}
}
