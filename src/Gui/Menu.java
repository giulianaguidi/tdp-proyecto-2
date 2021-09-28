package Gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Lógica.Logica;

import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class Menu extends JFrame {
	
	private Logica miLogica;
	private JPanel contentPane;
	private Ayuda reglas;
	private int dimensionX = 200;
	private int dimensionY = 300;
	
	
	public Menu() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Menu.class.getResource("/images/icon-tetris.png")));
		
		setSize(new Dimension(410, 300));
		setResizable(false);
		setTitle("Menu Principal");
		getContentPane().setLayout(null);
		
		JButton btnJugar = new JButton("Jugar");
		btnJugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					miLogica = new Logica();
			}
		});
		btnJugar.setBounds(61, 164, 264, 33);
		getContentPane().add(btnJugar);
		
		JButton btnReglas = new JButton("Reglas");
		btnReglas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (reglas == null)
					reglas = new Ayuda();
				reglas.setVisible(true);
			}
		});
		btnReglas.setBounds(61, 217, 264, 33);
		getContentPane().add(btnReglas);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Menu.class.getResource("/images/fondo-menu-final.jpg")));
		lblNewLabel.setBounds(0, 0, 403, 261);
		getContentPane().add(lblNewLabel);
	}
			
	public static void main(String[] args) {
			Menu juego = new Menu();
			juego.setVisible(true);
	}
}
