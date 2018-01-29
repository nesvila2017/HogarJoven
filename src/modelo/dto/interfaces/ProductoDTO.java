/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dto.interfaces;

import java.util.ArrayList;
import modelo.dao.ProductoDAO;

/**
 *
 * @author Fucker
 */
public interface ProductoDTO {

    public boolean registrarProducto(ProductoDAO p);
    public boolean modificarProducto(ProductoDAO p);
    public boolean eliminarPorID(int id);
    public boolean estadoProducto(boolean estado);
    public ProductoDAO buscarProductoId(int id);
    public ProductoDAO buscarProductoCodBarra(int codBarra);
    public ArrayList<ProductoDAO> buscarProductoDescripcion(String busqueda);
    public ArrayList<ProductoDAO> buscarProductosEstado(boolean estado);
    public ArrayList<ProductoDAO> buscarProductosMarca(String busqueda);
    public ArrayList<ProductoDAO> buscarProductosModelo(String busqueda);
    public ArrayList<ProductoDAO> buscarProductosCategoria(String busqueda);
    public ArrayList<ProductoDAO> buscarProductosProveedor(String busqueda);
    public ArrayList<ProductoDAO> mostrarProductos();
    
}
