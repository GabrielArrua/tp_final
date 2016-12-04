/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.edu.facitec.mec.controller;

import java.util.List;
import py.edu.facitec.mec.dao.ServicioDaoImple;
import py.edu.facitec.mec.dao.ServiciosDao;
import py.edu.facitec.mec.model.Servicios;

/**
 *
 * @author user
 */
public class ServicioControlleImple implements ServicioController{
       private ServiciosDao serviciosDao;
       public ServicioControlleImple(){
           this.serviciosDao= new ServicioDaoImple();
       }
    
    
    
    @Override
    public void guardar(Servicios servicios) {
     serviciosDao.guardar(servicios);
    
    }

    @Override
    public void eliminar(int codigo) {
   serviciosDao.eliminar(codigo);
    
    }

    @Override
    public boolean modificar(Servicios servicios) {
   return serviciosDao.modificar(servicios);
    
    }

    @Override
    public List<Servicios> recuperarPorFiltro(String filtro) {
    return  serviciosDao.recuperarPorFiltro(filtro);
    }

    @Override
    public Servicios recuperarPorCodigo(int codigo) {
    return serviciosDao.recuperarPorCodigo(codigo);
    
    }
    
}
