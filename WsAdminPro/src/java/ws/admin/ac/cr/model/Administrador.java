/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.admin.ac.cr.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Carlos Olivares
 */
@Entity
@Table(name = "ADM_ADMINISTRADOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Administrador.findAll", query = "SELECT a FROM Administrador a")
    , @NamedQuery(name = "Administrador.findByAdnId", query = "SELECT a FROM Administrador a WHERE a.adnId = :adnId")
    , @NamedQuery(name = "Administrador.findByAdnNombre", query = "SELECT a FROM Administrador a WHERE a.adnNombre = :adnNombre")
    , @NamedQuery(name = "Administrador.findByAdnPapellido", query = "SELECT a FROM Administrador a WHERE a.adnPapellido = :adnPapellido")
    , @NamedQuery(name = "Administrador.findByAdnSapellido", query = "SELECT a FROM Administrador a WHERE a.adnSapellido = :adnSapellido")
    , @NamedQuery(name = "Administrador.findByAdnCedula", query = "SELECT a FROM Administrador a WHERE a.adnCedula = :adnCedula")
    , @NamedQuery(name = "Administrador.findByAdnCorreo", query = "SELECT a FROM Administrador a WHERE a.adnCorreo = :adnCorreo")
    , @NamedQuery(name = "Administrador.findByAdnUsuario", query = "SELECT a FROM Administrador a WHERE a.adnUsuario = :adnUsuario")
    , @NamedQuery(name = "Administrador.findByAdnContrasena", query = "SELECT a FROM Administrador a WHERE a.adnContrasena = :adnContrasena")
    , @NamedQuery(name = "Administrador.findByAdnEstado", query = "SELECT a FROM Administrador a WHERE a.adnEstado = :adnEstado")
    , @NamedQuery(name = "Administrador.findByAdnVersion", query = "SELECT a FROM Administrador a WHERE a.adnVersion = :adnVersion")
    ,@NamedQuery(name = "Administrador.findByUsuClave", query = "SELECT a FROM Administrador a WHERE a.adnUsuario =:adnUsuario AND a.adnContrasena =:adnClave")})
public class Administrador implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "ADM_ID_GENERATOR", sequenceName = "ADM_ADMINISTRADOR_SEQ01", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ADM_ID_GENERATOR")
    @Basic(optional = false)
    @Column(name = "ADN_ID")
    private Long adnId;
    @Basic(optional = false)
    @Column(name = "ADN_NOMBRE")
    private String adnNombre;
    @Basic(optional = false)
    @Column(name = "ADN_PAPELLIDO")
    private String adnPapellido;
    @Basic(optional = false)
    @Column(name = "ADN_SAPELLIDO")
    private String adnSapellido;
    @Basic(optional = false)
    @Column(name = "ADN_CEDULA")
    private String adnCedula;
    @Basic(optional = false)
    @Column(name = "ADN_CORREO")
    private String adnCorreo;
    @Basic(optional = false)
    @Column(name = "ADN_USUARIO")
    private String adnUsuario;
    @Basic(optional = false)
    @Column(name = "ADN_CONTRASENA")
    private String adnContrasena;
    @Basic(optional = false)
    @Column(name = "ADN_ESTADO")
    private String adnEstado;
    @Basic(optional = false)
    @Column(name = "ADN_VERSION")
    private Long adnVersion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "axpAdministrador", fetch = FetchType.LAZY)
    private List<AdminPorPro> adminPorProList;

    public Administrador() {
    }

    public Administrador(Long adnId) {
        this.adnId = adnId;
    }

    public Administrador(Long adnId, String adnNombre, String adnPapellido, String adnSapellido, String adnCedula, String adnCorreo, String adnUsuario, String adnContrasena, String adnEstado, Long adnVersion) {
        this.adnId = adnId;
        this.adnNombre = adnNombre;
        this.adnPapellido = adnPapellido;
        this.adnSapellido = adnSapellido;
        this.adnCedula = adnCedula;
        this.adnCorreo = adnCorreo;
        this.adnUsuario = adnUsuario;
        this.adnContrasena = adnContrasena;
        this.adnEstado = adnEstado;
        this.adnVersion = adnVersion;
    }
    public Administrador(AdministradorDto admin) {
        this.adnId = admin.getAdnId();
        this.actualizar(admin);
    }
    public void actualizar(AdministradorDto admin) {
        this.adnNombre = admin.getAdnNombre();
        this.adnPapellido = admin.getAdnPapellido();
        this.adnSapellido = admin.getAdnSapellido();
        this.adnCedula = admin.getAdnCedula();
        this.adnCorreo = admin.getAdnCorreo();
        this.adnUsuario = admin.getAdnUsuario();
        this.adnContrasena = admin.getAdnContrasena();
        this.adnEstado = admin.getAdnEstado();
        this.adnVersion = admin.getAdnVersion();
    }
    
    public Long getAdnId() {
        return adnId;
    }

    public void setAdnId(Long adnId) {
        this.adnId = adnId;
    }

    public String getAdnNombre() {
        return adnNombre;
    }

    public void setAdnNombre(String adnNombre) {
        this.adnNombre = adnNombre;
    }

    public String getAdnPapellido() {
        return adnPapellido;
    }

    public void setAdnPapellido(String adnPapellido) {
        this.adnPapellido = adnPapellido;
    }

    public String getAdnSapellido() {
        return adnSapellido;
    }

    public void setAdnSapellido(String adnSapellido) {
        this.adnSapellido = adnSapellido;
    }

    public String getAdnCedula() {
        return adnCedula;
    }

    public void setAdnCedula(String adnCedula) {
        this.adnCedula = adnCedula;
    }

    public String getAdnCorreo() {
        return adnCorreo;
    }

    public void setAdnCorreo(String adnCorreo) {
        this.adnCorreo = adnCorreo;
    }

    public String getAdnUsuario() {
        return adnUsuario;
    }

    public void setAdnUsuario(String adnUsuario) {
        this.adnUsuario = adnUsuario;
    }

    public String getAdnContrasena() {
        return adnContrasena;
    }

    public void setAdnContrasena(String adnContrasena) {
        this.adnContrasena = adnContrasena;
    }

    public String getAdnEstado() {
        return adnEstado;
    }

    public void setAdnEstado(String adnEstado) {
        this.adnEstado = adnEstado;
    }

    public Long getAdnVersion() {
        return adnVersion;
    }

    public void setAdnVersion(Long adnVersion) {
        this.adnVersion = adnVersion;
    }

    @XmlTransient
    public List<AdminPorPro> getAdminPorProList() {
        return adminPorProList;
    }

    public void setAdminPorProList(List<AdminPorPro> adminPorProList) {
        this.adminPorProList = adminPorProList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adnId != null ? adnId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Administrador)) {
            return false;
        }
        Administrador other = (Administrador) object;
        if ((this.adnId == null && other.adnId != null) || (this.adnId != null && !this.adnId.equals(other.adnId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.unaplanillaws2.controller.model2.Administrador[ adnId=" + adnId + " ]";
    }
    
}
