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

	@Override
	public void rotar() {
		if (this.rotacion == 270) {
			this.rotacion = 0;							//en 0
			this.bloquesAbaj = new Bloque[1];			//Tetrimino:
			this.bloquesIzq = this.misBloques;			// b11
			this.bloquesDer = this.misBloques;			// b21
			this.bloquesAbaj[0] = this.misBloques[3];	// b31 
														// b41
		}else {
			if (this.rotacion == 90) {					//en 180
				this.bloquesAbaj = new Bloque[1];		//Tetrimino:
				this.bloquesIzq = new Bloque[4];			// b41
				this.bloquesIzq[0] = misBloques[3];		// b31	
				this.bloquesIzq[1] = misBloques[2];		// b21
				this.bloquesIzq[2] = misBloques[1];		// b11
				this.bloquesIzq[3] = misBloques[0];		//
				this.bloquesDer = this.bloquesIzq;		//
				this.bloquesAbaj[0] = this.misBloques[0];//
														
			}else {
				if (this.rotacion == 180) {					//en 270
					this.bloquesIzq = new Bloque[1];			//en 90
					this.bloquesDer = new Bloque[1];			//Tetrimino:
					this.bloquesAbaj = misBloques;			// b11  b21  b31  b41
					this.bloquesIzq[0] = this.misBloques[0]; //
					this.bloquesDer[0] = this.misBloques[3];	//
				}else {
					this.bloquesIzq = new Bloque[1];			//en 90
					this.bloquesDer = new Bloque[1];			//Tetrimino:
					this.bloquesAbaj = new Bloque[4];		// b41  b31  b21  b11
					this.bloquesAbaj[0] = misBloques[3];		//
					this.bloquesAbaj[1] = misBloques[2];		//
					this.bloquesAbaj[2] = misBloques[1];		//
					this.bloquesAbaj[3] = misBloques[0];		//
					this.bloquesIzq[0] = this.misBloques[3]; //
					this.bloquesDer[0] = this.misBloques[0];	//
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
		return new TetriminoI(misBloques[0], misBloques[1], misBloques[2], misBloques[3]);
	}

	@Override
	public Color getColor() {
		return this.color;
	}

}
