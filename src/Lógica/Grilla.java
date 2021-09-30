package Lógica;

import java.awt.Color;

public class Grilla {
	protected Bloque[][] tablero;
	protected static final int cantFilas = 21;
	protected static final int cantColumnas = 10;
	protected static final Color color = new Color(1, 1, 1);

	public Grilla(Bloque[][] miTablero) {
		tablero = miTablero;
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
		for (int i = 0; i < bloques.length; i++) {
			if (lineaNoChequeada(bloques,i)) {
				encontrado = chequearLineaLlena(bloques[i].getPosicionFila());
				toReturn[i] = encontrado ? bloques[i].getPosicionFila() : 22;
			}else{
				toReturn[i] = 22;
			}
		}
		return toReturn;
	}
	
	private boolean lineaNoChequeada(Bloque[] bloques, int i) {
		boolean yaChequeado = false;
		for (int j = 0; j < i && !yaChequeado; j++) {
			yaChequeado = bloques[j].getPosicionFila() == bloques[i].getPosicionFila();
		}
		return !yaChequeado;
	}

	private boolean chequearLineaLlena(int fila) {
		boolean filaLlena = true;
		for(int c = 0; c < cantColumnas && filaLlena; c++) {
			filaLlena = !tablero[fila][c].getColor().equals(color);
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
				if (linea[i] != 22)
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
		boolean cumple = true;
		Bloque[] misBloques = t.getBloques();
		int i = 0;
		while(cumple && i<misBloques.length){
			cumple = tablero[misBloques[i].getPosicionFila()][misBloques[i].getPosicionColumna()].getColor().equals(color);
			i++;
		}
		return cumple;
	}
	
	/*
	 * Verifica que el movimiento a derecha sea valido.
	 * @param Tetrimino t. tetrimino que se desea mover.
	 * @return boolean. verdader en caso  de que el movimiento sea valido. falso en caso contrario.
	 */
	public boolean puedoMoverDerecha(Tetrimino t) {
		Bloque[] bloquesDerecha = t.getBloquesDer();
		boolean valido = true;
		for(int c = 0; c < bloquesDerecha.length && valido; c++) {
			if (bloquesDerecha[c].getPosicionColumna() < cantColumnas-1)
				valido = tablero[bloquesDerecha[c].getPosicionFila()][bloquesDerecha[c].getPosicionColumna() + 1].getColor().equals(color);
			else
				valido = false;
		}
		return valido;		
	}
	
	/*
	 * Verifica que el movimiento a izquierda sea valido.
	 * @param Tetrimino t. tetrimino que se desea mover.
	 * @return boolean. verdader en caso  de que el movimiento sea valido. falso en caso contrario.
	 */
	public boolean puedoMoverIzquierda(Tetrimino t) {
		Bloque[] bloquesIzquierda = t.getBloquesIzq();
		boolean valido = true;
		for(int c = 0; c < bloquesIzquierda.length && valido; c++) {
			if (bloquesIzquierda[c].getPosicionColumna() > 0)
				valido = tablero[bloquesIzquierda[c].getPosicionFila()][bloquesIzquierda[c].getPosicionColumna() - 1].getColor().equals(color);
			else
				valido = false;
		}
		return valido;			
	}
	
	/*
	 * Verifica que el movimiento que se desea realizar sea valido.
	 * @param Tetrimino t. tetrimino que se desea mover.
	 * @return boolean. verdader en caso  de que el movimiento sea valido. falso en caso contrario.
	 */
	public boolean puedeDescender(Tetrimino t) {
		Bloque[] bloquesAbajo = t.getBloquesAbaj();
		boolean valido = true;
		for(int i = 0; i < bloquesAbajo.length && valido; i++) {
			if (bloquesAbajo[i].getPosicionFila() < cantFilas - 1)
				valido = tablero[bloquesAbajo[i].getPosicionFila() + 1][bloquesAbajo[i].getPosicionColumna()].getColor().equals(color);
			else
				valido = false;
		}
		return valido;	
	}

	
	/*
	 * Reorganiza el tablero segun cuantas lineas se eliminaron.
	 * @param int [] linea. Arreglo de enteros de las lineas eliminadas
	 */ 
	private void acomodarTablero(int[] linea) {
		for (int i = 0 ; i < linea.length ; i++) {
			if (linea[i] != 22) {
				for (int j = linea[i] - 1  ; j >= 0 && !chequearLineaVacia(j, linea); j--) {
					for (int c = 0 ; c < cantColumnas ; c++) {
						Color aux = tablero[j][c].getColor();
						tablero[j][c].pintar(tablero[j+1][c].getColor());
						tablero[j+1][c].pintar(aux);
					}
				}
			}
		}	
	}
		
	private boolean chequearLineaVacia(int fila, int borradas[]) {
		boolean lineaVacia = true ;
		for (int i = 0 ; i < borradas.length && lineaVacia; i++) {
			lineaVacia = fila != borradas[i];
		}
		for (int c = 0 ; c < cantColumnas && lineaVacia; c++) {
			lineaVacia = tablero[fila][c].getColor() == color;
		}
		return lineaVacia;
	}
	
	public Bloque obtenerBloque (int f, int c){
		return tablero[f][c];
	}
	
	public Color getColor() {
		return color;
	}
}