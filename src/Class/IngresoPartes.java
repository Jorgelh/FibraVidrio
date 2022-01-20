/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import BD.BDFIBRA;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author jluis
 */
public class IngresoPartes {
    private int idcompo;
    private int descripcion;
    private String id;
    private String id2;
    private String od;
    private String od2;
    private String thk;
    private int pines;
    private int numero;
    private String largo;
    private String aplastado;
    private String radio;
    private int insert;
    private String HT;

    public String getHT() {
        return HT;
    }

    public void setHT(String HT) {
        this.HT = HT;
    }
 
    public String getOd2() {
        return od2;
    }

    public void setOd2(String od2) {
        this.od2 = od2;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId2() {
        return id2;
    }

    public void setId2(String id2) {
        this.id2 = id2;
    }

    public String getOd() {
        return od;
    }

    public void setOd(String od) {
        this.od = od;
    }

    public String getThk() {
        return thk;
    }

    public void setThk(String thk) {
        this.thk = thk;
    }

    public String getLargo() {
        return largo;
    }

    public void setLargo(String largo) {
        this.largo = largo;
    }

    public String getAplastado() {
        return aplastado;
    }

    public void setAplastado(String aplastado) {
        this.aplastado = aplastado;
    }

    public String getRadio() {
        return radio;
    }

    public void setRadio(String radio) {
        this.radio = radio;
    }
    
    public int getIdcompo() {
        return idcompo;
    }

    public void setIdcompo(int idcompo) {
        this.idcompo = idcompo;
    }

    public int getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(int descripcion) {
        this.descripcion = descripcion;
    }

    public int getPines() {
        return pines;
    }

    public void setPines(int pines) {
        this.pines = pines;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getInsert() {
        return insert;
    }

    public void setInsert(int insert) {
        this.insert = insert;
    }

    public static void IngresoPart (IngresoPartes l) throws SQLException{
        Connection cn = BDFIBRA.getConnection();
        PreparedStatement ps = null;
        ps = cn.prepareStatement("insert into componentes values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        ps.setInt(1, l.getIdcompo());
        ps.setInt(2, l.getDescripcion());
        ps.setString(3, l.getId());
        ps.setString(4, l.getId2());
        ps.setString(5, l.getOd());
        ps.setInt(6, l.getPines());
        ps.setInt(7, l.getNumero());
        ps.setString(8, l.getLargo());
        ps.setString(9, l.getAplastado());
        ps.setString(10, l.getRadio());
        ps.setInt(11, l.getInsert());
        ps.setString(12, l.getThk());
        ps.setString(13, l.getOd2());
        ps.setString(14, l.getHT());
        ps.executeUpdate();
        cn.close();
        ps.close();
    }   
}   
    
           
    
    
    
    
    


