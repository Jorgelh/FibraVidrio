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
public class IngresoMat {
    
    int IDIngreso;
    int codigo;
    String pn;
    String job;
    String po;
    Date fecha;
    String nota;
    int cantidad;
    int idDesc;
    String invoice;
    String cliente;
    int entregadoa;

    public int getEntregadoa() {
        return entregadoa;
    }

    public void setEntregadoa(int entregadoa) {
        this.entregadoa = entregadoa;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
    
    

    public String getInvoice() {
        return invoice;
    }

    public void setInvoice(String invoice) {
        this.invoice = invoice;
    }
    
    public int getIdDesc() {
        return idDesc;
    }

    public void setIdDesc(int idDesc) {
        this.idDesc = idDesc;
    }
   
    public int getIDIngreso() {
        return IDIngreso;
    }

    public void setIDIngreso(int IDIngreso) {
        this.IDIngreso = IDIngreso;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getPn() {
        return pn;
    }

    public void setPn(String pn) {
        this.pn = pn;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getPo() {
        return po;
    }

    public void setPo(String po) {
        this.po = po;
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
