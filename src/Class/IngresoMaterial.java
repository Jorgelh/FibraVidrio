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
public class IngresoMaterial {
    
    public int Id_Material;
    public int IdMaterial;
    public int cantidad;
    public Date FechaIngreso;
    public String PO;
    public String invoice;
    public String PN;
    public String notas;
    public String Descripcion;
    public int Codigo;
    public String Job;
    public int cantidadBodega;
    public String Ubicacion;
    public String FechaString;

    public String getFechaString() {
        return FechaString;
    }

    public void setFechaString(String FechaString) {
        this.FechaString = FechaString;
    }

    
    
    public String getUbicacion() {
        return Ubicacion;
    }

    public void setUbicacion(String Ubicacion) {
        this.Ubicacion = Ubicacion;
    }

    public int getCantidadBodega() {
        return cantidadBodega;
    }

    public void setCantidadBodega(int cantidadBodega) {
        this.cantidadBodega = cantidadBodega;
    }
    
    public String getJob() {
        return Job;
    }

    public void setJob(String Job) {
        this.Job = Job;
    }
    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int Codigo) {
        this.Codigo = Codigo;
    }
    
    
    public int getId_Material() {
        return Id_Material;
    }

    public void setId_Material(int Id_Material) {
        this.Id_Material = Id_Material;
    }

    public int getIdMaterial() {
        return IdMaterial;
    }

    public void setIdMaterial(int IdMaterial) {
        this.IdMaterial = IdMaterial;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFechaIngreso() {
        return FechaIngreso;
    }

    public void setFechaIngreso(Date FechaIngreso) {
        this.FechaIngreso = FechaIngreso;
    }

    public String getPO() {
        return PO;
    }

    public void setPO(String PO) {
        this.PO = PO;
    }

    public String getInvoice() {
        return invoice;
    }

    public void setInvoice(String invoice) {
        this.invoice = invoice;
    }

    public String getPN() {
        return PN;
    }

    public void setPN(String PN) {
        this.PN = PN;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }
    
}
