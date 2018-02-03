/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao.interfaces;

import database.Conexion;
import java.util.ArrayList;
import modelo.dto.ProductoDTO;

/**
 *
 * @author Fucker
 */
public interface ProductoDAO {

    public boolean registrarProducto(ProductoDTO p, Conexion c);
    public boolean modificarProducto(ProductoDTO p, Conexion c);
    public boolean eliminarPorID(int id, Conexion c);
    public boolean estadoProducto(boolean estado, Conexion c);
    public modelo.dto.ProductoDTO buscarProductoId(int id, Conexion c);
    public modelo.dto.ProductoDTO buscarProductoCodBarra(int codBarra, Conexion c);
    public ArrayList<modelo.dto.ProductoDTO> buscarProductoDescripcion(String busqueda, Conexion c);
    public ArrayList<modelo.dto.ProductoDTO> buscarProductosEstado(boolean estado, Conexion c);
    public ArrayList<modelo.dto.ProductoDTO> buscarProductosMarca(String busqueda,Conexion c);
    public ArrayList<modelo.dto.ProductoDTO> buscarProductosModelo(String busqueda,Conexion c);
    public ArrayList<modelo.dto.ProductoDTO> buscarProductosCategoria(String busqueda,Conexion c);
    public ArrayList<modelo.dto.ProductoDTO> buscarProductosProveedor(String busqueda,Conexion c);
    public ArrayList<modelo.dto.ProductoDTO> mostrarProductos(Conexion c );
    
}
