/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import Class.BuscarHerramientas;
import Class.DescripcionC;
import Class.IngresoMaterial;
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
public class EditComponentesHerramienta {
    
     public static ArrayList<DescripcionC> ListarDescripcion(){
        
         return consultarSQL("select no_descripcion as \"numero\",descripcion as \"descri\" from m_descriherramienta order by no_descripcion");   
    }
    public static ArrayList<DescripcionC> ListarMarca(){
        
         return consultarSQL("select no_marca as \"numero\",decri_marca as \"descri\" from m_marca order by no_marca");   
    }
    public static ArrayList<DescripcionC> ListarMedida(){
        
         return consultarSQL("select no_medida as \"numero\", m_medida as \"descri\" from m_medidas order by no_medida");   
    }
    public static ArrayList<DescripcionC> ListarMaterial(){
        
         return consultarSQL("select no_tipo as \"numero\", m_tipo as \"descri\" from m_material order by no_tipo");   
    }
    
public static ArrayList<DescripcionC> consultarSQL(String sql) {
        ArrayList<DescripcionC> list = new ArrayList<DescripcionC>();
        Connection cn = BDFIBRA.getConnection();
        try {
            DescripcionC f;
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                f = new DescripcionC();
                f.setId(rs.getInt("numero"));
                f.setDescripcion(rs.getString("descri"));
                list.add(f);
            }
            cn.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        }
        return list;
    }


 public static DescripcionC buscarDesc(int id) throws SQLException {
      return BuscarDescri(id, null);
    }
 public static DescripcionC BuscarDescri(int id, DescripcionC p) throws SQLException {
        Connection cnn = BDFIBRA.getConnection();
        PreparedStatement ps = null;
        ps = cnn.prepareStatement("select DESCRIPCION from M_DESCRIHERRAMIENTA where NO_DESCRIPCION=?");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            if (p == null) {
                p = new DescripcionC(){
                };
            }
            p.setId(id);
            p.setDescripcion(rs.getString("DESCRIPCION"));
            
        }
        cnn.close();
        ps.close();
        return p;
    }
 public static void insertarDesc (DescripcionC d) throws SQLException{
    Connection cnn = BDFIBRA.getConnection();
        PreparedStatement ps = null;
    ps= cnn.prepareStatement("insert into M_DESCRIHERRAMIENTA Values(?,?)");
    ps.setInt(1, d.getId());
    ps.setString(2, d.getDescripcion());
    ps.executeUpdate();
    cnn.close();
    ps.close();
    
    }   
 public static boolean actualizarDescripcion(DescripcionC f) throws SQLException {
        Connection cnn = BDFIBRA.getConnection();
        PreparedStatement ps = null;
        ps = cnn.prepareStatement("update M_DESCRIHERRAMIENTA set DESCRIPCION=? where NO_DESCRIPCION =" + f.getId());
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
 
  public static DescripcionC buscarMarca(int id) throws SQLException {
      return buscarMarca(id, null);
    }
  public static DescripcionC buscarMarca(int id, DescripcionC p) throws SQLException {
        Connection cnn = BDFIBRA.getConnection();
        PreparedStatement ps = null;
        ps = cnn.prepareStatement("select DECRI_MARCA from M_MARCA where NO_MARCA=?");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            if (p == null) {
                p = new DescripcionC(){
                };
            }
            p.setId(id);
            p.setDescripcion(rs.getString("DECRI_MARCA"));
            
        }
        cnn.close();
        ps.close();
        return p;
    }
  
  public static void insertarMarca(DescripcionC d) throws SQLException{
    Connection cnn = BDFIBRA.getConnection();
        PreparedStatement ps = null;
    ps= cnn.prepareStatement("insert into M_MARCA Values(?,?)");
    ps.setInt(1, d.getId());
    ps.setString(2, d.getDescripcion());
    ps.executeUpdate();
    cnn.close();
    ps.close();
    
    }   
  public static boolean actualizarMarca(DescripcionC f) throws SQLException {
        Connection cnn = BDFIBRA.getConnection();
        PreparedStatement ps = null;
        ps = cnn.prepareStatement("update M_MARCA set DECRI_MARCA=? where NO_MARCA=" + f.getId());
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
  
  
  
  public static DescripcionC buscarMedida(int id) throws SQLException {
      return buscarMedida(id, null);
    }
  public static DescripcionC buscarMedida(int id, DescripcionC p) throws SQLException {
        Connection cnn = BDFIBRA.getConnection();
        PreparedStatement ps = null;
        ps = cnn.prepareStatement("select M_MEDIDA from M_MEDIDAS where NO_MEDIDA=?");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            if (p == null) {
                p = new DescripcionC(){
                };
            }
            p.setId(id);
            p.setDescripcion(rs.getString("M_MEDIDA"));
            
        }
        cnn.close();
        ps.close();
        return p;
    }
  public static void insertarMedida(DescripcionC d) throws SQLException{
    Connection cnn = BDFIBRA.getConnection();
        PreparedStatement ps = null;
    ps= cnn.prepareStatement("insert into M_MEDIDAS Values(?,?)");
    ps.setInt(1, d.getId());
    ps.setString(2, d.getDescripcion());
    ps.executeUpdate();
    cnn.close();
    ps.close();
    
    }   
  public static boolean actualizarMedida(DescripcionC f) throws SQLException {
        Connection cnn = BDFIBRA.getConnection();
        PreparedStatement ps = null;
        ps = cnn.prepareStatement("update M_MEDIDAS set M_MEDIDA=? where NO_MEDIDA=" + f.getId());
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
  
  
  
  public static DescripcionC buscarMaterial(int id) throws SQLException {
      return buscarMaterial(id, null);
    }
  public static DescripcionC buscarMaterial(int id, DescripcionC p) throws SQLException {
        Connection cnn = BDFIBRA.getConnection();
        PreparedStatement ps = null;
        ps = cnn.prepareStatement("select M_TIPO from M_MATERIAL where NO_TIPO=?");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            if (p == null) {
                p = new DescripcionC(){
                };
            }
            p.setId(id);
            p.setDescripcion(rs.getString("M_TIPO"));
            
        }
        cnn.close();
        ps.close();
        return p;
    }
  public static void insertarMaterial(DescripcionC d) throws SQLException{
    Connection cnn = BDFIBRA.getConnection();
        PreparedStatement ps = null;
    ps= cnn.prepareStatement("insert into M_MATERIAL Values(?,?)");
    ps.setInt(1, d.getId());
    ps.setString(2, d.getDescripcion());
    ps.executeUpdate();
    cnn.close();
    ps.close();
    
    }   
  public static boolean actualizarMaterial(DescripcionC f) throws SQLException {
        Connection cnn = BDFIBRA.getConnection();
        PreparedStatement ps = null;
            ps = cnn.prepareStatement("update M_MATERIAL set M_TIPO=? where NO_TIPO=" + f.getId());
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
  
  
public static ArrayList<BuscarHerramientas>BuscarHerramienta(String a, int b){
        
         return consultarHer("select a.NO, e.DESCRIPCION||' '|| d.M_MEDIDA||' '||c.M_TIPO as \"Descripcion\",filos,cantidad \n" +
                                "FROM M_DESCRIPCION a INNER JOIN "+
                                "M_MATERIAL c on a.NO_TIPO = c.NO_TIPO\n"+
                                "join M_MEDIDAS d on a.NO_MEDIDA = d.NO_MEDIDA \n"+
                                "join M_DESCRIHERRAMIENTA e ON  a.NO_DESCRIPCION = e.NO_DESCRIPCION where e.NO_DESCRIPCION = "+b+" and d.M_MEDIDA like '%"+a+"%' order by e.DESCRIPCION,d.M_MEDIDA,c.M_TIPO");   
    }
    
private static ArrayList<BuscarHerramientas>consultarHer(String sql) {
        ArrayList<BuscarHerramientas> list = new ArrayList<BuscarHerramientas>();
        Connection cn = BDFIBRA.getConnection();
        try {
            BuscarHerramientas f;
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                f = new BuscarHerramientas();
                f.setNo(rs.getInt("NO"));
                f.setDescripcion(rs.getString("Descripcion"));
                f.setFilos(rs.getString("filos"));
                f.setCantidad(rs.getInt("cantidad"));
                list.add(f);
            }
            cn.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        }
        return list;
    }  
  
  

public static BuscarHerramientas buscarHerramienta(int id) throws SQLException {
      return BuscarH(id, null);
    }
 public static BuscarHerramientas BuscarH(int id, BuscarHerramientas p) throws SQLException {
        Connection cnn = BDFIBRA.getConnection();
        PreparedStatement ps = null;
        ps = cnn.prepareStatement("select a.NO, e.DESCRIPCION||' '|| d.M_MEDIDA||' '||c.M_TIPO as \"Descripcion\",cantidad,comentario,a.NOCATALOGO \n" +
                                  "FROM M_DESCRIPCION a INNER JOIN \n" +
                                  "M_MATERIAL c on a.NO_TIPO = c.NO_TIPO\n" +
                                  "join M_MEDIDAS d on a.NO_MEDIDA = d.NO_MEDIDA \n" +
                                  "join M_DESCRIHERRAMIENTA e ON  a.NO_DESCRIPCION = e.NO_DESCRIPCION where a.NO=?");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            if (p == null) {
                p = new BuscarHerramientas(){
                };
            }
            p.setNo(rs.getInt("NO"));
            p.setDescripcion(rs.getString("DESCRIPCION"));
            p.setCatalogo(rs.getString("nocatalogo"));
            p.setCantidad(rs.getInt("cantidad"));
            p.setComentario(rs.getString("comentario"));
        }
        cnn.close();
        ps.close();
        return p;
    }
 
 
  public static void IngresoHerra (BuscarHerramientas l) throws SQLException{
        Connection cn = BDFIBRA.getConnection();
        PreparedStatement ps = null;
        ps = cn.prepareStatement("insert into M_INGRESOHERRAMIENTA values (?,?,?,?,1,?)");
        ps.setInt(1, l.getIdIngresoH());
        ps.setInt(2, l.getNo());
        ps.setInt(3, l.getNomarca());
        ps.setDate(4, new java.sql.Date(l.getFechain().getTime()));
        ps.setInt(5, l.getCantidad());
        ps.executeUpdate();
        cn.close();
        ps.close();
    }
  
  
   public static void DescargaHerra (BuscarHerramientas t) throws SQLException{
        Connection cn = BDFIBRA.getConnection();
        PreparedStatement ps = null;
        ps = cn.prepareStatement("insert into M_DESCARGAS values (?,?,?,?,3)");
        ps.setInt(1, t.getIdIngresoH());
        ps.setInt(2, t.getNo());
        ps.setDate(3, new java.sql.Date(t.getFechain().getTime()));
        ps.setInt(4, t.getCantidad());
        ps.executeUpdate();
        cn.close();
        ps.close();
    }

  
  
}
