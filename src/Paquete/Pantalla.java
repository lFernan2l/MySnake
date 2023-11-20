
package Paquete;

import java.awt.event.KeyEvent;

public class Pantalla extends javax.swing.JFrame {

    Snake snake;
    
    public Pantalla(String difficult) {
        initComponents();
        this.setLocationRelativeTo(null);
        
        snake = new Snake (600,30,  difficult);
        this.add(snake);
        snake.setBounds(10,10,600,600);
        snake.setOpaque(false);
        
        Fondo fondo =  new Fondo(600,30);
        this.add(fondo);
        fondo.setBounds(10,10,600,600);
        
        this.requestFocus(true);
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 620, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 620, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        switch (evt.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                snake.cambiarDireccion("left");
                break;
            case KeyEvent.VK_RIGHT:
                snake.cambiarDireccion("right");
                break;
            case KeyEvent.VK_UP:
                snake.cambiarDireccion("up");
                break;
            case KeyEvent.VK_DOWN:
                snake.cambiarDireccion("down");
                break;                           
        }
    }//GEN-LAST:event_formKeyPressed

    public void Iniciar (String difficult){
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pantalla(difficult).setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
