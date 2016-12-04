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
public class MantenimientoDet {
    
    private int codigo;
    private int mantenimiento_codigo;
    private int servicio_codigo;
    private Double cantidad;
    private Double precio;
    private Double subtotal;

    public MantenimientoDet() {
        this.codigo=0;
        this.mantenimiento_codigo=0;
        this.servicio_codigo=0;
        this.cantidad=0d;
        this.precio=0d;
        this.subtotal=0d;
        
    }

    public MantenimientoDet(int codigo, int mantenimiento_codigo, int servicio_codigo, Double cantidad, Double precio, Double subtotal) {
        this.codigo = codigo;
        this.mantenimiento_codigo = mantenimiento_codigo;
        this.servicio_codigo = servicio_codigo;
        this.cantidad = cantidad;
        this.precio = precio;
        this.subtotal = subtotal;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getMantenimiento_codigo() {
        return mantenimiento_codigo;
    }

    public void setMantenimiento_codigo(int mantenimiento_codigo) {
        this.mantenimiento_codigo = mantenimiento_codigo;
    }

    public int getServicio_codigo() {
        return servicio_codigo;
    }

    public void setServicio_codigo(int servicio_codigo) {
        this.servicio_codigo = servicio_codigo;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }
    
 
    
    
    
    
}
