package Gui;

import java.awt.Dimension;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Toolkit;

import Lógica.Logica;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;


@SuppressWarnings("serial")
public class Fin extends JFrame {

    public Fin(Logica miLogica) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Fin.class.getResource("/images/icon-tetris.png")));
		setTitle("FIN DEL JUEGO");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(463, 260));
		setAlwaysOnTop(true);
		getContentPane().setLayout(null);
		
		JLabel textoPuntaje = new JLabel("Su puntaje en esta partida fue: " + miLogica.getPuntaje());
		textoPuntaje.setForeground(Color.WHITE);
		textoPuntaje.setBounds(56, 35, 330, 110);
		textoPuntaje.setFont(new Font("Consolas", Font.PLAIN, 18));

		getContentPane().add(textoPuntaje);
		
		JLabel imagenFin = new JLabel();
		imagenFin.setIcon(new ImageIcon(Fin.class.getResource("/images/fin-del-juego.png")));
		imagenFin.setBounds(0, 0, 447, 221);
		getContentPane().add(imagenFin);
        
	}
}
