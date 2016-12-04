/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.edu.facitec.mec.controller;

import java.util.List;
import py.edu.facitec.mec.dao.MantenimientoDao;
import py.edu.facitec.mec.dao.MantenimientoDaoImple;
import py.edu.facitec.mec.model.Mantenimientos;

/**
 *
 * @author user
 */
public class MantenimientoControllerImp implements MantenimientoController{
    private MantenimientoDao mantenimientoDao;
    public MantenimientoControllerImp(){
        this.mantenimientoDao = new MantenimientoDaoImple();
    }

    @Override
    public void Guardar(Mantenimientos mantenimientos) {
        mantenimientoDao.Guardar(mantenimientos);
    }

    @Override
    public boolean modificar(Mantenimientos mantenimientos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(int codigo) {
   mantenimientoDao.eliminar(codigo);
    
    }

    @Override
    public Mantenimientos recupererPorCodigo(int codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Mantenimientos> recuperporFiltro(String filtro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
