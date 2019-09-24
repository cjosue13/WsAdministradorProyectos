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
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
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
@Table(name = "ADM_PROYECTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proyecto.findAll", query = "SELECT p FROM Proyecto p")
    , @NamedQuery(name = "Proyecto.findByProId", query = "SELECT p FROM Proyecto p WHERE p.proId = :proId")
    , @NamedQuery(name = "Proyecto.findByProNombre", query = "SELECT p FROM Proyecto p WHERE p.proNombre = :proNombre")
    , @NamedQuery(name = "Proyecto.findByProPatrocinador", query = "SELECT p FROM Proyecto p WHERE p.proPatrocinador = :proPatrocinador")
    , @NamedQuery(name = "Proyecto.findByProLiderusuario", query = "SELECT p FROM Proyecto p WHERE p.proLiderusuario = :proLiderusuario")
    , @NamedQuery(name = "Proyecto.findByProLidertecnico", query = "SELECT p FROM Proyecto p WHERE p.proLidertecnico = :proLidertecnico")
    , @NamedQuery(name = "Proyecto.findByProCorreopatrocinador", query = "SELECT p FROM Proyecto p WHERE p.proCorreopatrocinador = :proCorreopatrocinador")
    , @NamedQuery(name = "Proyecto.findByProCorreousuario", query = "SELECT p FROM Proyecto p WHERE p.proCorreousuario = :proCorreousuario")
    , @NamedQuery(name = "Proyecto.findByProCorreotecnico", query = "SELECT p FROM Proyecto p WHERE p.proCorreotecnico = :proCorreotecnico")
    , @NamedQuery(name = "Proyecto.findByProFechainicio", query = "SELECT p FROM Proyecto p WHERE p.proFechainicio = :proFechainicio")
    , @NamedQuery(name = "Proyecto.findByProFechafinal", query = "SELECT p FROM Proyecto p WHERE p.proFechafinal = :proFechafinal")
    , @NamedQuery(name = "Proyecto.findByProEstado", query = "SELECT p FROM Proyecto p WHERE p.proEstado = :proEstado")
    , @NamedQuery(name = "Proyecto.findByProVersion", query = "SELECT p FROM Proyecto p WHERE p.proVersion = :proVersion")
    , @NamedQuery(name = "Proyecto.findByProFechainireal", query = "SELECT p FROM Proyecto p WHERE p.proFechainireal = :proFechainireal")
    , @NamedQuery(name = "Proyecto.findByProFechafinreal", query = "SELECT p FROM Proyecto p WHERE p.proFechafinreal = :proFechafinreal")})
public class Proyecto implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "PRO_ID_GENERATOR", sequenceName = "ADM_PROYECTO_SEQ01", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRO_ID_GENERATOR")
    @Basic(optional = false)
    @Column(name = "PRO_ID")
    private Long proId;
    @Basic(optional = false)
    @Column(name = "PRO_NOMBRE")
    private String proNombre;
    @Basic(optional = false)
    @Column(name = "PRO_PATROCINADOR")
    private String proPatrocinador;
    @Basic(optional = false)
    @Column(name = "PRO_LIDERUSUARIO")
    private String proLiderusuario;
    @Basic(optional = false)
    @Column(name = "PRO_LIDERTECNICO")
    private String proLidertecnico;
    @Basic(optional = false)
    @Column(name = "PRO_CORREOPATROCINADOR")
    private String proCorreopatrocinador;
    @Basic(optional = false)
    @Column(name = "PRO_CORREOUSUARIO")
    private String proCorreousuario;
    @Basic(optional = false)
    @Column(name = "PRO_CORREOTECNICO")
    private String proCorreotecnico;
    @Basic(optional = false)
    @Column(name = "PRO_FECHAINICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date proFechainicio;
    @Column(name = "PRO_FECHAFINAL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date proFechafinal;
    @Basic(optional = false)
    @Column(name = "PRO_ESTADO")
    private String proEstado;
    @Basic(optional = false)
    @Column(name = "PRO_VERSION")
    private Long proVersion;
    @Column(name = "PRO_FECHAINIREAL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date proFechainireal;
    @Column(name = "PRO_FECHAFINREAL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date proFechafinreal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "actProyecto", fetch = FetchType.LAZY)
    private List<Actividad> actividadList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "segProyecto", fetch = FetchType.LAZY)
    private List<Seguimiento> seguimientoList;
    @JoinColumn(name = "PRO_ADMINISTRADOR", referencedColumnName = "ADN_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Administrador proAdministrador;

    public Proyecto() {
    }

    public Proyecto(Long proId) {
        this.proId = proId;
    }

    public Proyecto(Long proId, String proNombre, String proPatrocinador, String proLiderusuario, String proLidertecnico, String proCorreopatrocinador, String proCorreousuario, String proCorreotecnico, Date proFechainicio, String proEstado, Long proVersion) {
        this.proId = proId;
        this.proNombre = proNombre;
        this.proPatrocinador = proPatrocinador;
        this.proLiderusuario = proLiderusuario;
        this.proLidertecnico = proLidertecnico;
        this.proCorreopatrocinador = proCorreopatrocinador;
        this.proCorreousuario = proCorreousuario;
        this.proCorreotecnico = proCorreotecnico;
        this.proFechainicio = proFechainicio;
        this.proEstado = proEstado;
        this.proVersion = proVersion;
    }

    public Proyecto(ProyectoDto proyecto) {
        this.proId = proyecto.getProId();
        this.actualizar(proyecto);
    }

    //Rellenar datos
    public void actualizar(ProyectoDto proyecto) {
        this.proCorreopatrocinador = proyecto.getProCorreopatrocinador();
        this.proCorreotecnico = proyecto.getProCorreotecnico();
        this.proCorreousuario = proyecto.getProCorreousuario();
        this.proEstado = proyecto.getProEstado();
        LocalDate fechFinal = LocalDate.parse(proyecto.getProFechafinal(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate fechFinalReal = LocalDate.parse(proyecto.getProFechafinreal(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate fechIni = LocalDate.parse(proyecto.getProFechainicio(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate fechIniReal = LocalDate.parse(proyecto.getProFechainireal(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        this.proFechafinreal = Date.from(fechFinalReal.atStartOfDay(ZoneId.systemDefault()).toInstant());
        this.proFechainireal = Date.from(fechIniReal.atStartOfDay(ZoneId.systemDefault()).toInstant());
        //Agregar 2 fechas que faltan
        this.proFechafinal = Date.from(fechFinal.atStartOfDay(ZoneId.systemDefault()).toInstant());
        this.proFechainicio = Date.from(fechIni.atStartOfDay(ZoneId.systemDefault()).toInstant());
        this.proLidertecnico = proyecto.getProLidertecnico();
        this.proLiderusuario = proyecto.getProLiderusuario();
        this.proNombre = proyecto.getProNombre();
        this.proPatrocinador = proyecto.getProPatrocinador();
        this.proVersion = proyecto.getProVersion();
        this.actividadList = proyecto.getActividadesToDB();
        for(Actividad a:this.actividadList)a.setActProyecto(this);
        this.seguimientoList = proyecto.getSeguimientoToDB();
        for(Seguimiento s:this.seguimientoList)s.setSegProyecto(this);
        this.proAdministrador=new Administrador(proyecto.getProAdmin());
    }

    public Long getProId() {
        return proId;
    }

    public void setProId(Long proId) {
        this.proId = proId;
    }

    public String getProNombre() {
        return proNombre;
    }

    public void setProNombre(String proNombre) {
        this.proNombre = proNombre;
    }

    public String getProPatrocinador() {
        return proPatrocinador;
    }

    public void setProPatrocinador(String proPatrocinador) {
        this.proPatrocinador = proPatrocinador;
    }

    public String getProLiderusuario() {
        return proLiderusuario;
    }

    public void setProLiderusuario(String proLiderusuario) {
        this.proLiderusuario = proLiderusuario;
    }

    public String getProLidertecnico() {
        return proLidertecnico;
    }

    public void setProLidertecnico(String proLidertecnico) {
        this.proLidertecnico = proLidertecnico;
    }

    public String getProCorreopatrocinador() {
        return proCorreopatrocinador;
    }

    public void setProCorreopatrocinador(String proCorreopatrocinador) {
        this.proCorreopatrocinador = proCorreopatrocinador;
    }

    public String getProCorreousuario() {
        return proCorreousuario;
    }

    public void setProCorreousuario(String proCorreousuario) {
        this.proCorreousuario = proCorreousuario;
    }

    public String getProCorreotecnico() {
        return proCorreotecnico;
    }

    public void setProCorreotecnico(String proCorreotecnico) {
        this.proCorreotecnico = proCorreotecnico;
    }

    public Date getProFechainicio() {
        return proFechainicio;
    }

    public void setProFechainicio(Date proFechainicio) {
        this.proFechainicio = proFechainicio;
    }

    public Date getProFechafinal() {
        return proFechafinal;
    }

    public void setProFechafinal(Date proFechafinal) {
        this.proFechafinal = proFechafinal;
    }

    public String getProEstado() {
        return proEstado;
    }

    public void setProEstado(String proEstado) {
        this.proEstado = proEstado;
    }

    public Long getProVersion() {
        return proVersion;
    }

    public void setProVersion(Long proVersion) {
        this.proVersion = proVersion;
    }

    public Date getProFechainireal() {
        return proFechainireal;
    }

    public void setProFechainireal(Date proFechainireal) {
        this.proFechainireal = proFechainireal;
    }

    public Date getProFechafinreal() {
        return proFechafinreal;
    }

    public void setProFechafinreal(Date proFechafinreal) {
        this.proFechafinreal = proFechafinreal;
    }

    public List<Actividad> getActividadList() {
        return actividadList;
    }

    public void setActividadList(List<Actividad> actividadList) {
        this.actividadList = actividadList;
    }

    public List<Seguimiento> getSeguimientoList() {
        return seguimientoList;
    }

    public void setSeguimientoList(List<Seguimiento> seguimientoList) {
        this.seguimientoList = seguimientoList;
    }

    public Administrador getProAdministrador() {
        return proAdministrador;
    }

    public void setProAdministrador(Administrador proAdministrador) {
        this.proAdministrador = proAdministrador;
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (proId != null ? proId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proyecto)) {
            return false;
        }
        Proyecto other = (Proyecto) object;
        if ((this.proId == null && other.proId != null) || (this.proId != null && !this.proId.equals(other.proId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.unaplanillaws2.controller.model2.Proyecto[ proId=" + proId + " ]";
    }

}
