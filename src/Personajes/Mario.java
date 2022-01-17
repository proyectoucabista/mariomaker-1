package Personajes;

import java.awt.Image;
import javax.swing.ImageIcon;
import Paquete1.Main;

public class Mario extends Personaje{

	
	//**** VARIABLES ****//
	private Image imgMario;
	private ImageIcon icoMario;
        private boolean salto; // variable si Mario salta
        private int contadorSalto; // duración y altura del salto

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

	public boolean vSalto() {return salto;}
		
	//**** SETTERS ****//
	public void setSalto(boolean saut) {this.salto = saut;}
	

	//**** METODOS ****//	
         public Image salto(){
		
	    ImageIcon ico;
	    Image img;
	    String str;
	
		this.contadorSalto++;
		// Escalando el salto		
		if(this.contadorSalto <= 35){
			if(this.getY() > Main.escenario.getAlturaTecho()){this.setY(this.getY() - 4);}
			else{this.contadorSalto = 36;}			
			if(this.vMiraDerecha() == true){str = "/Imagenes/MarioSaltaDerecha.png";}
			else{str = "/Imagenes/MarioSaltaIzquierda.png";}	
			
		// Fallout del salto
		}else if(this.getY() + this.getAltura() < Main.escenario.getySuelo()){this.setY(this.getY() + 1);
			if(this.vMiraDerecha() == true){str = "/Imagenes/MarioSaltaDerecha.png";}
			else{str = "/Imagenes/MarioSaltaIzquierda.png";}
			
		// Salto completado
		}else{				
			if(this.vMiraDerecha() == true){str = "/Imagenes/MarioMarchaDerecha.png";}
			else{str = "/Imagenes/MarioMarchaIzquierda.png";}	
			this.salto = false;
			this.contadorSalto = 0;
		}
		// Visualización de imágenes de Mario
		ico = new ImageIcon(getClass().getResource(str));
		img = ico.getImage();
		return img;
	}
}

