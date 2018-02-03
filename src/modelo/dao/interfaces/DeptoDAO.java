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
public interface DeptoDAO {
    public ArrayList<modelo.dto.DeptoDTO> deptos();
    public modelo.dto.DeptoDTO deptosId (int idDepto);
    
}
