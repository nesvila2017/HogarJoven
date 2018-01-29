/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dto.interfaces;

import java.util.ArrayList;
import modelo.dao.MunipioDAO;

/**
 *
 * @author Fucker
 */
public interface MunipioDTO {
    public ArrayList<MunipioDAO> mostrarMunicipios();
    public ArrayList<MunipioDAO> mostrarMunicipiosPorDepto(int idDepto);
    
}
