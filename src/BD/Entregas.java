/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import Class.CEntregas;
import Class.CTrabajos;
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
public class Entregas {
    
    public static ArrayList<CEntregas> ListarPartesEntrega(int l){

        return ListarPartes("select tp.idtrabajopartes,tp.cantidad,decode(c1.idcompo2,1,c2.descripcion||' ID '||c1.ID||' THK '|| c1.THK," +
"                          2,c2.descripcion||' ID '||c1.ID||' ID '||c1.ID2||' THK '||c1.THK," +
"                          3,c2.descripcion||' ID '||c1.ID||' ID '||c1.ID2||' THK '||c1.THK," +
"                          4,c2.descripcion||' THK '||c1.THK," +
"                          5,c2.descripcion||' THK '||c1.THK," +
"                          6,c2.descripcion||' ID '||c1.ID||' LARGO '||c1.largo||' THK '||c1.THK," +
"                          7,c2.descripcion||' '||decode(c1.pinesmat,1,'TC',2,'NIKEL')||' #'||c1.nume||' LARGO '||c1.largo||' APLASTADO '||c1.aplastado," +
"                          8,c2.descripcion||' RADIO '||c1.radio," +
"                          9,c2.descripcion||' ID '||c1.ID||' THK '||c1.THK," +
"                          10,c2.descripcion||' ID '||c1.ID||' ID '||c1.ID2||' THK '||c1.THK," +
"                          11,c2.descripcion||' ID '||c1.ID||' ID '||c1.ID2||' THK '||c1.THK," +
"                          12,c2.descripcion||' '||decode(c1.inserto,1,'CB252-6',2,'CB440-4',3,'CBL 440-6',4,'CB 440-12',5,'CBL 632-8',6,'CBL 832-8')," +
"                          13,c2.descripcion||' OD '||c1.od||' ID '||c1.id||' THK '||c1.thk," +
"                          14,c2.descripcion||' OD '||c1.od||' ID '||c1.id||' THK '||c1.thk," +
"                          15,c2.descripcion||' THK '||c1.thk," +
"                          16,c2.descripcion||' THK '||c1.thk," +
"                          17,c2.descripcion||' THK '||c1.thk," +
"                          18,c2.descripcion||' THK '||c1.thk," +
"                          19,c2.descripcion||' ID '||c1.ID||' ID '||c1.ID2||' THK '||c1.THK,"+ 
"                          20,c2.descripcion,"+
"                          21,c2.descripcion||' OD '||c1.OD||' OD '||c1.OD2||' THK '||c1.THK,"+
"                          22,c2.descripcion||' OD '||c1.OD||' OD '||c1.OD2||' THK '||c1.THK,"+
"                          23,c2.descripcion||' OD '||c1.OD||' THK '||c1.THK||' HT '||c1.ht,"+
"                          24,c2.descripcion||' OD '||c1.OD||' THK '||c1.THK,"+
"                          25,c2.descripcion||' ID '||c1.id||' OD '||c1.od||' THK '||c1.thk,"+
"                          26,c2.descripcion||' ID '||c1.ID||' ID '||c1.ID2||' THK '||c1.THK) as Descripcion from trabajo_partes tp inner join componentes c1 on tp.IDCOMPO = c1.IDCOMPO join componentes2 c2 on c1.idcompo2 = c2.idcompo2 where no_trabajo ="+l);
    }

    private static ArrayList<CEntregas> ListarPartes(String sql) {
        ArrayList<CEntregas> list = new ArrayList<CEntregas>();
        Connection cn = BDFIBRA.getConnection();
        try {
            CEntregas t;
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                t = new CEntregas();
                t.setIdtrabajopartes(rs.getInt("idtrabajopartes"));
                t.setDescripcion(rs.getString("Descripcion"));
                t.setCantidad(rs.getInt("Cantidad"));
                list.add(t);
                }
            cn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR TABLA CANTIDADES " + e);
        }
        return list;
    }
    
    public static CEntregas BuscarComponente (int id)  throws SQLException{
        return BuscarTrabajoComponente(id,null);
    }
        
    public static CEntregas BuscarTrabajoComponente(int id,CEntregas t) throws SQLException{
        
        Connection cn = BDFIBRA.getConnection();
        PreparedStatement ps =null;
        ps = cn.prepareStatement("select decode(c1.idcompo2,1,c2.descripcion||' ID '||c1.ID||' THK '|| c1.THK,\n" +
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
"                          26,c2.descripcion||' ID '||c1.ID||' ID '||c1.ID2||' THK '||c1.THK) as Descripcion ,trabajo_partes.cantidad,trabajo_partes.idtrabajopartes,trabajo_partes.no_trabajo,trabajo_partes.idcompo from TRABAJO_PARTES inner join componentes c1 on TRABAJO_PARTES.IDCOMPO = c1.IDCOMPO join componentes2 c2 on c1.idcompo2 = c2.idcompo2 where TRABAJO_PARTES.IDTRABAJOPARTES = "+id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()){
             if (t == null){
             t = new CEntregas(){};
        }
             t.setIdtrabajopartes(rs.getInt("idtrabajopartes"));
             t.setNo_trabajo(rs.getInt("no_trabajo"));
             t.setIdcompo(rs.getInt("idcompo"));
             t.setDescripcion(rs.getString("Descripcion"));
             t.setCantidad(rs.getInt("cantidad"));
             
    }
      cn.close();
      ps.close();
      return t;
              
    }
    
    public static void Entregas(CEntregas p) throws SQLException{
        
        Connection cn = BDFIBRA.getConnection();
        PreparedStatement ps = null;
        ps = cn.prepareStatement("insert into entregas values(noentrega.nextval,?,?,?,?,?,?,1,?,?)");
        ps.setInt(1, p.getCodigo());
        ps.setInt(2, p.getIdtrabajopartes());
        ps.setInt(3, p.getNo_trabajo());
        ps.setInt(4, p.getIdcompo());
        ps.setInt(5, p.getCantidad());
        ps.setDate(6, new java.sql.Date(p.getFechaentre().getTime()));
        ps.setString(7, p.getPO());
        ps.setString(8, p.getNota());
        ps.executeUpdate();
        cn.close();
        ps.close();
    }
    
    
    
    
    public static ArrayList<CEntregas> ListarHistorialEntregas(String l, String i){

        return ListarHistorial("select i.pn,decode(c1.idcompo2,1,c2.descripcion||' ID '||c1.ID||' THK '|| c1.THK,\n" +
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
"                          26,c2.descripcion||' ID '||c1.ID||' ID '||c1.ID2||' THK '||c1.THK) as Descripcion,e.fecha,e.cantidad,e.po,i.job,\n" +
"                          e.codigo from entregas e inner join componentes c1 on\n" +
"                          e.IDCOMPO = c1.idcompo join ingreso_trabajo i on e.NO_TRABAJO = i.NO_TRABAJO\n" +
"                          join componentes2 c2 on c1.idcompo2 = c2.idcompo2\n" +
"                          where upper(i.PN) like upper('"+l+"%') and upper(i.job) like upper('"+i+"%')");
    }

    private static ArrayList<CEntregas> ListarHistorial(String sql) {
        ArrayList<CEntregas> list = new ArrayList<CEntregas>();
        Connection cn = BDFIBRA.getConnection();
        try {
            CEntregas t;
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                t = new CEntregas();
                t.setPN(rs.getString("pn"));
                t.setDescripcion(rs.getString("Descripcion"));
                t.setFecha(rs.getString("fecha"));
                t.setCantidad(rs.getInt("cantidad"));
                t.setPO(rs.getString("po"));
                t.setJOB(rs.getString("job"));
                t.setEmpleado(rs.getString("codigo"));
                list.add(t);
                }
            cn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR TABLA CANTIDADES " + e);
        }
        return list;
    }
    
    public static ArrayList<CEntregas> BuscarDrawings(String l){

        return Drawings("select pn,gabeta,folder,nota,rev from Drawings where upper(PN) like upper('"+l+"%')");
    }

    private static ArrayList<CEntregas> Drawings(String sql) {
        ArrayList<CEntregas> list = new ArrayList<CEntregas>();
        Connection cn = BDFIBRA.getConnection();
        try {
            CEntregas t;
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                t = new CEntregas();
                t.setPN(rs.getString("pn"));
                t.setGabeta(rs.getString("gabeta"));
                t.setFolder(rs.getString("folder"));
                t.setNota(rs.getString("nota"));
                t.setRev(rs.getString("rev"));
                list.add(t);
                }
            cn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR TABLA Drawings " + e);
        }
        return list;
    }
}
