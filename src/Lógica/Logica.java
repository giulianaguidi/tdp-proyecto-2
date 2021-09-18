package Lógica;

import Gui.GUI;

public class Logica {
	protected int puntaje;
	protected Tetrimino tetriminoActual;
	protected Tetrimino tetriminoProximo;
	protected Tetrimino[] misTetriminos;
	protected int velocidad;
	protected int contador;
	protected Grilla miGrilla;
	protected Reloj reloj;
	protected GUI Gui;
	
	public Logica() {
		
	}
	
	public int getPuntaje() {
		return puntaje;
	}
	
	public Tetrimino getProxima() {
		return tetriminoProximo;
	}
	

}
