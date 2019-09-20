/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.admin.ac.cr.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
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
    , @NamedQuery(name = "Proyecto.findByProVersion", query = "SELECT p FROM Proyecto p WHERE p.proVersion = :proVersion")})
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
    @Version
    @Column(name = "PRO_VERSION")
    private Long proVersion;
    @OneToMany(mappedBy = "proId", fetch = FetchType.LAZY)
    private List<Actividad> actividadList;
    @OneToMany(mappedBy = "proId", fetch = FetchType.LAZY)
    private List<Seguimiento> seguimientoList;
    @OneToMany(mappedBy = "proId", fetch = FetchType.LAZY)
    private List<AdminiPorProyecto> adminiPorProyectoList;

    public Proyecto() {
    }
    public Proyecto(ProyectoDto proyecto) {
        this.proId = proyecto.getProId();
        this.actualizar(proyecto);
    }
    //Rellenar datos
    public void actualizar(ProyectoDto proyecto){
        
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

    @XmlTransient
    public List<Actividad> getActividadList() {
        return actividadList;
    }

    public void setActividadList(List<Actividad> actividadList) {
        this.actividadList = actividadList;
    }

    @XmlTransient
    public List<Seguimiento> getSeguimientoList() {
        return seguimientoList;
    }

    public void setSeguimientoList(List<Seguimiento> seguimientoList) {
        this.seguimientoList = seguimientoList;
    }

    @XmlTransient
    public List<AdminiPorProyecto> getAdminiPorProyectoList() {
        return adminiPorProyectoList;
    }

    public void setAdminiPorProyectoList(List<AdminiPorProyecto> adminiPorProyectoList) {
        this.adminiPorProyectoList = adminiPorProyectoList;
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
        return "ws.admin.ac.cr.model.Proyecto[ proId=" + proId + " ]";
    }
    
}
