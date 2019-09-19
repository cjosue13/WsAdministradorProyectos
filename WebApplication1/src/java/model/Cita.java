/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Carlos Olivares
 */
@Entity
@Table(name = "CLN_CITAS", catalog = "", schema = "CLINICAUNA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cita.findAll", query = "SELECT c FROM Cita c")
    , @NamedQuery(name = "Cita.findByCtId", query = "SELECT c FROM Cita c WHERE c.ctId = :ctId")
    , @NamedQuery(name = "Cita.findByCtEstado", query = "SELECT c FROM Cita c WHERE c.ctEstado = :ctEstado")
    , @NamedQuery(name = "Cita.findByCtMotivo", query = "SELECT c FROM Cita c WHERE c.ctMotivo = :ctMotivo")
    , @NamedQuery(name = "Cita.findByCtVersion", query = "SELECT c FROM Cita c WHERE c.ctVersion = :ctVersion")})
public class Cita implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "CT_ID")
    private Long ctId;
    @Basic(optional = false)
    @Column(name = "CT_ESTADO")
    private String ctEstado;
    @Column(name = "CT_MOTIVO")
    private String ctMotivo;
    @Basic(optional = false)
    @Column(name = "CT_VERSION")
    private Long ctVersion;
    @JoinColumn(name = "CT_PACIENTE", referencedColumnName = "PAC_ID")
    @ManyToOne
    private Paciente ctPaciente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ctxespCita")
    private List<CitasPorEspacio> citasPorEspacioList;

    public Cita() {
    }

    public Cita(Long ctId) {
        this.ctId = ctId;
    }

    public Cita(Long ctId, String ctEstado, Long ctVersion) {
        this.ctId = ctId;
        this.ctEstado = ctEstado;
        this.ctVersion = ctVersion;
    }
    public void actualizarCita(CitaDto cita){
        
        //this.pkClnCita = cita.getID();
        this.ctVersion = cita.getCtVersion();
        this.ctPaciente = new Paciente(cita.getPaciente());
        //this.pkClnEspacioHora = new EspacioHora(cita.getEspacioHora());
        this.ctMotivo = cita.getMotivo();
        this.ctEstado = cita.getEstado();
        
    }
    public Cita(CitaDto citaDto) {
        this.ctId = citaDto.getID();
        actualizarCita(citaDto);
    }
    public Long getCtId() {
        return ctId;
    }

    public void setCtId(Long ctId) {
        this.ctId = ctId;
    }

    public String getCtEstado() {
        return ctEstado;
    }

    public void setCtEstado(String ctEstado) {
        this.ctEstado = ctEstado;
    }

    public String getCtMotivo() {
        return ctMotivo;
    }

    public void setCtMotivo(String ctMotivo) {
        this.ctMotivo = ctMotivo;
    }

    public Long getCtVersion() {
        return ctVersion;
    }

    public void setCtVersion(Long ctVersion) {
        this.ctVersion = ctVersion;
    }

    public Paciente getCtPaciente() {
        return ctPaciente;
    }

    public void setCtPaciente(Paciente ctPaciente) {
        this.ctPaciente = ctPaciente;
    }

    @XmlTransient
    public List<CitasPorEspacio> getCitasPorEspacioList() {
        return citasPorEspacioList;
    }

    public void setCitasPorEspacioList(List<CitasPorEspacio> citasPorEspacioList) {
        this.citasPorEspacioList = citasPorEspacioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ctId != null ? ctId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cita)) {
            return false;
        }
        Cita other = (Cita) object;
        if ((this.ctId == null && other.ctId != null) || (this.ctId != null && !this.ctId.equals(other.ctId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Cita[ ctId=" + ctId + " ]";
    }
    
}
