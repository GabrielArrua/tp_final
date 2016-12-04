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
public class Cliente {
    private int codigo;
    private String nombre;
    private String apellido;
    private String direccion;
    private int ciudad;
    private String celular;
    private double credito;
    private Boolean estado;

    public Cliente() {
        this.codigo = 0;
        this.nombre = "";
        this.apellido = "";
        this.direccion = "";
        this.ciudad = 0;
        this.celular = "";
        this.credito = 0d;
        this.estado = false;
    }

    
    
    public Cliente(String nombre, String apellido, String direccion, int ciudad, String celular, double credito, Boolean estado) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.celular = celular;
        this.credito = credito;
        this.estado = estado;
    }

    
     public Cliente(int codigo, String nombre, String apellido, String direccion, int ciudad, String celular, double credito, Boolean estado) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.celular = celular;
        this.credito = credito;
        this.estado = estado;
    }

    

    public Cliente(int parseInt, String text, String text0, String text1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getCiudad_codigo() {
        return ciudad;
    }

    public void setCiudad_codigo(int ciudad_codigo) {
        this.ciudad= ciudad_codigo;
    }


    public double getCredito() {
        return credito;
    }

    public void setCredito(double credito) {
        this.credito = credito;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
    
    
    
}
