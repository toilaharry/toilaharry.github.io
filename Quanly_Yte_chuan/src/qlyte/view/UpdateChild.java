package qlyte.view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import exception.MissWrongInfoException;
import exception.ObjectNotExistException;
import qlyte.dao.Ketnoi;
import qlyte.model.Thongtin_me;
import qlyte.service.Thongtin_meService;
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
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class UpdateChild {

	protected JFrame frame;
	protected JTextField cmndText;
	protected JTextField hotenText;
	protected JTextField ngaysinhText;
	protected JTextField bhytText;
	protected JTextField mabeText;

	/**
	 * Create the application.
	 */
	public UpdateChild() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	protected void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 625, 559);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.getContentPane().setBackground(Color.lightGray);
		
		JLabel cmndLabel = new JLabel("CMND mẹ");
		cmndLabel.setForeground(new Color(0, 0, 128));
		cmndLabel.setFont(new Font("Dialog", Font.PLAIN, 25));
		cmndLabel.setBounds(60, 344, 121, 37);
		frame.getContentPane().add(cmndLabel);
		
		cmndText = new JTextField();
		cmndText.setFont(new Font("Dialog", Font.PLAIN, 25));
		cmndText.setBounds(198, 342, 320, 41);
		frame.getContentPane().add(cmndText);
		cmndText.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBounds(71, 10, 468, 53);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel titleLabel = new JLabel("CẬP NHẬT THÔNG TIN BÉ");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setForeground(new Color(0, 100, 0));
		titleLabel.setBounds(0, 0, 468, 54);
		panel.add(titleLabel);
		titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		JLabel hotenLabel = new JLabel("Họ tên");
		hotenLabel.setForeground(new Color(0, 0, 128));
		hotenLabel.setFont(new Font("Dialog", Font.PLAIN, 25));
		hotenLabel.setBounds(60, 222, 108, 39);
		frame.getContentPane().add(hotenLabel);
		
		JLabel ngaysinhLabel = new JLabel("Ngày sinh");
		ngaysinhLabel.setForeground(new Color(0, 0, 128));
		ngaysinhLabel.setFont(new Font("Dialog", Font.PLAIN, 25));
		ngaysinhLabel.setBounds(60, 282, 135, 38);
		frame.getContentPane().add(ngaysinhLabel);
		
		JLabel bhytLabel = new JLabel("BHYT mẹ");
		bhytLabel.setForeground(new Color(0, 0, 128));
		bhytLabel.setFont(new Font("Dialog", Font.PLAIN, 25));
		bhytLabel.setBounds(60, 408, 108, 37);
		frame.getContentPane().add(bhytLabel);
		
		hotenText = new JTextField();
		hotenText.setFont(new Font("Dialog", Font.PLAIN, 25));
		hotenText.setBounds(198, 220, 320, 41);
		frame.getContentPane().add(hotenText);
		hotenText.setColumns(10);
		
		ngaysinhText = new JTextField();
		ngaysinhText.setFont(new Font("Dialog", Font.PLAIN, 25));
		ngaysinhText.setBounds(198, 282, 320, 38);
		frame.getContentPane().add(ngaysinhText);
		ngaysinhText.setColumns(10);
		
		bhytText = new JTextField();
		bhytText.setFont(new Font("Dialog", Font.PLAIN, 25));
		bhytText.setBounds(198, 406, 320, 41);
		frame.getContentPane().add(bhytText);
		bhytText.setColumns(10);
		
		JButton updateButton = new JButton("Cập nhật");
		updateButton.setFont(new Font("Dialog", Font.PLAIN, 25));
		updateButton.setBounds(257, 459, 205, 41);
		frame.getContentPane().add(updateButton);
		frame.getRootPane().setDefaultButton(updateButton);
		
		mabeText = new JTextField();
		mabeText.setFont(new Font("Dialog", Font.PLAIN, 25));
		mabeText.setBounds(198, 160, 320, 41);
		frame.getContentPane().add(mabeText);
		mabeText.setColumns(10);
		
		JLabel mabeLabel = new JLabel("Mã bé");
		mabeLabel.setForeground(new Color(0, 0, 128));
		mabeLabel.setFont(new Font("Dialog", Font.PLAIN, 25));
		mabeLabel.setBounds(58, 159, 81, 53);
		frame.getContentPane().add(mabeLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(198, 102, 320, 37);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel ttmoiLabel = new JLabel("Nhập thông tin mới");
		ttmoiLabel.setForeground(new Color(0, 0, 128));
		ttmoiLabel.setHorizontalAlignment(SwingConstants.CENTER);
		ttmoiLabel.setBounds(0, 0, 320, 37);
		panel_1.add(ttmoiLabel);
		ttmoiLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		BufferedImage myPicture;
		try {
			myPicture = ImageIO.read(new File("nen5.jpg"));
			JLabel picLabel = new JLabel(new ImageIcon(myPicture));
			picLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
			picLabel.setBounds(0, 0, 611, 522);
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
				int mabe = Integer.parseInt(mabeText.getText());
				
				Connection con;
				int option = JOptionPane.showConfirmDialog(null, 
						"Bạn chắc chắn muốn thay đổi thông tin?", "Xác nhận", JOptionPane.YES_NO_CANCEL_OPTION);
				try {
					if(option == 0) {
						con = (new Ketnoi()).connectionInfo();
						Statement state = con.createStatement();
						String sql1 = "select ma_be from thongtin_be";
						ResultSet rs1 = state.executeQuery(sql1);
						List<Integer> check1 = new ArrayList<Integer>();
						while(rs1.next()) {
							check1.add(rs1.getInt("ma_be"));
						}
						
						Thongtin_meService ttMeService = new Thongtin_meService();
						List<Thongtin_me> check2 = ttMeService.getTT_Me(1, "");
						
						int count1 = 0;
						for(Integer i : check1) {
							if(i == mabe) {
								count1 ++;
								break;
							}
						}
						if(count1 == 0) {
							JOptionPane.showMessageDialog(null, "Không tồn tại bé này! Vui lòng thử lại!");
							throw new ObjectNotExistException("Đối tượng không tồn tại!");
						}
											
						int count2 = 0;
						for(Thongtin_me t : check2) {
							if(t.getCmnd().equals(cmnd) && t.getMa_bhyt().equals(bhyt)) {
								count2 ++;
								break;
							}
						}
						if(count2 == 0) {
							JOptionPane.showMessageDialog(null, "Vui lòng kiểm tra lại thông tin của mẹ!");
							throw new MissWrongInfoException("Sai CMND hoặc BHYT");
						}					
						
						
						String sql = "update thongtin_be set cmnd_me = '" + cmnd + "', ma_bh_me = '" + bhyt 
				        		+ "', tenbe = '" + hoten + "', ngaysinh = '" + ngaysinh + "' "
				        		+ "where ma_be = '" + mabe + "'";
						PreparedStatement prestate = con.prepareStatement(sql);
						int rs = prestate.executeUpdate();
						
						if(rs != -1) {
							JOptionPane.showMessageDialog(null, "Cập nhật thành công!", "Thành công", JOptionPane.DEFAULT_OPTION);
							hotenText.setText("");
							ngaysinhText.setText("");
							cmndText.setText("");
							bhytText.setText("");
							mabeText.setText("");
						}	
					}
					
				} catch (ClassNotFoundException | SQLException | MissWrongInfoException | ObjectNotExistException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}
}
