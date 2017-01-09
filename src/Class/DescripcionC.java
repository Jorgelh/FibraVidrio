/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;


/**
 *
 * @author jluis
 */
public class DescripcionC {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

   

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }
    
    public int id;
    public String Descripcion;
    public String Medida;
    public String PN;
    public int cantidad;
    public int idcompo;
    public String nota;

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
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
    

    public String getPN() {
        return PN;
    }

    public void setPN(String PN) {
        this.PN = PN;
    }
    
    
    

    public String getMedida() {
        return Medida;
    }

    public void setMedida(String Medida) {
        this.Medida = Medida;
    }
    
    
    
    
    
}
