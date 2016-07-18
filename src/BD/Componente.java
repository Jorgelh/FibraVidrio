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
       if(p.getCompo2()!="Seleccionar.."){
       ps = cn.prepareStatement("insert into PN values("+p.getPN()+","
               +p.getCompo1()+","+p.getCantidad1()+","
               +p.getNota()+";");
               ps.executeUpdate();
               cn.close();
               ps.close();
       }else if(p.getCompo3()!="Seleccionar"){
               ps = cn.prepareStatement("insert into PN values(" + p.getPN() + ","
                       + p.getCompo1() + "," + p.getCantidad1() + ","
                       + p.getNota() + "");
               ps = cn.prepareStatement("insert into PN values(" + p.getPN() + ","
                   + p.getCompo2() + "," + p.getCantidad2() + ","
                   + p.getNota() + ";");
               ps.executeUpdate();
                cn.close();
               ps.close();
       }else if (p.getCompo4()!="Seleccionar"){
               ps = cn.prepareStatement("insert into PN values(" + p.getPN() + ","
                       + p.getCompo1() + "," + p.getCantidad1() + ","
                       + p.getNota() + ";");
               ps = cn.prepareStatement("insert into PN values(" + p.getPN() + ","
                   + p.getCompo2() + "," + p.getCantidad2() + ","
                   + p.getNota() + ";");
               ps = cn.prepareStatement("insert into PN values(" + p.getPN() + ","
                   + p.getCompo3() + "," + p.getCantidad3() + ","
                   + p.getNota() + ";");
               ps.executeUpdate();
               cn.close();
               ps.close();
       
       
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
