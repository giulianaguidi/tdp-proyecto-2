package Gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.border.EmptyBorder;

import Lógica.Bloque;


public class GUI extends JFrame{
	private JSplitPane splitPane;
	private JPanel panelIzq;
	private JPanel panelDer;
	protected Bloque[][] tableroGrafico;
	protected static final int cantFilas=21;
	protected static final int cantColumnas=10;
	
	protected static final Color fondo = new Color(1, 1, 1);
	
	
	//Esto esta para probar los colores
	protected static final Color I = new Color(12, 183, 242);
	protected static final Color J = new Color(0, 255, 0); 
	protected static final Color L = new Color(255, 165, 0);
	protected static final Color O = new Color(255, 255, 0);
	protected static final Color S = new Color(0, 0, 255);
	protected static final Color T = new Color(255, 0, 255);
	protected static final Color Z = new Color(255, 0 ,0);

	
	// Estos valores estan para poder dividir el panel en 2
	protected static final int dimensionX = 1024;
	protected static final int dimensionY = 760;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public GUI() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(GUI.class.getResource("/images/icon-tetris.png")));
		initialize();
	}
	
	public void initialize() {
		panelIzq = new JPanel();
		panelIzq.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelIzq.setBackground(new Color(47,79,79));
		panelIzq.setLayout(new GridLayout(cantFilas + 1, cantColumnas + 1, 5, 5));
		
		panelDer = new JPanel();
		panelDer.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelDer.setBackground(new Color(255-47,255-79,255-79));
		
		
		
		splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panelIzq, panelDer );
		splitPane.setEnabled(false);
		
		splitPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		splitPane.setBackground(new Color(255,255,255));
		splitPane.setDividerLocation(dimensionX/2);
		
		Dimension d = new Dimension();
		d.setSize(splitPane.getSize().getWidth()/2, splitPane.getSize().getHeight());
		
		panelDer.setSize(d);
		
		
		setTitle("¡Juega al Tetris!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(dimensionX, dimensionY));
		setResizable(false);
		setContentPane(splitPane);
		splitPane.getSize().getWidth();
		

		prepararGrilla();
	

		
	}
	
	
	/*
	 * En este metodo tenemos que hacer 2 for anidados para que clonen un bloque ya creado, y le cambiamos la posicion, o creamos un bloque y le seteamos posicion y coloro.
	 * ambas formas son validas, una es usando el concepto de prototype (creando objetos nuevos a partir de uno base).
	 * Otra opcion, es que la grilla cree el doble arreglo. e inicie los objetos, y en la gui se le cambie los colores en este metodo. para esto le pasariamos la grilla a la gui, y esta
	 * pediria el tablero, que es lo unico que necesitaria de la grilla.
	 */
	private void prepararGrilla() {
		tableroGrafico = new Bloque[cantFilas][cantColumnas];
		
		Bloque prototipo = new Bloque(0, 0, fondo);
		for (int fila = 0; fila < cantFilas; fila++) {
			for (int columna = 0; columna < cantColumnas; columna++) {
				Bloque nuevo = prototipo.clone();
				nuevo.setOpaque(true);
				nuevo.setPosicionFila(fila);
				nuevo.setPosicionColumna(columna);
				tableroGrafico[fila][columna] = nuevo;
				
				nuevo.pintar(fondo);
				
				panelIzq.add(nuevo);
			}
		}
	}
}
