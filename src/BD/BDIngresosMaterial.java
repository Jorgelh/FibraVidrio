/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import Class.CTrabajos;
import Class.IngresoMaterial;
import NOUSO.IngreMateriales;
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

        return consultaSQL("select \n" +
"decode(tipo_material,1,'TUBO CUADRADO',\n" +
"                     2,'TUBO REDONDO',\n" +
"                     3,'TUBO RECTANGULAR',\n" +
"                     4,'TUBO INSOLACION',\n" +
"                     5,'POT ROD',\n" +
"                     6,'PLANCHA',\n" +
"                     7,'TUBO PARA BOBINA REDONDO',\n" +
"                     8,'TUBO PARA BOBINA CUADRADO',\n" +
"                     9,'TUBO PARA BOBINA RECTANGULAR',\n" +
"                     10,'PLANCHA DE ALUMINIO',\n" +
"                     11,'TUBO REDONDO DE ALUMINIO',\n" +
"                     12,'TUBO CUADRADO DE ALUMINIO',\n" +
"                     13,'TUBO RECTANGULAR DE ALUMINIO',\n" +
"                     14,'ACERO',\n" +
"                     15,'BRONCE')||' '||grosor||' '||diametro||' '||\n" +
"                     decode(estilo,1,'SANDBLAST BOTH SIDES NEGRO',\n" +
"                     2,'SANDBLAST BOTH SIDES CLARO',\n" +
"                     3,'NATURAL NEGRO',\n" +
"                     4,'NATURAL CLARO',\n" +
"                     5,'SANDBLAST ONE SIDE NEGRO',\n" +
"                     6,'SANDBLAST ONE SIDE CLARO',\n" +
"                     7,'60-61',8,'O-1',9,'A-2') as \"Descripcion\",cantidad\n" +
"                     from productosmat where upper(decode(productosmat.TIPO_MATERIAL,1,'TUBO CUADRADO',2,'TUBO REDONDO',3,'TUBO RECTANGULAR',4,'TUBO INSOLACION',5,'POT ROD',6,'PLANCHA',7,'TUBO PARA BOBINA REDONDO',8,'TUBO PARA BOBINA CUADRADO',9,'TUBO PARA BOBINA RECTANGULAR',10,'PLANCHA DE ALUMINIO',11,'TUBO REDONDO DE ALUMINIO',12,'TUBO CUADRADO DE ALUMINIO',13,'TUBO RECTANGULAR DE ALUMINIO',14,'ACERO',15,'BRONCE')||' '||grosor||' '||diametro) like upper('"+c+"%')");
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
                t.setDescripcion(rs.getString("Descripcion"));
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


