/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.io.Serializable;

/**
 *
 * @author Fucker
 */
public class CategoriaDAO implements Serializable{
    private Integer idCategoria;
    private String descripCat;

    public CategoriaDAO() {
    }
    
    public CategoriaDAO(Integer idCategoria, String descripCat) {
        this.idCategoria = idCategoria;
        this.descripCat = descripCat;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getDescripCat() {
        return descripCat;
    }

    public void setDescripCat(String descripCat) {
        this.descripCat = descripCat;
    }

    @Override
    public String toString() {
        return "Categoria{" + "idCategoria=" + idCategoria + ", descripCat=" + descripCat + '}';
    }
    
    
}
