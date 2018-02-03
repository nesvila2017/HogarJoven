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
public class SedePrincipalDTO {
    private Integer idSedePrincipal;
    private Integer provNumIdent;
    private String dirSede;
    private String telSede;
    private String celular;
    private String email;
    private String web;
    private Integer idMunipio;
    private Integer idDepto;

    public SedePrincipalDTO() {
    }

    public SedePrincipalDTO(Integer idSedePrincipal, Integer provNumIdent, String dirSede, String telSede, String celular, String email, String web, Integer idMunipio, Integer idDepto) {
        this.idSedePrincipal = idSedePrincipal;
        this.provNumIdent = provNumIdent;
        this.dirSede = dirSede;
        this.telSede = telSede;
        this.celular = celular;
        this.email = email;
        this.web = web;
        this.idMunipio = idMunipio;
        this.idDepto = idDepto;
    }

    public Integer getIdSedePrincipal() {
        return idSedePrincipal;
    }

    public void setIdSedePrincipal(Integer idSedePrincipal) {
        this.idSedePrincipal = idSedePrincipal;
    }

    public Integer getProvNumIdent() {
        return provNumIdent;
    }

    public void setProvNumIdent(Integer provNumIdent) {
        this.provNumIdent = provNumIdent;
    }

    public String getDirSede() {
        return dirSede;
    }

    public void setDirSede(String dirSede) {
        this.dirSede = dirSede;
    }

    public String getTelSede() {
        return telSede;
    }

    public void setTelSede(String telSede) {
        this.telSede = telSede;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
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

    @Override
    public String toString() {
        return "SedePrincipal{" + "idSedePrincipal=" + idSedePrincipal + ", provNumIdent=" + provNumIdent + ", dirSede=" + dirSede + ", telSede=" + telSede + ", celular=" + celular + ", email=" + email + ", web=" + web + ", idMunipio=" + idMunipio + ", idDepto=" + idDepto + '}';
    }
    
    
    
}
