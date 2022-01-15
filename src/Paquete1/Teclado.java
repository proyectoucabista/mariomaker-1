package Paquete1;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Teclado implements KeyListener {

    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_RIGHT) { // tecla derecha

            if (Main.escenario.getxPos() == -1) {
                Main.escenario.setxPos(0);     // Réinitialisation de setxPos
                Main.escenario.setFondo1(-50); // Réinitialisation de xFond1
                Main.escenario.setFondo2(750); // Réinitialisation de xFond2
            }

            Main.escenario.mario.setCaminar(true);
            Main.escenario.mario.setMiraDerecha(true);
            Main.escenario.setDx(1);
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) { // tecla izquierda
            Main.escenario.mario.setCaminar(true);
            Main.escenario.mario.setMiraDerecha(false);
            Main.escenario.setDx(-1);
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        Main.escenario.mario.setCaminar(false);
        Main.escenario.setDx(0);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

}
