/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dto;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author Fucker
 */
public class ProductoDTO implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private Integer idProducto;
    private String codBarras;
    private String descrip;
    private Integer idCategoria;
    private String marca;
    private String modelo;
    private String serie;
    private String fabrica;
    private Date fechaFab;
    private String lote;
    private Timestamp fechaReg;
    private String estado;
    private String unidadMedida;
    private Integer stockMin;
    private Integer stockMax;

    public ProductoDTO() {
    }

    public ProductoDTO(Integer idProducto, String codBarras, String descrip, Integer idCategoria, String marca, String modelo, String serie, String fabrica, Date fechaFab, String lote, Timestamp fechaReg, String estado, String unidadMedida, Integer stockMin, Integer stockMax) {
        this.idProducto = idProducto;
        this.codBarras = codBarras;
        this.descrip = descrip;
        this.idCategoria = idCategoria;
        this.marca = marca;
        this.modelo = modelo;
        this.serie = serie;
        this.fabrica = fabrica;
        this.fechaFab = fechaFab;
        this.lote = lote;
        this.fechaReg = fechaReg;
        this.estado = estado;
        this.unidadMedida = unidadMedida;
        this.stockMin = stockMin;
        this.stockMax = stockMax;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getCodBarras() {
        return codBarras;
    }

    public void setCodBarras(String codBarras) {
        this.codBarras = codBarras;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getFabrica() {
        return fabrica;
    }

    public void setFabrica(String fabrica) {
        this.fabrica = fabrica;
    }

    public Date getFechaFab() {
        return fechaFab;
    }

    public void setFechaFab(Date fechaFab) {
        this.fechaFab = fechaFab;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public Timestamp getFechaReg() {
        return fechaReg;
    }

    public void setFechaReg(Timestamp fechaReg) {
        this.fechaReg = fechaReg;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public Integer getStockMin() {
        return stockMin;
    }

    public void setStockMin(Integer stockMin) {
        this.stockMin = stockMin;
    }

    public Integer getStockMax() {
        return stockMax;
    }

    public void setStockMax(Integer stockMax) {
        this.stockMax = stockMax;
    }

    @Override
    public String toString() {
        return "ProductoDTO{" + "idProducto=" + idProducto + ", codBarras=" + codBarras + ", descrip=" + descrip + ", idCategoria=" + idCategoria + ", marca=" + marca + ", modelo=" + modelo + ", serie=" + serie + ", fabrica=" + fabrica + ", fechaFab=" + fechaFab + ", lote=" + lote + ", fechaReg=" + fechaReg + ", estado=" + estado + ", unidadMedida=" + unidadMedida + ", stockMin=" + stockMin + ", stockMax=" + stockMax + '}';
    }
    

    
    
    
    
}
