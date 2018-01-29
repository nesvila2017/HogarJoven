/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dto.interfaces;

import modelo.dao.DetalleInventarioDAO;

/**
 *
 * @author Fucker
 */
public interface DetalleInventario {
    
    public Boolean registroDetalleInventario(DetalleInventarioDAO di);
    public Boolean modificarDetalleInventario(DetalleInventarioDAO di);
    public Boolean eliminarDetalleInventario(DetalleInventarioDAO di);
    public DetalleInventarioDAO buscarDetalleInventID(int idDetalle, int idInventario);
    public DetalleInventarioDAO buscarDetalleInventFactIDNomProducto(int idDetalle, String nomProd);
    public DetalleInventarioDAO buscarDetalleInventFactIDMovimiento(int idDetalle, String nomProd);
    
    
    
}
