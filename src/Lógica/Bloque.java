package Lógica;

import java.awt.Color;

import javax.swing.JLabel;

public class Bloque extends JLabel {
	protected int posicionFila;
	protected int posicionColumna;
	protected Color color;
	
	public Bloque() {
		
	}
	
	public void setPosicionFila(int pos) {
		posicionFila=pos;
	}
	
	public void setPosicionColumna (int pos) {
		posicionColumna=pos;
	}
	
	public int getPosicionFila() {
		return posicionFila;
	}
	
	public int getPosicionColumna() {
		return posicionColumna;
	}
	
	public Color getColor(){
		return color;
	}
}
