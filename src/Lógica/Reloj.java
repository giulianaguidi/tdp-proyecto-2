package Lógica;

import javax.swing.JLabel;

import Gui.GUI;


public class Reloj implements Runnable {
	
	protected GUI gui;
	protected Logica logica;
	protected long tiempoInicial = System.currentTimeMillis(); 
	protected long tiempoActual = System.currentTimeMillis();
	protected long tiempoTranscurrido = tiempoActual - tiempoInicial;
	protected long tiempoActualEnSegundos = tiempoTranscurrido / 1000;
	protected int paso = 1000;
	protected boolean activo;
	
	public Reloj (GUI gui, Logica juego) {
		this.gui = gui;
		this.logica = juego;
		this.activo = true;
	}

	@Override
	public void run() {
		while (activo) {			
			tiempoActual = System.currentTimeMillis(); 
			tiempoTranscurrido = tiempoActual - tiempoInicial;
			tiempoActualEnSegundos = tiempoTranscurrido / 1000;		
			try {
				Thread.sleep(paso);
				if (logica.enJuego())
					logica.accion(logica.MOVER_ABAJO);
			} catch (InterruptedException e) {e.printStackTrace();}
			actualizarTiempo();
			if (tiempoActualEnSegundos == 45) {
				actualizarPaso();
			}
			if (!gui.isVisible()) {
				gui.detenerAudio();
				this.stop();
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
	
	public void stop() {
		activo = false;
	}
}
