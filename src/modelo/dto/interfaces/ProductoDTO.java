/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dto.interfaces;

import java.util.ArrayList;
import modelo.dao.Producto;

/**
 *
 * @author Fucker
 */
public interface ProductoDTO {

    public boolean registrarProducto(Producto p,int idCat, int idProv);
    public boolean modificarProducto(Producto p);
    public boolean eliminarPorID(int id);
    public boolean estadoProducto(boolean estado);
    public Producto buscarProductoId(int id);
    public Producto buscarProductoCodBarra(int codBarra);
    public ArrayList<Producto> buscarProductoDescripcion(String busqueda);
    public ArrayList<Producto> buscarProductosEstado(boolean estado);
    public ArrayList<Producto> buscarProductosMarca(String busqueda);
    public ArrayList<Producto> buscarProductosModelo(String busqueda);
    public ArrayList<Producto> buscarProductosCategoria(String busqueda);
    public ArrayList<Producto> buscarProductosProveedor(String busqueda);
    public ArrayList<Producto> mostrarProductos();
    
}
