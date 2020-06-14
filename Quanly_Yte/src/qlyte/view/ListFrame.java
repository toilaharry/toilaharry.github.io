package qlyte.view;

import java.awt.EventQueue;
import java.sql.SQLException;

import javax.swing.JFrame;

import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JTable;

import javax.swing.JPanel;
import java.awt.Rectangle;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import javax.swing.BoxLayout;
public class ListFrame {

	protected JFrame frame;
	protected JTextField nhapttText;
	protected JTable table;
	protected JPanel centerPanel;
	protected JPanel botPanel;
	protected JPanel topPanel;
	protected JLabel nhapttLabel;
	protected JButton timkiemButton;
	protected JLabel mainTitle;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListFrame window = new ListFrame();
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
	public ListFrame() throws ClassNotFoundException, SQLException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	protected void initialize() throws ClassNotFoundException, SQLException {
		frame = new JFrame();
		frame.setBounds(new Rectangle(0, 0, 600, 400));
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		frame.setLocationRelativeTo(null);
		
		centerPanel = new JPanel();
		centerPanel.setOpaque(false);
		frame.getContentPane().add(centerPanel, BorderLayout.CENTER);
		centerPanel.setLayout(new BorderLayout(0, 0));
		
		botPanel = new JPanel();
		frame.getContentPane().add(botPanel, BorderLayout.SOUTH);
		
		topPanel = new JPanel();
		frame.getContentPane().add(topPanel, BorderLayout.NORTH);
		botPanel.setLayout(new BoxLayout(botPanel, BoxLayout.X_AXIS));
		
		
		nhapttLabel = new JLabel();
		nhapttLabel.setForeground(SystemColor.textHighlight);
		botPanel.add(nhapttLabel);
		nhapttLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		nhapttLabel.setToolTipText("");
		
		nhapttText = new JTextField();
		botPanel.add(nhapttText);
		nhapttText.setFont(new Font("Tahoma", Font.PLAIN, 20));
		nhapttText.setColumns(10);
		
		timkiemButton = new JButton("Tìm kiếm");
		timkiemButton.setForeground(SystemColor.textHighlight);
		timkiemButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		botPanel.add(timkiemButton);
		frame.getRootPane().setDefaultButton(timkiemButton);
				
		mainTitle = new JLabel();
		mainTitle.setForeground(Color.RED);
		mainTitle.setVerticalTextPosition(SwingConstants.BOTTOM);
		mainTitle.setHorizontalAlignment(SwingConstants.CENTER);
		mainTitle.setHorizontalTextPosition(SwingConstants.CENTER);
		mainTitle.setFont(new Font("Calibri", Font.PLAIN, 30));
		topPanel.add(mainTitle);
		
		frame.setVisible(true);
	}
}
