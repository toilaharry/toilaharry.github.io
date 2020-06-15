package qlyte.view;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JTextField;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class InputDelete {

	protected JFrame frame;
	protected JTextField keyText;
	protected JLabel keyLabel;
	protected JLabel mainLabel;
	protected JButton xoaButton;
	public static int count = 0;

	/**
	 * Create the application.
	 */
	public InputDelete() {
		count ++;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	protected void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 569);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.lightGray);
		frame.setVisible(true);
		
		mainLabel = new JLabel("XÓA THÔNG TIN");
		mainLabel.setHorizontalAlignment(SwingConstants.CENTER);
		mainLabel.setForeground(new Color(0, 0, 128));
		mainLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		mainLabel.setBounds(36, 22, 363, 42);
		frame.getContentPane().add(mainLabel);
		
		keyLabel = new JLabel("Key");
		keyLabel.setForeground(new Color(0, 0, 128));
		keyLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		keyLabel.setBounds(10, 74, 138, 32);
		frame.getContentPane().add(keyLabel);
		
		keyText = new JTextField();
		keyText.setForeground(new Color(0, 0, 128));
		keyText.setFont(new Font("Tahoma", Font.PLAIN, 18));
		keyText.setBounds(155, 75, 271, 32);
		frame.getContentPane().add(keyText);
		keyText.setColumns(10);
		
		xoaButton = new JButton("Xóa");
		xoaButton.setForeground(new Color(255, 0, 0));
		xoaButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		xoaButton.setBounds(205, 128, 150, 29);
		frame.getContentPane().add(xoaButton);
		frame.getRootPane().setDefaultButton(xoaButton);
		
		BufferedImage myPicture;
		try {
			myPicture = ImageIO.read(new File("nen4.1.png"));
			JLabel picLabel = new JLabel(new ImageIcon(myPicture));
			picLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
			picLabel.setBounds(0, 0, 436, 532);
			frame.getContentPane().add(picLabel);
			frame.getContentPane().setLayout(null);
			
		} catch (IOException e4) {
			// TODO Auto-generated catch block
			e4.printStackTrace();
		}
	}
}
