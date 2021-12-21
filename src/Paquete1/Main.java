
package Paquete1;

import javax.swing.JFrame;

public class Main {

	public static Escenario escenario;
	
	public static void main(String[] args) {
		
		// creacion de la ventana del juego
		JFrame ventana = new JFrame("Juego de Mario Bros");
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setSize(700, 360);
		ventana.setLocationRelativeTo(null);
		ventana.setResizable(false);
		ventana.setAlwaysOnTop(true);
		
		// Iniciacion de la escena
		escenario = new Escenario();
				
		ventana.setContentPane(escenario); 
		ventana.setVisible(true);		
	}
}

