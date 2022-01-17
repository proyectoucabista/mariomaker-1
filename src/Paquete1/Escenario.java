package Paquete1;

import Objetos.Bloque;
import Objetos.Tuberia;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import Personajes.Mario;


@SuppressWarnings("serial")
public class Escenario extends JPanel {
    
    // Imagenes del juego
	private ImageIcon icoFond;
	private Image imgFondo1;
        private Image imgFondo2;
	
	private ImageIcon icoMario; 
	private Image imgMario; 
        
        private ImageIcon icoLetrero; 
	private Image imgLetrero;
        
        private ImageIcon icoCastillo1; 
	private Image imgCastillo1;
        
        
	
	private int Fondo1;
        private int Fondo2;
	private int dx; // desplazamiento
        private int xPos; // posicion del juego
        private int ySuelo; // altura actual desde el suelo
        private int alturaTecho; // altura actual del techo
        
        public Mario mario;
        public Tuberia tuberia1;
	public Bloque bloque1;
	
	//**** CONSTRUCTOR ****//	
	public Escenario(){
		
		super();
		
		this.Fondo1 = -50; // inicializacion
                this.Fondo2 = 750; // duplicar fondo y se vea infinito
		this.dx = 0;
                this.xPos = -1;
                this.ySuelo = 293;
		this.alturaTecho = 0;
		
                //FONDO1
		icoFond = new ImageIcon(getClass().getResource("/Imagenes/Fondo.png"));
		this.imgFondo1 = this.icoFond.getImage();
                // MARIO
		icoMario = new ImageIcon(getClass().getResource("/Imagenes/MarioDerecha.png"));
		this.imgMario = this.icoMario.getImage();
                // FONDO2.1
                this.imgFondo2 = this.icoFond.getImage();
                
                //CASTILLO1
		icoCastillo1 = new ImageIcon(getClass().getResource("/Imagenes/Castillo1.png"));
		this.imgCastillo1 = this.icoCastillo1.getImage();
                // LETRERO
		icoLetrero = new ImageIcon(getClass().getResource("/Imagenes/Letrero3.png"));
		this.imgLetrero = this.icoLetrero.getImage();
                
                mario = new Mario(300,245);
                tuberia1 = new Tuberia(600, 230);
		bloque1 = new Bloque(400, 180);
                
		this.setFocusable(true);
		this.requestFocusInWindow();
		this.addKeyListener(new Teclado());
		
		Thread chronoEcran = new Thread(new Tiempo());
		chronoEcran.start();
	}
	
	
	//**** GETTERS ****//	
	public int getDx() {return dx;}
        
        public int getxPos() {return xPos;}

        public int getySuelo() {return ySuelo;}

        public int getAlturaTecho() {return alturaTecho; }

	
	//**** SETTERS ****//
	public void setDx(int dx) {this.dx = dx;}
        
        public void setxPos(int xPos) {this.xPos = xPos;}
        
        public void setFondo1(int Fondo1) {this.Fondo1 = Fondo1;}

	public void setFondo2(int Fondo2) {this.Fondo2 = Fondo2;}

        public void setySuelo(int ySuelo) {this.ySuelo = ySuelo;}

        public void setAlturaTecho(int alturaTecho) {this.alturaTecho = alturaTecho;}
        
	//**** METODOS ****//
	public void desplazamientoFondo(){   
            if(this.xPos >= 0){
 		this.xPos = this.xPos + this.dx;		
		this.Fondo1 = this.Fondo1 - this.dx;
		this.Fondo2 = this.Fondo2 - this.dx;
		}
            
            // mostrar fondo infinito ARREGLADO
            if(this.Fondo1 == -800){this.Fondo1 = 800;}
		else if(this.Fondo2 == -800){this.Fondo2 = 800;}
		else if(this.Fondo1 == 800){this.Fondo1 = -800;}
		else if(this.Fondo2 == 800){this.Fondo2 = -800;}
        
        }


	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		Graphics g2 = (Graphics2D)g;
                
                // Detección de contacto de mario con un objeto.
		if(this.mario.cerca(this.bloque1)){this.mario.contacto(bloque1);}
 		if(this.mario.cerca(this.tuberia1)){this.mario.contacto(tuberia1);}
		
                // Mover todos los objetos "fijos" en el juego.
		this.desplazamientoFondo();
                this.tuberia1.desplazamiento();
                this.bloque1.desplazamiento();
		
		g2.drawImage(this.imgFondo1, this.Fondo1, 0, null); // diseño de imagen de fondo   
                g2.drawImage(this.imgFondo2, this.Fondo2, 0, null); 

                g2.drawImage(imgCastillo1, 10 - this.xPos, 95, null); // dejar atras al caminar
 		g2.drawImage(imgLetrero, 220 - this.xPos, 234, null); // dejar atras al caminar
                g2.drawImage(this.tuberia1.getImgTuberia(), this.tuberia1.getX() - 20, this.tuberia1.getY(), null);
 		g2.drawImage(this.bloque1.getImgBloque(), this.bloque1.getX() - 20, this.bloque1.getY(), null);
                
                if(this.mario.vSalto()){g2.drawImage(this.mario.salto(), this.mario.getX(), this.mario.getY(), null);}
 		else{g2.drawImage(this.mario.caminar("Mario", 25), this.mario.getX(), this.mario.getY(), null);}
        }
}