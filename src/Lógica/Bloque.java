package Lógica;

import java.awt.Color;

import javax.swing.JLabel;

public class Bloque extends JLabel {
	protected int posicionFila;
	protected int posicionColumna;
	protected Color color;
	
	public Bloque(int posF, int posC, Color color) {
		this.posicionFila= posF;
		this.posicionColumna=posC;
		this.color=color;
	}
	
	public void pintar (Color c) {
		this.color=c;
	}
	
	public void setPosicionFila(int pos) {
		this.posicionFila=pos;
	}
	
	public void setPosicionColumna (int pos) {
		this.posicionColumna=pos;
	}
	
	public int getPosicionFila() {
		return this.posicionFila;
	}
	
	public int getPosicionColumna() {
		return this.posicionColumna;
	}
	
	public Color getColor(){
		return this.color;
	}
}
