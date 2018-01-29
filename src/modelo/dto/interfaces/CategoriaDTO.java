/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dto.interfaces;

import java.util.ArrayList;
import modelo.dao.CategoriaDAO;

/**
 *
 * @author Fucker
 */
public interface CategoriaDTO {
  public Boolean registrarCategoria(CategoriaDAO c);
  public Boolean modificarCategoria(CategoriaDAO c);
  public Boolean eliminarCategoria(CategoriaDAO c);
  public CategoriaDAO buscarCategaria(int idCategoria);
  public ArrayList<CategoriaDAO> mostrarCategarias();
  
}
