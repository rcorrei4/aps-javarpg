package gui;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Window {
	public static void createWindow() {  
		JFrame f=new JFrame();
		          
		JButton b=new JButton("click");
		b.setBounds(150,100,100, 40);//x axis, y axis, width, height  
		          
		f.add(b);
		          
		f.setSize(500,400);//400 width and 500 height  
		f.setLayout(null);
		f.setVisible(true);
	}
}
