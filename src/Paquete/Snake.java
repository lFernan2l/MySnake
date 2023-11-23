
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
    int tamaño, celdas, conjuntoCeldas, resto;
    List<int[]> cuerpoSnake = new ArrayList<>();
    int[] comida = new int[2];
    String direccion = "right";
    String direccionSiguiente = "right";
    // Pantalla pantalla = new Pantalla(null);
    final String EASY = "easy";
    final String MEDIUM = "medium";
    final String HARD = "hard"; 
    Thread hilo;
    Movimiento movimiento;
    Pantalla p;
    
    public Snake (int tamaño, int conjuntoCeldas, String difficult, Pantalla p) {
        this.tamaño = tamaño;
        this.conjuntoCeldas = conjuntoCeldas;
        this.celdas = tamaño/conjuntoCeldas;
        this.resto = tamaño%conjuntoCeldas; 
        int[]  a={conjuntoCeldas/2-1, conjuntoCeldas/2-1};
        int[]  b={conjuntoCeldas/2, conjuntoCeldas/2-1};
        cuerpoSnake.add(a);
        cuerpoSnake.add(b);
        generarComida();
        
        int velocidad = 200; 
        switch (difficult) {
            case EASY:
                velocidad = 200;        
                break;
            case MEDIUM:
                velocidad = 100;        
                break;
           case HARD:
                velocidad = 50;        
                break; 
        }
        
        movimiento = new Movimiento(this,  velocidad);
        hilo = new  Thread(movimiento);
        hilo.start();
        
        this.p = p;
    }
    
    @Override
    public void paint (Graphics pintor) {
        super.paint(pintor);
        pintor.setColor(colorSnake);
        
            for(int[] par:cuerpoSnake) {
                pintor.fillRect(resto/2+par[0]*celdas, resto/2+par[1]*celdas, celdas-1, celdas-1);
            }
            pintor.setColor(colorComida); 
            pintor.fillRect(resto/2+comida[0]*celdas, resto/2+comida[1]*celdas, celdas-1, celdas-1);
    } 
    
    public void avanzar() {
        igualarDireccion();
        int[] ultimo = cuerpoSnake.get(cuerpoSnake.size()-1);
        int agregarX = 0;
        int agregarY = 0;
        switch(direccion) {
            case "right": agregarX = 1 ;break;
            case "left": agregarX = -1 ;break;
            case "up": agregarY = -1 ;break;
            case "down": agregarY = 1 ;break;
        }
        int[] nuevo = { Math.floorMod(ultimo[0]+agregarX,conjuntoCeldas), Math.floorMod(ultimo[1]+agregarY,conjuntoCeldas) };
        
        boolean existencia = false;
        for(int i = 0; i < cuerpoSnake.size(); i++){
            if(nuevo[0]==cuerpoSnake.get(i)[0] && nuevo[1]==cuerpoSnake.get(i)[1]){
                 existencia = true;
                 break;
            }
        }
        if(existencia) {
            movimiento.pausa();
            JOptionPane.showMessageDialog(p, "Has Perdido");
            p.dispose();
        } else {
             if(nuevo[0]==comida[0] && nuevo[1]==comida[1]){
                cuerpoSnake.add(nuevo);
                generarComida();
            }else{
                cuerpoSnake.add(nuevo);
                cuerpoSnake.remove(0);
            }
        }
        
    }

    public void generarComida(){
        boolean existencia=false;
        int x = (int) (Math.random()*conjuntoCeldas);
        int y = (int) (Math.random()*conjuntoCeldas);
        for(int[] par:cuerpoSnake){
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
        this.direccionSiguiente = direccionVariable;
        
         if((this.direccion.equals("up") || this.direccion.equals("down")) && (direccionVariable.equals("right") || direccionVariable.equals("left")))        
        this.direccionSiguiente = direccionVariable;
    }
    public void igualarDireccion() {
        this.direccion = direccionSiguiente;
    }
}