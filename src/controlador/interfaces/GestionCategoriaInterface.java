/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.interfaces;

import java.util.ArrayList;
import modelo.dto.CategoriaDTO;

/**
 *
 * @author Fucker
 */
public interface GestionCategoriaInterface {
    
    public Boolean registrarCategoria(CategoriaDTO c);
    public Boolean modificarCategoria(CategoriaDTO c);
    public Boolean eliminarCategoria(CategoriaDTO c);
    public CategoriaDTO buscarCategoriaID(int id);
    public CategoriaDTO buscarCategoriaNombre(String cat);
    public ArrayList<CategoriaDTO> mostrarCategorias();
}
