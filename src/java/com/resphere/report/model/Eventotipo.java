/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.resphere.report.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author hp
 */
@Entity
@Table(name = "eventotipo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Eventotipo.findAll", query = "SELECT e FROM Eventotipo e"),
    @NamedQuery(name = "Eventotipo.findByIdeventotipo", query = "SELECT e FROM Eventotipo e WHERE e.ideventotipo = :ideventotipo"),
    @NamedQuery(name = "Eventotipo.findByEventotipo", query = "SELECT e FROM Eventotipo e WHERE e.eventotipo = :eventotipo")})
public class Eventotipo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "ideventotipo")
    private String ideventotipo;
    @Size(max = 2147483647)
    @Column(name = "eventotipo")
    private String eventotipo;

    public Eventotipo() {
    }

    public Eventotipo(String ideventotipo) {
        this.ideventotipo = ideventotipo;
    }

    public String getIdeventotipo() {
        return ideventotipo;
    }

    public void setIdeventotipo(String ideventotipo) {
        this.ideventotipo = ideventotipo;
    }

    public String getEventotipo() {
        return eventotipo;
    }

    public void setEventotipo(String eventotipo) {
        this.eventotipo = eventotipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ideventotipo != null ? ideventotipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Eventotipo)) {
            return false;
        }
        Eventotipo other = (Eventotipo) object;
        if ((this.ideventotipo == null && other.ideventotipo != null) || (this.ideventotipo != null && !this.ideventotipo.equals(other.ideventotipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.resphere.report.model.Eventotipo[ ideventotipo=" + ideventotipo + " ]";
    }
    
}
