/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dto;

import java.math.BigInteger;
import java.util.Date;

/**
 *
 * @author Fucker
 */
public class PersonaDTO {
    
    private Integer idPersona;
    private BigInteger numIdent;
    private String tipoIdent;
    private String primNombre;
    private String segNombre;
    private String priApe;
    private String segApe;
    private Date fechaNac;
    private Character genero;
    private String email;

    public PersonaDTO() {
    }

    public PersonaDTO(Integer idPersona, BigInteger numIdent, String tipoIdent, String primNombre, String segNombre, String priApe, String segApe, Date fechaNac, Character genero, String email) {
        this.idPersona = idPersona;
        this.numIdent = numIdent;
        this.tipoIdent = tipoIdent;
        this.primNombre = primNombre;
        this.segNombre = segNombre;
        this.priApe = priApe;
        this.segApe = segApe;
        this.fechaNac = fechaNac;
        this.genero = genero;
        this.email = email;
    }

    public PersonaDTO(Integer idPersona, BigInteger numIdent, String tipoIdent, String primNombre, String priApe, Character genero) {
        this.idPersona = idPersona;
        this.numIdent = numIdent;
        this.tipoIdent = tipoIdent;
        this.primNombre = primNombre;
        this.priApe = priApe;
        this.genero = genero;
    }

    public PersonaDTO(Integer idPersona, BigInteger numIdent, String tipoIdent, String primNombre, String priApe, Date fechaNac, Character genero, String email) {
        this.idPersona = idPersona;
        this.numIdent = numIdent;
        this.tipoIdent = tipoIdent;
        this.primNombre = primNombre;
        this.priApe = priApe;
        this.fechaNac = fechaNac;
        this.genero = genero;
        this.email = email;
    }

    public PersonaDTO(Integer idPersona, BigInteger numIdent, String tipoIdent, String primNombre, String priApe, String segApe, Date fechaNac, Character genero, String email) {
        this.idPersona = idPersona;
        this.numIdent = numIdent;
        this.tipoIdent = tipoIdent;
        this.primNombre = primNombre;
        this.priApe = priApe;
        this.segApe = segApe;
        this.fechaNac = fechaNac;
        this.genero = genero;
        this.email = email;
    }

    public PersonaDTO(Integer idPersona, BigInteger numIdent, String tipoIdent, String primNombre, String segNombre, String priApe, String segApe, Date fechaNac, Character genero) {
        this.idPersona = idPersona;
        this.numIdent = numIdent;
        this.tipoIdent = tipoIdent;
        this.primNombre = primNombre;
        this.segNombre = segNombre;
        this.priApe = priApe;
        this.segApe = segApe;
        this.fechaNac = fechaNac;
        this.genero = genero;
    }

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public BigInteger getNumIdent() {
        return numIdent;
    }

    public void setNumIdent(BigInteger numIdent) {
        this.numIdent = numIdent;
    }

    public String getTipoIdent() {
        return tipoIdent;
    }

    public void setTipoIdent(String tipoIdent) {
        this.tipoIdent = tipoIdent;
    }

    public String getPrimNombre() {
        return primNombre;
    }

    public void setPrimNombre(String primNombre) {
        this.primNombre = primNombre;
    }

    public String getSegNombre() {
        return segNombre;
    }

    public void setSegNombre(String segNombre) {
        this.segNombre = segNombre;
    }

    public String getPriApe() {
        return priApe;
    }

    public void setPriApe(String priApe) {
        this.priApe = priApe;
    }

    public String getSegApe() {
        return segApe;
    }

    public void setSegApe(String segApe) {
        this.segApe = segApe;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public Character getGenero() {
        return genero;
    }

    public void setGenero(Character genero) {
        this.genero = genero;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Persona{" + "idPersona=" + idPersona + ", numIdent=" + numIdent + ", tipoIdent=" + tipoIdent + ", primNombre=" + primNombre + ", segNombre=" + segNombre + ", priApe=" + priApe + ", segApe=" + segApe + ", fechaNac=" + fechaNac + ", genero=" + genero + ", email=" + email + '}';
    }
    
    
    
    
}
