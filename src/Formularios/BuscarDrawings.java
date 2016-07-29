/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import BD.Entregas;
import Class.CEntregas;
import java.awt.Desktop;
import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jluis
 */
public class BuscarDrawings extends javax.swing.JInternalFrame {

    /**
     * Creates new form BuscarDrawings
     */
    public BuscarDrawings() {
        initComponents();
        BCarpeta.setEnabled(false);
        BuscarDrawins();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtPN = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Drawings = new javax.swing.JTable();
        BCarpeta = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("P/N");

        txtPN.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        txtPN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPNKeyReleased(evt);
            }
        });

        Drawings.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "P/N", "GAVETA", "FOLDER", "NOTAS"
            }
        ));
        Drawings.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DrawingsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Drawings);

        BCarpeta.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BCarpeta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/icon.png"))); // NOI18N
        BCarpeta.setText("CARPETA DE DRAWING");
        BCarpeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BCarpetaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtPN, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BCarpeta))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(15, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 944, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtPN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BCarpeta))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPNKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPNKeyReleased
        BuscarDrawins();
    }//GEN-LAST:event_txtPNKeyReleased

    private void BCarpetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BCarpetaActionPerformed
        DefaultTableModel tm = (DefaultTableModel)Drawings.getModel();
        String P = String.valueOf(tm.getValueAt(Drawings.getSelectedRow(),0));
            try {
                if(P.equals("")){
                JOptionPane.showMessageDialog(null, "SELECCIONE UN P/N DE LA LISTA");
                }else{
                Desktop.getDesktop().open(new File("\\\\192.168.0.2\\Compartida Produccion\\DRAWINGS\\TRANSFORMERS\\DRAWINGS\\" + P));
                }    
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "EL P/N "+P+" NO TIENE CARPETA");
                }
            
            
            
       
    }//GEN-LAST:event_BCarpetaActionPerformed

    private void DrawingsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DrawingsMouseClicked
        BCarpeta.setEnabled(true);
    }//GEN-LAST:event_DrawingsMouseClicked

     private void BuscarDrawins() {
        ArrayList<CEntregas> result = Entregas.BuscarDrawings(txtPN.getText());
        cargarTabla(result);
    }

    private void cargarTabla(ArrayList<CEntregas> list1) {

        Object[][] dato = new Object[list1.size()][5];
        int f = 0;
        for (CEntregas a : list1) {
            dato[f][0] = a.getPN();
            dato[f][1] = a.getRev();
            dato[f][2] = a.getGabeta();
            dato[f][3] = a.getFolder();
            dato[f][4] = a.getNota();
            f++;
        }
        Drawings.setModel(new javax.swing.table.DefaultTableModel(
                dato,
                new String[]{
                "P/N","REV","GAVETA","FOLDER","NOTA"
                }) {
            @Override
            public boolean isCellEditable(int row, int colum) {
                return false;
            }
        });
    
    }
    
    
    
    
    
    
    
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
            java.util.logging.Logger.getLogger(BuscarDrawings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BuscarDrawings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BuscarDrawings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BuscarDrawings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BuscarDrawings().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BCarpeta;
    private javax.swing.JTable Drawings;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtPN;
    // End of variables declaration//GEN-END:variables
}
