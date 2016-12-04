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
import py.edu.facitec.mec.util.ConexionManager;

/**
 *
 * @author user
 */
public class CiudadDaoImple  implements CiudadDao{

    @Override
    public void guardar(Ciudad ciudad) {
    
    String sql  = "insert into Ciudad(nombre,iso,estado )"
            +" values('"+ciudad.getNombre()+"', '"+ciudad.getIso()+"',"+ciudad.getEstado()+" );";
     ConexionManager.conectar();
       
       
       
        
        try {
            ConexionManager.stm.execute(sql);
             System.out.println("SQL ="+ sql );
        } catch (SQLException ex) {
            Logger.getLogger(CiudadDaoImple.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ConexionManager.desconectar();
        
    }

    /**
     *
     * @param ciudad
     * @return
     */
    
    
    @Override
    public boolean modificar(Ciudad ciudad) {
      
   String sql = "UPDATE ciudad"
                + "SET nombre='"+ciudad.getNombre()+"',"
                + " iso='"+ciudad.getIso()+"',"
                + " estado="+ciudad.getEstado()+""
                + "WHERE codigo="+ciudad.getCodigo()+";";
    boolean resultado = false;
     ConexionManager.conectar();
        try {
            //ejecutar sql
            resultado = ConexionManager.stm.execute(sql);
        } catch (SQLException ex) {
            
            Logger.getLogger(CiudadDaoImple.class.getName()).log(Level.SEVERE, null, ex);
            
        }

        //cerrar conexion
        ConexionManager.desconectar();
        
        return resultado;
           
    }

    @Override
    public void eliminar(int codigo) {
       String sql = "DELETE FROM ciudad WHERE codigo ="+codigo+"";
        
        System.out.println("SQL = "+sql);
        
        //abrir una conexion
        ConexionManager.conectar();

        try {
            //ejecutar sql
            ConexionManager.stm.execute(sql);
            System.out.println("Ejecutando: "+sql);

        } catch (SQLException ex) {

            Logger.getLogger(CiudadDaoImple.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al ejecutar "+ ex);

        }

        //cerrar conexion
        ConexionManager.desconectar();
    }

    @Override
    public Ciudad recuperarPorCodigo(int codigo) {
   
    String sql = "SELECT nombre, iso, estado FROM ciudad WHERE codigo="+codigo+";";
        
        //abrir una conexion
        ConexionManager.conectar();
        
        Ciudad ciudad = null;
        
        ResultSet rs;
        
        try {
            //ejecutar sql
            
            rs = ConexionManager.stm.executeQuery(sql);
            System.out.println("Ejecutando: "+sql);
            
           while (rs.next()) {
                ciudad = new Ciudad();
                ciudad.setNombre(rs.getString("nombre"));
                ciudad.setIso(rs.getString("iso"));
                ciudad.setEstado(rs.getBoolean("estado"));
            
                  
           }
            
        } catch (SQLException ex) {
            Logger.getLogger(CiudadDaoImple.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al ejecutar SQL: "+ex);

        }
        //cerrar conexion
        ConexionManager.desconectar();
        return ciudad;
    }

    @Override
    public List<Ciudad> recuperarPorFiltro(String filtro) {
    String sql = "SELECT codigo, nombre, iso "
                + "FROM ciudad"
                + " WHERE(nombre LIKE '%"+filtro+"%') "
                + "or (iso LIKE '%"+filtro+"%')"
                + " order by codigo;";
        
        List<Ciudad> lista = new ArrayList<>();
        
        System.out.println("SQL = " + sql);
        
        
        //abrir una conexion
        ConexionManager.conectar();
        
        Ciudad ciudad = null;
        
        ResultSet rs;
        
        try {
            //ejecutar sql
            
            rs = ConexionManager.stm.executeQuery(sql);
            
            System.out.println("Ejecutando: "+sql);

            
            while (rs.next()) {
                
                ciudad = new Ciudad();
                
                ciudad.setCodigo(rs.getInt("codigo"));
                ciudad.setNombre(rs.getString("nombre"));
                ciudad.setIso(rs.getString("iso"));
                
                //Agregara a la lista
                lista.add(ciudad);
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

