/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PRODUCTOS_INGRESADOS;

import BD.BDFIBRA;
import ClassProductos.IngresoConsultaProductos;
import ClassProductos.ProductosTaller;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import javax.swing.table.TableColumn;

/**
 *
 * @author jluis
 */
public class IngresoProductos extends javax.swing.JInternalFrame {
    
     int estandar;
     String fecha1;
     int id_ingreso;
     int presentacion = 0;
     int idkardex;
     int cantidaddeingreso = 0;
     int ididentificador;
     Double nuevoprecio = 0.00;
     Double precioanterior = 0.00;
     int conta;
     
     /**
     * Creates new form IngresoProductos
     */
    public IngresoProductos() {
        initComponents();
        ListarPro();
        
    } 
    
    public void limpiar(){
          
        Codigo.setText("");
        descripcionInfo.setText("");
        PN.setText("");
        JOb.setText("");
        PO.setText("");
        INVOICE.setText("");
        CANTIDAD.setText("");
        Estandar.setSelectedItem("MIL-PRF-27");
        FechaIngre.setDate(null);
        Nota.setText("");
        productos.clearSelection();
        FPOLIZA.setDate(null);
        PRECIO.setText("0.00");
    
    }
    
    public void fechaingresokardex() {
        Date date = FPOLIZA.getDate();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
        fecha1 = sdf.format(date);
    }
    
     public void fechaingreso() {
        Date date = FechaIngre.getDate();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
        fecha1 = sdf.format(date);
    }
    
    public void ultimoidingreso() {
        try {
            Connection con = BDFIBRA.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select max(id_ingreso_pro) from productos_taller_ingresos");
            while (rs.next()) {
                int lastID = rs.getInt(1);
                id_ingreso = lastID + 1;
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException error) {
            System.out.print(error + "ERROR QUE OBTIENE EL ULTIMO ID DE INGRESO");
        }
    }
    
    
    public void kardexfibra() {
        try {
            System.out.print("ID = "+idkardex+"\n");
            System.out.print("CODIGO = '"+Integer.parseInt(Codigo.getText())+"'\n");
            //System.out.print("NO DOC = "+txtNoDoc.getText()+"\n");
            System.out.print("cantidad = "+Integer.parseInt(CANTIDAD.getText())+"\n");
            System.out.print("PRECIO = "+Double.parseDouble(PRECIO.getText())+"\n");
            System.out.print("CANTIDAD saldo = "+cantidaddeingreso+"\n");
            System.out.print("NUEVO PRECIO = "+nuevoprecio+"\n");
            System.out.print("IDENTIFICADOR = "+ididentificador+"\n");
            System.out.print("FECHA = "+fecha1+"\n");
            
            Connection cn = BD.BDFIBRA.getConnection();
            Statement ps = cn.createStatement();
            ps.executeUpdate("begin kardexfibra(IDKardex=>" + idkardex + ","
                    + "NCodigo=>'" + Integer.parseInt(Codigo.getText()) + "',"
                    + "NDocumento=>'0',"
                    + "Fecha_ingreso=>'" + fecha1 + "',"
                    + "Ncantidad=>" + Integer.parseInt(CANTIDAD.getText()) + ","
                    + "Nprecio=>" + Double.parseDouble(PRECIO.getText()) + ","
                    + "CantidadSaldo=>" + cantidaddeingreso + ","
                    + "precioSaldo=>" + nuevoprecio + ","
                    + "Ididen=>" + ididentificador + "); commit; end;");
            cn.close();
            ps.close();
        } catch (Exception e) {
            System.out.print(e + " ERROR DE LOS DATOS DE PROCEDIMIENTO");
        }
    }
    
    public void ididentificador() {
        try {
            Connection con = BDFIBRA.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select max(id) from kardex");
            while (rs.next()) {
                int lastID = rs.getInt(1);
                ididentificador = lastID + 1;
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException error) {
            System.out.print(error + " ERROR QUE OBTIENE EL ULTIMO ID DE KARDEX ");
        }
    }
    
    
     public void sumaingresos() {

       
            try {
                Connection con = BDFIBRA.getConnection();
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("select sum(cantidad) as cantidad from productos_taller_ingresos where codigo_ingre = " + Codigo.getText() + " and conta = 1");
                while (rs.next()) {
                    int cantidad = rs.getInt(1);
                    cantidaddeingreso = cantidad;
                }
                rs.close();
                stmt.close();
                con.close();
            } catch (SQLException error) {
                System.out.print(error);
            }

        }
    
    public void buscarProducto(){
    
    try {
            ProductosTaller c = IngresoConsultaProductos.BuscarProducto(Integer.parseInt(String.valueOf(productos.getModel().getValueAt(productos.getSelectedRow(), 0))));
            Codigo.setText(String.valueOf(c.getCodigo_ingre()));
            descripcionInfo.setText(c.getDescripcion());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR"+e);
        }
}
    public void EstandarSelect(){
           if (Estandar.getSelectedItem().toString().equalsIgnoreCase("MIL-PRF-27"))
           {estandar = 1;}
        else if (Estandar.getSelectedItem().toString().equalsIgnoreCase("MIL-STD-981"))
           {estandar = 2;}
    }
    
    public void id_kardex() {
        try {
            Connection con = BDFIBRA.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select max(idkardex) from kardex");
            while (rs.next()) {
                int lastID = rs.getInt(1);
                idkardex = lastID + 1;
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException error) {
            System.out.print(error + "ERROR QUE OBTIENE EL ULTIMO ID DE KARDEX");
        }
    }
    
    
    public void Ultimoprecio() {

            try {
                Connection con = BDFIBRA.getConnection();
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("select valorsaldo from kardex where id =(select MAX(id) from kardex where codigo = " + Codigo.getText() + ") and codigo = " + Codigo.getText());
                while (rs.next()) {
                    Double precio = rs.getDouble(1);
                    precioanterior = precio;
                }
                rs.close();
                stmt.close();
                con.close();
            } catch (SQLException error) {
                System.out.print(error + " ERROR QUE OBTIENE EL ULTIMO PRECIO DE INGRESO");
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
        jScrollPane1 = new javax.swing.JScrollPane();
        productos = new javax.swing.JTable();
        descripcion = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        BCodigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        PN = new javax.swing.JTextField();
        JOb = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        PO = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        INVOICE = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        CANTIDAD = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        PRECIO = new javax.swing.JTextField();
        contable = new javax.swing.JCheckBox();
        jPanel7 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Nota = new javax.swing.JTextArea();
        Estandar = new javax.swing.JComboBox<>();
        FechaIngre = new com.toedter.calendar.JDateChooser();
        FPOLIZA = new com.toedter.calendar.JDateChooser();
        jLabel32 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        Codigo = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        descripcionInfo = new javax.swing.JTextField();
        Guardar = new javax.swing.JButton();

        setClosable(true);
        setTitle("INGRESO DE PRODUCTO");

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));

        productos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODIGO PRODUCTO", "DESCRIPCION"
            }
        ));
        productos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                productosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(productos);

        descripcion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        descripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                descripcionKeyReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("DESCRIPCION DE PRODUCTO");

        BCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                BCodigoKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("INGRESO DE PRODUCTOS");

        jPanel4.setBackground(new java.awt.Color(204, 204, 255));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("P/N");

        PN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PNActionPerformed(evt);
            }
        });

        JOb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JObActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("JOB");

        PO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                POActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("P.O");

        INVOICE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                INVOICEActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("INVOICE #");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("CANTIDAD");

        CANTIDAD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CANTIDADActionPerformed(evt);
            }
        });
        CANTIDAD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CANTIDADKeyTyped(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("PRECIO");

        PRECIO.setText("0.00");
        PRECIO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PRECIOActionPerformed(evt);
            }
        });

        contable.setText("CONTABLE");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(contable)
                    .addComponent(jLabel3)
                    .addComponent(PN, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JOb, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(PO, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(INVOICE, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(CANTIDAD, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PRECIO, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JOb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(INVOICE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CANTIDAD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PRECIO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(contable)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(204, 204, 255));

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel30.setText("ESTANDAR");

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel31.setText("FECHA INGRESO");

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel33.setText("NOTA");

        Nota.setColumns(20);
        Nota.setRows(5);
        jScrollPane2.setViewportView(Nota);

        Estandar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MIL-PRF-27", "MIL-STD-981" }));

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel32.setText("FECHA POLIZA");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel30)
                        .addComponent(jLabel31)
                        .addComponent(jLabel33)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                        .addComponent(Estandar, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(FechaIngre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(FPOLIZA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel32))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel30)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Estandar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel31)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(FechaIngre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel32)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(FPOLIZA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel33)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jPanel8.setBackground(new java.awt.Color(204, 204, 255));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("CODIGO");

        Codigo.setEditable(false);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("DESCRIPCION");

        descripcionInfo.setEditable(false);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(84, 84, 84)
                        .addComponent(jLabel9)
                        .addGap(0, 206, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(Codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(descripcionInfo)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(descripcionInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Guardar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/save2.png"))); // NOI18N
        Guardar.setText("GUARDAR");
        Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addComponent(Guardar)))))
                .addGap(11, 11, 11))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(362, 362, 362))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(14, Short.MAX_VALUE))
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

    private void descripcionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_descripcionKeyReleased
            ListarPro();
    }//GEN-LAST:event_descripcionKeyReleased

    private void productosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productosMouseClicked
       buscarProducto();
       PN.requestFocus();
       Calendar c2 = new GregorianCalendar();
       FechaIngre.setCalendar(c2);
    }//GEN-LAST:event_productosMouseClicked

    private void PNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PNActionPerformed
       JOb.requestFocus();
    }//GEN-LAST:event_PNActionPerformed

    private void JObActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JObActionPerformed

        PO.requestFocus();
    }//GEN-LAST:event_JObActionPerformed

    private void POActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_POActionPerformed
        INVOICE.requestFocus();
    }//GEN-LAST:event_POActionPerformed

    private void INVOICEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_INVOICEActionPerformed
        CANTIDAD.requestFocus();
    }//GEN-LAST:event_INVOICEActionPerformed

    private void CANTIDADActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CANTIDADActionPerformed
       PRECIO.requestFocus();
    }//GEN-LAST:event_CANTIDADActionPerformed

    private void GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarActionPerformed
        
        if(Codigo.getText().compareTo("")!= 0 && FechaIngre.getDate() != null && CANTIDAD.getText().compareTo("")!=0){
            EstandarSelect();
            fechaingresokardex();
            ListarPro();
            ultimoidingreso();
            Ultimoprecio();
            sumaingresos();
            id_kardex();
            ididentificador();
            nuevoprecio = ((Double.parseDouble(PRECIO.getText()) * Integer.parseInt(CANTIDAD.getText())) + (cantidaddeingreso * precioanterior)) / (Integer.parseInt(CANTIDAD.getText()) + (cantidaddeingreso));
            
            try {
            ProductosTaller m = new ProductosTaller();
            m.setCodigo_ingre(Integer.parseInt(Codigo.getText()));
            m.setPN(PN.getText());
            m.setJOB(JOb.getText());
            m.setPO(PO.getText());
            m.setFechaI(FechaIngre.getDate());
            m.setINVOICE(INVOICE.getText());
            m.setCANTIDAD(Integer.parseInt(CANTIDAD.getText()));
            m.setCANTIDADINGRESO(Integer.parseInt(CANTIDAD.getText()));
            m.setFechaPoliza(FPOLIZA.getDate());
            m.setPrecio(Double.parseDouble(PRECIO.getText()));
            m.setESTANDAR(estandar);
            m.setNOTA(Nota.getText());
            if(contable.isSelected()){m.setConta(conta= 1);}else{m.setConta(conta = 2);}
            IngresoConsultaProductos.IngresoProductos(m);
            if(contable.isSelected()){kardexfibra();}
            JOptionPane.showMessageDialog(null, "Ingreso Realizado...");
            limpiar();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR INGRESO"+e);
        }
            }else{JOptionPane.showMessageDialog(null, "LLene Los Campos necesario");}
    }//GEN-LAST:event_GuardarActionPerformed

    private void PRECIOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PRECIOActionPerformed
        Guardar.requestFocus();
    }//GEN-LAST:event_PRECIOActionPerformed

    private void CANTIDADKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CANTIDADKeyTyped
       
         char c = evt.getKeyChar();
        if ((c < '0' || c > '9') && (c < '0' || c > '9')) {
            evt.consume();
        }
        
    }//GEN-LAST:event_CANTIDADKeyTyped

    private void BCodigoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BCodigoKeyReleased
        ListarPro();
    }//GEN-LAST:event_BCodigoKeyReleased

    private void ListarPro() {

        ArrayList<ProductosTaller>result = IngresoConsultaProductos.ListarTodosProductos(descripcion.getText(),BCodigo.getText());
        cargarTabla(result);
        
    }

    private void cargarTabla(ArrayList<ProductosTaller> list1) {

        Object[][] dato = new Object[list1.size()][2];
        int f = 0;
        for (ProductosTaller a : list1) {
            dato[f][0] = a.getCodigo_ingre();
            dato[f][1] = a.getDescripcion();
            f++;
        }
        productos.setModel(new javax.swing.table.DefaultTableModel(
                dato,
                new String[]{
                "CODIGO","DESCRIPCION"
                }) {
            @Override
            public boolean isCellEditable(int row, int colum) {
                return false;
            }
        });
         TableColumn columna1 = productos.getColumn("CODIGO");
         columna1.setPreferredWidth(0);
         TableColumn columna2 = productos.getColumn("DESCRIPCION");
         columna2.setPreferredWidth(350);
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField BCodigo;
    private javax.swing.JTextField CANTIDAD;
    private javax.swing.JTextField Codigo;
    private javax.swing.JComboBox<String> Estandar;
    private com.toedter.calendar.JDateChooser FPOLIZA;
    private com.toedter.calendar.JDateChooser FechaIngre;
    private javax.swing.JButton Guardar;
    private javax.swing.JTextField INVOICE;
    private javax.swing.JTextField JOb;
    private javax.swing.JTextArea Nota;
    private javax.swing.JTextField PN;
    private javax.swing.JTextField PO;
    private javax.swing.JTextField PRECIO;
    private javax.swing.JCheckBox contable;
    private javax.swing.JTextField descripcion;
    private javax.swing.JTextField descripcionInfo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
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
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable productos;
    // End of variables declaration//GEN-END:variables
}
