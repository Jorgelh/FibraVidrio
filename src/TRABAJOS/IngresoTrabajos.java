/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TRABAJOS;

import BD.BDFIBRA;
import BD.Trabajos;
import Class.CTrabajos;
import static Formularios.Inicio.Panel1;
import NOUSO.MarcaNew;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
/**
 *
 * @author jluis
 */
public class IngresoTrabajos extends javax.swing.JInternalFrame {

    int idcompo1;
    int cantidad1;
    int idcompo2;
    int cantidad2;
    int idcompo3;
    int cantidad3;
    int idcompo4;
    int cantidad4;
    int idcompo5;
    int cantidad5;
    int idcompo6;
    int cantidad6;
    int idcompo7;
    int cantidad7;
    int idcompo8;
    int cantidad8;
    int idcompo9;
    int cantidad9;
    int idcompo10;
    int cantidad10;
    int n=0;
    int cliente;
    int prec;
    DefaultTableModel temp;
    /**
     * Creates new form IngresoTrabajos
     */
    public IngresoTrabajos() {
        initComponents();
        txtpn.requestFocus();
        txtTrabajo.setEditable(false);
        fechaingre.setEnabled(false);
        ComboCliente.setEnabled(false);
        txtcantidad.setEnabled(false);
        txtrevision.setEnabled(false);
        fechaexp.setEnabled(false);
        txtnota.setEnabled(false);
        addCliente.setEnabled(false);
    }
    public void existePN() {

        try {
            Connection con = BDFIBRA.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select COUNT(PN) from PN where PN='" + txtpn.getText().toUpperCase() + "'");
            rs.next();
            int coun = rs.getInt("count(PN)");
            if (coun > 0) {
                TablaComponentes();
                obtenerID();
                txtpn.setEditable(false);
                txtTrabajo.setEditable(true);
                txtTrabajo.requestFocus();
        fechaingre.setEnabled(true);
        ComboCliente.setEnabled(true);
        txtcantidad.setEnabled(true);
        txtrevision.setEnabled(true);
        fechaexp.setEnabled(true);
        txtnota.setEnabled(true);
        addCliente.setEnabled(true);
                
            } else {
                JOptionPane.showMessageDialog(null, "El P/N no existe");
                txtpn.requestFocus();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR CONTACTE AL ADMINISTRADOR DEL SISTEMA" + e);
        }

    }
    
    
    public static void llenardescri(){
            ComboCliente.removeAllItems();
            ComboCliente.addItem("SELECCIONAR...");
            ComboCliente.setSelectedItem("SELECCIONAR...");
        try {
            Connection con = BDFIBRA.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select descripcion from CLIENTES order by descripcion");
            while (rs.next()){
            ComboCliente.addItem((String) rs.getObject(1));
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "ERROR "+e);
        }
        }
    
    public void obteneridCliente(){
    try {
            Connection con = BDFIBRA.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select id_cliente from CLIENTES where descripcion ='"+ComboCliente.getSelectedItem()+"'");
            while (rs.next()) {
            cliente = rs.getInt("id_cliente");     
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR CONTACTE AL ADMINISTRADOR DEL SISTEMA" + e);
        }
    }

    public void existeJob() {

        try {
            Connection con = BDFIBRA.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select COUNT(JOB) AS \"JOB\" from INGRESO_TRABAJO where JOB='"+txtTrabajo.getText().toUpperCase() + "'");
            rs.next();
            int coun = rs.getInt("JOB");
            if (coun == 0) {
                if(txtTrabajo.getText().compareTo("")!=0 && txtcantidad.getText().compareTo("")!=0 && txtpn.getText().compareTo("")!=0
            && txtrevision.getText().compareTo("")!=0 && fechaingre.getDate()!=null && fechaexp.getDate()!=null && !ComboCliente.getSelectedItem().equals("SELECCIONAR..."))
        { 
            try {
            CTrabajos t = new CTrabajos();
            obteneridCliente();
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yy");
            Date fec1 = fechaingre.getDate();
            Date fec2 = fechaexp.getDate();
            String fe1 = formato.format(fec1);
            String fe2 = formato.format(fec2);
             t.setJob(txtTrabajo.getText().toUpperCase());
             t.setClienteint(cliente);
             if(precap.getSelectedItem().equals("SI")){prec = 1;}else{prec = 2;}
             t.setPrecap(prec);
             t.setCantidadportrabajo(Integer.parseInt(txtcantidad.getText()));
             t.setPn(txtpn.getText().toUpperCase());
             t.setRev(txtrevision.getText().toUpperCase());
             t.setF1(fe1);
             t.setF2(fe2);
             t.setNoTabajo(txtnota.getText().toUpperCase());
             t.setIdTrabajo(n+1);
             t.setNota(txtnota.getText());
             t.setCantidad1(cantidad1*(Integer.parseInt(txtcantidad.getText())));t.setIdpn1(idcompo1);
             t.setCantidad2(cantidad2*(Integer.parseInt(txtcantidad.getText())));t.setIdpn2(idcompo2);
             t.setCantidad3(cantidad3*(Integer.parseInt(txtcantidad.getText())));t.setIdpn3(idcompo3);
             t.setCantidad4(cantidad4*(Integer.parseInt(txtcantidad.getText())));t.setIdpn4(idcompo4);
             t.setCantidad5(cantidad5*(Integer.parseInt(txtcantidad.getText())));t.setIdpn5(idcompo5);
             t.setCantidad6(cantidad6*(Integer.parseInt(txtcantidad.getText())));t.setIdpn6(idcompo6);
             t.setCantidad7(cantidad7*(Integer.parseInt(txtcantidad.getText())));t.setIdpn7(idcompo7);
             t.setCantidad8(cantidad8*(Integer.parseInt(txtcantidad.getText())));t.setIdpn8(idcompo8);
             t.setCantidad9(cantidad9*(Integer.parseInt(txtcantidad.getText())));t.setIdpn9(idcompo9);
             t.setCantidad10(cantidad10*(Integer.parseInt(txtcantidad.getText())));t.setIdpn10(idcompo10);
             Trabajos.GuardarTrabajo(t);
             JOptionPane.showMessageDialog(null, "Trabajo Ingresado");
             Limpiar();
             } catch (Exception e) {
                 System.out.println("ERROR"+e);
            }        
        }else {JOptionPane.showMessageDialog(null, "Llene Todos Los Campos");}
             
            } else {
                JOptionPane.showMessageDialog(null, "El No. JOB ya existe");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR CONTACTE AL ADMINISTRADOR DEL SISTEMA" + e);
        }

    }
    public void obtenerID()
    {
        
        try {
             Connection cn = BDFIBRA.getConnection();
             Statement ps = cn.createStatement();
             ResultSet rs = ps.executeQuery("select max(no_trabajo) as \"id\" from ingreso_trabajo");
             rs.next();
             n = (rs.getInt("id"));
             ps.close();
             rs.close();
        } catch (Exception e) {
        }
    }
    public void Limpiar()
    {
       txtTrabajo.setText("");
       txtcantidad.setText("");
       txtnota.setText("");
       txtpn.setText("");
       txtrevision.setText("");
       fechaingre.setDate(null);
       fechaexp.setDate(null);
       txtpn.setEditable(true);
       txtpn.requestFocus();
       ComboCliente.removeAllItems();
       ComboCliente.addItem("SELECCIONAR...");
       ComboCliente.setSelectedItem("SELECCIONAR...");
       precap.setSelectedItem("NO");
       //Bagregar.setEnabled(false);
                txtTrabajo.setEditable(false);
                fechaingre.setEnabled(false);
                ComboCliente.setEnabled(false);
                txtcantidad.setEnabled(false);
                txtrevision.setEnabled(false);
                fechaexp.setEnabled(false);
                txtnota.setEnabled(false);
                addCliente.setEnabled(false);
       
        try {
            temp = (DefaultTableModel) TablaPartes.getModel();
            int a = temp.getRowCount();
            for (int i = 0; i < a; i++) {
                temp.removeRow(i);
                i--;
            }
        }catch (Exception e) {

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

        jLocaleChooser1 = new com.toedter.components.JLocaleChooser();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtpn = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaPartes = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        fechaexp = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtnota = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        precap = new javax.swing.JComboBox<>();
        Bagregar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtrevision = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtTrabajo = new javax.swing.JTextField();
        fechaingre = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        txtcantidad = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        ComboCliente = new javax.swing.JComboBox<>();
        addCliente = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("P/N");

        txtpn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtpn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpnActionPerformed(evt);
            }
        });

        TablaPartes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No.", "Descripcion", "Cantidad por Pieza"
            }
        ));
        jScrollPane2.setViewportView(TablaPartes);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Fecha Vencimiento de Trabajo");

        fechaexp.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Notas");

        txtnota.setColumns(20);
        txtnota.setRows(5);
        jScrollPane1.setViewportView(txtnota);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("PRE-CAP");

        precap.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        precap.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NO", "SI" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(fechaexp, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(precap, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(fechaexp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(precap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Bagregar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Bagregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/save2.png"))); // NOI18N
        Bagregar.setText("Agregar Trabajo");
        Bagregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BagregarActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Revision");

        txtrevision.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtrevision.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtrevisionActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("No Trabajo");

        txtTrabajo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtTrabajo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTrabajoActionPerformed(evt);
            }
        });

        fechaingre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Fecha Ingreso");

        txtcantidad.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtcantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcantidadActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Cantidad");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Cliente");

        ComboCliente.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        ComboCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONAR..." }));

        addCliente.setText("+");
        addCliente.setMargin(new java.awt.Insets(2, 2, 2, 2));
        addCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtrevision, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTrabajo, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(fechaingre, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                    .addComponent(jLabel8)
                    .addComponent(ComboCliente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addCliente)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fechaingre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ComboCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addCliente))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(txtTrabajo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtrevision, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/cancelar.png"))); // NOI18N
        jButton3.setText("  Cancelar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtpn, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Bagregar)
                                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtpn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(17, 17, 17))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(Bagregar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
                .addGap(0, 8, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtpnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpnActionPerformed
       
        existePN();
        llenardescri();
        
    }//GEN-LAST:event_txtpnActionPerformed

    private void txtTrabajoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTrabajoActionPerformed
       txtcantidad.requestFocus();
    }//GEN-LAST:event_txtTrabajoActionPerformed

    private void BagregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BagregarActionPerformed
    
        existeJob();
    }//GEN-LAST:event_BagregarActionPerformed

    private void txtcantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcantidadActionPerformed
       txtrevision.requestFocus();
    }//GEN-LAST:event_txtcantidadActionPerformed

    private void txtrevisionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtrevisionActionPerformed
        Bagregar.requestFocus();
    }//GEN-LAST:event_txtrevisionActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        
        Limpiar();

    }//GEN-LAST:event_jButton3ActionPerformed

    private void addClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addClienteActionPerformed

        CLIENTES compo = new CLIENTES();
        Panel1.add(compo);
        Dimension desktopSize = Panel1.getSize();
        Dimension FrameSize = compo.getSize();
        compo.setLocation((desktopSize.width - FrameSize.width)/2 , (desktopSize.height - FrameSize.height)/2);
        compo.show();
    }//GEN-LAST:event_addClienteActionPerformed

    private void TablaComponentes() {

        ArrayList<CTrabajos> result = Trabajos.ListarTrabajos(txtpn.getText());
        cargarTabla(result);
    }

    private void cargarTabla(ArrayList<CTrabajos> list1) {

        Object[][] dato = new Object[list1.size()][3];
        int f = 0;
        for (CTrabajos a : list1) {
            dato[f][0] = a.getIdcompo();
            dato[f][1] = a.getDescripcion();
            dato[f][2] = a.getCantidadporpieza();
            f++;
        }
        TablaPartes.setModel(new javax.swing.table.DefaultTableModel(
                dato,
                new String[]{
                "No.","Descripcion", "Cantidad por Pieza"
                }) {
            @Override
            public boolean isCellEditable(int row, int colum) {
                return false;
            }
        });
         TableColumn columna1 = TablaPartes.getColumn("No.");
         columna1.setPreferredWidth(15);
         TableColumn columna2 = TablaPartes.getColumn("Descripcion");
         columna2.setPreferredWidth(350);
         TableColumn columna3 = TablaPartes.getColumn("Cantidad por Pieza");
         columna3.setPreferredWidth(15);
        if (list1.size() == 1) {
            idcompo1 = (int)dato[0][0];cantidad1=(int)dato[0][2];
            System.out.println("ID "+idcompo1+" / cantidad "+cantidad1);
        } else if (list1.size() == 2) {
            idcompo1 = (int)dato[0][0];cantidad1=(int)dato[0][2];
            idcompo2 = (int)dato[1][0];cantidad2=(int)dato[1][2];
                    System.out.println("ID "+idcompo1+" / cantidad "+cantidad1);
                    System.out.println("ID "+idcompo2+" / cantidad "+cantidad2);
        } else if (list1.size() == 3) {
            idcompo1 = (int)dato[0][0];cantidad1=(int)dato[0][2];
            idcompo2 = (int)dato[1][0];cantidad2=(int)dato[1][2];
            idcompo3 = (int)dato[2][0];cantidad3=(int)dato[2][2];
            System.out.println("ID "+idcompo1+" / cantidad "+cantidad1);
                    System.out.println("ID "+idcompo2+" / cantidad "+cantidad2);
                    System.out.println("ID "+idcompo3+" / cantidad "+cantidad3);
        } else if (list1.size() == 4) {
            idcompo1 = (int)dato[0][0];cantidad1=(int)dato[0][2];
            idcompo2 = (int)dato[1][0];cantidad2=(int)dato[1][2];
            idcompo3 = (int)dato[2][0];cantidad3=(int)dato[2][2];
            idcompo4 = (int)dato[3][0];cantidad4=(int)dato[3][2];
                    System.out.println("ID "+idcompo1+" / cantidad "+cantidad1);
                    System.out.println("ID "+idcompo2+" / cantidad "+cantidad2);
                    System.out.println("ID "+idcompo3+" / cantidad "+cantidad3);
                    System.out.println("ID "+idcompo4+" / cantidad "+cantidad4);
        } else if (list1.size() == 5) {
            idcompo1 = (int)dato[0][0];cantidad1=(int)dato[0][2];
            idcompo2 = (int)dato[1][0];cantidad2=(int)dato[1][2];
            idcompo3 = (int)dato[2][0];cantidad3=(int)dato[2][2];
            idcompo4 = (int)dato[3][0];cantidad4=(int)dato[3][2];
            idcompo5 = (int)dato[4][0];cantidad5=(int)dato[4][2];
        } else if (list1.size() == 6) {
            idcompo1 = (int)dato[0][0];cantidad1=(int)dato[0][2];
            idcompo2 = (int)dato[1][0];cantidad2=(int)dato[1][2];
            idcompo3 = (int)dato[2][0];cantidad3=(int)dato[2][2];
            idcompo4 = (int)dato[3][0];cantidad4=(int)dato[3][2];
            idcompo5 = (int)dato[4][0];cantidad5=(int)dato[4][2];
            idcompo6 = (int)dato[5][0];cantidad6=(int)dato[5][2];
        } else if (list1.size() == 7) {
            idcompo1 = (int)dato[0][0];cantidad1=(int)dato[0][2];
            idcompo2 = (int)dato[1][0];cantidad2=(int)dato[1][2];
            idcompo3 = (int)dato[2][0];cantidad3=(int)dato[2][2];
            idcompo4 = (int)dato[3][0];cantidad4=(int)dato[3][2];
            idcompo5 = (int)dato[4][0];cantidad5=(int)dato[4][2];
            idcompo6 = (int)dato[5][0];cantidad6=(int)dato[5][2];
            idcompo7 = (int)dato[6][0];cantidad7=(int)dato[6][2];
        } else if (list1.size() == 8) {
            idcompo1 = (int)dato[0][0];cantidad1=(int)dato[0][2];
            idcompo2 = (int)dato[1][0];cantidad2=(int)dato[1][2];
            idcompo5 = (int)dato[2][0];cantidad3=(int)dato[2][2];
            idcompo4 = (int)dato[3][0];cantidad4=(int)dato[3][2];
            idcompo5 = (int)dato[4][0];cantidad5=(int)dato[4][2];
            idcompo6 = (int)dato[5][0];cantidad6=(int)dato[5][2];
            idcompo7 = (int)dato[6][0];cantidad7=(int)dato[6][2];
            idcompo8 = (int)dato[7][0];cantidad8=(int)dato[7][2];
        } else if (list1.size() == 9) {
            idcompo1 = (int)dato[0][0];cantidad1=(int)dato[0][2];
            idcompo2 = (int)dato[1][0];cantidad2=(int)dato[1][2];
            idcompo3 = (int)dato[2][0];cantidad3=(int)dato[2][2];
            idcompo4 = (int)dato[3][0];cantidad4=(int)dato[3][2];
            idcompo5 = (int)dato[4][0];cantidad5=(int)dato[4][2];
            idcompo6 = (int)dato[5][0];cantidad6=(int)dato[5][2];
            idcompo7 = (int)dato[6][0];cantidad7=(int)dato[6][2];
            idcompo8 = (int)dato[7][0];cantidad8=(int)dato[7][2];
            idcompo9 = (int)dato[8][0];cantidad9=(int)dato[8][2];
         } else if (list1.size() == 10) {
            idcompo1 = (int)dato[0][0];cantidad1=(int)dato[0][2];
            idcompo2 = (int)dato[1][0];cantidad2=(int)dato[1][2];
            idcompo3 = (int)dato[2][0];cantidad3=(int)dato[2][2];
            idcompo4 = (int)dato[3][0];cantidad4=(int)dato[3][2];
            idcompo5 = (int)dato[4][0];cantidad5=(int)dato[4][2];
            idcompo6 = (int)dato[5][0];cantidad6=(int)dato[5][2];
            idcompo7 = (int)dato[6][0];cantidad7=(int)dato[6][2];
            idcompo8 = (int)dato[7][0];cantidad8=(int)dato[7][2];
            idcompo9 = (int)dato[8][0];cantidad9=(int)dato[8][2];
            idcompo10 =(int)dato[9][0];cantidad10=(int)dato[9][2];
    }
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
            java.util.logging.Logger.getLogger(IngresoTrabajos.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IngresoTrabajos.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IngresoTrabajos.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IngresoTrabajos.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IngresoTrabajos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Bagregar;
    private static javax.swing.JComboBox<String> ComboCliente;
    private javax.swing.JTable TablaPartes;
    private javax.swing.JButton addCliente;
    private com.toedter.calendar.JDateChooser fechaexp;
    private com.toedter.calendar.JDateChooser fechaingre;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private com.toedter.components.JLocaleChooser jLocaleChooser1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> precap;
    private javax.swing.JTextField txtTrabajo;
    private javax.swing.JTextField txtcantidad;
    private javax.swing.JTextArea txtnota;
    private javax.swing.JTextField txtpn;
    private javax.swing.JTextField txtrevision;
    // End of variables declaration//GEN-END:variables
}
