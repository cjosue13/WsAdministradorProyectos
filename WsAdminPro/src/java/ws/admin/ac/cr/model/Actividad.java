/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.admin.ac.cr.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Carlos Olivares
 */
@Entity
@Table(name = "ADM_ACTIVIDAD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Actividad.findAll", query = "SELECT a FROM Actividad a")
    , @NamedQuery(name = "Actividad.findByActId", query = "SELECT a FROM Actividad a WHERE a.actId = :actId")
    , @NamedQuery(name = "Actividad.findByActDescripcion", query = "SELECT a FROM Actividad a WHERE a.actDescripcion = :actDescripcion")
    , @NamedQuery(name = "Actividad.findByActEncargado", query = "SELECT a FROM Actividad a WHERE a.actEncargado = :actEncargado")
    , @NamedQuery(name = "Actividad.findByActFechainicio", query = "SELECT a FROM Actividad a WHERE a.actFechainicio = :actFechainicio")
    , @NamedQuery(name = "Actividad.findByActFechafinal", query = "SELECT a FROM Actividad a WHERE a.actFechafinal = :actFechafinal")
    , @NamedQuery(name = "Actividad.findByActEstado", query = "SELECT a FROM Actividad a WHERE a.actEstado = :actEstado")
    , @NamedQuery(name = "Actividad.findByActVersion", query = "SELECT a FROM Actividad a WHERE a.actVersion = :actVersion")
    , @NamedQuery(name = "Actividad.findByActNumorden", query = "SELECT a FROM Actividad a WHERE a.actNumorden = :actNumorden")
    , @NamedQuery(name = "Actividad.findByActFechainireal", query = "SELECT a FROM Actividad a WHERE a.actFechainireal = :actFechainireal")
    , @NamedQuery(name = "Actividad.findByActFechafinreal", query = "SELECT a FROM Actividad a WHERE a.actFechafinreal = :actFechafinreal")})
public class Actividad implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "ACT_ID_GENERATOR", sequenceName = "ADM_ACTIVIDAD_SEQ01", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ACT_ID_GENERATOR")
    @Basic(optional = false)
    @Column(name = "ACT_ID")
    private Long actId;
    @Basic(optional = false)
    @Column(name = "ACT_DESCRIPCION")
    private String actDescripcion;
    @Basic(optional = false)
    @Column(name = "ACT_ENCARGADO")
    private String actEncargado;
    @Basic(optional = false)
    @Column(name = "ACT_FECHAINICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date actFechainicio;
    @Basic(optional = false)
    @Column(name = "ACT_FECHAFINAL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date actFechafinal;
    @Basic(optional = false)
    @Column(name = "ACT_ESTADO")
    private String actEstado;
    @Basic(optional = false)
    @Column(name = "ACT_VERSION")
    private Long actVersion;
    @Basic(optional = false)
    @Column(name = "ACT_NUMORDEN")
    private Integer actNumorden;
    @Column(name = "ACT_FECHAINIREAL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date actFechainireal;
    @Column(name = "ACT_FECHAFINREAL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date actFechafinreal;
    @JoinColumn(name = "ACT_PROYECTO", referencedColumnName = "PRO_ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Proyecto actProyecto;

    public Actividad() {
    }

    public Actividad(Long actId) {
        this.actId = actId;
    }

    public Actividad(Long actId, String actDescripcion, String actEncargado, Date actFechainicio, Date actFechafinal, String actEstado, Long actVersion, Integer actNumorden) {
        this.actId = actId;
        this.actDescripcion = actDescripcion;
        this.actEncargado = actEncargado;
        this.actFechainicio = actFechainicio;
        this.actFechafinal = actFechafinal;
        this.actEstado = actEstado;
        this.actVersion = actVersion;
        this.actNumorden = actNumorden;
    }

    public Actividad(ActividadDto actividad) {
        this.actId = actividad.getActId();
        this.actualizar(actividad);
    }

    //Rellenar datos
    public void actualizar(ActividadDto actividad) {
        this.actDescripcion = actividad.getActDescripcion();
        this.actDescripcion = actividad.getActDescripcion();
        this.actEncargado = actividad.getActEncargado();
        this.actEstado = actividad.getActEstado();
        LocalDate fechFinal = LocalDate.parse(actividad.getActFechafinal(), DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        LocalDate fechFinalReal = LocalDate.parse(actividad.getActFechafinreal(), DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        LocalDate fechIni = LocalDate.parse(actividad.getActFechainicio(), DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        LocalDate fechIniReal = LocalDate.parse(actividad.getActFechainireal(), DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        this.actFechafinreal = Date.from(fechFinalReal.atStartOfDay(ZoneId.systemDefault()).toInstant());
        this.actFechainireal = Date.from(fechIniReal.atStartOfDay(ZoneId.systemDefault()).toInstant());
        this.actFechafinal = Date.from(fechFinal.atStartOfDay(ZoneId.systemDefault()).toInstant());
        this.actFechainicio = Date.from(fechIni.atStartOfDay(ZoneId.systemDefault()).toInstant());
        this.actNumorden = actividad.getActNumorden();
        //this.actProyecto = new Proyecto(actividad.getActProyecto());
        this.actVersion = actividad.getActVersion();
    }

    public Long getActId() {
        return actId;
    }

    public void setActId(Long actId) {
        this.actId = actId;
    }

    public String getActDescripcion() {
        return actDescripcion;
    }

    public void setActDescripcion(String actDescripcion) {
        this.actDescripcion = actDescripcion;
    }

    public String getActEncargado() {
        return actEncargado;
    }

    public void setActEncargado(String actEncargado) {
        this.actEncargado = actEncargado;
    }

    public Date getActFechainicio() {
        return actFechainicio;
    }

    public void setActFechainicio(Date actFechainicio) {
        this.actFechainicio = actFechainicio;
    }

    public Date getActFechafinal() {
        return actFechafinal;
    }

    public void setActFechafinal(Date actFechafinal) {
        this.actFechafinal = actFechafinal;
    }

    public String getActEstado() {
        return actEstado;
    }

    public void setActEstado(String actEstado) {
        this.actEstado = actEstado;
    }

    public Long getActVersion() {
        return actVersion;
    }

    public void setActVersion(Long actVersion) {
        this.actVersion = actVersion;
    }

    public Integer getActNumorden() {
        return actNumorden;
    }

    public void setActNumorden(Integer actNumorden) {
        this.actNumorden = actNumorden;
    }

    public Date getActFechainireal() {
        return actFechainireal;
    }

    public void setActFechainireal(Date actFechainireal) {
        this.actFechainireal = actFechainireal;
    }

    public Date getActFechafinreal() {
        return actFechafinreal;
    }

    public void setActFechafinreal(Date actFechafinreal) {
        this.actFechafinreal = actFechafinreal;
    }

    public Proyecto getActProyecto() {
        return actProyecto;
    }

    public void setActProyecto(Proyecto actProyecto) {
        this.actProyecto = actProyecto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (actId != null ? actId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Actividad)) {
            return false;
        }
        Actividad other = (Actividad) object;
        if ((this.actId == null && other.actId != null) || (this.actId != null && !this.actId.equals(other.actId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.unaplanillaws2.controller.model2.Actividad[ actId=" + actId + " ]";
    }

}
