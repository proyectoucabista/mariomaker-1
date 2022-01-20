package Objetos;

import javax.swing.ImageIcon;

public class Bloque extends Objeto{
    
	//**** VARIABLES ****//
		
        //**** CONSTRUCTOR	****//	
        public Bloque(int x, int y) {
            super(x, y, 30, 30);		
            super.icoObjeto = new ImageIcon(getClass().getResource("/Imagenes/Ladrillo.png"));
            super.imgObjeto = this.icoObjeto.getImage();
        }


        //**** GETTERS ****//		
   

        //**** SETTERS ****//


        //**** METHODES ****//
}
