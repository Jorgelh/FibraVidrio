/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CREARPN;

import BD.BDFIBRA;
import BD.Componente;
import BD.DBDescripcion;
import Class.DescripcionC;
import Class.PN;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
/**
 *
 * @author jluis
 */
public class EditarPNComponentes extends javax.swing.JInternalFrame {

    String accion = "";
    DefaultTableModel temp;
    int idcomponente;
    int ID_PN;

    /**
     * Creates new form Descri
     */
    public EditarPNComponentes(){
        initComponents();
        BEditar.setEnabled(false);
        BGuardar.setEnabled(false);
        BNuevo.requestFocus();
        CombDescripcion.setEnabled(false);
        txtCantidad.setEditable(false);
        txtNota.setEditable(false);
        
        
        /*try {
            Connection con = BDFIBRA.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select descripcion||' '||medida from COMPONENTES order by descripcion");
            while (rs.next()){
            CombDescripcion.addItem((String) rs.getObject(1));
            }
            CombDescripcion.addItem("SELECCIONAR...");
        } catch (Exception e){
        }*/
    }

  /*  public void obtenerUltimoID(){
    
        try {
            Connection c = BDFIBRA.getConnection();
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("select max(IDCOMPO) from COMPONENTES");
            while (rs.next()){
               int lastID = rs.getInt(1);
               txtNo.setText(String.valueOf(lastID + 1));
            }
            rs.close();
            stmt.close();
            c.close();
        } catch (SQLException error) {
            System.out.println(error);
        }
    }*/
    
    public void llenacomponentes(){
    
    try {
            Connection con = BDFIBRA.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select decode(c1.idcompo2,1,c2.descripcion||' ID '||c1.ID||' THK '|| c1.THK,\n" +
"                          2,c2.descripcion||' ID '||c1.ID||' ID '||c1.ID2||' THK '||c1.THK,\n" +
"                          3,c2.descripcion||' ID '||c1.ID||' ID '||c1.ID2||' THK '||c1.THK,\n" +
"                          4,c2.descripcion||' THK '||c1.THK,\n" +
"                          5,c2.descripcion||' THK '||c1.THK,\n" +
"                          6,c2.descripcion||' ID '||c1.ID||' LARGO '||c1.largo||' THK '||c1.THK,\n" +
"                          7,c2.descripcion||' '||decode(c1.pinesmat,1,'TC',2,'NIKEL')||' #'||c1.nume||' LARGO '||c1.largo||' APLASTADO '||c1.aplastado,\n" +
"                          8,c2.descripcion||' RADIO '||c1.radio,\n" +
"                          9,c2.descripcion||' ID '||c1.ID||' THK '||c1.THK,\n" +
"                          10,c2.descripcion||' ID '||c1.ID||' ID '||c1.ID2||' THK '||c1.THK,\n" +
"                          11,c2.descripcion||' ID '||c1.ID||' ID '||c1.ID2||' THK '||c1.THK,\n" +
"                          12,c2.descripcion||' '||decode(c1.inserto,1,'CB252-6',2,'CB440-4',3,'CBL 440-6',4,'CB 440-12',5,'CBL 632-8',6,'CBL 832-8'),\n" +
"                          13,c2.descripcion||' OD '||c1.od||' ID '||c1.id||' THK '||c1.thk,\n" +
"                          14,c2.descripcion||' OD '||c1.od||' ID '||c1.id||' THK '||c1.thk,\n" +
"                          15,c2.descripcion||' THK '||c1.thk,\n" +
"                          16,c2.descripcion||' THK '||c1.thk,\n" +
"                          17,c2.descripcion||' THK '||c1.thk,\n" +
"                          18,c2.descripcion||' THK '||c1.thk,\n" +
"                          19,c2.descripcion||' ID '||c1.ID||' ID '||c1.ID2||' THK '||c1.THK,"+ 
"                          20,c2.descripcion,"+
"                          21,c2.descripcion||' OD '||c1.OD||' OD '||c1.OD2||' THK '||c1.THK,"+
"                          22,c2.descripcion||' OD '||c1.OD||' OD '||c1.OD2||' THK '||c1.THK,"+
"                          23,c2.descripcion||' OD '||c1.OD||' THK '||c1.THK||' HT '||c1.ht,"+
"                          24,c2.descripcion||' OD '||c1.OD||' THK '||c1.THK,"+
"                          25,c2.descripcion||' ID '||c1.id||' OD '||c1.od||' THK '||c1.thk,"+
"                          26,c2.descripcion||' ID '||c1.ID||' ID '||c1.ID2||' THK '||c1.THK ) as Descripcion,c1.idcompo2 \n" +
"                          from componentes c1 inner join componentes2 c2 on c1.idcompo2 = c2.idcompo2");            
                while (rs.next()){
                CombDescripcion.addItem((String) rs.getObject(1));
            }
                CombDescripcion.addItem("SELECCIONAR...");
                CombDescripcion.setSelectedItem("SELECCIONAR...");
               
        } catch (Exception e) {
        }
    }
    
    
    public  void obteneridcompo() {
       if(!CombDescripcion.getSelectedItem().toString().equalsIgnoreCase("SELECCIONAR...")){
        try {
            Connection con = BDFIBRA.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select idcompo from componentes c1 inner join componentes2 c2 on c1.idcompo2 = c2.idcompo2 where \n" +
"                          decode(c1.idcompo2,1,c2.descripcion||' ID '||c1.ID||' THK '|| c1.THK,\n" +
"                          2,c2.descripcion||' ID '||c1.ID||' ID '||c1.ID2||' THK '||c1.THK,\n" +
"                          3,c2.descripcion||' ID '||c1.ID||' ID '||c1.ID2||' THK '||c1.THK,\n" +
"                          4,c2.descripcion||' THK '||c1.THK,\n" +
"                          5,c2.descripcion||' THK '||c1.THK,\n" +
"                          6,c2.descripcion||' ID '||c1.ID||' LARGO '||c1.largo||' THK '||c1.THK,\n" +
"                          7,c2.descripcion||' '||decode(c1.pinesmat,1,'TC',2,'NIKEL')||' #'||c1.nume||' LARGO '||c1.largo||' APLASTADO '||c1.aplastado,\n" +
"                          8,c2.descripcion||' RADIO '||c1.radio,\n" +
"                          9,c2.descripcion||' ID '||c1.ID||' THK '||c1.THK,\n" +
"                          10,c2.descripcion||' ID '||c1.ID||' ID '||c1.ID2||' THK '||c1.THK,\n" +
"                          11,c2.descripcion||' ID '||c1.ID||' ID '||c1.ID2||' THK '||c1.THK,\n" +
"                          12,c2.descripcion||' '||decode(c1.inserto,1,'CB252-6',2,'CB440-4',3,'CBL 440-6',4,'CB 440-12',5,'CBL 632-8',6,'CBL 832-8'),\n" +
"                          13,c2.descripcion||' OD '||c1.od||' ID '||c1.id||' THK '||c1.thk,\n" +
"                          14,c2.descripcion||' OD '||c1.od||' ID '||c1.id||' THK '||c1.thk,\n" +
"                          15,c2.descripcion||' THK '||c1.thk,\n" +
"                          16,c2.descripcion||' THK '||c1.thk,\n" +
"                          17,c2.descripcion||' THK '||c1.thk,\n" +
"                          18,c2.descripcion||' THK '||c1.thk,\n" +
"                          19,c2.descripcion||' ID '||c1.ID||' ID '||c1.ID2||' THK '||c1.THK,"+ 
"                          20,c2.descripcion,"+
"                          21,c2.descripcion||' OD '||c1.OD||' OD '||c1.OD2||' THK '||c1.THK,"+
"                          22,c2.descripcion||' OD '||c1.OD||' OD '||c1.OD2||' THK '||c1.THK,"+
"                          23,c2.descripcion||' OD '||c1.OD||' THK '||c1.THK||' HT '||c1.ht,"+
"                          24,c2.descripcion||' OD '||c1.OD||' THK '||c1.THK,"+
"                          25,c2.descripcion||' ID '||c1.id||' OD '||c1.od||' THK '||c1.thk,"+
"                          26,c2.descripcion||' ID '||c1.ID||' ID '||c1.ID2||' THK '||c1.THK) = '" + CombDescripcion.getSelectedItem()+"'");
            rs.next();

            idcomponente = rs.getInt("idcompo");
            txtNo.setText(String.valueOf(idcomponente));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR CONTACTE AL ADMINISTRADOR POR QUE HAY ALGO MAL"+e);
        }
    }
    }
   public void cleartablacomponentes() {

        try {
            temp = (DefaultTableModel) Tabla.getModel();
            int a = temp.getRowCount();
            for (int i = 0; i < a; i++) {
                temp.removeRow(i);
                i--;
            }
        } catch (Exception e) {

        }

    }
    public void limpiarCajaTexto(){
      // CombDescripcion.setText("");
       txtNo.setText("");
       txtCantidad.setText("");
       txtNota.setText("");
       CombDescripcion.setSelectedItem("SELECCIONAR...");
       Tabla.setEnabled(true);
    }
    
    public void activartexto(boolean b){
        
        txtNo.setEditable(!b);
        CombDescripcion.setEnabled(b);
        txtCantidad.setEditable(b);
        txtNota.setEditable(b);
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
        BNuevo = new javax.swing.JButton();
        BGuardar = new javax.swing.JButton();
        BEditar = new javax.swing.JButton();
        BCancelar = new javax.swing.JButton();
        txtCantidad = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        CombDescripcion = new javax.swing.JComboBox<>();
        txtNota = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        PN = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));

        Tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No.", "Descripcion", "Cantidad"
            }
        ));
        Tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                TablaMouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(Tabla);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("No.");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Descripcion");

        txtNo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtNo.setEnabled(false);

        BNuevo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        BNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/New.png"))); // NOI18N
        BNuevo.setText("Nuevo");
        BNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BNuevoActionPerformed(evt);
            }
        });

        BGuardar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        BGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/save2.png"))); // NOI18N
        BGuardar.setText("Guardar");
        BGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BGuardarActionPerformed(evt);
            }
        });

        BEditar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        BEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/edit2.png"))); // NOI18N
        BEditar.setText("Editar");
        BEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BEditarActionPerformed(evt);
            }
        });

        BCancelar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        BCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/cancelar.png"))); // NOI18N
        BCancelar.setText("Cancelar");
        BCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BCancelarActionPerformed(evt);
            }
        });

        txtCantidad.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Cantidad");

        CombDescripcion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        CombDescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CombDescripcionActionPerformed(evt);
            }
        });

        txtNota.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtNota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNotaActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Nota");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 41, Short.MAX_VALUE)
                        .addComponent(BNuevo)
                        .addGap(42, 42, 42)
                        .addComponent(BGuardar)
                        .addGap(55, 55, 55)
                        .addComponent(BEditar)
                        .addGap(45, 45, 45)
                        .addComponent(BCancelar)
                        .addGap(58, 58, 58))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CombDescripcion, 0, 451, Short.MAX_VALUE)
                            .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNota))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(CombDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("P/N");

        PN.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        PN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PNActionPerformed(evt);
            }
        });
        PN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                PNKeyReleased(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/New.png"))); // NOI18N
        jButton1.setText("Nueva Consulta de  P/N");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PN, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 138, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(88, 88, 88))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(306, 306, 306))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(PN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
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

    private void BNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BNuevoActionPerformed
        limpiarCajaTexto();
        activartexto(true);
        BGuardar.setEnabled(true);
        BCancelar.setEnabled(true);
        BNuevo.setEnabled(false);
        BEditar.setEnabled(false);
        accion = "Guardar";
        CombDescripcion.setEnabled(true);
        txtCantidad.setEditable(true);
        txtNota.setEditable(true);
        CombDescripcion.requestFocus();
         Tabla.clearSelection();
         Tabla.setEnabled(false);
        
    }//GEN-LAST:event_BNuevoActionPerformed

    private void BGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BGuardarActionPerformed
      
        if(accion.equalsIgnoreCase("Guardar")){
            
            if(txtCantidad.getText().compareTo("")!=0 && !CombDescripcion.getSelectedItem().toString().equalsIgnoreCase("Seleccionar...")){
                try {
                    CombDescripcion.setEnabled(true);
                    txtCantidad.setEditable(true);
                    txtNota.setEditable(true);
                    obteneridcompo();
                    DescripcionC m = new DescripcionC();
                    m.setCantidad(Integer.parseInt(txtCantidad.getText()));
                    m.setPN(PN.getText());
                    m.setIdcompo(idcomponente);
                    m.setNota(txtNota.getText());
                    Componente.guardarPNmas(m);
                    JOptionPane.showMessageDialog(null,"Registro Guardado");
                } catch (Exception e){
                    System.out.println(e);
                }
                limpiarCajaTexto();
                BusquedaComponentes();
                //BGuardar.setEnabled(false);
                BNuevo.requestFocus();
                BNuevo.setEnabled(true);
                CombDescripcion.setSelectedItem("SELECCIONAR...");
                txtNo.setText("");
                CombDescripcion.setEnabled(false);
                txtCantidad.setEditable(false);
                txtNota.setEditable(false);
            }else {
               JOptionPane.showMessageDialog(null, "Llene Todos Los Campos...");
            }
        }
        if(accion.equalsIgnoreCase("Actualizar")){
            //DescripcionC p;
            if(txtCantidad.getText().compareTo("")!=0 && !CombDescripcion.getSelectedItem().toString().equalsIgnoreCase("Seleccionar...")){
            try {
                 DescripcionC p = new DescripcionC();
                p.setIdcompo(idcomponente);
                p.setCantidad(Integer.parseInt(txtCantidad.getText()));
                p.setNota(txtNota.getText());
                p.setId_pn(ID_PN);
                DBDescripcion.actualizarPNComponente(p);
                JOptionPane.showMessageDialog(null, "Datos Actualizados");
                limpiarCajaTexto();
                BusquedaComponentes();
                BGuardar.setEnabled(false);
                BNuevo.setEnabled(true);
                CombDescripcion.setEnabled(false);
                txtCantidad.setEditable(false);
                txtNota.setEditable(false);
                BNuevo.requestFocus();
                CombDescripcion.setSelectedItem("SELECCIONAR...");
                txtNo.setText("");

            } catch (Exception e) {
                 JOptionPane.showMessageDialog(null, "Error BD:" + e.getMessage());
            }
        }
        
        }
        
        
    }//GEN-LAST:event_BGuardarActionPerformed

    private void BEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BEditarActionPerformed
        
        accion = "Actualizar";
        activartexto(true);
        BNuevo.setEnabled(false);
        BGuardar.setEnabled(true);
        BEditar.setEnabled(false);
        BCancelar.setEnabled(true);
        CombDescripcion.setEnabled(true);
        txtCantidad.setEditable(true);
        txtNota.setEditable(true);
        
        
    }//GEN-LAST:event_BEditarActionPerformed

    private void BCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BCancelarActionPerformed
        
        limpiarCajaTexto();
        BNuevo.setEnabled(true);
        BGuardar.setEnabled(false);
        BEditar.setEnabled(false);
        CombDescripcion.setEnabled(false);
        txtCantidad.setEditable(false);
        txtNota.setEditable(false);
        CombDescripcion.setSelectedItem("SELECCIONAR...");
        txtNo.setText("");
        Tabla.requestFocus();
        Tabla.setEnabled(true);
        accion= "";
        Tabla.clearSelection();
        
        
        
    }//GEN-LAST:event_BCancelarActionPerformed

    private void TablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaMouseClicked
        BEditar.setEnabled(true);
        if(accion == "Guardar"){
        BGuardar.setEnabled(true);
        BEditar.setEnabled(false);
        }else{BGuardar.setEnabled(false);}
        try {
           DescripcionC m = DBDescripcion.buscarEditCompo(Integer.parseInt(String.valueOf(Tabla.getModel().getValueAt(Tabla.getSelectedRow(),0))));
           txtNo.setText(String.valueOf(m.getIdcompo()));
           CombDescripcion.setSelectedItem(m.getDescripcion());
           txtCantidad.setText(String.valueOf(m.getCantidad()));
           txtNota.setText(m.getNota());
           ID_PN = m.getId_pn();
        } catch (Exception e) {
            System.out.println("Error de Seleccion = "+e);
        }
    }//GEN-LAST:event_TablaMouseClicked

    private void txtCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadActionPerformed
        txtNota.requestFocus();
    }//GEN-LAST:event_txtCantidadActionPerformed

    private void PNKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PNKeyReleased
    }//GEN-LAST:event_PNKeyReleased

    private void PNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PNActionPerformed
        try {
            Connection con = BDFIBRA.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select COUNT(PN) from PN where PN='"+PN.getText().toUpperCase()+"'");
            rs.next();
            int pn1 = rs.getInt("count(PN)");
            if (pn1 > 0) {
                 BusquedaComponentes();
                 PN.setEditable(false);
                 //CombDescripcion.setEnabled(true);
                 llenacomponentes();
                 limpiarCajaTexto();
            } else {
                JOptionPane.showMessageDialog(null, "EL P/N NO EXISTE...");
                PN.requestFocus();
                return;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR CONTACTE AL ADMIN POR ERRORES"+e);
        }
    }//GEN-LAST:event_PNActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
        limpiarCajaTexto();
        BNuevo.setEnabled(true);
        BGuardar.setEnabled(false);
        BEditar.setEnabled(false);
        CombDescripcion.setEnabled(false);
        txtCantidad.setEditable(false);
        txtNota.setEditable(false);
        CombDescripcion.setSelectedItem("SELECCIONAR...");
        txtNo.setText("");
        PN.setText("");
        cleartablacomponentes();
        PN.setEditable(true);
        PN.requestFocus();
                

    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtNotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNotaActionPerformed
       BGuardar.requestFocus();
    }//GEN-LAST:event_txtNotaActionPerformed

    private void CombDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CombDescripcionActionPerformed
       obteneridcompo();
       txtCantidad.requestFocus();
    }//GEN-LAST:event_CombDescripcionActionPerformed

    private void TablaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_TablaMouseEntered
    private void BusquedaComponentes(){
        ArrayList<DescripcionC> result = DBDescripcion.ListarComponentes(PN.getText());
        recargarTable(result);
    }
    public void recargarTable(ArrayList<DescripcionC> list) {
        Object[][] datos = new Object[list.size()][3];
        int i = 0;
        for (DescripcionC f : list)
        {
            datos[i][0] = f.getId_pn();
            datos[i][1] = f.getDescripcion();
            datos[i][2] = f.getCantidad();
            i++;
        }
        Tabla.setModel(new javax.swing.table.DefaultTableModel(
                datos,
                new String[]{
                    "ID P/N","DESCRIPCION","CANTIDAD"
                }) {
                     @Override
            public boolean isCellEditable(int row, int column) {
            return false;
            }
        });
        
        TableColumn columna1 = Tabla.getColumn("ID P/N");
        columna1.setPreferredWidth(0);
        TableColumn columna2 = Tabla.getColumn("DESCRIPCION");
        columna2.setPreferredWidth(200);
        TableColumn columna3 = Tabla.getColumn("CANTIDAD");
        columna3.setPreferredWidth(200);
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
            java.util.logging.Logger.getLogger(EditarPNComponentes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditarPNComponentes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditarPNComponentes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditarPNComponentes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditarPNComponentes().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BCancelar;
    private javax.swing.JButton BEditar;
    private javax.swing.JButton BGuardar;
    private javax.swing.JButton BNuevo;
    private javax.swing.JComboBox<String> CombDescripcion;
    private javax.swing.JTextField PN;
    private javax.swing.JTable Tabla;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtNo;
    private javax.swing.JTextField txtNota;
    // End of variables declaration//GEN-END:variables
}
