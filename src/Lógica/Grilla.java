package Lógica;

import java.awt.Color;

public class Grilla {
	protected Bloque[][] tablero;
	protected static final int cantFilas=21;
	protected static final int cantColumnas=10;
	protected static final Color color= new Color (119, 136, 153);//color ejemplo

	public Grilla() {
		tablero = new Bloque[cantFilas][cantColumnas];
	}
	
	public int[] getLineasLlenas(Tetrimino t) {
		Bloque [] bloques = t.getBloques();
		int filaB1= bloques[0].getPosicionFila();
		int filaB2= 22;
		int filaB3= 22;
		int filaB4= 22;
		boolean encontrado = false;
		int[] toReturn = new int[4];
		int contador = 0;
		
		for(int c = 0; c < cantColumnas && !encontrado; c++) {
			encontrado = tablero[filaB1][c].getColor() == color;
		}
		
		if(!encontrado) {
			toReturn[contador] = filaB1;
			contador++;
		}
		
		encontrado = false;
		
		if (bloques[1].getPosicionFila() != filaB1) {
			filaB2 = bloques[1].getPosicionFila();
			
			for(int c = 0; c < cantColumnas && !encontrado; c++) {
				encontrado = tablero[filaB2][c].getColor() == color;
			}
			
			if(!encontrado) {
				toReturn[contador] = filaB2;
				contador++;		
			}
			
			encontrado = false;
		}
		
		if (bloques[2].getPosicionFila() != filaB1 && bloques[2].getPosicionFila() != filaB2) {
			filaB3 = bloques[2].getPosicionFila();
			
			for(int c = 0; c < cantColumnas && !encontrado; c++) {
				encontrado = tablero[filaB3][c].getColor() == color;
			}
			
			if(!encontrado) {
				toReturn[contador] = filaB3;
				contador++;		
			}
			
			encontrado = false;
		}
		
		if (bloques[3].getPosicionFila() != filaB1 && bloques[3].getPosicionFila() != filaB2 && bloques[3].getPosicionFila() != filaB3) {
			filaB4 = bloques[3].getPosicionFila();
			
			for(int c = 0; c < cantColumnas && !encontrado; c++) {
				encontrado = tablero[filaB4][c].getColor() == color;
			}
			
			if(!encontrado) 
				toReturn[contador] = filaB4;		
			
			encontrado = false;
		}
		
		return toReturn;
		
	}
	
	public void eliminarLineas(int[] linea) {
		for(int i = 0; i < linea.length; i++) {
			for(int c = 0; c < cantColumnas; c++) {
				tablero[linea[i]][c].pintar(color);
			}
		}	
		acomodarTablero(linea);
	}
	
	public boolean puedeAparecer(Tetrimino t) {
		return false;
		
	}
	
	public boolean puedoMoverDerecha(Tetrimino t) {
		Bloque[] bloquesDerecha = t.getBloquesDer();
		boolean valido = true;
		for(int c = 0; c < bloquesDerecha.length && valido; c++) {
			valido = tablero[bloquesDerecha[c].getPosicionFila()][bloquesDerecha[c].getPosicionColumna() + 1].getColor() == color;
		}
		return valido;		
	}
	
	public boolean puedoMoverIzquierda(Tetrimino t) {
		Bloque[] bloquesIzquierda = t.getBloquesIzq();
		boolean valido = true;
		for(int c = 0; c < bloquesIzquierda.length && valido; c++) {
			valido = tablero[bloquesIzquierda[c].getPosicionFila()][bloquesIzquierda[c].getPosicionColumna() - 1].getColor() == color;
		}
		return valido;			
	}
	
	public boolean puedeDescender(Tetrimino t) {
		Bloque[] bloquesAbajo = t.getBloquesAbaj();
		boolean valido = true;
		for(int i = 0; i < bloquesAbajo.length && valido; i++) {
			valido = tablero[bloquesAbajo[i].getPosicionFila() + 1][bloquesAbajo[i].getPosicionColumna()].getColor() == color;
		}
		return valido;	
	}
	
	public boolean puedeRotar(Tetrimino t) {
		return false;	
	}
	
	private void acomodarTablero(int[] linea) {
		
	}
		
}