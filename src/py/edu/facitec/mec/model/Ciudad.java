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
 public class Ciudad {
    private int codigo;
    private String nombre;
    private String iso;
    private Boolean estado;

    public Ciudad() {
        this.codigo=0;
        this.estado=false;
        this.iso="";
        this.nombre="";
        
    }
    
    public Ciudad(String nombre, String iso, boolean estado) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.iso = iso;
        this.estado = estado;
    }

    public Ciudad(int codigo, String nombre, String iso, boolean estado) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.iso = iso;
        this.estado = estado;
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

    public String getIso() {
        return iso;
    }

    public void setIso(String iso) {
        this.iso = iso;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    
}
