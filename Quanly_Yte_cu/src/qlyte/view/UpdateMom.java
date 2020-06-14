package qlyte.view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import exception.CheckIsNumeric;
import exception.MissWrongInfoException;
import exception.ObjectNotExistException;
import qlyte.dao.Ketnoi;

import javax.swing.JTextArea;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JPanel;

public class UpdateMom {

	protected JFrame frame;
	protected JTextField cmndText;
	protected JTextField hotenText;
	protected JTextField ngaysinhText;
	protected JTextField bhytText;
	protected JTextField sdtText;
	protected JTextField cmndCuText;

	/**
	 * Create the application.
	 */
	public UpdateMom() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	protected void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 734, 548);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.getContentPane().setBackground(Color.lightGray);
		
		JLabel cmndLabel = new JLabel("CMND");
		cmndLabel.setFont(new Font("Dialog", Font.PLAIN, 20));
		cmndLabel.setBounds(52, 260, 96, 34);
		frame.getContentPane().add(cmndLabel);
		
		cmndText = new JTextField();
		cmndText.setFont(new Font("Dialog", Font.PLAIN, 20));
		cmndText.setBounds(186, 262, 264, 34);
		frame.getContentPane().add(cmndText);
		cmndText.setColumns(10);
		
		JLabel titleLabel = new JLabel("CẬP NHẬT THÔNG TIN CỦA MẸ");
		titleLabel.setForeground(new Color(255, 0, 0));
		titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 35));
		titleLabel.setBounds(27, 10, 518, 50);
		frame.getContentPane().add(titleLabel);
		
		JLabel hotenLabel = new JLabel("Họ tên");
		hotenLabel.setFont(new Font("Dialog", Font.PLAIN, 20));
		hotenLabel.setBounds(52, 154, 82, 26);
		frame.getContentPane().add(hotenLabel);
		
		JLabel ngaysinhLabel = new JLabel("Ngày sinh");
		ngaysinhLabel.setFont(new Font("Dialog", Font.PLAIN, 20));
		ngaysinhLabel.setBounds(52, 210, 96, 29);
		frame.getContentPane().add(ngaysinhLabel);
		
		JLabel bhytLabel = new JLabel("Mã BHYT");
		bhytLabel.setFont(new Font("Dialog", Font.PLAIN, 20));
		bhytLabel.setBounds(52, 316, 96, 31);
		frame.getContentPane().add(bhytLabel);
		
		JLabel diachiLabel = new JLabel("Địa chỉ");
		diachiLabel.setFont(new Font("Dialog", Font.PLAIN, 20));
		diachiLabel.setBounds(52, 366, 82, 37);
		frame.getContentPane().add(diachiLabel);
		
		JLabel sdtLabel = new JLabel("Số điện thoại");
		sdtLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		sdtLabel.setBounds(52, 423, 124, 36);
		frame.getContentPane().add(sdtLabel);
		
		hotenText = new JTextField();
		hotenText.setFont(new Font("Dialog", Font.PLAIN, 20));
		hotenText.setBounds(186, 153, 264, 34);
		frame.getContentPane().add(hotenText);
		hotenText.setColumns(10);
		
		ngaysinhText = new JTextField();
		ngaysinhText.setFont(new Font("Dialog", Font.PLAIN, 20));
		ngaysinhText.setBounds(186, 207, 264, 34);
		frame.getContentPane().add(ngaysinhText);
		ngaysinhText.setColumns(10);
		
		bhytText = new JTextField();
		bhytText.setFont(new Font("Dialog", Font.PLAIN, 20));
		bhytText.setBounds(186, 315, 264, 34);
		frame.getContentPane().add(bhytText);
		bhytText.setColumns(10);
		
		JTextArea diachiText = new JTextArea();
		diachiText.setFont(new Font("Dialog", Font.PLAIN, 20));
		diachiText.setBounds(186, 371, 264, 34);
		frame.getContentPane().add(diachiText);
		
		sdtText = new JTextField();
		sdtText.setFont(new Font("Dialog", Font.PLAIN, 20));
		sdtText.setBounds(186, 427, 264, 34);
		frame.getContentPane().add(sdtText);
		sdtText.setColumns(10);
		
		JButton updateButton = new JButton("Cập nhật");
		updateButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		updateButton.setBounds(212, 471, 205, 34);
		frame.getContentPane().add(updateButton);
		frame.getRootPane().setDefaultButton(updateButton);
		
		cmndCuText = new JTextField();
		cmndCuText.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cmndCuText.setBounds(186, 65, 264, 38);
		frame.getContentPane().add(cmndCuText);
		cmndCuText.setColumns(10);
		
		JLabel cmndCuLabel = new JLabel("CMND cũ");
		cmndCuLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cmndCuLabel.setBounds(52, 65, 96, 34);
		frame.getContentPane().add(cmndCuLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(186, 113, 264, 24);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel ttmoiLabel = new JLabel("Nhập thông tin mới");
		ttmoiLabel.setBounds(0, 0, 264, 24);
		panel.add(ttmoiLabel);
		ttmoiLabel.setHorizontalAlignment(SwingConstants.CENTER);
		ttmoiLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		BufferedImage myPicture;
		try {
			myPicture = ImageIO.read(new File("C://Users//DELL//Desktop//nen6.jpg"));
			JLabel picLabel = new JLabel(new ImageIcon(myPicture));
			picLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
			picLabel.setBounds(0, -8, 736, 532);
			frame.getContentPane().add(picLabel);
			frame.getContentPane().setLayout(null);
			
		} catch (IOException e4) {
			// TODO Auto-generated catch block
			e4.printStackTrace();
		}
		
		
		updateButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String hoten = hotenText.getText();
				String ngaysinh = ngaysinhText.getText();
				String cmnd = cmndText.getText();
				String bhyt = bhytText.getText();
				String sdt = sdtText.getText();
				String diachi = diachiText.getText();
				String cmndcu = cmndCuText.getText();
				
				Connection con;
				int option = JOptionPane.showConfirmDialog(null, 
						"Bạn chắc chắn muốn thay đổi thông tin?", "Xác nhận", JOptionPane.YES_NO_CANCEL_OPTION);
				try {
					if(option == 0) {
						
						if(hoten.equals("")||cmnd.equals("")||bhyt.equals("")||diachi.equals("")||cmndcu.equals("")){
							JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ tên, CMND, mã BHYT, địa chỉ\nkể cả những thông tin không thay đổi!");
							throw new MissWrongInfoException("Nhập thiếu thông tin!");
						}
						
						con = Ketnoi.getPostgresqlConnection();
						Statement state = con.createStatement();
						String sql1 = "select cmnd from quanlytt";
						ResultSet rs = state.executeQuery(sql1);
						List<String> check = new ArrayList<String>();
						while(rs.next()) {
							check.add(rs.getString("cmnd"));
						}
						
						if((cmnd.length() != 9 && cmnd.length() != 12) || (cmndcu.length() != 9 && cmndcu.length() != 12)) {
							JOptionPane.showMessageDialog(null, "Số CMND (mới hoặc cũ) không hợp lệ! Vui lòng thử lại!");
							throw new MissWrongInfoException("CMND không hợp lệ!");
						}
						
						if(! CheckIsNumeric.isNumeric(cmnd)) {
							JOptionPane.showMessageDialog(null, "Số CMND phải là một chuỗi số!");
							throw new MissWrongInfoException("CMND không hợp lệ!");
						}
						
						int count = 0;
						for(String s : check) {
							if(s.equals(cmndcu)) {
								count ++;
								break;
							}
						}
						
						if(count == 0) {
							JOptionPane.showMessageDialog(null, "Không tồn tại người này! Vui lòng thử lại!");
							throw new ObjectNotExistException("Không tồn tại đối tượng!");
						}
						
						con = Ketnoi.getPostgresqlConnection();
						String sql2 = "update quanlytt set hoten = '" + hoten + "', ngaysinh = '" + ngaysinh + "', cmnd = '" + cmnd 
				        		+ "', ma_bhyt = '" + bhyt + "', diachi = '" + diachi + "', sdt = '" + sdt + "' "
				        		+ "where cmnd = '" + cmndcu + "'";
						PreparedStatement prestate = con.prepareStatement(sql2);
						int kt = prestate.executeUpdate();
						
						if(kt != -1) {
							JOptionPane.showMessageDialog(null, "Cập nhật thành công!", "Thành công", JOptionPane.DEFAULT_OPTION);
							hotenText.setText("");
							ngaysinhText.setText("");
							cmndText.setText("");
							bhytText.setText("");
							sdtText.setText("");
							diachiText.setText("");
							cmndCuText.setText("");
						}
					}
					
				} catch (ClassNotFoundException | SQLException |MissWrongInfoException |ObjectNotExistException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}
}
