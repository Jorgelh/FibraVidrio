/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InventarioHerramientas;

import BD.BDFIBRA;
import BD.BDIngresosMaterial;
import BD.BDTaller;
import Class.IngresoMaterial;
import Class.componentes;
import NOUSO.MDescripcionNew;
import NOUSO.MaterialaNew;
import NOUSO.MedidasNew;
import static Formularios.Inicio.Panel1;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.Clock;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import org.omg.CORBA.MARSHAL;

/**
 *
 * @author jluis
 */
public class ingresoHerramientas extends javax.swing.JInternalFrame {

    
int no_material;
int no_medida;
int no_descrip;
int no_marca;
int n=0;
    /**
     * Creates new form IngreMateriales
     */
    public ingresoHerramientas() {
        initComponents();
        Calendar c2 = new GregorianCalendar();
        fechaIngreso.setCalendar(c2);
        llenarCombo1();
        llenarCombo2();
        llenarCombo3();
      //  llenarCombo4();
        
        

    }  
    
    public static void llenarCombo1(){
        material.removeAllItems();   
        material.addItem("Seleccionar...");
       try {
            Connection con = BDFIBRA.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select m_tipo from m_material order by m_tipo");
            while (rs.next()){
                material.addItem((String) rs.getObject(1));
            }
        material.setSelectedItem("Seleccionar...");    
        } catch (Exception e) {
        }
    }
    
    public static void llenarCombo2(){
        medida.removeAllItems();   
        medida.addItem("Seleccionar...");
        try {
            Connection con = BDFIBRA.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select m_medida from m_medidas order by m_medida");
            while (rs.next()){
                medida.addItem((String) rs.getObject(1));
            }
        medida.setSelectedItem("Seleccionar...");
        } catch (Exception e) {
            
        }
    }
    public static void llenarCombo3(){
        
        descripcion.removeAllItems();
        descripcion.addItem("Seleccionar...");
        try {
            Connection con = BDFIBRA.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select descripcion from m_descriherramienta order by descripcion");
            while (rs.next()){
                descripcion.addItem((String) rs.getObject(1));
            }
            descripcion.setSelectedItem("Seleccionar...");
        } catch (Exception e) {
        }
    }

//     public static void llenarCombo4(){
//        
//        try {
//            Connection con = BDFIBRA.getConnection();
//            Statement st = con.createStatement();
//            ResultSet rs = st.executeQuery("select decri_marca from m_marca order by decri_marca");
//            while (rs.next()){
//                marca.addItem((String) rs.getObject(1));
//            }
//        } catch (Exception e) {
//        }
//       marca.setSelectedItem("Sin Marca...");
//    }
//      
    
    
    
    
    public void obtenerID(){
      try {
            Connection con = BDFIBRA.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select NO_TIPO from m_material where M_TIPO = '"+material.getSelectedItem()+"'");
            while (rs.next()) {
            no_material = rs.getInt("NO_TIPO");     
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR CONTACTE AL ADMINISTRADOR DEL SISTEMA" + e);
        }
      
      try {
            Connection con = BDFIBRA.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT NO_MEDIDA FROM M_MEDIDAS WHERE M_MEDIDA = '"+medida.getSelectedItem()+"'");
            while (rs.next()) {
            no_medida = rs.getInt("NO_MEDIDA");     
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR CONTACTE AL ADMINISTRADOR DEL SISTEMA" + e);
        }
      
      try {
            Connection con = BDFIBRA.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT NO_DESCRIPCION FROM M_DESCRIHERRAMIENTA WHERE DESCRIPCION=  '"+descripcion.getSelectedItem()+"'");
            while (rs.next()) {
            no_descrip = rs.getInt("NO_DESCRIPCION");     
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR CONTACTE AL ADMINISTRADOR DEL SISTEMA" + e);
        }
      
//       try {
//            Connection con = BDFIBRA.getConnection();
//            Statement stmt = con.createStatement();
//            ResultSet rs = stmt.executeQuery("SELECT NO_MARCA FROM M_MARCA WHERE DECRI_MARCA='"+marca.getSelectedItem()+"'");
//            while (rs.next()) {
//            no_marca = rs.getInt("NO_MARCA");     
//            }
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "ERROR CONTACTE AL ADMINISTRADOR DEL SISTEMA" + e);
//        }
      
      
      
      
      
      
    }
    public void obtenerultimoid(){
    
     try {
             Connection cn = BDFIBRA.getConnection();
             Statement ps = cn.createStatement();
             ResultSet rs = ps.executeQuery("select max(NO) from M_DESCRIPCION");
             rs.next();
             n = (rs.getInt("max(NO)"));
             ps.close();
             rs.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR "+e);
        }
    }
            
    
    public void limpiar(){
    
        material.setSelectedItem("Seleccionar...");
        medida.setSelectedItem("Seleccionar...");
        descripcion.setSelectedItem("Seleccionar...");
        //marca.setSelectedItem("Sin Marca...");
        fechaIngreso.setDate(null);
        //marca.setSelectedItem("");
        filos.setSelectedItem("");
      //  cantidad.setText("");
        nota.setText("");
        no_descrip = 0;
        no_material = 0;
        no_medida = 0;
        Calendar c2 = new GregorianCalendar();
        fechaIngreso.setCalendar(c2);
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
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        material = new javax.swing.JComboBox<>();
        BTmaterial = new javax.swing.JButton();
        medida = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        BTmedida = new javax.swing.JButton();
        filos = new javax.swing.JComboBox<>();
        descripcion = new javax.swing.JComboBox<>();
        BTdescripcion = new javax.swing.JButton();
        fechaIngreso = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        nota = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        Guardar = new javax.swing.JButton();
        Cancelar = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ingreso de Herramientas");

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));
        jPanel1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPanel1FocusGained(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Tipo de Material");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Descripcion");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Filos");

        material.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        material.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar..." }));
        material.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                materialMouseClicked(evt);
            }
        });
        material.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                materialActionPerformed(evt);
            }
        });

        BTmaterial.setText("+");
        BTmaterial.setMargin(new java.awt.Insets(2, 2, 2, 2));
        BTmaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTmaterialActionPerformed(evt);
            }
        });

        medida.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        medida.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar..." }));
        medida.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                medidaMouseClicked(evt);
            }
        });
        medida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                medidaActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Medida");

        BTmedida.setText("+");
        BTmedida.setMargin(new java.awt.Insets(2, 2, 2, 2));
        BTmedida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTmedidaActionPerformed(evt);
            }
        });

        filos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "2", "3", "4", "6", "8" }));
        filos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                filosItemStateChanged(evt);
            }
        });
        filos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filosActionPerformed(evt);
            }
        });

        descripcion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        descripcion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar..." }));
        descripcion.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                descripcionItemStateChanged(evt);
            }
        });
        descripcion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                descripcionFocusLost(evt);
            }
        });
        descripcion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                descripcionMouseClicked(evt);
            }
        });
        descripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                descripcionActionPerformed(evt);
            }
        });

        BTdescripcion.setText("+");
        BTdescripcion.setMargin(new java.awt.Insets(2, 2, 2, 2));
        BTdescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTdescripcionActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Fecha Ingreso");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Notas");

        nota.setColumns(20);
        nota.setRows(5);
        jScrollPane1.setViewportView(nota);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(material, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BTmaterial))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(medida, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BTmedida))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BTdescripcion))
                    .addComponent(fechaIngreso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel10)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(filos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel4)
                            .addComponent(jLabel7)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(material, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BTmaterial))
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(medida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BTmedida))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BTdescripcion))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(filos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fechaIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("CREAR  HERRAMIENTAS");

        Guardar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/save2.png"))); // NOI18N
        Guardar.setText("Guardar");
        Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarActionPerformed(evt);
            }
        });

        Cancelar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/cancelar.png"))); // NOI18N
        Cancelar.setText("Cancelar");
        Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(Guardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Cancelar)
                .addGap(53, 53, 53))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel1)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void materialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_materialActionPerformed
    }//GEN-LAST:event_materialActionPerformed
    private void CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarActionPerformed
               
         limpiar();
         Guardar.requestFocus();


    }//GEN-LAST:event_CancelarActionPerformed

    private void GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarActionPerformed
            
        
            obtenerultimoid();
            obtenerID();
            if(fechaIngreso.getDate() != null && !material.getSelectedItem().toString().equalsIgnoreCase("Seleccionar...") && !medida.getSelectedItem().toString().equalsIgnoreCase("Seleccionar...") && !descripcion.getSelectedItem().toString().equalsIgnoreCase("Seleccionar...")){
        try {
            componentes m = new componentes();
            m.setNo(n+1);
            m.setTipoMaterial(no_material);
            m.setMedida(no_medida);
            m.setDescri(no_descrip);
            m.setFecha(fechaIngreso.getDate());
            m.setMarca(no_marca);
           // m.setCantidad(Integer.parseInt(cantidad.getText()));
            m.setFilos((String)filos.getSelectedItem());
            m.setComentantario(nota.getText());
            m.setPo(null);
            m.setCodigoCatalogo(null);
            BDTaller.guardarIngresoHerramienta(m);
            JOptionPane.showMessageDialog(null, "Ingreso Agregado...");
            limpiar();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR"+e);
        }
            }else{JOptionPane.showMessageDialog(null, "LLene Los Campos necesario");}

    }//GEN-LAST:event_GuardarActionPerformed

    private void BTmaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTmaterialActionPerformed

        MaterialaNew compo = new MaterialaNew();
        Panel1.add(compo);
        Dimension desktopSize = Panel1.getSize();
        Dimension FrameSize = compo.getSize();
        compo.setLocation((desktopSize.width - FrameSize.width)/2 , (desktopSize.height - FrameSize.height)/2);
        compo.show();
               
    }//GEN-LAST:event_BTmaterialActionPerformed

    private void medidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_medidaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_medidaActionPerformed

    private void BTmedidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTmedidaActionPerformed

        MedidasNew compo = new MedidasNew();
        Panel1.add(compo);
        Dimension desktopSize = Panel1.getSize();
        Dimension FrameSize = compo.getSize();
        compo.setLocation((desktopSize.width - FrameSize.width)/2 , (desktopSize.height - FrameSize.height)/2);
        compo.show();

    }//GEN-LAST:event_BTmedidaActionPerformed

    private void filosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_filosActionPerformed

    private void BTdescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTdescripcionActionPerformed
        
        MDescripcionNew compo = new MDescripcionNew();
        Panel1.add(compo);
        Dimension desktopSize = Panel1.getSize();
        Dimension FrameSize = compo.getSize();
        compo.setLocation((desktopSize.width - FrameSize.width)/2 , (desktopSize.height - FrameSize.height)/2);
        compo.show();
        
    }//GEN-LAST:event_BTdescripcionActionPerformed

    private void jPanel1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPanel1FocusGained

       
        
    }//GEN-LAST:event_jPanel1FocusGained

    private void materialMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_materialMouseClicked
         
      


    }//GEN-LAST:event_materialMouseClicked

    private void medidaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_medidaMouseClicked
                 
    

    }//GEN-LAST:event_medidaMouseClicked

    private void filosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_filosItemStateChanged
    //  marca.requestFocus();
    }//GEN-LAST:event_filosItemStateChanged

    private void descripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_descripcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_descripcionActionPerformed

    private void descripcionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_descripcionMouseClicked

    }//GEN-LAST:event_descripcionMouseClicked

    private void descripcionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_descripcionFocusLost

    }//GEN-LAST:event_descripcionFocusLost

    private void descripcionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_descripcionItemStateChanged
     //   marca.requestFocus();
    }//GEN-LAST:event_descripcionItemStateChanged

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
            java.util.logging.Logger.getLogger(ingresoHerramientas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ingresoHerramientas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ingresoHerramientas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ingresoHerramientas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ingresoHerramientas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTdescripcion;
    private javax.swing.JButton BTmaterial;
    private javax.swing.JButton BTmedida;
    private javax.swing.JButton Cancelar;
    private javax.swing.JButton Guardar;
    public static javax.swing.JComboBox<String> descripcion;
    private com.toedter.calendar.JDateChooser fechaIngreso;
    private javax.swing.JComboBox<String> filos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JComboBox<String> material;
    public static javax.swing.JComboBox<String> medida;
    private javax.swing.JTextArea nota;
    // End of variables declaration//GEN-END:variables
}
