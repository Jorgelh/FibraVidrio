/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassProductos;

import java.util.Date;

/**
 *
 * @author jluis
 */
public class ProductosTaller {
    
    private String descripcion;
    private int cantidad;
    private int codigo_ingre;
    private String PN;
    private String JOB;
    private String PO;
    private String FechaIngre;
    private String FechaDesca;
    private String INVOICE;
    private int CANTIDAD;
    private int CANTIDADINGRESO;
    private int ESTANDAR;
    private String NOTA;
    private Date fechaI;
    private int id_ingreso;
    private String EstandarStr;
    private Date fechaPoliza;
    private Double precio;
    private int conta;
    private String cliente;
    int departamento;
    int procedencia;
    int entregado;

    public int getEntregado() {
        return entregado;
    }

    public void setEntregado(int entregado) {
        this.entregado = entregado;
    }
    

    public int getProcedencia() {
        return procedencia;
    }

    public void setProcedencia(int procedencia) {
        this.procedencia = procedencia;
    }
    
    

    public int getDepartamento() {
        return departamento;
    }

    public void setDepartamento(int departamento) {
        this.departamento = departamento;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
   
    public int getConta() {
        return conta;
    }

    public void setConta(int conta) {
        this.conta = conta;
    }
    
    public Double getPrecio() {
        return precio;
    }
    public void setPrecio(Double precio) {
        this.precio = precio;
    }
    public Date getFechaPoliza() {
        return fechaPoliza;
    }
    public void setFechaPoliza(Date fechaPoliza) {
        this.fechaPoliza = fechaPoliza;
    }
    public String getFechaDesca() {
        return FechaDesca;
    }
    public void setFechaDesca(String FechaDesca) {
        this.FechaDesca = FechaDesca;
    }
    public String getEstandarStr() {
        return EstandarStr;
    }

    public void setEstandarStr(String EstandarStr) {
        this.EstandarStr = EstandarStr;
    }
    public int getId_ingreso() {
        return id_ingreso;
    }

    public void setId_ingreso(int id_ingreso) {
        this.id_ingreso = id_ingreso;
    }
    
    public Date getFechaI() {
        return fechaI;
    }

    public void setFechaI(Date fechaI) {
        this.fechaI = fechaI;
    }
    
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getCodigo_ingre() {
        return codigo_ingre;
    }

    public void setCodigo_ingre(int codigo_ingre) {
        this.codigo_ingre = codigo_ingre;
    }

    public String getPN() {
        return PN;
    }

    public void setPN(String PN) {
        this.PN = PN;
    }

    public String getJOB() {
        return JOB;
    }

    public void setJOB(String JOB) {
        this.JOB = JOB;
    }

    public String getPO() {
        return PO;
    }

    public void setPO(String PO) {
        this.PO = PO;
    }

    public String getFechaIngre() {
        return FechaIngre;
    }

    public void setFechaIngre(String FechaIngre) {
        this.FechaIngre = FechaIngre;
    }

    public String getINVOICE() {
        return INVOICE;
    }

    public void setINVOICE(String INVOICE) {
        this.INVOICE = INVOICE;
    }

    public int getCANTIDAD() {
        return CANTIDAD;
    }

    public void setCANTIDAD(int CANTIDAD) {
        this.CANTIDAD = CANTIDAD;
    }

    public int getCANTIDADINGRESO() {
        return CANTIDADINGRESO;
    }

    public void setCANTIDADINGRESO(int CANTIDADINGRESO) {
        this.CANTIDADINGRESO = CANTIDADINGRESO;
    }

    public int getESTANDAR() {
        return ESTANDAR;
    }

    public void setESTANDAR(int ESTANDAR) {
        this.ESTANDAR = ESTANDAR;
    }

    public String getNOTA() {
        return NOTA;
    }

    public void setNOTA(String NOTA) {
        this.NOTA = NOTA;
    }
    
}
