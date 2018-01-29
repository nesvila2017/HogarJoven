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
public class SucursalDAO {
    private Integer idSucursal;
    private String dirProveedor;
    private Integer idMunipio;
    private Integer idDepto;
    private String nomSucursal;
    private Character tipoSucursal;
    private BigInteger numIdentProv;

    public SucursalDAO() {
    }

    public SucursalDAO(Integer idSucursal, String dirProveedor, Integer idMunipio, Integer idDepto, String nomSucursal, Character tipoSucursal, BigInteger numIdentProv) {
        this.idSucursal = idSucursal;
        this.dirProveedor = dirProveedor;
        this.idMunipio = idMunipio;
        this.idDepto = idDepto;
        this.nomSucursal = nomSucursal;
        this.tipoSucursal = tipoSucursal;
        this.numIdentProv = numIdentProv;
    }

    public Integer getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(Integer idSucursal) {
        this.idSucursal = idSucursal;
    }

    public String getDirProveedor() {
        return dirProveedor;
    }

    public void setDirProveedor(String dirProveedor) {
        this.dirProveedor = dirProveedor;
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

    public String getNomSucursal() {
        return nomSucursal;
    }

    public void setNomSucursal(String nomSucursal) {
        this.nomSucursal = nomSucursal;
    }

    public Character getTipoSucursal() {
        return tipoSucursal;
    }

    public void setTipoSucursal(Character tipoSucursal) {
        this.tipoSucursal = tipoSucursal;
    }

    public BigInteger getNumIdentProv() {
        return numIdentProv;
    }

    public void setNumIdentProv(BigInteger numIdentProv) {
        this.numIdentProv = numIdentProv;
    }

    @Override
    public String toString() {
        return "Sucursal{" + "idSucursal=" + idSucursal + ", dirProveedor=" + dirProveedor + ", idMunipio=" + idMunipio + ", idDepto=" + idDepto + ", nomSucursal=" + nomSucursal + ", tipoSucursal=" + tipoSucursal + ", numIdentProv=" + numIdentProv + '}';
    }
    
    
    
}
