/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dto;

import java.util.ArrayList;
import modelo.dao.CategoriaDAO;
import modelo.dto.interfaces.CategoriaDTO;

/**
 *
 * @author Fucker
 */
public class CategoriaDTOImpl implements CategoriaDTO{

    @Override
    public Boolean registrarCategoria(CategoriaDAO c) {
        //INSERT INTO `inventariohogar`.`categoria` (`idCategoria`, `descripCat`) VALUES ('?', 'COMIDA');
        return false;
    }

    @Override
    public Boolean modificarCategoria(CategoriaDAO c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean eliminarCategoria(CategoriaDAO c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CategoriaDAO buscarCategaria(int idCategoria) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<CategoriaDAO> mostrarCategarias() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
