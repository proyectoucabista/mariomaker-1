package Objetos;

import java.awt.Image;
import javax.swing.ImageIcon;
import Paquete1.Main;

public class Objeto{

	//**** VARIABLES ****//
	private int ancho, altura; //dimensiones del objeto
	private int x, y; //posicion del objeto
        
	protected Image imgObjeto;
	protected ImageIcon icoObjeto;
	
	//**** CONSTRUCTOR ****//	
	public Objeto(int x, int y, int ancho, int altura){
			
		this.x = x;
		this.y = y;
		this.ancho = ancho;
		this.altura = altura;
	}
	
	
	 //**** GETTERS ****//	
        public int getX() {return x;}

	public int getY() {return y;}

	public int getAncho() {return ancho;}

	public int getAltura() {return altura;}
	
	public Image getImgObjeto() {return imgObjeto;}

	//**** SETTERS ****//	
	public void setX(int x) {this.x = x;}

	public void setY(int y) {this.y = y;}

	public void setAncho(int ancho) {this.ancho = ancho;}

	public void setAltura(int altura) {this.altura = altura;}
	
	
	//**** METODOS ****//
        public void desplazamiento(){		
		if(Main.escenario.getxPos() >= 0){
			this.x = this.x - Main.escenario.getDx();
		}
	}
}

