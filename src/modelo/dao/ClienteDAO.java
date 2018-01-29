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
public class ClienteDAO {
    private Integer idCliente;
    private Integer numIdent;
    private Character naturalezaPers;
    private Integer digitoVerif;

    public ClienteDAO() {
    }

    public ClienteDAO(Integer idCliente, Integer numIdent, Character naturalezaPers, Integer digitoVerif) {
        this.idCliente = idCliente;
        this.numIdent = numIdent;
        this.naturalezaPers = naturalezaPers;
        this.digitoVerif = digitoVerif;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getNumIdent() {
        return numIdent;
    }

    public void setNumIdent(Integer numIdent) {
        this.numIdent = numIdent;
    }

    public Character getNaturalezaPers() {
        return naturalezaPers;
    }

    public void setNaturalezaPers(Character naturalezaPers) {
        this.naturalezaPers = naturalezaPers;
    }

    public Integer getDigitoVerif() {
        return digitoVerif;
    }

    public void setDigitoVerif(Integer digitoVerif) {
        this.digitoVerif = digitoVerif;
    }

    @Override
    public String toString() {
        return "Cliente{" + "idCliente=" + idCliente + ", numIdent=" + numIdent + ", naturalezaPers=" + naturalezaPers + ", digitoVerif=" + digitoVerif + '}';
    }
    
    
    
    
    
}
