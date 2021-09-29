package Gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

@SuppressWarnings("serial")
public class Ayuda extends JFrame {
	
	public Ayuda() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Ayuda.class.getResource("/images/icon-tetris.png")));
		setTitle("Reglas del Tetris");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(new Dimension(407, 235));
		setAlwaysOnTop(true);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Ayuda.class.getResource("/images/reglas.jpeg")));
		getContentPane().add(lblNewLabel, BorderLayout.CENTER);
	}

}
