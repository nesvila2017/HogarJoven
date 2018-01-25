/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

/**
 *
 * @author Fucker
 */
public class TelSucursal {

private Integer idSucursal;
private String telefono;

    public TelSucursal() {
    }

    public TelSucursal(Integer idSucursal, String telefono) {
        this.idSucursal = idSucursal;
        this.telefono = telefono;
    }

    public Integer getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(Integer idSucursal) {
        this.idSucursal = idSucursal;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "TelSucursal{" + "idSucursal=" + idSucursal + ", telefono=" + telefono + '}';
    }
        
    
    
}
