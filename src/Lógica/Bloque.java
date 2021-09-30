package Lógica;

import java.awt.Color;

import javax.swing.JLabel;

@SuppressWarnings("serial")
public class Bloque extends JLabel {
	protected int posicionFila;
	protected int posicionColumna;
	protected Color color;
	
	
	public Bloque(int posF, int posC) {
		this.posicionFila = posF;
		this.posicionColumna = posC;
	}
	
	public Bloque(int posF, int posC, Color color) {
		this.posicionFila = posF;
		this.posicionColumna = posC;
		this.color = color;
	}
	
	public void pintar (Color c) {
		this.color = c;
		this.setBackground(this.color);
		this.setForeground(this.color);
	}
	
	public void setPosicionFila(int pos) {
		this.posicionFila = pos;
	}
	
	public void setPosicionColumna (int pos) {
		this.posicionColumna = pos;
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
	
	public Bloque clone() {
		Color clonado = new Color(color.getRed(), color.getGreen(), color.getBlue());
		Bloque aRetornar = new Bloque(posicionFila, posicionColumna, clonado);
		return aRetornar;
	}
	
}
