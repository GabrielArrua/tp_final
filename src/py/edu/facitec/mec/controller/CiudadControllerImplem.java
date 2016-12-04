/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.edu.facitec.mec.controller;

import java.util.List;
import py.edu.facitec.mec.dao.CiudadDao;
import py.edu.facitec.mec.dao.CiudadDaoImple;
import py.edu.facitec.mec.model.Ciudad;

/**
 *
 * @author user
 */
public class CiudadControllerImplem implements CiudadController{
    
    private CiudadDao ciudadDao;
    
    public CiudadControllerImplem(){
        this.ciudadDao = new CiudadDaoImple();
    }
    

    @Override
    public void guardar(Ciudad ciudad) {
    ciudadDao.guardar(ciudad);
    
    }

   

    @Override
    public void eliminar(int codigo) {
   ciudadDao.eliminar(codigo);
    }

    @Override
    public boolean  modificar(Ciudad ciudad) {
    return ciudadDao.modificar(ciudad);
            
    }

    @Override
    public Ciudad recuperarPorCodigo(int codigo) {
     return ciudadDao.recuperarPorCodigo(codigo);
    
    }

    @Override
    public List<Ciudad> recuperarPorFiltro(String filtro) {
     return ciudadDao.recuperarPorFiltro(filtro);
    }
}
