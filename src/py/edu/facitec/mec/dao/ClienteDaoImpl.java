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
import py.edu.facitec.mec.model.Cliente;
import py.edu.facitec.mec.util.ConexionManager;

/**
 *
 * @author user
 */
public class ClienteDaoImpl implements ClienteDao{

    @Override
    public void guardar(Cliente cliente) {
        
        String sql  =  "INSERT INTO clientes("
                + "nombres, credito, apellido, direccion, ciudad_codigo, celular, estado) "
                + "VALUES ('"+cliente.getNombre()+"', "+cliente.getCredito()+", '"+cliente.getApellido()+"', "
                + "'"+cliente.getDireccion()+"', "+cliente.getCiudad_codigo()+", '"+cliente.getCelular()+"', "+cliente.getEstado()+");";
         
        
        
         ConexionManager.conectar();
         
        try {
            ConexionManager.stm.execute(sql);
            System.out.println("SQL = "+sql);
        
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("error "+ex);
        
        }
         
         ConexionManager.desconectar();
        
    }

    @Override
    public Cliente buscarClientePorCodigo(int codigo) {
        String sql ="select nombres, apellidos,direccion from cliente where codigo="+codigo+"";
  Cliente cliente = null;
    ConexionManager.conectar();
  ResultSet rs;
        try {
            rs = ConexionManager.stm.executeQuery(sql);
           if(rs.next()){// si hubo resultado el sql
             cliente = new Cliente();// instanciamos la clase cliente
      cliente.setNombre(rs.getString("nombres"));//seteamos los valores a los atributos
      cliente.setApellido(rs.getString("apellidos"));
      cliente.setDireccion(rs.getString("direccion"));
      //cliente.setCodigo(rs.getDouble("codigo"));
        }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
      ConexionManager.desconectar();//cerramos la conxion
     return cliente;//retornamos el obj cliente
    
      
  }

    @Override
    public boolean modificarCliente(Cliente cliente) {
    String sql=  "UPDATE clientes "
            + "SET nombres='"+cliente.getNombre()+"', credito="+cliente.getCredito()+","
            + " apellido='"+cliente.getApellido()+"', direccion='"+cliente.getDireccion()+"', "
            + "ciudad_codigo='"+cliente.getCiudad_codigo()+"', celular='"+cliente.getCelular()+"',"
            + " estado="+cliente.getEstado()+", "
            + "WHERE codigo="+cliente.getCodigo()+";";
            
    boolean resultado = false ;//decclarar inicializar una variable
            ConexionManager.conectar();
        try {
         resultado = ConexionManager.stm.execute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            ConexionManager.desconectar();
            return resultado;
            
            
            
            
         
          //  where codigo=  ";
    }
// + "//% tiene q considirr
    @Override
    public void eliminar(int codigo) {
      //sql
      String sql ="delete from clientes where codigo"+codigo+"";
      ConexionManager.conectar();
        try {
          ConexionManager.stm.execute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConexionManager.desconectar();//cerramos la conxion
   //  return cliente;//retornamos el obj cliente
    
            
    }

    @Override// colliction  generic<>_>
    public List<Cliente> buscarClientesPorFiltro(String filtro) {
     String sql = "SELECT codigo, nombres, credito, apellido, direccion "
                + "FROM public.clientes "
                + "WHERE (nombres LIKE '%"+filtro+"%') "
                + "or (apellido LIKE '%"+filtro+"%') "
                + "or (direccion LIKE '%"+filtro+"%');";
        
        List<Cliente> lista = new ArrayList<>();
        
        System.out.println("SQL = " + sql);
        
        //abrir una conexion
        ConexionManager.conectar();
        
        Cliente cliente = null;
        
        ResultSet rs;
        
        try {
            //ejecutar sql
            
            rs = ConexionManager.stm.executeQuery(sql);
            
            System.out.println("Ejecutando: "+sql);

            
            while (rs.next()) {
                
                cliente = new Cliente();
                
                cliente.setCodigo(rs.getInt("codigo"));
                cliente.setNombre(rs.getString("nombres"));
                cliente.setCredito(rs.getDouble("credito"));
                cliente.setApellido(rs.getString("apellido"));
                cliente.setDireccion(rs.getString("direccion"));
                
                
                //Agregara a la lista
                lista.add(cliente);
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
    
    
    
    
                
   
    

