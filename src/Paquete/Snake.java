
package Paquete;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Snake extends JPanel {
    Color colorSnake = Color.green;
    Color colorComida = Color.red;
    int limite, division, totalDivisiones,residuo;
    List<int[]> snake = new ArrayList<>();
    int[] comida = new int[2] ;
    String direccion = "right";
    String proximaDireccion = "right";
    final String EASY = "easy";
   final String MEDIUM = "medium";
   final String HARD = "hard"; 
    Thread hilo;
    Movimiento movimiento;
    
    public Snake (int limite,int totalDivisiones, String difficult) {
        this.limite = limite;
        this.totalDivisiones = totalDivisiones;
        this.division = limite/totalDivisiones;
        this.residuo = limite%totalDivisiones; 
        int[]  a={totalDivisiones/2-1, totalDivisiones/2-1};
        int[]  b={totalDivisiones/2, totalDivisiones/2-1};
        snake.add(a);
        snake.add(b);
        generarComida();
        
        int speed = 200; 
        switch (difficult) {
            case EASY:
                speed = 200;        
                break;
            case MEDIUM:
                speed = 100;        
                break;
           case HARD:
                speed = 50;        
                break; 
        }
        
        movimiento = new Movimiento(this,  speed);
        hilo = new  Thread(movimiento);
        hilo.start();
    }
    
    @Override
    public void paint (Graphics pintor) {
        super.paint(pintor);
        pintor.setColor(colorSnake);
        
            for(int[] par:snake) {
                pintor.fillRect(residuo/2+par[0]*division, residuo/2+par[1]*division, division-1, division-1);
            }
            pintor.setColor(colorComida); 
            pintor.fillRect(residuo/2+comida[0]*division, residuo/2+comida[1]*division, division-1, division-1);
    } 
    
    public void avanzar() {
        igualarDireccion();
        int[] ultimo = snake.get(snake.size()-1);
        int agregarX = 0;
        int agregarY = 0;
        switch(direccion) {
            case "right": agregarX = 1 ;break;
            case "left": agregarX = -1 ;break;
            case "up": agregarY = -1 ;break;
            case "down": agregarY = 1 ;break;
        }
        int[] nuevo = { Math.floorMod(ultimo[0]+agregarX,totalDivisiones), Math.floorMod(ultimo[1]+agregarY,totalDivisiones) };
        
        boolean existencia = false;
        for(int i = 0; i < snake.size(); i++){
            if(nuevo[0]==snake.get(i)[0] && nuevo[1]==snake.get(i)[1]){
                existencia = true;
                break;
            }
        }
        if(existencia){
            JOptionPane.showMessageDialog(this, "Has Perdido");
        }else{
            if(nuevo[0]==comida[0] && nuevo[1]==comida[1]){
                snake.add(nuevo);
                generarComida();
            }else{
                snake.add(nuevo);
                snake.remove(0);
            }
        }
        
 
    }

    public void generarComida(){
        boolean existencia=false;
        int x = (int) (Math.random()*totalDivisiones);
        int y = (int) (Math.random()*totalDivisiones);
        for(int[] par:snake){
            if(par[0]==x && par[1]==y){
                existencia=true;
                generarComida();
                break;
            }
        } 
        if(!existencia){
            this.comida[0]=x;
            this.comida[1]=y;
        }
    }
    
    public void cambiarDireccion (String direccionVariable) {
        
        if((this.direccion.equals("right") || this.direccion.equals("left")) && (direccionVariable.equals("up") || direccionVariable.equals("down")))        
        this.proximaDireccion = direccionVariable;
        
         if((this.direccion.equals("up") || this.direccion.equals("down")) && (direccionVariable.equals("right") || direccionVariable.equals("left")))        
        this.proximaDireccion = direccionVariable;
    }
    public void igualarDireccion() {
        this.direccion = proximaDireccion;
    }
    
}