/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao.interfaces;

import modelo.dto.DetalleInventarioDTO;

/**
 *
 * @author Fucker
 */
public interface DetalleInventarioDAO {
    
    public Boolean registroDetalleInventario(DetalleInventarioDTO di);
    public Boolean modificarDetalleInventario(DetalleInventarioDTO di);
    public Boolean eliminarDetalleInventario(DetalleInventarioDTO di);
    public DetalleInventarioDTO buscarDetalleInventID(int idDetalle, int idInventario);
    public DetalleInventarioDTO buscarDetalleInventFactIDNomProducto(int idDetalle, String nomProd);
    public DetalleInventarioDTO buscarDetalleInventFactIDMovimiento(int idDetalle, String nomProd);
    
    
    
}
