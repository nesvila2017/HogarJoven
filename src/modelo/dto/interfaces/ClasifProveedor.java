/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dto.interfaces;

import java.util.ArrayList;
import modelo.dao.ClasifProveedorDAO;

/**
 *
 * @author Fucker
 */
public interface ClasifProveedor {
    public Boolean ingresarClasifProveed(ClasifProveedorDAO c);
    public Boolean modificarClasifProveed(ClasifProveedorDAO c);
    public Boolean eliminarClasifProveed(ClasifProveedorDAO c);
    public ClasifProveedorDAO buscarClasifProveedID(int idClasif);
    public ClasifProveedorDAO buscarClasifProveedNombre(String clasif);
    public ArrayList<ClasifProveedorDAO> mostrarClasificacionesProveedores();
    
    
}
