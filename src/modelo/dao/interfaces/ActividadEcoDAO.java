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
public interface ActividadEcoDAO {
 
    public Boolean registrarActivEco(modelo.dto.ActividadEcoDTO ac);
    public Boolean modificarActivEco(modelo.dto.ActividadEcoDTO ac);
    public Boolean eliminarActivEco(modelo.dto.ActividadEcoDTO ac);
    public modelo.dto.ActividadEcoDTO buscarActividadEcoID(int idActivEco);
    public modelo.dto.ActividadEcoDTO buscarActividadEcoNombre(String ActivEco);
    public ArrayList<modelo.dto.ActividadEcoDTO> mostrarActividadEco();
    
}
