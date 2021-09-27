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

public class Menu extends JFrame {
	
	private Logica miLogica;
	private JPanel contentPane;
	private Ayuda reglas;
	private int dimensionX = 200;
	private int dimensionY = 300;
	
	
	public Menu() {
		
		setSize(new Dimension(430, 300));
		setResizable(false);
		setTitle("Menu Principal");
		getContentPane().setLayout(null);
		
		JButton btnJugar = new JButton("Jugar");
		btnJugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (miLogica==null)
					miLogica = new Logica();
			}
		});
		btnJugar.setBounds(82, 100, 264, 33);
		getContentPane().add(btnJugar);
		
		JButton btnReglas = new JButton("Reglas");
		btnReglas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (reglas == null)
					reglas = new Ayuda();
				reglas.setVisible(true);
			}
		});
		btnReglas.setBounds(82, 163, 264, 33);
		getContentPane().add(btnReglas);
	}
			
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Menu juego = new Menu();
			juego.setVisible(true);
	}
}
