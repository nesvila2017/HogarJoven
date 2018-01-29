/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author Fucker
 */
public class ProductoDAO implements Serializable{
    
    private Integer idProducto;
    private Integer codBarras;
    private String descrip;
    private Integer idCategoria;
    private String marca;
    private String modelo;
    private String serie;
    private String fabrica;
    private Date fechaFab;
    private String lote;
    private Timestamp fechaReg;

    public ProductoDAO() {
    }

    public ProductoDAO(Integer idProducto, Integer codBarras, String descrip, Integer idCategoria, String marca, String modelo, String serie, String fabrica, Date fechaFab, String lote, Timestamp fechaReg) {
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
    }

    public ProductoDAO(Integer idProducto, String descrip, Integer idCategoria, Timestamp fechaReg) {
        this.idProducto = idProducto;
        this.descrip = descrip;
        this.idCategoria = idCategoria;
        this.fechaReg = fechaReg;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public Integer getCodBarras() {
        return codBarras;
    }

    public void setCodBarras(Integer codBarras) {
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

    @Override
    public String toString() {
        return "Producto{" + "idProducto=" + idProducto + ", codBarras=" + codBarras + ", descrip=" + descrip + ", idCategoria=" + idCategoria + ", marca=" + marca + ", modelo=" + modelo + ", serie=" + serie + ", fabrica=" + fabrica + ", fechaFab=" + fechaFab + ", lote=" + lote + ", fechaReg=" + fechaReg + '}';
    }
    
    
}
