package Personajes;

public class Personaje {

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
        this.caminar = caminar;
        this.miraDerecha = miraDerecha;
        
    }
    
    public Personaje(int x, int y) {
        
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.altura = altura;
        
    }
	
	 //**** GETTES & SETTERS ****//

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean vCaminar() {
        return caminar;
    }

    public void setCaminar(boolean caminar) {
        this.caminar = caminar;
    }

    public boolean vMiraDerecha() {
        return miraDerecha;
    }

    public void setMiraDerecha(boolean miraDerecha) {
        this.miraDerecha = miraDerecha;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }
    
     // metodos..
}
