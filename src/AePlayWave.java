import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

/**
 * Esta clase se usa para reproducir sonidos en el juego. 
 * 
 *
 */
public class AePlayWave{

    static AePlayWave fondoMusica;
private SourceDataLine linea = null;
private byte[] audioBytes;
	private int numBytes;
	private AudioFormat audioFormat;
	private DataLine.Info info;
        public static Object fondito;

	
	public AePlayWave(String path){
		File soundFile = new File(path);
		AudioInputStream audioInputStream = null;
		try{
			audioInputStream = AudioSystem.getAudioInputStream(soundFile);
		}catch (Exception ex){
			
		}
		if(audioInputStream == null)return;
		audioFormat = audioInputStream.getFormat();
		info = new DataLine.Info(SourceDataLine.class,
								 audioFormat);
		try{
			linea = (SourceDataLine)AudioSystem.getLine(info);
			linea.open(audioFormat);
		}catch (LineUnavailableException ex){
			
		}

		linea.start();

		audioBytes = new byte[(int)soundFile.length()];

		try{
			numBytes = audioInputStream.read(audioBytes, 0, audioBytes.length);
		}catch (IOException ex){
			
		}
	}
	
	/**
	 * reproducir el sonido
	 */
	public void start(){
		new Thread(){
                       
			public void run(){
				try{
					linea = (SourceDataLine)AudioSystem.getLine(info);
					linea.open(audioFormat);
				}catch (LineUnavailableException ex){
					//System.out.println("*** Audio linea unavailable ***");
					//System.exit(1);
				}
				linea.start();
				linea.write(audioBytes, 0, numBytes);
			}
		}.start();
	}
        public void finalizar(){
          
			linea.close();
                        
        }
}
