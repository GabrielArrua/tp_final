/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.edu.facitec.mec.controller;

import java.util.List;
import py.edu.facitec.mec.model.Ciudad;

/**
 *
 * @author user
 */
public interface CiudadController {
    void guardar(Ciudad ciudad);
    boolean modificar(Ciudad ciudad);
    void eliminar (int codigo);
     Ciudad recuperarPorCodigo(int codigo); 
    List<Ciudad>recuperarPorFiltro(String filtro);
}
