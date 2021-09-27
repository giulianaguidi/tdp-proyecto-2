package Lógica;

import java.awt.Color;

public abstract class Tetrimino {
	protected int rotacion=0;
	protected Color color;
	protected Bloque[] bloquesIzq;
	protected Bloque[] bloquesDer;
	protected Bloque[] bloquesAbaj;
	protected Bloque[] misBloques = new Bloque[4];
	
	
	public abstract void rotar();
	
	public abstract Bloque[] getBloquesIzq();
	
	public abstract Bloque[] getBloquesDer();
	
	public abstract Bloque[] getBloquesAbaj();
	
	public Bloque[] getBloques() {
		return this.misBloques;
	}
	
	public abstract Tetrimino clone();

	public abstract Color getColor() ;


}
