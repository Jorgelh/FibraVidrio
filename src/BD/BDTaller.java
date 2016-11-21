/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import Class.IngresoMaterial;
import Class.componentes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author jluis
 */
public class BDTaller {
    
    public static void guardarIngresoHerramienta (componentes l) throws SQLException{
        Connection cn = BDFIBRA.getConnection();
        PreparedStatement ps = null;
        ps = cn.prepareStatement("insert into M_DESCRIPCION values (?,?,?,?,?,?,?,?,?,?,?)");
        ps.setInt(1, l.getNo());
        ps.setInt(2, l.getTipoMaterial());
        ps.setInt(3, l.getMedida());
        ps.setInt(4, l.getDescri());
        ps.setInt(5, l.getMarca());
        ps.setString(6, l.getFilos());
        ps.setInt(7, l.getCantidad());
        ps.setDate(8, new java.sql.Date(l.getFecha().getTime()));
        ps.setString(9, l.getPo());
        ps.setString(10, l.getComentantario());
        ps.setString(11, l.getCodigoCatalogo());
        ps.executeUpdate();
        cn.close();
        ps.close();
    }
    
    
    
    
    
}
