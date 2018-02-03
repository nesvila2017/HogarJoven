/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao.interfaces;

import java.util.ArrayList;
import modelo.dto.CategoriaDTO;

/**
 *
 * @author Fucker
 */
public interface CategoriaDAO {
  public Boolean registrarCategoria(CategoriaDTO c);
  public Boolean modificarCategoria(CategoriaDTO c);
  public Boolean eliminarCategoria(CategoriaDTO c);
  public modelo.dto.CategoriaDTO buscarCategaria(int idCategoria);
  public ArrayList<modelo.dto.CategoriaDTO> mostrarCategorias();
  public String nameCategoria(int id);
}
