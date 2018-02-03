/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dto;

import java.math.BigInteger;
import java.sql.Timestamp;

/**
 *
 * @author Fucker
 */
public class InventarioDTO {
    
    private Integer idInventario;
    private Integer idProducto;
    private BigInteger numIdentProv;
    private Integer maxInventario;
    private Integer minInventario;
    private Timestamp fechaRegistro;

    public InventarioDTO() {
    }

    public InventarioDTO(Integer idInventario, Integer idProducto, BigInteger numIdentProv, Integer maxInventario, Integer minInventario, Timestamp fechaRegistro) {
        this.idInventario = idInventario;
        this.idProducto = idProducto;
        this.numIdentProv = numIdentProv;
        this.maxInventario = maxInventario;
        this.minInventario = minInventario;
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getIdInventario() {
        return idInventario;
    }

    public void setIdInventario(Integer idInventario) {
        this.idInventario = idInventario;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public BigInteger getNumIdentProv() {
        return numIdentProv;
    }

    public void setNumIdentProv(BigInteger numIdentProv) {
        this.numIdentProv = numIdentProv;
    }

    public Integer getMaxInventario() {
        return maxInventario;
    }

    public void setMaxInventario(Integer maxInventario) {
        this.maxInventario = maxInventario;
    }

    public Integer getMinInventario() {
        return minInventario;
    }

    public void setMinInventario(Integer minInventario) {
        this.minInventario = minInventario;
    }

    public Timestamp getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Timestamp fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    @Override
    public String toString() {
        return "Inventario{" + "idInventario=" + idInventario + ", idProducto=" + idProducto + ", numIdentProv=" + numIdentProv + ", maxInventario=" + maxInventario + ", minInventario=" + minInventario + ", fechaRegistro=" + fechaRegistro + '}';
    }
    
    
    
}
