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
public class Factura {

    private Integer idFactura;
    private Integer numIdentCliente;
    private Timestamp fechaHoraFactura;
    private Character tipoPago;

    public Factura() {
    }

    public Factura(Integer idFactura, Integer numIdentCliente, Timestamp fechaHoraFactura, Character tipoPago) {
        this.idFactura = idFactura;
        this.numIdentCliente = numIdentCliente;
        this.fechaHoraFactura = fechaHoraFactura;
        this.tipoPago = tipoPago;
    }

    public Integer getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Integer idFactura) {
        this.idFactura = idFactura;
    }

    public Integer getNumIdentCliente() {
        return numIdentCliente;
    }

    public void setNumIdentCliente(Integer numIdentCliente) {
        this.numIdentCliente = numIdentCliente;
    }

    public Timestamp getFechaHoraFactura() {
        return fechaHoraFactura;
    }

    public void setFechaHoraFactura(Timestamp fechaHoraFactura) {
        this.fechaHoraFactura = fechaHoraFactura;
    }

    public Character getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(Character tipoPago) {
        this.tipoPago = tipoPago;
    }

    @Override
    public String toString() {
        return "Factura{" + "idFactura=" + idFactura + ", numIdentCliente=" + numIdentCliente + ", fechaHoraFactura=" + fechaHoraFactura + ", tipoPago=" + tipoPago + '}';
    }

}
