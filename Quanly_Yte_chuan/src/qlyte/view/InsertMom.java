package qlyte.view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import exception.CheckIsNumeric;
import exception.MissWrongInfoException;
import exception.ObjectExistException;
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
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class InsertMom {

	protected JFrame frame;
	protected JTextField cmndText;
	protected JTextField hotenText;
	protected JTextField ngaysinhText;
	protected JTextField bhytText;
	protected JTextField sdtText;
	private JTextField diachiText;

	/**
	 * Create the application.
	 */
	public InsertMom() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	protected void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 799, 548);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.getContentPane().setBackground(Color.lightGray);
		
		JLabel cmndLabel = new JLabel("CMND");
		cmndLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		cmndLabel.setBounds(22, 195, 105, 51);
		frame.getContentPane().add(cmndLabel);
		
		cmndText = new JTextField();
		cmndText.setFont(new Font("Dialog", Font.PLAIN, 25));
		cmndText.setBounds(191, 200, 263, 42);
		frame.getContentPane().add(cmndText);
		cmndText.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(22, 10, 453, 51);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel titleLabel = new JLabel("THÊM THÔNG TIN CỦA MẸ");
		titleLabel.setBounds(0, 0, 453, 51);
		panel_1.add(titleLabel);
		titleLabel.setForeground(new Color(255, 0, 0));
		titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 37));
		
		JLabel hotenLabel = new JLabel("Họ tên");
		hotenLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		hotenLabel.setBounds(22, 94, 105, 42);
		frame.getContentPane().add(hotenLabel);
		
		JLabel ngaysinhLabel = new JLabel("Ngày sinh");
		ngaysinhLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		ngaysinhLabel.setBounds(22, 146, 110, 43);
		frame.getContentPane().add(ngaysinhLabel);
		
		JLabel bhytLabel = new JLabel("Mã BHYT");
		bhytLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		bhytLabel.setBounds(22, 251, 163, 42);
		frame.getContentPane().add(bhytLabel);
		
		JLabel diachiLabel = new JLabel("Địa chỉ");
		diachiLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		diachiLabel.setBounds(22, 350, 102, 42);
		frame.getContentPane().add(diachiLabel);
		
		JLabel sdtLabel = new JLabel("Số điện thoại");
		sdtLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		sdtLabel.setBounds(20, 303, 150, 37);
		frame.getContentPane().add(sdtLabel);
		
		hotenText = new JTextField();
		hotenText.setFont(new Font("Dialog", Font.PLAIN, 25));
		hotenText.setBounds(191, 95, 263, 42);
		frame.getContentPane().add(hotenText);
		hotenText.setColumns(10);
		
		ngaysinhText = new JTextField();
		ngaysinhText.setFont(new Font("Dialog", Font.PLAIN, 25));
		ngaysinhText.setBounds(191, 148, 263, 42);
		frame.getContentPane().add(ngaysinhText);
		ngaysinhText.setColumns(10);
		
		bhytText = new JTextField();
		bhytText.setFont(new Font("Dialog", Font.PLAIN, 25));
		bhytText.setBounds(191, 252, 263, 42);
		frame.getContentPane().add(bhytText);
		bhytText.setColumns(10);
		
		sdtText = new JTextField();
		sdtText.setFont(new Font("Dialog", Font.PLAIN, 25));
		sdtText.setBounds(191, 304, 263, 42);
		frame.getContentPane().add(sdtText);
		sdtText.setColumns(10);
		
		JButton themButton = new JButton("Thêm");
		themButton.setFont(new Font("Dialog", Font.PLAIN, 25));
		themButton.setBounds(221, 418, 205, 42);
		frame.getContentPane().add(themButton);
		frame.getRootPane().setDefaultButton(themButton);
		
		BufferedImage myPicture;
		try {
			myPicture = ImageIO.read(new File("nen4.jpg"));
			
			diachiText = new JTextField();
			diachiText.setFont(new Font("Dialog", Font.PLAIN, 25));
			diachiText.setBounds(191, 356, 263, 42);
			frame.getContentPane().add(diachiText);
			diachiText.setColumns(10);
			JLabel picLabel = new JLabel(new ImageIcon(myPicture));
			picLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
			picLabel.setBounds(0, 0, 783, 511);
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
				String sdt = sdtText.getText();
				String diachi = diachiText.getText();
								
				Connection con;
				int option = JOptionPane.showConfirmDialog(null, 
						"Bạn có chắc chắn thêm thông tin?", "Xác nhận", JOptionPane.YES_NO_CANCEL_OPTION);
				try {
					if(option == 0) {
						con = (new Ketnoi()).connectionInfo();
						Statement state = con.createStatement();
						
						Thongtin_meService ttMeService = new Thongtin_meService();
						List<Thongtin_me> check = ttMeService.getTT_Me(1, "");
						
						if(hoten.equals("")|| diachi.equals("")||cmnd.equals("")||bhyt.equals("")|| (cmnd.length() != 9 && cmnd.length() != 12)){
							JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi!\n1.Nhập đầy đủ họ tên, số CMND, mã BHYT và địa chỉ!\n2.Nhập chính xác số CMND",
									"Lỗi nhập thông tin", JOptionPane.ERROR_MESSAGE);
							throw new MissWrongInfoException("Nhập thiếu các trường bắt buộc hoặc sai thông tin CMND!");
						}
						
						if(! CheckIsNumeric.isNumeric(cmnd)) {
							JOptionPane.showMessageDialog(null, "Số CMND phải là một chuỗi số!");
							throw new MissWrongInfoException("CMND không hợp lệ!");
						}
												
						for(Thongtin_me s : check) {
							if(s.getCmnd().equals(cmnd) || s.getMa_bhyt().equals(bhyt)) {
								JOptionPane.showMessageDialog(null, "Người này đã tồn tại!");
								throw new ObjectExistException("Đối tượng đã tồn tại");
							}
						}
						 
						String sql = "insert into quanlytt(hoten, ngaysinh, cmnd, ma_bhyt, diachi, sdt) "
								+ "values('" + hoten + "', '" + ngaysinh + "', '" + cmnd + "', '" + bhyt 
								+ "', '" + diachi + "', '" + sdt + "')";
						state.execute(sql);
						JOptionPane.showMessageDialog(null, "Đã thêm thành công!", "Thành công", JOptionPane.DEFAULT_OPTION);
						hotenText.setText("");
						ngaysinhText.setText("");
						cmndText.setText("");
						bhytText.setText("");
						sdtText.setText("");
						diachiText.setText("");
					}	
				} catch (ClassNotFoundException | SQLException | ObjectExistException | MissWrongInfoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
				
		});
	}
}
