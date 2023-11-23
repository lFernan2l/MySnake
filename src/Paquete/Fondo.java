
package Paquete;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Fondo extends JPanel {
    Color colorFondo = Color.black;
    int tamaño, celdas, conjuntoCeldas, resto;
    
    public Fondo (int tamaño,int conjuntoCeldas) {
        this.tamaño = tamaño;
        this.conjuntoCeldas = conjuntoCeldas;
        this.celdas = tamaño/conjuntoCeldas;
        this.resto = tamaño%conjuntoCeldas; 
    }
    
    @Override
    public void paint (Graphics pintor) {
        super.paint(pintor);
        pintor.setColor(colorFondo);
        for (int i=0; i<conjuntoCeldas; i++) {
            for(int j=0;  j<conjuntoCeldas ; j++) {
                pintor.fillRect(resto/2+i*celdas, resto/2+j*celdas, celdas-1, celdas-1);
            }
        }
    }
}