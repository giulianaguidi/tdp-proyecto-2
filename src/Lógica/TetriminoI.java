package Lógica;

import java.awt.Color;

public class TetriminoI extends Tetrimino{
	
	public TetriminoI (Bloque b11, Bloque b21, Bloque b31, Bloque b41) { 
		this.color= new Color(0, 255, 255);

		
		this.misBloques[0] = b11;
		this.misBloques[1] = b21;
		this.misBloques[2] = b31;
		this.misBloques[3] = b41;
		
		this.bloquesAbaj = new Bloque[1];
		this.bloquesIzq = new Bloque[4];
		this.bloquesDer = new Bloque[4];
		this.bloquesIzq[0] = b11;
		this.bloquesDer[0] = b11;
		this.bloquesIzq[1] = b21;
		this.bloquesDer[1] = b21;
		this.bloquesIzq[2] = b31;
		this.bloquesDer[2] = b31;
		this.bloquesIzq[3] = b41;
		this.bloquesDer[3] = b41;
		
		this.bloquesAbaj[0] = b41;
	}

	public void rotar(Bloque[][] TG) {
		girarTetrimino(TG);
		if (this.rotacion == 270) {
			this.rotacion = 0;							//en 0
			this.bloquesAbaj = new Bloque[1];			//Tetrimino:
			this.bloquesIzq = new Bloque[4];
			this.bloquesDer = new Bloque[4];
			this.bloquesIzq[0] = this.misBloques[3];			// b11	
			this.bloquesIzq[1] = this.misBloques[2];			// b21
			this.bloquesIzq[2] = this.misBloques[1];			// b31
			this.bloquesIzq[3] = this.misBloques[0];			// b41
			
			this.bloquesDer[0] = this.misBloques[3];			// b11	
			this.bloquesDer[1] = this.misBloques[2];			// b21
			this.bloquesDer[2] = this.misBloques[1];			// b31
			this.bloquesDer[3] = this.misBloques[0];			// b41

			this.bloquesAbaj[0] = this.misBloques[3];	 
														
		}else {
			if (this.rotacion == 90) {					//en 180
				this.bloquesAbaj = new Bloque[1];		//Tetrimino:
				this.bloquesIzq = new Bloque[4];		// b41
				this.bloquesDer = new Bloque[4];
				this.bloquesIzq[0] = this.misBloques[3];		// b31	
				this.bloquesIzq[1] = this.misBloques[2];		// b21
				this.bloquesIzq[2] = this.misBloques[1];		// b11
				this.bloquesIzq[3] = this.misBloques[0];		//
				this.bloquesDer[0] = this.misBloques[3];			// b11	
				this.bloquesDer[1] = this.misBloques[2];			// b21
				this.bloquesDer[2] = this.misBloques[1];			// b31
				this.bloquesDer[3] = this.misBloques[0];			// b41
				this.bloquesAbaj[0] = this.misBloques[0];//
														
			}else {
				if (this.rotacion == 180) {						//en 270
					this.bloquesIzq = new Bloque[1];			//en 90
					this.bloquesDer = new Bloque[1];			//Tetrimino:
					this.bloquesAbaj = new Bloque[4];				// b11  b21  b31  b41
					this.bloquesAbaj[0] = this.misBloques[3];			
					this.bloquesAbaj[1] = this.misBloques[2];			
					this.bloquesAbaj[2] = this.misBloques[1];			
					this.bloquesAbaj[3] = this.misBloques[0];			
					this.bloquesIzq[0] = this.misBloques[0];	//
					this.bloquesDer[0] = this.misBloques[3];	//
				}else {
					this.bloquesIzq = new Bloque[1];			//en 90
					this.bloquesDer = new Bloque[1];			//Tetrimino:
					this.bloquesAbaj = new Bloque[4];			// b41  b31  b21  b11
					this.bloquesAbaj[0] = this.misBloques[3];		//
					this.bloquesAbaj[1] = this.misBloques[2];		//
					this.bloquesAbaj[2] = this.misBloques[1];		//
					this.bloquesAbaj[3] = this.misBloques[0];		//
					this.bloquesIzq[0] = this.misBloques[3]; //
					this.bloquesDer[0] = this.misBloques[0];	//
					}
			}
			this.rotacion += 90;

		}
	}

	private void girarTetrimino(Bloque[][] TG) {
		Bloque [][] tableroGrafico = TG;
		int fila;
		int columna;
		switch(rotacion) {
		case 0: {
			
			fila = misBloques[0].getPosicionFila() + 1;
			columna = misBloques[0].getPosicionColumna() + 2;
			misBloques[0] = tableroGrafico[fila][columna];
			
			fila = misBloques[1].getPosicionFila();
			columna = misBloques[1].getPosicionColumna() + 1;
			misBloques[1] = tableroGrafico[fila][columna];
			
			fila = misBloques[2].getPosicionFila() - 1;
			columna = misBloques[2].getPosicionColumna();
			misBloques[2] = tableroGrafico[fila][columna];
			
			fila = misBloques[3].getPosicionFila() - 2;
			columna = misBloques[3].getPosicionColumna() - 1;
			misBloques[3] = tableroGrafico[fila][columna];
			break;
			}
		case 90: {
			

			fila = misBloques[0].getPosicionFila() + 2;
			columna = misBloques[0].getPosicionColumna() - 2;
			misBloques[0] = tableroGrafico[fila][columna];
			
			fila = misBloques[1].getPosicionFila() + 1;
			columna = misBloques[1].getPosicionColumna() - 1;
			misBloques[1] = tableroGrafico[fila][columna];
			
			fila = misBloques[3].getPosicionFila() - 1;
			columna = misBloques[3].getPosicionColumna() + 1;
			misBloques[3] = tableroGrafico[fila][columna];
			break;
			}
		case 180: {
			
			fila = misBloques[0].getPosicionFila() - 2;
			columna = misBloques[0].getPosicionColumna() - 1;
			misBloques[0] = tableroGrafico[fila][columna];
			
			fila = misBloques[1].getPosicionFila() - 1;
			columna = misBloques[1].getPosicionColumna();
			misBloques[1] = tableroGrafico[fila][columna];
			
			fila = misBloques[2].getPosicionFila();
			columna = misBloques[2].getPosicionColumna() + 1;
			misBloques[2] = tableroGrafico[fila][columna];
			
			fila = misBloques[3].getPosicionFila() + 1;
			columna = misBloques[3].getPosicionColumna() + 2;
			misBloques[3] = tableroGrafico[fila][columna];
			break;
			}
		case 270: {
			
			fila = misBloques[0].getPosicionFila() - 1;
			columna = misBloques[0].getPosicionColumna() + 1;
			misBloques[0] = tableroGrafico[fila][columna];
			
			fila = misBloques[2].getPosicionFila() + 1;
			columna = misBloques[2].getPosicionColumna() - 1;
			misBloques[2] = tableroGrafico[fila][columna];
			
			fila = misBloques[3].getPosicionFila() + 2;
			columna = misBloques[3].getPosicionColumna() - 2;
			misBloques[3] = tableroGrafico[fila][columna];
			break;
			}
		}
	}

	@Override
	public Bloque[] getBloquesIzq() {
		return bloquesIzq;
	}

	@Override
	public Bloque[] getBloquesDer() {
		return bloquesDer;
	}

	@Override
	public Bloque[] getBloquesAbaj() {
		return bloquesAbaj;
	}

	@Override
	public Tetrimino clone() {
		return new TetriminoI(misBloques[0], misBloques[1], misBloques[2], misBloques[3]);
	}

	@Override
	public Color getColor() {
		return this.color;
	}

	@Override
	public boolean puedeRotar(Bloque[][] tableroGrafico, Color fondo) {
		boolean cumple = true;
		int fila;
		int columna;
		switch(rotacion) {
		case 0: {

			fila = misBloques[0].getPosicionFila() + 1;
			columna = misBloques[0].getPosicionColumna() + 2;
			if (fila > tableroGrafico.length - 1 || columna > tableroGrafico[0].length - 1) 
				cumple = false;
			else 
				cumple = cumple && tableroGrafico[fila][columna].getColor().equals(fondo);

			fila = misBloques[1].getPosicionFila();
			columna = misBloques[1].getPosicionColumna() + 1;
			if (fila > tableroGrafico.length - 1 || columna > tableroGrafico[0].length - 1) 
				cumple = false;
			else 
				cumple = cumple && tableroGrafico[fila][columna].getColor().equals(fondo);
							
			fila = misBloques[3].getPosicionFila() - 2;
			columna = misBloques[3].getPosicionColumna() - 1;
			if (fila < 0 || columna < 0) 
				cumple = false;
			else 
				cumple = cumple && tableroGrafico[fila][columna].getColor().equals(fondo);

			break;
		}
		case 90: {

			fila = misBloques[0].getPosicionFila() + 2;
			columna = misBloques[0].getPosicionColumna() - 2;
			if (fila < 0 || columna < 0)
				cumple = false;
			else
				cumple = cumple && tableroGrafico[fila][columna].getColor().equals(fondo);
		
			fila = misBloques[2].getPosicionFila() + 1;
			columna = misBloques[2].getPosicionColumna();
			if (fila < 0 || columna > tableroGrafico[0].length - 1)
				cumple = false;
			else
				cumple = cumple && tableroGrafico[fila][columna].getColor().equals(fondo);
			
			fila = misBloques[3].getPosicionFila() + 2;
			columna = misBloques[3].getPosicionColumna() + 1;
			if (fila > tableroGrafico.length - 1 || columna > tableroGrafico[0].length - 1)
				cumple = false;
			else
				cumple = cumple && tableroGrafico[fila][columna].getColor().equals(fondo);
			break;
		}
		case 180: {
			
			fila = misBloques[0].getPosicionFila() + 1;
			columna = misBloques[0].getPosicionColumna() + 2;
			if (fila > tableroGrafico.length - 1 || columna > tableroGrafico[0].length - 1)
				cumple = false;
			else
				cumple = cumple && tableroGrafico[fila][columna].getColor().equals(fondo);
			
			fila = misBloques[2].getPosicionFila();
			columna = misBloques[2].getPosicionColumna() + 1;
			if (fila > tableroGrafico.length - 1 || columna > tableroGrafico[0].length - 1)
				cumple = false;
			else
				cumple = cumple && tableroGrafico[fila][columna].getColor().equals(fondo);
			
			fila = misBloques[3].getPosicionFila() - 2;
			columna = misBloques[3].getPosicionColumna() - 1;
			if (fila < 0 || columna < 0)
				cumple = false;
			else
				cumple = cumple && tableroGrafico[fila][columna].getColor().equals(fondo);
			break;
		}
		case 270: {

			fila = misBloques[0].getPosicionFila() - 1;
			columna = misBloques[0].getPosicionColumna() + 1;
			if (fila < 0 || columna < 0)
				cumple = false;
			else
				cumple = cumple && tableroGrafico[fila][columna].getColor().equals(fondo);
			
			fila = misBloques[2].getPosicionFila() + 1;
			columna = misBloques[2].getPosicionColumna() - 1;
			if (fila < 0 || columna > tableroGrafico[0].length - 1)
				cumple = false;
			else
				cumple = cumple && tableroGrafico[fila][columna].getColor().equals(fondo);
			
			fila = misBloques[3].getPosicionFila() + 2;
			columna = misBloques[3].getPosicionColumna() - 2;
			if (fila > tableroGrafico.length - 1 || columna > tableroGrafico[0].length - 1)
				cumple = false;
			else
				cumple = cumple && tableroGrafico[fila][columna].getColor().equals(fondo);
			break;
			}
		}
		return cumple;
	}

}
