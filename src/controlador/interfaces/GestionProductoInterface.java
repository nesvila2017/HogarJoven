/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.interfaces;

import java.util.ArrayList;
import modelo.dto.ProductoDTO;

/**
 *
 * @author Fucker
 */
public interface GestionProductoInterface {
    
    
    public boolean registrarProducto(ProductoDTO p);
    public ProductoDTO busquedaProductoID(int id);
    public ProductoDTO busquedaPorNombre(String nom);
    public boolean modificarProducto(ProductoDTO p);
    public boolean eliminarProducto(ProductoDTO p);
    public ArrayList<ProductoDTO> mostrarProductos();
    
      
    
    
}
