package Paquete1;

import Objetos.Bloque;
import Objetos.Objeto;
import Objetos.Tuberia;
import Personajes.Mario;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


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
        public Tuberia tuberia2;
        public Tuberia tuberia3;
        public Tuberia tuberia4;
        public Tuberia tuberia5;
        public Tuberia tuberia6;
        public Tuberia tuberia7;
        public Tuberia tuberia8;
        
	public Bloque bloque1;	
        public Bloque bloque2;
        public Bloque bloque3;	
        public Bloque bloque4;	
        public Bloque bloque5;	
        public Bloque bloque6;	
        public Bloque bloque7;	
        public Bloque bloque8;	
        public Bloque bloque9;	
        public Bloque bloque10;	
        public Bloque bloque11;	
        public Bloque bloque12;	
        
        private ImageIcon icoBandera;
	private Image imgBandera;
	private ImageIcon icoCastilloFin;
	private Image imgCastilloFin;
        
        private ArrayList<Objeto> tabObjetos; // tableau qui enregistre tous les objets du jeu.
        
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
                // FONDO2.1
                this.imgFondo2 = this.icoFond.getImage();
                
                // MARIO
		icoMario = new ImageIcon(getClass().getResource("/Imagenes/MarioDerecha.png"));
		this.imgMario = this.icoMario.getImage();
                
                //CASTILLO1
		icoCastillo1 = new ImageIcon(getClass().getResource("/Imagenes/Castillo1.png"));
		this.imgCastillo1 = this.icoCastillo1.getImage();
                
                // LETRERO
		icoLetrero = new ImageIcon(getClass().getResource("/Imagenes/Letrero3.png"));
		this.imgLetrero = this.icoLetrero.getImage();
                
                mario = new Mario(300,245);
                
                tuberia1 = new Tuberia(600, 230);
		tuberia2 = new Tuberia(1000, 230);
		tuberia3 = new Tuberia(1600, 230);
		tuberia4 = new Tuberia(1900, 230);
		tuberia5 = new Tuberia(2500, 230);
		tuberia6 = new Tuberia(3000, 230);
		tuberia7 = new Tuberia(3800, 230);
		tuberia8 = new Tuberia(4500, 230);
                
		bloque1 = new Bloque(400, 180);
                bloque2 = new Bloque(1200, 180);
		bloque3 = new Bloque(1270, 170);
		bloque4 = new Bloque(1340, 160);
		bloque5 = new Bloque(2000, 180);
		bloque6 = new Bloque(2600, 160);
		bloque7 = new Bloque(2650, 180);
		bloque8 = new Bloque(3500, 160);
		bloque9 = new Bloque(3550, 140);
		bloque10 = new Bloque(4000, 170);
		bloque11 = new Bloque(4200, 200);
		bloque12 = new Bloque(4300, 210);
                
                this.icoCastilloFin = new ImageIcon(getClass().getResource("/Imagenes/CastilloFin.png"));
		this.imgCastilloFin = this.icoCastilloFin.getImage(); 
		
		this.icoBandera = new ImageIcon(getClass().getResource("/Imagenes/Bandera.png"));
		this.imgBandera = this.icoBandera.getImage(); 
		
		tabObjetos = new ArrayList<Objeto>();
                
		this.tabObjetos.add(this.tuberia1);
		this.tabObjetos.add(this.tuberia2);
		this.tabObjetos.add(this.tuberia3);
		this.tabObjetos.add(this.tuberia4);
		this.tabObjetos.add(this.tuberia5);
		this.tabObjetos.add(this.tuberia6);
		this.tabObjetos.add(this.tuberia7);
		this.tabObjetos.add(this.tuberia8);
		
		this.tabObjetos.add(this.bloque1);
		this.tabObjetos.add(this.bloque2);
		this.tabObjetos.add(this.bloque3);
		this.tabObjetos.add(this.bloque4);
		this.tabObjetos.add(this.bloque5);
		this.tabObjetos.add(this.bloque6);
		this.tabObjetos.add(this.bloque7);
		this.tabObjetos.add(this.bloque8);
		this.tabObjetos.add(this.bloque9);
		this.tabObjetos.add(this.bloque10);
		this.tabObjetos.add(this.bloque11);
		this.tabObjetos.add(this.bloque12);
                
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
            if(this.xPos >= 0 && this.xPos <= 4430){
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
                for(int i = 0; i < this.tabObjetos.size(); i++){
		    // mario
		    if(this.mario.cerca(this.tabObjetos.get(i))){this.mario.contacto(this.tabObjetos.get(i));}
		}
		
                // Mover todos los objetos "fijos" en el juego.
                this.desplazamientoFondo();
                if(this.xPos >= 0 && this.xPos <= 4430){
		    for(int i = 0; i < this.tabObjetos.size(); i++){this.tabObjetos.get(i).desplazamiento();}
		}
		
                //Imagenes de fondo
		g2.drawImage(this.imgFondo1, this.Fondo1, 0, null); // diseño de imagen de fondo   
                g2.drawImage(this.imgFondo2, this.Fondo2, 0, null); 
                
                //Imagenes del inicio
                g2.drawImage(imgCastillo1, 10 - this.xPos, 95, null); // dejar atras al caminar
 		g2.drawImage(imgLetrero, 220 - this.xPos, 234, null); // dejar atras al caminar
                
                // Images de objetos
 	 	for(int i = 0; i < this.tabObjetos.size(); i++){
 	 		g2.drawImage(this.tabObjetos.get(i).getImgObjeto(), this.tabObjetos.get(i).getX(), this.tabObjetos.get(i).getY(), null);
 	 	}
               
                // Imagenes del final
 	 	g2.drawImage(imgBandera, 4650 - this.xPos, 115, null);
 		g2.drawImage(imgCastilloFin, 5000 - this.xPos, 145, null);
                
                // Imagen de mario
                if(this.mario.vSalto()){g2.drawImage(this.mario.salto(), this.mario.getX(), this.mario.getY(), null);}
 		else{g2.drawImage(this.mario.caminar("Mario", 25), this.mario.getX(), this.mario.getY(), null);}
        }
}