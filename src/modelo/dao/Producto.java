/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author Fucker
 */
public class Producto {
    
    private Integer idProducto;
    private Integer codBarras;
    private String descrip;
    private String categoria;
    private String marca;
    private String modelo;
    private String serie;
    private String proveed;
    private String fabrica;
    private Date fechaFab;
    private String lote;
    private Timestamp fechaReg;

    public Producto() {
    }

    public Producto(Integer idProducto, Integer codBarras, String descrip, String categoria, String marca, String modelo, String serie, String proveed, String fabrica, Date fechaFab, String lote, Timestamp fechaReg) {
        this.idProducto = idProducto;
        this.codBarras = codBarras;
        this.descrip = descrip;
        this.categoria = categoria;
        this.marca = marca;
        this.modelo = modelo;
        this.serie = serie;
        this.proveed = proveed;
        this.fabrica = fabrica;
        this.fechaFab = fechaFab;
        this.lote = lote;
        this.fechaReg = fechaReg;
    }

    public Producto(Integer idProducto, String descrip, String categoria, String proveed) {
        this.idProducto = idProducto;
        this.descrip = descrip;
        this.categoria = categoria;
        this.proveed = proveed;
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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
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

    public String getProveed() {
        return proveed;
    }

    public void setProveed(String proveed) {
        this.proveed = proveed;
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

    public Timestamp getFechaReg() {
        return fechaReg;
    }

    public void setFechaReg(Timestamp fechaReg) {
        this.fechaReg = fechaReg;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }
    
    

    @Override
    public String toString() {
        return "Producto{" + "idProducto=" + idProducto + ", codBarras=" + codBarras + ", descrip=" + descrip + ", categoria=" + categoria + ", marca=" + marca + ", modelo=" + modelo + ", serie=" + serie + ", proveed=" + proveed + ", fabrica=" + fabrica + '}';
    }
    
    
    
}
