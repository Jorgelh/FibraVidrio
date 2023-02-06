/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassProductos;

import BD.BDFIBRA;
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
public class IngresoConsultaProductos {
    
    public static ArrayList<ProductosTaller> ListarTodosProductos(String a,String b) {

        return consultaTrabajo("select codigo_ingre,descripcion from TALLER_PRODUCTOS where descripcion like upper('"+a+"%') and codigo_ingre like upper('"+b+"%')");
    }
    
    
    public static ArrayList<ProductosTaller> ListarTodosProductosDescargas(String a,String b) {

        return consultaTrabajo("select p.codigo_ingre,p.descripcion from TALLER_PRODUCTOS p inner join productos_taller_ingresos i on p.codigo_ingre = i.codigo_ingre where descripcion like upper('"+a+"%') and i.codigo_ingre like upper('"+b+"%') GROUP BY p.codigo_ingre,p.descripcion");
    }
    
    public static ArrayList<ProductosTaller> ListarTodosDescarga(String a,String b) {

        return consultaTrabajo("select p.codigo_ingre,p.descripcion from  productos_taller_ingresos i  inner join TALLER_PRODUCTOS p on p.codigo_ingre = i.codigo_ingre join procutos_taller_descarga d on i.id_ingreso_pro = d.id_ingreso_pro where p.descripcion like upper('"+a+"%') and i.codigo_ingre like upper('"+b+"%') GROUP BY p.codigo_ingre,p.descripcion");
    }
    
    
    private static ArrayList<ProductosTaller> consultaTrabajo(String sql) {
        ArrayList<ProductosTaller> list = new ArrayList<ProductosTaller>();
        Connection cn = BDFIBRA.getConnection();
        try {
            ProductosTaller t;
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                t = new ProductosTaller();
                t.setCodigo_ingre(rs.getInt("codigo_ingre"));
                t.setDescripcion(rs.getString("descripcion"));
                list.add(t);
                }
            cn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR " + e);
        }
        return list;
    }
    
public static ArrayList<ProductosTaller> ListarTodosProductosIngresados(int a) {

    

    
        return consultaIngresos("select id_ingreso_pro,PN,JOB,PO,to_char(fecha_ingreso,'dd/mm/yyyy') as fecha,invoice,cantidad,decode(estandar,1,'MIL-PRF-27',2,'MIL-STD-981') as estandar,cantidad_ingreso from PRODUCTOS_TALLER_INGRESOS where CODIGO_INGRE ="+a);
    }

    private static ArrayList<ProductosTaller> consultaIngresos(String sql) {
        ArrayList<ProductosTaller> list = new ArrayList<ProductosTaller>();
        Connection cn = BDFIBRA.getConnection();
        try {
            ProductosTaller t;
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                t = new ProductosTaller();
                t.setId_ingreso(rs.getInt("id_ingreso_pro"));
                t.setFechaIngre(rs.getString("fecha"));
                t.setPO(rs.getString("PO"));
                t.setINVOICE(rs.getString("invoice"));
                t.setCANTIDAD(rs.getInt("cantidad"));
                t.setEstandarStr(rs.getString("estandar"));
                t.setCANTIDADINGRESO(rs.getInt("cantidad_ingreso"));
                list.add(t);
                }
            cn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR " + e);
        }
        return list;
    }    
 
public static ArrayList<ProductosTaller> ListarTodosProductosIngresadosConsulta(int a) {

    

    
        return consultaIngresosCon("select id_ingreso_pro,PN,JOB,PO,to_char(fecha_ingreso,'dd/mm/yyyy') as fecha,invoice,cantidad,cantidad_ingreso,decode(estandar,1,'MIL-PRF-27',2,'MIL-STD-981') as estandar from PRODUCTOS_TALLER_INGRESOS where CODIGO_INGRE ="+a);
    }

    private static ArrayList<ProductosTaller> consultaIngresosCon(String sql) {
        ArrayList<ProductosTaller> list = new ArrayList<ProductosTaller>();
        Connection cn = BDFIBRA.getConnection();
        try {
            ProductosTaller t;
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                t = new ProductosTaller();
                t.setId_ingreso(rs.getInt("id_ingreso_pro"));
                t.setFechaIngre(rs.getString("fecha"));
                t.setPO(rs.getString("PO"));
                t.setINVOICE(rs.getString("invoice"));
                t.setCANTIDAD(rs.getInt("cantidad"));
                t.setCANTIDADINGRESO(rs.getInt("cantidad_ingreso"));
                t.setEstandarStr(rs.getString("estandar"));
                list.add(t);
                }
            cn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR " + e);
        }
        return list;
    }        
    
    
    
    
    
    
    
    
    
    
  public static ProductosTaller BuscarProducto (int id)  throws SQLException{
        return Buscar(id,null);
    }
        
    public static ProductosTaller Buscar(int id,ProductosTaller t) throws SQLException{
        
        Connection cn = BDFIBRA.getConnection();
        PreparedStatement ps =null;
        ps = cn.prepareStatement("select codigo_ingre,descripcion from taller_productos where codigo_ingre ="+id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()){
             if (t == null){
             t = new ProductosTaller(){};
        }
             t.setCodigo_ingre(rs.getInt("codigo_ingre"));
             t.setDescripcion(rs.getString("descripcion"));
    }
      cn.close();
      ps.close();
      return t;
              
    }
    
    
    public static ProductosTaller BuscarIngreso (int id)  throws SQLException{
        return Buscarin(id,null);
    }
        
    public static ProductosTaller Buscarin(int id,ProductosTaller t) throws SQLException{
        
        Connection cn = BDFIBRA.getConnection();
        PreparedStatement ps =null;
        ps = cn.prepareStatement("select (select sum(cantidad) from productos_taller_ingresos where codigo_ingre = "+id+" and estandar = 2) as cantidad1,(select sum(cantidad) from productos_taller_ingresos where codigo_ingre = "+id+" and estandar = 1)as cantidad2,(select sum(cantidad) from productos_taller_ingresos where codigo_ingre = "+id+")as cantidadtotal from dual");
        ResultSet rs = ps.executeQuery();
        if (rs.next()){
             if (t == null){
             t = new ProductosTaller(){};
        }
             t.setCANTIDAD(rs.getInt("cantidad1"));
             t.setCANTIDADINGRESO(rs.getInt("cantidad2"));
             t.setCantidad(rs.getInt("cantidadtotal"));
    }
      cn.close();
      ps.close();
      return t;
              
    }
    
    public static ProductosTaller BuscarIngresoTodo (int id)  throws SQLException{
        return BuscarinTo(id,null);
    }
        
    public static ProductosTaller BuscarinTo(int id,ProductosTaller t) throws SQLException{
        
        Connection cn = BDFIBRA.getConnection();
        PreparedStatement ps =null;
        ps = cn.prepareStatement("select id_ingreso_pro,to_char(fecha_ingreso,'dd/mm/yyyy') as fecha,decode(PO,null,' ',PO) as PO,decode(INVOICE,null,' ',INVOICE) as INVOICE,cantidad,decode(estandar,1,'MIL-PRF-27',2,'MIL-STD-981') as estandar,nota,codigo_ingre,conta from productos_taller_ingresos where id_ingreso_pro = "+id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()){
             if (t == null){
             t = new ProductosTaller(){};
        }
             t.setFechaIngre(rs.getString("fecha"));
             t.setPO(rs.getString("PO"));
             t.setINVOICE(rs.getString("INVOICE"));
             t.setCANTIDAD(rs.getInt("cantidad"));
             t.setEstandarStr(rs.getString("estandar"));
             t.setId_ingreso(rs.getInt("id_ingreso_pro"));
             t.setNOTA(rs.getString("nota"));
             t.setCodigo_ingre(rs.getInt("codigo_ingre"));
             t.setConta(rs.getInt("conta"));
    }
      cn.close();
      ps.close();
      return t;
              
    }
    
    
    
    public static void IngresoProductos (ProductosTaller t) throws SQLException{
        Connection cn = BDFIBRA.getConnection();
        PreparedStatement ps = null;
        ps = cn.prepareStatement("insert into PRODUCTOS_TALLER_INGRESOS values (INGRESOPRODUCTOS.NEXTVAL,?,?,?,?,?,?,?,?,?,?,sysdate,?,?,?,?)");
        ps.setInt(1, t.getCodigo_ingre());
        ps.setString(2, t.getPN());
        ps.setString(3, t.getJOB());
        ps.setString(4, t.getPO());
        ps.setDate(5, new java.sql.Date(t.getFechaI().getTime()));
        ps.setString(6, t.getINVOICE());
        ps.setInt(7, t.getCANTIDAD());
        ps.setInt(8, t.getCANTIDADINGRESO());
        ps.setInt(9, t.getESTANDAR());
        ps.setString(10, t.getNOTA());
        ps.setDouble(11, t.getPrecio());
        ps.setInt(12, t.getConta());
        ps.setDate(13, new java.sql.Date(t.getFechaPoliza().getTime())); 
        ps.setInt(14, t.getProcedencia());
        ps.executeUpdate();
        cn.close();
        ps.close();
    }
    
    public static void IngresoDescarga (ProductosTaller l) throws SQLException{
        Connection cn = BDFIBRA.getConnection();
        PreparedStatement ps = null;
        ps = cn.prepareStatement("insert into PROCUTOS_TALLER_DESCARGA values (ingresodesc.nextval,?,?,?,?,?,?,?,?,?)");
        ps.setInt(1, l.getId_ingreso());
        ps.setDate(2, new java.sql.Date(l.getFechaI().getTime()));
        ps.setInt(3, l.getCANTIDAD());
        ps.setString(4, l.getPN());
        ps.setString(5, l.getJOB());
        ps.setString(6, l.getCliente());
        ps.setString(7, l.getNOTA());
        ps.setInt(8, l.getDepartamento());
        ps.setInt(9, l.getEntregado());
        ps.executeUpdate();
        cn.close();
        ps.close();
    }
    
    
    
    public static ArrayList<ProductosTaller> ListarDescargas(int a) {

        return consultaDescargas("select to_char(i.fecha_ingreso,'dd/mm/yyyy') as fecha_ingreso,i.po,i.cantidad_ingreso,i.cantidad as cantidad2,to_char(d.fecha,'dd/mm/yyyy') as fecha_descarga,d.cantidad,d.pn,d.job,d.nota from procutos_taller_descarga d inner join productos_taller_ingresos i on d.id_ingreso_pro = i.id_ingreso_pro where codigo_ingre ="+a);
    }
    
    private static ArrayList<ProductosTaller> consultaDescargas(String sql) {
        ArrayList<ProductosTaller> list = new ArrayList<ProductosTaller>();
        Connection cn = BDFIBRA.getConnection();
        try {
            ProductosTaller t;
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                t = new ProductosTaller();
                t.setFechaIngre(rs.getString("fecha_ingreso"));
                t.setPO(rs.getString("po"));
                t.setCANTIDADINGRESO(rs.getInt("cantidad_ingreso"));
                t.setFechaDesca(rs.getString("fecha_descarga"));
                t.setCantidad(rs.getInt("cantidad"));
                t.setPN(rs.getString("pn"));
                t.setJOB(rs.getString("job"));
                t.setCANTIDAD(rs.getInt("cantidad2"));
                t.setNOTA(rs.getString("nota"));
                
                list.add(t);
                }
            cn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR " + e);
        }
        return list;
    }
    
    public static ArrayList<ProductosTaller> ListarDescargasPN(int a) {

        return consultaDescargasPN("select pn from productos_taller_ingresos where codigo_ingre = "+a);
    }
    
    private static ArrayList<ProductosTaller> consultaDescargasPN(String sql) {
        ArrayList<ProductosTaller> list = new ArrayList<ProductosTaller>();
        Connection cn = BDFIBRA.getConnection();
        try {
            ProductosTaller t;
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                t = new ProductosTaller();
                t.setPN(rs.getString("PN"));
                list.add(t);
                }
            cn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR " + e);
        }
        return list;
    }
}
