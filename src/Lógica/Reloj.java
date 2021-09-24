package Lógica;

import javax.swing.JLabel;

import Gui.GUI;


public class Reloj implements Runnable {
	
	protected GUI gui;
	protected Logica logica;
	protected long tiempoInicial = System.currentTimeMillis(); 
	protected long tiempoActual = System.currentTimeMillis();
	protected long tiempoTranscurrido = tiempoActual - tiempoInicial;
	protected long tiempoActualEnSegundos = System.currentTimeMillis() / 1000;
	protected int paso = 1000;
	
	public Reloj (GUI gui, Logica juego) {
		this.gui = gui;
		this.logica = juego;
	}

	@Override
	public void run() {
		while (true) {			
			tiempoActual = System.currentTimeMillis(); 
			tiempoTranscurrido = tiempoActual - tiempoInicial;
			tiempoActualEnSegundos = System.currentTimeMillis() / 1000;		
			try {
				Thread.sleep(paso);
				logica.bajarTetrimino();
			} catch (InterruptedException e) {e.printStackTrace();}
			actualizarTiempo();
			if (tiempoActualEnSegundos == 45) {
				actualizarPaso();
			}
		}	
		
	}


	private void actualizarPaso(){
		if (paso >= 500){
			paso -= 200;
			logica.aumentarVelocidad();
		}
	}
	
	private void actualizarTiempo(){
		JLabel auxiliar = gui.getTiempo();
		auxiliar.setText("" + tiempoActualEnSegundos);
	}
}
