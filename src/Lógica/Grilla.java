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
	
	/*
	 * Metodo para obtener las lineas que se lograron llenar, es decir las que por logica se deben eliminar. Debido a que por logica del juego estas seran entre
	 * 0, 1, 2, 3 o 4, se decidio utilizar un arreglo de 4 espacios.
	 * @param Tetrimino t. 
	 * @return int[]. Arreglo que guardara las posiciones de las filas que se lograron llenar.
	 */
	
	public int[] getLineasLlenas(Tetrimino t) {
		Bloque [] bloques = t.getBloques();
		boolean encontrado = false;
		int[] toReturn = new int[4];
		for (int i=0 ; i<bloques.length ; i++) {
			if (lineaNoChequeada(bloques,i)) {
				encontrado = chequearLineaLlena(bloques[i].getPosicionFila());
				toReturn[i] = encontrado ? bloques[i].getPosicionFila() : 22;
			}
		}
		return toReturn;
	}
	
	private boolean lineaNoChequeada(Bloque[] bloques, int i) {
		boolean yaChequeado = false;
		for (int j=0 ; j<i && !yaChequeado ; j++) {
			yaChequeado = bloques[j].getPosicionFila() == bloques[i].getPosicionFila();
		}
		return !yaChequeado;
	}

	private boolean chequearLineaLlena(int fila) {
		boolean filaLlena = true;
		for(int c = 0; c < cantColumnas && filaLlena; c++) {
			filaLlena = tablero[fila][c].getColor() != color;
		}
		return filaLlena;
	}

	/*
	 * Metodo encargado de eliminar las lineas que estan llenas.
	 * @param int[] linea. Arreglo que contiene las posiciones de la o las filas llenas. vacio en caso de que no se llenaran filas.
	 * 
	 */
	
	public void eliminarLineas(int[] linea) {
		for(int i = 0; i < linea.length; i++) {
			for(int c = 0; c < cantColumnas; c++) {
				tablero[linea[i]][c].pintar(color);
			}
		}	
		acomodarTablero(linea);
	}
	
	/*
	 * En este metodo se recibira un tetrimino, del cual se obtendra su "forma" mediante las posiciones de los bloques que lo componene
	 * y se verificara que esas casillas de la grilla o bloques, se encuentren disponibles. Se retornara verdadero si la accion es realizable
	 * @param Tetrimino t. Tetrimino a verificar que sea posible insertarse en la grilla.
	 * @return boolean verdader en caso de que se pueda colocar el tetrimino. falso en caso contrario.
	 */
	public boolean puedeAparecer(Tetrimino t) {
		return false;
		
	}
	
	/*
	 * Metodo para verificar que el movimiento que se desea realizar sea valido.
	 * @param Tetrimino t. tetrimino que se desea mover.
	 * @return boolean. verdader en caso  de que el movimiento sea valido. falso en caso contrario.
	 */
	public boolean puedoMoverDerecha(Tetrimino t) {
		Bloque[] bloquesDerecha = t.getBloquesDer();
		boolean valido = true;
		for(int c = 0; c < bloquesDerecha.length && valido; c++) {
			valido = tablero[bloquesDerecha[c].getPosicionFila()][bloquesDerecha[c].getPosicionColumna() + 1].getColor() == color;
		}
		return valido;		
	}
	
	/*
	 * Metodo para verificar que el movimiento que se desea realizar sea valido.
	 * @param Tetrimino t. tetrimino que se desea mover.
	 * @return boolean. verdader en caso  de que el movimiento sea valido. falso en caso contrario.
	 */
	public boolean puedoMoverIzquierda(Tetrimino t) {
		Bloque[] bloquesIzquierda = t.getBloquesIzq();
		boolean valido = true;
		for(int c = 0; c < bloquesIzquierda.length && valido; c++) {
			valido = tablero[bloquesIzquierda[c].getPosicionFila()][bloquesIzquierda[c].getPosicionColumna() - 1].getColor() == color;
		}
		return valido;			
	}
	
	/*
	 * Metodo para verificar que el movimiento que se desea realizar sea valido.
	 * @param Tetrimino t. tetrimino que se desea mover.
	 * @return boolean. verdader en caso  de que el movimiento sea valido. falso en caso contrario.
	 */
	public boolean puedeDescender(Tetrimino t) {
		Bloque[] bloquesAbajo = t.getBloquesAbaj();
		boolean valido = true;
		for(int i = 0; i < bloquesAbajo.length && valido; i++) {
			valido = tablero[bloquesAbajo[i].getPosicionFila() + 1][bloquesAbajo[i].getPosicionColumna()].getColor() == color;
		}
		return valido;	
	}
	
	/*
	 * Metodo para verificar que el movimiento que se desea realizar sea valido.
	 * @param Tetrimino t. tetrimino que se desea mover.
	 * @return boolean. verdader en caso  de que el movimiento sea valido. falso en caso contrario.
	 */
	public boolean puedeRotar(Tetrimino t) {
		return false;	
	}
	
	/*
	 *
	 */
	private void acomodarTablero(int[] linea) {
		
	}
		
}