/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dto;

/**
 *
 * @author Fucker
 */
public class DetalleFacturaDTO {
    
    private Integer idDetFact;
    private Integer idFactura;
    private Integer idProducto;
    private Integer cant;
    private Double precioUnit;
    private Double subTotal;

    public DetalleFacturaDTO(Integer idDetFact, Integer idFactura, Integer idProducto, Integer cant, Double precioUnit, Double subTotal) {
        this.idDetFact = idDetFact;
        this.idFactura = idFactura;
        this.idProducto = idProducto;
        this.cant = cant;
        this.precioUnit = precioUnit;
        this.subTotal = subTotal;
    }

    public DetalleFacturaDTO() {
    }

    public Integer getIdDetFact() {
        return idDetFact;
    }

    public void setIdDetFact(Integer idDetFact) {
        this.idDetFact = idDetFact;
    }

    public Integer getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Integer idFactura) {
        this.idFactura = idFactura;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public Integer getCant() {
        return cant;
    }

    public void setCant(Integer cant) {
        this.cant = cant;
    }

    public Double getPrecioUnit() {
        return precioUnit;
    }

    public void setPrecioUnit(Double precioUnit) {
        this.precioUnit = precioUnit;
    }

    public Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }

    @Override
    public String toString() {
        return "DetalleFactura{" + "idDetFact=" + idDetFact + ", idFactura=" + idFactura + ", idProducto=" + idProducto + ", cant=" + cant + ", precioUnit=" + precioUnit + ", subTotal=" + subTotal + '}';
    }
    
    
    
}
