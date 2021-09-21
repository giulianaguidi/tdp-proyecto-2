package Lógica;

import java.awt.Color;

public class TetriminoO extends Tetrimino{
	
	public TetriminoO() {
		this.color= new Color(255, 255, 0);
		Bloque b11= new Bloque(0, 5, this.color);  
		Bloque b12= new Bloque(0, 6, this.color);  
		Bloque b21= new Bloque(1, 5, this.color);
		Bloque b22= new Bloque(1, 6, this.color);
		
		this.misBloques[0]= b11;
		this.misBloques[1]= b12;
		this.misBloques[2]= b21;
		this.misBloques[3]= b22;
		
		this.bloquesAbaj= new Bloque[2];
		this.bloquesIzq= new Bloque[2];
		this.bloquesDer= new Bloque[2];
		
		this.bloquesIzq[0]= b11;
		this.bloquesIzq[1]= b21;
		this.bloquesDer[0]= b12;
		this.bloquesDer[1]= b22;
		this.bloquesAbaj[0]= b21;
		this.bloquesAbaj[1]= b22;
		
	}

	@Override
	public void rotar() {
		if (this.rotacion==270)
			this.rotacion=0;		//Para este tetrimino en particular, su rotacion es trivial.
		else
			this.rotacion+=90;
	}

	@Override
	public Bloque[] getBloquesIzq() {
		return this.bloquesIzq;
	}

	@Override
	public Bloque[] getBloquesDer() {
		return this.bloquesDer;
	}

	@Override
	public Bloque[] getBloquesAbaj() {
		return this.bloquesAbaj;
		
	}

}
