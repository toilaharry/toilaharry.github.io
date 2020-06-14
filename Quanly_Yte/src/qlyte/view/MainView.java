package qlyte.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.sql.Statement;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import qlyte.dao.Ketnoi;
import javax.swing.JLabel;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JButton;

public class MainView {

	private JFrame frame;
	
	
	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	protected ListFrame[] listFrame;
	protected InputDelete[] inputDelete;
	protected UpdateMom updateMom;
	protected UpdateChild updateChild;
	protected InsertMom insertMom;
	protected InsertChild insertChild;
	protected CreateEvents createEvents;
	
	/**
	 * Launch the application.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainView window = new MainView();
					window.frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});		
	}

	/**
	 * Create the application.
	 */
	public MainView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @wbp.parser.entryPoint
	 */
	private void initialize() {
		frame = new JFrame("Chương trình quản lý y tế");
		frame.setBounds(100, 100, 750, 591);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
				
		JLabel huongdanLabel = new JLabel("<html><br>Các chức năng gồm có:<br>1.Quản lý: Thêm, xóa, sửa đổi các loại thông tin<br>2.Tra cứu: Tra cứu các loại thông tin<br>3.Sự kiện: Tạo các sự kiện, gửi thông báo<br>4.Tài khoản: Thay đổi thông tin tài khoản, đăng xuất");
		huongdanLabel.setHorizontalAlignment(SwingConstants.CENTER);
		huongdanLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		huongdanLabel.setBounds(106, 104, 510, 175);
		frame.getContentPane().add(huongdanLabel);
		
		JLabel mainLabel = new JLabel("Chương trình quản lý y tế");
		mainLabel.setForeground(Color.WHITE);
		mainLabel.setBounds(0, 20, 736, 41);
		mainLabel.setHorizontalAlignment(SwingConstants.CENTER);
		mainLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		mainLabel.setFont(new Font("Courier New", Font.BOLD, 40));
		frame.getContentPane().add(mainLabel);
		
		JButton xemskmoiButton = new JButton("Sự kiện mới");
		xemskmoiButton.setToolTipText("Nhấn để xem sự kiện mới nhất");
		xemskmoiButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		xemskmoiButton.setBounds(0, 497, 138, 35);
		frame.getContentPane().add(xemskmoiButton);
		
		JLabel sukienLabel = new JLabel("");
		sukienLabel.setHorizontalAlignment(SwingConstants.LEFT);
		sukienLabel.setForeground(Color.RED);
		sukienLabel.setFont(new Font("Calibri", Font.BOLD, 20));
		sukienLabel.setBounds(65, 275, 363, 161);
		frame.getContentPane().add(sukienLabel);
		
		JLabel huongdan1Label = new JLabel("<html>Hướng dẫn: Bạn hãy chọn các chức năng trên menu</html>");
		huongdan1Label.setFont(new Font("Tahoma", Font.PLAIN, 26));
		huongdan1Label.setBounds(67, 84, 623, 45);
		frame.getContentPane().add(huongdan1Label);
		
			
		BufferedImage myPicture;
		try {
			myPicture = ImageIO.read(new File("C://Users//DELL//Desktop//yte.jpg"));
			JLabel picLabel = new JLabel(new ImageIcon(myPicture));
			picLabel.setForeground(Color.RED);
			picLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
			picLabel.setBounds(0, 0, 736, 532);
			frame.getContentPane().add(picLabel);
							
			frame.getContentPane().setLayout(null);
			
		} catch (IOException e4) {
			// TODO Auto-generated catch block
			e4.printStackTrace();
		}
		
		JMenuBar menubar = new JMenuBar();
		menubar.setBounds(0, 0, 436, 263);
		JMenu quanly = new JMenu("Quản lý");
		JMenu tracuu = new JMenu("Tra cứu");
		JMenu taosk = new JMenu("Sự kiện");
		JMenu taikhoan = new JMenu("Tài khoản");
		
		JMenuItem thongtin = new JMenuItem("Thông tin tài khoản");
		JMenuItem dangxuat = new JMenuItem("Đăng xuất");
		
		JMenuItem thongtinme = new JMenuItem("Thông tin mẹ");
		JMenuItem thongtinbe = new JMenuItem("Thông tin bé");
		JMenuItem thongtinpk = new JMenuItem("Tìm phòng khám");
				
		JMenuItem taosukien = new JMenuItem("Tạo sự kiện");
		JMenuItem xemsukien = new JMenuItem("Xem tất cả các sự kiện");
				
		JMenuItem thongtinvacxin = new JMenuItem("Tra cứu vacxin");
		JMenuItem thongtinxn = new JMenuItem("Tra cứu xét nghiệm");
		
		JMenu quanlyme = new JMenu("Quản lý thông tin mẹ");
		JMenu quanlybe = new JMenu("Quan lý thông tin bé");
		JMenu quanlykhac = new JMenu("Quản lý thông tin khác");
		
		JMenuItem them_me = new JMenuItem("Thêm thông tin mẹ");
		JMenuItem update_me = new JMenuItem("Sửa thông tin mẹ");
		JMenuItem xoa_me = new JMenuItem("Xóa thông tin mẹ");
		JMenuItem them_con = new JMenuItem("Thêm thông tin bé");
		JMenuItem update_con = new JMenuItem("Sửa thông tin bé");
		JMenuItem xoa_con = new JMenuItem("Xóa thông tin bé");
		
		frame.setJMenuBar(menubar);
		menubar.add(quanly);
		menubar.add(tracuu);
		menubar.add(taosk);
		menubar.add(taikhoan);
		
		
		tracuu.add(thongtinme);
		tracuu.add(thongtinbe);
		tracuu.add(thongtinpk);
		tracuu.add(thongtinvacxin);
		tracuu.add(thongtinxn);

		
		taosk.add(taosukien);
		taosk.add(xemsukien);
		
		
		quanly.add(quanlyme);
		quanly.add(quanlybe);
		quanly.add(quanlykhac);
		
		quanlyme.add(them_me);
		quanlyme.add(update_me);
		quanlyme.add(xoa_me);
		quanlybe.add(them_con);
		quanlybe.add(update_con);
		quanlybe.add(xoa_con);
		
		quanly.addSeparator();
		
		taikhoan.add(thongtin);
		taikhoan.add(dangxuat);
		
		thongtinpk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					listFrame[ListFrame.count] =  new ListPKFrame();
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}		
				
			}
		});
		
		thongtinme.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					listFrame[ListFrame.count] = new ListMomFrame();
				}
				catch(ClassNotFoundException | SQLException e2) {
					e2.printStackTrace();
				}
			}
		});
		
		
		thongtinbe.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					listFrame[ListFrame.count] = new ListChildFrame();
				}
				catch(ClassNotFoundException | SQLException e3) {
					e3.printStackTrace();
				}
			}
		});
		
		thongtinvacxin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
					try {
						listFrame[ListFrame.count] = new ListVacxinFrame();
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}			
			}
		});
		
		thongtinxn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
					try {
						listFrame[ListFrame.count] = new ListXnFrame();
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}			
			}
		});
		
		update_me.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				updateMom = new UpdateMom();
			}
		});
		
		update_con.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				updateChild = new UpdateChild();
			}
		});

		them_me.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				insertMom = new InsertMom();				
			}
		});
		
		them_con.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				insertChild = new InsertChild();				
			}
		});
		
		xoa_me.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			inputDelete[InputDelete.count] =  new InputDeleteMom();
			}
		});
		
		xoa_con.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				inputDelete[InputDelete.count] = new InputDeleteChild();
			}
		});
		
		dangxuat.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int option = JOptionPane.showConfirmDialog(null, "Bạn chắn chắc muốn đăng xuất?", "Xác nhận", JOptionPane.YES_NO_CANCEL_OPTION);
				if(option == 0) {
					JOptionPane.showMessageDialog(null, "Đăng xuất thành công!");
					System.exit(0);
				}
			}
		});
		
		xemskmoiButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
					try {
						Connection con = Ketnoi.getPostgresqlConnection();
						Statement state = con.createStatement();
						String sql = "select * from sukien where mask >= all(select mask from sukien)";
						ResultSet rs = state.executeQuery(sql);
						
						String noidung = ""; 
						String thoigian = "";
						String diadiem = "";
						String lienhe = "";
						
						while(rs.next()) {
							noidung = rs.getString("noidungsk");
							thoigian = rs.getString("thoigian");
							diadiem = rs.getString("diadiem");
							lienhe = rs.getString("lienhe");
						}
						
						String tonghop = "<html>Sự kiện: " + noidung + "<br>Thời gian: " + thoigian + "<br>Địa điểm: " + diadiem + "<br>Liên hệ: " + lienhe + "</html>";
						
						sukienLabel.setText(tonghop);
					}
					catch(SQLException | ClassNotFoundException k) {
						k.printStackTrace();
					}
					
					
					
			}
		});
		
		xemsukien.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					listFrame[ListFrame.count] = new SukienView();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		taosukien.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				createEvents = new CreateEvents();				
			}
		});

	}
}
