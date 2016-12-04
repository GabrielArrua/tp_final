/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.edu.facitec.mec.dao;

import java.util.List;
import py.edu.facitec.mec.model.Mantenimientos;

/**
 *
 * @author user
 */
public interface MantenimientoDao {
    void Guardar(Mantenimientos mantenimientos);
    boolean modificar(Mantenimientos mantenimientos);
    void eliminar(int codigo);
    Mantenimientos recupererPorCodigo(int codigo);
    List<Mantenimientos>recuperporFiltro(String filtro);
}
