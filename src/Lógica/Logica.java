package Lógica;

import Gui.Fin;
import Gui.GUI;
import java.util.Random;

public class Logica {
	protected int puntaje;
	protected Tetrimino tetriminoActual;
	protected Tetrimino tetriminoProximo;
	protected Tetrimino[] misTetriminos = new Tetrimino[7];
	protected int velocidad = 1;
	protected Grilla miGrilla;
	protected Reloj reloj;
	protected GUI Gui;
	protected Random randi = new Random();
	protected boolean enJuego;

	public final int MOVER_ABAJO = 0;
	public final int MOVER_IZQUIERDA = 1;
	public final int MOVER_DERECHA = 2;
	public final int ROTAR = 3;

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
		this.puntaje = 0;
		
		iniciarJuego();
		
		
		
	}

	public void iniciarJuego() {
		reloj = new Reloj(Gui, this);
		Thread t = new Thread(this.reloj);
		t.start();
		enJuego = true;
		Gui.iniciarAudio();
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

	public boolean enJuego(){
		return enJuego;
	}

	public synchronized void accion(int action) {
		switch(action) {
			case MOVER_ABAJO:{
				bajarTetrimino();
				break;
			}
			case MOVER_IZQUIERDA:{
				moverIzquierda();
				break;}
			case MOVER_DERECHA:{
				moverDerecha();
				break;}
			case ROTAR:{
				rotarTetrimino();
				break;}
			}
	}

	public void bajarTetrimino(){
		if (miGrilla.puedeDescender(tetriminoActual)){

			Bloque[] bloques = tetriminoActual.getBloques();
			Bloque[] bloquesDer = tetriminoActual.getBloquesDer();
			Bloque[] bloquesIzq = tetriminoActual.getBloquesIzq();
			Bloque[] bloquesAbaj = tetriminoActual.getBloquesAbaj();
			Bloque[][] tableroGrafico = Gui.getTableroGrafico();

			Gui.pintarFondo(bloques);

			bloques[0] = tableroGrafico[bloques[0].getPosicionFila() + 1][bloques[0].getPosicionColumna()];
			bloques[1] = tableroGrafico[bloques[1].getPosicionFila() + 1][bloques[1].getPosicionColumna()];	
			bloques[2] = tableroGrafico[bloques[2].getPosicionFila() + 1][bloques[2].getPosicionColumna()];	
			bloques[3] = tableroGrafico[bloques[3].getPosicionFila() + 1][bloques[3].getPosicionColumna()];
			
			for (int i = 0; i < bloquesDer.length; i++) {
				bloquesDer[i] = tableroGrafico[bloquesDer[i].getPosicionFila() + 1][bloquesDer[i].getPosicionColumna()];	
			}
			for (int i = 0; i < bloquesIzq.length; i++) {
				bloquesIzq[i] = tableroGrafico[bloquesIzq[i].getPosicionFila() + 1][bloquesIzq[i].getPosicionColumna()];	
			}
			for (int i = 0; i < bloquesAbaj.length; i++) {
				bloquesAbaj[i] = tableroGrafico[bloquesAbaj[i].getPosicionFila() + 1][bloquesAbaj[i].getPosicionColumna()];	
			}
			
			Gui.pintarNuevo(bloques, tetriminoActual.color);

		}else{
			sumarPuntos();
			actualizarTetriminoActual();
			actualizarTetriminoProximo();
		}
	}
	
	public void finDelJuego() {
		this.reloj.stop();
		enJuego=false;
		Gui.detenerAudio();
		Fin fin = new Fin(this);
		fin.setVisible(true);
	}

	public void actualizarTetriminoActual (){
		this.tetriminoActual = this.tetriminoProximo;
		if (miGrilla.puedeAparecer(tetriminoActual))
			Gui.pintarNuevo(tetriminoActual.getBloques(), tetriminoActual.color);
		else
			finDelJuego();
	}
	
	public void actualizarTetriminoProximo(){
		
		this.tetriminoProximo = misTetriminos[randi.nextInt(7)].clone();
		Gui.repintarProximoTetrimino();
		Gui.pintarProximoTetriminoGrafico(tetriminoProximo);
		
	}
	
	public void moverDerecha(){
		if (miGrilla.puedoMoverDerecha(this.tetriminoActual)){
			
			Bloque[] bloques = tetriminoActual.getBloques();
			Bloque[] bloquesDer = tetriminoActual.getBloquesDer();
			Bloque[] bloquesIzq = tetriminoActual.getBloquesIzq();
			Bloque[] bloquesAbaj = tetriminoActual.getBloquesAbaj();
			Bloque[][] tableroGrafico = Gui.getTableroGrafico();
			
			
			Gui.pintarFondo(bloques);

			bloques[0] = tableroGrafico[bloques[0].getPosicionFila()][bloques[0].getPosicionColumna() + 1];
			bloques[1] = tableroGrafico[bloques[1].getPosicionFila()][bloques[1].getPosicionColumna() + 1];	
			bloques[2] = tableroGrafico[bloques[2].getPosicionFila()][bloques[2].getPosicionColumna() + 1];	
			bloques[3] = tableroGrafico[bloques[3].getPosicionFila()][bloques[3].getPosicionColumna() + 1];	

			Gui.pintarNuevo(bloques, tetriminoActual.color);
			
			for (int i = 0; i < bloquesDer.length; i++) {
				bloquesDer[i] = tableroGrafico[bloquesDer[i].getPosicionFila()][bloquesDer[i].getPosicionColumna() + 1];	
			}
			for (int i = 0; i < bloquesIzq.length; i++) {
				bloquesIzq[i] = tableroGrafico[bloquesIzq[i].getPosicionFila()][bloquesIzq[i].getPosicionColumna() + 1];	
			}
			for (int i = 0; i < bloquesAbaj.length; i++) {
				bloquesAbaj[i] = tableroGrafico[bloquesAbaj[i].getPosicionFila()][bloquesAbaj[i].getPosicionColumna() + 1];	
			}
			
		}
	}
	
	public void moverIzquierda(){
		if (miGrilla.puedoMoverIzquierda(this.tetriminoActual)){
			Bloque[] bloques = tetriminoActual.getBloques();
			Bloque[] bloquesDer = tetriminoActual.getBloquesDer();
			Bloque[] bloquesIzq = tetriminoActual.getBloquesIzq();
			Bloque[] bloquesAbaj = tetriminoActual.getBloquesAbaj();
			Bloque[][] tableroGrafico = Gui.getTableroGrafico();

			Gui.pintarFondo(bloques);

			bloques[0] = tableroGrafico[bloques[0].getPosicionFila()][bloques[0].getPosicionColumna() - 1];
			bloques[1] = tableroGrafico[bloques[1].getPosicionFila()][bloques[1].getPosicionColumna() - 1];	
			bloques[2] = tableroGrafico[bloques[2].getPosicionFila()][bloques[2].getPosicionColumna() - 1];	
			bloques[3] = tableroGrafico[bloques[3].getPosicionFila()][bloques[3].getPosicionColumna() - 1];	

			for (int i = 0; i < bloquesDer.length;i++) {
				bloquesDer[i] = tableroGrafico[bloquesDer[i].getPosicionFila()][bloquesDer[i].getPosicionColumna() - 1];	
			}
			for (int i = 0; i < bloquesIzq.length;i++) {
				bloquesIzq[i] = tableroGrafico[bloquesIzq[i].getPosicionFila()][bloquesIzq[i].getPosicionColumna() - 1];	
			}
			for (int i = 0; i < bloquesAbaj.length;i++) {
				bloquesAbaj[i] = tableroGrafico[bloquesAbaj[i].getPosicionFila()][bloquesAbaj[i].getPosicionColumna() - 1];	
			}
			
			
			Gui.pintarNuevo(bloques, tetriminoActual.color);
			
		
		}
		
	}
	
	public void sumarPuntos() {
		int [] lineasLlenas = miGrilla.getLineasLlenas(tetriminoActual);
		miGrilla.eliminarLineas(lineasLlenas);
		int cantLineasLlenas = 0;
		
		for(int i = 0; i < lineasLlenas.length; i++)
			if (lineasLlenas[i] != 22)
				cantLineasLlenas++;
		
		switch(cantLineasLlenas) {
		case 1: {actualizarPuntaje(100); break;}
		case 2: {actualizarPuntaje(200); break;}
		case 3: {actualizarPuntaje(500); break;}
		case 4: {actualizarPuntaje(800); break;}
		default: {actualizarPuntaje(0); break;}
		}
		
		Gui.getPuntos().setText("" + this.puntaje);
	}
	
	private void actualizarPuntaje (int p) {
		this.puntaje+=p;
	}

	public void rotarTetrimino() {
		if (tetriminoActual.puedeRotar(Gui.getTableroGrafico(), miGrilla.getColor())) {
			Gui.pintarFondo(tetriminoActual.getBloques());
			tetriminoActual.rotar(Gui.getTableroGrafico());
			Gui.pintarNuevo(tetriminoActual.getBloques(), tetriminoActual.getColor());
		}
		
	}

}
