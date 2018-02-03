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
public class ProveedorDTO {
    private Integer idProveedor;
    private Integer numIdent;
    private String razonSocial;
    private Integer idTipoEmpresa;
    private Character genero;
    private Integer idActivEco;
    private Integer idClasProv;
    private Integer digitoVer;
    
    public ProveedorDTO() {
    }

    public ProveedorDTO(Integer idProveedor, Integer numIdent, String razonSocial, Integer idTipoEmpresa, Character genero, Integer idActivEco, Integer idClasProv, Integer digitoVer) {
        this.idProveedor = idProveedor;
        this.numIdent = numIdent;
        this.razonSocial = razonSocial;
        this.idTipoEmpresa = idTipoEmpresa;
        this.genero = genero;
        this.idActivEco = idActivEco;
        this.idClasProv = idClasProv;
        this.digitoVer = digitoVer;
    }

    
    
    public Integer getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Integer idProveedor) {
        this.idProveedor = idProveedor;
    }

    public Integer getNumIdent() {
        return numIdent;
    }

    public void setNumIdent(Integer numIdent) {
        this.numIdent = numIdent;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public Integer getIdTipoEmpresa() {
        return idTipoEmpresa;
    }

    public void setIdTipoEmpresa(Integer idTipoEmpresa) {
        this.idTipoEmpresa = idTipoEmpresa;
    }

    public Character getGenero() {
        return genero;
    }

    public void setGenero(Character genero) {
        this.genero = genero;
    }

    public Integer getIdActivEco() {
        return idActivEco;
    }

    public void setIdActivEco(Integer idActivEco) {
        this.idActivEco = idActivEco;
    }

    public Integer getIdClasProv() {
        return idClasProv;
    }

    public void setIdClasProv(Integer idClasProv) {
        this.idClasProv = idClasProv;
    }

    public Integer getDigitoVer() {
        return digitoVer;
    }

    public void setDigitoVer(Integer digitoVer) {
        this.digitoVer = digitoVer;
    }

    @Override
    public String toString() {
        return "Proveedor{" + "idProveedor=" + idProveedor + ", numIdent=" + numIdent + ", razonSocial=" + razonSocial + ", idTipoEmpresa=" + idTipoEmpresa + ", genero=" + genero + ", idActivEco=" + idActivEco + ", idClasProv=" + idClasProv + ", digitoVer=" + digitoVer + '}';
    }
    
    
    
    
}
