/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.edu.facitec.mec.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import py.edu.facitec.mec.model.MantenimientoDet;
import py.edu.facitec.mec.util.ConexionManager;

/**
 *
 * @author user
 */
public class MantenimientoDelDaoImpl implements MantenimientoDetDao{

    @Override
    public void guardar(MantenimientoDet matMantenimientoDet) {
  String sql=" INSERT INTO mantenimientos_detalles"
          + "( mantenimientos_codigo, servicio_codigo, cantidad, precio, subtotal)"
          +  "VALUES("+matMantenimientoDet.getMantenimiento_codigo()+","
          + ""+matMantenimientoDet.getServicio_codigo()+","
          + ""+matMantenimientoDet.getCantidad()+","
           + ""+matMantenimientoDet.getPrecio()+", "
          + ""+matMantenimientoDet.getSubtotal()+",";
        ConexionManager.conectar();
        
        try {
            ConexionManager.stm.execute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(MantenimientoDelDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
       ConexionManager.desconectar();
    }

    @Override
    public boolean modificar(MantenimientoDet mantenimientoDet) {
   String sql=  "UPDATE mantenimientos_detalles"
           + "SET mantenimientos_codigo='"+mantenimientoDet.getMantenimiento_codigo()+"',"
           + "servicio_codigo='"+mantenimientoDet.getServicio_codigo()+"',"
           + " cantidad='"+mantenimientoDet.getCantidad()+"',"
           + "   precio='"+mantenimientoDet.getPrecio()+"',"
           + " subtotal='"+mantenimientoDet.getSubtotal()+"',"
           + " WHERE codigo ="+mantenimientoDet.getCodigo()+",";
               boolean resultodo= false;
    ConexionManager.conectar();
    
        try {
            resultodo = ConexionManager.stm.execute(sql);
            System.out.println("Ejecutando: "+sql);
        } catch (SQLException ex) {
            Logger.getLogger(MantenimientoDaoImple.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al ejecutar "+ ex);
            
        }
    
    ConexionManager.desconectar();
    return resultodo;
    }

    @Override
    public void eliminar(int codigo) {
    String sql ="DELETE FROM mantenimientos_detalles WHERE codigo="+codigo+",";
      ConexionManager.conectar();
        
        try {
            System.out.println("SQL="+ sql);
            ConexionManager.stm.execute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(MantenimientoDaoImple.class.getName()).log(Level.SEVERE, null, ex);
        }
    ConexionManager.desconectar();
}

    @Override
    public MantenimientoDet recupererPorCodigo(int codigo) {
   String sql = "SELECT  mantenimientos_codigo, servicio_codigo, cantidad, precio, subtotal FROM mantenimientos_detalles WHERE codigo="+codigo+";";
      //abrir una conexion
        ConexionManager.conectar();
        
        MantenimientoDet mantenimientoDet = null;
        
        ResultSet rs;
        
        try {
            //ejecutar sql
            
            rs = ConexionManager.stm.executeQuery(sql);
            System.out.println("Ejecutando: "+sql);
            
           while (rs.next()) {
                mantenimientoDet = new MantenimientoDet();
                mantenimientoDet.setMantenimiento_codigo(rs.getInt("Mantenimiento_codigo"));
                mantenimientoDet.setServicio_codigo(rs.getInt("Servicio_codigoo"));
                mantenimientoDet.setCantidad(rs.getDouble("cantidad"));
                mantenimientoDet.setPrecio(rs.getDouble("Precio"));
                mantenimientoDet.setSubtotal(rs.getDouble("Subtotal"));
            
                  
           }
            
        } catch (SQLException ex) {
            Logger.getLogger(CiudadDaoImple.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al ejecutar SQL: "+ex);

        }
        //cerrar conexion
        ConexionManager.desconectar();
        return mantenimientoDet;
    
    }

    @Override
    public List<MantenimientoDet> recuperporFiltro(String filtro) {
    String sql= "SELECT codigo, mantenimientos_codigo, servicio_codigo, cantidad, precio,  subtotal"
            + "FROM mantenimientos_detalles"
            + "WHERE(mantenimiento_codigoLIKE '%"+filtro+"%')"
            + "or(servicio_codigoLIKE '%"+filtro+"%' )"
            + "or(cantidadLIKE '%"+filtro+"%' )"
            + "or(precioLIKE '%"+filtro+"%')"
            + "or(subtotal '%"+filtro+"%')"
            + "order by codigo;";
            List<MantenimientoDet> lista = new ArrayList<>();
        
        System.out.println("SQL = " + sql);
        
        
        //abrir una conexion
        ConexionManager.conectar();
        
        MantenimientoDet mantenimientoDet = null;
        
        ResultSet rs;
        
        try {
            //ejecutar sql
            
            rs = ConexionManager.stm.executeQuery(sql);
            
            System.out.println("Ejecutando: "+sql);

            
            while (rs.next()) {
                
                mantenimientoDet = new MantenimientoDet();
                
                mantenimientoDet.setCodigo(rs.getInt("codigo"));
                mantenimientoDet.setMantenimiento_codigo(rs.getInt("Mantenimiento_codigo"));
                mantenimientoDet.setServicio_codigo(rs.getInt("Servicio_codigo"));
                mantenimientoDet.setCantidad(rs.getDouble("Cantidad"));
                mantenimientoDet.setPrecio(rs.getDouble("Precio"));
                mantenimientoDet.setSubtotal(rs.getDouble("Subbtotal"));
                
                //Agregara a la lista
                lista.add(mantenimientoDet);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al ejecutar "+ex);
        }
        //cerrar conexion
        ConexionManager.desconectar();
        
        return lista;
          
          

    
    }
    
}
