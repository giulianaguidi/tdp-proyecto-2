package Gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.border.EmptyBorder;

import Lógica.Bloque;
import Lógica.Logica;
import Lógica.Tetrimino;

import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;


public class GUI extends JFrame implements KeyListener{
	private JSplitPane splitPane;
	private JPanel panelIzq;
	private JPanel panelDer;
	protected Bloque[][] tableroGrafico;
	protected Bloque[][] proximoTetrimino;
	protected static final int cantFilas=21;
	protected static final int cantColumnas=10;
	protected JLabel tiempo;
	protected JLabel puntos;
	protected Logica miLogica;
	
	
	protected static final Color fondo = new Color(1, 1, 1);
	
	
	//Esto esta para probar los colores
	protected static final Color I = new Color(0, 255, 255);
	protected static final Color J = new Color(0, 0 ,255); 
	protected static final Color L = new Color(255, 200, 0);
	protected static final Color O = new Color(255, 255, 0);
	protected static final Color S = new Color(0, 255, 0);
	protected static final Color T = new Color(148, 0, 211);
	protected static final Color Z = new Color(255, 0, 0);

	
	// Estos valores estan para poder dividir el panel en 2
	protected static final int dimensionX = 1024;
	protected static final int dimensionY = 760;
	private JLabel tetriminoProximo;
	private JPanel panel_1;
	
	
	public GUI(Logica l) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(GUI.class.getResource("/images/icon-tetris.png")));
		miLogica = l;
		initialize();
	}
	
	public void initialize() {
		panelIzq = new JPanel();
		panelIzq.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelIzq.setBackground(new Color(47,79,79));
		panelIzq.setLayout(new GridLayout(cantFilas + 1, cantColumnas + 1, 5, 5));
		
		panelDer = new JPanel();
		panelDer.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelDer.setBackground(new Color(255-47, 255-79, 255-79));
		
		this.addKeyListener(this);
		
		splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panelIzq, panelDer );
		splitPane.setEnabled(false);
		
		splitPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		splitPane.setBackground(new Color(255, 255, 255));
		splitPane.setDividerLocation(dimensionX / 2);
		
		Dimension d = new Dimension();
		d.setSize(splitPane.getSize().getWidth() / 2, splitPane.getSize().getHeight());
		
		panelDer.setSize(d);
		
		
		setTitle("¡Juega al Tetris!");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(new Dimension(dimensionX, dimensionY));
		setResizable(false);
		setContentPane(splitPane);
		splitPane.getSize().getWidth();
		puntos= new JLabel();
		puntos.setFont(new Font("Consolas", Font.BOLD, 16));
		puntos.setBounds(106, 25, 90, 19);


		prepararGrillaIzq();
		prepararGrillaDer();

		
	}
	
	public void pintarFondo(Bloque[] fondos){
		int posFila;
		int posColumna;
		for (int i = 0; i < fondos.length; i++){
			posFila = fondos[i].getPosicionFila();
			posColumna = fondos[i].getPosicionColumna();
			tableroGrafico[posFila][posColumna].pintar(fondo);
		} 
	}

	public void pintarNuevo(Bloque[] bloques, Color color) {
		int posFila;
		int posColumna;
		for (int i = 0; i < bloques.length; i++){
			posFila = bloques[i].getPosicionFila();
			posColumna = bloques[i].getPosicionColumna();
			tableroGrafico[posFila][posColumna].pintar(color);
		} 
	}

	public Bloque[][] getTableroGrafico(){
		return this.tableroGrafico;
	}


	public JLabel getTiempo(){
		return this.tiempo;
	}
	
	public JLabel getPuntos() {
		return this.puntos;
	}

	
	private void prepararGrillaDer() {
		panelDer.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 240, 245));
		panel.setBounds(114, 98, 221, 60);
		panelDer.add(panel);
		panel.setLayout(null);
		puntos.setText("0");
		panel.add(puntos);
		
		JLabel Puntaje_obtenido = new JLabel("Puntaje:");
		Puntaje_obtenido.setFont(new Font("Consolas", Font.BOLD, 16));
		Puntaje_obtenido.setBounds(10, 25, 72, 19);
		panel.add(Puntaje_obtenido);
		
		tetriminoProximo = new JLabel("Proximo Tetrimino:");
		tetriminoProximo.setFont(new Font("Consolas", Font.BOLD, 16));
		tetriminoProximo.setBounds(114, 197, 207, 33);
		panelDer.add(tetriminoProximo);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 245, 238));
		panel_1.setBounds(112, 11, 221, 60);
		panelDer.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel Tiempo_Transcurrido = new JLabel();
		Tiempo_Transcurrido.setBounds(10, 11, 129, 40);
		panel_1.add(Tiempo_Transcurrido);
		Tiempo_Transcurrido.setFont(new Font("Consolas", Font.BOLD, 16));
		Tiempo_Transcurrido.setText("Tiempo: ");
		
		tiempo = new JLabel();
		tiempo.setBounds(106, 18, 105, 27);
		panel_1.add(tiempo);
		tiempo.setFont(new Font("Consolas", Font.BOLD, 16));
		tiempo.setHorizontalAlignment(SwingConstants.RIGHT);
		
		tiempo.setText("00");
		
		Bloque B;
		proximoTetrimino = new Bloque[4][3];
		int boundX = 114;
		int boundY = 241;
		int boundWidth = 46;
		int boundHeight = 14;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 3; j++) {
				B = new Bloque(i, j, fondo);
				B.setBounds(boundX, boundY, boundWidth, boundHeight);
				proximoTetrimino[i][j] = B;
				B.setOpaque(true);
				B.pintar(fondo);
				panelDer.add(B);
				boundX+=56;
			}
			boundX = 114;
			boundY+=25;
		}		
		
	}

	/*
	 * En este metodo tenemos que hacer 2 for anidados para que clonen un bloque ya creado, y le cambiamos la posicion, o creamos un bloque y le seteamos posicion y coloro.
	 * ambas formas son validas, una es usando el concepto de prototype (creando objetos nuevos a partir de uno base).
	 * Otra opcion, es que la grilla cree el doble arreglo. e inicie los objetos, y en la gui se le cambie los colores en este metodo. para esto le pasariamos la grilla a la gui, y esta
	 * pediria el tablero, que es lo unico que necesitaria de la grilla.
	 */
	private void prepararGrillaIzq() {
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

	// ESTE METODO LO USAMOS PARA CUANDO SE PRESIONA UNA TECLA
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == e.VK_LEFT)
			miLogica.moverIzquierda();
		if (e.getKeyCode() == e.VK_RIGHT)
			miLogica.moverDerecha();
		if (e.getKeyCode() == e.VK_UP)
			miLogica.rotarTetrimino();
		if (e.getKeyCode() == e.VK_DOWN)
			miLogica.bajarTetrimino();
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		
	}

	public void pintarProximoTetriminoGrafico(Tetrimino proximo) {
		// TODO Auto-generated method stub
		Bloque[] auxiliar = proximo.getBloques();
		for (int i = 0; i < auxiliar.length; i++) {
			int fila = auxiliar[i].getPosicionFila();
			int columna = auxiliar[i].getPosicionColumna()-4;
			proximoTetrimino[fila][columna].pintar(proximo.getColor());
		}
	}

	public void repintarProximoTetrimino() {
		// TODO Auto-generated method stub
		for(int fila = 0; fila<proximoTetrimino.length;fila++) {
			for (int columna = 0; columna<proximoTetrimino[fila].length;columna++) {
				proximoTetrimino[fila][columna].pintar(fondo);
			}
		}
	}
}
