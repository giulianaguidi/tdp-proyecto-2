package Lógica;

import java.awt.Color;

public class TetriminoL extends Tetrimino {
	 
	public TetriminoL(Bloque b13, Bloque b21, Bloque b22, Bloque b23) {
		this.color= new Color(255,200,0);
	
		
		this.misBloques[0] = b13;
		this.misBloques[1] = b21;
		this.misBloques[2] = b22;
		this.misBloques[3] = b23;
		
		this.bloquesAbaj = new Bloque[3];
		this.bloquesIzq = new Bloque[2];
		this.bloquesDer = new Bloque[2];
		
		this.bloquesIzq[0] = b21; 
		this.bloquesIzq[1] = b13;
		this.bloquesDer[0] = b13;
		this.bloquesDer[1] = b23;
		this.bloquesAbaj[0] = b21;
		this.bloquesAbaj[1] = b22;
		this.bloquesAbaj[2] = b23;
	}
	
	@Override
	public void rotar(Bloque [][] TG) {
		girarTetrimino(TG);
		if (this.rotacion == 270) {
			rotacion = 0;
			this.bloquesAbaj = new Bloque[3];	//en 0			
			this.bloquesIzq = new Bloque[2];		//Tetrimino:
			this.bloquesDer = new Bloque[2];		//			      b13
			this.bloquesIzq[0] = this.misBloques[1]; 	//  b21  b22  b23
			this.bloquesIzq[1] = this.misBloques[0];
			this.bloquesDer[0] = this.misBloques[0];	//
			this.bloquesDer[1] = this.misBloques[3];	//
			this.bloquesAbaj[0] = this.misBloques[1];	//
			this.bloquesAbaj[1] = this.misBloques[2];	//
			this.bloquesAbaj[2] = this.misBloques[3];	//
			
		}else {
			
			if (this.rotacion==90) {
				this.bloquesIzq = new Bloque [2];	//en 180
				this.bloquesDer = new Bloque [2];	//Tetrimino:
				this.bloquesAbaj = new Bloque [3];	// b23  b22  b21
				this.bloquesIzq[0] = this.misBloques[3];	// b13
				this.bloquesIzq[1] = this.misBloques[0];	//
				this.bloquesDer[0] = this.misBloques[1];	//
				this.bloquesDer[1] = this.misBloques[0];
				this.bloquesAbaj[0] = this.misBloques[0];//
				this.bloquesAbaj[1] = this.misBloques[2];
				this.bloquesAbaj[2] = this.misBloques[1];
			}else {
				if (this.rotacion == 180) {
					this.bloquesIzq = new Bloque[3];		//en 270
					this.bloquesDer = new Bloque[3];		//Tetrimino:
					this.bloquesAbaj = new Bloque [2];		//  b13  b23
					this.bloquesAbaj[0] = this.misBloques[1];	//		 b22
					this.bloquesIzq[0] = this.misBloques[0]; //       b21
					this.bloquesIzq[1] = this.misBloques[2];
					this.bloquesIzq[2] = this.misBloques[1];
					this.bloquesDer[0] = this.misBloques[3];	//
					this.bloquesDer[1] = this.misBloques[2];	//
					this.bloquesDer[2] = this.misBloques[1];	//
					this.bloquesAbaj[1] = this.misBloques[0];
				}
				else {
					this.bloquesIzq = new Bloque[3];		//en 90
					this.bloquesDer = new Bloque[3];		//Tetrimino:
					this.bloquesAbaj = new Bloque [2];		//  b21
					this.bloquesAbaj[0] = this.misBloques[3];	//  b22
					this.bloquesAbaj[1] = this.misBloques[0];	//  b23  b13
					this.bloquesIzq[0] = this.misBloques[1]; //
					this.bloquesIzq[1] = this.misBloques[2];	//
					this.bloquesIzq[2] = this.misBloques[3];	//
					this.bloquesDer[0] = this.misBloques[0];	//
					this.bloquesDer[1] = this.misBloques[2];
					this.bloquesDer[2] = this.misBloques[1];
				}
			}
			this.rotacion+=90;
		}
	}

	private void girarTetrimino(Bloque [][] TG) {
		// TODO Auto-generated method stub
		int rotacion = getRotacion();
		Bloque [][] tableroGrafico = TG;
		int fila;
		int columna;
		switch(rotacion) {
		case 0: {
			fila = misBloques[1].getPosicionFila()-1;
			columna = misBloques[1].getPosicionColumna()+1;

			misBloques[1] = tableroGrafico[fila][columna];
			fila = misBloques[3].getPosicionFila() + 1;
			columna = misBloques[3].getPosicionColumna() - 1;

			misBloques[3] = tableroGrafico[fila][columna];
			fila = misBloques[0].getPosicionFila() + 2;
			columna = misBloques[0].getPosicionColumna();

			misBloques[0] = tableroGrafico[fila][columna];
				
		break;}
		case 90: {
			fila = misBloques[1].getPosicionFila()+1;
			columna = misBloques[1].getPosicionColumna()+1;

			misBloques[1] = tableroGrafico[fila][columna];
			fila = misBloques[3].getPosicionFila() - 1;
			columna = misBloques[3].getPosicionColumna() - 1;

			misBloques[3] = tableroGrafico[fila][columna];
			fila = misBloques[0].getPosicionFila();
			columna = misBloques[0].getPosicionColumna() - 2;

			misBloques[0] = tableroGrafico[fila][columna];
			 break;}
		case 180: {
			fila = misBloques[1].getPosicionFila() + 1;
			columna = misBloques[1].getPosicionColumna() - 1;

			misBloques[1] = tableroGrafico[fila][columna];
			fila = misBloques[3].getPosicionFila() - 1;
			columna = misBloques[3].getPosicionColumna() + 1;

			misBloques[3] = tableroGrafico[fila][columna];
			fila = misBloques[0].getPosicionFila() - 2;
			columna = misBloques[0].getPosicionColumna();

			misBloques[0] = tableroGrafico[fila][columna];
			 break;}
		case 270: {
			fila = misBloques[1].getPosicionFila() - 1;
			columna = misBloques[1].getPosicionColumna() - 1;

			misBloques[1] = tableroGrafico[fila][columna];
			fila = misBloques[3].getPosicionFila() + 1;
			columna = misBloques[3].getPosicionColumna() + 1;

			misBloques[3] = tableroGrafico[fila][columna];
			fila = misBloques[0].getPosicionFila();
			columna = misBloques[0].getPosicionColumna() + 2;

			misBloques[0] = tableroGrafico[fila][columna];
			 break;}
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
		return new TetriminoL(misBloques[0], misBloques[1], misBloques[2], misBloques[3]);
	}

	@Override
	public Color getColor() {
		return color;
	}

	@Override
	public boolean puedeRotar(Bloque[][] tableroGrafico, Color fondo) {
		// TODO Auto-generated method stub
		boolean cumple = true;
		int fila;
		int columna;
		switch(rotacion) {
		case 0: {
			fila = misBloques[1].getPosicionFila()-1;
			columna = misBloques[1].getPosicionColumna()+1;
			if (fila < 0 || columna > tableroGrafico[0].length - 1)
				cumple = false;
			else	
				cumple = tableroGrafico[fila][columna].getColor().equals(fondo);
			
			fila = misBloques[3].getPosicionFila() + 1;
			columna = misBloques[3].getPosicionColumna() - 1;
			if (fila > tableroGrafico.length - 1 || columna < 0)
				cumple = false;
			else
				cumple = cumple && tableroGrafico[fila][columna].getColor().equals(fondo);
			
			fila = misBloques[0].getPosicionFila() + 2;
			columna = misBloques[0].getPosicionColumna();
			if (fila > tableroGrafico.length - 1 || columna < 0)
				cumple = false;
			else	
				cumple = cumple && tableroGrafico[fila][columna].getColor().equals(fondo);	
		break;}
		case 90: {
			fila = misBloques[1].getPosicionFila()+1;
			columna = misBloques[1].getPosicionColumna()+1;
			if (fila > tableroGrafico.length - 1 || columna > tableroGrafico[0].length - 1)
				cumple = false;
			else	
				cumple = cumple && tableroGrafico[fila][columna].getColor().equals(fondo);
			
			fila = misBloques[3].getPosicionFila() - 1;
			columna = misBloques[3].getPosicionColumna() - 1;
			if (fila < 0 || columna < 0)
				cumple = false;
			else
				cumple = cumple && tableroGrafico[fila][columna].getColor().equals(fondo);
			
			fila = misBloques[0].getPosicionFila();
			columna = misBloques[0].getPosicionColumna() - 2;
			if (fila > tableroGrafico.length - 1 || columna < 0)
				cumple = false;
			else
				cumple = cumple && tableroGrafico[fila][columna].getColor().equals(fondo);
		break;}
		case 180: {
			fila = misBloques[1].getPosicionFila() + 1;
			columna = misBloques[1].getPosicionColumna() - 1;
			if (fila > tableroGrafico.length - 1 || columna < 0)
				cumple = false;
			else
				cumple = cumple && tableroGrafico[fila][columna].getColor().equals(fondo);
			
			fila = misBloques[3].getPosicionFila() - 1;
			columna = misBloques[3].getPosicionColumna() + 1;
			if (fila < 0 || columna > tableroGrafico[0].length - 1)
				cumple = false;
			else
				cumple = cumple && tableroGrafico[fila][columna].getColor().equals(fondo);
			
			fila = misBloques[0].getPosicionFila() - 2;
			columna = misBloques[0].getPosicionColumna();
			if (fila < 0 || columna < 0)
				cumple = false;
			else
				cumple = cumple && tableroGrafico[fila][columna].getColor().equals(fondo);
		break;}
		case 270: {
			fila = misBloques[1].getPosicionFila() - 1;
			columna = misBloques[1].getPosicionColumna() + 1;
			if (fila < 0 || columna > tableroGrafico[0].length - 1)
				cumple = false;
			else
				cumple = cumple && tableroGrafico[fila][columna].getColor().equals(fondo);
			
			fila = misBloques[3].getPosicionFila() + 1;
			columna = misBloques[3].getPosicionColumna() + 1;
			if (fila > tableroGrafico.length - 1 || columna > tableroGrafico[0].length - 1)
				cumple = false;
			else
				cumple = cumple && tableroGrafico[fila][columna].getColor().equals(fondo);
			
			fila = misBloques[0].getPosicionFila();
			columna = misBloques[0].getPosicionColumna() + 2;
			if (fila < 0 || columna > tableroGrafico[0].length - 1)
				cumple = false;
			else
				cumple = cumple && tableroGrafico[fila][columna].getColor().equals(fondo);
			break;}
		}
		return cumple;
	}
}
