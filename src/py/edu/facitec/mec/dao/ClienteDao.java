/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.edu.facitec.mec.dao;

import java.util.List;
import py.edu.facitec.mec.model.Cliente;

/**
 *
 * @author user
 */
public interface ClienteDao {
    void guardar(Cliente cliente);
   Cliente buscarClientePorCodigo(int codigo);
   boolean modificarCliente(Cliente cliente); 
   void eliminar(int codigo);
  List<Cliente> buscarClientesPorFiltro(String filtro);
}
