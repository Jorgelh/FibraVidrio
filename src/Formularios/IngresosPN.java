/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import BD.BDFIBRA;
import BD.Componente;
import Class.PN;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.naming.spi.DirStateFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author jluis
 */
public class IngresosPN extends javax.swing.JInternalFrame {
    int Enviacodigo;
    int comb1;
    int comb2;
    int comb3;
    int comb4;
    int comb5;
    int comb6;
    int comb7;
    int comb8;
    int comb9;
    int comb10;
    /**
     * Creates new form Ingresos
     */
    public IngresosPN() {
        initComponents();
        habilitar(true);
        bGuardar.setEnabled(false);
        pn.requestFocus();
        try {
            Connection con = BDFIBRA.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select descripcion||' '||medida from COMPONENTES order by descripcion");
            while (rs.next()){
                ComboBox1.addItem((String) rs.getObject(1));
                ComboBox2.addItem((String) rs.getObject(1));
                ComboBox3.addItem((String) rs.getObject(1));
                ComboBox4.addItem((String) rs.getObject(1));
                ComboBox5.addItem((String) rs.getObject(1));
                ComboBox6.addItem((String) rs.getObject(1));
                ComboBox7.addItem((String) rs.getObject(1));
                ComboBox8.addItem((String) rs.getObject(1)); 
                ComboBox9.addItem((String) rs.getObject(1));
                ComboBox10.addItem((String) rs.getObject(1));
            }
     
        } catch (Exception e) {
        }
    }
    public void idcompo1() {

        try {
            Connection con = BDFIBRA.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select idcompo from componentes where descripcion||' '||medida ='"+ComboBox1.getSelectedItem()+"'");
            while (rs.next()) {
            comb1 = rs.getInt("idcompo");       
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR CONTACTE AL ADMINISTRADOR DEL SISTEMA" + e);
        }
    }

    public void idcompo2() {

        try {
            
            Connection con = BDFIBRA.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select idcompo from componentes where descripcion||' '||medida ='"+ComboBox2.getSelectedItem()+"'");
            while (rs.next()) {
            comb2 = rs.getInt("idcompo");     
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR CONTACTE AL ADMINISTRADOR DEL SISTEMA" + e);
        }
    }

    public void idcompo3() {

        try {
            Connection con = BDFIBRA.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select idcompo from componentes where descripcion||' '||medida ='"+ComboBox3.getSelectedItem()+"'");
            while (rs.next()) {
            comb3 = rs.getInt("idcompo");     
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR CONTACTE AL ADMINISTRADOR DEL SISTEMA" + e);
        }
    }

    public void idcompo4() {

        try {
            Connection con = BDFIBRA.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select idcompo from componentes where descripcion||' '||medida ='"+ComboBox4.getSelectedItem()+"'");
            while (rs.next()) {
            comb4 = rs.getInt("idcompo");     
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR CONTACTE AL ADMINISTRADOR DEL SISTEMA" + e);
        }
    }

    public void idcompo5() {

        try {
            Connection con = BDFIBRA.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select idcompo from componentes where descripcion||' '||medida ='"+ComboBox5.getSelectedItem()+"'");
            while (rs.next()) {
            comb5 = rs.getInt("idcompo");     
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR CONTACTE AL ADMINISTRADOR DEL SISTEMA" + e);
        }
    }

    public void idcompo6() {

        try {
            Connection con = BDFIBRA.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select idcompo from componentes where descripcion||' '||medida ='"+ComboBox6.getSelectedItem()+"'");
            while (rs.next()) {
            comb6 = rs.getInt("idcompo");     
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR CONTACTE AL ADMINISTRADOR DEL SISTEMA" + e);
        }
    }

    public void idcompo7() {

        try {
            Connection con = BDFIBRA.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select idcompo from componentes where descripcion||' '||medida ='"+ComboBox7.getSelectedItem()+"'");
            while (rs.next()) {
            comb7 = rs.getInt("idcompo");     
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR CONTACTE AL ADMINISTRADOR DEL SISTEMA" + e);
        }
    }

    public void idcompo8() {

        try {
            Connection con = BDFIBRA.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select idcompo from componentes where descripcion||' '||medida='"+ComboBox8.getSelectedItem()+"'");
            while (rs.next()) {
            comb8 = rs.getInt("idcompo");     
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR CONTACTE AL ADMINISTRADOR DEL SISTEMA" + e);
        }
    }

    public void idcompo9() {

        try {
            Connection con = BDFIBRA.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select idcompo from componentes where descripcion||' '||medida='"+ComboBox9.getSelectedItem()+"'");
            while (rs.next()) {
            comb9 = rs.getInt("idcompo");     
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR CONTACTE AL ADMINISTRADOR DEL SISTEMA" + e);
        }
    }

    public void idcompo10() {

        try {
            Connection con = BDFIBRA.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select idcompo from componentes where descripcion||' '||medida ='"+ComboBox10.getSelectedItem()+"'");
            while (rs.next()) {
            comb10 = rs.getInt("idcompo");     
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR CONTACTE AL ADMINISTRADOR DEL SISTEMA" + e);
        }
    }
    
     public void habilitar(boolean b){
     ComboBox1.setEnabled(!b);
     ComboBox2.setEnabled(!b);
     ComboBox3.setEnabled(!b);
     ComboBox4.setEnabled(!b);
     ComboBox5.setEnabled(!b);
     ComboBox6.setEnabled(!b);
     ComboBox7.setEnabled(!b);
     ComboBox8.setEnabled(!b);
     ComboBox9.setEnabled(!b);
     ComboBox10.setEnabled(!b);
     cantidad1.setEnabled(!b);
     cantidad2.setEnabled(!b);
     cantidad3.setEnabled(!b);
     cantidad4.setEnabled(!b);
     cantidad5.setEnabled(!b);
     cantidad6.setEnabled(!b);
     cantidad7.setEnabled(!b);
     cantidad8.setEnabled(!b);
     cantidad9.setEnabled(!b);
     cantidad10.setEnabled(!b);
     }

   
     
    public void limpiar(){
     
        ComboBox1.setSelectedItem("Seleccionar...");
        ComboBox2.setSelectedItem("Seleccionar...");
        ComboBox3.setSelectedItem("Seleccionar...");
        ComboBox4.setSelectedItem("Seleccionar...");
        ComboBox5.setSelectedItem("Seleccionar...");
        ComboBox6.setSelectedItem("Seleccionar...");
        ComboBox7.setSelectedItem("Seleccionar...");
        ComboBox8.setSelectedItem("Seleccionar...");
        ComboBox9.setSelectedItem("Seleccionar...");
        ComboBox10.setSelectedItem("Seleccionar...");
        cantidad1.setText("");
        cantidad2.setText("");
        cantidad3.setText("");
        cantidad4.setText("");
        cantidad5.setText("");
        cantidad6.setText("");
        cantidad7.setText("");
        cantidad8.setText("");
        cantidad9.setText("");
        cantidad10.setText("");
        pn.setText("");
        nota.setText("");
    } 
    
    public void existePN(){
       
        try {
            Connection con = BDFIBRA.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select COUNT(PN) from PN where PN='"+ pn.getText().toUpperCase()+"'");
            rs.next();
            int pn1 = rs.getInt("count(PN)");
            if (pn1 == 0) {
                bGuardar.requestFocus();
                bGuardar.setEnabled(true);
                ComboBox1.setEnabled(true);
                cantidad1.setEnabled(true);
            } else {
                JOptionPane.showMessageDialog(null, "EL P/N YA EXISTE...");
                pn.requestFocus();
                return;
                
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR CONTACTE AL ADMINISTRADOR DEL SISTEMA"+e);
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
        test2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pn = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        nota = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        ComboBox1 = new javax.swing.JComboBox<>();
        ComboBox2 = new javax.swing.JComboBox<>();
        ComboBox3 = new javax.swing.JComboBox<>();
        ComboBox4 = new javax.swing.JComboBox<>();
        ComboBox5 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cantidad1 = new javax.swing.JTextField();
        cantidad2 = new javax.swing.JTextField();
        cantidad3 = new javax.swing.JTextField();
        cantidad4 = new javax.swing.JTextField();
        cantidad5 = new javax.swing.JTextField();
        ComboBox6 = new javax.swing.JComboBox<>();
        cantidad6 = new javax.swing.JTextField();
        ComboBox7 = new javax.swing.JComboBox<>();
        cantidad7 = new javax.swing.JTextField();
        ComboBox8 = new javax.swing.JComboBox<>();
        cantidad8 = new javax.swing.JTextField();
        ComboBox9 = new javax.swing.JComboBox<>();
        cantidad9 = new javax.swing.JTextField();
        ComboBox10 = new javax.swing.JComboBox<>();
        cantidad10 = new javax.swing.JTextField();
        bGuardar = new javax.swing.JButton();
        Cancel = new javax.swing.JButton();

        setClosable(true);
        setTitle("CREAR P/N");

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));

        test2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        test2.setText("Ingreso P/N");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("P/N");

        pn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pn.setFocusTraversalPolicyProvider(true);
        pn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pnActionPerformed(evt);
            }
        });
        pn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pnKeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Nota");

        nota.setColumns(20);
        nota.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        nota.setRows(5);
        nota.setFocusTraversalPolicyProvider(true);
        nota.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                notaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(nota);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Componentes", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        jPanel3.setMaximumSize(new java.awt.Dimension(244, 389));

        ComboBox1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        ComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar..." }));
        ComboBox1.setNextFocusableComponent(pn);
        ComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBox1ActionPerformed(evt);
            }
        });

        ComboBox2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        ComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar..." }));
        ComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBox2ActionPerformed(evt);
            }
        });

        ComboBox3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        ComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar..." }));
        ComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBox3ActionPerformed(evt);
            }
        });

        ComboBox4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        ComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar..." }));
        ComboBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBox4ActionPerformed(evt);
            }
        });

        ComboBox5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        ComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar..." }));
        ComboBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBox5ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Partes");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("cantidad");

        cantidad1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cantidad1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cantidad1FocusLost(evt);
            }
        });
        cantidad1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cantidad1MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cantidad1MouseExited(evt);
            }
        });
        cantidad1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cantidad1ActionPerformed(evt);
            }
        });
        cantidad1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cantidad1KeyTyped(evt);
            }
        });

        cantidad2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cantidad2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cantidad2ActionPerformed(evt);
            }
        });
        cantidad2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cantidad2KeyTyped(evt);
            }
        });

        cantidad3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cantidad3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cantidad3ActionPerformed(evt);
            }
        });
        cantidad3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cantidad3KeyTyped(evt);
            }
        });

        cantidad4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cantidad4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cantidad4ActionPerformed(evt);
            }
        });
        cantidad4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cantidad4KeyTyped(evt);
            }
        });

        cantidad5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cantidad5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cantidad5ActionPerformed(evt);
            }
        });
        cantidad5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cantidad5KeyTyped(evt);
            }
        });

        ComboBox6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        ComboBox6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar..." }));
        ComboBox6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBox6ActionPerformed(evt);
            }
        });

        cantidad6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cantidad6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cantidad6ActionPerformed(evt);
            }
        });
        cantidad6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cantidad6KeyTyped(evt);
            }
        });

        ComboBox7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        ComboBox7.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar..." }));
        ComboBox7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBox7ActionPerformed(evt);
            }
        });

        cantidad7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cantidad7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cantidad7ActionPerformed(evt);
            }
        });
        cantidad7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cantidad7KeyTyped(evt);
            }
        });

        ComboBox8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        ComboBox8.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar..." }));
        ComboBox8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBox8ActionPerformed(evt);
            }
        });

        cantidad8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cantidad8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cantidad8ActionPerformed(evt);
            }
        });
        cantidad8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cantidad8KeyTyped(evt);
            }
        });

        ComboBox9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        ComboBox9.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar..." }));
        ComboBox9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBox9ActionPerformed(evt);
            }
        });

        cantidad9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cantidad9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cantidad9ActionPerformed(evt);
            }
        });
        cantidad9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cantidad9KeyTyped(evt);
            }
        });

        ComboBox10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        ComboBox10.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar..." }));
        ComboBox10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBox10ActionPerformed(evt);
            }
        });

        cantidad10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cantidad10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cantidad10ActionPerformed(evt);
            }
        });
        cantidad10.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cantidad10KeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ComboBox10, 0, 214, Short.MAX_VALUE)
                    .addComponent(ComboBox9, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(ComboBox8, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ComboBox7, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ComboBox6, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ComboBox5, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ComboBox4, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ComboBox3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cantidad2, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                            .addComponent(cantidad3)
                            .addComponent(cantidad4)
                            .addComponent(cantidad5)
                            .addComponent(cantidad1)
                            .addComponent(cantidad6)
                            .addComponent(cantidad7))
                        .addComponent(cantidad8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cantidad9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cantidad10, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cantidad1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cantidad2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cantidad3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cantidad4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cantidad5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cantidad6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ComboBox7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cantidad7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ComboBox8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cantidad8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ComboBox9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cantidad9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ComboBox10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cantidad10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bGuardar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        bGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/save2.png"))); // NOI18N
        bGuardar.setText(" GUARDAR");
        bGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bGuardarActionPerformed(evt);
            }
        });

        Cancel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Cancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/cancelar.png"))); // NOI18N
        Cancel.setText("Cancelar");
        Cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel2)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(57, 57, 57)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(bGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Cancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                        .addComponent(pn)))
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(bGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(Cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(323, 323, 323)
                        .addComponent(test2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(399, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(test2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bGuardarActionPerformed
        
        if(pn.getText().compareTo("")!=0 && !ComboBox1.getSelectedItem().toString().equalsIgnoreCase("Seleccionar...")){
        idcompo2();idcompo3();idcompo4();idcompo5();    
        idcompo6();idcompo7();idcompo8();idcompo9();idcompo10();    
        idcompo1();
            
            try {
                 PN p = new PN();
                 p.setPN(pn.getText().toUpperCase());
                 p.setNota(nota.getText());
                 
                 p.setCompo1(ComboBox1.getSelectedItem().toString());
                 p.setComp1(comb1);
                 p.setCantidad1(Integer.parseInt(cantidad1.getText()));
                 
                 p.setCompo2(ComboBox2.getSelectedItem().toString());
                 p.setComp2(comb2);
                 if(cantidad2.getText().compareTo("")!=0){p.setCantidad2(Integer.parseInt(cantidad2.getText()));}else{p.setCantidad2(0);}
                                               
                 p.setCompo3(ComboBox3.getSelectedItem().toString());
                 p.setComp3(comb3);
                 if(cantidad3.getText().compareTo("")!=0){p.setCantidad3(Integer.parseInt(cantidad3.getText()));}else{p.setCantidad3(0);}
                 
                 p.setCompo4(ComboBox4.getSelectedItem().toString());
                 p.setComp4(comb4);
                 if(cantidad4.getText().compareTo("")!=0){p.setCantidad4(Integer.parseInt(cantidad4.getText()));}else{p.setCantidad4(0);}
                 
                 p.setCompo5(ComboBox5.getSelectedItem().toString());
                 p.setComp5(comb5);
                 if(cantidad5.getText().compareTo("")!=0){p.setCantidad5(Integer.parseInt(cantidad5.getText()));}else{p.setCantidad5(0);}
                 
                 p.setCompo6(ComboBox6.getSelectedItem().toString());
                 p.setComp6(comb6);
                 if(cantidad6.getText().compareTo("")!=0){p.setCantidad6(Integer.parseInt(cantidad6.getText()));}else{p.setCantidad6(0);}
                 
                 p.setCompo7(ComboBox7.getSelectedItem().toString());
                 p.setComp7(comb7);
                 if(cantidad7.getText().compareTo("")!=0){p.setCantidad7(Integer.parseInt(cantidad7.getText()));}else{p.setCantidad7(0);}
                 
                 p.setCompo8(ComboBox8.getSelectedItem().toString());
                 p.setComp8(comb8);
                 if(cantidad8.getText().compareTo("")!=0){p.setCantidad8(Integer.parseInt(cantidad8.getText()));}else{p.setCantidad8(0);}
                 
                 p.setCompo9(ComboBox9.getSelectedItem().toString());
                 p.setComp9(comb9);
                 if(cantidad9.getText().compareTo("")!=0){p.setCantidad9(Integer.parseInt(cantidad9.getText()));}else{p.setCantidad9(0);}

                 p.setCompo10(ComboBox10.getSelectedItem().toString());
                 p.setComp10(comb10);
                 if(cantidad10.getText().compareTo("")!=0){p.setCantidad10(Integer.parseInt(cantidad10.getText()));}else{p.setCantidad10(0);}
                 
                 Componente.guardarPN(p);
                 JOptionPane.showMessageDialog(null,"P/N Agregado..."); 
                 limpiar();
                 habilitar(true);
            } catch (SQLException e) { JOptionPane.showMessageDialog(null,"ERROR desde guardar"+e);
                        
            }
            
        }else{JOptionPane.showMessageDialog(null, "Llene Todos los Campos");}
        
        
    }//GEN-LAST:event_bGuardarActionPerformed

    private void cantidad5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cantidad5ActionPerformed
        if(!ComboBox4.getSelectedItem().toString().equalsIgnoreCase("Seleccionar...") && cantidad4.getText().compareTo("")!=0) {
            ComboBox6.setEnabled(true);
            cantidad6.setEnabled(true);
            ComboBox6.requestFocus();
        }else{JOptionPane.showMessageDialog(null, "Llene todos los Datos");
            cantidad6.requestFocus();}
    }//GEN-LAST:event_cantidad5ActionPerformed

    private void cantidad4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cantidad4ActionPerformed
        if(!ComboBox4.getSelectedItem().toString().equalsIgnoreCase("Seleccionar...") && cantidad4.getText().compareTo("")!=0) {
            ComboBox5.setEnabled(true);
            cantidad5.setEnabled(true);
            pn.requestFocus();
        }else{JOptionPane.showMessageDialog(null, "Llene todos los Datos");
            cantidad5.requestFocus();}
    }//GEN-LAST:event_cantidad4ActionPerformed

    private void cantidad3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cantidad3ActionPerformed
        if(!ComboBox3.getSelectedItem().toString().equalsIgnoreCase("Seleccionar...") && cantidad3.getText().compareTo("")!=0) {
            ComboBox4.setEnabled(true);
            cantidad4.setEnabled(true);
            pn.requestFocus();
        }else{JOptionPane.showMessageDialog(null, "Llene todos los Datos");
            cantidad3.requestFocus();}
    }//GEN-LAST:event_cantidad3ActionPerformed

    private void cantidad2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cantidad2ActionPerformed
        if(!ComboBox2.getSelectedItem().toString().equalsIgnoreCase("Seleccionar...") && cantidad2.getText().compareTo("")!=0) {
            ComboBox3.setEnabled(true);
            cantidad3.setEnabled(true);
            pn.requestFocus();
        }else{JOptionPane.showMessageDialog(null, "Llene todos los Datos");
            cantidad2.requestFocus();}
    }//GEN-LAST:event_cantidad2ActionPerformed

    private void cantidad1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cantidad1ActionPerformed
        if(!ComboBox1.getSelectedItem().toString().equalsIgnoreCase("Seleccionar...") && cantidad1.getText().compareTo("")!=0) {
            ComboBox2.setEnabled(true);
            cantidad2.setEnabled(true);
            pn.requestFocus();
        }else{JOptionPane.showMessageDialog(null, "Llene todos los Datos");
            cantidad1.requestFocus();}
    }//GEN-LAST:event_cantidad1ActionPerformed

    private void cantidad1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cantidad1MouseExited

    }//GEN-LAST:event_cantidad1MouseExited

    private void cantidad1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cantidad1FocusLost

    }//GEN-LAST:event_cantidad1FocusLost

    private void ComboBox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBox5ActionPerformed
        cantidad5.requestFocus();
    }//GEN-LAST:event_ComboBox5ActionPerformed

    private void ComboBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBox4ActionPerformed
        cantidad4.requestFocus();
    }//GEN-LAST:event_ComboBox4ActionPerformed

    private void ComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBox3ActionPerformed
        cantidad3.requestFocus();
    }//GEN-LAST:event_ComboBox3ActionPerformed

    private void ComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBox2ActionPerformed
        cantidad2.requestFocus();
    }//GEN-LAST:event_ComboBox2ActionPerformed

    private void ComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBox1ActionPerformed
        cantidad1.requestFocus();
    }//GEN-LAST:event_ComboBox1ActionPerformed

    private void pnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pnActionPerformed
        existePN();
        
        
        
    }//GEN-LAST:event_pnActionPerformed

    private void cantidad1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cantidad1MouseClicked
      
    }//GEN-LAST:event_cantidad1MouseClicked

    private void CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelActionPerformed
       limpiar();
        habilitar(true);
        bGuardar.setEnabled(false);
       
    }//GEN-LAST:event_CancelActionPerformed

    private void cantidad1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cantidad1KeyTyped
       char c = evt.getKeyChar();
        if ((c < '0' || c > '9') && (c < '0' || c > '9')) {
            evt.consume();
        }
    }//GEN-LAST:event_cantidad1KeyTyped

    private void cantidad2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cantidad2KeyTyped
       char c = evt.getKeyChar();
        if ((c < '0' || c > '9') && (c < '0' || c > '9')) {
            evt.consume();
        }
    }//GEN-LAST:event_cantidad2KeyTyped

    private void cantidad3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cantidad3KeyTyped
       char c = evt.getKeyChar();
        if ((c < '0' || c > '9') && (c < '0' || c > '9')) {
            evt.consume();
        }
    }//GEN-LAST:event_cantidad3KeyTyped

    private void cantidad4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cantidad4KeyTyped
        char c = evt.getKeyChar();
        if ((c < '0' || c > '9') && (c < '0' || c > '9')) {
            evt.consume();
        }
    }//GEN-LAST:event_cantidad4KeyTyped

    private void cantidad5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cantidad5KeyTyped
        char c = evt.getKeyChar();
        if ((c < '0' || c > '9') && (c < '0' || c > '9')) {
            evt.consume();
        }
    }//GEN-LAST:event_cantidad5KeyTyped

    private void pnKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pnKeyTyped
       
    }//GEN-LAST:event_pnKeyTyped

    private void notaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_notaMouseClicked

    }//GEN-LAST:event_notaMouseClicked

    private void ComboBox6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBox6ActionPerformed
        cantidad6.requestFocus();
    }//GEN-LAST:event_ComboBox6ActionPerformed

    private void cantidad6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cantidad6ActionPerformed
      if(!ComboBox6.getSelectedItem().toString().equalsIgnoreCase("Seleccionar...") && cantidad6.getText().compareTo("")!=0) {
            ComboBox7.setEnabled(true);
            cantidad7.setEnabled(true);
            ComboBox7.requestFocus();
            idcompo7();
        }else{JOptionPane.showMessageDialog(null, "Llene todos los Datos");
            cantidad6.requestFocus();}
    }//GEN-LAST:event_cantidad6ActionPerformed

    private void cantidad6KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cantidad6KeyTyped
      char c = evt.getKeyChar();
        if ((c < '0' || c > '9') && (c < '0' || c > '9')) {
            evt.consume();
        }
    }//GEN-LAST:event_cantidad6KeyTyped

    private void ComboBox7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBox7ActionPerformed
       cantidad7.requestFocus();
    }//GEN-LAST:event_ComboBox7ActionPerformed

    private void cantidad7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cantidad7ActionPerformed
       if(!ComboBox7.getSelectedItem().toString().equalsIgnoreCase("Seleccionar...") && cantidad7.getText().compareTo("")!=0) {
            ComboBox8.setEnabled(true);
            cantidad8.setEnabled(true);
            ComboBox8.requestFocus();
            idcompo8();
        }else{JOptionPane.showMessageDialog(null, "Llene todos los Datos");
            cantidad7.requestFocus();}
    }//GEN-LAST:event_cantidad7ActionPerformed

    private void cantidad7KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cantidad7KeyTyped
       char c = evt.getKeyChar();
        if ((c < '0' || c > '9') && (c < '0' || c > '9')) {
            evt.consume();
        }
    }//GEN-LAST:event_cantidad7KeyTyped

    private void ComboBox8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBox8ActionPerformed
         cantidad8.requestFocus();
    }//GEN-LAST:event_ComboBox8ActionPerformed

    private void cantidad8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cantidad8ActionPerformed
       if(!ComboBox8.getSelectedItem().toString().equalsIgnoreCase("Seleccionar...") && cantidad8.getText().compareTo("")!=0) {
            ComboBox9.setEnabled(true);
            cantidad9.setEnabled(true);
            ComboBox9.requestFocus();
            idcompo9();
        }else{JOptionPane.showMessageDialog(null, "Llene todos los Datos");
            cantidad8.requestFocus();}
    }//GEN-LAST:event_cantidad8ActionPerformed

    private void cantidad8KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cantidad8KeyTyped
         char c = evt.getKeyChar();
            if ((c < '0' || c > '9') && (c < '0' || c > '9')) {
               evt.consume();
            }
    }//GEN-LAST:event_cantidad8KeyTyped

    private void ComboBox9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBox9ActionPerformed
       cantidad9.requestFocus();
    }//GEN-LAST:event_ComboBox9ActionPerformed

    private void cantidad9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cantidad9ActionPerformed
       if(!ComboBox9.getSelectedItem().toString().equalsIgnoreCase("Seleccionar...") && cantidad9.getText().compareTo("")!=0) {
            ComboBox10.setEnabled(true);
            cantidad10.setEnabled(true);
            ComboBox10.requestFocus();
            idcompo10();
        }else{JOptionPane.showMessageDialog(null, "Llene todos los Datos");
            cantidad9.requestFocus();}
    }//GEN-LAST:event_cantidad9ActionPerformed

    private void cantidad9KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cantidad9KeyTyped
        char c = evt.getKeyChar();
        if ((c < '0' || c > '9') && (c < '0' || c > '9')) {
            evt.consume();
        }
    }//GEN-LAST:event_cantidad9KeyTyped

    private void ComboBox10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBox10ActionPerformed
        cantidad10.requestFocus();
    }//GEN-LAST:event_ComboBox10ActionPerformed

    private void cantidad10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cantidad10ActionPerformed
       if(!ComboBox10.getSelectedItem().toString().equalsIgnoreCase("Seleccionar...") && cantidad10.getText().compareTo("")!=0) {
            bGuardar.requestFocus();
        }else{JOptionPane.showMessageDialog(null, "Llene todos los Datos");
            cantidad10.requestFocus();}
    }//GEN-LAST:event_cantidad10ActionPerformed

    private void cantidad10KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cantidad10KeyTyped
      char c = evt.getKeyChar();
        if ((c < '0' || c > '9') && (c < '0' || c > '9')) {
            evt.consume();
        }
    }//GEN-LAST:event_cantidad10KeyTyped

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
            java.util.logging.Logger.getLogger(IngresosPN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IngresosPN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IngresosPN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IngresosPN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IngresosPN().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cancel;
    private javax.swing.JComboBox<String> ComboBox1;
    private javax.swing.JComboBox<String> ComboBox10;
    private javax.swing.JComboBox<String> ComboBox2;
    private javax.swing.JComboBox<String> ComboBox3;
    private javax.swing.JComboBox<String> ComboBox4;
    private javax.swing.JComboBox<String> ComboBox5;
    private javax.swing.JComboBox<String> ComboBox6;
    private javax.swing.JComboBox<String> ComboBox7;
    private javax.swing.JComboBox<String> ComboBox8;
    private javax.swing.JComboBox<String> ComboBox9;
    private javax.swing.JButton bGuardar;
    private javax.swing.JTextField cantidad1;
    private javax.swing.JTextField cantidad10;
    private javax.swing.JTextField cantidad2;
    private javax.swing.JTextField cantidad3;
    private javax.swing.JTextField cantidad4;
    private javax.swing.JTextField cantidad5;
    private javax.swing.JTextField cantidad6;
    private javax.swing.JTextField cantidad7;
    private javax.swing.JTextField cantidad8;
    private javax.swing.JTextField cantidad9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea nota;
    private javax.swing.JTextField pn;
    private javax.swing.JLabel test2;
    // End of variables declaration//GEN-END:variables
}
