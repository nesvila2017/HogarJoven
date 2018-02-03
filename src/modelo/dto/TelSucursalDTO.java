/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dto;

/**
 *
 * @author Fucker
 */
public class TelSucursalDTO {

private Integer idSucursal;
private String telefono;

    public TelSucursalDTO() {
    }

    public TelSucursalDTO(Integer idSucursal, String telefono) {
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
