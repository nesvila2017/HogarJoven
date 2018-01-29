/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.sql.Timestamp;

/**
 *
 * @author Fucker
 */
public class DetalleInventarioDAO {

    private Integer idDetInvent;
    private Integer idInvent;
    private Integer idProd;
    private Timestamp fechaMov;
    private String descripMov;
    private Integer cantItem;
    private Double costoItem;
    private Double costoTotal;
    private Character tipoMovimiento;
    private Integer cantRest;

    public DetalleInventarioDAO() {
    }

    public DetalleInventarioDAO(Integer idDetInvent, Integer idInvent, Integer idProd, Timestamp fechaMov, String descripMov, Integer cantItem, Double costoItem, Double costoTotal, Character tipoMovimiento, Integer cantRest) {
        this.idDetInvent = idDetInvent;
        this.idInvent = idInvent;
        this.idProd = idProd;
        this.fechaMov = fechaMov;
        this.descripMov = descripMov;
        this.cantItem = cantItem;
        this.costoItem = costoItem;
        this.costoTotal = costoTotal;
        this.tipoMovimiento = tipoMovimiento;
        this.cantRest = cantRest;
    }

    public Integer getIdDetInvent() {
        return idDetInvent;
    }

    public void setIdDetInvent(Integer idDetInvent) {
        this.idDetInvent = idDetInvent;
    }

    public Integer getIdInvent() {
        return idInvent;
    }

    public void setIdInvent(Integer idInvent) {
        this.idInvent = idInvent;
    }

    public Integer getIdProd() {
        return idProd;
    }

    public void setIdProd(Integer idProd) {
        this.idProd = idProd;
    }

    public Timestamp getFechaMov() {
        return fechaMov;
    }

    public void setFechaMov(Timestamp fechaMov) {
        this.fechaMov = fechaMov;
    }

    public String getDescripMov() {
        return descripMov;
    }

    public void setDescripMov(String descripMov) {
        this.descripMov = descripMov;
    }

    public Integer getCantItem() {
        return cantItem;
    }

    public void setCantItem(Integer cantItem) {
        this.cantItem = cantItem;
    }

    public Double getCostoItem() {
        return costoItem;
    }

    public void setCostoItem(Double costoItem) {
        this.costoItem = costoItem;
    }

    public Double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(Double costoTotal) {
        this.costoTotal = costoTotal;
    }

    public Character getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(Character tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public Integer getCantRest() {
        return cantRest;
    }

    public void setCantRest(Integer cantRest) {
        this.cantRest = cantRest;
    }

    @Override
    public String toString() {
        return "DetalleInventario{" + "idDetInvent=" + idDetInvent + ", idInvent=" + idInvent + ", idProd=" + idProd + ", fechaMov=" + fechaMov + ", descripMov=" + descripMov + ", cantItem=" + cantItem + ", costoItem=" + costoItem + ", costoTotal=" + costoTotal + ", tipoMovimiento=" + tipoMovimiento + ", cantRest=" + cantRest + '}';
    }
    
    
    
    
}
