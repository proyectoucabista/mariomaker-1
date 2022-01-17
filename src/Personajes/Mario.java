
package Personajes;




import Paquete1.Main;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Mario extends Personaje{

	
	//**** VARIABLES ****//
	private Image imgMario;
	private ImageIcon icoMario;
        private boolean salto;
        private int contadorSalto;

      //**** CONSTRUCTOR ***//	
	public Mario(int x, int y) {

	super(x,y,30,50);		
	this.icoMario = new ImageIcon("src/Imagenes/MarioDerecha.png");
	this.imgMario = this.icoMario.getImage();
        
        this.salto = false;
	this.contadorSalto = 0;
	}

		
	
		
	//**** GETTERS ****//		
	public Image getImgMario() {return imgMario;}
       
        public boolean isSalto() {
        return salto;
    }
        
        
		
		
	//**** SETTERS ****//

    public void setSalto(boolean salto) {
        this.salto = salto;
    }

    //**** METODOS ****//
    
    public Image salto(){
		
	    ImageIcon ico;
	    Image img;
	    String str;
	
		this.contadorSalto++;
		// Montée du saut		
		if(this.contadorSalto <= 35){
			if(this.getY() > Main.escenario.getAlturaTecho()){this.setY(this.getY() - 4);}
			else{this.contadorSalto = 36;}			
			if(this.vMiraDerecha() == true){str = "/Imagenes/MarioSaltaDerecha.png";}
			else{str = "/Imagenes/MarioSaltaIzquierda.png";}	
			
		
		}else if(this.getY() + this.getAltura() < Main.escenario.getySuelo()){this.setY(this.getY() + 1);
			if(this.vMiraDerecha() == true){str = "/Imagenes/MarioSaltaDerecha.png";}
			else{str = "/Imagenes/MarioSaltaDerecha.png";}
			
		// Saut terminé	
		}else{				
			if(this.vMiraDerecha() == true){str = "/Imagenes/MarioSaltaDerecha.png";}
			else{str = "/Imagenes/MarioSaltaDerecha.png";}	
			this.salto = false;
			this.contadorSalto = 0;
		}
		// Affichage de l'image de mario
		ico = new ImageIcon(getClass().getResource(str));
		img = ico.getImage();
		return img;
	}
   
}

