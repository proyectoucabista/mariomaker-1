package Personajes;

import Objetos.Objeto;
import Paquete1.Main;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Personaje{

	//**** VARIABLES ****//
	private int ancho, altura; //dimensiones del personaje
	private int x, y; //posicion de personaje
	private boolean caminar; //verdadero, cuando el personaje camina
	private boolean miraDerecha; // verdadero, cuando el personaje mira a la derecha
	public int contador; // 

        //**** CONSTRUCTOR ****//
    public Personaje(int x, int y, int ancho, int altura) {
        this.ancho = ancho;
        this.altura = altura;
        this.x = x;
        this.y = y;
        this.contador = 0;
        this.caminar = false;
        this.miraDerecha = true;
        
    }
    
    public Personaje(int x, int y) {
        
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.altura = altura;
        
    }
	
    //**** GETTES ****//

    public int getAncho() {
        return ancho;
    }
    
    public int getAltura() {
        return altura;
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    public int getContador() {
        return contador;
    }
    
    //**** SETTERS ****//

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    public void setCaminar(boolean caminar) {
        this.caminar = caminar;
    }
     
    public void setMiraDerecha(boolean miraDerecha) {
        this.miraDerecha = miraDerecha;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public boolean vCaminar() {
        return caminar;
    }

    public boolean vMiraDerecha() {
        return miraDerecha;
    }

     // metodos..
    
    public Image caminar(String nom, int frecuencia){
		
		String str;
		ImageIcon ico;
		Image img;
		
		if(this.caminar == false || Main.escenario.getxPos() <= 0){
			if(this.miraDerecha == true){str = "/Imagenes/" + nom + "Derecha.png";}
			else{str = "/Imagenes/" + nom + "Izquierda.png";}
		}else{
			this.contador++;
			if(this.contador / frecuencia == 0){
				if(this.miraDerecha == true){str = "/Imagenes/" + nom + "Derecha.png";}
				else{str = "/Imagenes/" + nom + "Izquierda.png";}
			}else{
				if(this.miraDerecha == true){str = "/Imagenes/" + nom + "MarchaDerecha.png";}
				else{str = "/Imagenes/" + nom + "MarchaIzquierda.png";}
			}
			if(this.contador == 2 * frecuencia){this.contador = 0;}
		}
		// Visualización de imágenes de Mario
		ico = new ImageIcon(getClass().getResource(str));
		img = ico.getImage();
		return img;
	}
    public boolean contactoAntes(Objeto objet){
    	if(this.vMiraDerecha() == true){
                return !(this.x + this.altura < objet.getX() || this.x + this.ancho > objet.getX() + 5 || this.y + this.altura <= objet.getY() || this.y >= objet.getY() + objet.getAltura());
    	}else{return false;}	    	
    }
    
}
