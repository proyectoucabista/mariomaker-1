
package Paquete1;

import javax.swing.JFrame;


public class Main {

	public static Escenario escenario;
	
	public static void main(String[] args) {
            final int anchov = 700; // ancho Ventana
            final int alturav = 360; // altura Ventana
		
		// creacion de la ventana del juego
		JFrame ventana = new JFrame("Juego de Mario Bros"); // titulo de la ventana
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setSize(anchov, alturav);
		ventana.setLocationRelativeTo(null);
		ventana.setResizable(false);
		ventana.setAlwaysOnTop(true);
		
		// Iniciacion de la escena
		escenario = new Escenario();
				
		ventana.setContentPane(escenario); 
		ventana.setVisible(true);		
	}
}

