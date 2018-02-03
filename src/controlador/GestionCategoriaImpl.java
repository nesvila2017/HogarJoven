/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import controlador.interfaces.GestionCategoriaInterface;
import java.util.ArrayList;
import modelo.dao.CategoriaDAOImpl;
import modelo.dao.interfaces.CategoriaDAO;
import modelo.dto.CategoriaDTO;

/**
 *
 * @author Fucker
 */
public class GestionCategoriaImpl implements GestionCategoriaInterface {


    private CategoriaDAO cat;

    public GestionCategoriaImpl() {
         cat= new CategoriaDAOImpl();
    }

    @Override
    public Boolean registrarCategoria(CategoriaDTO c) {
       
        
        return true;
    }

    @Override
    public Boolean modificarCategoria(CategoriaDTO c) {
       
      return true;
    }

    @Override
    public Boolean eliminarCategoria(CategoriaDTO c) {

      return true;
    }

    @Override
    public CategoriaDTO buscarCategoriaID(int id) {
        
        return null;

    }
    
    public String buscarNombreCategoriaID(int id) {
        
        return cat.nameCategoria(id);

    }

    @Override
    public CategoriaDTO buscarCategoriaNombre(String cat) {
     return null;

    }

    @Override
    public ArrayList<CategoriaDTO> mostrarCategorias() {
        return cat.mostrarCategorias();
    }

  

}
