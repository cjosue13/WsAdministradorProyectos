/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Carlos Olivares
 */
@Entity
@Table(name = "CLN_ESPACIOS", catalog = "", schema = "CLINICAUNA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Espacio.findAll", query = "SELECT e FROM Espacio e")
    , @NamedQuery(name = "Espacio.findByEspId", query = "SELECT e FROM Espacio e WHERE e.espId = :espId")
    , @NamedQuery(name = "Espacio.findByEspHoraFin", query = "SELECT e FROM Espacio e WHERE e.espHoraFin = :espHoraFin")
    , @NamedQuery(name = "Espacio.findByEspHoraInicio", query = "SELECT e FROM Espacio e WHERE e.espHoraInicio = :espHoraInicio")
    , @NamedQuery(name = "Espacio.findByEspVersion", query = "SELECT e FROM Espacio e WHERE e.espVersion = :espVersion")})
public class Espacio implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ESP_ID")
    private Long espId;
    @Basic(optional = false)
    @Column(name = "ESP_HORA_FIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date espHoraFin;
    @Basic(optional = false)
    @Column(name = "ESP_HORA_INICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date espHoraInicio;
    @Basic(optional = false)
    @Column(name = "ESP_VERSION")
    private Long espVersion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ctxespEspacio")
    private List<CitasPorEspacio> citasPorEspacioList;
    @JoinColumn(name = "ESP_AGENDA", referencedColumnName = "AGE_ID")
    @ManyToOne
    private Agenda espAgenda;

    public Espacio() {
    }

    public Espacio(Long espId) {
        this.espId = espId;
    }

    public Espacio(Long espId, Date espHoraFin, Date espHoraInicio, Long espVersion) {
        this.espId = espId;
        this.espHoraFin = espHoraFin;
        this.espHoraInicio = espHoraInicio;
        this.espVersion = espVersion;
    }
    public EspacioHora(EspacioHoraDto espacioHoraDto) {
        this.pkClnEspacioHora = espacioHoraDto.getEspID();
        actualizarEspacioHora(espacioHoraDto);
    }
    
    public void actualizarEspacioHora(EspacioHoraDto espacioh){
        //Arreglar 
        this.espId = espacioh.getEspVersion();
        this.espVersion = espacioh.getEspVersion();
        this.espAgenda = new Agenda(espacioh.getAgenda());
        
    }
    public Long getEspId() {
        return espId;
    }

    public void setEspId(Long espId) {
        this.espId = espId;
    }

    public Date getEspHoraFin() {
        return espHoraFin;
    }

    public void setEspHoraFin(Date espHoraFin) {
        this.espHoraFin = espHoraFin;
    }

    public Date getEspHoraInicio() {
        return espHoraInicio;
    }

    public void setEspHoraInicio(Date espHoraInicio) {
        this.espHoraInicio = espHoraInicio;
    }

    public Long getEspVersion() {
        return espVersion;
    }

    public void setEspVersion(Long espVersion) {
        this.espVersion = espVersion;
    }

    @XmlTransient
    public List<CitasPorEspacio> getCitasPorEspacioList() {
        return citasPorEspacioList;
    }

    public void setCitasPorEspacioList(List<CitasPorEspacio> citasPorEspacioList) {
        this.citasPorEspacioList = citasPorEspacioList;
    }

    public Agenda getEspAgenda() {
        return espAgenda;
    }

    public void setEspAgenda(Agenda espAgenda) {
        this.espAgenda = espAgenda;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (espId != null ? espId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Espacio)) {
            return false;
        }
        Espacio other = (Espacio) object;
        if ((this.espId == null && other.espId != null) || (this.espId != null && !this.espId.equals(other.espId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Espacio[ espId=" + espId + " ]";
    }
    
}
