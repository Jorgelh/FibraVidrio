/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import static BD.NuevoProducto.IngresoMat;
import Class.IngresoMat;
import Class.IngresoMaterial;
import Class.nuevo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Jorge Lopez
 */
public class NuevoProducto {
    
    public static void IngresoProducto (nuevo l) throws SQLException{
        Connection cn = BDFIBRA.getConnection();
        PreparedStatement ps = null;
        ps = cn.prepareStatement("insert into productosmat values (?,?,?,?,0,?)");
        ps.setInt(1, l.getCodigo());
        ps.setString(2, l.getDiametro());
        ps.setString(3, l.getGrosor());
        ps.setInt(4, l.getTipomaterial());
        ps.setInt(5, l.getEstilo());
        ps.executeUpdate();
        cn.close();
        ps.close();
    }
    
     public static ArrayList<nuevo> ListarProductosDesc(String a){
        
         return ListarProductos("select codigo,decode(tipo_material,1,'TUBO CUADRADO',2,'TUBO REDONDO',3,'TUBO RECTANGULAR',4,'TUBO INSOLACION',5,'POT ROD',6,'PLANCHA')||' '||diametro||' '||grosor||' '||decode(estilo,1,'SANDBLAST BOTH SIDES NEGRO',2,'SANDBLAST BOTH SIDES CLARO',3,'NATURAL NEGRO',4,'NATURAL CLARO',5,'SANDBLAST ONE SIDE NEGRO',6,'SANDBLAST ONE SIDE CLARO') as \"Descripcion\" from productosmat where upper(decode(tipo_material,1,'TUBO CUADRADO',2,'TUBO REDONDO',3,'TUBO RECTANGULAR',4,'TUBO INSOLACION',5,'POT ROD',6,'PLANCHA')||' '||diametro||' '||grosor) like upper('"+a+"%')");   
    }
    

     
     
     
    public static ArrayList<nuevo> ListarProductos(){
        
         return ListarProductos("select codigo,decode(tipo_material,1,'TUBO CUADRADO',2,'TUBO REDONDO',3,'TUBO RECTANGULAR',4,'TUBO INSOLACION',5,'POT ROD',6,'PLANCHA')||' '||diametro||' '||grosor as \"Descripcion\" from productosmat order by codigo");   
    }
   
    
private static ArrayList<nuevo> ListarProductos(String sql) {
        ArrayList<nuevo> list = new ArrayList<nuevo>();
        Connection cn = BDFIBRA.getConnection();
        try {
            nuevo f;
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                f = new nuevo();
                f.setCodigo(rs.getInt("codigo"));
                f.setDescripcion(rs.getString("descripcion"));
                list.add(f);
            }
            cn.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        }
        return list;
    }
    

 public static ArrayList<IngresoMat> ListarIngresos(int a){
        
         return ListarIngre("select id_ingreso,pn,job,po,cantidad from ingresosmat where codigo = "+a+" order by id_ingreso");   
    }
   
private static ArrayList<IngresoMat> ListarIngre(String sql) {
        ArrayList<IngresoMat> list = new ArrayList<IngresoMat>();
        Connection cn = BDFIBRA.getConnection();
        try {
            IngresoMat f;
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                f = new IngresoMat();
                f.setIDIngreso(rs.getInt("id_ingreso"));
                f.setPn(rs.getString("pn"));
                f.setJob(rs.getString("job"));
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


public static nuevo Buscarpro (int id)  throws SQLException{
        return BuscarProducto(id,null);
    }
        
    public static nuevo BuscarProducto(int id,nuevo t) throws SQLException{
        
        Connection cn = BDFIBRA.getConnection();
        PreparedStatement ps =null;
        ps = cn.prepareStatement("select decode(tipo_material,1,'TUBO CUADRADO',2,'TUBO REDONDO',3,'TUBO RECTANGULAR',4,'TUBO INSOLACION',5,'POT ROD',6,'PLANCHA')||' '||diametro||' '||grosor \"descri\",productosmat.codigo,cantidad from productosmat where codigo ="+id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()){
             if (t == null){
             t = new nuevo(){};
        }
             t.setCodigo(rs.getInt("codigo"));
             t.setDescripcion(rs.getString("descri"));
             //t.setDescripcion(rs.getString("decode(tipo_material,1,'TUBO CUADRADO',2,'TUBO REDONDO',3,'TUBO RECTANGULAR',4,'PLANCHA')||' '||diametro||' '||grosor"));
             t.setCantidad(rs.getInt("cantidad"));
             
    }
      cn.close();
      ps.close();
      return t;
              
    }
    
    
    public static void IngresoMat (IngresoMat l) throws SQLException{
        Connection cn = BDFIBRA.getConnection();
        PreparedStatement ps = null;
        ps = cn.prepareStatement("insert into ingresosmat values (?,?,?,?,?,?,?,?,?)");
        ps.setInt(1, l.getIDIngreso());
        ps.setInt(2, l.getCodigo());
        ps.setString(3, l.getPn());
        ps.setString(4, l.getJob());
        ps.setString(5, l.getPo());
        ps.setDate(6, new java.sql.Date(l.getFecha().getTime()));
        ps.setString(7, l.getNota());
        ps.setInt(8, l.getCantidad());
        ps.setInt(9, l.getCantidad());
        ps.executeUpdate();
        cn.close();
        ps.close();
    }

    public static void IngresoDesc (IngresoMat l) throws SQLException{
        Connection cn = BDFIBRA.getConnection();
        PreparedStatement ps = null;
        ps = cn.prepareStatement("insert into DESCARGASMAT values (?,?,?,?,?,?,?)");
        ps.setInt(1, l.getIdDesc());
        ps.setInt(2, l.getIDIngreso());
        ps.setDate(3, new java.sql.Date(l.getFecha().getTime()));
        ps.setInt(4, l.getCantidad());
        ps.setString(5, l.getJob());
        ps.setString(6, l.getPn());
        ps.setString(7, l.getNota());
        ps.executeUpdate();
        cn.close();
        ps.close();
    }
    
    
    
    
    
}
