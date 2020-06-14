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

public class InputDeleteMom extends InputDelete {

	/**
	 * Create the application.
	 */
	public InputDeleteMom() {
		super();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	@Override
	protected void initialize() {
		super.initialize();
		keyLabel.setText("Nhập số CMND");
		mainLabel.setText("XÓA THÔNG TIN MẸ");
		
		xoaButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int option = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa người này?", "Xác nhận", JOptionPane.YES_NO_CANCEL_OPTION);
				if(option == 0) {
					String cmnd = keyText.getText();
					Connection con;
					try {
						 con = Ketnoi.getPostgresqlConnection();
						 Statement state = con.createStatement();
						 String sql = "select cmnd from quanlytt";
						 ResultSet rs = state.executeQuery(sql);
						 int count = 0;
						 while(rs.next()) {
							 if(rs.getString("cmnd").equals(cmnd)) {
								 count ++;
								 break;
							 }
						 }
						 
						 if(count == 0) {
							 JOptionPane.showMessageDialog(null, "Không tìm thấy người này! Vui lòng thử lại!");
							 throw new MissWrongInfoException("Đối tượng không tồn tại!");
						 }
						 
						 String sql2 = "delete from quanlytt where cmnd = '" + cmnd + "'";
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
