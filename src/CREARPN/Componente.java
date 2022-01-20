/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CREARPN;

import BD.BDFIBRA;
import Class.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JComponent;
import javax.swing.JOptionPane;

/**
 *
 * @author jluis
 */
public class Componente extends javax.swing.JInternalFrame {
    int nodescri;
    int pin;
    int num;
    int inserto;
    int n;
    /**
     * Creates new form Componente
     */
    public Componente() {
        initComponents();
        llenardescri();
        bloqueartodo();
    }

    
    public void llenardescri(){
        try {
            Connection con = BDFIBRA.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select descripcion from COMPONENTES2 order by descripcion");
            while (rs.next()){
            CombDescripcion.addItem((String) rs.getObject(1));
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "ERROR "+e);
        }
        }
    
    public void obtenerid(){
    try {
            Connection con = BDFIBRA.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select idcompo2 from componentes2 where descripcion = '"+CombDescripcion.getSelectedItem()+"'");
            while (rs.next()) {
            nodescri = rs.getInt("idcompo2");     
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR CONTACTE AL ADMINISTRADOR DEL SISTEMA" + e);
        }
    }
    
    
    /*public void ingresocase(){
     try {
            IngresoPartes m = new IngresoPartes();
            m.setDescripcion(nodescri);
            m.setId(Integer.parseInt(ID.getText()));
            m.setId2(Integer.parseInt(ID2.getText()));
            m.setThk(Integer.parseInt(THK.getText()));
            IngresoPartes.IngresoPart(m);
            JOptionPane.showMessageDialog(null, "Registro Guardado");
         } catch (Exception e) {
            System.out.println(e);
         }
    }
    
    public void ingresocaseredondo(){
  
     try {
            IngresoPartes m = new IngresoPartes();
            m.setDescripcion(nodescri);
            m.setId(Integer.parseInt(ID.getText()));
            
            m.setId2(Integer.parseInt(ID2.getText()));
            m.setThk(Integer.parseInt(THK.getText()));
            m.setOd(Integer.parseInt(OD.getText()));
            m.setLargo(Integer.parseInt(LARGO.getText()));
            m.setAplastado(Integer.parseInt(APLASTADO.getText()));
            IngresoPartes.IngresoPart(m);
            JOptionPane.showMessageDialog(null, "Registro Guardado");
         } catch (Exception e) {
            System.out.println(e);
         }
    }*/
    
    public void bloqueartodo(){
    ID.setEnabled(false);
    ID2.setEnabled(false);
    THK.setEnabled(false);
    OD.setEnabled(false);
    OD2.setEnabled(false);
    LARGO.setEnabled(false);
    APLASTADO.setEnabled(false);
    PINES.setEnabled(false);
    NO.setEnabled(false);
    RADIO.setEnabled(false);
    INSERT.setEnabled(false);
    HT.setEnabled(false);
    }
    
    public void limpiar(){
    CombDescripcion.setSelectedItem("SELECCIONAR...");
    ID.setText("");
    ID2.setText("");
    THK.setText("");
    OD.setText("");
    OD2.setText("");
    LARGO.setText("");
    APLASTADO.setText("");
    PINES.setSelectedItem("SELECCIONAR...");
    NO.setSelectedItem("SELECCIONAR...");
    RADIO.setText("");
    INSERT.setSelectedItem("SELECCIONAR...");
    INSERT.setSelectedItem("SELECCIONAR...");
    
     }
    
    public void newid(){
     try {
             Connection cn = BDFIBRA.getConnection();
             Statement ps = cn.createStatement();
             ResultSet rs = ps.executeQuery("select max(IDCOMPO) AS ID from COMPONENTES");
             rs.next();
             n = (rs.getInt("ID"));
             n = n+1;
             ps.close();
             rs.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR "+e);
        }
    }
    public void guardar(){
    
         try {
                    newid();
                    obtenerid();
                    IngresoPartes m = new IngresoPartes();
                    m.setIdcompo(n);
                    m.setDescripcion(nodescri);
                    m.setId(ID.getText());
                    m.setId2(ID2.getText());
                    m.setThk(THK.getText());
                    m.setOd(OD.getText());
                    m.setOd2(OD2.getText());
                    m.setLargo(LARGO.getText());
                    m.setAplastado(APLASTADO.getText());
                    m.setPines(pin);
                    m.setNumero(num);
                    m.setRadio(RADIO.getText());
                    m.setInsert(inserto);
                    m.setHT(HT.getText());
                    IngresoPartes.IngresoPart(m);
                    JOptionPane.showMessageDialog(null, "Registro Guardado");
                    limpiar();
                } catch (Exception e) {
                    System.out.println(e);
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        CombDescripcion = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        ID = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        ID2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        THK = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        OD = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        OD2 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        HT = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        PINES = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        NO = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        LARGO = new javax.swing.JTextField();
        APLASTADO = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        RADIO = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        INSERT = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("INGRESO PARTES");

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("DESCRIPCION");

        CombDescripcion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONAR..." }));
        CombDescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CombDescripcionActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("ID");

        ID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("ID");

        ID2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ID2ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("THK");

        THK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                THKActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("OD");

        OD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ODActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("OD");

        OD2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OD2ActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("HT");

        HT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(THK, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(OD))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(101, 101, 101)
                                        .addComponent(jLabel7))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(ID, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel3))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel8)
                                            .addComponent(ID2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(0, 6, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(OD2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(HT, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ID2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(THK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(OD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(OD2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(HT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("PINES");

        PINES.setEditable(true);
        PINES.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONAR...", "TC", "NIKEL", "HAPTZ" }));
        PINES.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PINESActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("No.");

        NO.setEditable(true);
        NO.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONAR...", "15", "16", "17", "18", "20", "22", "24" }));
        NO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NOActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("APLASTADO");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("LARGO");

        LARGO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LARGOActionPerformed(evt);
            }
        });

        APLASTADO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                APLASTADOActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PINES, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel9)
                    .addComponent(NO, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11))
                        .addGap(46, 46, 46))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LARGO)
                            .addComponent(APLASTADO, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addContainerGap())))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PINES, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LARGO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(APLASTADO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("RADIO");

        RADIO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RADIOActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("INSERT");

        INSERT.setEditable(true);
        INSERT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONAR...", "CB 256-6", "CB 440-4", "CBL 440-6", "CB 440-12", "CBL 632-8", "CBL 832-8" }));
        INSERT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                INSERTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(RADIO)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(INSERT, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RADIO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(INSERT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1)
                            .addComponent(CombDescripcion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CombDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/save2.png"))); // NOI18N
        jButton1.setText("GUARDAR");
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
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(84, 84, 84))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CombDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CombDescripcionActionPerformed
       
        
        if (CombDescripcion.getSelectedItem().toString().equalsIgnoreCase("CASE REDONDO")){bloqueartodo(); ID.setEnabled(true);THK.setEnabled(true);} 
        else if(CombDescripcion.getSelectedItem().toString().equalsIgnoreCase("CASE CUADRADO") ||
                CombDescripcion.getSelectedItem().toString().equalsIgnoreCase("CASE CUADRADO PLASTICO") ||
                CombDescripcion.getSelectedItem().toString().equalsIgnoreCase("CASE RECTANGULAR PLASTICO") ||
                CombDescripcion.getSelectedItem().toString().equalsIgnoreCase("CASE RECTANGULAR")){bloqueartodo(); ID.setEnabled(true);ID2.setEnabled(true);THK.setEnabled(true);}
        else if(CombDescripcion.getSelectedItem().toString().equalsIgnoreCase("TAPADERA") || 
                CombDescripcion.getSelectedItem().toString().equalsIgnoreCase("HEADER") || 
                CombDescripcion.getSelectedItem().toString().equalsIgnoreCase("HEADER INPUT")||
                CombDescripcion.getSelectedItem().toString().equalsIgnoreCase("HEADER OUTPUT")||
                CombDescripcion.getSelectedItem().toString().equalsIgnoreCase("BASES CUADRADAS")|| 
                CombDescripcion.getSelectedItem().toString().equalsIgnoreCase("BASES REDONDAS")){bloqueartodo(); THK.setEnabled(true);}
        else if(CombDescripcion.getSelectedItem().toString().equalsIgnoreCase("TUBO INSULACION")){bloqueartodo();ID.setEnabled(true); THK.setEnabled(true);LARGO.setEnabled(true);} 
        else if(CombDescripcion.getSelectedItem().toString().equalsIgnoreCase("PINES")){bloqueartodo();APLASTADO.setEnabled(true); PINES.setEnabled(true); NO.setEnabled(true);LARGO.setEnabled(true); } 
        else if(CombDescripcion.getSelectedItem().toString().equalsIgnoreCase("POT ROD")){bloqueartodo();RADIO.setEnabled(true);} 
        else if(CombDescripcion.getSelectedItem().toString().equalsIgnoreCase("BOBINA REDONDA")){bloqueartodo(); ID.setEnabled(true);THK.setEnabled(true);} 
        else if(CombDescripcion.getSelectedItem().toString().equalsIgnoreCase("BOBINA CUADRADA") ||
                CombDescripcion.getSelectedItem().toString().equalsIgnoreCase("BOBINA RECTANGULAR")){bloqueartodo(); ID.setEnabled(true);ID2.setEnabled(true);THK.setEnabled(true);}
        else if(CombDescripcion.getSelectedItem().toString().equalsIgnoreCase("INSERT")){bloqueartodo(); INSERT.setEnabled(true);} 
        else if(CombDescripcion.getSelectedItem().toString().equalsIgnoreCase("WASHER NOMEX") || CombDescripcion.getSelectedItem().toString().equalsIgnoreCase("DISCO") || CombDescripcion.getSelectedItem().toString().equalsIgnoreCase("WASHER KAPTON")){bloqueartodo(); OD.setEnabled(true);ID.setEnabled(true);THK.setEnabled(true);} 
        else if(CombDescripcion.getSelectedItem().toString().equalsIgnoreCase("BASE PLATE") || CombDescripcion.getSelectedItem().toString().equalsIgnoreCase("CASE DE ALUMINIO")){bloqueartodo(); OD.setEnabled(true);OD2.setEnabled(true);THK.setEnabled(true);} 
        else if(CombDescripcion.getSelectedItem().toString().equalsIgnoreCase("BOTTOM PLATE")){bloqueartodo(); OD.setEnabled(true);THK.setEnabled(true);} 
        else if(CombDescripcion.getSelectedItem().toString().equalsIgnoreCase("TOP PLATE")){bloqueartodo(); OD.setEnabled(true);THK.setEnabled(true);HT.setEnabled(true);} 
        else if(CombDescripcion.getSelectedItem().toString().equalsIgnoreCase("SELECCIONAR...")){bloqueartodo();} 
           ((JComponent) evt.getSource()).transferFocus();
        
    }//GEN-LAST:event_CombDescripcionActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        if(CombDescripcion.getSelectedItem().toString().equalsIgnoreCase("SELECCIONAR...")){
            JOptionPane.showMessageDialog(null, "SELECCIONE UNA DESCRIPCION...");
         }else if(CombDescripcion.getSelectedItem().toString().equalsIgnoreCase("CASE REDONDO")){
                     
             if(ID.getText().compareTo("")!=0 && THK.getText().compareTo("")!=0){guardar();}else{JOptionPane.showMessageDialog(null, "LLENAR DATOS NECESARIOS...");} 
                 
         }else if(CombDescripcion.getSelectedItem().toString().equalsIgnoreCase("CASE CUADRADO")||CombDescripcion.getSelectedItem().toString().equalsIgnoreCase("CASE RECTANGULAR")||CombDescripcion.getSelectedItem().toString().equalsIgnoreCase("CASE CUADRADO PLASTICO")||CombDescripcion.getSelectedItem().toString().equalsIgnoreCase("CASE RECTANGULAR PLASTICO")){

             if(ID.getText().compareTo("")!=0 && ID2.getText().compareTo("")!=0 && THK.getText().compareTo("")!=0){guardar();}else{JOptionPane.showMessageDialog(null, "LLENAR DATOS NECESARIOS...");} 
        
         }else if(CombDescripcion.getSelectedItem().toString().equalsIgnoreCase("TAPADERA") || 
                CombDescripcion.getSelectedItem().toString().equalsIgnoreCase("HEADER") || 
                CombDescripcion.getSelectedItem().toString().equalsIgnoreCase("HEADER INPUT")||
                CombDescripcion.getSelectedItem().toString().equalsIgnoreCase("HEADER OUTPUT")||
                CombDescripcion.getSelectedItem().toString().equalsIgnoreCase("BASES CUADRADAS")|| 
                CombDescripcion.getSelectedItem().toString().equalsIgnoreCase("BASES REDONDAS")){
                if(THK.getText().compareTo("")!=0){guardar();}else{JOptionPane.showMessageDialog(null, "LLENAR DATOS NECESARIOS...");} 
        }
        
        else if(CombDescripcion.getSelectedItem().toString().equalsIgnoreCase("TUBO INSULACION")){
                if(ID.getText().compareTo("")!=0 && LARGO.getText().compareTo("")!=0 && THK.getText().compareTo("")!=0){guardar();}else{JOptionPane.showMessageDialog(null, "LLENAR DATOS NECESARIOS...");} 
        }else if(CombDescripcion.getSelectedItem().toString().equalsIgnoreCase("PINES")){
                if(APLASTADO.getText().compareTo("")!=0 && LARGO.getText().compareTo("")!=0 && !PINES.getSelectedItem().toString().equalsIgnoreCase("SELECCIONAR...") && !NO.getSelectedItem().toString().equalsIgnoreCase("SELECCIONAR...")){guardar();}else{JOptionPane.showMessageDialog(null, "LLENAR DATOS NECESARIOS...");} 
                }
         else if(CombDescripcion.getSelectedItem().toString().equalsIgnoreCase("POT ROD")){ if(RADIO.getText().compareTo("")!=0){guardar();}else{JOptionPane.showMessageDialog(null, "LLENAR DATOS NECESARIOS...");}        
        }else if(CombDescripcion.getSelectedItem().toString().equalsIgnoreCase("BOBINA REDONDA")){
              if(ID.getText().compareTo("")!=0 && THK.getText().compareTo("")!=0){guardar();}else{JOptionPane.showMessageDialog(null, "LLENAR DATOS NECESARIOS...");}  
        }
        else if(CombDescripcion.getSelectedItem().toString().equalsIgnoreCase("BOBINA CUADRADA")||
                CombDescripcion.getSelectedItem().toString().equalsIgnoreCase("BOBINA RECTANGULAR")){ if(ID.getText().compareTo("")!=0 && ID2.getText().compareTo("")!=0 && THK.getText().compareTo("")!=0){guardar();}else{JOptionPane.showMessageDialog(null, "LLENAR DATOS NECESARIOS...");} }
        else if(CombDescripcion.getSelectedItem().toString().equalsIgnoreCase("INSERT")){if(!INSERT.getSelectedItem().toString().equalsIgnoreCase("SELECCIONAR...")){guardar();}else{JOptionPane.showMessageDialog(null, "LLENAR DATOS NECESARIOS...");}} 
        else if(CombDescripcion.getSelectedItem().toString().equalsIgnoreCase("WASHER NOMEX") || 
                CombDescripcion.getSelectedItem().toString().equalsIgnoreCase("DISCO")||
                CombDescripcion.getSelectedItem().toString().equalsIgnoreCase("WASHER KAPTON")){if(OD.getText().compareTo("")!=0 && ID.getText().compareTo("")!=0 && THK.getText().compareTo("")!=0){guardar();}else{JOptionPane.showMessageDialog(null, "LLENAR DATOS NECESARIOS...");}}
        else if(CombDescripcion.getSelectedItem().toString().equalsIgnoreCase("CASE DE ALUMINIO") || 
                CombDescripcion.getSelectedItem().toString().equalsIgnoreCase("BASE PLATE")){if(OD.getText().compareTo("")!=0 && THK.getText().compareTo("")!=0){guardar();}else{JOptionPane.showMessageDialog(null, "LLENAR DATOS NECESARIOS...");}}
        else if(CombDescripcion.getSelectedItem().toString().equalsIgnoreCase("TOP PLATE")){if(OD.getText().compareTo("")!=0 && THK.getText().compareTo("")!=0 && HT.getText().compareTo("")!=0){guardar();}else{JOptionPane.showMessageDialog(null, "LLENAR DATOS NECESARIOS...");}}
        else if(CombDescripcion.getSelectedItem().toString().equalsIgnoreCase("BOTTOM PLATE")){if(OD.getText().compareTo("")!=0 && THK.getText().compareTo("")!=0){guardar();}else{JOptionPane.showMessageDialog(null, "LLENAR DATOS NECESARIOS...");}        
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void PINESActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PINESActionPerformed
        
        if (PINES.getSelectedItem().toString().equalsIgnoreCase("TC")) {
             pin = 1;
        }else if(PINES.getSelectedItem().toString().equalsIgnoreCase("NIKEL")){pin = 2;}
        else if(PINES.getSelectedItem().toString().equalsIgnoreCase("HAPTZ")){pin = 3;}
        else if(PINES.getSelectedItem().toString().equalsIgnoreCase("SELECCIONAR...")){pin = 0;}
           ((JComponent) evt.getSource()).transferFocus();
    }//GEN-LAST:event_PINESActionPerformed

    private void NOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NOActionPerformed
         if (NO.getSelectedItem().toString().equalsIgnoreCase("SELECCIONAR...")) {
             num = 0;
        }else {
             num =  Integer.parseInt((String) NO.getSelectedItem());
             
        }
           ((JComponent) evt.getSource()).transferFocus();
    }//GEN-LAST:event_NOActionPerformed

    private void INSERTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_INSERTActionPerformed

        if (INSERT.getSelectedItem().toString().equalsIgnoreCase("SELECCIONAR...")) {
             inserto = 0;
        }else if(INSERT.getSelectedItem().toString().equalsIgnoreCase("CB 256-6")){inserto = 1;}
        else if(INSERT.getSelectedItem().toString().equalsIgnoreCase("CB 440-4")){inserto = 2;}
        else if(INSERT.getSelectedItem().toString().equalsIgnoreCase("CBL 440-6")){inserto = 3;}
        else if(INSERT.getSelectedItem().toString().equalsIgnoreCase("CB 440-12")){inserto = 4;}
        else if(INSERT.getSelectedItem().toString().equalsIgnoreCase("CBL 632-8")){inserto = 5;}
        else if(INSERT.getSelectedItem().toString().equalsIgnoreCase("CBL 832-8")){inserto = 6;}
           ((JComponent) evt.getSource()).transferFocus();
    }//GEN-LAST:event_INSERTActionPerformed

    private void IDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDActionPerformed
         ((JComponent) evt.getSource()).transferFocus();
    }//GEN-LAST:event_IDActionPerformed

    private void ID2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ID2ActionPerformed
           ((JComponent) evt.getSource()).transferFocus();
    }//GEN-LAST:event_ID2ActionPerformed

    private void THKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_THKActionPerformed
          ((JComponent) evt.getSource()).transferFocus();
    }//GEN-LAST:event_THKActionPerformed

    private void ODActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ODActionPerformed
           ((JComponent) evt.getSource()).transferFocus();
    }//GEN-LAST:event_ODActionPerformed

    private void LARGOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LARGOActionPerformed
          ((JComponent) evt.getSource()).transferFocus();
    }//GEN-LAST:event_LARGOActionPerformed

    private void RADIOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RADIOActionPerformed
          ((JComponent) evt.getSource()).transferFocus();
    }//GEN-LAST:event_RADIOActionPerformed

    private void APLASTADOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_APLASTADOActionPerformed
      ((JComponent) evt.getSource()).transferFocus();
    }//GEN-LAST:event_APLASTADOActionPerformed

    private void OD2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OD2ActionPerformed
       ((JComponent) evt.getSource()).transferFocus();
    }//GEN-LAST:event_OD2ActionPerformed

    private void HTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HTActionPerformed
       ((JComponent) evt.getSource()).transferFocus();
    }//GEN-LAST:event_HTActionPerformed

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
            java.util.logging.Logger.getLogger(Componente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Componente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Componente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Componente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Componente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField APLASTADO;
    private javax.swing.JComboBox<String> CombDescripcion;
    private javax.swing.JTextField HT;
    private javax.swing.JTextField ID;
    private javax.swing.JTextField ID2;
    private javax.swing.JComboBox<String> INSERT;
    private javax.swing.JTextField LARGO;
    private javax.swing.JComboBox<String> NO;
    private javax.swing.JTextField OD;
    private javax.swing.JTextField OD2;
    private javax.swing.JComboBox<String> PINES;
    private javax.swing.JTextField RADIO;
    private javax.swing.JTextField THK;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
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
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    // End of variables declaration//GEN-END:variables
}
