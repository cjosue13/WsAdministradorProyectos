/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.admin.ac.cr.model;

import java.time.LocalDate;
import java.time.ZoneId;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Carlos Olivares
 */
@XmlRootElement(name = "ActividadDto")
@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
public class ActividadDto {

    private Long actId;
    private String actDescripcion;
    private String actEncargado;
    private String actFechainireal;
    private String actFechafinreal;
    private String actFechainicio;
    private String actFechafinal;
    private String actEstado;
    private Integer actNumorden;
    private Long actVersion;
    private ProyectoDto actProyecto;

    public ActividadDto() {
    }

    
    public ActividadDto(Actividad actividad) {
        this.actDescripcion = actividad.getActDescripcion();
        this.actEncargado = actividad.getActEncargado();
        this.actEstado = actividad.getActEstado();
        this.actFechafinreal = actividad.getActFechafinreal().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().toString();
        this.actFechainireal = actividad.getActFechainireal().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().toString();
        this.actFechainicio = actividad.getActFechainicio().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().toString();
        this.actFechafinal = actividad.getActFechafinal().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().toString();
        this.actId = actividad.getActId();
        this.actNumorden = actividad.getActNumorden();
        this.actProyecto = new ProyectoDto(actividad.getActProyecto());
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

    public String getActFechainireal() {
        return actFechainireal;
    }

    public void setActFechainireal(String actFechainireal) {
        this.actFechainireal = actFechainireal;
    }

    public String getActFechafinreal() {
        return actFechafinreal;
    }

    public void setActFechafinreal(String actFechafinreal) {
        this.actFechafinreal = actFechafinreal;
    }

    public String getActEstado() {
        return actEstado;
    }

    public void setActEstado(String actEstado) {
        this.actEstado = actEstado;
    }

    public Integer getActNumorden() {
        return actNumorden;
    }

    public void setActNumorden(Integer actNumorden) {
        this.actNumorden = actNumorden;
    }

    public Long getActVersion() {
        return actVersion;
    }

    public void setActVersion(Long actVersion) {
        this.actVersion = actVersion;
    }

    public ProyectoDto getActProyecto() {
        return actProyecto;
    }

    public void setActProyecto(ProyectoDto actProyecto) {
        this.actProyecto = actProyecto;
    }

    public String getActFechainicio() {
        return actFechainicio;
    }

    public void setActFechainicio(String actFechainicio) {
        this.actFechainicio = actFechainicio;
    }

    public String getActFechafinal() {
        return actFechafinal;
    }

    public void setActFechafinal(String actFechafinal) {
        this.actFechafinal = actFechafinal;
    }
   
    
}
