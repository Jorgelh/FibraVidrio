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

        return ListarPartes("select trabajo_partes.idtrabajopartes,trabajo_partes.cantidad,componentes.medida,componentes.descripcion from trabajo_partes inner join componentes on trabajo_partes.IDCOMPO = componentes.IDCOMPO where no_trabajo="+l);
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
                t.setDescripcion(rs.getString("descripcion"));
                t.setMedida(rs.getString("medida"));
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
        ps = cn.prepareStatement("select componentes.descripcion,trabajo_partes.idtrabajopartes,trabajo_partes.no_trabajo,trabajo_partes.idcompo from TRABAJO_PARTES inner join\n" +
        "componentes on TRABAJO_PARTES.IDCOMPO = componentes.IDCOMPO where TRABAJO_PARTES.IDTRABAJOPARTES ="+id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()){
             if (t == null){
             t = new CEntregas(){};
        }
             t.setIdtrabajopartes(rs.getInt("idtrabajopartes"));
             t.setNo_trabajo(rs.getInt("no_trabajo"));
             t.setIdcompo(rs.getInt("idcompo"));
             t.setDescripcion(rs.getString("Descripcion"));
             
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
}
