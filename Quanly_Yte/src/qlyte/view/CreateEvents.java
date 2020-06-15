package qlyte.view;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;

import qlyte.dao.Ketnoi;

import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.Color;

public class CreateEvents {

	private JFrame frame;
	private JTextField noidungText;
	private JTextField thoigianText;
	private JTextField diadiemText;
	private JTextField lienheText;


	/**
	 * Create the application.
	 */
	public CreateEvents() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 587, 310);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel topPanel = new JPanel();
		frame.getContentPane().add(topPanel, BorderLayout.NORTH);
		
		JLabel mainTitle = new JLabel("SỰ KIỆN MỚI");
		mainTitle.setForeground(Color.RED);
		mainTitle.setFont(new Font("Tahoma", Font.PLAIN, 25));
		topPanel.add(mainTitle);
		
		JPanel bottomPanel = new JPanel();
		frame.getContentPane().add(bottomPanel, BorderLayout.SOUTH);
		bottomPanel.setLayout(new BorderLayout(0, 0));
		
		JButton themButton = new JButton("Thêm");
		themButton.setForeground(Color.BLUE);
		themButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		bottomPanel.add(themButton);
		
		JPanel centerPanel = new JPanel();
		frame.getContentPane().add(centerPanel, BorderLayout.CENTER);
		centerPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		centerPanel.add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		noidungText = new JTextField();
		noidungText.setText("Nội dung");
		noidungText.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_noidungText = new GridBagConstraints();
		gbc_noidungText.anchor = GridBagConstraints.SOUTH;
		gbc_noidungText.insets = new Insets(0, 0, 5, 0);
		gbc_noidungText.fill = GridBagConstraints.HORIZONTAL;
		gbc_noidungText.gridx = 0;
		gbc_noidungText.gridy = 0;
		panel.add(noidungText, gbc_noidungText);
		noidungText.setColumns(10);
		
		thoigianText = new JTextField();
		thoigianText.setText("Thời gian");
		thoigianText.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_thoigianText = new GridBagConstraints();
		gbc_thoigianText.insets = new Insets(0, 0, 5, 0);
		gbc_thoigianText.fill = GridBagConstraints.HORIZONTAL;
		gbc_thoigianText.gridx = 0;
		gbc_thoigianText.gridy = 1;
		panel.add(thoigianText, gbc_thoigianText);
		thoigianText.setColumns(10);
		
		diadiemText = new JTextField();
		diadiemText.setText("Địa điểm");
		diadiemText.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_diadiemText = new GridBagConstraints();
		gbc_diadiemText.insets = new Insets(0, 0, 5, 0);
		gbc_diadiemText.fill = GridBagConstraints.HORIZONTAL;
		gbc_diadiemText.gridx = 0;
		gbc_diadiemText.gridy = 2;
		panel.add(diadiemText, gbc_diadiemText);
		diadiemText.setColumns(10);
		
		lienheText = new JTextField();
		lienheText.setText("Liên hệ");
		lienheText.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lienheText.setColumns(10);
		GridBagConstraints gbc_lienheText = new GridBagConstraints();
		gbc_lienheText.insets = new Insets(0, 0, 5, 0);
		gbc_lienheText.fill = GridBagConstraints.HORIZONTAL;
		gbc_lienheText.gridx = 0;
		gbc_lienheText.gridy = 3;
		panel.add(lienheText, gbc_lienheText);
		
		frame.getRootPane().setDefaultButton(themButton);
		
		themButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String noidung = noidungText.getText();
				String thoigian = thoigianText.getText();
				String diadiem = diadiemText.getText();
				String lienhe = lienheText.getText();
				
				int option = JOptionPane.showConfirmDialog(null, 
						"Bạn có chắc chắn thêm thông tin?", "Xác nhận", JOptionPane.YES_NO_CANCEL_OPTION);
				if (option == 0) {
					try {
						Connection con = (new Ketnoi()).connectionInfo();
						String sql = "insert into sukien (noidungsk, thoigian, diadiem, lienhe) values ('" + noidung + "', '" + thoigian + "', '" + diadiem + "', '" + lienhe + "')"; 
						PreparedStatement prestate = con.prepareStatement(sql);
						int rs = prestate.executeUpdate();
					
						if(rs != -1) {
							JOptionPane.showMessageDialog(null, "Đã thêm thành công!");
							noidungText.setText("Nội dung");
							thoigianText.setText("Thời gian");
							diadiemText.setText("Địa điểm");
							lienheText.setText("Liên hệ");
						}
					
					}
					catch (SQLException s) {
						s.printStackTrace();
					}
				}
				
			}
		});
		
		frame.setVisible(true);
	}
}
