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
public class CEntregas {
    
    public int codigo;
    public int idtrabajopartes;
    public int no_trabajo;
    public int idcompo;
    public int cantidad;
    public String fecha;
    public String descripcion;
    public String PO;
    public String Nota;
    public String medida;
    public Date fechaentre;
    public String PN;
    public String JOB;
    public String empleado;
    public String gabeta;
    public String folder;
    public String rev;

    public String getRev() {
        return rev;
    }

    public void setRev(String rev) {
        this.rev = rev;
    }
    
    

    public String getGabeta() {
        return gabeta;
    }

    public void setGabeta(String gabeta) {
        this.gabeta = gabeta;
    }

    public String getFolder() {
        return folder;
    }

    public void setFolder(String folder) {
        this.folder = folder;
    }
    
    
    public String getEmpleado() {
        return empleado;
    }

    public void setEmpleado(String empleado) {
        this.empleado = empleado;
    }
    public String getJOB() {
        return JOB;
    }
    public void setJOB(String JOB) {
        this.JOB = JOB;
    }
    public String getPN() {
        return PN;
    }

    public void setPN(String PN) {
        this.PN = PN;
    }
     
    
    public Date getFechaentre() {
        return fechaentre;
    }

    public void setFechaentre(Date fechaentre) {
        this.fechaentre = fechaentre;
    }

    
    public String getMedida() {
        return medida;
    }

    public void setMedida(String medida) {
        this.medida = medida;
    }
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getIdtrabajopartes() {
        return idtrabajopartes;
    }

    public void setIdtrabajopartes(int idtrabajopartes) {
        this.idtrabajopartes = idtrabajopartes;
    }

    public int getNo_trabajo() {
        return no_trabajo;
    }

    public void setNo_trabajo(int no_trabajo) {
        this.no_trabajo = no_trabajo;
    }

    public int getIdcompo() {
        return idcompo;
    }

    public void setIdcompo(int idcompo) {
        this.idcompo = idcompo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPO() {
        return PO;
    }

    public void setPO(String PO) {
        this.PO = PO;
    }

    public String getNota() {
        return Nota;
    }

    public void setNota(String Nota) {
        this.Nota = Nota;
    }
    
    
}
