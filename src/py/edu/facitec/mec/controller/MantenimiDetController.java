/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.edu.facitec.mec.controller;

import java.util.List;
import py.edu.facitec.mec.model.MantenimientoDet;

/**
 *
 * @author user
 */
public interface MantenimiDetController {
    void guardar(MantenimientoDet matMantenimientoDet);
    boolean modificar(MantenimientoDet mantenimientoDet);
    void eliminar(int codigo);
     MantenimientoDet recupererPorCodigo(int codigo);
    List<MantenimientoDet>recuperporFiltro(String filtro);
}
