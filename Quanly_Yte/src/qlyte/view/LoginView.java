package qlyte.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import exception.MissWrongInfoException;
import qlyte.model.Login;
import qlyte.service.LoginService;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.SystemColor;

public class LoginView {

	private JFrame frame;
	
	public JFrame getFrame() {
		return frame;
	}
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	private LoginService loginService;
	private boolean check = false;
	private JPasswordField passField;
	private JButton loginButton;
	private JTextField taikhoanText;

	public static void main(String args[]) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				LoginView loginView;
				try {
					loginView = new LoginView();
					loginView.frame.setVisible(true);
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
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
	public LoginView() throws ClassNotFoundException, SQLException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	private void initialize() throws ClassNotFoundException, SQLException {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.inactiveCaption);
		frame.setForeground(SystemColor.activeCaption);
		frame.getContentPane().setForeground(SystemColor.activeCaption);
		frame.setBounds(100, 100, 451, 313);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		
		JLabel mainLabel = new JLabel("HỆ THỐNG QUẢN LÝ Y TẾ");
		mainLabel.setBounds(62, 10, 320, 50);
		mainLabel.setForeground(new Color(0, 0, 128));
		mainLabel.setFont(new Font("Courier New", Font.BOLD, 25));
		frame.getContentPane().add(mainLabel);
		
		JLabel tkLabel = new JLabel("Tài khoản");
		tkLabel.setBounds(28, 88, 109, 25);
		tkLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		frame.getContentPane().add(tkLabel);
		
		JLabel mkLabel = new JLabel("Mật khẩu");
		mkLabel.setBounds(28, 129, 109, 25);
		mkLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		frame.getContentPane().add(mkLabel);
		
		JButton forgotButton = new JButton("Quên mật khẩu?");
		forgotButton.setBounds(196, 229, 154, 25);
		forgotButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		frame.getContentPane().add(forgotButton);
		
		loginButton = new JButton("Đăng nhập");
		loginButton.setBounds(147, 184, 248, 33);
		loginButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		frame.getContentPane().add(loginButton);
		frame.getRootPane().setDefaultButton(loginButton);
		
		passField = new JPasswordField();
		passField.setBounds(147, 129, 248, 32);
		passField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		frame.getContentPane().add(passField);
		
		taikhoanText = new JTextField();
		taikhoanText.setFont(new Font("Tahoma", Font.PLAIN, 20));
		taikhoanText.setBounds(147, 81, 248, 33);
		frame.getContentPane().add(taikhoanText);
		taikhoanText.setColumns(10);
		
		frame.setVisible(true);	
		
		loginButton.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				String taikhoan = taikhoanText.getText();
				String matkhau = String.valueOf(passField.getPassword());
				try {
					if(taikhoan.equals("")||matkhau.equals("")) {
						JOptionPane.showMessageDialog(null, "Tài khoản/mật khẩu không được để trống!");
						throw new MissWrongInfoException("Missing Info");
					}
					loginService = new LoginService();
					List<Login> list = loginService.getAll_User();
					int count = 0;
					for(Login l : list) {
						if(l.getUsername().equals(taikhoan) && l.getPass().equals(matkhau)) {
							JOptionPane.showMessageDialog(null, "Đăng nhập thành công!");
							frame.setVisible(false);
							EventQueue.invokeLater(new Runnable() {
								public void run() {
									try {
										MainView window = new MainView();
										window.getFrame().setVisible(true);
									} catch (Exception e) {
										e.printStackTrace();
									}
								}
							});	
							count ++;
							break;
						}
					}
									
					if(count == 0) {
						JOptionPane.showMessageDialog(null, "Đăng nhập không thành công!\nVui lòng thử lại!");
						taikhoanText.setText("");
						passField.setText("");
					}
					
				} catch (ClassNotFoundException | SQLException | MissWrongInfoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		forgotButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Vui lòng gọi tới số 0123456789 để lấy lại tài khoản!");
				setCheck(false);
				
			}
		});
				
	}

	public boolean isCheck() {
		return check;
	}

	public void setCheck(boolean check) {
		this.check = check;
	}
}
