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
public class TipoEmpresaDTO {

    private Integer idTipoEmpresa;
    private String tipoEmpresa;

    public TipoEmpresaDTO() {
    }

    public TipoEmpresaDTO(Integer idTipoEmpresa, String tipoEmpresa) {
        this.idTipoEmpresa = idTipoEmpresa;
        this.tipoEmpresa = tipoEmpresa;
    }

    public Integer getIdTipoEmpresa() {
        return idTipoEmpresa;
    }

    public void setIdTipoEmpresa(Integer idTipoEmpresa) {
        this.idTipoEmpresa = idTipoEmpresa;
    }

    public String getTipoEmpresa() {
        return tipoEmpresa;
    }

    public void setTipoEmpresa(String tipoEmpresa) {
        this.tipoEmpresa = tipoEmpresa;
    }

    @Override
    public String toString() {
        return "TipoEmpresa{" + "idTipoEmpresa=" + idTipoEmpresa + ", tipoEmpresa=" + tipoEmpresa + '}';
    }
    
    
    
    
}
