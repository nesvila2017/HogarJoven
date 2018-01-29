/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dto.interfaces;

import java.util.ArrayList;
import modelo.dao.ClienteDAO;

/**
 *
 * @author Fucker
 */
public interface ClienteDTO {
    public Boolean registrarCliente(ClienteDAO c);
    public Boolean modificarCliente(ClienteDAO c);
    public Boolean eliminarCliente(ClienteDAO c);
    public ClienteDAO buscarClienteNumIdent(ClienteDAO c);
    public ArrayList<ClienteDAO> mostrarClientes();
    public ArrayList<ClienteDAO> mostrarClientesPorNombre(String criterio);
    public ArrayList<ClienteDAO> mostrarClientesPorApellido(String criterio);
    public ArrayList<ClienteDAO> mostrarClientesPorNaturaleza(String criterio);
    
    
}
