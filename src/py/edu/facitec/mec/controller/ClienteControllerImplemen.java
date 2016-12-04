/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.edu.facitec.mec.controller;

import java.util.List;
import py.edu.facitec.mec.dao.ClienteDao;
import py.edu.facitec.mec.dao.ClienteDaoImpl;
import py.edu.facitec.mec.model.Cliente;

/**
 *
 * @author user
 */
public class ClienteControllerImplemen implements ClienteController{
    private ClienteDao clienteDao;

    public ClienteControllerImplemen() {
        
        this.clienteDao= new ClienteDaoImpl();
    }
   
    @Override
    
    public void guardarCliente(Cliente cliente) {
        
       clienteDao.guardar(cliente);
    
}

 @Override
    public Cliente buscarClientePorCodigo(int codigo) {
      return clienteDao.buscarClientePorCodigo(codigo);
    }

    @Override
    public List<Cliente> buscarClientePorFiltro(String busqueda) {
    return clienteDao.buscarClientesPorFiltro(busqueda);
    }

    @Override
    public boolean modificarCliente(Cliente cliente) {
    return clienteDao.modificarCliente(cliente);
    }

    @Override
    public void eliminarCliente(int codigo) {
    clienteDao.eliminar(codigo);
    }

    @Override
    public void eliminar(Cliente cliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
    
