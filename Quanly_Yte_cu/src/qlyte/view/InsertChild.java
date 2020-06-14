package qlyte.view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import exception.MissWrongInfoException;
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
import java.sql.SQLException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class InsertChild {

	protected JFrame frame;
	protected JTextField cmndText;
	protected JTextField hotenText;
	protected JTextField ngaysinhText;
	protected JTextField bhytText;

	/**
	 * Create the application.
	 */
	public InsertChild() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	protected void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 797, 584);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.getContentPane().setBackground(Color.lightGray);
		
		JLabel cmndLabel = new JLabel("CMND của mẹ");
		cmndLabel.setFont(new Font("Dialog", Font.PLAIN, 25));
		cmndLabel.setBounds(33, 254, 205, 44);
		frame.getContentPane().add(cmndLabel);
		
		cmndText = new JTextField();
		cmndText.setFont(new Font("Dialog", Font.PLAIN, 25));
		cmndText.setBounds(232, 250, 247, 53);
		frame.getContentPane().add(cmndText);
		cmndText.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBounds(33, 10, 463, 53);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel titleLabel = new JLabel("THÊM THÔNG TIN CỦA BÉ");
		titleLabel.setBounds(0, 10, 463, 53);
		panel.add(titleLabel);
		titleLabel.setForeground(new Color(255, 0, 0));
		titleLabel.setFont(new Font("Dialog", Font.PLAIN, 35));
		
		JLabel hotenLabel = new JLabel("Họ tên");
		hotenLabel.setFont(new Font("Dialog", Font.PLAIN, 25));
		hotenLabel.setBounds(33, 123, 114, 64);
		frame.getContentPane().add(hotenLabel);
		
		JLabel ngaysinhLabel = new JLabel("Ngày sinh");
		ngaysinhLabel.setFont(new Font("Dialog", Font.PLAIN, 25));
		ngaysinhLabel.setBounds(33, 188, 144, 50);
		frame.getContentPane().add(ngaysinhLabel);
		
		JLabel bhytLabel = new JLabel("BHYT của mẹ");
		bhytLabel.setFont(new Font("Dialog", Font.PLAIN, 25));
		bhytLabel.setBounds(33, 316, 189, 39);
		frame.getContentPane().add(bhytLabel);
		
		hotenText = new JTextField();
		hotenText.setFont(new Font("Dialog", Font.PLAIN, 25));
		hotenText.setBounds(232, 128, 247, 51);
		frame.getContentPane().add(hotenText);
		hotenText.setColumns(10);
		
		ngaysinhText = new JTextField();
		ngaysinhText.setFont(new Font("Dialog", Font.PLAIN, 25));
		ngaysinhText.setBounds(232, 189, 247, 49);
		frame.getContentPane().add(ngaysinhText);
		ngaysinhText.setColumns(10);
		
		bhytText = new JTextField();
		bhytText.setFont(new Font("Dialog", Font.PLAIN, 25));
		bhytText.setBounds(232, 316, 247, 53);
		frame.getContentPane().add(bhytText);
		bhytText.setColumns(10);
		
		JButton themButton = new JButton("Thêm");
		themButton.setFont(new Font("Dialog", Font.PLAIN, 25));
		themButton.setBounds(232, 412, 247, 44);
		frame.getContentPane().add(themButton);
		frame.getRootPane().setDefaultButton(themButton);
		
		BufferedImage myPicture;
		try {
			myPicture = ImageIO.read(new File("C://Users//DELL//Desktop//nen4.jpg"));
			JLabel picLabel = new JLabel(new ImageIcon(myPicture));
			picLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
			picLabel.setBounds(0, 0, 783, 547);
			frame.getContentPane().add(picLabel);
			frame.getContentPane().setLayout(null);
		} catch (IOException e4) {
			// TODO Auto-generated catch block
			e4.printStackTrace();
		}
		
		themButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String hoten = hotenText.getText();
				String ngaysinh = ngaysinhText.getText();
				String cmnd = cmndText.getText();
				String bhyt = bhytText.getText();
											
				Connection con;
				int option = JOptionPane.showConfirmDialog(null, 
						"Bạn có chắc chắn thêm thông tin?", "Xác nhận", JOptionPane.YES_NO_CANCEL_OPTION);
				try {
					if(option == 0) {					
						Thongtin_meService ttMeService = new Thongtin_meService();
						List<Thongtin_me> check2 = ttMeService.getTT_Me(1, "");
						
						if(hoten.equals("")|| ngaysinh.equals("")||cmnd.equals("")||bhyt.equals("")||(cmnd.length() != 9 && cmnd.length() != 12)){
							JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi!\n1.Nhập đầy đủ tất cả thông tin!\n2.Số CMND sai định dạng",
									"Lỗi nhập thông tin", JOptionPane.ERROR_MESSAGE);
							throw new MissWrongInfoException("Thiếu các trường bắt buộc hoặc sai CMND!");
						}
									
						int count = 0;
						for(Thongtin_me t : check2) {
							if(t.getCmnd().equals(cmnd) && t.getMa_bhyt().equals(bhyt)) {
								count ++;
								break;
							}
						}
						
						if(count == 0) {
							JOptionPane.showMessageDialog(null, "Thông tin của mẹ chưa đúng!");
							throw new MissWrongInfoException("Nhập sai thông tin mẹ!");
						}
						con = Ketnoi.getPostgresqlConnection();
						String sql = "insert into thongtin_be(cmnd_me, ma_bh_me, tenbe, ngaysinh) "
								+ "values('" + cmnd + "', '" + bhyt + "', '" + hoten + "', '" + ngaysinh + "')";
						PreparedStatement prestate = con.prepareStatement(sql);
						int kt = prestate.executeUpdate();
						if(kt != -1) {
							JOptionPane.showMessageDialog(null, "Đã thêm thành công!", "Thành công", JOptionPane.DEFAULT_OPTION);
							hotenText.setText("");
							ngaysinhText.setText("");
							cmndText.setText("");
							bhytText.setText("");
						}
					}	
				} catch (ClassNotFoundException | SQLException | MissWrongInfoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
				
		});
	}
}
