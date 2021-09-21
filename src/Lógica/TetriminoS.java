package Lógica;

import java.awt.Color;

public class TetriminoS extends Tetrimino {
	
	public TetriminoS() {
		this.color= new Color(0,255,0);
		Bloque b21= new Bloque(1, 4, this.color);  
		Bloque b22= new Bloque(1, 5, this.color);  
		Bloque b12= new Bloque(0, 5, this.color);
		Bloque b13= new Bloque(0, 6, this.color);
		
		this.misBloques[0]= b21;
		this.misBloques[1]= b22;
		this.misBloques[2]= b12;
		this.misBloques[3]= b13;
		
		bloquesIzq = new Bloque[1];
		bloquesDer = new Bloque[1];
		bloquesAbaj = new Bloque[2];
		
		bloquesIzq[0] = b21;
		bloquesDer[0] = b13;
		bloquesAbaj[0] = b21;
		bloquesAbaj[1] = b22;
	}
	
	@Override
	public void rotar() {
		if (this.rotacion==270) {
			rotacion = 0;
			bloquesIzq = new Bloque[1];
			bloquesDer = new Bloque[1];
			bloquesAbaj = new Bloque[2];
			bloquesIzq[0] = misBloques[0];
			bloquesDer[0] = misBloques[3];
			bloquesAbaj[0] = misBloques[0];
			bloquesAbaj[1] = misBloques[1];
			
		}else {
			if (this.rotacion==90) {
				bloquesIzq = new Bloque[1];
				bloquesDer = new Bloque[1];
				bloquesAbaj = new Bloque[2];
				bloquesIzq[0] = misBloques[3];
				bloquesDer[0] = misBloques[0];
				bloquesAbaj[0] = misBloques[2];
				bloquesAbaj[1] = misBloques[3];
			}else {
				if (this.rotacion == 180) {
					this.bloquesIzq = new Bloque[2];
					this.bloquesDer = new Bloque[2];
					this.bloquesAbaj = new Bloque [1];
					this.bloquesAbaj[0] = misBloques[0];
					this.bloquesIzq[0]= this.misBloques[2]; 
					this.bloquesIzq[1]= this.misBloques[3];
					this.bloquesDer[0]= this.misBloques[0];
					this.bloquesDer[1]= this.misBloques[1];
				}
				else {
					this.bloquesIzq = new Bloque[2];
					this.bloquesDer = new Bloque[2];
					this.bloquesAbaj = new Bloque [1];
					this.bloquesAbaj[0] = misBloques[3];
					this.bloquesIzq[0]= this.misBloques[0]; 
					this.bloquesIzq[1]= this.misBloques[1];
					this.bloquesDer[0]= this.misBloques[2];
					this.bloquesDer[1]= this.misBloques[3];
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
