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
public class ClasifProveedorDTO {

private Integer idClasProv;
private String clasProv;

    public ClasifProveedorDTO() {
    }

    public ClasifProveedorDTO(Integer idClasProv, String clasProv) {
        this.idClasProv = idClasProv;
        this.clasProv = clasProv;
    }

    public Integer getIdClasProv() {
        return idClasProv;
    }

    public void setIdClasProv(Integer idClasProv) {
        this.idClasProv = idClasProv;
    }

    public String getClasProv() {
        return clasProv;
    }

    public void setClasProv(String clasProv) {
        this.clasProv = clasProv;
    }

    @Override
    public String toString() {
        return "ClasifProveedor{" + "idClasProv=" + idClasProv + ", clasProv=" + clasProv + '}';
    }


    
}
