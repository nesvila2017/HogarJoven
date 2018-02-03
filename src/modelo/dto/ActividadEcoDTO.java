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
public class ActividadEcoDTO {
    private Integer idActivEco;
    private String actividadEco;

    public ActividadEcoDTO() {
    }

    public ActividadEcoDTO(Integer idActivEco, String actividadEco) {
        this.idActivEco = idActivEco;
        this.actividadEco = actividadEco;
    }

    public Integer getIdActivEco() {
        return idActivEco;
    }

    public void setIdActivEco(Integer idActivEco) {
        this.idActivEco = idActivEco;
    }

    public String getActividadEco() {
        return actividadEco;
    }

    public void setActividadEco(String actividadEco) {
        this.actividadEco = actividadEco;
    }

    @Override
    public String toString() {
        return "ActividadEco{" + "idActivEco=" + idActivEco + ", actividadEco=" + actividadEco + '}';
    }
    
    
}
