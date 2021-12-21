
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
	
	private ImageIcon icoMario; //* code provisoire
	private Image imgMario; //* code provisoire
	
	private int Fondo1;
	
	
	//**** CONSTRUCTEUR ****//	
	public Escenario(){
		
		super();
		
		this.Fondo1 = -50;
		
		icoFond = new ImageIcon(getClass().getResource("/Paquete1/Fondo.png"));
		this.imgFondo1 = this.icoFond.getImage();
		icoMario = new ImageIcon(getClass().getResource("/Paquete1/Mario1.png"));
		this.imgMario = this.icoMario.getImage();
	}
	
	
	//**** METHODES ****//
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		Graphics g2 = (Graphics2D)g;
		
		g2.drawImage(this.imgFondo1, this.Fondo1, 0, null); // Dessin de l'image de fond  		 	    
 		g2.drawImage(imgMario, 300, 245, null); //*** code provisoire
	}
}
