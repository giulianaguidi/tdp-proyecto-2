package Lógica;

import java.awt.Color;

public class TetriminoS extends Tetrimino {
	
	public TetriminoS(Bloque b21, Bloque b22, Bloque b12, Bloque b13) {
		this.color= new Color(0, 255, 0);
		
		this.misBloques[0] = b21;
		this.misBloques[1] = b22;
		this.misBloques[2] = b12;
		this.misBloques[3] = b13;
		
		this.bloquesIzq = new Bloque[2];
		this.bloquesDer = new Bloque[2];
		this.bloquesAbaj = new Bloque[3];
		
		this.bloquesIzq[0] = b21;
		this.bloquesIzq[1] = b12;
		this.bloquesDer[0] = b22;
		this.bloquesDer[1] = b13;

		this.bloquesAbaj[0] = b21;
		this.bloquesAbaj[1] = b22;
		this.bloquesAbaj[2] = b13;
	}
	
	@Override
	public void rotar() {
		if (this.rotacion == 270) {
			rotacion = 0;
			this.bloquesIzq = new Bloque[2];			//en 0
			this.bloquesDer = new Bloque[2];			//Tetrimino:
			this.bloquesAbaj = new Bloque[3];		//      b12  b13
			this.bloquesIzq[0] = this.misBloques[0];		// b21  b22
			this.bloquesIzq[1] = this.misBloques[2];
			this.bloquesDer[0] = this.misBloques[3];		//
			this.bloquesDer[1] = this.misBloques[1];
			this.bloquesAbaj[0] = this.misBloques[0];		//
			this.bloquesAbaj[1] = this.misBloques[1];		//
			this.bloquesAbaj[2] = this.misBloques[3];
			
			
		}else {
			if (this.rotacion==90) {
				this.bloquesIzq = new Bloque[1];			//en 180
				this.bloquesDer = new Bloque[1];			//Tetrimino:
				this.bloquesAbaj = new Bloque[2];		//      b22  b21
				this.bloquesIzq[0] = this.misBloques[3];		// b13  b12
				this.bloquesDer[0] = this.misBloques[0];		//
				this.bloquesAbaj[0] = this.misBloques[2];		//
				this.bloquesAbaj[1] = this.misBloques[3];		//
			}else {
				if (this.rotacion == 180) {
					this.bloquesIzq = new Bloque[3];			//en 270
					this.bloquesDer = new Bloque[3];			//Tetrimino:
					this.bloquesAbaj = new Bloque [2];			//      b13  
					this.bloquesAbaj[0] = this.misBloques[0];		//   	b12  b22
					this.bloquesIzq[0] = this.misBloques[2]; 	//			 b21
					this.bloquesIzq[1] = this.misBloques[3];		//
					this.bloquesAbaj[1] = this.misBloques[2];
					this.bloquesIzq[2] = this.misBloques[0];
					this.bloquesDer[0] = this.misBloques[0];		//
					this.bloquesDer[1] = this.misBloques[1];		//
					this.bloquesDer[2] = this.misBloques[3];
					
				}
				else {
					this.bloquesIzq = new Bloque[3];			//en 90
					this.bloquesDer = new Bloque[3];			//Tetrimino:
					this.bloquesAbaj = new Bloque [2];			//      b21
					this.bloquesAbaj[0] = this.misBloques[3];		//   	b22  b12
					this.bloquesIzq[0] = this.misBloques[0]; 	//			 b13
					this.bloquesIzq[1] = this.misBloques[1];		//
					this.bloquesDer[0] = this.misBloques[2];		//
					this.bloquesDer[1] = this.misBloques[3];		//
					this.bloquesIzq[2] = this.misBloques[3];
					this.bloquesDer[2] = this.misBloques[0];
					this.bloquesAbaj[1] = this.misBloques[1];
				}
			}
			this.rotacion += 90;
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
		return new TetriminoS(misBloques[0], misBloques[1], misBloques[2], misBloques[3]);
	}

	@Override
	public Color getColor() {
		return this.color;
	}

}
