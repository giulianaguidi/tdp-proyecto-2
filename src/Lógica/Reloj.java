package Lógica;

import Gui.GUI;


public class Reloj implements Runnable {
	
	protected int segundos;
	protected int minutos;
	protected int horas;
	protected GUI gui;
	protected Logica logica;
	
	public Reloj (GUI gui, Logica juego) {
		this.segundos=0;
		this.minutos=0;
		this.horas=0;
		this.gui=gui;
		this.logica=juego;
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(1000);
				if (segundos<60)
					segundos++;
				else {
					if (minutos<60)
						minutos++;
					else 
						horas++;
				}
				/*
				 * this.gui.getLabel().setText(horas+":"+minutos+":"+segundos);
				 * DAR ORDEN A LA LOGICA
				*/
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}


}
