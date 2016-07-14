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
    
    
    
}
