/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InventarioHerramientas;

import BD.BDFIBRA;
//import BD.BDIngresosMaterial;
import BD.EditComponentesHerramienta;
import Class.BuscarHerramientas;
//import Class.DescripcionC;
//import Class.IngresoMaterial;
import NOUSO.MarcaNew;
import static Formularios.Inicio.Panel1;
//import static InventarioHerramientas.ingresoHerramientas.descripcion;
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
int cantidadint;
int d;
    /**
     * Creates new form IngreMateriales
     */
    public CargaHerramientas() {
        initComponents();
        buscarHerramients();
        
        medida.requestFocus();
        llenarCombo4();
         nota.setLineWrap(true);
        //obtenerIDcombo();
    }
    
    
     public static void llenarCombo4(){
        marca.removeAllItems();
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
    
    /* public static void llenarCombo3(){
        
        try {
            Connection con = BDFIBRA.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select descripcion from m_descriherramienta order by descripcion");
            while (rs.next()){
                combodescri.addItem((String) rs.getObject(1));
            }
        } catch (Exception e) {
        }
    }*/
     
     
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
     
    
  /* public void obtenerIDcombo(){
        
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
    } */
    
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
    
     public void SumaCantidades(){
    
     try {
             Connection cn = BDFIBRA.getConnection();
             Statement ps = cn.createStatement();
             ResultSet rs = ps.executeQuery("select sum(cantidad) as cantidad from M_INGRESOHERRAMIENTA where no = "+ no.getText());
             rs.next();
             cantidadint = (rs.getInt("cantidad"));
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
    
    
    
    public void buscarHerramienta(){
            
             try {
               BuscarHerramientas b = EditComponentesHerramienta.buscarHerramienta(Integer.parseInt(String.valueOf(Herramientas.getModel().getValueAt(Herramientas.getSelectedRow(),0))));
               no.setText(String.valueOf(b.getNo()));
               descripcion.setText(b.getDescripcion());
               catalogo.setText(b.getCatalogo());
               //cantidadBodga.setText(String.valueOf(b.getCantidad()));
               nota.setText(b.getComentario());
             //PO.requestFocus();
               //Calendar c2 = new GregorianCalendar();
               //fechain.setCalendar(c2);
               //cantidad.requestFocus();
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
        jLabel6 = new javax.swing.JLabel();
        notaingre = new javax.swing.JTextField();
        PROCEDENCIA = new javax.swing.JCheckBox();
        jLabel12 = new javax.swing.JLabel();
        PO = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        INVOICE = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        Herramientas = new javax.swing.JTable();
        Guardar = new javax.swing.JButton();
        Cancelar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        medida = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        INGRESOS = new javax.swing.JTable();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ingreso de Material");

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("No.");

        no.setEditable(false);
        no.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(catalogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cantidadBodga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Nota");

        notaingre.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        PROCEDENCIA.setText("PRODUCTO NACIONAL");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("P.O");

        PO.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        PO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                POActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("INVOICE");

        INVOICE.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fechain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PO)
            .addComponent(INVOICE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(notaingre)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(PROCEDENCIA))
                            .addComponent(jLabel12))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(marca, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BTdescripcion1))
                    .addComponent(jLabel4)
                    .addComponent(jLabel11)
                    .addComponent(jLabel6)
                    .addComponent(jLabel13))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(marca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BTdescripcion1))
                .addGap(12, 12, 12)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(INVOICE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fechain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(notaingre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(PROCEDENCIA)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap())
        );

        Herramientas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No.", "Descripcion", "Cantidad"
            }
        ));
        Herramientas.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                HerramientasMouseDragged(evt);
            }
        });
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
        jLabel2.setText("Descripcion ");

        medida.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        medida.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                medidaKeyReleased(evt);
            }
        });

        INGRESOS.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "PO", "INVOICE", "FECHA INGRESO", "CANTIDAD"
            }
        ));
        jScrollPane3.setViewportView(INGRESOS);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(medida, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 489, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(Guardar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Cancelar))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(22, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(505, 505, 505))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(medida, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(jLabel2))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 14, Short.MAX_VALUE))))
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
            m.setNota(notaingre.getText());
            m.setInvoice(INVOICE.getText());
            m.setPo(PO.getText());
            if (PROCEDENCIA.isSelected()) {m.setProcedencia(2);}else{m.setProcedencia(1);}
           // m.setPo(PO.getText());
            EditComponentesHerramienta.IngresoHerra(m);
            JOptionPane.showMessageDialog(null, "Ingreso Agregado...");
            //limpiar();
            buscarHerramients();
            buscarIngresos();
            SumaCantidades();
            
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

      buscarHerramienta();
      buscarIngresos();
      SumaCantidades();
      cantidadBodga.setText(Integer.toString(cantidadint));  
      
      
    }//GEN-LAST:event_HerramientasMouseClicked

    private void marcaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_marcaItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_marcaItemStateChanged

    private void marcaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_marcaFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_marcaFocusLost

    private void marcaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_marcaMouseClicked
      
    }//GEN-LAST:event_marcaMouseClicked

    private void marcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_marcaActionPerformed
        PO.requestFocus();
    }//GEN-LAST:event_marcaActionPerformed

    private void BTdescripcion1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTdescripcion1ActionPerformed

        MarcaNew compo = new MarcaNew();
        Panel1.add(compo);
        Dimension desktopSize = Panel1.getSize();
        Dimension FrameSize = compo.getSize();
        compo.setLocation((desktopSize.width - FrameSize.width)/2 , (desktopSize.height - FrameSize.height)/2);
        compo.show();

    }//GEN-LAST:event_BTdescripcion1ActionPerformed

    private void medidaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_medidaKeyReleased
       buscarHerramients();
    }//GEN-LAST:event_medidaKeyReleased

    private void HerramientasMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HerramientasMouseDragged
        // TODO add your handling code here:
    }//GEN-LAST:event_HerramientasMouseDragged

    private void POActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_POActionPerformed
        INVOICE.requestFocus();
    }//GEN-LAST:event_POActionPerformed
    
    private void buscarHerramients(){
         //obtenerIDcombo();
         ArrayList<BuscarHerramientas> result = EditComponentesHerramienta.BuscarHerramienta(medida.getText());
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
                  i++;
        }
        
        Herramientas.setModel(new javax.swing.table.DefaultTableModel(
                datos,
                new String[]{
                    "No.","Descripcion","No Filos"
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
       
    }
    
    
    
    
    private void buscarIngresos(){
         //obtenerIDcombo();
         ArrayList<BuscarHerramientas> result = EditComponentesHerramienta.BuscarHerramientaIngresada(Integer.parseInt(no.getText()));
         llenartablaIngresos(result);
    }
    
    public void llenartablaIngresos(ArrayList<BuscarHerramientas> list){
        Object[][] datos = new Object[list.size()][5];
        int i=0;
        for (BuscarHerramientas h :list)
        {
                  datos[i][0] = h.getIdIngresoH();
                  datos[i][1] = h.getPo();
                  datos[i][2] = h.getInvoice();
                  datos[i][3] = h.getFechaS();
                  datos[i][4] = h.getCantidad();
                  i++;
        }
        
        INGRESOS.setModel(new javax.swing.table.DefaultTableModel(
                datos,
                new String[]{
                    "ID","P.O","INVOICE","FECHA INGRESO","CANTIDAD"
                }) {
                     @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
        TableColumn columna1 = INGRESOS.getColumn("ID");
        columna1.setPreferredWidth(20);
        TableColumn columna2 = INGRESOS.getColumn("P.O");
        columna2.setPreferredWidth(20);
         TableColumn columna3 = INGRESOS.getColumn("INVOICE");
        columna3.setPreferredWidth(20);
         TableColumn columna4 = INGRESOS.getColumn("CANTIDAD");
        columna4.setPreferredWidth(20);
        
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
    private javax.swing.JTable INGRESOS;
    private javax.swing.JTextField INVOICE;
    private javax.swing.JTextField PO;
    private javax.swing.JCheckBox PROCEDENCIA;
    private javax.swing.JTextField cantidad;
    private javax.swing.JTextField cantidadBodga;
    private javax.swing.JTextField catalogo;
    private javax.swing.JTextField descripcion;
    private com.toedter.calendar.JDateChooser fechain;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    public static javax.swing.JComboBox<String> marca;
    private javax.swing.JTextField medida;
    private javax.swing.JTextField no;
    private javax.swing.JTextArea nota;
    private javax.swing.JTextField notaingre;
    // End of variables declaration//GEN-END:variables


}
