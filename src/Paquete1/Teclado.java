
package Paquete1;



import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Teclado implements KeyListener{

	@Override
	public void keyPressed(KeyEvent e) {
		
		if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			Main.escenario.setDx(1);
		}else if(e.getKeyCode() == KeyEvent.VK_LEFT){
			Main.escenario.setDx(-1);
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {Main.escenario.setDx(0);}

	@Override
	public void keyTyped(KeyEvent e) {}

}

