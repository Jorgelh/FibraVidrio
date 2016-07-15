/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import java.awt.Dimension;
import java.util.Locale;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author jluis
 */
public class Inicio extends javax.swing.JFrame {

    /**
     * Creates new form Inicio
     */
    public Inicio() {
         try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
        }
        initComponents();
        setLocationRelativeTo(null);
        this.setExtendedState(MAXIMIZED_BOTH);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel1 = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenu8 = new javax.swing.JMenu();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        Pendientes = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem24 = new javax.swing.JMenuItem();
        jMenuItem25 = new javax.swing.JMenuItem();
        jMenu12 = new javax.swing.JMenu();
        jMenuItem26 = new javax.swing.JMenuItem();
        jMenuItem27 = new javax.swing.JMenuItem();
        jMenu11 = new javax.swing.JMenu();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenu13 = new javax.swing.JMenu();
        jMenuItem23 = new javax.swing.JMenuItem();
        jMenuItem28 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CONTROL FIBRA DE VIDRIO");

        Panel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Eras Bold ITC", 2, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 255));
        jLabel1.setText("FIBRA DE VIDRIO");

        Panel1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout Panel1Layout = new javax.swing.GroupLayout(Panel1);
        Panel1.setLayout(Panel1Layout);
        Panel1Layout.setHorizontalGroup(
            Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel1Layout.createSequentialGroup()
                .addContainerGap(446, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        Panel1Layout.setVerticalGroup(
            Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel1Layout.createSequentialGroup()
                .addContainerGap(406, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(30, 30, 30))
        );

        jMenuBar1.setToolTipText("");
        jMenuBar1.setFont(new java.awt.Font("Eras Bold ITC", 0, 14)); // NOI18N
        jMenuBar1.setPreferredSize(new java.awt.Dimension(25, 35));
        jMenuBar1.addHierarchyListener(new java.awt.event.HierarchyListener() {
            public void hierarchyChanged(java.awt.event.HierarchyEvent evt) {
                jMenuBar1HierarchyChanged(evt);
            }
        });

        jMenu1.setBorder(null);
        jMenu1.setForeground(new java.awt.Color(0, 102, 255));
        jMenu1.setText("  DRAWINGS");
        jMenu1.setAutoscrolls(true);
        jMenu1.setFont(new java.awt.Font("Eras Bold ITC", 0, 14)); // NOI18N
        jMenu1.setPreferredSize(new java.awt.Dimension(105, 25));

        jMenuItem1.setText("Buscar ");
        jMenu1.add(jMenuItem1);

        jMenuItem5.setText("Agregar");
        jMenu1.add(jMenuItem5);

        jMenuItem6.setText("Reubicar ");
        jMenu1.add(jMenuItem6);

        jMenuBar1.add(jMenu1);
        jMenu1.getAccessibleContext().setAccessibleName("Drawings");

        jMenu4.setForeground(new java.awt.Color(0, 102, 255));
        jMenu4.setActionCommand(" P/N");
        jMenu4.setFont(new java.awt.Font("Eras Bold ITC", 0, 14)); // NOI18N
        jMenu4.setLabel("  P/N");
        jMenu4.setPreferredSize(new java.awt.Dimension(50, 25));

        jMenuItem4.setFont(new java.awt.Font("Eras Bold ITC", 1, 14)); // NOI18N
        jMenuItem4.setText("Nuevo P/N ");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem4);

        jMenuItem14.setText("Editar P/N");
        jMenu4.add(jMenuItem14);

        jMenu8.setText("Componentes");
        jMenu8.setFont(new java.awt.Font("Eras Bold ITC", 0, 14)); // NOI18N

        jMenuItem13.setFont(new java.awt.Font("Eras Bold ITC", 0, 14)); // NOI18N
        jMenuItem13.setText("Nuevo");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem13);

        jMenuItem8.setText("Editar");
        jMenu8.add(jMenuItem8);

        jMenu4.add(jMenu8);

        jMenuBar1.add(jMenu4);

        jMenu3.setForeground(new java.awt.Color(0, 102, 255));
        jMenu3.setText("TRABAJOS");
        jMenu3.setFont(new java.awt.Font("Eras Bold ITC", 0, 14)); // NOI18N
        jMenu3.setPreferredSize(new java.awt.Dimension(87, 19));

        jMenuItem2.setText("Nuevo");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem2);

        jMenuItem9.setText("Entregar");
        jMenu3.add(jMenuItem9);

        Pendientes.setText("Pendientes");
        jMenu3.add(Pendientes);

        jMenuItem7.setText("Terminados");
        jMenu3.add(jMenuItem7);

        jMenuBar1.add(jMenu3);

        jMenu5.setForeground(new java.awt.Color(0, 102, 255));
        jMenu5.setText("  FOTOS");
        jMenu5.setToolTipText("");
        jMenu5.setFont(new java.awt.Font("Eras Bold ITC", 0, 14)); // NOI18N
        jMenu5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jMenu5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jMenu5.setPreferredSize(new java.awt.Dimension(75, 25));

        jMenu7.setText("Fotos");
        jMenu5.add(jMenu7);

        jMenuBar1.add(jMenu5);

        jMenu2.setForeground(new java.awt.Color(0, 102, 255));
        jMenu2.setFont(new java.awt.Font("Eras Bold ITC", 0, 14)); // NOI18N
        jMenu2.setLabel("  BODEGA PRODUCTOS");
        jMenu2.setMinimumSize(new java.awt.Dimension(29, 25));
        jMenu2.setPreferredSize(new java.awt.Dimension(185, 25));

        jMenuItem24.setText("Ingreso");
        jMenu2.add(jMenuItem24);

        jMenuItem25.setText("Descargas");
        jMenu2.add(jMenuItem25);

        jMenu12.setText("Consultas");

        jMenuItem26.setText("Ingresos");
        jMenu12.add(jMenuItem26);

        jMenuItem27.setText("Descargas");
        jMenu12.add(jMenuItem27);

        jMenu2.add(jMenu12);

        jMenuBar1.add(jMenu2);

        jMenu11.setForeground(new java.awt.Color(0, 102, 255));
        jMenu11.setFocusTraversalPolicyProvider(true);
        jMenu11.setFont(new java.awt.Font("Eras Bold ITC", 0, 14)); // NOI18N
        jMenu11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jMenu11.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jMenu11.setLabel("  BODEGA MATERIALES");
        jMenu11.setPreferredSize(new java.awt.Dimension(190, 25));

        jMenuItem10.setText("Existencias Bodega");
        jMenu11.add(jMenuItem10);

        jMenuItem11.setText("Ingresos");
        jMenu11.add(jMenuItem11);

        jMenuItem12.setText("Descargas");
        jMenu11.add(jMenuItem12);

        jMenu13.setText("Consultas");

        jMenuItem23.setText("Ingresos");
        jMenu13.add(jMenuItem23);

        jMenuItem28.setText("Descargas");
        jMenu13.add(jMenuItem28);

        jMenu11.add(jMenu13);

        jMenuBar1.add(jMenu11);

        jMenu6.setForeground(new java.awt.Color(255, 0, 0));
        jMenu6.setFocusPainted(true);
        jMenu6.setFont(new java.awt.Font("Eras Bold ITC", 0, 14)); // NOI18N
        jMenu6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jMenu6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jMenu6.setLabel("  SALIR");
        jMenu6.setPreferredSize(new java.awt.Dimension(65, 25));

        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/cancelar.png"))); // NOI18N
        jMenuItem3.setText("Salir");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem3);

        jMenuBar1.add(jMenu6);

        setJMenuBar(jMenuBar1);
        jMenuBar1.getAccessibleContext().setAccessibleName("");
        jMenuBar1.getAccessibleContext().setAccessibleDescription("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuBar1HierarchyChanged(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_jMenuBar1HierarchyChanged
     
    }//GEN-LAST:event_jMenuBar1HierarchyChanged

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        
        IngresoTrabajos compo = new IngresoTrabajos();
        Panel1.add(compo);
        Dimension desktopSize = Panel1.getSize();
        Dimension FrameSize = compo.getSize();
        compo.setLocation((desktopSize.width - FrameSize.width)/2 , (desktopSize.height - FrameSize.height)/2);
        compo.show();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        System.exit(1);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
       
        IngresoComponentes compo = new IngresoComponentes();
        Panel1.add(compo);
        Dimension desktopSize = Panel1.getSize();
        Dimension FrameSize = compo.getSize();
        compo.setLocation((desktopSize.width - FrameSize.width)/2 , (desktopSize.height - FrameSize.height)/2);
        compo.show();
   
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
       IngresosPN ingre  = new IngresosPN();
       Panel1.add(ingre);
       Dimension desktopSize = Panel1.getSize();
        Dimension FrameSize = ingre.getSize();
        ingre.setLocation((desktopSize.width - FrameSize.width)/2 , (desktopSize.height - FrameSize.height)/2);
        ingre.show();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

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
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane Panel1;
    private javax.swing.JMenuItem Pendientes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu11;
    private javax.swing.JMenu jMenu12;
    private javax.swing.JMenu jMenu13;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem23;
    private javax.swing.JMenuItem jMenuItem24;
    private javax.swing.JMenuItem jMenuItem25;
    private javax.swing.JMenuItem jMenuItem26;
    private javax.swing.JMenuItem jMenuItem27;
    private javax.swing.JMenuItem jMenuItem28;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    // End of variables declaration//GEN-END:variables
}
