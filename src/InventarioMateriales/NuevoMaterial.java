/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InventarioMateriales;

import BD.BDFIBRA;
import BD.NuevoProducto;
import Class.nuevo;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.TableColumn;

/**
 *
 * @author jluis
 */
public class NuevoMaterial extends javax.swing.JInternalFrame {

        int idingre;
        int tipo;
        int estilo;
        int n=0;
        
    
    
    public NuevoMaterial() {
        initComponents();
        Lista();
        obtenerID();
        comboESTILO.setEnabled(false);
    }
    
    
    
    public void limpiar(){
    
        comboTipo.setSelectedItem("Seleccionar...");
        grosor.setText("");
        diametro.setText("");
        comboESTILO.setSelectedItem("Seleccionar...");
        comboESTILO.setEnabled(false);
        ubicacion.setText("");
        obtenerID();
        Lista();
    }

    
     public void obtenerID(){
    
     try {
             Connection cn = BDFIBRA.getConnection();
             Statement ps = cn.createStatement();
             ResultSet rs = ps.executeQuery("select max(codigo) from productosmat");
             rs.next();
             n = (rs.getInt("max(codigo)"));
             codigo.setText(String.valueOf(n+1));
             ps.close();
             rs.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR "+e);
        }
         
     }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        grosor1 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        comboTipo = new javax.swing.JComboBox();
        medida = new javax.swing.JLabel();
        diametro = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        grosor = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        guardarMat = new javax.swing.JButton();
        codigo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        comboESTILO = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        ubicacion = new javax.swing.JTextField();

        jLabel7.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel7.setText("GROSOR");

        grosor1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                grosor1ActionPerformed(evt);
            }
        });

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODIGO", "DESCRIPCION"
            }
        ));
        jScrollPane1.setViewportView(tabla);

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jLabel1.setText("NUEVO PRODUCTO");

        jLabel5.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel5.setText("TIPO DE MATERIAL");

        comboTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccionar...", "TUBO CUADRADO", "TUBO REDONDO", "TUBO RECTANGULAR", "TUBO INSOLACION", "POT ROD", "PLANCHA", "TUBO PARA BOBINA REDONDO", "TUBO PARA BOBINA CUADRADO", "TUBO PARA BOBINA RECTANGULAR", "PLANCHA DE ALUMINIO", "TUBO REDONDO DE ALUMINIO", "BARRA DE ALUMINIO", "ANGULARES DE ALUMINIO", "BARRA DE ACERO", "BARRA DE BRONCE", "PLANCHA DE ACERO", "BARRA DE TITANIUM RODS", "BARRA DE ACERO INOXIDABLE", "BARRA ROSCADA" }));
        comboTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboTipoActionPerformed(evt);
            }
        });

        medida.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        medida.setText("--");

        diametro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                diametroActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel4.setText("GROSOR");

        grosor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                grosorActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel2.setText("CODIGO");
        jLabel2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jLabel2KeyPressed(evt);
            }
        });

        guardarMat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/save2.png"))); // NOI18N
        guardarMat.setText("GUARDAR");
        guardarMat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarMatActionPerformed(evt);
            }
        });

        codigo.setEnabled(false);
        codigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codigoActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel6.setText("ESTILO");

        comboESTILO.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccionar...", "SANDBLAST BOTH SIDES NEGRO", "SANDBLAST BOTH SIDES CLARO", "NATURAL NEGRO", "NATURAL CLARO", "SANDBLAST ONE SIDE NEGRO", "SANDBLAST ONE SIDE CLARO", "60-61", "O-1", "A-2" }));
        comboESTILO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboESTILOActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel8.setText("UBICACION");

        ubicacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ubicacionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(grosor)
                    .addComponent(diametro)
                    .addComponent(comboTipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(codigo)
                    .addComponent(comboESTILO, 0, 230, Short.MAX_VALUE)
                    .addComponent(ubicacion)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(medida)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(guardarMat)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel2)
                .addGap(1, 1, 1)
                .addComponent(codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboESTILO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(medida)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(diametro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(grosor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ubicacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(guardarMat, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 455, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(220, 220, 220)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(24, Short.MAX_VALUE))
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

    private void comboTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboTipoActionPerformed
        
        if (comboTipo.getSelectedItem().toString().equalsIgnoreCase("TUBO CUADRADO")) {
                 medida.setText("DIAMETRO EXTERNO");
                 comboESTILO.setEnabled(false);
                 comboESTILO.setSelectedItem("Seleccionar...");
            } else if (comboTipo.getSelectedItem().toString().equalsIgnoreCase("TUBO REDONDO")) {
                 medida.setText("DIAMETRO EXTERNO");
                 comboESTILO.setEnabled(false);
                 comboESTILO.setSelectedItem("Seleccionar...");
            } else if (comboTipo.getSelectedItem().toString().equalsIgnoreCase("TUBO RECTANGULAR"))
            {
                 medida.setText("DIAMETRO EXTERNO");
                 comboESTILO.setEnabled(false);
                 comboESTILO.setSelectedItem("Seleccionar...");
            }
            else if (comboTipo.getSelectedItem().toString().equalsIgnoreCase("TUBO INSOLACION"))
            {
                 medida.setText("DIAMETRO EXTERNO");
                 comboESTILO.setEnabled(false);
                 comboESTILO.setSelectedItem("Seleccionar...");
            }
            else if (comboTipo.getSelectedItem().toString().equalsIgnoreCase("POT ROD"))
            {
                 medida.setText("DIAMETRO EXTERNO");
                 comboESTILO.setEnabled(false);
                 comboESTILO.setSelectedItem("Seleccionar...");
            }
            else if (comboTipo.getSelectedItem().toString().equalsIgnoreCase("PLANCHA"))
            {
                 medida.setText("MEDIDAS"); 
                 comboESTILO.setEnabled(true);
                 comboESTILO.setSelectedItem("Seleccionar...");
            }
        else if (comboTipo.getSelectedItem().toString().equalsIgnoreCase("TUBO PARA BOBINA REDONDO"))
            {
                 medida.setText("DIAMETRO EXTERNO");
                 comboESTILO.setEnabled(false);
                 comboESTILO.setSelectedItem("Seleccionar...");
            }
        else if (comboTipo.getSelectedItem().toString().equalsIgnoreCase("TUBO PARA BOBINA CUADRADO"))
            {
                 medida.setText("DIAMETRO EXTERNO");
                 comboESTILO.setEnabled(false);
                 comboESTILO.setSelectedItem("Seleccionar...");
            }else if (comboTipo.getSelectedItem().toString().equalsIgnoreCase("TUBO PARA BOBINA RECTANGULAR"))
            {
                 medida.setText("DIAMETRO EXTERNO");
                 comboESTILO.setEnabled(false);
                 comboESTILO.setSelectedItem("Seleccionar...");
            }else if (comboTipo.getSelectedItem().toString().equalsIgnoreCase("PLANCHA DE ALUMINIO"))
            {
                 medida.setText("MEDIDAS");
                 comboESTILO.setEnabled(true);
                 comboESTILO.setSelectedItem("Seleccionar...");
            }else if (comboTipo.getSelectedItem().toString().equalsIgnoreCase("TUBO REDONDO DE ALUMINIO"))
            {
                 medida.setText("DIAMETRO EXTERNO");
                 comboESTILO.setEnabled(true);
                 comboESTILO.setSelectedItem("Seleccionar...");
            }else if (comboTipo.getSelectedItem().toString().equalsIgnoreCase("BARRA DE ALUMINIO"))
            {
                 medida.setText("DIAMETRO EXTERNO");
                 comboESTILO.setEnabled(true);
                 comboESTILO.setSelectedItem("Seleccionar...");
            }else if (comboTipo.getSelectedItem().toString().equalsIgnoreCase("ANGULARES DE ALUMINIO"))
            {
                 medida.setText("DIAMETRO EXTERNO");
                 comboESTILO.setEnabled(true);
                 comboESTILO.setSelectedItem("Seleccionar...");
            }else if (comboTipo.getSelectedItem().toString().equalsIgnoreCase("BARRA DE ACERO"))
            {
                 medida.setText("DIAMETRO EXTERNO");
                 comboESTILO.setEnabled(true);
                 comboESTILO.setSelectedItem("Seleccionar...");
            }else if (comboTipo.getSelectedItem().toString().equalsIgnoreCase("BARRA DE BRONCE"))
            {
                 medida.setText("DIAMETRO EXTERNO");
                 comboESTILO.setEnabled(false);
                 comboESTILO.setSelectedItem("Seleccionar...");
            }else if (comboTipo.getSelectedItem().toString().equalsIgnoreCase("BARRA DE TITANIUM RODS"))
            {
                 medida.setText("DIAMETRO EXTERNO");
                 comboESTILO.setEnabled(false);
                 comboESTILO.setSelectedItem("Seleccionar...");
            }else if (comboTipo.getSelectedItem().toString().equalsIgnoreCase("BARRA DE ACERO INOXIDABLE"))
            {
                 medida.setText("DIAMETRO EXTERNO");
                 comboESTILO.setEnabled(false);
                 comboESTILO.setSelectedItem("Seleccionar...");
            }else if (comboTipo.getSelectedItem().toString().equalsIgnoreCase("PLANCHA DE ACERO"))
            {
                 medida.setText("MEDIDAS");
                 comboESTILO.setEnabled(false);
                 comboESTILO.setSelectedItem("Seleccionar...");
            }
        else if (comboTipo.getSelectedItem().toString().equalsIgnoreCase("BARRA ROSCADA"))
            {
                 medida.setText("DIAMETRO EXTERNO");
                 comboESTILO.setEnabled(false);
                 comboESTILO.setSelectedItem("Seleccionar...");
            }
        
        diametro.requestFocus();
        
    }//GEN-LAST:event_comboTipoActionPerformed

    private void diametroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_diametroActionPerformed
        grosor.requestFocus();
    }//GEN-LAST:event_diametroActionPerformed

    private void grosorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_grosorActionPerformed
        ubicacion.requestFocus();
    }//GEN-LAST:event_grosorActionPerformed

    private void jLabel2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLabel2KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel2KeyPressed

    private void guardarMatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarMatActionPerformed
       
        if(codigo.getText().compareTo("")!=0 && diametro.getText().compareTo("")!=0 && grosor.getText().compareTo("")!=0 && !comboTipo.getSelectedItem().toString().equalsIgnoreCase("Seleccionar...")){

            if (comboTipo.getSelectedItem().toString().equalsIgnoreCase("TUBO CUADRADO")) {
                tipo = 1;
                estilo=0;
                 medida.setText("DIAMETRO EXTERNO");
            } else if (comboTipo.getSelectedItem().toString().equalsIgnoreCase("TUBO REDONDO")) {
                tipo = 2;
                estilo=0;
                 medida.setText("DIAMETRO EXTERNO");
            } else if (comboTipo.getSelectedItem().toString().equalsIgnoreCase("TUBO RECTANGULAR"))
            {tipo = 3;
            estilo=0;
                 medida.setText("DIAMETRO EXTERNO");
            }
            else if (comboTipo.getSelectedItem().toString().equalsIgnoreCase("TUBO INSOLACION"))
            {tipo = 4;
            estilo=0;
                 medida.setText("DIAMETRO EXTERNO");
            }
            else if (comboTipo.getSelectedItem().toString().equalsIgnoreCase("POT ROD"))
            {tipo = 5;
            estilo=0;
                 medida.setText("DIAMETRO EXTERNO");
            }
            else if (comboTipo.getSelectedItem().toString().equalsIgnoreCase("PLANCHA"))
            {tipo = 6;
                 medida.setText("MEDIDAS"); 
                    comboESTILO.setEnabled(true);
                    if (comboESTILO.getSelectedItem().toString().equalsIgnoreCase("SANDBLAST BOTH SIDES NEGRO")){estilo = 1;} 
                    else if (comboESTILO.getSelectedItem().toString().equalsIgnoreCase("SANDBLAST BOTH SIDES CLARO")){estilo = 2;}
                    else if (comboESTILO.getSelectedItem().toString().equalsIgnoreCase("NATURAL NEGRO")){estilo = 3;}
                    else if (comboESTILO.getSelectedItem().toString().equalsIgnoreCase("NATURAL CLARO")){estilo = 4;}
                    else if (comboESTILO.getSelectedItem().toString().equalsIgnoreCase("SANDBLAST ONE SIDE NEGRO")){estilo = 5;}
                    else if (comboESTILO.getSelectedItem().toString().equalsIgnoreCase("SANDBLAST ONE SIDE CLARO")){estilo = 6;}
            }
            else if (comboTipo.getSelectedItem().toString().equalsIgnoreCase("TUBO PARA BOBINA REDONDO"))
            {tipo = 7;estilo=0;}
            else if (comboTipo.getSelectedItem().toString().equalsIgnoreCase("TUBO PARA BOBINA CUADRADO"))
            {tipo = 8;estilo=0;}
            else if (comboTipo.getSelectedItem().toString().equalsIgnoreCase("TUBO PARA BOBINA RECTANGULAR"))
            {tipo = 9;estilo=0;}
            else if (comboTipo.getSelectedItem().toString().equalsIgnoreCase("PLANCHA DE ALUMINIO"))
            {tipo = 10;
               comboESTILO.setEnabled(true);
                    if (comboESTILO.getSelectedItem().toString().equalsIgnoreCase("SANDBLAST BOTH SIDES NEGRO")){estilo = 1;} 
                    else if (comboESTILO.getSelectedItem().toString().equalsIgnoreCase("SANDBLAST BOTH SIDES CLARO")){estilo = 2;}
                    else if (comboESTILO.getSelectedItem().toString().equalsIgnoreCase("NATURAL NEGRO")){estilo = 3;}
                    else if (comboESTILO.getSelectedItem().toString().equalsIgnoreCase("NATURAL CLARO")){estilo = 4;}
                    else if (comboESTILO.getSelectedItem().toString().equalsIgnoreCase("SANDBLAST ONE SIDE NEGRO")){estilo = 5;}
                    else if (comboESTILO.getSelectedItem().toString().equalsIgnoreCase("SANDBLAST ONE SIDE CLARO")){estilo = 6;}
                    else if (comboESTILO.getSelectedItem().toString().equalsIgnoreCase("60-61")){estilo = 7;}
                    else if (comboESTILO.getSelectedItem().toString().equalsIgnoreCase("O-1")){estilo = 8;}
                    else if (comboESTILO.getSelectedItem().toString().equalsIgnoreCase("A-2")){estilo = 9;}
                          
            }else if (comboTipo.getSelectedItem().toString().equalsIgnoreCase("TUBO REDONDO DE ALUMINIO"))
            {tipo = 11;
                comboESTILO.setEnabled(true);
                    if (comboESTILO.getSelectedItem().toString().equalsIgnoreCase("SANDBLAST BOTH SIDES NEGRO")){estilo = 1;} 
                    else if (comboESTILO.getSelectedItem().toString().equalsIgnoreCase("SANDBLAST BOTH SIDES CLARO")){estilo = 2;}
                    else if (comboESTILO.getSelectedItem().toString().equalsIgnoreCase("NATURAL NEGRO")){estilo = 3;}
                    else if (comboESTILO.getSelectedItem().toString().equalsIgnoreCase("NATURAL CLARO")){estilo = 4;}
                    else if (comboESTILO.getSelectedItem().toString().equalsIgnoreCase("SANDBLAST ONE SIDE NEGRO")){estilo = 5;}
                    else if (comboESTILO.getSelectedItem().toString().equalsIgnoreCase("SANDBLAST ONE SIDE CLARO")){estilo = 6;}
                    else if (comboESTILO.getSelectedItem().toString().equalsIgnoreCase("60-61")){estilo = 7;}
                    else if (comboESTILO.getSelectedItem().toString().equalsIgnoreCase("O-1")){estilo = 8;}
                    else if (comboESTILO.getSelectedItem().toString().equalsIgnoreCase("A-2")){estilo = 9;}
                
            }else if (comboTipo.getSelectedItem().toString().equalsIgnoreCase("BARRA DE ALUMINIO"))
            {tipo = 12;
            
                comboESTILO.setEnabled(true);
                    if (comboESTILO.getSelectedItem().toString().equalsIgnoreCase("SANDBLAST BOTH SIDES NEGRO")){estilo = 1;} 
                    else if (comboESTILO.getSelectedItem().toString().equalsIgnoreCase("SANDBLAST BOTH SIDES CLARO")){estilo = 2;}
                    else if (comboESTILO.getSelectedItem().toString().equalsIgnoreCase("NATURAL NEGRO")){estilo = 3;}
                    else if (comboESTILO.getSelectedItem().toString().equalsIgnoreCase("NATURAL CLARO")){estilo = 4;}
                    else if (comboESTILO.getSelectedItem().toString().equalsIgnoreCase("SANDBLAST ONE SIDE NEGRO")){estilo = 5;}
                    else if (comboESTILO.getSelectedItem().toString().equalsIgnoreCase("SANDBLAST ONE SIDE CLARO")){estilo = 6;}
                    else if (comboESTILO.getSelectedItem().toString().equalsIgnoreCase("60-61")){estilo = 7;}
                    else if (comboESTILO.getSelectedItem().toString().equalsIgnoreCase("O-1")){estilo = 8;}
                    else if (comboESTILO.getSelectedItem().toString().equalsIgnoreCase("A-2")){estilo = 9;}
                    
            }else if (comboTipo.getSelectedItem().toString().equalsIgnoreCase("ANGULARES DE ALUMINIO"))
            {tipo = 13;
                    comboESTILO.setEnabled(true);
                    if (comboESTILO.getSelectedItem().toString().equalsIgnoreCase("SANDBLAST BOTH SIDES NEGRO")){estilo = 1;} 
                    else if (comboESTILO.getSelectedItem().toString().equalsIgnoreCase("SANDBLAST BOTH SIDES CLARO")){estilo = 2;}
                    else if (comboESTILO.getSelectedItem().toString().equalsIgnoreCase("NATURAL NEGRO")){estilo = 3;}
                    else if (comboESTILO.getSelectedItem().toString().equalsIgnoreCase("NATURAL CLARO")){estilo = 4;}
                    else if (comboESTILO.getSelectedItem().toString().equalsIgnoreCase("SANDBLAST ONE SIDE NEGRO")){estilo = 5;}
                    else if (comboESTILO.getSelectedItem().toString().equalsIgnoreCase("SANDBLAST ONE SIDE CLARO")){estilo = 6;}
                    else if (comboESTILO.getSelectedItem().toString().equalsIgnoreCase("60-61")){estilo = 7;}
                    else if (comboESTILO.getSelectedItem().toString().equalsIgnoreCase("O-1")){estilo = 8;}
                    else if (comboESTILO.getSelectedItem().toString().equalsIgnoreCase("A-2")){estilo = 9;}
            }else if (comboTipo.getSelectedItem().toString().equalsIgnoreCase("BARRA DE ACERO"))
            {tipo = 14;
                    comboESTILO.setEnabled(true);
                    if (comboESTILO.getSelectedItem().toString().equalsIgnoreCase("SANDBLAST BOTH SIDES NEGRO")){estilo = 1;} 
                    else if (comboESTILO.getSelectedItem().toString().equalsIgnoreCase("SANDBLAST BOTH SIDES CLARO")){estilo = 2;}
                    else if (comboESTILO.getSelectedItem().toString().equalsIgnoreCase("NATURAL NEGRO")){estilo = 3;}
                    else if (comboESTILO.getSelectedItem().toString().equalsIgnoreCase("NATURAL CLARO")){estilo = 4;}
                    else if (comboESTILO.getSelectedItem().toString().equalsIgnoreCase("SANDBLAST ONE SIDE NEGRO")){estilo = 5;}
                    else if (comboESTILO.getSelectedItem().toString().equalsIgnoreCase("SANDBLAST ONE SIDE CLARO")){estilo = 6;}
                    else if (comboESTILO.getSelectedItem().toString().equalsIgnoreCase("60-61")){estilo = 7;}
                    else if (comboESTILO.getSelectedItem().toString().equalsIgnoreCase("O-1")){estilo = 8;}
                    else if (comboESTILO.getSelectedItem().toString().equalsIgnoreCase("A-2")){estilo = 9;}
            }
            else if (comboTipo.getSelectedItem().toString().equalsIgnoreCase("BARRA DE BRONCE"))
            {tipo = 15;estilo=0;medida.setText("DIAMETRO EXTERNO");}
             else if (comboTipo.getSelectedItem().toString().equalsIgnoreCase("PLANCHA DE ACERO"))
            {tipo = 16;estilo=0;medida.setText("MEDIDAS"); }
             else if (comboTipo.getSelectedItem().toString().equalsIgnoreCase("BARRA DE TITANIUM RODS"))
            {tipo = 17;estilo=0;medida.setText("DIAMETRO EXTERNO");}
             else if (comboTipo.getSelectedItem().toString().equalsIgnoreCase("BARRA DE ACERO INOXIDABLE"))
            {tipo = 18;estilo=0;medida.setText("DIAMETRO EXTERNO");}
             else if (comboTipo.getSelectedItem().toString().equalsIgnoreCase("BARRA ROSCADA"))
            {tipo = 19;estilo=0;medida.setText("DIAMETRO EXTERNO");}
            try {
                nuevo m = new nuevo();
                m.setCodigo(Integer.parseInt(codigo.getText()));
                m.setDiametro(diametro.getText());
                m.setGrosor(grosor.getText());
                m.setTipomaterial(tipo);
                m.setEstilo(estilo);
                m.setUbicacion(ubicacion.getText());
                NuevoProducto.IngresoProducto(m);
                JOptionPane.showMessageDialog(null, "Producto Creado...");
                limpiar();
            } catch (Exception e){
                JOptionPane.showMessageDialog(null, "ERROR"+e);
            }
        }else{JOptionPane.showMessageDialog(null, "LLene Los Campos necesario");}
    }//GEN-LAST:event_guardarMatActionPerformed

    private void codigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codigoActionPerformed

        
    }//GEN-LAST:event_codigoActionPerformed

    private void comboESTILOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboESTILOActionPerformed
       diametro.requestFocus();
    }//GEN-LAST:event_comboESTILOActionPerformed

    private void grosor1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_grosor1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_grosor1ActionPerformed

    private void ubicacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubicacionActionPerformed
            guardarMat.requestFocus();
    }//GEN-LAST:event_ubicacionActionPerformed
     private void Lista() {
        ArrayList<nuevo> result = NuevoProducto.ListarProductos();
        recargarTablaPro(result);
    }
    public void recargarTablaPro(ArrayList<nuevo> list) {
        Object[][] datos = new Object[list.size()][2];
        int i = 0;
        for (nuevo f : list)
        {
            datos[i][0] = f.getCodigo();
            datos[i][1] = f.getDescripcion();
            i++;
        }
        tabla.setModel(new javax.swing.table.DefaultTableModel(
                datos,
                new String[]{
                    "CODIGO","DESCRIPCION"
                }) {
                     @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
        
        TableColumn columna1 = tabla.getColumn("CODIGO");
        columna1.setPreferredWidth(150);
        TableColumn columna2 = tabla.getColumn("DESCRIPCION");
        columna2.setPreferredWidth(350);
    }
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
            java.util.logging.Logger.getLogger(NuevoMaterial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NuevoMaterial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NuevoMaterial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NuevoMaterial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NuevoMaterial().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField codigo;
    private javax.swing.JComboBox comboESTILO;
    private javax.swing.JComboBox comboTipo;
    private javax.swing.JTextField diametro;
    private javax.swing.JTextField grosor;
    private javax.swing.JTextField grosor1;
    private javax.swing.JButton guardarMat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel medida;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField ubicacion;
    // End of variables declaration//GEN-END:variables
}
