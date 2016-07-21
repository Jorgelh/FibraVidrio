/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import Class.CTrabajos;
import java.sql.Connection;
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
        
        return consultaSQL("select componentes.descripcion,pn.cantidad from pn inner join componentes on componentes.IDCOMPO=pn.IDCOMPO where pn = '"+c+"'");
    }
    
    private static ArrayList<CTrabajos>consultaSQL(String sql){
        ArrayList<CTrabajos> list = new ArrayList<CTrabajos>();
        Connection cn = BDFIBRA.getConnection();
        
        try {
            CTrabajos t;
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
            t = new CTrabajos();
            t.setDescripcion(rs.getString("Descripcion"));
            t.setCantidadporpieza(rs.getInt("Cantidad"));
            list.add(t);
            }
        cn.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"ERROR " +e);
        }
        return list;
    }
}  
    
    
    
    
    

