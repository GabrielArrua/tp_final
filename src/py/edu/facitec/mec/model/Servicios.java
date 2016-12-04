/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.edu.facitec.mec.model;

/**
 *
 * @author user
 */
public class Servicios {
    private int codigo;
     private String descripcion;
      private Double valor_unitario;
    private String nombre;
    private Boolean estado;

    public Servicios() {
         this.codigo = 0;
        this.nombre = "";
        this.descripcion = "";
        this.valor_unitario = 0d;
        this.estado = false;
      
    }

    public Servicios( String descripcion, Double valor_unitario, String nombre, Boolean estado) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.valor_unitario = valor_unitario;
        this.nombre = nombre;
        this.estado = estado;
    }

   
    public Servicios(int codigo, String nombre, String descripcion, Double valor_unitario, boolean estado) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.valor_unitario = valor_unitario;
        this.estado = estado;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getValor_unitario() {
        return valor_unitario;
    }

    public void setValor_unitario(Double valor_unitario) {
        this.valor_unitario = valor_unitario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
    
        
    
}
