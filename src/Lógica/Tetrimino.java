package Lógica;

public abstract class Tetrimino {
	protected int rotacion;
	protected Bloque[] bloquesIzq;
	protected Bloque[] bloquesDer;
	protected Bloque[] bloquesAbaj;
	//falta agregar los cuatro bloques que lo conforman (misBloques)
	
	public abstract void rotar();
	public abstract void getBloquesIzq();
	public abstract void getBloquesDer();
	public abstract void getBloquesAbaj();



}
