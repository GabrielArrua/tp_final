/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.edu.facitec.mec.controller;

import java.util.List;
import py.edu.facitec.mec.dao.MantenimientoDelDaoImpl;
import py.edu.facitec.mec.dao.MantenimientoDetDao;
import py.edu.facitec.mec.model.MantenimientoDet;

/**
 *
 * @author user
 */
public class MantenimDelControllImplem implements MantenimiDetController{
    private MantenimientoDetDao mantenimientoDetDao;

    public MantenimDelControllImplem() {
    this.mantenimientoDetDao= new MantenimientoDelDaoImpl();
    }
    

    @Override
    public void guardar(MantenimientoDet matMantenimientoDet) {
  mantenimientoDetDao.guardar(matMantenimientoDet);
    }

    @Override
    public boolean modificar(MantenimientoDet mantenimientoDet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(int codido) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public MantenimientoDet recupererPorCodigo(int codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<MantenimientoDet> recuperporFiltro(String filtro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
