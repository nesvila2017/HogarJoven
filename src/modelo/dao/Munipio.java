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
public class Munipio {

private Integer idMunipio;
private String munipio;
private Integer idDepto;

    public Munipio() {
    }

    public Munipio(Integer idMunipio, String munipio, Integer idDepto) {
        this.idMunipio = idMunipio;
        this.munipio = munipio;
        this.idDepto = idDepto;
    }

    public Integer getIdMunipio() {
        return idMunipio;
    }

    public void setIdMunipio(Integer idMunipio) {
        this.idMunipio = idMunipio;
    }

    public String getMunipio() {
        return munipio;
    }

    public void setMunipio(String munipio) {
        this.munipio = munipio;
    }

    public Integer getIdDepto() {
        return idDepto;
    }

    public void setIdDepto(Integer idDepto) {
        this.idDepto = idDepto;
    }

    @Override
    public String toString() {
        return "Munipio{" + "idMunipio=" + idMunipio + ", munipio=" + munipio + ", idDepto=" + idDepto + '}';
    }


    
    
    
}
