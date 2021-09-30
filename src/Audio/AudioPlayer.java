package Audio;

import java.io.InputStream;

import javazoom.jl.player.Player;

public class AudioPlayer implements Runnable {
	
	protected String file;
	
	public AudioPlayer( String file ) {
		this.file = file;
		
	}

	@Override
	public void run() {
		try{
			InputStream is = null;
			is = AudioPlayer.class.getResourceAsStream("/music/" + file);
			Player playMP3 = new Player(is);
			playMP3.play();		
		}
		catch(Exception ex)
		{  
			ex.printStackTrace();
		}
	}


}