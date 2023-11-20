
package Paquete;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Fondo extends JPanel {
    Color colorFondo = Color.black;
    int limite, division, totalDivisiones,residuo;
    
    public Fondo (int limite,int totalDivisiones) {
        this.limite = limite;
        this.totalDivisiones = totalDivisiones;
        this.division = limite/totalDivisiones;
        this.residuo = limite%totalDivisiones; 
    }
    
    @Override
    public void paint (Graphics pintor) {
        super.paint(pintor);
        pintor.setColor(colorFondo);
        for (int i=0; i<totalDivisiones; i++) {
            for(int j=0;  j<totalDivisiones ; j++) {
                pintor.fillRect(residuo/2+i*division, residuo/2+j*division, division-1, division-1);
            }
        }
    }
}