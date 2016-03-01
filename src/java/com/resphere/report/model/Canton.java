/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.resphere.report.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "canton")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Canton.findAll", query = "SELECT c FROM Canton c"),
    @NamedQuery(name = "Canton.findByIdprovincia", query = "SELECT c FROM Canton c WHERE c.cantonPK.idprovincia = :idprovincia"),
    @NamedQuery(name = "Canton.findByIdcanton", query = "SELECT c FROM Canton c WHERE c.cantonPK.idcanton = :idcanton"),
    @NamedQuery(name = "Canton.findByCanton", query = "SELECT c FROM Canton c WHERE c.canton = :canton")})
public class Canton implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CantonPK cantonPK;
    @Size(max = 2147483647)
    @Column(name = "canton")
    private String canton;

    public Canton() {
    }

    public Canton(CantonPK cantonPK) {
        this.cantonPK = cantonPK;
    }

    public Canton(String idprovincia, String idcanton) {
        this.cantonPK = new CantonPK(idprovincia, idcanton);
    }

    public CantonPK getCantonPK() {
        return cantonPK;
    }

    public void setCantonPK(CantonPK cantonPK) {
        this.cantonPK = cantonPK;
    }

    public String getCanton() {
        return canton;
    }

    public void setCanton(String canton) {
        this.canton = canton;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cantonPK != null ? cantonPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Canton)) {
            return false;
        }
        Canton other = (Canton) object;
        if ((this.cantonPK == null && other.cantonPK != null) || (this.cantonPK != null && !this.cantonPK.equals(other.cantonPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.resphere.report.model.Canton[ cantonPK=" + cantonPK + " ]";
    }
    
}
