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
       ps = cn.prepareStatement("insert into PN values(?,?,?,?,?,?,?,?,?,?,?,?)");
       ps.setString(1,p.getPN());
       if (p.getCompo1()== "Seleccionar..."){ps.setString(2, null);} else {ps.setString(2,p.getCompo1());}
       if (p.getCompo2()== "Seleccionar..."){ps.setString(3, null);} else {ps.setString(3,p.getCompo2());}
       if (p.getCompo3()== "Seleccionar..."){ps.setString(4, null);} else {ps.setString(4,p.getCompo3());}
       if (p.getCompo4()== "Seleccionar..."){ps.setString(5, null);} else {ps.setString(5,p.getCompo4());}
       if (p.getCompo5()== "Seleccionar..."){ps.setString(6, null);} else {ps.setString(6,p.getCompo5());}
       ps.setInt(7,p.getCantidad1());
       ps.setInt(8,p.getCantidad2());
       ps.setInt(9,p.getCantidad3());
       ps.setInt(10,p.getCantidad4());
       ps.setInt(11,p.getCantidad5());
       ps.setString(12,p.getNota());
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
        c.setCantidad1(rs.getInt("cantidad1"));
        c.setCantidad2(rs.getInt("cantidad2"));
        c.setCantidad3(rs.getInt("cantidad3"));
        c.setCantidad4(rs.getInt("cantidad4"));
        c.setCantidad5(rs.getInt("cantidad5"));
        }
        cn.close();
        ps.close();
        return c;
        
    }
    
    
    
    
    
}
