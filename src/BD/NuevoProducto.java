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
        ps = cn.prepareStatement("insert into productosmat values (?,?,?,?,0,?,?)");
        ps.setInt(1, l.getCodigo());
        ps.setString(2, l.getDiametro());
        ps.setString(3, l.getGrosor());
        ps.setInt(4, l.getTipomaterial());
        ps.setInt(5, l.getEstilo());
        ps.setString(6, l.getUbicacion());
        ps.executeUpdate();
        cn.close();
        ps.close();
    }
    
     public static ArrayList<nuevo> ListarProductosDesc(String a){
         return ListarProductos("select codigo,decode(tipo_material,1,'TUBO CUADRADO',2,'TUBO REDONDO',3,'TUBO RECTANGULAR',4,'TUBO INSOLACION',5,'POT ROD',6,'PLANCHA',7,'TUBO PARA BOBINA REDONDO',8,'TUBO PARA BOBINA CUADRADO',9,'TUBO PARA BOBINA RECTANGULAR',10,'PLANCHA DE ALUMINIO',11,'TUBO REDONDO DE ALUMINIO',12,'BARRA DE ALUMINIO',13,'ANGULARES DE ALUMINIO',14,'BARRA DE ACERO',15,'BARRA DE BRONCE',16,'PLANCHA DE ACERO',17,'BARRA DE TITANIUM RODS',18,'BARRA DE ACERO INOXIDABLE',19,'BARRA ROSCADA')||' '||grosor||' '||diametro||' '||decode(estilo,1,'SANDBLAST BOTH SIDES NEGRO',2,'SANDBLAST BOTH SIDES CLARO',3,'NATURAL NEGRO',4,'NATURAL CLARO',5,'SANDBLAST ONE SIDE NEGRO',6,'SANDBLAST ONE SIDE CLARO',7,'60-61',8,'O-1',9,'A-2') as \"Descripcion\" from productosmat where upper(decode(tipo_material,1,'TUBO CUADRADO',2,'TUBO REDONDO',3,'TUBO RECTANGULAR',4,'TUBO INSOLACION',5,'POT ROD',6,'PLANCHA',7,'TUBO PARA BOBINA REDONDO',8,'TUBO PARA BOBINA CUADRADO',9,'TUBO PARA BOBINA RECTANGULAR',10,'PLANCHA DE ALUMINIO',11,'TUBO REDONDO DE ALUMINIO',12,'BARRA DE ALUMINIO',13,'ANGULARES DE ALUMINIO',14,'BARRA DE ACERO',15,'BARRA DE BRONCE',16,'PLANCHA DE ACERO',17,'BARRA DE TITANIUM RODS',18,'BARRA DE ACERO INOXIDABLE',19,'BARRA ROSCADA')||' '||grosor||' '||diametro) like upper('"+a+"%')");   
    }
     
    public static ArrayList<nuevo> ListarProductos(){
         return ListarProductos("select codigo,decode(tipo_material,1,'TUBO CUADRADO',2,'TUBO REDONDO',3,'TUBO RECTANGULAR',4,'TUBO INSOLACION',5,'POT ROD',6,'PLANCHA',7,'TUBO PARA BOBINA REDONDO',8,'TUBO PARA BOBINA CUADRADO',9,'TUBO PARA BOBINA RECTANGULAR',10,'PLANCHA DE ALUMINIO',11,'TUBO REDONDO DE ALUMINIO',12,'BARRA DE ALUMINIO',13,'ANGULARES DE ALUMINIO',14,'BARRA DE ACERO',15,'BARRA DE BRONCE',16,'PLANCHA DE ACERO',17,'BARRA DE TITANIUM RODS',18,'BARRA DE ACERO INOXIDABLE',19,'BARRA ROSCADA')||' '||grosor||' '||diametro as \"Descripcion\" from productosmat order by codigo");   
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
    

public static ArrayList<nuevo> ProductosDescargados(String a){
        
         return ListarProductosDescargados("select productosmat.codigo,decode(tipo_material,1,'TUBO CUADRADO',2,'TUBO REDONDO',3,'TUBO RECTANGULAR',4,'TUBO INSOLACION',5,'POT ROD',6,'PLANCHA',7,'TUBO PARA BOBBINA REDONDO',8,'TUBO PARA BOBBINA CUADRADO',9,'TUBO PARA BOBBINA RECTANGULAR',10,'PLANCHA DE ALUMINIO',11,'TUBO REDONDO DE ALUMINIO',12,'BARRA DE ALUMINIO',13,'ANGULARES DE ALUMINIO',14,'BARRA DE ACERO',15,'BARRA DE BRONCE',16,'PLANCHA DE ACERO',17,'BARRA DE TITANIUM RODS',18,'BARRA DE ACERO INOXIDABLE',19,'BARRA ROSCADA')||' '||grosor||' '||diametro||' '||decode(estilo,1,'SANDBLAST BOTH SIDES NEGRO',2,'SANDBLAST BOTH SIDES CLARO',3,'NATURAL NEGRO',4,'NATURAL CLARO',5,'SANDBLAST ONE SIDE NEGRO',6,'SANDBLAST ONE SIDE CLARO',7,'60-61',8,'O-1',9,'A-2') as \"Descripcion\" ,"
                 + "DESCARGASMAT.fecha,DESCARGASMAT.PN,DESCARGASMAT.TRABAJO,DESCARGASMAT.CANTIDAD,INGRESOSMAT.PO,DESCARGASMAT.NOTA "
                 + "from productosmat inner join INGRESOSMAT on INGRESOSMAT.CODIGO = productosmat.CODIGO join DESCARGASMAT on INGRESOSMAT.ID_INGRESO = DESCARGASMAT.ID_INGRESO where upper(decode(tipo_material,1,'TUBO CUADRADO',2,'TUBO REDONDO',3,'TUBO RECTANGULAR',4,'TUBO INSOLACION',5,'POT ROD',6,'PLANCHA',7,'TUBO PARA BOBBINA REDONDO',8,'TUBO PARA BOBBINA CUADRADO',9,'TUBO PARA BOBBINA RECTANGULAR',10,'PLANCHA DE ALUMINIO',11,'TUBO REDONDO DE ALUMINIO',12,'BARRA DE ALUMINIO',13,'ANGULARES DE ALUMINIO',14,'BARRA DE ACERO',15,'BARRA DE BRONCE',16,'PLANCHA DE ACERO',17,'BARRA DE TITANIUM RODS',18,'BARRA DE ACERO INOXIDABLE',19,'BARRA ROSCADA')||' '||grosor||' '||diametro) like upper('"+a+"%')");   
    }

private static ArrayList<nuevo> ListarProductosDescargados(String sql) {
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
                f.setCantidad(rs.getInt("cantidad"));
                f.setFecha(rs.getString("fecha"));
                f.setPN(rs.getString("pn"));
                f.setTrabajo(rs.getString("trabajo"));
                f.setPO(rs.getString("PO"));
                f.setNota(rs.getString("nota"));
                list.add(f);
            }
            cn.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        }
        return list;
    }


public static ArrayList<nuevo> HerramientaDescargada(String a){
        
         return ListarHerramientaDescargada("select dh.DESCRIPCION||' '||m.M_MEDIDA||' '||ma.M_TIPO as \"descripcion\",de.FECHADESC ,de.CANTIDAD,de.NOTA from  M_DESCRIPCION d join   M_DESCRIHERRAMIENTA dh on  d.NO_DESCRIPCION = dh.NO_DESCRIPCION\n" +
"                     join M_Medidas m on d.NO_MEDIDA = m.NO_MEDIDA join M_MATERIAL ma on d.NO_TIPO = ma.NO_TIPO join m_descargas de on de.NO = d.NO \n" +
"                     where upper(dh.DESCRIPCION||' '||m.M_MEDIDA||' '||ma.M_TIPO) like upper('"+a+"%')");   
    }

private static ArrayList<nuevo> ListarHerramientaDescargada(String sql) {
        ArrayList<nuevo> list = new ArrayList<nuevo>();
        Connection cn = BDFIBRA.getConnection();
        try {
            nuevo f;
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                f = new nuevo();
                f.setDescripcion(rs.getString("descripcion"));
                f.setCantidad(rs.getInt("cantidad"));
                f.setFecha(rs.getString("fechadesc"));
                f.setNota(rs.getString("nota"));
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
                f.setPo(rs.getString("po"));
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
        ps = cn.prepareStatement("select decode(tipo_material,1,'TUBO CUADRADO',2,'TUBO REDONDO',3,'TUBO RECTANGULAR',4,'TUBO INSOLACION',5,'POT ROD',6,'PLANCHA',7,'TUBO PARA BOBINA REDONDO',8,'TUBO PARA BOBINA CUADRADO',9,'TUBO PARA BOBINA RECTANGULAR',10,'PLANCHA DE ALUMINIO',11,'TUBO REDONDO DE ALUMINIO',12,'BARRA DE ALUMINIO',13,'ANGULARES DE ALUMINIO',14,'BARRA DE ACERO',15,'BARRA DE BRONCE',16,'PLANCHA DE ACERO',17,'BARRA DE TITANIUM RODS',18,'BARRA DE ACERO INOXIDABLE',19,'BARRA ROSCADA')||' '||grosor||' '||diametro \"descri\",productosmat.codigo,cantidad from productosmat where codigo ="+id);
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
        ps = cn.prepareStatement("insert into ingresosmat values (?,?,?,?,?,?,?,?,?,?)");
        ps.setInt(1, l.getIDIngreso());
        ps.setInt(2, l.getCodigo());
        ps.setString(3, l.getPn());
        ps.setString(4, l.getJob());
        ps.setString(5, l.getPo());
        ps.setDate(6, new java.sql.Date(l.getFecha().getTime()));
        ps.setString(7, l.getNota());
        ps.setInt(8, l.getCantidad());
        ps.setInt(9, l.getCantidad());
        ps.setString(10, l.getInvoice());
        ps.executeUpdate();
        cn.close();
        ps.close();
    }

    public static void IngresoDesc (IngresoMat l) throws SQLException{
        Connection cn = BDFIBRA.getConnection();
        PreparedStatement ps = null;
        ps = cn.prepareStatement("insert into DESCARGASMAT values (?,?,?,?,?,?,?,?,?)");
        ps.setInt(1, l.getIdDesc());
        ps.setInt(2, l.getIDIngreso());
        ps.setDate(3, new java.sql.Date(l.getFecha().getTime()));
        ps.setInt(4, l.getCantidad());
        ps.setString(5, l.getJob());
        ps.setString(6, l.getPn());
        ps.setString(7, l.getNota());
        ps.setString(8, l.getCliente());
        ps.setInt(9, l.getEntregadoa());
        ps.executeUpdate();
        cn.close();
        ps.close();
    }
    
    
    
    
    
}
