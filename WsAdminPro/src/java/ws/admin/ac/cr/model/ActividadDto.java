/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.admin.ac.cr.model;

import java.time.LocalDate;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Carlos Olivares
 */
@XmlRootElement(name = "ActividadDto")
@XmlAccessorType(XmlAccessType.FIELD)
public class ActividadDto {

    private Long actId;
    private String actDescripcion;
    private String actEncargado;
    private LocalDate actFechainicio;
    private LocalDate actFechafinal;
    private String actEstado;
    private Long actVersion;
    private ProyectoDto proId;

    public ActividadDto() {
    }
    //Rellenar datos
    public ActividadDto(Actividad actividad) {
        
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

    public LocalDate getActFechainicio() {
        return actFechainicio;
    }

    public void setActFechainicio(LocalDate actFechainicio) {
        this.actFechainicio = actFechainicio;
    }

    public LocalDate getActFechafinal() {
        return actFechafinal;
    }

    public void setActFechafinal(LocalDate actFechafinal) {
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

    public ProyectoDto getProId() {
        return proId;
    }

    public void setProId(ProyectoDto proId) {
        this.proId = proId;
    }
    
}
