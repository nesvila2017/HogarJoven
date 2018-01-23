/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import modelo.dao.Producto;
import modelo.dto.ProductoDTOImpl;

/**
 *
 * @author Fucker
 */
public class GestionProducto implements GestionProductoInterface {

    private ArrayList<Producto> contenedorProducto;
    private ProductoDTOImpl pdto = new ProductoDTOImpl();
    
    public GestionProducto() {
        contenedorProducto = new ArrayList<>();
        //contenedorProducto.add(new Producto(1, 123, "Salchichon", "Porquerias", "Burro","Uña", "Vieja", "Jorge", "La Fama de Jorge"));
    }

    private boolean existeProducto(Producto p) {
        for (Producto producto : contenedorProducto) {
            if (producto.equals(p)) {
                return true;
            }
        }
        return false;
    }

    public boolean registroProductos(Producto p){
        pdto.registrarProducto(p, 1, 2);
        return true;
    }
    
    @Override
    public boolean registrarProducto(Producto p) {
        if (existeProducto(p)) {
            return false;
        } else {
            contenedorProducto.add(p);
            return true;
        }
    }

    @Override
    public Producto busquedaProductoID(int id) {
        for (int i = 0; i < contenedorProducto.size(); i++) {
            if (contenedorProducto.get(i).getIdProducto().equals(id)) {
                return contenedorProducto.get(i);
            }

        }
        return null;
    }

    @Override
    public Producto busquedaPorNombre(String nom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modificarProducto(Producto p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminarProducto(Producto p) {
        if (existeProducto(p)) {

            return contenedorProducto.remove(p);
        } else {
            return false;
        }
    }

    @Override
    public ArrayList<Producto> mostrarProductos() {
        return contenedorProducto;
    }

}
