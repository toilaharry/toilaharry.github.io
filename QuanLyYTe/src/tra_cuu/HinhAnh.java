package tra_cuu;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class HinhAnh extends Canvas {
	public void paint(Graphics g) {  
        Toolkit t = Toolkit.getDefaultToolkit();  
        Image i = t.getImage("E://cccn.jpg");  
        g.drawImage(i, 250,10,this);  
    }  
        public static void main(String[] args) {  
        HinhAnh m=new HinhAnh();  
        JFrame f=new JFrame();  
        f.add(m);  
        f.getContentPane().getSize();
        f.setSize(400,400);  
        f.setVisible(true);  
    }  

}
