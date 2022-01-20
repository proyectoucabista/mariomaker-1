package Objetos;

import javax.swing.ImageIcon;

public class Tuberia extends Objeto{
	
	//**** VARIABLES ****//
	
	//**** CONSTRUCTOR	****//	
	public Tuberia(int x, int y) {
            super(x, y, 43, 65);		
            super.icoObjeto = new ImageIcon(getClass().getResource("/Imagenes/Tuberia.png"));
            super.imgObjeto = this.icoObjeto.getImage();
	}
	
	
	//**** GETTERS ****//		
		
		
	//**** SETTERS ****//
		

	//**** METODOS ****//

}
