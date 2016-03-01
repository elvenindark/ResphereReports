/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.resphere.report.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author hp
 */
@Embeddable
public class CantonPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "idprovincia")
    private String idprovincia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "idcanton")
    private String idcanton;

    public CantonPK() {
    }

    public CantonPK(String idprovincia, String idcanton) {
        this.idprovincia = idprovincia;
        this.idcanton = idcanton;
    }

    public String getIdprovincia() {
        return idprovincia;
    }

    public void setIdprovincia(String idprovincia) {
        this.idprovincia = idprovincia;
    }

    public String getIdcanton() {
        return idcanton;
    }

    public void setIdcanton(String idcanton) {
        this.idcanton = idcanton;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idprovincia != null ? idprovincia.hashCode() : 0);
        hash += (idcanton != null ? idcanton.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CantonPK)) {
            return false;
        }
        CantonPK other = (CantonPK) object;
        if ((this.idprovincia == null && other.idprovincia != null) || (this.idprovincia != null && !this.idprovincia.equals(other.idprovincia))) {
            return false;
        }
        if ((this.idcanton == null && other.idcanton != null) || (this.idcanton != null && !this.idcanton.equals(other.idcanton))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.resphere.report.model.CantonPK[ idprovincia=" + idprovincia + ", idcanton=" + idcanton + " ]";
    }
    
}
