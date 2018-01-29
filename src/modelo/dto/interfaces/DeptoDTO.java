/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dto.interfaces;

import java.util.ArrayList;
import modelo.dao.DeptoDAO;

/**
 *
 * @author Fucker
 */
public interface DeptoDTO {
    public ArrayList<DeptoDAO> deptos();
    public DeptoDAO deptosId (int idDepto);
    
}
