package Lógica;

import java.awt.Color;

public class TetriminoT extends Tetrimino {
	public TetriminoT() {
		this.color= new Color(148,0,211);
		Bloque b12= new Bloque(0, 4, this.color);  //         b12
		Bloque b21= new Bloque(0, 5, this.color);  //	b21   b22  b23
		Bloque b22= new Bloque(1, 5, this.color);  //
		Bloque b23= new Bloque(1, 6, this.color);  //
		
		this.misBloques[0]= b12;
		this.misBloques[1]= b21;
		this.misBloques[2]= b22;
		this.misBloques[3]= b23;
		
		bloquesIzq = new Bloque[1];
		bloquesDer = new Bloque[1];
		bloquesAbaj = new Bloque[3];
		
		bloquesIzq[0] = b21;
		bloquesDer[0] = b23;
		bloquesAbaj[0] = b21;
		bloquesAbaj[1] = b22;
		bloquesAbaj[2] = b23;
	}
	
	@Override
	public void rotar() {
		if (this.rotacion==270) {
			rotacion = 0;
			bloquesIzq = new Bloque[1];			// en 0
			bloquesDer = new Bloque[1];			// Tetrimino:
			bloquesAbaj = new Bloque[3];		//		  b12		
			bloquesIzq[0] = misBloques[1];		//	b21   b22  b23
			bloquesDer[0] = misBloques[3];		//
			bloquesAbaj[0] = misBloques[1];		//
			bloquesAbaj[1] = misBloques[2];		//
			bloquesAbaj[2] = misBloques[3];		//
			
		}else {
			if (this.rotacion==90) {
				bloquesIzq = new Bloque[1];		// en 180
				bloquesDer = new Bloque[1];		// Tetrimino:
				bloquesAbaj = new Bloque[1];	//	b23	  b22  b21	
				bloquesIzq[0] = misBloques[3];	//		  b12 
				bloquesDer[0] = misBloques[1];	//
				bloquesAbaj[0] = misBloques[0];	//
			}else {
				if (this.rotacion == 180) {
					this.bloquesIzq = new Bloque[1];			// en 270
					this.bloquesDer = new Bloque[3];			// Tetrimino:
					this.bloquesAbaj = new Bloque[1];			//		  b23  
					this.bloquesAbaj[0] = misBloques[1];		//	 b12  b22 
					this.bloquesIzq[0]= this.misBloques[0]; 	//    	  b21
					this.bloquesDer[0]= this.misBloques[1];		//
					this.bloquesDer[1]= this.misBloques[2];		//
					this.bloquesDer[2]= this.misBloques[3];		//
				}
				else {
					this.bloquesIzq = new Bloque[3];			// en 90
					this.bloquesDer = new Bloque[1];			// Tetrimino:   
					this.bloquesAbaj = new Bloque[1];			//  b21
					this.bloquesAbaj[0] = misBloques[3];		//  b22  b12
					this.bloquesIzq[0]= this.misBloques[1]; 	//  b23
					this.bloquesIzq[1]= this.misBloques[2];		//
					this.bloquesIzq[2]= this.misBloques[3];		//
					this.bloquesDer[0]= this.misBloques[0];		//
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
}
