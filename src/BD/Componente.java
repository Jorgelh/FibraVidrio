/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import Class.PN;
import BD.BDFIBRA;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
    
    public static void guardarPN (PN p) throws SQLException{
       Connection cn = BDFIBRA.getConnection();
       PreparedStatement ps = null;
       ps = cn.prepareStatement("insert into PN values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
       ps.setString(1,p.getPN());
       if (p.getCompo1()== "Seleccionar..."){ps.setString(2, null);} else {ps.setString(2,p.getCompo1());}
       if (p.getCompo2()== "Seleccionar..."){ps.setString(3, null);} else {ps.setString(3,p.getCompo2());}
       if (p.getCompo3()== "Seleccionar..."){ps.setString(4, null);} else {ps.setString(4,p.getCompo3());}
       if (p.getCompo4()== "Seleccionar..."){ps.setString(5, null);} else {ps.setString(5,p.getCompo4());}
       if (p.getCompo5()== "Seleccionar..."){ps.setString(6, null);} else {ps.setString(6,p.getCompo5());}
       if (p.getCompo6()== "Seleccionar..."){ps.setString(7, null);} else {ps.setString(7,p.getCompo6());}
       if (p.getCompo7()== "Seleccionar..."){ps.setString(8, null);} else {ps.setString(8,p.getCompo7());}
       if (p.getCompo8()== "Seleccionar..."){ps.setString(9, null);} else {ps.setString(9,p.getCompo8());}
       if (p.getCompo9()== "Seleccionar..."){ps.setString(10, null);} else {ps.setString(10,p.getCompo9());}
       if (p.getCompo10()== "Seleccionar..."){ps.setString(11, null);} else {ps.setString(11,p.getCompo10());}
       
       ps.setInt(12,p.getCantidad1());
       ps.setInt(13,p.getCantidad2());
       ps.setInt(14,p.getCantidad3());
       ps.setInt(15,p.getCantidad4());
       ps.setInt(16,p.getCantidad5());
       ps.setInt(17,p.getCantidad6());
       ps.setInt(18,p.getCantidad7());
       ps.setInt(19,p.getCantidad8());
       ps.setInt(20,p.getCantidad9());
       ps.setInt(21,p.getCantidad10());
       ps.setString(22,p.getNota());
       ps.executeUpdate();
       cn.close();
       ps.close();
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
