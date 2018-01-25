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
public class Depto {

private Integer idDepto;
private String depto;

    public Depto() {
    }

    public Depto(Integer idDepto, String depto) {
        this.idDepto = idDepto;
        this.depto = depto;
    }

    public Integer getIdDepto() {
        return idDepto;
    }

    public void setIdDepto(Integer idDepto) {
        this.idDepto = idDepto;
    }

    public String getDepto() {
        return depto;
    }

    public void setDepto(String depto) {
        this.depto = depto;
    }

    @Override
    public String toString() {
        return "Depto{" + "idDepto=" + idDepto + ", depto=" + depto + '}';
    }


    
}
