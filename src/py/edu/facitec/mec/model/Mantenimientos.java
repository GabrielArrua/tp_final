/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.edu.facitec.mec.model;

import java.util.Date;

/**
 *
 * @author user
 **/
public class Mantenimientos {
    private int codigo;
    private Date fecha;
    private int cliente_codigo;
    private String condicion;
    private double importe_total;
    private String observacion;
    private String situacion;

    public Mantenimientos() {
        this.codigo=0;
         this.fecha= new Date();
        this.cliente_codigo=0;
        this.condicion="";
        this.importe_total=0;
        this.observacion="";
        this.situacion="";
    }

    public Mantenimientos(int codigo, Date fecha, int cliente_codigo, String condicion, double importe_total, String observacion, String situacion) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.cliente_codigo = cliente_codigo;
        this.condicion = condicion;
        this.importe_total = importe_total;
        this.observacion = observacion;
        this.situacion = situacion;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getCliente_codigo() {
        return cliente_codigo;
    }

    public void setCliente_codigo(int cliente_codigo) {
        this.cliente_codigo = cliente_codigo;
    }

    public String getCondicion() {
        return condicion;
    }

    public void setCondicion(String condicion) {
        this.condicion = condicion;
    }

    public double getImporte_total() {
        return importe_total;
    }

    public void setImporte_total(double importe_total) {
        this.importe_total = importe_total;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getSituacion() {
        return situacion;
    }

    public void setSituacion(String situacion) {
        this.situacion = situacion;
    }

   
}
