
package Paquete;

public class Principal extends javax.swing.JFrame {

    public Principal() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MenuSnake = new javax.swing.JMenuBar();
        Inicio = new javax.swing.JMenu();
        Cerrar = new javax.swing.JMenuItem();
        UnJugador = new javax.swing.JMenu();
        Facil = new javax.swing.JMenuItem();
        Medio = new javax.swing.JMenuItem();
        Dificil = new javax.swing.JMenuItem();
        Multijugador = new javax.swing.JMenu();
        Offline = new javax.swing.JMenuItem();
        Informacion = new javax.swing.JMenu();
        AcercaDe = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Inicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Home.png"))); // NOI18N
        Inicio.setText("Inicio");

        Cerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Close.png"))); // NOI18N
        Cerrar.setText("Cerrar");
        Cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CerrarActionPerformed(evt);
            }
        });
        Inicio.add(Cerrar);

        MenuSnake.add(Inicio);

        UnJugador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/SinglePlayer.png"))); // NOI18N
        UnJugador.setText("Un Jugador");

        Facil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/OneStar.png"))); // NOI18N
        Facil.setText("Facil");
        Facil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FacilActionPerformed(evt);
            }
        });
        UnJugador.add(Facil);

        Medio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/TwoStars.png"))); // NOI18N
        Medio.setText("Medio");
        Medio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MedioActionPerformed(evt);
            }
        });
        UnJugador.add(Medio);

        Dificil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/ThreeStars.png"))); // NOI18N
        Dificil.setText("Dificil");
        Dificil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DificilActionPerformed(evt);
            }
        });
        UnJugador.add(Dificil);

        MenuSnake.add(UnJugador);

        Multijugador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Multiplayer.png"))); // NOI18N
        Multijugador.setText("Multijugador ");

        Offline.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Local.png"))); // NOI18N
        Offline.setText("Offline");
        Multijugador.add(Offline);

        MenuSnake.add(Multijugador);

        Informacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Information.png"))); // NOI18N
        Informacion.setText("Informacion ");

        AcercaDe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/About.png"))); // NOI18N
        AcercaDe.setText("Acerca De");
        Informacion.add(AcercaDe);

        MenuSnake.add(Informacion);

        setJMenuBar(MenuSnake);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 620, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 598, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void FacilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FacilActionPerformed
        String difficult = "easy";
        Pantalla pantalla = new Pantalla(difficult);
        pantalla.Iniciar(difficult);
    }//GEN-LAST:event_FacilActionPerformed

    private void DificilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DificilActionPerformed
        String difficult = "hard";
        Pantalla pantalla = new Pantalla(difficult);
        pantalla.Iniciar(difficult);
        
    }//GEN-LAST:event_DificilActionPerformed

    private void CerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CerrarActionPerformed
        System.exit(0);
    }//GEN-LAST:event_CerrarActionPerformed

    private void MedioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MedioActionPerformed
        String difficult = "medium";
        Pantalla pantalla = new Pantalla(difficult);
        pantalla.Iniciar(difficult);
    }//GEN-LAST:event_MedioActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem AcercaDe;
    private javax.swing.JMenuItem Cerrar;
    private javax.swing.JMenuItem Dificil;
    private javax.swing.JMenuItem Facil;
    private javax.swing.JMenu Informacion;
    private javax.swing.JMenu Inicio;
    private javax.swing.JMenuItem Medio;
    private javax.swing.JMenuBar MenuSnake;
    private javax.swing.JMenu Multijugador;
    private javax.swing.JMenuItem Offline;
    private javax.swing.JMenu UnJugador;
    // End of variables declaration//GEN-END:variables
}
