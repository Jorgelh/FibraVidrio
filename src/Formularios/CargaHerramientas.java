/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import BD.BDFIBRA;
import BD.BDIngresosMaterial;
import BD.EditComponentesHerramienta;
import Class.BuscarHerramientas;
import Class.DescripcionC;
import Class.IngresoMaterial;
import static Formularios.Inicio.Panel1;
import static Formularios.ingresoHerramientas.descripcion;
//import static Formularios.ingresoHerramientas.marca;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import javax.swing.table.TableColumn;

/**
 *
 * @author jluis
 */
public class CargaHerramientas extends javax.swing.JInternalFrame {

int idingreherra;
int no_marca;
int n=0;

int d;
    /**
     * Creates new form IngreMateriales
     */
    public CargaHerramientas() {
        initComponents();
        buscarHerramients();
        
        medida.requestFocus();
        llenarCombo4();
        llenarCombo3();
        obtenerIDcombo();
    }
    
     public static void llenarCombo4(){
        
        try {
            Connection con = BDFIBRA.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select decri_marca from m_marca order by decri_marca");
            while (rs.next()){
                marca.addItem((String) rs.getObject(1));
            }
        } catch (Exception e) {
        }
       marca.setSelectedItem("Sin Marca...");
    }
    
     public static void llenarCombo3(){
        
        try {
            Connection con = BDFIBRA.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select descripcion from m_descriherramienta order by descripcion");
            while (rs.next()){
                combodescri.addItem((String) rs.getObject(1));
            }
        } catch (Exception e) {
        }
    }
     
     
    public void obtenerID(){
        
        try {
            Connection con = BDFIBRA.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT NO_MARCA FROM M_MARCA WHERE DECRI_MARCA='"+marca.getSelectedItem()+"'");
            while (rs.next()) {
            no_marca = rs.getInt("NO_MARCA");     
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR CONTACTE AL ADMINISTRADOR DEL SISTEMA" + e);
        } 
    
    }
     
    
   public void obtenerIDcombo(){
        
        try {
            Connection con = BDFIBRA.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT NO_DESCRIPCION FROM M_DESCRIHERRAMIENTA WHERE DESCRIPCION='"+combodescri.getSelectedItem()+"'");
            while (rs.next()) {
            d = rs.getInt("NO_DESCRIPCION");     
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR CONTACTE AL ADMINISTRADOR DEL SISTEMA" + e);
        } 
   
        System.out.println("Formularios.CargaHerramientas.obtenerIDcombo()"+d);
    } 
    
    public void obtenerultimoid(){
    
     try {
             Connection cn = BDFIBRA.getConnection();
             Statement ps = cn.createStatement();
             ResultSet rs = ps.executeQuery("select max(ID_INGRESOHERRA) from M_INGRESOHERRAMIENTA");
             rs.next();
             n = (rs.getInt("max(ID_INGRESOHERRA)"));
             ps.close();
             rs.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR "+e);
        }
         
    
    }
            
    
    public void limpiar(){
    
        cantidadBodga.setText("");
        descripcion.setText("");
        nota.setText("");
        no.setText("");
        marca.setSelectedItem("Sin Marca...");
        no_marca = 0;
       // PO.setText("");
        idingreherra = 0;
        catalogo.setText("");
        Calendar c2 = new GregorianCalendar();
        fechain.setCalendar(c2);
        cantidad.setText("");
       
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
        jLabel5 = new javax.swing.JLabel();
        no = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        descripcion = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        catalogo = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        nota = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cantidadBodga = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        cantidad = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        fechain = new com.toedter.calendar.JDateChooser();
        jLabel11 = new javax.swing.JLabel();
        marca = new javax.swing.JComboBox<>();
        BTdescripcion1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        Herramientas = new javax.swing.JTable();
        Guardar = new javax.swing.JButton();
        Cancelar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        medida = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        combodescri = new javax.swing.JComboBox<>();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ingreso de Material");

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("No.");

        no.setEditable(false);
        no.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        no.setForeground(new java.awt.Color(255, 0, 0));
        no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Descripcion");

        descripcion.setEditable(false);
        descripcion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        descripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                descripcionActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("No. Catalogo");

        catalogo.setEditable(false);
        catalogo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        nota.setEditable(false);
        nota.setColumns(20);
        nota.setRows(5);
        jScrollPane1.setViewportView(nota);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Notas");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Cantidad");

        cantidadBodga.setEditable(false);
        cantidadBodga.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(catalogo, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(cantidadBodga, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(no, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(descripcion))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(no, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(catalogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cantidadBodga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("CARGAR HERRAMIENTAS");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos Ingreso", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Eras Bold ITC", 0, 14))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Cantidad");

        cantidad.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        cantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cantidadActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Fecha Ingreso");

        fechain.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Marca");

        marca.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        marca.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                marcaItemStateChanged(evt);
            }
        });
        marca.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                marcaFocusLost(evt);
            }
        });
        marca.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                marcaMouseClicked(evt);
            }
        });
        marca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                marcaActionPerformed(evt);
            }
        });

        BTdescripcion1.setText("+");
        BTdescripcion1.setMargin(new java.awt.Insets(2, 2, 2, 2));
        BTdescripcion1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTdescripcion1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(fechain, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(13, 13, 13))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(marca, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BTdescripcion1))
                    .addComponent(jLabel4)
                    .addComponent(jLabel11))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel11)
                .addGap(9, 9, 9)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(marca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BTdescripcion1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fechain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        Herramientas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No.", "Descripcion", "Cantidad"
            }
        ));
        Herramientas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HerramientasMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(Herramientas);

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

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Medida");

        medida.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        medida.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                medidaKeyReleased(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Descripcion");

        combodescri.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        combodescri.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combodescriItemStateChanged(evt);
            }
        });
        combodescri.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                combodescriFocusLost(evt);
            }
        });
        combodescri.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                combodescriMouseClicked(evt);
            }
        });
        combodescri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combodescriActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jLabel6))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(medida)
                            .addComponent(combodescri, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Cancelar)
                            .addComponent(Guardar))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(291, 291, 291))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(combodescri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(medida))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(Guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(Cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
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

    private void CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarActionPerformed
               
         limpiar();
         Guardar.requestFocus();


    }//GEN-LAST:event_CancelarActionPerformed
    private void descripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_descripcionActionPerformed
        Guardar.requestFocus();
    }//GEN-LAST:event_descripcionActionPerformed

    private void GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarActionPerformed
            
        
            obtenerultimoid();
            obtenerID();
            if(cantidad.getText().compareTo("")!=0 && no.getText().compareTo("")!=0 && fechain.getDate()!=null){
                
        try {
            BuscarHerramientas m = new BuscarHerramientas();
            m.setIdIngresoH(n+1);
            m.setNo(Integer.parseInt(no.getText()));
            m.setCantidad(Integer.parseInt(cantidad.getText()));
            m.setFechain(fechain.getDate());
            m.setNomarca(no_marca);
           // m.setPo(PO.getText());
            EditComponentesHerramienta.IngresoHerra(m);
            JOptionPane.showMessageDialog(null, "Ingreso Agregado...");
            limpiar();
            buscarHerramients();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR"+e);
        }
            }else{JOptionPane.showMessageDialog(null, "LLene Los Campos necesario");}

    }//GEN-LAST:event_GuardarActionPerformed

    private void noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noActionPerformed
       // PO.requestFocus();
    }//GEN-LAST:event_noActionPerformed

    private void cantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cantidadActionPerformed
        Guardar.requestFocus();
    }//GEN-LAST:event_cantidadActionPerformed

    private void HerramientasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HerramientasMouseClicked

        
        try {
               BuscarHerramientas b = EditComponentesHerramienta.buscarHerramienta(Integer.parseInt(String.valueOf(Herramientas.getModel().getValueAt(Herramientas.getSelectedRow(),0))));
               no.setText(String.valueOf(b.getNo()));
               descripcion.setText(b.getDescripcion());
               catalogo.setText(b.getCatalogo());
               cantidadBodga.setText(String.valueOf(b.getCantidad()));
               nota.setText(b.getComentario());
             //PO.requestFocus();
               Calendar c2 = new GregorianCalendar();
               fechain.setCalendar(c2);
               cantidad.requestFocus();
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_HerramientasMouseClicked

    private void marcaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_marcaItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_marcaItemStateChanged

    private void marcaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_marcaFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_marcaFocusLost

    private void marcaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_marcaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_marcaMouseClicked

    private void marcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_marcaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_marcaActionPerformed

    private void BTdescripcion1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTdescripcion1ActionPerformed

        IngresoMarca1 compo = new IngresoMarca1();
        Panel1.add(compo);
        Dimension desktopSize = Panel1.getSize();
        Dimension FrameSize = compo.getSize();
        compo.setLocation((desktopSize.width - FrameSize.width)/2 , (desktopSize.height - FrameSize.height)/2);
        compo.show();

    }//GEN-LAST:event_BTdescripcion1ActionPerformed

    private void combodescriItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combodescriItemStateChanged
       buscarHerramients();
    }//GEN-LAST:event_combodescriItemStateChanged

    private void combodescriFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_combodescriFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_combodescriFocusLost

    private void combodescriMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_combodescriMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_combodescriMouseClicked

    private void combodescriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combodescriActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combodescriActionPerformed

    private void medidaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_medidaKeyReleased
       buscarHerramients();
    }//GEN-LAST:event_medidaKeyReleased
    
    private void buscarHerramients(){
         obtenerIDcombo();
         ArrayList<BuscarHerramientas> result = EditComponentesHerramienta.BuscarHerramienta(medida.getText(),d);
         llenartabla(result);
    }
    
    public void llenartabla(ArrayList<BuscarHerramientas> list){
        Object[][] datos = new Object[list.size()][4];
        int i=0;
        for (BuscarHerramientas h :list)
        {
                  datos[i][0] = h.getNo();
                  datos[i][1] = h.getDescripcion();
                  datos[i][2] = h.getFilos();
                  datos[i][3] = h.getCantidad();
                  i++;
        }
        
        Herramientas.setModel(new javax.swing.table.DefaultTableModel(
                datos,
                new String[]{
                    "No.","Descripcion","No Filos","Cantidad"
                }) {
                     @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
        TableColumn columna1 = Herramientas.getColumn("No.");
        columna1.setPreferredWidth(0);
        TableColumn columna2 = Herramientas.getColumn("Descripcion");
        columna2.setPreferredWidth(250);
         TableColumn columna3 = Herramientas.getColumn("No Filos");
        columna3.setPreferredWidth(0);
         TableColumn columna4 = Herramientas.getColumn("Cantidad");
        columna4.setPreferredWidth(0);
        
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
            java.util.logging.Logger.getLogger(CargaHerramientas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CargaHerramientas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CargaHerramientas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CargaHerramientas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CargaHerramientas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTdescripcion1;
    private javax.swing.JButton Cancelar;
    private javax.swing.JButton Guardar;
    private javax.swing.JTable Herramientas;
    private javax.swing.JTextField cantidad;
    private javax.swing.JTextField cantidadBodga;
    private javax.swing.JTextField catalogo;
    public static javax.swing.JComboBox<String> combodescri;
    private javax.swing.JTextField descripcion;
    private com.toedter.calendar.JDateChooser fechain;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JComboBox<String> marca;
    private javax.swing.JTextField medida;
    private javax.swing.JTextField no;
    private javax.swing.JTextArea nota;
    // End of variables declaration//GEN-END:variables
}