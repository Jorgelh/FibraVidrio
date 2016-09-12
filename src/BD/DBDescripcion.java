/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import Class.DescripcionC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author jluis
 */
public abstract class DBDescripcion {
    
    public static void insertarDesc (DescripcionC d) throws SQLException{
    Connection cnn = BDFIBRA.getConnection();
        PreparedStatement ps = null;
    ps= cnn.prepareStatement("insert into descripcion (iddesc,nombre,cantidad) Values(?,?,0)");
    ps.setInt(1, d.getId());
    ps.setString(2, d.getDescripcion());
    ps.executeUpdate();
    cnn.close();
    ps.close();
    
    }
    
  /*  public static ArrayList<Medida> listarProductoPorCodigo(String codigo) {
        return listar("nProCodigo", codigo + "%", "like");
    }*/
    public static boolean actualizarFamilia(DescripcionC f) throws SQLException {
        Connection cnn = BDFIBRA.getConnection();
        PreparedStatement ps = null;
        ps = cnn.prepareStatement("update descripcion set nombre=? where iddesc =" + f.getId());
        ps.setString(1, f.getDescripcion());
        int rowsUpdated = ps.executeUpdate();
        cnn.close();
        ps.close();
        if (rowsUpdated > 0) {
            return true;
        } else {
            return false;
        }
    }
    
    
    public static DescripcionC buscarDesc(int id) throws SQLException {
      return buscarDescrip(id, null);
    }
    public static DescripcionC buscarDescrip(int id, DescripcionC p) throws SQLException {
        Connection cnn = BDFIBRA.getConnection();
        PreparedStatement ps = null;
        ps = cnn.prepareStatement("select nombre from descripcion where iddesc=?");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            if (p == null) {
                p = new DescripcionC(){
                };
            }
            p.setId(id);
            p.setDescripcion(rs.getString("nombre"));
            
        }
        cnn.close();
        ps.close();
        return p;
    }
    

    public static ArrayList<DescripcionC> ListarDescrip(){
        
         return consultarSQL("select iddesc,nombre from descripcion order by iddesc");   
    }
   
    
private static ArrayList<DescripcionC> consultarSQL(String sql) {
        ArrayList<DescripcionC> list = new ArrayList<DescripcionC>();
        Connection cn = BDFIBRA.getConnection();
        try {
            DescripcionC f;
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                f = new DescripcionC();
                f.setId(rs.getInt("iddesc"));
                f.setDescripcion(rs.getString("nombre"));
                list.add(f);
            }
            cn.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        }
        return list;
    }


    
}
