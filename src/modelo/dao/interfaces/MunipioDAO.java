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
public interface MunipioDAO {
    public ArrayList<modelo.dto.MunipioDTO> mostrarMunicipios();
    public ArrayList<modelo.dto.MunipioDTO> mostrarMunicipiosPorDepto(int idDepto);
    
}
