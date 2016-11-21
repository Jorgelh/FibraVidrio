/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import Class.CTrabajos;
import Class.IngresoMaterial;
import Formularios.IngreMateriales;
import Formularios.ingresoTmaterial;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author jluis
 */
public class BDIngresosMaterial {

public static void guardarIngresoMaterial (IngresoMaterial l) throws SQLException{
        Connection cn = BDFIBRA.getConnection();
        PreparedStatement ps = null;
        ps = cn.prepareStatement("insert into material values (?,?,?,?,?,?,1,?,?)");
        ps.setInt(1, l.getId_Material());
        ps.setInt(2, l.getIdMaterial());
        ps.setInt(3, l.getCantidad());
        ps.setDate(4, new java.sql.Date(l.getFechaIngreso().getTime()));
        ps.setString(5, l.getPO());
        ps.setString(6, l.getInvoice());
        ps.setString(7, l.getPN());
        ps.setString(8, l.getNotas());
        ps.executeUpdate();
        cn.close();
        ps.close();
    }


public static ArrayList<IngresoMaterial> ListarMateriales(String c) {

        return consultaSQL("select nombre,cantidad from descripcion where upper(nombre) like upper('"+c+"%')");
    }

    private static ArrayList<IngresoMaterial> consultaSQL(String sql) {
        ArrayList<IngresoMaterial> list = new ArrayList<IngresoMaterial>();
        Connection cn = BDFIBRA.getConnection();

        try {
            IngresoMaterial t;
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                t = new IngresoMaterial();
                t.setDescripcion(rs.getString("nombre"));
                t.setCantidad(rs.getInt("Cantidad"));
                list.add(t);
            }
            cn.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR " + e);
        }
        return list;
    }

    
    
    
    
    

}


