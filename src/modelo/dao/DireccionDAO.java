/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.math.BigInteger;

/**
 *
 * @author Fucker
 */
public class DireccionDAO {
    private Integer idDir;
    private BigInteger numIdent;
    private String direccion;
    private Integer idMunipio;
    private Integer idDepto;

    public DireccionDAO() {
    }

    public DireccionDAO(Integer idDir, BigInteger numIdent, String direccion, Integer idMunipio, Integer idDepto) {
        this.idDir = idDir;
        this.numIdent = numIdent;
        this.direccion = direccion;
        this.idMunipio = idMunipio;
        this.idDepto = idDepto;
    }

    public Integer getIdDir() {
        return idDir;
    }

    public void setIdDir(Integer idDir) {
        this.idDir = idDir;
    }

    public BigInteger getNumIdent() {
        return numIdent;
    }

    public void setNumIdent(BigInteger numIdent) {
        this.numIdent = numIdent;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getIdMunipio() {
        return idMunipio;
    }

    public void setIdMunipio(Integer idMunipio) {
        this.idMunipio = idMunipio;
    }

    public Integer getIdDepto() {
        return idDepto;
    }

    public void setIdDepto(Integer idDepto) {
        this.idDepto = idDepto;
    }

    
    @Override
    public String toString() {
        return "Direccion{" + "idDir=" + idDir + ", numIdent=" + numIdent + ", direccion=" + direccion + ", idMunipio=" + idMunipio + ", idDepto=" + idDepto + '}';
    }
    
    
    
}
