
package Personajes;




import java.awt.Image;

import javax.swing.ImageIcon;

public class Mario extends Personaje{

	
	//**** VARIABLES ****//
	private Image imgMario;
	private ImageIcon icoMario;

      //**** CONSTRUCTOR ***//	
	public Mario(int x, int y) {

	super(x,y,28,50);		
	this.icoMario = new ImageIcon("src/Imagenes/Mario1.png");
	this.imgMario = this.icoMario.getImage();
	}

		
	
		
	//**** GETTERS ****//		
	public Image getImgMario() {return imgMario;}
		
		
	//**** SETTERS ****//
		

	//**** METHODES ****//		
}

