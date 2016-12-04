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
import py.edu.facitec.mec.model.Ciudad;
import py.edu.facitec.mec.model.Mantenimientos;
import py.edu.facitec.mec.util.ConexionManager;

/**
 *
 * @author user
 */
public class MantenimientoDaoImple implements MantenimientoDao{

    @Override
    public void Guardar(Mantenimientos mantenimientos) {
 String sql="  INSERT INTO public.mantenimientos"
         + "( cliente_codigo, condicion, fecha, importe_total, observacion,  situacion)"
         + " VALUES ('"+mantenimientos.getCliente_codigo()+"','"+mantenimientos.getCondicion()+"',"
         + " '"+mantenimientos.getFecha()+"','"+mantenimientos.getImporte_total()+"',"
         + " '"+mantenimientos.getObservacion()+"',"
         + " '"+mantenimientos.getSituacion()+"');";
         
       ConexionManager.conectar();
       
        try {
            ConexionManager.stm.execute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(MantenimientoDaoImple.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       ConexionManager.desconectar();

    
    }

    

    @Override
    public void eliminar(int codigo) {
  String sql =" DELETE FROM mantenimientos WHERE codigo="+codigo+",";
        
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
    public boolean modificar(Mantenimientos mantenimientos) {
   String sql =" UPDATE mantenimientos"
           + "SET cliente_codigo ='"+mantenimientos.getCliente_codigo()+"', ,"
           + " condicion='"+mantenimientos.getCondicion()+"', fecha='"+mantenimientos.getFecha()+"',"
           + " importe_total="+mantenimientos.getImporte_total()+","
           + "observacion='"+mantenimientos.getObservacion()+"',"
           + " situacion='"+mantenimientos.getSituacion()+"'"
           + " WHERE codigo="+mantenimientos.getCodigo()+";";

    
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
    public Mantenimientos recupererPorCodigo(int codigo) {
  String sql = "SELECT  cliente_codigo, condicion, fecha, importe_total, observacion,  situacion FROM mantenimientos WHERE="+codigo+";";
//abrir una conexion
        ConexionManager.conectar();
        
        Mantenimientos mantenimientos = null;
        
        ResultSet rs;
        
        try {
            //ejecutar sql
            
            rs = ConexionManager.stm.executeQuery(sql);
            System.out.println("Ejecutando: "+sql);
            
           while (rs.next()) {
                mantenimientos = new Mantenimientos();
                mantenimientos.setCliente_codigo(rs.getInt("cliente_codigo"));
                mantenimientos.setCondicion(rs.getString("condicion"));
                mantenimientos.setFecha(rs.getDate("fecha"));
                mantenimientos.setImporte_total(rs.getDouble("import_total"));
                mantenimientos.setObservacion(rs.getString("observacion"));
                mantenimientos.setSituacion(rs.getString("situacion"));
            
                  
           }
            
        } catch (SQLException ex) {
            Logger.getLogger(CiudadDaoImple.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al ejecutar SQL: "+ex);

        }
        //cerrar conexion
        ConexionManager.desconectar();
        return mantenimientos;
    }

    @Override
    public List<Mantenimientos> recuperporFiltro(String filtro) {
  String sql= "SELECT codigo , cliente_codigo, condicion, fecha, importe_total, observacion,  situacion"
          + " FROM mantenimientos"
          + "WHERE(cliente_codigoLIKE '%"+filtro+"%')"
           + "or (condicion LIKE '%"+filtro+"%')"
           + "or (fecha LIKE '%"+filtro+"%')"
           + "or (importe_total LIKE '%"+filtro+"%')"
            + "or (observacion LIKE '%"+filtro+"%')"
           + "or (situacion LIKE '%"+filtro+"%')"
               + " order by codigo;";
  
            
        List<Mantenimientos> lista = new ArrayList<>();
        
        System.out.println("SQL = " + sql);
        
        
        //abrir una conexion
        ConexionManager.conectar();
        
        Mantenimientos mantenimientos = null;
        
        ResultSet rs;
        
        try {
            //ejecutar sql
            
            rs = ConexionManager.stm.executeQuery(sql);
            
            System.out.println("Ejecutando: "+sql);

            
            while (rs.next()) {
                
                mantenimientos = new Mantenimientos();
                
                mantenimientos.setCodigo(rs.getInt("codigo"));
                mantenimientos.setCliente_codigo(rs.getInt("Cliente_codigo"));
                mantenimientos.setCondicion(rs.getString("Condicion"));
                mantenimientos.setFecha(rs.getDate("fecha"));
                mantenimientos.setImporte_total(rs.getDouble("importe_total"));
                mantenimientos.setObservacion(rs.getString("observacion"));
                mantenimientos.setSituacion(rs.getString("situacion"));
                
                //Agregara a la lista
                lista.add(mantenimientos);
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

    
    