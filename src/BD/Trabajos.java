/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import static BD.EditComponentesHerramienta.consultarSQL;
import Class.CTrabajos;
import Class.DescripcionC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.naming.spi.DirStateFactory;
import javax.swing.JOptionPane;
import javax.xml.transform.Result;

/**
 *
 * @author jluis
 */
public class Trabajos {

    public static ArrayList<CTrabajos> ListarTrabajos(String c) {

        return consultaSQL("select pn.idcompo,decode(c1.idcompo2,1,c2.descripcion||' ID '||c1.ID||' THK '|| c1.THK,\n" +
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
"                          26,c2.descripcion||' ID '||c1.ID||' ID '||c1.ID2||' THK '||c1.THK) as Descripcion,pn.cantidad from pn inner join componentes c1 on c1.IDCOMPO = pn.IDCOMPO join componentes2 c2 on c1.idcompo2 = c2.idcompo2 where pn = '" + c + "'");
    }

    private static ArrayList<CTrabajos> consultaSQL(String sql) {
        ArrayList<CTrabajos> list = new ArrayList<CTrabajos>();
        Connection cn = BDFIBRA.getConnection();

        try {
            CTrabajos t;
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                t = new CTrabajos();
                t.setDescripcion(rs.getString("Descripcion"));
                t.setCantidadporpieza(rs.getInt("Cantidad"));
                t.setIdcompo(rs.getInt("idcompo"));
                list.add(t);
            }
            cn.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR " + e);
        }
        return list;
    }

    public static void GuardarTrabajo(CTrabajos p) throws SQLException {
                       System.out.println(p.getIdTrabajo());
        try {
            Connection cn = BDFIBRA.getConnection();
            Statement ps = cn.createStatement();
            ps.executeUpdate("insert into ingreso_trabajo(NO_TRABAJO,ID_CLIENTE,JOB,REV,FECHA,ESTADO,CANTIDAD,PN,FECHAVEN,NOTA,PRECAP) values(" + p.getIdTrabajo() + ","+p.getClienteint()+",'" + p.getJob() + "','" + p.getRev() + "','"+p.getF1()+"',1,"+p.getCantidadportrabajo()+""
                    + ",'"+p.getPn()+"','"+p.getF2()+"','"+p.getNota()+"',"+p.getPrecap()+")");
            //+new java.sql.Date(p.getFechaexp().getTime())+
            //+new java.sql.Date(p.getFecha().getTime())+
            if (p.getIdpn2() == 0) {
                ps.executeUpdate("insert into TRABAJO_PARTES values (job.nextval," + p.getIdTrabajo() + "," + p.getIdpn1() + "," + p.getCantidad1() + ")");
                System.out.println("shit 1");
            } else if (p.getCantidad3() == 0) {
                ps.executeUpdate("insert into TRABAJO_PARTES values (job.nextval," + p.getIdTrabajo() + "," + p.getIdpn1() + "," + p.getCantidad1() + ")");
                ps.executeUpdate("insert into TRABAJO_PARTES values (job.nextval," + p.getIdTrabajo() + "," + p.getIdpn2() + "," + p.getCantidad2() + ")");
                System.out.println("shit 2");
            } else if (p.getCantidad4() == 0) {
                ps.executeUpdate("insert into TRABAJO_PARTES values (job.nextval," + p.getIdTrabajo() + "," + p.getIdpn1() + "," + p.getCantidad1() + ")");
                ps.executeUpdate("insert into TRABAJO_PARTES values (job.nextval," + p.getIdTrabajo() + "," + p.getIdpn2() + "," + p.getCantidad2() + ")");
                ps.executeUpdate("insert into TRABAJO_PARTES values (job.nextval," + p.getIdTrabajo() + "," + p.getIdpn3() + "," + p.getCantidad3() + ")");
            } else if (p.getCantidad5() == 0) {
                ps.executeUpdate("insert into TRABAJO_PARTES values (job.nextval," + p.getIdTrabajo() + "," + p.getIdpn1() + "," + p.getCantidad1() + ")");
                ps.executeUpdate("insert into TRABAJO_PARTES values (job.nextval," + p.getIdTrabajo() + "," + p.getIdpn2() + "," + p.getCantidad2() + ")");
                ps.executeUpdate("insert into TRABAJO_PARTES values (job.nextval," + p.getIdTrabajo() + "," + p.getIdpn3() + "," + p.getCantidad3() + ")");
                ps.executeUpdate("insert into TRABAJO_PARTES values (job.nextval," + p.getIdTrabajo() + "," + p.getIdpn4() + "," + p.getCantidad4() + ")");
            } else if (p.getCantidad6() == 0) {
                ps.executeUpdate("insert into TRABAJO_PARTES values (job.nextval," + p.getIdTrabajo() + "," + p.getIdpn1() + "," + p.getCantidad1() + ")");
                ps.executeUpdate("insert into TRABAJO_PARTES values (job.nextval," + p.getIdTrabajo() + "," + p.getIdpn2() + "," + p.getCantidad2() + ")");
                ps.executeUpdate("insert into TRABAJO_PARTES values (job.nextval," + p.getIdTrabajo() + "," + p.getIdpn3() + "," + p.getCantidad3() + ")");
                ps.executeUpdate("insert into TRABAJO_PARTES values (job.nextval," + p.getIdTrabajo() + "," + p.getIdpn4() + "," + p.getCantidad4() + ")");
                ps.executeUpdate("insert into TRABAJO_PARTES values (job.nextval," + p.getIdTrabajo() + "," + p.getIdpn5() + "," + p.getCantidad5() + ")");
            } else if (p.getCantidad7() == 0) {
                ps.executeUpdate("insert into TRABAJO_PARTES values (job.nextval," + p.getIdTrabajo() + "," + p.getIdpn1() + "," + p.getCantidad1() + ")");
                ps.executeUpdate("insert into TRABAJO_PARTES values (job.nextval," + p.getIdTrabajo() + "," + p.getIdpn2() + "," + p.getCantidad2() + ")");
                ps.executeUpdate("insert into TRABAJO_PARTES values (job.nextval," + p.getIdTrabajo() + "," + p.getIdpn3() + "," + p.getCantidad3() + ")");
                ps.executeUpdate("insert into TRABAJO_PARTES values (job.nextval," + p.getIdTrabajo() + "," + p.getIdpn4() + "," + p.getCantidad4() + ")");
                ps.executeUpdate("insert into TRABAJO_PARTES values (job.nextval," + p.getIdTrabajo() + "," + p.getIdpn5() + "," + p.getCantidad5() + ")");
                ps.executeUpdate("insert into TRABAJO_PARTES values (job.nextval," + p.getIdTrabajo() + "," + p.getIdpn6() + "," + p.getCantidad6() + ")");
            } else if (p.getCantidad8() == 0) {
                ps.executeUpdate("insert into TRABAJO_PARTES values (job.nextval," + p.getIdTrabajo() + "," + p.getIdpn1() + "," + p.getCantidad1() + ")");
                ps.executeUpdate("insert into TRABAJO_PARTES values (job.nextval," + p.getIdTrabajo() + "," + p.getIdpn2() + "," + p.getCantidad2() + ")");
                ps.executeUpdate("insert into TRABAJO_PARTES values (job.nextval," + p.getIdTrabajo() + "," + p.getIdpn3() + "," + p.getCantidad3() + ")");
                ps.executeUpdate("insert into TRABAJO_PARTES values (job.nextval," + p.getIdTrabajo() + "," + p.getIdpn4() + "," + p.getCantidad4() + ")");
                ps.executeUpdate("insert into TRABAJO_PARTES values (job.nextval," + p.getIdTrabajo() + "," + p.getIdpn5() + "," + p.getCantidad5() + ")");
                ps.executeUpdate("insert into TRABAJO_PARTES values (job.nextval," + p.getIdTrabajo() + "," + p.getIdpn6() + "," + p.getCantidad6() + ")");
                ps.executeUpdate("insert into TRABAJO_PARTES values (job.nextval," + p.getIdTrabajo() + "," + p.getIdpn7() + "," + p.getCantidad7() + ")");
            } else if (p.getCantidad9() == 0) {
                ps.executeUpdate("insert into TRABAJO_PARTES values (job.nextval," + p.getIdTrabajo() + "," + p.getIdpn1() + "," + p.getCantidad1() + ")");
                ps.executeUpdate("insert into TRABAJO_PARTES values (job.nextval," + p.getIdTrabajo() + "," + p.getIdpn2() + "," + p.getCantidad2() + ")");
                ps.executeUpdate("insert into TRABAJO_PARTES values (job.nextval," + p.getIdTrabajo() + "," + p.getIdpn3() + "," + p.getCantidad3() + ")");
                ps.executeUpdate("insert into TRABAJO_PARTES values (job.nextval," + p.getIdTrabajo() + "," + p.getIdpn4() + "," + p.getCantidad4() + ")");
                ps.executeUpdate("insert into TRABAJO_PARTES values (job.nextval," + p.getIdTrabajo() + "," + p.getIdpn5() + "," + p.getCantidad5() + ")");
                ps.executeUpdate("insert into TRABAJO_PARTES values (job.nextval," + p.getIdTrabajo() + "," + p.getIdpn6() + "," + p.getCantidad6() + ")");
                ps.executeUpdate("insert into TRABAJO_PARTES values (job.nextval," + p.getIdTrabajo() + "," + p.getIdpn7() + "," + p.getCantidad7() + ")");
                ps.executeUpdate("insert into TRABAJO_PARTES values (job.nextval," + p.getIdTrabajo() + "," + p.getIdpn8() + "," + p.getCantidad8() + ")");
            } else if (p.getCantidad10() == 0) {
                ps.executeUpdate("insert into TRABAJO_PARTES values (job.nextval," + p.getIdTrabajo() + "," + p.getIdpn1() + "," + p.getCantidad1() + ")");
                ps.executeUpdate("insert into TRABAJO_PARTES values (job.nextval," + p.getIdTrabajo() + "," + p.getIdpn2() + "," + p.getCantidad2() + ")");
                ps.executeUpdate("insert into TRABAJO_PARTES values (job.nextval," + p.getIdTrabajo() + "," + p.getIdpn3() + "," + p.getCantidad3() + ")");
                ps.executeUpdate("insert into TRABAJO_PARTES values (job.nextval," + p.getIdTrabajo() + "," + p.getIdpn4() + "," + p.getCantidad4() + ")");
                ps.executeUpdate("insert into TRABAJO_PARTES values (job.nextval," + p.getIdTrabajo() + "," + p.getIdpn5() + "," + p.getCantidad5() + ")");
                ps.executeUpdate("insert into TRABAJO_PARTES values (job.nextval," + p.getIdTrabajo() + "," + p.getIdpn6() + "," + p.getCantidad6() + ")");
                ps.executeUpdate("insert into TRABAJO_PARTES values (job.nextval," + p.getIdTrabajo() + "," + p.getIdpn7() + "," + p.getCantidad7() + ")");
                ps.executeUpdate("insert into TRABAJO_PARTES values (job.nextval," + p.getIdTrabajo() + "," + p.getIdpn8() + "," + p.getCantidad8() + ")");
                ps.executeUpdate("insert into TRABAJO_PARTES values (job.nextval," + p.getIdTrabajo() + "," + p.getIdpn9() + "," + p.getCantidad9() + ")");
            } else if (p.getCantidad10() != 0){
                ps.executeUpdate("insert into TRABAJO_PARTES values (job.nextval," + p.getIdTrabajo() + "," + p.getIdpn1() + "," + p.getCantidad1() + ")");
                ps.executeUpdate("insert into TRABAJO_PARTES values (job.nextval," + p.getIdTrabajo() + "," + p.getIdpn2() + "," + p.getCantidad2() + ")");
                ps.executeUpdate("insert into TRABAJO_PARTES values (job.nextval," + p.getIdTrabajo() + "," + p.getIdpn3() + "," + p.getCantidad3() + ")");
                ps.executeUpdate("insert into TRABAJO_PARTES values (job.nextval," + p.getIdTrabajo() + "," + p.getIdpn4() + "," + p.getCantidad4() + ")");
                ps.executeUpdate("insert into TRABAJO_PARTES values (job.nextval," + p.getIdTrabajo() + "," + p.getIdpn5() + "," + p.getCantidad5() + ")");
                ps.executeUpdate("insert into TRABAJO_PARTES values (job.nextval," + p.getIdTrabajo() + "," + p.getIdpn6() + "," + p.getCantidad6() + ")");
                ps.executeUpdate("insert into TRABAJO_PARTES values (job.nextval," + p.getIdTrabajo() + "," + p.getIdpn7() + "," + p.getCantidad7() + ")");
                ps.executeUpdate("insert into TRABAJO_PARTES values (job.nextval," + p.getIdTrabajo() + "," + p.getIdpn8() + "," + p.getCantidad8() + ")");
                ps.executeUpdate("insert into TRABAJO_PARTES values (job.nextval," + p.getIdTrabajo() + "," + p.getIdpn9() + "," + p.getCantidad9() + ")");
                ps.executeUpdate("insert into TRABAJO_PARTES values (job.nextval," + p.getIdTrabajo() + "," + p.getIdpn10() + "," + p.getCantidad10() + ")");
            }
            System.out.println("Lo hace 2 veces");
            cn.close();
            ps.close();
        } catch (SQLException e) {
            System.err.println("eroor BASE DE DATOS"+e);
        }
    }

    public static ArrayList<CTrabajos> ListarJob(String c) {

        return consultaJOB("select no_trabajo,job from ingreso_trabajo where ESTADO = 1 AND pn = '"+ c +"'");
    }

    private static ArrayList<CTrabajos> consultaJOB(String sql) {
        ArrayList<CTrabajos> list = new ArrayList<CTrabajos>();
        Connection cn = BDFIBRA.getConnection();
        try {
            CTrabajos t;
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                t = new CTrabajos();
                t.setNoTabajo(rs.getString("no_trabajo"));
                t.setJob(rs.getString("job"));
                list.add(t);
                }
            cn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR " + e);
        }
        return list;
    }
    
     public static ArrayList<CTrabajos> ListarJobTodo(String a) {

        return consultaTrabajo("select no_trabajo,job,PN,cantidad from INGRESO_TRABAJO where PN like upper('"+a+"%')");
    }

    private static ArrayList<CTrabajos> consultaTrabajo(String sql) {
        ArrayList<CTrabajos> list = new ArrayList<CTrabajos>();
        Connection cn = BDFIBRA.getConnection();
        try {
            CTrabajos t;
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                t = new CTrabajos();
                t.setNoTabajo(rs.getString("no_trabajo"));
                t.setJob(rs.getString("job"));
                t.setPn(rs.getString("PN"));
                t.setCantidad1(rs.getInt("cantidad"));
                list.add(t);
                }
            cn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR " + e);
        }
        return list;
    }
    
    
    public static CTrabajos BuscarTrabajo (int id)  throws SQLException{
        return BuscarTrabajo(id,null);
    }
        
    public static CTrabajos BuscarTrabajo(int id,CTrabajos t) throws SQLException{
        
        Connection cn = BDFIBRA.getConnection();
        PreparedStatement ps =null;
        ps = cn.prepareStatement("select i.pn,i.no_trabajo,i.job,i.rev,i.fecha,i.fechaven,i.nota,i.cantidad,c.descripcion from ingreso_trabajo i inner join clientes c on i.id_cliente = c.id_cliente where no_trabajo ="+id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()){
             if (t == null){
             t = new CTrabajos(){};
        }
             t.setIdTrabajo(rs.getInt("no_trabajo"));
             t.setPn(rs.getString("pn"));
             t.setJob(rs.getString("job"));
             t.setRev(rs.getString("rev"));
             t.setF1(rs.getString("fecha"));
             t.setF2(rs.getString("fechaven"));
             t.setNota(rs.getString("Nota"));
             t.setCantidad1(rs.getInt("cantidad"));
             t.setCliente(rs.getString("descripcion"));
    }
      cn.close();
      ps.close();
      return t;
              
    }
    
    public static ArrayList<CTrabajos> ListarPendiente(String c) {
        return ListarPendientes("select  decode(c1.idcompo2,1,c2.descripcion||' ID '||c1.ID||' THK '|| c1.THK,\n" +
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
"        b.CANTIDAD,\n" +
"        b.CANTIDAD-tp.cantidad as cantientre \n" +
"        from ingreso_trabajo inner join TRABAJO_PARTES tp on ingreso_trabajo.NO_TRABAJO = tp.no_trabajo \n" +
"        join componentes c1 on c1.IDCOMPO = tp.idcompo \n" +
"        join BITACORAPARTES b on tp.idtrabajopartes = b.IDTRABAJOPARTES \n" +
"        join componentes2 c2 on c1.idcompo2 = c2.idcompo2 where ingreso_trabajo.JOB ='"+c+"'");
    }

    private static ArrayList<CTrabajos> ListarPendientes(String sql) {
        ArrayList<CTrabajos> list = new ArrayList<CTrabajos>();
        Connection cn = BDFIBRA.getConnection();
        try {
            CTrabajos t;
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                t = new CTrabajos();
                t.setDescripcion(rs.getString("Descripcion"));
                t.setCantidad1(rs.getInt("cantidad"));
                t.setCantidad2(rs.getInt("cantidadin"));
                t.setCantidad3(rs.getInt("cantientre"));
                list.add(t);
                }
            cn.close();
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,"ERROR TABLA CANTIDADES" + e);
        }
        return list;
    }
    
    
     public static ArrayList<DescripcionC> ListarClientes(){
        
         return consultarSQL("select ID_CLIENTE as \"no\",descripcion as \"descri\" from clientes order by id_cliente");   
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
                f.setId(rs.getInt("no"));
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
    
    
     public static DescripcionC buscarClientes(int id) throws SQLException {
      return buscarClientes(id, null);
    }
  public static DescripcionC buscarClientes(int id, DescripcionC p) throws SQLException {
        Connection cnn = BDFIBRA.getConnection();
        PreparedStatement ps = null;
        ps = cnn.prepareStatement("select descripcion from clientes where id_cliente=?");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            if (p == null) {
                p = new DescripcionC(){
                };
            }
            p.setId(id);
            p.setDescripcion(rs.getString("descripcion"));
            
        }
        cnn.close();
        ps.close();
        return p;
    }
  
  public static boolean actualizarCliente(DescripcionC f) throws SQLException {
        Connection cnn = BDFIBRA.getConnection();
        PreparedStatement ps = null;
        ps = cnn.prepareStatement("update clientes set descripcion=? where id_cliente=" + f.getId());
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
    
  public static void insertarCliente(DescripcionC d) throws SQLException{
    Connection cnn = BDFIBRA.getConnection();
        PreparedStatement ps = null;
    ps= cnn.prepareStatement("insert into clientes Values(?,?)");
    ps.setInt(1, d.getId());
    ps.setString(2, d.getDescripcion());
    ps.executeUpdate();
    cnn.close();
    ps.close();
    
    }     
  
  public static void insertarNuevoComponente(CTrabajos d) throws SQLException{
    Connection cnn = BDFIBRA.getConnection();
    PreparedStatement ps = null;
    ps= cnn.prepareStatement("insert into trabajo_partes Values(job.nextval,?,?,?)");
    ps.setInt(1, d.getIdTrabajo());
    ps.setInt(2, d.getIdcompo());
    ps.setInt(3, d.getCantidadportrabajo());
    ps.executeUpdate();
    cnn.close();
    ps.close();
    
    }     
  
  public static void deleteComponente(CTrabajos d) throws SQLException{
    Connection cnn = BDFIBRA.getConnection();
    PreparedStatement ps = null;
    ps= cnn.prepareStatement("delete from bitacorapartes where idtrabajopartes = ? and EXISTS(select 1 from trabajo_partes where bitacorapartes.idtrabajopartes = trabajo_partes.idtrabajopartes)");
    ps.setInt(1, d.getIdcompo());
    ps.executeUpdate();
    cnn.close();
    ps.close();
    
    }     
  
}