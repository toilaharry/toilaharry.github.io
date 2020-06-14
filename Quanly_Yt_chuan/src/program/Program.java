package program;

import java.awt.EventQueue;
import java.sql.SQLException;

import qlyte.view.LoginView;

public class Program {
	public static void main(String args[]) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				LoginView loginView;
				try {
					loginView = new LoginView();
					loginView.getFrame().setVisible(true);
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}
}
