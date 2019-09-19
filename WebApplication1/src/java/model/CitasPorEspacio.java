/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "CLN_CITAS_POR_ESPACIOS", catalog = "", schema = "CLINICAUNA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CitasPorEspacio.findAll", query = "SELECT c FROM CitasPorEspacio c")
    , @NamedQuery(name = "CitasPorEspacio.findByCtxespId", query = "SELECT c FROM CitasPorEspacio c WHERE c.ctxespId = :ctxespId")
    , @NamedQuery(name = "CitasPorEspacio.findByCtxespTiempoCita", query = "SELECT c FROM CitasPorEspacio c WHERE c.ctxespTiempoCita = :ctxespTiempoCita")
    , @NamedQuery(name = "CitasPorEspacio.findByCtxespVersion", query = "SELECT c FROM CitasPorEspacio c WHERE c.ctxespVersion = :ctxespVersion")})
public class CitasPorEspacio implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "CTXESP_ID")
    private Long ctxespId;
    @Basic(optional = false)
    @Column(name = "CTXESP_TIEMPO_CITA")
    private Long ctxespTiempoCita;
    @Basic(optional = false)
    @Column(name = "CTXESP_VERSION")
    private Long ctxespVersion;
    @JoinColumn(name = "CTXESP_CITA", referencedColumnName = "CT_ID")
    @ManyToOne(optional = false)
    private Cita ctxespCita;
    @JoinColumn(name = "CTXESP_ESPACIO", referencedColumnName = "ESP_ID")
    @ManyToOne(optional = false)
    private Espacio ctxespEspacio;

    public CitasPorEspacio() {
    }

    public CitasPorEspacio(Long ctxespId) {
        this.ctxespId = ctxespId;
    }

    public CitasPorEspacio(Long ctxespId, Long ctxespTiempoCita, Long ctxespVersion) {
        this.ctxespId = ctxespId;
        this.ctxespTiempoCita = ctxespTiempoCita;
        this.ctxespVersion = ctxespVersion;
    }

    public Long getCtxespId() {
        return ctxespId;
    }

    public void setCtxespId(Long ctxespId) {
        this.ctxespId = ctxespId;
    }

    public Long getCtxespTiempoCita() {
        return ctxespTiempoCita;
    }

    public void setCtxespTiempoCita(Long ctxespTiempoCita) {
        this.ctxespTiempoCita = ctxespTiempoCita;
    }

    public Long getCtxespVersion() {
        return ctxespVersion;
    }

    public void setCtxespVersion(Long ctxespVersion) {
        this.ctxespVersion = ctxespVersion;
    }

    public Cita getCtxespCita() {
        return ctxespCita;
    }

    public void setCtxespCita(Cita ctxespCita) {
        this.ctxespCita = ctxespCita;
    }

    public Espacio getCtxespEspacio() {
        return ctxespEspacio;
    }

    public void setCtxespEspacio(Espacio ctxespEspacio) {
        this.ctxespEspacio = ctxespEspacio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ctxespId != null ? ctxespId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CitasPorEspacio)) {
            return false;
        }
        CitasPorEspacio other = (CitasPorEspacio) object;
        if ((this.ctxespId == null && other.ctxespId != null) || (this.ctxespId != null && !this.ctxespId.equals(other.ctxespId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.CitasPorEspacio[ ctxespId=" + ctxespId + " ]";
    }
    
}
