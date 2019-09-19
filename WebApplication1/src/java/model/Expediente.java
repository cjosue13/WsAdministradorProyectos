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
@Table(name = "CLN_EXPEDIENTES", catalog = "", schema = "CLINICAUNA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Expediente.findAll", query = "SELECT e FROM Expediente e")
    , @NamedQuery(name = "Expediente.findByPlClnExpediente", query = "SELECT e FROM Expediente e WHERE e.plClnExpediente = :plClnExpediente")
    , @NamedQuery(name = "Expediente.findByExpAntecedentePatologicos", query = "SELECT e FROM Expediente e WHERE e.expAntecedentePatologicos = :expAntecedentePatologicos")
    , @NamedQuery(name = "Expediente.findByExpHospitalizaciones", query = "SELECT e FROM Expediente e WHERE e.expHospitalizaciones = :expHospitalizaciones")
    , @NamedQuery(name = "Expediente.findByExpOperaciones", query = "SELECT e FROM Expediente e WHERE e.expOperaciones = :expOperaciones")
    , @NamedQuery(name = "Expediente.findByExpAlergias", query = "SELECT e FROM Expediente e WHERE e.expAlergias = :expAlergias")
    , @NamedQuery(name = "Expediente.findByExpTratamientos", query = "SELECT e FROM Expediente e WHERE e.expTratamientos = :expTratamientos")
    , @NamedQuery(name = "Expediente.findByExpAntecedentesFamiliares", query = "SELECT e FROM Expediente e WHERE e.expAntecedentesFamiliares = :expAntecedentesFamiliares")
    , @NamedQuery(name = "Expediente.findByExpVersion", query = "SELECT e FROM Expediente e WHERE e.expVersion = :expVersion")})
public class Expediente implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "PL_CLN_EXPEDIENTE")
    private Long plClnExpediente;
    @Basic(optional = false)
    @Column(name = "EXP_ANTECEDENTE_PATOLOGICOS")
    private String expAntecedentePatologicos;
    @Basic(optional = false)
    @Column(name = "EXP_HOSPITALIZACIONES")
    private String expHospitalizaciones;
    @Basic(optional = false)
    @Column(name = "EXP_OPERACIONES")
    private String expOperaciones;
    @Basic(optional = false)
    @Column(name = "EXP_ALERGIAS")
    private String expAlergias;
    @Basic(optional = false)
    @Column(name = "EXP_TRATAMIENTOS")
    private String expTratamientos;
    @Basic(optional = false)
    @Column(name = "EXP_ANTECEDENTES_FAMILIARES")
    private String expAntecedentesFamiliares;
    @Basic(optional = false)
    @Column(name = "EXP_VERSION")
    private Long expVersion;
    @OneToMany(mappedBy = "cntExpediente")
    private List<Control> controlList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "exmExpediente")
    private List<Examen> examenList;
    @JoinColumn(name = "EXP_PACIENTE", referencedColumnName = "PAC_ID")
    @ManyToOne(optional = false)
    private Paciente expPaciente;

    public Expediente() {
    }
    public void actualizarExpediente(ExpedienteDto expediente){
        this.expAlergias = expediente.getAlergias();
        this.expAntecedentePatologicos = expediente.getAntecedentesPatologicos();
        this.expAntecedentesFamiliares = expediente.getAntecedentesFamiliares();
        this.expHospitalizaciones = expediente.getHospitalizaciones();
        this.expOperaciones = expediente.getOperaciones();
        this.expTratamientos = expediente.getTratamientos();
        this.expVersion = expediente.getExpVersion();
        this.expPaciente = new Paciente(expediente.getPaciente());
    }
    
    public Expediente(ExpedienteDto expedienteDto) {
        this.plClnExpediente = expedienteDto.getExpID();
        actualizarExpediente(expedienteDto);
    }
    public Expediente(Long plClnExpediente) {
        this.plClnExpediente = plClnExpediente;
    }

    public Expediente(Long plClnExpediente, String expAntecedentePatologicos, String expHospitalizaciones, String expOperaciones, String expAlergias, String expTratamientos, String expAntecedentesFamiliares, Long expVersion) {
        this.plClnExpediente = plClnExpediente;
        this.expAntecedentePatologicos = expAntecedentePatologicos;
        this.expHospitalizaciones = expHospitalizaciones;
        this.expOperaciones = expOperaciones;
        this.expAlergias = expAlergias;
        this.expTratamientos = expTratamientos;
        this.expAntecedentesFamiliares = expAntecedentesFamiliares;
        this.expVersion = expVersion;
    }

    public Long getPlClnExpediente() {
        return plClnExpediente;
    }

    public void setPlClnExpediente(Long plClnExpediente) {
        this.plClnExpediente = plClnExpediente;
    }

    public String getExpAntecedentePatologicos() {
        return expAntecedentePatologicos;
    }

    public void setExpAntecedentePatologicos(String expAntecedentePatologicos) {
        this.expAntecedentePatologicos = expAntecedentePatologicos;
    }

    public String getExpHospitalizaciones() {
        return expHospitalizaciones;
    }

    public void setExpHospitalizaciones(String expHospitalizaciones) {
        this.expHospitalizaciones = expHospitalizaciones;
    }

    public String getExpOperaciones() {
        return expOperaciones;
    }

    public void setExpOperaciones(String expOperaciones) {
        this.expOperaciones = expOperaciones;
    }

    public String getExpAlergias() {
        return expAlergias;
    }

    public void setExpAlergias(String expAlergias) {
        this.expAlergias = expAlergias;
    }

    public String getExpTratamientos() {
        return expTratamientos;
    }

    public void setExpTratamientos(String expTratamientos) {
        this.expTratamientos = expTratamientos;
    }

    public String getExpAntecedentesFamiliares() {
        return expAntecedentesFamiliares;
    }

    public void setExpAntecedentesFamiliares(String expAntecedentesFamiliares) {
        this.expAntecedentesFamiliares = expAntecedentesFamiliares;
    }

    public Long getExpVersion() {
        return expVersion;
    }

    public void setExpVersion(Long expVersion) {
        this.expVersion = expVersion;
    }

    @XmlTransient
    public List<Control> getControlList() {
        return controlList;
    }

    public void setControlList(List<Control> controlList) {
        this.controlList = controlList;
    }

    @XmlTransient
    public List<Examen> getExamenList() {
        return examenList;
    }

    public void setExamenList(List<Examen> examenList) {
        this.examenList = examenList;
    }

    public Paciente getExpPaciente() {
        return expPaciente;
    }

    public void setExpPaciente(Paciente expPaciente) {
        this.expPaciente = expPaciente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (plClnExpediente != null ? plClnExpediente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Expediente)) {
            return false;
        }
        Expediente other = (Expediente) object;
        if ((this.plClnExpediente == null && other.plClnExpediente != null) || (this.plClnExpediente != null && !this.plClnExpediente.equals(other.plClnExpediente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Expediente[ plClnExpediente=" + plClnExpediente + " ]";
    }
    
}
