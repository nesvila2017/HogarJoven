/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import modelo.dao.ProductoDAO;

/**
 *
 * @author Fucker
 */
public interface GestionProductoInterface {
    
    
    public boolean registrarProducto(ProductoDAO p);
    public ProductoDAO busquedaProductoID(int id);
    public ProductoDAO busquedaPorNombre(String nom);
    public boolean modificarProducto(ProductoDAO p);
    public boolean eliminarProducto(ProductoDAO p);
    public ArrayList<ProductoDAO> mostrarProductos();
    
      
    
    
}
