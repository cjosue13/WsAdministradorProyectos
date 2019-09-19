/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Carlos Olivares
 */
@Entity
@Table(name = "CLN_CONTROLES", catalog = "", schema = "CLINICAUNA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Control.findAll", query = "SELECT c FROM Control c")
    , @NamedQuery(name = "Control.findByCntId", query = "SELECT c FROM Control c WHERE c.cntId = :cntId")
    , @NamedQuery(name = "Control.findByCntFecha", query = "SELECT c FROM Control c WHERE c.cntFecha = :cntFecha")
    , @NamedQuery(name = "Control.findByCntHora", query = "SELECT c FROM Control c WHERE c.cntHora = :cntHora")
    , @NamedQuery(name = "Control.findByCntPresion", query = "SELECT c FROM Control c WHERE c.cntPresion = :cntPresion")
    , @NamedQuery(name = "Control.findByCntFrecuenciaCardiaca", query = "SELECT c FROM Control c WHERE c.cntFrecuenciaCardiaca = :cntFrecuenciaCardiaca")
    , @NamedQuery(name = "Control.findByCntPeso", query = "SELECT c FROM Control c WHERE c.cntPeso = :cntPeso")
    , @NamedQuery(name = "Control.findByCntTalla", query = "SELECT c FROM Control c WHERE c.cntTalla = :cntTalla")
    , @NamedQuery(name = "Control.findByCntTemperatura", query = "SELECT c FROM Control c WHERE c.cntTemperatura = :cntTemperatura")
    , @NamedQuery(name = "Control.findByCntImc", query = "SELECT c FROM Control c WHERE c.cntImc = :cntImc")
    , @NamedQuery(name = "Control.findByCntAnotacionEnfermeria", query = "SELECT c FROM Control c WHERE c.cntAnotacionEnfermeria = :cntAnotacionEnfermeria")
    , @NamedQuery(name = "Control.findByCntRazonConsulta", query = "SELECT c FROM Control c WHERE c.cntRazonConsulta = :cntRazonConsulta")
    , @NamedQuery(name = "Control.findByCntPlanAtencion", query = "SELECT c FROM Control c WHERE c.cntPlanAtencion = :cntPlanAtencion")
    , @NamedQuery(name = "Control.findByCntObservaciones", query = "SELECT c FROM Control c WHERE c.cntObservaciones = :cntObservaciones")
    , @NamedQuery(name = "Control.findByCntExamenFisico", query = "SELECT c FROM Control c WHERE c.cntExamenFisico = :cntExamenFisico")
    , @NamedQuery(name = "Control.findByCntTratamiento", query = "SELECT c FROM Control c WHERE c.cntTratamiento = :cntTratamiento")
    , @NamedQuery(name = "Control.findByCntVersion", query = "SELECT c FROM Control c WHERE c.cntVersion = :cntVersion")})
public class Control implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "CNT_ID")
    private Long cntId;
    @Basic(optional = false)
    @Column(name = "CNT_FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cntFecha;
    @Basic(optional = false)
    @Column(name = "CNT_HORA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cntHora;
    @Basic(optional = false)
    @Column(name = "CNT_PRESION")
    private Long cntPresion;
    @Basic(optional = false)
    @Column(name = "CNT_FRECUENCIA_CARDIACA")
    private Long cntFrecuenciaCardiaca;
    @Basic(optional = false)
    @Column(name = "CNT_PESO")
    private Long cntPeso;
    @Basic(optional = false)
    @Column(name = "CNT_TALLA")
    private Long cntTalla;
    @Basic(optional = false)
    @Column(name = "CNT_TEMPERATURA")
    private Long cntTemperatura;
    @Basic(optional = false)
    @Column(name = "CNT_IMC")
    private Long cntImc;
    @Basic(optional = false)
    @Column(name = "CNT_ANOTACION_ENFERMERIA")
    private String cntAnotacionEnfermeria;
    @Basic(optional = false)
    @Column(name = "CNT_RAZON_CONSULTA")
    private String cntRazonConsulta;
    @Basic(optional = false)
    @Column(name = "CNT_PLAN_ATENCION")
    private String cntPlanAtencion;
    @Basic(optional = false)
    @Column(name = "CNT_OBSERVACIONES")
    private String cntObservaciones;
    @Basic(optional = false)
    @Column(name = "CNT_EXAMEN_FISICO")
    private String cntExamenFisico;
    @Basic(optional = false)
    @Column(name = "CNT_TRATAMIENTO")
    private String cntTratamiento;
    @Basic(optional = false)
    @Column(name = "CNT_VERSION")
    private Long cntVersion;
    @JoinColumn(name = "CNT_EXPEDIENTE", referencedColumnName = "PL_CLN_EXPEDIENTE")
    @ManyToOne
    private Expediente cntExpediente;

    public Control() {
    }

    public Control(Long cntId) {
        this.cntId = cntId;
    }

    public Control(Long cntId, Date cntFecha, Date cntHora, Long cntPresion, Long cntFrecuenciaCardiaca, Long cntPeso, Long cntTalla, Long cntTemperatura, Long cntImc, String cntAnotacionEnfermeria, String cntRazonConsulta, String cntPlanAtencion, String cntObservaciones, String cntExamenFisico, String cntTratamiento, Long cntVersion) {
        this.cntId = cntId;
        this.cntFecha = cntFecha;
        this.cntHora = cntHora;
        this.cntPresion = cntPresion;
        this.cntFrecuenciaCardiaca = cntFrecuenciaCardiaca;
        this.cntPeso = cntPeso;
        this.cntTalla = cntTalla;
        this.cntTemperatura = cntTemperatura;
        this.cntImc = cntImc;
        this.cntAnotacionEnfermeria = cntAnotacionEnfermeria;
        this.cntRazonConsulta = cntRazonConsulta;
        this.cntPlanAtencion = cntPlanAtencion;
        this.cntObservaciones = cntObservaciones;
        this.cntExamenFisico = cntExamenFisico;
        this.cntTratamiento = cntTratamiento;
        this.cntVersion = cntVersion;
    }
    public void actualizarControlPaciente(ControlPacienteDto control){
    
        this.cntVersion = control.getCtrPacVersion();
        this.cntFecha = java.util.Date.from(control.getFecha().atStartOfDay()
      .atZone(ZoneId.systemDefault())
      .toInstant());
 
        Date date1;
        try {
            date1 = new SimpleDateFormat("yyyy/MM/dd").parse(control.getHora());
            this.cntHora = date1;
        } catch (ParseException ex) {
            Logger.getLogger(ControlPaciente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        this.cntPresion = control.getPresion();
        this.cntFrecuenciaCardiaca = control.getFrecuenciaCardiaca();
        this.cntPeso = control.getPeso();
        this.cntTalla = control.getTalla();
        this.cntTemperatura = control.getTemperatura();
        this.cntImc = control.getImc();
        this.cntAnotacionEnfermeria = control.getAnotacionEnfermeria();
        this.cntRazonConsulta = control.getRazonConsulta();
        this.cntPlanAtencion = control.getPlanAtencion();
        this.cntObservaciones = control.getObservaciones();
        this.cntExamenFisico = control.getExamenFisico();
        this.cntTratamiento = control.getTratamiento();
    
    }
    public Long getCntId() {
        return cntId;
    }

    public void setCntId(Long cntId) {
        this.cntId = cntId;
    }

    public Date getCntFecha() {
        return cntFecha;
    }

    public void setCntFecha(Date cntFecha) {
        this.cntFecha = cntFecha;
    }

    public Date getCntHora() {
        return cntHora;
    }

    public void setCntHora(Date cntHora) {
        this.cntHora = cntHora;
    }

    public Long getCntPresion() {
        return cntPresion;
    }

    public void setCntPresion(Long cntPresion) {
        this.cntPresion = cntPresion;
    }

    public Long getCntFrecuenciaCardiaca() {
        return cntFrecuenciaCardiaca;
    }

    public void setCntFrecuenciaCardiaca(Long cntFrecuenciaCardiaca) {
        this.cntFrecuenciaCardiaca = cntFrecuenciaCardiaca;
    }

    public Long getCntPeso() {
        return cntPeso;
    }

    public void setCntPeso(Long cntPeso) {
        this.cntPeso = cntPeso;
    }

    public Long getCntTalla() {
        return cntTalla;
    }

    public void setCntTalla(Long cntTalla) {
        this.cntTalla = cntTalla;
    }

    public Long getCntTemperatura() {
        return cntTemperatura;
    }

    public void setCntTemperatura(Long cntTemperatura) {
        this.cntTemperatura = cntTemperatura;
    }

    public Long getCntImc() {
        return cntImc;
    }

    public void setCntImc(Long cntImc) {
        this.cntImc = cntImc;
    }

    public String getCntAnotacionEnfermeria() {
        return cntAnotacionEnfermeria;
    }

    public void setCntAnotacionEnfermeria(String cntAnotacionEnfermeria) {
        this.cntAnotacionEnfermeria = cntAnotacionEnfermeria;
    }

    public String getCntRazonConsulta() {
        return cntRazonConsulta;
    }

    public void setCntRazonConsulta(String cntRazonConsulta) {
        this.cntRazonConsulta = cntRazonConsulta;
    }

    public String getCntPlanAtencion() {
        return cntPlanAtencion;
    }

    public void setCntPlanAtencion(String cntPlanAtencion) {
        this.cntPlanAtencion = cntPlanAtencion;
    }

    public String getCntObservaciones() {
        return cntObservaciones;
    }

    public void setCntObservaciones(String cntObservaciones) {
        this.cntObservaciones = cntObservaciones;
    }

    public String getCntExamenFisico() {
        return cntExamenFisico;
    }

    public void setCntExamenFisico(String cntExamenFisico) {
        this.cntExamenFisico = cntExamenFisico;
    }

    public String getCntTratamiento() {
        return cntTratamiento;
    }

    public void setCntTratamiento(String cntTratamiento) {
        this.cntTratamiento = cntTratamiento;
    }

    public Long getCntVersion() {
        return cntVersion;
    }

    public void setCntVersion(Long cntVersion) {
        this.cntVersion = cntVersion;
    }

    public Expediente getCntExpediente() {
        return cntExpediente;
    }

    public void setCntExpediente(Expediente cntExpediente) {
        this.cntExpediente = cntExpediente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cntId != null ? cntId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Control)) {
            return false;
        }
        Control other = (Control) object;
        if ((this.cntId == null && other.cntId != null) || (this.cntId != null && !this.cntId.equals(other.cntId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Control[ cntId=" + cntId + " ]";
    }
    
}
