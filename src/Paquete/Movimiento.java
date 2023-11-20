
package Paquete;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Movimiento implements Runnable {
    
    Snake  snake;
    protected int speed;
    boolean estado=true ;
    
    public Movimiento(Snake snake, int speed){
        this.snake=snake;
        this.speed=speed;
    }
    
    @Override
    public void run() {
        while(estado){
            snake.avanzar();
            snake.repaint();
            try {
                Thread.sleep(this.speed);
            } catch (InterruptedException ex) {
                Logger.getLogger(Movimiento.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public int getSpeed() {
        return speed;
    }
    
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    
    public void pausa(){
        this.estado=false;
    }
}