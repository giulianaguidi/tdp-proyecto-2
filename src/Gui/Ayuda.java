/**
 * 
 */
package Gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Dimension;

/**
 * @author Zkeith
 *
 */
public class Ayuda extends JFrame {
	
	
	private int dimensionX = 200;
	private int dimensionY = 300;
	
	public Ayuda() {
		setTitle("LAS REGLAS");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(new Dimension(407, 300));
		setAlwaysOnTop(true);
		
		JLabel lblNewLabel = new JLabel("ACA VAN LAS REGLAS DEL JUEGO Y LOS CONTROLES\r\n\r\n\r\n\r\n");
		getContentPane().add(lblNewLabel, BorderLayout.CENTER);
	}

}
