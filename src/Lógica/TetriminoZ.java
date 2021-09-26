package Lógica;

import java.awt.Color;

public class TetriminoZ extends Tetrimino {

	public TetriminoZ(Bloque b11, Bloque b12, Bloque b22, Bloque b23) {
		this.color= new Color(255,0,0);							   
		
		this.misBloques[0] = b11;	//  b11 b12
		this.misBloques[1] = b12;	//	    b22 b23
		this.misBloques[2] = b22;	//
		this.misBloques[3] = b23;	//
		
		bloquesIzq = new Bloque[1];
		bloquesDer = new Bloque[1];
		bloquesAbaj = new Bloque[2];
		
		bloquesIzq[0] = b11;
		bloquesDer[0] = b23;
		bloquesAbaj[0] = b22;
		bloquesAbaj[1] = b23;
	}
	
	@Override
	public void rotar() {
		if (this.rotacion == 270) {
			rotacion = 0;
			bloquesIzq = new Bloque[1];				// en 0					
			bloquesDer = new Bloque[1];				// Tetrimino:
			bloquesAbaj = new Bloque[2];			//	b11	  b12
			bloquesIzq[0] = misBloques[0];			//	  	  b22  b23
			bloquesDer[0] = misBloques[3];			//
			bloquesAbaj[0] = misBloques[2];			//
			bloquesAbaj[1] = misBloques[3];			//
			
		}else {
			if (this.rotacion==90) {			
				bloquesIzq = new Bloque[1];				// en 180
				bloquesDer = new Bloque[1];				// Tetrimino:
				bloquesAbaj = new Bloque[2];			//	b23	  b22
				bloquesIzq[0] = misBloques[3];			//	  	  b12  b11
				bloquesDer[0] = misBloques[0];			//
				bloquesAbaj[0] = misBloques[0];			//
				bloquesAbaj[1] = misBloques[1];			//
			}else {
				if (this.rotacion == 180) {
					this.bloquesIzq = new Bloque[2];		// en 270
					this.bloquesDer = new Bloque[2];		// Tetrimino:
					this.bloquesAbaj = new Bloque [1];		//		  b23
					this.bloquesAbaj[0] = misBloques[0];	//	 b12  b22 
					this.bloquesIzq[0] = this.misBloques[0]; //	 b11  
					this.bloquesIzq[1] = this.misBloques[1]; //
					this.bloquesDer[0] = this.misBloques[2]; //
					this.bloquesDer[1] = this.misBloques[3]; //
				}
				else {
					this.bloquesIzq = new Bloque[2];		// en 90
					this.bloquesDer = new Bloque[2];		// Tetrimino:
					this.bloquesAbaj = new Bloque [1];		//		  b11
					this.bloquesAbaj[0] = misBloques[3];	//	 b22  b12 
					this.bloquesIzq[0] = this.misBloques[2]; //	 b23  
					this.bloquesIzq[1] = this.misBloques[3]; //
					this.bloquesDer[0] = this.misBloques[0]; //
					this.bloquesDer[1] = this.misBloques[1]; //
				}
			}
			this.rotacion+=90;
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
		// TODO Auto-generated method stub
		return new TetriminoL(misBloques[0], misBloques[1], misBloques[2], misBloques[3]);
	}
}
