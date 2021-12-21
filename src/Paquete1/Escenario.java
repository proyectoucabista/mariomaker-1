package Paquete1;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Escenario extends JPanel {

	private ImageIcon icoFond;
	private Image imgFondo1;
	
	private ImageIcon icoMario; 
	private Image imgMario; 
	
	private int Fondo1;
	private int dx;
	
	//**** CONSTRUCTOR ****//	
	public Escenario(){
		
		super();
		
		this.Fondo1 = -10;
		this.dx = 0;
		
		icoFond = new ImageIcon(getClass().getResource("/Paquete1/Fondo.png"));
		this.imgFondo1 = this.icoFond.getImage();
		icoMario = new ImageIcon(getClass().getResource("/Paquete1/Mario1.png"));
		this.imgMario = this.icoMario.getImage();
		
		this.setFocusable(true);
		this.requestFocusInWindow();
		this.addKeyListener(new Teclado());
		
		Thread chronoEcran = new Thread(new Tiempo());
		chronoEcran.start();
	}
	
	
	//**** GETTERS ****//	
	public int getDx() {return dx;}
	
	
	//**** SETTERS ****//
	public void setDx(int dx) {this.dx = dx;}
	
	
	//**** METODOS ****//
	public void deplacementFond(){this.Fondo1 = this.Fondo1 - this.dx;}


	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		Graphics g2 = (Graphics2D)g;
		
		this.deplacementFond();
		
		g2.drawImage(this.imgFondo1, this.Fondo1, 0, null); // diseño de imagen de fondo		 	    
 		g2.drawImage(imgMario, 300, 245, null); 
	}
}
