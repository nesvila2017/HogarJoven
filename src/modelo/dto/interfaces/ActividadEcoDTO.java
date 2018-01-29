/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dto.interfaces;

import java.util.ArrayList;
import modelo.dao.ActividadEcoDAO;

/**
 *
 * @author Fucker
 */
public interface ActividadEcoDTO {
 
    public Boolean registrarActivEco(ActividadEcoDAO ac);
    public Boolean modificarActivEco(ActividadEcoDAO ac);
    public Boolean eliminarActivEco(ActividadEcoDAO ac);
    public ActividadEcoDAO buscarActividadEcoID(int idActivEco);
    public ActividadEcoDAO buscarActividadEcoNombre(String ActivEco);
    public ArrayList<ActividadEcoDAO> mostrarActividadEco();
    
}
