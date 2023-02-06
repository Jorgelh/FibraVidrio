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
        ps = cn.prepareStatement("insert into M_DESCRIPCION(no,no_tipo,no_medida,no_descripcion,no_marca,filos,notas,nocatalogo) values (?,?,?,?,?,?,?,?)");
        ps.setInt(1, l.getNo());
        ps.setInt(2, l.getTipoMaterial());
        ps.setInt(3, l.getMedida());
        ps.setInt(4, l.getDescri());
        ps.setInt(5, l.getMarca());
        ps.setString(6, l.getFilos());
        ps.setString(7, l.getComentantario());
        ps.setString(8, l.getCodigoCatalogo());
        ps.executeUpdate();
        cn.close();
        ps.close();
    }
    
    
    
    
    
}
