package qlyte.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import exception.MissWrongInfoException;
import qlyte.dao.Ketnoi;

public class InputDeleteChild extends InputDelete {

	/**
	 * Create the application.
	 */
	public InputDeleteChild() {
		super();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	@Override
	protected void initialize() {
		super.initialize();
		keyLabel.setText("Nhập mã bé");
		mainLabel.setText("XÓA THÔNG TIN BÉ");
		
		xoaButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int option = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa?", "Xác nhận", JOptionPane.YES_NO_CANCEL_OPTION);
				if(option == 0) {
					String mabe = keyText.getText();
					Connection con;
					try {
						 con = Ketnoi.getPostgresqlConnection();
						 Statement state = con.createStatement();
						 String sql = "select ma_be from thongtin_be";
						 ResultSet rs = state.executeQuery(sql);
						 int count = 0;
						 while(rs.next()) {
							 if(rs.getString("ma_be").equals(mabe)) {
								 count ++;
								 break;
							 }
						 }
						 
						 if(count == 0) {
							 JOptionPane.showMessageDialog(null, "Không tìm thấy bé này! Vui lòng thử lại!");
							 throw new MissWrongInfoException("Đối tượng không tồn tại!");
						 }
						 
						 String sql2 = "delete from thongtin_be where ma_be = '" + mabe + "'";
						 PreparedStatement prestate = con.prepareStatement(sql2);
						 int rs2 = prestate.executeUpdate();
						 
						 if(rs2 != -1) {
							JOptionPane.showMessageDialog(null, "Xóa thành công!");
							keyText.setText("");
						 }
						 
					}
					catch(SQLException | ClassNotFoundException | MissWrongInfoException e1) {
						
					}
					
				}
				
			}
		});
	}

}
