/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao.interfaces;

import java.util.ArrayList;

/**
 *
 * @author Fucker
 */
public interface ClienteDAO {
    public Boolean registrarCliente(modelo.dto.ClienteDTO c);
    public Boolean modificarCliente(modelo.dto.ClienteDTO c);
    public Boolean eliminarCliente(modelo.dto.ClienteDTO c);
    public modelo.dto.ClienteDTO buscarClienteNumIdent(modelo.dto.ClienteDTO c);
    public ArrayList<modelo.dto.ClienteDTO> mostrarClientes();
    public ArrayList<modelo.dto.ClienteDTO> mostrarClientesPorNombre(String criterio);
    public ArrayList<modelo.dto.ClienteDTO> mostrarClientesPorApellido(String criterio);
    public ArrayList<modelo.dto.ClienteDTO> mostrarClientesPorNaturaleza(String criterio);
    
    
}
