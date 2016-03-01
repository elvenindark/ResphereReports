/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.resphere.report.model;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author hp
 */
@Entity
@Table(name = "v_rptevento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VRptevento.findAll", query = "SELECT v FROM VRptevento v"),
    @NamedQuery(name = "VRptevento.findByIdevento", query = "SELECT v FROM VRptevento v WHERE v.idevento = :idevento"),
    @NamedQuery(name = "VRptevento.findByDescripcion", query = "SELECT v FROM VRptevento v WHERE v.descripcion = :descripcion"),
    @NamedQuery(name = "VRptevento.findByEfectos", query = "SELECT v FROM VRptevento v WHERE v.efectos = :efectos"),
    @NamedQuery(name = "VRptevento.findByAmenazas", query = "SELECT v FROM VRptevento v WHERE v.amenazas = :amenazas"),
    @NamedQuery(name = "VRptevento.findByFecha", query = "SELECT v FROM VRptevento v WHERE v.fecha = :fecha"),
    @NamedQuery(name = "VRptevento.findByHora", query = "SELECT v FROM VRptevento v WHERE v.hora = :hora"),
    @NamedQuery(name = "VRptevento.findByProvincia", query = "SELECT v FROM VRptevento v WHERE v.provincia = :provincia"),
    @NamedQuery(name = "VRptevento.findByCanton", query = "SELECT v FROM VRptevento v WHERE v.canton = :canton"),
    @NamedQuery(name = "VRptevento.findByParroquia", query = "SELECT v FROM VRptevento v WHERE v.parroquia = :parroquia"),
    @NamedQuery(name = "VRptevento.findByTipo", query = "SELECT v FROM VRptevento v WHERE v.tipo = :tipo"),
    @NamedQuery(name = "VRptevento.findBySector", query = "SELECT v FROM VRptevento v WHERE v.sector = :sector"),
    @NamedQuery(name = "VRptevento.findByDistancia", query = "SELECT v FROM VRptevento v WHERE v.distancia = :distancia"),
    @NamedQuery(name = "VRptevento.findByTiempo", query = "SELECT v FROM VRptevento v WHERE v.tiempo = :tiempo"),
    @NamedQuery(name = "VRptevento.findByReferencia", query = "SELECT v FROM VRptevento v WHERE v.referencia = :referencia"),
    @NamedQuery(name = "VRptevento.findByLongitud", query = "SELECT v FROM VRptevento v WHERE v.longitud = :longitud"),
    @NamedQuery(name = "VRptevento.findByLatitud", query = "SELECT v FROM VRptevento v WHERE v.latitud = :latitud"),
    @NamedQuery(name = "VRptevento.findByAltitud", query = "SELECT v FROM VRptevento v WHERE v.altitud = :altitud"),
    @NamedQuery(name = "VRptevento.findByEvento", query = "SELECT v FROM VRptevento v WHERE v.evento = :evento")})
public class VRptevento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Size(max = 20)
    @Column(name = "idevento")
    private String idevento;
    @Size(max = 2147483647)
    @Column(name = "descripcion")
    private String descripcion;
    @Size(max = 2147483647)
    @Column(name = "efectos")
    private String efectos;
    @Size(max = 2147483647)
    @Column(name = "amenazas")
    private String amenazas;
    @Size(max = 2147483647)
    @Column(name = "fecha")
    private String fecha;
    @Size(max = 2147483647)
    @Column(name = "hora")
    private String hora;
    @Size(max = 2147483647)
    @Column(name = "provincia")
    private String provincia;
    @Size(max = 2147483647)
    @Column(name = "canton")
    private String canton;
    @Size(max = 2147483647)
    @Column(name = "parroquia")
    private String parroquia;
    @Size(max = 2147483647)
    @Column(name = "tipo")
    private String tipo;
    @Size(max = 2147483647)
    @Column(name = "sector")
    private String sector;
    @Column(name = "distancia")
    private BigInteger distancia;
    @Column(name = "tiempo")
    private BigInteger tiempo;
    @Size(max = 2147483647)
    @Column(name = "referencia")
    private String referencia;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "longitud")
    private Double longitud;
    @Column(name = "latitud")
    private Double latitud;
    @Column(name = "altitud")
    private Double altitud;
    @Size(max = 2147483647)
    @Column(name = "evento")
    private String evento;

    public VRptevento() {
    }

    public String getIdevento() {
        return idevento;
    }

    public void setIdevento(String idevento) {
        this.idevento = idevento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEfectos() {
        return efectos;
    }

    public void setEfectos(String efectos) {
        this.efectos = efectos;
    }

    public String getAmenazas() {
        return amenazas;
    }

    public void setAmenazas(String amenazas) {
        this.amenazas = amenazas;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCanton() {
        return canton;
    }

    public void setCanton(String canton) {
        this.canton = canton;
    }

    public String getParroquia() {
        return parroquia;
    }

    public void setParroquia(String parroquia) {
        this.parroquia = parroquia;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public BigInteger getDistancia() {
        return distancia;
    }

    public void setDistancia(BigInteger distancia) {
        this.distancia = distancia;
    }

    public BigInteger getTiempo() {
        return tiempo;
    }

    public void setTiempo(BigInteger tiempo) {
        this.tiempo = tiempo;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public Double getAltitud() {
        return altitud;
    }

    public void setAltitud(Double altitud) {
        this.altitud = altitud;
    }

    public String getEvento() {
        return evento;
    }

    public void setEvento(String evento) {
        this.evento = evento;
    }
    
}
