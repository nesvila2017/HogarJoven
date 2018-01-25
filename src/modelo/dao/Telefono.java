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
public class Telefono {

    private Integer idTelefono;
    private BigInteger telefono;
    private BigInteger numIdent;

    public Telefono() {
    }
    
    public Telefono(Integer idTelefono, BigInteger telefono, BigInteger numIdent) {
        this.idTelefono = idTelefono;
        this.telefono = telefono;
        this.numIdent = numIdent;
    }

    public Integer getIdTelefono() {
        return idTelefono;
    }

    public void setIdTelefono(Integer idTelefono) {
        this.idTelefono = idTelefono;
    }

    public BigInteger getTelefono() {
        return telefono;
    }

    public void setTelefono(BigInteger telefono) {
        this.telefono = telefono;
    }

    public BigInteger getNumIdent() {
        return numIdent;
    }

    public void setNumIdent(BigInteger numIdent) {
        this.numIdent = numIdent;
    }

    @Override
    public String toString() {
        return "Telefono{" + "idTelefono=" + idTelefono + ", telefono=" + telefono + ", numIdent=" + numIdent + '}';
    }
    
    
    
}
