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
    
    public static boolean actualizarComponente(DescripcionC f) throws SQLException {
        Connection cnn = BDFIBRA.getConnection();
        PreparedStatement ps = null;
        ps = cnn.prepareStatement("update componentes set descripcion=?,medida=? where idcompo=" + f.getId());
        ps.setString(1, f.getDescripcion());
        ps.setString(2, f.getMedida());
        int rowsUpdated = ps.executeUpdate();
        cnn.close();
        ps.close();
        if (rowsUpdated > 0) {
            return true;
        } else {
            return false;
        }
    }
    
    
    public static boolean actualizarPNComponente(DescripcionC f) throws SQLException {
        Connection cnn = BDFIBRA.getConnection();
        PreparedStatement ps = null;
        ps = cnn.prepareStatement("update PN set idcompo=?, cantidad=? where id_pn =" + f.getId());
        ps.setInt(1, f.getIdcompo());
        ps.setInt(2, f.getCantidad());
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
    
    
    public static DescripcionC buscarDescCompo(int id) throws SQLException {
      return buscarDescripCompo(id, null);
    }
    public static DescripcionC buscarDescripCompo(int id, DescripcionC p) throws SQLException {
        Connection cnn = BDFIBRA.getConnection();
        PreparedStatement ps = null;
        ps = cnn.prepareStatement("select DESCRIPCION,MEDIDA from COMPONENTES where IDCOMPO=?");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            if (p == null) {
                p = new DescripcionC(){
                };
            }
            p.setId(id);
            p.setDescripcion(rs.getString("DESCRIPCION"));
            p.setMedida(rs.getString("MEDIDA"));
            
        }
        cnn.close();
        ps.close();
        return p;
    }
    
    
       
    
    public static DescripcionC buscarEditCompo(int id) throws SQLException {
      return buscarEditCompo(id, null);
    }
    public static DescripcionC buscarEditCompo(int id, DescripcionC p) throws SQLException {
        Connection cnn = BDFIBRA.getConnection();
        PreparedStatement ps = null;
        ps = cnn.prepareStatement("select PN.IDCOMPO,componentes.descripcion||' '||COMPONENTES.MEDIDA as \"compo\",cantidad from PN inner join COMPONENTES on PN.IDCOMPO = COMPONENTES.IDCOMPO where PN.ID_PN=?");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            if (p == null) {
                p = new DescripcionC(){
                };
            }
            p.setId(id);
            p.setDescripcion(rs.getString("compo"));
            p.setCantidad(rs.getInt("cantidad"));
            p.setIdcompo(rs.getInt("idcompo"));
            
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



 public static ArrayList<DescripcionC> ListarDescripComponentes(String a){
        
         return consultarComponentes("SELECT IDCOMPO,DESCRIPCION ||' '| | MEDIDA FROM COMPONENTES where UPPER(DESCRIPCION ||' '| | MEDIDA) LIKE UPPER('"+a+"%') ORDER BY DESCRIPCION");   
    }
   
    
private static ArrayList<DescripcionC> consultarComponentes(String sql) {
        ArrayList<DescripcionC> list = new ArrayList<DescripcionC>();
        Connection cn = BDFIBRA.getConnection();
        try {
            DescripcionC f;
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                f = new DescripcionC();
                f.setId(rs.getInt("IDCOMPO"));
                f.setDescripcion(rs.getString("DESCRIPCION||''||MEDIDA"));
                list.add(f);
            }
            cn.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        }
        return list;
    }




public static ArrayList<DescripcionC> ListarComponentes(String a){
        
         return Componentes("select PN.ID_PN,componentes.descripcion||''||COMPONENTES.MEDIDA,cantidad from PN inner join COMPONENTES on PN.IDCOMPO = COMPONENTES.IDCOMPO where PN = '"+a+"'");   
    }
   
    
private static ArrayList<DescripcionC> Componentes(String sql) {
        ArrayList<DescripcionC> list = new ArrayList<DescripcionC>();
        Connection cn = BDFIBRA.getConnection();
        try {
            DescripcionC f;
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                f = new DescripcionC();
                f.setId(rs.getInt("ID_PN"));
                f.setDescripcion(rs.getString("componentes.descripcion||''||COMPONENTES.MEDIDA"));
                f.setCantidad(rs.getInt("CANTIDAD"));
                list.add(f);
            }
            cn.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        }
        return list;
    }


public static ArrayList<DescripcionC> ListarPN(int a){
        
         return consultarPN("SELECT PN FROM PN where IDCOMPO ="+a+" GROUP by (PN)");   
    }
   
    
private static ArrayList<DescripcionC> consultarPN(String sql) {
        ArrayList<DescripcionC> list = new ArrayList<DescripcionC>();
        Connection cn = BDFIBRA.getConnection();
        try {
            DescripcionC f;
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                f = new DescripcionC();
                f.setPN(rs.getString("PN"));
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
