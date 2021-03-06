/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import Class.CTrabajos;
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
"                          12,c2.descripcion||' '||decode(c1.inserto,1,'CB252-6',2,'CB440-4'),\n" +
"                          13,c2.descripcion||' OD '||c1.od||' ID '||c1.id||' THK '||c1.thk,\n" +
"                          14,c2.descripcion||' OD '||c1.od||' ID '||c1.id||' THK '||c1.thk,\n" +
"                          15,c2.descripcion||' THK '||c1.thk,\n" +
"                          16,c2.descripcion||' THK '||c1.thk,\n" +
"                          17,c2.descripcion||' THK '||c1.thk,\n" +
"                          18,c2.descripcion||' THK '||c1.thk,\n" +
"                          19,c2.descripcion||' ID '||c1.ID||' ID '||c1.ID2||' THK '||c1.THK) as Descripcion,pn.cantidad from pn inner join componentes c1 on c1.IDCOMPO = pn.IDCOMPO join componentes2 c2 on c1.idcompo2 = c2.idcompo2 where pn = '" + c + "'");
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
            ps.executeUpdate("insert into ingreso_trabajo values(" + p.getIdTrabajo() + ",'" + p.getJob() + "','" + p.getRev() + "','"+p.getF1()+"',1,"+p.getCantidadportrabajo()+""
                    + ",'"+p.getPn()+"','"+p.getF2()+"','"+p.getNota()+"')");
            
            //+new java.sql.Date(p.getFechaexp().getTime())+
            //+new java.sql.Date(p.getFecha().getTime())+
            if (p.getIdpn2() == 0) {
                ps.executeUpdate("insert into TRABAJO_PARTES values (job.nextval," + p.getIdTrabajo() + "," + p.getIdpn1() + "," + p.getCantidad1() + ")");
            } else if (p.getCantidad3() == 0) {
                ps.executeUpdate("insert into TRABAJO_PARTES values (job.nextval," + p.getIdTrabajo() + "," + p.getIdpn1() + "," + p.getCantidad1() + ")");
                ps.executeUpdate("insert into TRABAJO_PARTES values (job.nextval," + p.getIdTrabajo() + "," + p.getIdpn2() + "," + p.getCantidad2() + ")");
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
            } else if (p.getCantidad10() != 0) {
                ps.executeUpdate("insert into TRABAJO_PARTES values (job.nextval," + p.getIdTrabajo() + "," + p.getIdpn1() + "," + p.getCantidad1() + ")");
                ps.executeUpdate("insert into TRABAJO_PARTES values (job.nextval," + p.getIdTrabajo() + "," + p.getIdpn2() + "," + p.getCantidad2() + ")");
                ps.executeUpdate("insert into TRABAJO_PARTES values (job.nextval," + p.getIdTrabajo() + "," + p.getIdpn3() + "," + p.getCantidad3() + ")");
                ps.executeUpdate("insert into TRABAJO_PARTES values (job.nextval," + p.getIdTrabajo() + "," + p.getIdpn4() + "," + p.getCantidad4() + ")");
                ps.executeUpdate("insert into TRABAJO_PARTES values (job.nextval," + p.getIdTrabajo() + "," + p.getIdpn5() + "," + p.getCantidad5() + ")");
                ps.executeUpdate("insert into TRABAJO_PARTES values (job.nextval," + p.getIdTrabajo() + "," + p.getIdpn6() + "," + p.getCantidad6() + ")");
                ps.executeUpdate("insert into TRABAJO_PARTES values (job.nextval," + p.getIdTrabajo() + "," + p.getIdpn7() + "," + p.getCantidad7() + ")");
                ps.executeUpdate("insert into TRABAJO_PARTES values (job.nextval," + p.getIdTrabajo() + "," + p.getIdpn8() + "," + p.getCantidad8() + ")");
                ps.executeUpdate("insert into TRABAJO_PARTES values (job.nextval," + p.getIdTrabajo() + "," + p.getIdpn9() + "," + p.getCantidad9() + ")");
                ps.executeUpdate("insert into TRABAJO_PARTES values (job.nextval," + p.getIdTrabajo() + "," + p.getIdpn9() + "," + p.getCantidad10() + ")");
            }
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
    
     public static ArrayList<CTrabajos> ListarJobTodo() {

        return consultaTrabajo("select no_trabajo,job,PN,cantidad from INGRESO_TRABAJO");
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
        ps = cn.prepareStatement("select pn,no_trabajo,job,rev,fecha,fechaven,nota,cantidad from ingreso_trabajo where no_trabajo ="+id);
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
"                          12,c2.descripcion||' '||decode(c1.inserto,1,'CB252-6',2,'CB440-4'),\n" +
"                          13,c2.descripcion||' OD '||c1.od||' ID '||c1.id||' THK '||c1.thk,\n" +
"                          14,c2.descripcion||' OD '||c1.od||' ID '||c1.id||' THK '||c1.thk,\n" +
"                          15,c2.descripcion||' THK '||c1.thk,\n" +
"                          16,c2.descripcion||' THK '||c1.thk,\n" +
"                          17,c2.descripcion||' THK '||c1.thk,\n" +
"                          18,c2.descripcion||' THK '||c1.thk,\n" +
"                          19,c2.descripcion||' ID '||c1.ID||' ID '||c1.ID2||' THK '||c1.THK) as Descripcion,tp.cantidad as cantidadin,\n" +
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
}