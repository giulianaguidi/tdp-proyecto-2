package Lógica;

import Gui.GUI;
import java.util.Random;

public class Logica {
	protected int puntaje;
	protected Tetrimino tetriminoActual;
	protected Tetrimino tetriminoProximo;
	protected Tetrimino[] misTetriminos = new Tetrimino[7];
	protected int velocidad = 1;
	protected int contador;
	protected Grilla miGrilla;
	protected Reloj reloj;
	protected GUI Gui;
	protected Random randi = new Random();


	public Logica() {

		Gui = new GUI(this);
		Gui.setVisible(true);
		
		Bloque[][] miTablero = Gui.getTableroGrafico();

		miGrilla = new Grilla(miTablero);

		misTetriminos[0] = new TetriminoI(miGrilla.obtenerBloque(0, 5), miGrilla.obtenerBloque(1, 5), miGrilla.obtenerBloque(2, 5), miGrilla.obtenerBloque(3, 5));
		misTetriminos[1] = new TetriminoL(miGrilla.obtenerBloque(0, 6), miGrilla.obtenerBloque(1, 4), miGrilla.obtenerBloque(1, 5), miGrilla.obtenerBloque(1, 6));
		misTetriminos[2] = new TetriminoLReves(miGrilla.obtenerBloque(0, 4), miGrilla.obtenerBloque(1, 4), miGrilla.obtenerBloque(1, 5), miGrilla.obtenerBloque(1, 6));
		misTetriminos[3] = new TetriminoT(miGrilla.obtenerBloque(0, 5), miGrilla.obtenerBloque(1, 4), miGrilla.obtenerBloque(1, 5), miGrilla.obtenerBloque(1, 6));
		misTetriminos[4] = new TetriminoS(miGrilla.obtenerBloque(1, 4), miGrilla.obtenerBloque(1, 5), miGrilla.obtenerBloque(0, 5), miGrilla.obtenerBloque(0, 6));
		misTetriminos[5] = new TetriminoZ(miGrilla.obtenerBloque(0, 4), miGrilla.obtenerBloque(0, 5), miGrilla.obtenerBloque(1, 5), miGrilla.obtenerBloque(1, 6));
		misTetriminos[6] = new TetriminoO(miGrilla.obtenerBloque(0, 5), miGrilla.obtenerBloque(0, 6), miGrilla.obtenerBloque(1, 5), miGrilla.obtenerBloque(1, 6));
		
		actualizarTetriminoProximo();
		actualizarTetriminoActual();
		actualizarTetriminoProximo();
		
	}

	public void iniciarJuego() {
		reloj = new Reloj(Gui, this);
		reloj.run();
	}
	
	public int getPuntaje() {
		return puntaje;
	}
	
	public Tetrimino getProxima() {
		return tetriminoProximo;
	}
	
	public void aumentarVelocidad() {
		this.velocidad++;
	}

	public void bajarTetrimino(){
		Bloque[] bloques = tetriminoActual.getBloques();
		if (miGrilla.puedeDescender(tetriminoActual)){

			Bloque[][] tableroGrafico = Gui.getTableroGrafico();

			Gui.pintarFondo(bloques);

			bloques[0] = tableroGrafico[bloques[0].getPosicionFila() + 1][bloques[0].getPosicionColumna()];
			bloques[1] = tableroGrafico[bloques[1].getPosicionFila() + 1][bloques[1].getPosicionColumna()];	
			bloques[2] = tableroGrafico[bloques[2].getPosicionFila() + 1][bloques[2].getPosicionColumna()];	
			bloques[3] = tableroGrafico[bloques[3].getPosicionFila() + 1][bloques[3].getPosicionColumna()];	

			Gui.pintarNuevo(bloques, tetriminoActual.color);

		}else{
			sumarPuntos();
			actualizarTetriminoActual();
			actualizarTetriminoProximo();
			if (!miGrilla.puedeAparecer(tetriminoActual))
				finDelJuego();
			
		}
	}
	
	public void finDelJuego() {
		
	}

	public void actualizarTetriminoActual (){
		this.tetriminoActual = this.tetriminoProximo;
		if (miGrilla.puedeAparecer(tetriminoActual))
			Gui.pintarNuevo(tetriminoActual.getBloques(), tetriminoActual.color);
	}
	
	public void actualizarTetriminoProximo(){
		this.tetriminoProximo = misTetriminos[randi.nextInt(7)];
	}
	
	public void moverDerecha(){
		Bloque[] bloques = tetriminoActual.getBloques();
		if (miGrilla.puedoMoverDerecha(this.tetriminoActual)){
			
			Bloque[][] tableroGrafico = Gui.getTableroGrafico();

			Gui.pintarFondo(bloques);

			bloques[0] = tableroGrafico[bloques[0].getPosicionFila()][bloques[0].getPosicionColumna() + 1];
			bloques[1] = tableroGrafico[bloques[1].getPosicionFila()][bloques[1].getPosicionColumna() + 1];	
			bloques[2] = tableroGrafico[bloques[2].getPosicionFila()][bloques[2].getPosicionColumna() + 1];	
			bloques[3] = tableroGrafico[bloques[3].getPosicionFila()][bloques[3].getPosicionColumna() + 1];	

			Gui.pintarNuevo(bloques, tetriminoActual.color);

			
		}
	}
	
	public void moverIzquierda(){
		Bloque[] bloques = tetriminoActual.getBloques();
		if (miGrilla.puedoMoverIzquierda(this.tetriminoActual)){
			Gui.getTiempo().setText("SE PUEDE MOVER");				
			Bloque[][] tableroGrafico = Gui.getTableroGrafico();

			Gui.pintarFondo(bloques);

			bloques[0] = tableroGrafico[bloques[0].getPosicionFila()][bloques[0].getPosicionColumna() - 1];
			bloques[1] = tableroGrafico[bloques[1].getPosicionFila()][bloques[1].getPosicionColumna() - 1];	
			bloques[2] = tableroGrafico[bloques[2].getPosicionFila()][bloques[2].getPosicionColumna() - 1];	
			bloques[3] = tableroGrafico[bloques[3].getPosicionFila()][bloques[3].getPosicionColumna() - 1];	

			Gui.pintarNuevo(bloques, tetriminoActual.color);

		
		}else {
			Gui.getTiempo().setText("NO se puede mover");
		}
		
	}
	
	public void sumarPuntos() {
		int [] lineasLlenas= miGrilla.getLineasLlenas(tetriminoActual);
		miGrilla.eliminarLineas(lineasLlenas);
		int cantLineasLlenas=0;
		
		for(int i=0; i<lineasLlenas.length; i++)
			if (lineasLlenas[i]!=22)
				cantLineasLlenas++;
		
		switch(cantLineasLlenas) {
		case 0: {break;}
		case 1: {actualizarPuntaje(100); break;}
		case 2: {actualizarPuntaje(200); break;}
		case 3: {actualizarPuntaje(500); break;}
		case 4: {actualizarPuntaje(800); break;}
		}
		
		Gui.getPuntos().setText("Puntaje: "+ this.puntaje);
	}
	
	private void actualizarPuntaje (int p) {
		this.puntaje+=p;
	}

	public void rotarTetrimino() {
		// TODO Auto-generated method stub
		
	}
}
