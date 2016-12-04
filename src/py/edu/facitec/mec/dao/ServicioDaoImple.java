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
import py.edu.facitec.mec.model.Servicios;
import py.edu.facitec.mec.util.ConexionManager;

/**
 *
 * @author user
 */
public class ServicioDaoImple implements ServiciosDao{

 private String sql;

    @Override
    public void guardar(Servicios servicios) {
      String sql =" INSERT INTO servicios("
              + "descripcion, valor_unitario, nombre, estado)"
              + "VALUES ('"+servicios.getDescripcion()+"',"
              + " "+servicios.getValor_unitario()+",'"+servicios.getNombre()+"',"
              + ""+servicios.getEstado()+")";
               
              
                ConexionManager.conectar();
                
        try {
            ConexionManager.stm.execute(sql);
              System.out.println("SQL="+ sql);
        } catch (SQLException ex) {
            Logger.getLogger(ServicioDaoImple.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConexionManager.desconectar();
    }

    @Override
    public boolean modificar(Servicios servicios) {
   
      sql = "UPDATE servicios "
                + "SET nombre='"+servicios.getNombre()+"', descripcion='"+servicios.getDescripcion()+"', "
                + "Valor_unitario="+servicios.getValor_unitario()+", estado="+servicios.getEstado()+", "
                + "WHERE codigo="+servicios.getCodigo()+";";
        boolean resultado= false;
        ConexionManager.conectar();
        
        try {
         resultado=   ConexionManager.stm.execute(sql);
            
        } catch (SQLException ex) {
            Logger.getLogger(ServicioDaoImple.class.getName()).log(Level.SEVERE, null, ex);
           
        }
        
        ConexionManager.desconectar();
    return resultado;
            
   }

    @Override
    public void eliminar(int codigo) {
   String sql ="DELETE FROM servicios  WHERE codigo="+codigo+"";
        System.out.println("SQL="+ sql);
        
        ConexionManager.conectar();

        try {
            //ejecutar sql
            ConexionManager.stm.execute(sql);
            System.out.println("Ejecutando: "+sql);

        } catch (SQLException ex) {

            Logger.getLogger(CiudadDaoImple.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al ejecutar "+ ex);

        }
        
        
        
    
    }

    @Override
    public List<Servicios> recuperarPorFiltro(String filtro) {
List<Servicios> lista = new ArrayList<>();
        
      String  sql = "SELECT codigo, nombre, descripcion, valor_unitario, estado FROM servicios;";
        
        Servicios servicio = null;
        
        ConexionManager.conectar();
        
        try {
            ResultSet rs = ConexionManager.stm.executeQuery(sql);
            System.out.println("SQL "+sql);
            
            while(rs.next()) {
                servicio = new Servicios();
                servicio.setCodigo(rs.getInt("codigo"));
                servicio.setNombre(rs.getString("nombre"));
                servicio.setDescripcion(rs.getString("descripcion"));
                servicio.setValor_unitario(rs.getDouble("valor_unitario"));
                servicio.setEstado(rs.getBoolean("estado"));
                lista.add(servicio);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ServicioDaoImple.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al ejecutar sql "+ex);
        }
        
        ConexionManager.desconectar();
        
        return lista;
    }

    @Override
    public Servicios recuperarPorCodigo(int codigo) {
   
     sql = "SELECT nombre, descripcion, valor_unitario, estado "
                + "FROM public.servicio "
                + "WHERE codigo="+codigo+";";
        
        Servicios servicio = null;
        
        ConexionManager.conectar();
        
        try {
            ResultSet rs = ConexionManager.stm.executeQuery(sql);
            System.out.println("SQL "+sql);
            
            if (rs.next()) {
                servicio = new Servicios();
                servicio.setNombre(rs.getString("nombre"));
                servicio.setDescripcion(rs.getString("descripcion"));
                servicio.setValor_unitario(rs.getDouble("valor_unitario"));
                servicio.setEstado(rs.getBoolean("estado"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ServicioDaoImple.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al ejecutar sql "+ex);
        }
        
        ConexionManager.desconectar();
        
        return servicio;
    }
    
    }

