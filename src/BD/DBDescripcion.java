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
        ps = cnn.prepareStatement("update PN set idcompo=?, cantidad=?, nota=? where id_pn =?");
        ps.setInt(1, f.getIdcompo());
        ps.setInt(2, f.getCantidad());
        ps.setString(3, f.getNota());
        ps.setInt(4, f.getId_pn());
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
    
    
       
    
    public static DescripcionC buscarEditCompo(int id1) throws SQLException {
      return buscarEditCompo(id1, null);
    }
    public static DescripcionC buscarEditCompo(int id, DescripcionC p) throws SQLException {
        Connection cnn = BDFIBRA.getConnection();
        PreparedStatement ps = null;
        try {
        ps = cnn.prepareStatement("select p.id_pn,p.idcompo, decode(c1.idcompo2,1,c2.descripcion||' ID '||c1.ID||' THK '|| c1.THK,\n" +
"                          2,c2.descripcion||' ID '||c1.ID||' ID '||c1.ID2||' THK '||c1.THK,\n" +
"                          3,c2.descripcion||' ID '||c1.ID||' ID '||c1.ID2||' THK '||c1.THK,\n" +
"                          4,c2.descripcion||' THK '||c1.THK,\n" +
"                          5,c2.descripcion||' THK '||c1.THK,\n" +
"                          6,c2.descripcion||' ID '||c1.ID||' LARGO '||c1.largo||' THK '||c1.THK,\n" +
"                          7,c2.descripcion||' '||decode(c1.pinesmat,1,'TC',2,'NIKEL')||' #'||c1.nume||' LARGO '||c1.largo||' APLASTADO '||c1.aplastado,\n" +
"                          8,c2.descripcion||' RADIO '||c1.radio,\n" +
"                          9,c2.descripcion||' ID '||c1.ID||' THK '||c1.THK,\n" +
"                          10,c2.descripcion||' ID '||c1.ID||' ID '||c1.ID2||' THK '||c1.THK,\n" +
"                          11,c2.descripcion||' ID '||c1.ID||' ID '||c1.ID2||' THK '||c1.THK,\n" +
"                          12,c2.descripcion||' '||decode(c1.inserto,1,'CB252-6',2,'CB440-4',3,'CBL 440-6',4,'CB 440-12',5,'CBL 632-8',6,'CBL 832-8'),\n" +
"                          13,c2.descripcion||' OD '||c1.od||' ID '||c1.id||' THK '||c1.thk,\n" +
"                          14,c2.descripcion||' OD '||c1.od||' ID '||c1.id||' THK '||c1.thk,\n" +
"                          15,c2.descripcion||' THK '||c1.thk,\n" +
"                          16,c2.descripcion||' THK '||c1.thk,\n" +
"                          17,c2.descripcion||' THK '||c1.thk,\n" +
"                          18,c2.descripcion||' THK '||c1.thk,\n" +
"                          19,c2.descripcion||' ID '||c1.ID||' ID '||c1.ID2||' THK '||c1.THK,"+ 
"                          20,c2.descripcion,"+
"                          21,c2.descripcion||' OD '||c1.OD||' OD '||c1.OD2||' THK '||c1.THK,"+
"                          22,c2.descripcion||' OD '||c1.OD||' OD '||c1.OD2||' THK '||c1.THK,"+
"                          23,c2.descripcion||' OD '||c1.OD||' THK '||c1.THK||' HT '||c1.ht,"+
"                          24,c2.descripcion||' OD '||c1.OD||' THK '||c1.THK,"+
"                          25,c2.descripcion||' ID '||c1.id||' OD '||c1.od||' THK '||c1.thk,"+
"                          26,c2.descripcion||' ID '||c1.ID||' ID '||c1.ID2||' THK '||c1.THK) as Descripcion,p.cantidad,p.nota\n" +
"                          from componentes c1 inner join componentes2 c2 on c1.idcompo2 = c2.idcompo2 join pn p on c1.idcompo = p.idcompo where p.id_pn ="+id);
        //ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            if (p == null) {
                p = new DescripcionC(){
                };
            }
            p.setIdcompo(rs.getInt("idcompo"));
            p.setDescripcion(rs.getString("Descripcion"));
            p.setCantidad(rs.getInt("cantidad"));
            p.setNota(rs.getString("nota"));
            p.setId_pn(rs.getInt("id_pn"));
        }
        } catch (Exception e) {
            System.out.println("ERRRO MIERDA "+e);
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
        
         return Componentes("select p.id_pn,c1.idcompo, decode(c1.idcompo2,1,c2.descripcion||' ID '||c1.ID||' THK '|| c1.THK,\n" +
"                          2,c2.descripcion||' ID '||c1.ID||' ID '||c1.ID2||' THK '||c1.THK,\n" +
"                          3,c2.descripcion||' ID '||c1.ID||' ID '||c1.ID2||' THK '||c1.THK,\n" +
"                          4,c2.descripcion||' THK '||c1.THK,\n" +
"                          5,c2.descripcion||' THK '||c1.THK,\n" +
"                          6,c2.descripcion||' ID '||c1.ID||' LARGO '||c1.largo||' THK '||c1.THK,\n" +
"                          7,c2.descripcion||' '||decode(c1.pinesmat,1,'TC',2,'NIKEL')||' #'||c1.nume||' LARGO '||c1.largo||' APLASTADO '||c1.aplastado,\n" +
"                          8,c2.descripcion||' RADIO '||c1.radio,\n" +
"                          9,c2.descripcion||' ID '||c1.ID||' THK '||c1.THK,\n" +
"                          10,c2.descripcion||' ID '||c1.ID||' ID '||c1.ID2||' THK '||c1.THK,\n" +
"                          11,c2.descripcion||' ID '||c1.ID||' ID '||c1.ID2||' THK '||c1.THK,\n" +
"                          12,c2.descripcion||' '||decode(c1.inserto,1,'CB252-6',2,'CB440-4',3,'CBL 440-6',4,'CB 440-12',5,'CBL 632-8',6,'CBL 832-8'),\n" +
"                          13,c2.descripcion||' OD '||c1.od||' ID '||c1.id||' THK '||c1.thk,\n" +
"                          14,c2.descripcion||' OD '||c1.od||' ID '||c1.id||' THK '||c1.thk,\n" +
"                          15,c2.descripcion||' THK '||c1.thk,\n" +
"                          16,c2.descripcion||' THK '||c1.thk,\n" +
"                          17,c2.descripcion||' THK '||c1.thk,\n" +
"                          18,c2.descripcion||' THK '||c1.thk,\n" +
"                          19,c2.descripcion||' ID '||c1.ID||' ID '||c1.ID2||' THK '||c1.THK,"+ 
"                          20,c2.descripcion,"+
"                          21,c2.descripcion||' OD '||c1.OD||' OD '||c1.OD2||' THK '||c1.THK,"+
"                          22,c2.descripcion||' OD '||c1.OD||' OD '||c1.OD2||' THK '||c1.THK,"+
"                          23,c2.descripcion||' OD '||c1.OD||' THK '||c1.THK||' HT '||c1.ht,"+
"                          24,c2.descripcion||' OD '||c1.OD||' THK '||c1.THK,"+
"                          25,c2.descripcion||' ID '||c1.id||' OD '||c1.od||' THK '||c1.thk,"+
"                          26,c2.descripcion||' ID '||c1.ID||' ID '||c1.ID2||' THK '||c1.THK) as Descripcion,p.cantidad\n" +
"                          from componentes c1 inner join componentes2 c2 on c1.idcompo2 = c2.idcompo2 join pn p on c1.idcompo = p.idcompo where p.pn = '"+a+"'");   
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
                f.setId_pn(rs.getInt("id_pn"));
                f.setIdcompo(rs.getInt("idcompo"));
                f.setDescripcion(rs.getString("descripcion"));
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
   

public static ArrayList<DescripcionC> ListarComponentesNombre(String a){
        
         return ComponentesNombre(" select decode(c1.idcompo2,1,c2.descripcion||' ID '||c1.ID||' THK '|| c1.THK,\n" +
"                          2,c2.descripcion||' ID '||c1.ID||' ID '||c1.ID2||' THK '||c1.THK,\n" +
"                          3,c2.descripcion||' ID '||c1.ID||' ID '||c1.ID2||' THK '||c1.THK,\n" +
"                          4,c2.descripcion||' THK '||c1.THK,\n" +
"                          5,c2.descripcion||' THK '||c1.THK,\n" +
"                          6,c2.descripcion||' ID '||c1.ID||' LARGO '||c1.largo||' THK '||c1.THK,\n" +
"                          7,c2.descripcion||' '||decode(c1.pinesmat,1,'TC',2,'NIKEL')||' #'||c1.nume||' LARGO '||c1.largo||' APLASTADO '||c1.aplastado,\n" +
"                          8,c2.descripcion||' RADIO '||c1.radio,\n" +
"                          9,c2.descripcion||' ID '||c1.ID||' THK '||c1.THK,\n" +
"                          10,c2.descripcion||' ID '||c1.ID||' ID '||c1.ID2||' THK '||c1.THK,\n" +
"                          11,c2.descripcion||' ID '||c1.ID||' ID '||c1.ID2||' THK '||c1.THK,\n" +
"                          12,c2.descripcion||' '||decode(c1.inserto,1,'CB252-6',2,'CB440-4',3,'CBL 440-6',4,'CB 440-12',5,'CBL 632-8',6,'CBL 832-8'),\n" +
"                          13,c2.descripcion||' OD '||c1.od||' ID '||c1.id||' THK '||c1.thk,\n" +
"                          14,c2.descripcion||' OD '||c1.od||' ID '||c1.id||' THK '||c1.thk,\n" +
"                          15,c2.descripcion||' THK '||c1.thk,\n" +
"                          16,c2.descripcion||' THK '||c1.thk,\n" +
"                          17,c2.descripcion||' THK '||c1.thk,\n" +
"                          18,c2.descripcion||' THK '||c1.thk,\n" +
"                          19,c2.descripcion||' ID '||c1.ID||' ID '||c1.ID2||' THK '||c1.THK,\n" +
"                          20,c2.descripcion,\n" +
"                          21,c2.descripcion||' OD '||c1.OD||' OD '||c1.OD2||' THK '||c1.THK,\n" +
"                          22,c2.descripcion||' OD '||c1.OD||' OD '||c1.OD2||' THK '||c1.THK,\n" +
"                          23,c2.descripcion||' OD '||c1.OD||' THK '||c1.THK||' HT '||c1.ht,\n" +
"                          24,c2.descripcion||' OD '||c1.OD||' THK '||c1.THK,\n" +
"                          25,c2.descripcion||' ID '||c1.id||' OD '||c1.od||' THK '||c1.thk,\n" +
"                          26,c2.descripcion||' ID '||c1.ID||' ID '||c1.ID2||' THK '||c1.THK) as Descripcion\n" +
"                          from componentes c1 inner join componentes2 c2 on c1.idcompo2 = c2.idcompo2\n" +
"                          where upper(decode(c1.idcompo2,1,c2.descripcion||' ID '||c1.ID||' THK '|| c1.THK,\n" +
"                          2,c2.descripcion||' ID '||c1.ID||' ID '||c1.ID2||' THK '||c1.THK,\n" +
"                          3,c2.descripcion||' ID '||c1.ID||' ID '||c1.ID2||' THK '||c1.THK,\n" +
"                          4,c2.descripcion||' THK '||c1.THK,\n" +
"                          5,c2.descripcion||' THK '||c1.THK,\n" +
"                          6,c2.descripcion||' ID '||c1.ID||' LARGO '||c1.largo||' THK '||c1.THK,\n" +
"                          7,c2.descripcion||' '||decode(c1.pinesmat,1,'TC',2,'NIKEL')||' #'||c1.nume||' LARGO '||c1.largo||' APLASTADO '||c1.aplastado,\n" +
"                          8,c2.descripcion||' RADIO '||c1.radio,\n" +
"                          9,c2.descripcion||' ID '||c1.ID||' THK '||c1.THK,\n" +
"                          10,c2.descripcion||' ID '||c1.ID||' ID '||c1.ID2||' THK '||c1.THK,\n" +
"                          11,c2.descripcion||' ID '||c1.ID||' ID '||c1.ID2||' THK '||c1.THK,\n" +
"                          12,c2.descripcion||' '||decode(c1.inserto,1,'CB252-6',2,'CB440-4',3,'CBL 440-6',4,'CB 440-12',5,'CBL 632-8',6,'CBL 832-8'),\n" +
"                          13,c2.descripcion||' OD '||c1.od||' ID '||c1.id||' THK '||c1.thk,\n" +
"                          14,c2.descripcion||' OD '||c1.od||' ID '||c1.id||' THK '||c1.thk,\n" +
"                          15,c2.descripcion||' THK '||c1.thk,\n" +
"                          16,c2.descripcion||' THK '||c1.thk,\n" +
"                          17,c2.descripcion||' THK '||c1.thk,\n" +
"                          18,c2.descripcion||' THK '||c1.thk,\n" +
"                          19,c2.descripcion||' ID '||c1.ID||' ID '||c1.ID2||' THK '||c1.THK,\n" +
"                          20,c2.descripcion,\n" +
"                          21,c2.descripcion||' OD '||c1.OD||' OD '||c1.OD2||' THK '||c1.THK,\n" +
"                          22,c2.descripcion||' OD '||c1.OD||' OD '||c1.OD2||' THK '||c1.THK,\n" +
"                          23,c2.descripcion||' OD '||c1.OD||' THK '||c1.THK||' HT '||c1.ht,\n" +
"                          24,c2.descripcion||' OD '||c1.OD||' THK '||c1.THK,\n" +
"                          25,c2.descripcion||' ID '||c1.id||' OD '||c1.od||' THK '||c1.thk,\n" +
"                          26,c2.descripcion||' ID '||c1.ID||' ID '||c1.ID2||' THK '||c1.THK)) like upper('"+a+"%')");   
    }

    
private static ArrayList<DescripcionC> ComponentesNombre(String a) {
        ArrayList<DescripcionC> list = new ArrayList<DescripcionC>();
        Connection cn = BDFIBRA.getConnection();
        try {
            DescripcionC s;
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery(a);
            while (rs.next()) {
                s = new DescripcionC();
                s.setDescripcion(rs.getString("descripcion"));
                list.add(s);
            }
            cn.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        }
        return list;
    }



public static ArrayList<DescripcionC> ListarComponentesExistentes(String c){
        
         return ComponentesExistentes("select tp.idcompo,tp.idtrabajopartes,decode(c1.idcompo2,1,c2.descripcion||' ID '||c1.ID||' THK '|| c1.THK,\n" +
"                          2,c2.descripcion||' ID '||c1.ID||' ID '||c1.ID2||' THK '||c1.THK,\n" +
"                          3,c2.descripcion||' ID '||c1.ID||' ID '||c1.ID2||' THK '||c1.THK,\n" +
"                          4,c2.descripcion||' THK '||c1.THK,\n" +
"                          5,c2.descripcion||' THK '||c1.THK,\n" +
"                          6,c2.descripcion||' ID '||c1.ID||' LARGO '||c1.largo||' THK '||c1.THK,\n" +
"                          7,c2.descripcion||' '||decode(c1.pinesmat,1,'TC',2,'NIKEL')||' #'||c1.nume||' LARGO '||c1.largo||' APLASTADO '||c1.aplastado,\n" +
"                          8,c2.descripcion||' RADIO '||c1.radio,\n" +
"                          9,c2.descripcion||' ID '||c1.ID||' THK '||c1.THK,\n" +
"                          10,c2.descripcion||' ID '||c1.ID||' ID '||c1.ID2||' THK '||c1.THK,\n" +
"                          11,c2.descripcion||' ID '||c1.ID||' ID '||c1.ID2||' THK '||c1.THK,\n" +
"                          12,c2.descripcion||' '||decode(c1.inserto,1,'CB252-6',2,'CB440-4',3,'CBL 440-6',4,'CB 440-12',5,'CBL 632-8',6,'CBL 832-8'),\n" +
"                          13,c2.descripcion||' OD '||c1.od||' ID '||c1.id||' THK '||c1.thk,\n" +
"                          14,c2.descripcion||' OD '||c1.od||' ID '||c1.id||' THK '||c1.thk,\n" +
"                          15,c2.descripcion||' THK '||c1.thk,\n" +
"                          16,c2.descripcion||' THK '||c1.thk,\n" +
"                          17,c2.descripcion||' THK '||c1.thk,\n" +
"                          18,c2.descripcion||' THK '||c1.thk,\n" +
"                          19,c2.descripcion||' ID '||c1.ID||' ID '||c1.ID2||' THK '||c1.THK,"+ 
"                          20,c2.descripcion,"+
"                          21,c2.descripcion||' OD '||c1.OD||' OD '||c1.OD2||' THK '||c1.THK,"+
"                          22,c2.descripcion||' OD '||c1.OD||' OD '||c1.OD2||' THK '||c1.THK,"+
"                          23,c2.descripcion||' OD '||c1.OD||' THK '||c1.THK||' HT '||c1.ht,"+
"                          24,c2.descripcion||' OD '||c1.OD||' THK '||c1.THK,"+
"                          25,c2.descripcion||' ID '||c1.id||' OD '||c1.od||' THK '||c1.thk,"+
"                          26,c2.descripcion||' ID '||c1.ID||' ID '||c1.ID2||' THK '||c1.THK) as Descripcion,tp.cantidad as cantidadin,\n" +
"        b.CANTIDAD\n" +
"        from ingreso_trabajo inner join TRABAJO_PARTES tp on ingreso_trabajo.NO_TRABAJO = tp.no_trabajo \n" +
"        join componentes c1 on c1.IDCOMPO = tp.idcompo \n" +
"        join BITACORAPARTES b on tp.idtrabajopartes = b.IDTRABAJOPARTES \n" +
"        join componentes2 c2 on c1.idcompo2 = c2.idcompo2 where ingreso_trabajo.JOB ='"+c+"'");   
    }
   
    
private static ArrayList<DescripcionC> ComponentesExistentes(String sql) {
        ArrayList<DescripcionC> list = new ArrayList<DescripcionC>();
        Connection cn = BDFIBRA.getConnection();
        try {
            DescripcionC f;
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                f = new DescripcionC();
                f.setId_pn(rs.getInt("idtrabajopartes"));
                f.setDescripcion(rs.getString("descripcion"));
                f.setCantidad(rs.getInt("CANTIDAD"));
                f.setIdcompo(rs.getInt("idcompo"));
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
