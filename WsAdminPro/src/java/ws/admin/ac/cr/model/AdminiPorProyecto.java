/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.admin.ac.cr.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Carlos Olivares
 */
@Entity
@Table(name = "ADM_ADMIN_X_PRO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdminiPorProyecto.findAll", query = "SELECT a FROM AdminiPorProyecto a")
    , @NamedQuery(name = "AdminiPorProyecto.findByAxpId", query = "SELECT a FROM AdminiPorProyecto a WHERE a.axpId = :axpId")
    , @NamedQuery(name = "AdminiPorProyecto.findByAxpTipo", query = "SELECT a FROM AdminiPorProyecto a WHERE a.axpTipo = :axpTipo")
    , @NamedQuery(name = "AdminiPorProyecto.findByAxpVersion", query = "SELECT a FROM AdminiPorProyecto a WHERE a.axpVersion = :axpVersion")})
public class AdminiPorProyecto implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "AXP_ID")
    private BigDecimal axpId;
    @Basic(optional = false)
    @Column(name = "AXP_TIPO")
    private String axpTipo;
    @Basic(optional = false)
    @Column(name = "AXP_VERSION")
    private BigInteger axpVersion;
    @JoinColumn(name = "ADN_ID", referencedColumnName = "ADN_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Administrador adnId;
    @JoinColumn(name = "PRO_ID", referencedColumnName = "PRO_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Proyecto proId;

    public AdminiPorProyecto() {
    }

    public AdminiPorProyecto(BigDecimal axpId) {
        this.axpId = axpId;
    }

    public AdminiPorProyecto(BigDecimal axpId, String axpTipo, BigInteger axpVersion) {
        this.axpId = axpId;
        this.axpTipo = axpTipo;
        this.axpVersion = axpVersion;
    }

    public BigDecimal getAxpId() {
        return axpId;
    }

    public void setAxpId(BigDecimal axpId) {
        this.axpId = axpId;
    }

    public String getAxpTipo() {
        return axpTipo;
    }

    public void setAxpTipo(String axpTipo) {
        this.axpTipo = axpTipo;
    }

    public BigInteger getAxpVersion() {
        return axpVersion;
    }

    public void setAxpVersion(BigInteger axpVersion) {
        this.axpVersion = axpVersion;
    }

    public Administrador getAdnId() {
        return adnId;
    }

    public void setAdnId(Administrador adnId) {
        this.adnId = adnId;
    }

    public Proyecto getProId() {
        return proId;
    }

    public void setProId(Proyecto proId) {
        this.proId = proId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (axpId != null ? axpId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdminiPorProyecto)) {
            return false;
        }
        AdminiPorProyecto other = (AdminiPorProyecto) object;
        if ((this.axpId == null && other.axpId != null) || (this.axpId != null && !this.axpId.equals(other.axpId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ws.admin.ac.cr.model.AdminiPorProyecto[ axpId=" + axpId + " ]";
    }
    
}
