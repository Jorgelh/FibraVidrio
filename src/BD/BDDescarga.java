/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import Class.CTrabajos;
import Class.Descargas;
import Class.IngresoMaterial;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author jluis
 */
public class BDDescarga {
    
    public static Descargas BuscarDes (String id)  throws SQLException{
        return BuscarDes(id,null);
    }
        
    public static Descargas BuscarDes(String id,Descargas t) throws SQLException{
        
        Connection cn = BDFIBRA.getConnection();
        PreparedStatement ps =null;
        ps = cn.prepareStatement("select iddesc,nombre,cantidad from descripcion where nombre ='"+id+"'");
        ResultSet rs = ps.executeQuery();
        if (rs.next()){
             if (t == null){
            t = new Descargas();
             }   
            t.setIddesc(rs.getInt("iddesc"));
            t.setDescripcion(rs.getString("nombre"));
            t.setCantidad(rs.getInt("cantidad"));
    }
      cn.close();
      ps.close();
      return t;
    }
    
    public static void guardardescarga (Descargas l) throws SQLException{
        Connection cn = BDFIBRA.getConnection();
        PreparedStatement ps = null;
        ps = cn.prepareStatement("insert into DESCARGASMATERIAL values (?,?,?,?,?,?)");
        ps.setInt(1, l.getId_descarga());
        ps.setInt(2, l.getIddesc());
        ps.setDate(3, new java.sql.Date(l.getFecha().getTime()));
        ps.setString(4, l.getNota());
        ps.setInt(5, l.getCantidad());
        ps.setString(6, l.getPN());
        ps.executeUpdate();
        cn.close();
        ps.close();
    }
}
       
    
 

