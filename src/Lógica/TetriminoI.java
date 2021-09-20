package Lógica;

import java.awt.Color;

public class TetriminoI extends Tetrimino{
	
	public TetriminoI () {
		this.color= new Color(0, 255, 255);
		Bloque b11= new Bloque(0, 5, this.color);  
		Bloque b21= new Bloque(1, 5, this.color);  
		Bloque b31= new Bloque(2, 5, this.color);
		Bloque b41= new Bloque(3, 5, this.color);
		
		this.misBloques[0]= b11;
		this.misBloques[1]= b21;
		this.misBloques[2]= b31;
		this.misBloques[3]= b41;
		
		this.bloquesAbaj= new Bloque[1];
		this.bloquesIzq= new Bloque[4];
		this.bloquesDer= new Bloque[4];
		
		this.bloquesIzq[0]= b11; 
		this.bloquesIzq[1]= b21; 
		this.bloquesIzq[2]= b31; 
		this.bloquesIzq[3]= b41; 
		this.bloquesDer[0]= b11;
		this.bloquesDer[1]= b21;
		this.bloquesDer[2]= b31;
		this.bloquesDer[3]= b41;
		this.bloquesAbaj[0]= b41;
	}

	@Override
	public void rotar() {
		if (this.rotacion==270) {
			this.rotacion=0;
			this.bloquesAbaj= new Bloque[1];
			this.bloquesIzq=this.misBloques;
			this.bloquesDer= this.misBloques;
			this.bloquesAbaj[0]= this.misBloques[3];
			
		}else {
			if (this.rotacion==90) {
				this.bloquesAbaj= new Bloque[1];
				this.bloquesIzq=this.misBloques;
				this.bloquesDer= this.misBloques;
				this.bloquesAbaj[0]= this.misBloques[3];
			}else {
				this.bloquesIzq= new Bloque[1];
				this.bloquesDer= new Bloque[1];
				this.bloquesAbaj= this.misBloques;
				this.bloquesIzq[0]= this.misBloques[3]; 
				this.bloquesDer[0]= this.misBloques[0];
			}
			this.rotacion+=90;

		}
	}

	@Override
	public Bloque[] getBloquesIzq() {
		return null;
	}

	@Override
	public Bloque[] getBloquesDer() {
		return null;
	}

	@Override
	public Bloque[] getBloquesAbaj() {
		return null;
	}

}
