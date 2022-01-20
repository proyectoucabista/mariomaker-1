package Personajes;

import Objetos.Objeto;
import Objetos.Pieza;
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
		if(this.contadorSalto <= 40){
			if(this.getY() > Main.escenario.getAlturaTecho()){this.setY(this.getY() - 4);}
			else{this.contadorSalto = 41;}			
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
         
        public void contacto(Objeto objet){
            //Contacto horizontal
            if((super.contactoAntes(objet) == true && this.vMiraDerecha() == true) || (super.contactoAtras(objet) == true && this.vMiraDerecha() == false)){
                    Main.escenario.setDx(0);
                this.setCaminar(false);
            }		
            //Contacto con un objeto debajo
            if(super.contactoDebajo(objet) == true && this.salto == true){ // Mario salta sobre un objeto
                    Main.escenario.setySuelo(objet.getY());			
            }else if(super.contactoDebajo(objet) == false){ //Mario cae al suelo inicial
                    Main.escenario.setySuelo(293); // Elevación inicial del terreno
                    if(this.salto == false){this.setY(243);} // Altitud inicial de Mario
            }
            //Contacto con un objeto arriba
            if(super.contactoDebajo(objet) == true){
                    Main.escenario.setAlturaTecho(objet.getY() + objet.getAltura()); // El techo se convierte en la parte inferior del objeto
            }else if(super.contactoDebajo(objet) == false && this.salto == false){
                    Main.escenario.setAlturaTecho(0);// Altitud inicial de la plataforma (cielo)
            }     
	}
        
        public boolean contactoPieza(Pieza piece){
		// Tocar una moneda no tiene efecto en Mario
		if(this.contactoAntes(piece) == true || this.contactoAntes(piece) == true || this.contactoDebajo(piece) == true || this.contactoDebajo(piece) == true){
			return true;			
		}else{return false;}
	}
}

