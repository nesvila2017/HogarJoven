/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao.interfaces;

import java.util.ArrayList;
import modelo.dto.ClasifProveedorDTO;

/**
 *
 * @author Fucker
 */
public interface ClasifProveedorDAO {
    public Boolean ingresarClasifProveed(ClasifProveedorDTO c);
    public Boolean modificarClasifProveed(ClasifProveedorDTO c);
    public Boolean eliminarClasifProveed(ClasifProveedorDTO c);
    public ClasifProveedorDTO buscarClasifProveedID(int idClasif);
    public ClasifProveedorDTO buscarClasifProveedNombre(String clasif);
    public ArrayList<ClasifProveedorDTO> mostrarClasificacionesProveedores();
    
    
}
