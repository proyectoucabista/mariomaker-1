
package Objetos;

import java.awt.Image;
import javax.swing.ImageIcon;


public class Bloque extends Objeto{
	//**** VARIABLES ****//
		private Image imgBloque;
		private ImageIcon icoBloque;
		
		
		//**** CONSTRUCTOR	****//	
		public Bloque(int x, int y) {

			super(x, y, 43, 65);		
			this.icoBloque = new ImageIcon(getClass().getResource("/Imagenes/Ladrillo.png"));
			this.imgBloque = this.icoBloque.getImage();
		}
		
		
		//**** GETTERS ****//		
		public Image getImgBloque() {return imgBloque;}
			
			
		//**** SETTERS ****//
			

		//**** METHODES ****//
}
