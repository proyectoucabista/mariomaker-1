
package Objetos;


import java.awt.Image;

import javax.swing.ImageIcon;

public class Tuberia extends Objeto{
	
	//**** VARIABLES ****//
	private Image imgTuberia;
	private ImageIcon icoTuberia;
	
	
	//**** CONSTRUCTOR	****//	
	public Tuberia(int x, int y) {

		super(x, y, 43, 65);		
		this.icoTuberia = new ImageIcon(getClass().getResource("/Imagenes/Tuberia.png"));
		this.imgTuberia = this.icoTuberia.getImage();
	}
	
	
	//**** GETTERS ****//		
	public Image getImgTuberia() {return imgTuberia;}
		
		
	//**** SETTERS ****//
		

	//**** METODOS ****//

}
