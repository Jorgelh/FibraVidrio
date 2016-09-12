/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import java.util.Date;

/**
 *
 * @author jluis
 */
public class Descargas {
    
    public String descripcion;
    public int id_descarga;
    public int iddesc;
    public Date fecha;
    public String nota;
    public int cantidad;
    public String PN;

    public String getPN() {
        return PN;
    }

    public void setPN(String PN) {
        this.PN = PN;
    }
  
    
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getId_descarga() {
        return id_descarga;
    }

    public void setId_descarga(int id_descarga) {
        this.id_descarga = id_descarga;
    }

    public int getIddesc() {
        return iddesc;
    }

    public void setIddesc(int iddesc) {
        this.iddesc = iddesc;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    
    
}
