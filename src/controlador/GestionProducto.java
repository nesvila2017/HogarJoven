/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import modelo.dao.ProductoDAO;
import modelo.dto.ProductoDTOImpl;

/**
 *
 * @author Fucker
 */
public class GestionProducto implements GestionProductoInterface {

    private ArrayList<ProductoDAO> contenedorProducto;
    private ProductoDTOImpl pdto = new ProductoDTOImpl();
    
    public GestionProducto() {
        contenedorProducto = new ArrayList<>();
        //contenedorProducto.add(new Producto(1, 123, "Salchichon", "Porquerias", "Burro","Uña", "Vieja", "Jorge", "La Fama de Jorge"));
    }

    private boolean existeProducto(ProductoDAO p) {
        for (ProductoDAO producto : contenedorProducto) {
            if (producto.equals(p)) {
                return true;
            }
        }
        return false;
    }

    public boolean registroProductos(ProductoDAO p){
        pdto.registrarProducto(p);
        return true;
    }
    
    @Override
    public boolean registrarProducto(ProductoDAO p) {
        if (existeProducto(p)) {
            return false;
        } else {
            contenedorProducto.add(p);
            return true;
        }
    }

    @Override
    public ProductoDAO busquedaProductoID(int id) {
        for (int i = 0; i < contenedorProducto.size(); i++) {
            if (contenedorProducto.get(i).getIdProducto().equals(id)) {
                return contenedorProducto.get(i);
            }

        }
        return null;
    }

    @Override
    public ProductoDAO busquedaPorNombre(String nom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modificarProducto(ProductoDAO p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminarProducto(ProductoDAO p) {
        if (existeProducto(p)) {

            return contenedorProducto.remove(p);
        } else {
            return false;
        }
    }

    @Override
    public ArrayList<ProductoDAO> mostrarProductos() {
        
        return pdto.mostrarProductos();
    }

}
