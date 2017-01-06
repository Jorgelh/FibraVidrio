/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import Class.PN;
import BD.BDFIBRA;
import Class.DescripcionC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author jluis
 */
public class Componente {
    
    public static void guardarComponentes (PN p) throws SQLException{
        Connection cn = BDFIBRA.getConnection();
        PreparedStatement ps = null;
        ps = cn.prepareStatement("insert into COMPONENTES values (?,?,?)");
        ps.setInt(1, p.getIdcompo());
        ps.setString(2, p.getDescripcion());
        ps.setString(3, p.getMedida());
        ps.executeUpdate();
        cn.close();
        ps.close();
    }
    
    public static void guardarPNmas (DescripcionC p) throws SQLException{
        Connection cn = BDFIBRA.getConnection();
        PreparedStatement ps = null;
        ps = cn.prepareStatement("insert into PN values (pn1.nextval,?,?,?,'')");
        ps.setString(1, p.getPN());
        ps.setInt(2, p.getIdcompo());
        ps.setInt(3, p.getCantidad());
        ps.executeUpdate();
        cn.close();
        ps.close();
    }
    
    
    public static void guardarPN(PN p) throws SQLException {

        try {
            Connection cn = BDFIBRA.getConnection();
            Statement ps = cn.createStatement();
            if (p.getCompo2() == "Seleccionar...") {
               
                ps.executeUpdate("insert into PN values(pn1.nextval,'" + p.getPN() + "'," + p.getComp1() + "," + p.getCantidad1() + ",'" + p.getNota() + "')");
                cn.close();
                ps.close();

            } else if (p.getCompo3() == "Seleccionar...") {
                ps.executeUpdate("insert into PN values(pn1.nextval,'" + p.getPN() + "'," + p.getComp1() + "," + p.getCantidad1() + ",'" + p.getNota() + "')");
                ps.executeUpdate("insert into PN values(pn1.nextval,'" + p.getPN() + "'," + p.getComp2() + "," + p.getCantidad2() + ",'" + p.getNota() + "')");
                cn.close();
                ps.close();

            } else if (p.getCompo4() == "Seleccionar...") {
                ps.executeUpdate("insert into PN values(pn1.nextval,'" + p.getPN() + "'," + p.getComp1() + "," + p.getCantidad1() + ",'" + p.getNota() + "')");
                ps.executeUpdate("insert into PN values(pn1.nextval,'" + p.getPN() + "'," + p.getComp2() + "," + p.getCantidad2() + ",'" + p.getNota() + "')");
                ps.executeUpdate("insert into PN values(pn1.nextval,'" + p.getPN() + "'," + p.getComp3() + "," + p.getCantidad3() + ",'" + p.getNota() + "')");
                cn.close();
                ps.close();
            } else if (p.getCompo5() == "Seleccionar...") {
                ps.executeUpdate("insert into PN values(pn1.nextval,'" + p.getPN() + "'," + p.getComp1() + "," + p.getCantidad1() + ",'" + p.getNota() + "')");
                ps.executeUpdate("insert into PN values(pn1.nextval,'" + p.getPN() + "'," + p.getComp2() + "," + p.getCantidad2() + ",'" + p.getNota() + "')");
                ps.executeUpdate("insert into PN values(pn1.nextval,'" + p.getPN() + "'," + p.getComp3() + "," + p.getCantidad3() + ",'" + p.getNota() + "')");
                ps.executeUpdate("insert into PN values(pn1.nextval,'" + p.getPN() + "'," + p.getComp4() + "," + p.getCantidad4() + ",'" + p.getNota() + "')");
                cn.close();
                ps.close();
            } else if (p.getCompo6() == "Seleccionar") {

                ps.executeUpdate("insert into PN values(pn1.nextval,'" + p.getPN() + "'," + p.getComp1() + "," + p.getCantidad1() + ",'" + p.getNota() + "')");
                ps.executeUpdate("insert into PN values(pn1.nextval,'" + p.getPN() + "'," + p.getComp2() + "," + p.getCantidad2() + ",'" + p.getNota() + "')");
                ps.executeUpdate("insert into PN values(pn1.nextval,'" + p.getPN() + "'," + p.getComp3() + "," + p.getCantidad3() + ",'" + p.getNota() + "')");
                ps.executeUpdate("insert into PN values(pn1.nextval,'" + p.getPN() + "'," + p.getComp4() + "," + p.getCantidad4() + ",'" + p.getNota() + "')");
                ps.executeUpdate("insert into PN values(pn1.nextval,'" + p.getPN() + "'," + p.getComp5() + "," + p.getCantidad5() + ",'" + p.getNota() + "')");
                cn.close();
                ps.close();
            } else if (p.getCompo7() == "Seleccionar...") {
                ps.executeUpdate("insert into PN values(pn1.nextval,'" + p.getPN() + "'," + p.getComp1() + "," + p.getCantidad1() + ",'" + p.getNota() + "')");
                ps.executeUpdate("insert into PN values(pn1.nextval,'" + p.getPN() + "'," + p.getComp2() + "," + p.getCantidad2() + ",'" + p.getNota() + "')");
                ps.executeUpdate("insert into PN values(pn1.nextval,'" + p.getPN() + "'," + p.getComp3() + "," + p.getCantidad3() + ",'" + p.getNota() + "')");
                ps.executeUpdate("insert into PN values(pn1.nextval,'" + p.getPN() + "'," + p.getComp4() + "," + p.getCantidad4() + ",'" + p.getNota() + "')");
                ps.executeUpdate("insert into PN values(pn1.nextval,'" + p.getPN() + "'," + p.getComp5() + "," + p.getCantidad5() + ",'" + p.getNota() + "')");
                ps.executeUpdate("insert into PN values(pn1.nextval,'" + p.getPN() + "'," + p.getComp6() + "," + p.getCantidad6() + ",'" + p.getNota() + "')");
                cn.close();
                ps.close();
            } else if (p.getCompo8() == "Seleccionar...") {
                ps.executeUpdate("insert into PN values(pn1.nextval,'" + p.getPN() + "'," + p.getComp1() + "," + p.getCantidad1() + ",'" + p.getNota() + "')");
                ps.executeUpdate("insert into PN values(pn1.nextval,'" + p.getPN() + "'," + p.getComp2() + "," + p.getCantidad2() + ",'" + p.getNota() + "')");
                ps.executeUpdate("insert into PN values(pn1.nextval,'" + p.getPN() + "'," + p.getComp3() + "," + p.getCantidad3() + ",'" + p.getNota() + "')");
                ps.executeUpdate("insert into PN values(pn1.nextval,'" + p.getPN() + "'," + p.getComp4() + "," + p.getCantidad4() + ",'" + p.getNota() + "')");
                ps.executeUpdate("insert into PN values(pn1.nextval,'" + p.getPN() + "'," + p.getComp5() + "," + p.getCantidad5() + ",'" + p.getNota() + "')");
                ps.executeUpdate("insert into PN values(pn1.nextval,'" + p.getPN() + "'," + p.getComp6() + "," + p.getCantidad6() + ",'" + p.getNota() + "')");
                ps.executeUpdate("insert into PN values(pn1.nextval,'" + p.getPN() + "'," + p.getComp7() + "," + p.getCantidad7() + ",'" + p.getNota() + "')");
                cn.close();
                ps.close();
            } else if (p.getCompo9() == "Seleccionar...") {
                ps.executeUpdate("insert into PN values(pn1.nextval,'" + p.getPN() + "'," + p.getComp1() + "," + p.getCantidad1() + ",'" + p.getNota() + "')");
                ps.executeUpdate("insert into PN values(pn1.nextval,'" + p.getPN() + "'," + p.getComp2() + "," + p.getCantidad2() + ",'" + p.getNota() + "')");
                ps.executeUpdate("insert into PN values(pn1.nextval,'" + p.getPN() + "'," + p.getComp3() + "," + p.getCantidad3() + ",'" + p.getNota() + "')");
                ps.executeUpdate("insert into PN values(pn1.nextval,'" + p.getPN() + "'," + p.getComp4() + "," + p.getCantidad4() + ",'" + p.getNota() + "')");
                ps.executeUpdate("insert into PN values(pn1.nextval,'" + p.getPN() + "'," + p.getComp5() + "," + p.getCantidad5() + ",'" + p.getNota() + "')");
                ps.executeUpdate("insert into PN values(pn1.nextval,'" + p.getPN() + "'," + p.getComp6() + "," + p.getCantidad6() + ",'" + p.getNota() + "')");
                ps.executeUpdate("insert into PN values(pn1.nextval,'" + p.getPN() + "'," + p.getComp7() + "," + p.getCantidad7() + ",'" + p.getNota() + "')");
                ps.executeUpdate("insert into PN values(pn1.nextval,'" + p.getPN() + "'," + p.getComp8() + "," + p.getCantidad8() + ",'" + p.getNota() + "')");
                cn.close();
                ps.close();
            } else if (p.getCompo10() == "Seleccionar") {
                ps.executeUpdate("insert into PN values(pn1.nextval,'" + p.getPN() + "'," + p.getComp1() + "," + p.getCantidad1() + ",'" + p.getNota() + "')");
                ps.executeUpdate("insert into PN values(pn1.nextval,'" + p.getPN() + "'," + p.getComp2() + "," + p.getCantidad2() + ",'" + p.getNota() + "')");
                ps.executeUpdate("insert into PN values(pn1.nextval,'" + p.getPN() + "'," + p.getComp3() + "," + p.getCantidad3() + ",'" + p.getNota() + "')");
                ps.executeUpdate("insert into PN values(pn1.nextval,'" + p.getPN() + "'," + p.getComp4() + "," + p.getCantidad4() + ",'" + p.getNota() + "')");
                ps.executeUpdate("insert into PN values(pn1.nextval,'" + p.getPN() + "'," + p.getComp5() + "," + p.getCantidad5() + ",'" + p.getNota() + "')");
                ps.executeUpdate("insert into PN values(pn1.nextval,'" + p.getPN() + "'," + p.getComp6() + "," + p.getCantidad6() + ",'" + p.getNota() + "')");
                ps.executeUpdate("insert into PN values(pn1.nextval,'" + p.getPN() + "'," + p.getComp7() + "," + p.getCantidad7() + ",'" + p.getNota() + "')");
                ps.executeUpdate("insert into PN values(pn1.nextval,'" + p.getPN() + "'," + p.getComp8() + "," + p.getCantidad8() + ",'" + p.getNota() + "')");
                ps.executeUpdate("insert into PN values(pn1.nextval,'" + p.getPN() + "'," + p.getComp9() + "," + p.getCantidad9() + ",'" + p.getNota() + "')");
                cn.close();
                ps.close();
            } else if (p.getCompo10() != "Seleccionar") {
                ps.executeUpdate("insert into PN values(pn1.nextval,'" + p.getPN() + "'," + p.getComp1() + "," + p.getCantidad1() + ",'" + p.getNota() + "')");
                ps.executeUpdate("insert into PN values(pn1.nextval,'" + p.getPN() + "'," + p.getComp2() + "," + p.getCantidad2() + ",'" + p.getNota() + "')");
                ps.executeUpdate("insert into PN values(pn1.nextval,'" + p.getPN() + "'," + p.getComp3() + "," + p.getCantidad3() + ",'" + p.getNota() + "')");
                ps.executeUpdate("insert into PN values(pn1.nextval,'" + p.getPN() + "'," + p.getComp4() + "," + p.getCantidad4() + ",'" + p.getNota() + "')");
                ps.executeUpdate("insert into PN values(pn1.nextval,'" + p.getPN() + "'," + p.getComp5() + "," + p.getCantidad5() + ",'" + p.getNota() + "')");
                ps.executeUpdate("insert into PN values(pn1.nextval,'" + p.getPN() + "'," + p.getComp6() + "," + p.getCantidad6() + ",'" + p.getNota() + "')");
                ps.executeUpdate("insert into PN values(pn1.nextval,'" + p.getPN() + "'," + p.getComp7() + "," + p.getCantidad7() + ",'" + p.getNota() + "')");
                ps.executeUpdate("insert into PN values(pn1.nextval,'" + p.getPN() + "'," + p.getComp8() + "," + p.getCantidad8() + ",'" + p.getNota() + "')");
                ps.executeUpdate("insert into PN values(pn1.nextval,'" + p.getPN() + "'," + p.getComp9() + "," + p.getCantidad9() + ",'" + p.getNota() + "')");
                ps.executeUpdate("insert into PN values(pn1.nextval,'" + p.getPN() + "'," + p.getComp10() + "," + p.getCantidad10() + ",'" + p.getNota() + "')");
                cn.close();
                ps.close();
            }
        } catch (Exception e) {
        }
    }
    
    public static PN buscarCompo (String p1) throws SQLException{
        return buscarDescarga(p1, null);
    }
    
    public static PN buscarDescarga(String p1, PN c) throws SQLException{
        
        Connection cn = BDFIBRA.getConnection();
        PreparedStatement ps =null;
        ps = cn.prepareStatement("select * from pn where pn ='"+p1+"'");
        ResultSet rs = ps.executeQuery();
        if (rs.next()){
             if (c == null){
             c = new PN(){
             };
        }
        c.setPN(rs.getString("pn"));
        c.setCompo1(rs.getString("componente1"));
        c.setCompo2(rs.getString("componente2"));
        c.setCompo3(rs.getString("componente3"));
        c.setCompo4(rs.getString("componente4"));
        c.setCompo5(rs.getString("componente5"));
        c.setCompo6(rs.getString("componente6"));
        c.setCompo7(rs.getString("componente7"));
        c.setCompo8(rs.getString("componente8"));
        c.setCompo9(rs.getString("componente9"));
        c.setCompo10(rs.getString("componente10"));
        c.setCantidad1(rs.getInt("cantidad1"));
        c.setCantidad2(rs.getInt("cantidad2"));
        c.setCantidad3(rs.getInt("cantidad3"));
        c.setCantidad4(rs.getInt("cantidad4"));
        c.setCantidad5(rs.getInt("cantidad5"));
        c.setCantidad1(rs.getInt("cantidad6"));
        c.setCantidad2(rs.getInt("cantidad7"));
        c.setCantidad3(rs.getInt("cantidad8"));
        c.setCantidad4(rs.getInt("cantidad9"));
        c.setCantidad5(rs.getInt("cantidad10"));
        }
        cn.close();
        ps.close();
        return c;
        
    }
    
    
    
    
    
}
