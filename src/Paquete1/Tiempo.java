
package Paquete1;

public class Tiempo implements Runnable{

	private final int PAUSE = 3; 
	
	@Override
	public void run() {

		while(true){ 
			
			Main.escenario.repaint();
			System.out.println("ok"); // SI TODO esta bien
			try {
				Thread.sleep(PAUSE);
			}catch (InterruptedException e) {}
		}
	}

}

