
package Paquete;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Movimiento implements Runnable {
    
    Snake  snake;
    protected int velocidad;
    boolean estado = true;
    
    public Movimiento(Snake snake, int velocidad){
        this.snake = snake;
        this.velocidad = velocidad;
    }
    
    @Override
    public void run() {
        while(estado){
            snake.avanzar();
            snake.repaint();
            try {
                Thread.sleep(this.velocidad);
            } catch (InterruptedException ex) {
                Logger.getLogger(Movimiento.class.getName()).log(Level.SEVERE, null, ex);
            }
        }            
    }
    
    public int getVelocidad() {
        return velocidad;
    }
    
    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }
    
    public void pausa(){
        this.estado = false;
    }
}