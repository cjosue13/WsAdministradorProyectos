/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "CLN_PACIENTES", catalog = "", schema = "CLINICAUNA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Paciente.findAll", query = "SELECT p FROM Paciente p")
    , @NamedQuery(name = "Paciente.findByPacId", query = "SELECT p FROM Paciente p WHERE p.pacId = :pacId")
    , @NamedQuery(name = "Paciente.findByPacNombre", query = "SELECT p FROM Paciente p WHERE p.pacNombre = :pacNombre")
    , @NamedQuery(name = "Paciente.findByPacPapellido", query = "SELECT p FROM Paciente p WHERE p.pacPapellido = :pacPapellido")
    , @NamedQuery(name = "Paciente.findByPacSapellido", query = "SELECT p FROM Paciente p WHERE p.pacSapellido = :pacSapellido")
    , @NamedQuery(name = "Paciente.findByPacCedula", query = "SELECT p FROM Paciente p WHERE p.pacCedula = :pacCedula")
    , @NamedQuery(name = "Paciente.findByPacCorreo", query = "SELECT p FROM Paciente p WHERE p.pacCorreo = :pacCorreo")
    , @NamedQuery(name = "Paciente.findByPacGenero", query = "SELECT p FROM Paciente p WHERE p.pacGenero = :pacGenero")
    , @NamedQuery(name = "Paciente.findByPacFechanacimiento", query = "SELECT p FROM Paciente p WHERE p.pacFechanacimiento = :pacFechanacimiento")
    , @NamedQuery(name = "Paciente.findByPacVersion", query = "SELECT p FROM Paciente p WHERE p.pacVersion = :pacVersion")})
public class Paciente implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "PAC_ID")
    private Long pacId;
    @Basic(optional = false)
    @Column(name = "PAC_NOMBRE")
    private String pacNombre;
    @Basic(optional = false)
    @Column(name = "PAC_PAPELLIDO")
    private String pacPapellido;
    @Basic(optional = false)
    @Column(name = "PAC_SAPELLIDO")
    private String pacSapellido;
    @Basic(optional = false)
    @Column(name = "PAC_CEDULA")
    private String pacCedula;
    @Basic(optional = false)
    @Column(name = "PAC_CORREO")
    private String pacCorreo;
    @Basic(optional = false)
    @Column(name = "PAC_GENERO")
    private String pacGenero;
    @Basic(optional = false)
    @Column(name = "PAC_FECHANACIMIENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date pacFechanacimiento;
    @Basic(optional = false)
    @Column(name = "PAC_VERSION")
    private Long pacVersion;
    @OneToMany(mappedBy = "ctPaciente")
    private List<Cita> citaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "expPaciente")
    private List<Expediente> expedienteList;

    public Paciente() {
    }

    public Paciente(Long pacId) {
        this.pacId = pacId;
    }

    public Paciente(Long pacId, String pacNombre, String pacPapellido, String pacSapellido, String pacCedula, String pacCorreo, String pacGenero, Date pacFechanacimiento, Long pacVersion) {
        this.pacId = pacId;
        this.pacNombre = pacNombre;
        this.pacPapellido = pacPapellido;
        this.pacSapellido = pacSapellido;
        this.pacCedula = pacCedula;
        this.pacCorreo = pacCorreo;
        this.pacGenero = pacGenero;
        this.pacFechanacimiento = pacFechanacimiento;
        this.pacVersion = pacVersion;
    }
     public Paciente(PacienteDto PacienteDto) {
        this.pacId = PacienteDto.getID();
        actualizarPaciente(PacienteDto);
    }
    
    public void actualizarPaciente(PacienteDto PacienteDto) {
        this.pacCedula = PacienteDto.getCedula();
        this.pacCorreo = PacienteDto.getCorreo();
        this.pacFechanacimiento = Date.from(PacienteDto.getFechaNacimiento().atStartOfDay()
                .atZone(ZoneId.systemDefault())
                .toInstant());
        this.pacGenero = PacienteDto.getGenero();
        this.pacNombre = PacienteDto.getNombre();
        this.pacPapellido = PacienteDto.getpApellido();
        this.pacSapellido = PacienteDto.getsApellido();
        //this.medicoList = new ArrayList<>();
        //this.usId = MedicoDto.getID();
    }

    public Long getPacId() {
        return pacId;
    }

    public void setPacId(Long pacId) {
        this.pacId = pacId;
    }

    public String getPacNombre() {
        return pacNombre;
    }

    public void setPacNombre(String pacNombre) {
        this.pacNombre = pacNombre;
    }

    public String getPacPapellido() {
        return pacPapellido;
    }

    public void setPacPapellido(String pacPapellido) {
        this.pacPapellido = pacPapellido;
    }

    public String getPacSapellido() {
        return pacSapellido;
    }

    public void setPacSapellido(String pacSapellido) {
        this.pacSapellido = pacSapellido;
    }

    public String getPacCedula() {
        return pacCedula;
    }

    public void setPacCedula(String pacCedula) {
        this.pacCedula = pacCedula;
    }

    public String getPacCorreo() {
        return pacCorreo;
    }

    public void setPacCorreo(String pacCorreo) {
        this.pacCorreo = pacCorreo;
    }

    public String getPacGenero() {
        return pacGenero;
    }

    public void setPacGenero(String pacGenero) {
        this.pacGenero = pacGenero;
    }

    public Date getPacFechanacimiento() {
        return pacFechanacimiento;
    }

    public void setPacFechanacimiento(Date pacFechanacimiento) {
        this.pacFechanacimiento = pacFechanacimiento;
    }

    public Long getPacVersion() {
        return pacVersion;
    }

    public void setPacVersion(Long pacVersion) {
        this.pacVersion = pacVersion;
    }

    @XmlTransient
    public List<Cita> getCitaList() {
        return citaList;
    }

    public void setCitaList(List<Cita> citaList) {
        this.citaList = citaList;
    }

    @XmlTransient
    public List<Expediente> getExpedienteList() {
        return expedienteList;
    }

    public void setExpedienteList(List<Expediente> expedienteList) {
        this.expedienteList = expedienteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pacId != null ? pacId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paciente)) {
            return false;
        }
        Paciente other = (Paciente) object;
        if ((this.pacId == null && other.pacId != null) || (this.pacId != null && !this.pacId.equals(other.pacId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Paciente[ pacId=" + pacId + " ]";
    }
    
}
