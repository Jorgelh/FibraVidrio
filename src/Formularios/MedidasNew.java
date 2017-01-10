/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import BD.BDFIBRA;
import BD.EditComponentesHerramienta;
import Class.DescripcionC;
import static Formularios.ingresoHerramientas.llenarCombo2;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.TableColumn;

/**
 *
 * @author jluis
 */
public class MedidasNew extends javax.swing.JInternalFrame {
    String accion = "";
    /**
     * Creates new form MarcaNew
     */
    public MedidasNew() {
        initComponents();
        BEditar.setEnabled(false);
        BGuardar.setEnabled(false);
        BNuevo.requestFocus();
        txtDescripcion.setEditable(false);
        actualizarBusqueda();
    }

    public void obtenerUltimoIdfam() {
        try {
            Connection con = BDFIBRA.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select max(NO_MEDIDA) from M_MEDIDAS");
            while (rs.next()) {
                int lastID = rs.getInt(1);
                txtNo.setText(String.valueOf(lastID + 1));
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException error) {
            System.out.print(error);
        }
    }
    
    public void limpiarCajaTextofam() {
        txtNo.setText("");
        txtDescripcion.setText("");
    }

    public void activarCajaTextofam(boolean b) {
        txtNo.setEditable(!b);
        txtDescripcion.setEditable(b);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNo = new javax.swing.JTextField();
        txtDescripcion = new javax.swing.JTextField();
        BNuevo = new javax.swing.JButton();
        BGuardar = new javax.swing.JButton();
        BEditar = new javax.swing.JButton();
        BCancelar = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosed(evt);
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));

        Tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No.", "Descripcion"
            }
        ));
        Tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Tabla);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("No.");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Descripcion");

        txtNo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        txtDescripcion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtDescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescripcionActionPerformed(evt);
            }
        });

        BNuevo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/New.png"))); // NOI18N
        BNuevo.setText("Nuevo");
        BNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BNuevoActionPerformed(evt);
            }
        });

        BGuardar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/save2.png"))); // NOI18N
        BGuardar.setText("Guardar");
        BGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BGuardarActionPerformed(evt);
            }
        });

        BEditar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/edit2.png"))); // NOI18N
        BEditar.setText("Editar");
        BEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BEditarActionPerformed(evt);
            }
        });

        BCancelar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/cancelar.png"))); // NOI18N
        BCancelar.setText("Cancelar");
        BCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNo, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(BNuevo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BCancelar)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 4, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(BNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaMouseClicked
        
        BEditar.setEnabled(true);
        BGuardar.setEnabled(false);
        try {
            DescripcionC m = EditComponentesHerramienta.buscarMedida(Integer.parseInt(String.valueOf(Tabla.getModel().getValueAt(Tabla.getSelectedRow(),0))));
            txtNo.setText(String.valueOf(m.getId()));
            txtDescripcion.setText(m.getDescripcion());
        } catch (Exception e) {
            System.out.println("Erro de Seleccion:"+e);
        }
        
        
        
    }//GEN-LAST:event_TablaMouseClicked

    private void BNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BNuevoActionPerformed

     limpiarCajaTextofam();
        activarCajaTextofam(true);
        BGuardar.setEnabled(true);
        BCancelar.setEnabled(true);
        BNuevo.setEnabled(false);
        BEditar.setEnabled(false);
        obtenerUltimoIdfam();
        accion = "Guardar";
        txtDescripcion.setEditable(true);
        txtDescripcion.requestFocus();

    }//GEN-LAST:event_BNuevoActionPerformed

    private void BGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BGuardarActionPerformed
      
        if(accion.equalsIgnoreCase("Guardar")){

            if (txtNo.getText().compareTo("")!=0 && txtDescripcion.getText().compareTo("")!=0){
                try {
                    txtDescripcion.setEditable(true);
                    DescripcionC m = new DescripcionC();
                    m.setDescripcion(txtDescripcion.getText().toUpperCase());
                    m.setId(Integer.parseInt(txtNo.getText()));
                    EditComponentesHerramienta.insertarMedida(m);
                    JOptionPane.showMessageDialog(null,"Registro Guardado");
                } catch (Exception e) {
                    System.out.println("Error BD:"+e.getMessage());
                }
                limpiarCajaTextofam();
                obtenerUltimoIdfam();
                actualizarBusqueda();
                BGuardar.setEnabled(false);
                BNuevo.requestFocus();
                BNuevo.setEnabled(true);
                txtDescripcion.setEditable(false);
              

            }else {
                JOptionPane.showMessageDialog(null,"Llene Todos Los Campos...");
            }
        }
        if (accion.equalsIgnoreCase("Actualizar")) {
            DescripcionC p;
            try {
                p=EditComponentesHerramienta.buscarMedida(Integer.parseInt(txtNo.getText()));
                p.setDescripcion(txtDescripcion.getText());
                EditComponentesHerramienta.actualizarMedida(p);
                JOptionPane.showMessageDialog(null, "[Datos Actualizados]");
                limpiarCajaTextofam();
                obtenerUltimoIdfam();
                BGuardar.setEnabled(false);
                BNuevo.setEnabled(true);
                actualizarBusqueda();
             } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error BD: " + e.getMessage());
            }
        }
        

    }//GEN-LAST:event_BGuardarActionPerformed

    private void BEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BEditarActionPerformed
           
        accion = "Actualizar";
        activarCajaTextofam(true);
        BNuevo.setEnabled(false);
        BGuardar.setEnabled(true);
        BEditar.setEnabled(false);
        BCancelar.setEnabled(true);
        txtDescripcion.setEditable(true);
    }//GEN-LAST:event_BEditarActionPerformed

    private void BCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BCancelarActionPerformed
        limpiarCajaTextofam();
        obtenerUltimoIdfam();
        BNuevo.setEnabled(true);
        BGuardar.setEnabled(false);
        BEditar.setEnabled(false);
        txtDescripcion.setEditable(false);
    }//GEN-LAST:event_BCancelarActionPerformed

    private void txtDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescripcionActionPerformed
            BGuardar.requestFocus();
    }//GEN-LAST:event_txtDescripcionActionPerformed

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        llenarCombo2();
    }//GEN-LAST:event_formInternalFrameClosed
    private void actualizarBusqueda() {
        ArrayList<DescripcionC> result = EditComponentesHerramienta.ListarMedida();
        recargarTablefam(result);
    }
    public void recargarTablefam(ArrayList<DescripcionC> list) {
        Object[][] datos = new Object[list.size()][2];
        int i = 0;
        for (DescripcionC f : list)
        {
            datos[i][0] = f.getId();
            datos[i][1] = f.getDescripcion();
            i++;
        }
        Tabla.setModel(new javax.swing.table.DefaultTableModel(
                datos,
                new String[]{
                    "No.","Descripcion"
                }) {
                     @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
        
        TableColumn columna1 = Tabla.getColumn("No.");
        columna1.setPreferredWidth(0);
        TableColumn columna2 = Tabla.getColumn("Descripcion");
        columna2.setPreferredWidth(200);
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
            java.util.logging.Logger.getLogger(MedidasNew.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MedidasNew.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MedidasNew.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MedidasNew.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MedidasNew().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BCancelar;
    private javax.swing.JButton BEditar;
    private javax.swing.JButton BGuardar;
    private javax.swing.JButton BNuevo;
    private javax.swing.JTable Tabla;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtNo;
    // End of variables declaration//GEN-END:variables
}
