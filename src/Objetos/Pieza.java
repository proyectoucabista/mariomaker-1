package Objetos;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Pieza extends Objeto implements Runnable{
	
	//**** VARIABLES ****//
	private int contador;
	private final int PAUSE = 15; // Tiempo de espera entre 2 vueltas en bucle
        
	//**** CONSTRUCTEUR	****//
        public Pieza(int x, int y){
	    super(x, y, 30, 30);
	    
	    super.icoObjeto = new ImageIcon(getClass().getResource("/Imagenes/Pieza1.png"));
	    super.imgObjeto = super.icoObjeto.getImage();
    }


    //**** GETTERS ****//		


    //**** SETTERS ****//


    //**** METHODES ****//
    public Image bouge(){ // Movimiento de piezas	
    	String str;
    	ImageIcon ico;
	Image img;
			
        this.contador++;
        if (this.contador / 100 == 0) {str = "/Imagenes/Pieza1.png";}
            else{str = "/Imagenes/Pieza2.png";}							    
            if (this.contador == 200) {this.contador = 0;}
            // Visualización de la imagen del personaje
            ico = new ImageIcon(getClass().getResource(str));
            img = ico.getImage();
            return img;   	
	}

	@Override
	public void run() {
		try{Thread.sleep(20);} // Esperamos 20 ms antes de llamar a move para que todos los objetos se creen por completo
		catch (InterruptedException e){}		
			
		while(true){ // Bucle infinito									
			this.bouge();
			try{Thread.sleep(PAUSE);}
			catch (InterruptedException e){}
		}			
	}
}

