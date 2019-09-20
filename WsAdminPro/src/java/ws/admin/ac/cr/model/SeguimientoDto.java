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
@XmlRootElement(name = "SeguimientoDto")
@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
public class SeguimientoDto {
    private Long segId;
    private LocalDate segFecha;
    private Integer segAvance;
    private Long segVersion;
    private ProyectoDto segProyecto;

    public SeguimientoDto() {
    }
    //Rellenar datos
    public SeguimientoDto(Seguimiento seguimiento) {
        this.segAvance = seguimiento.getSegAvance();
        this.segId = seguimiento.getSegId();
        this.segProyecto = new ProyectoDto(seguimiento.getSegProyecto());
        this.segFecha = seguimiento.getSegFecha().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        this.segVersion = seguimiento.getSegVersion();
        
    }

    public Long getSegId() {
        return segId;
    }

    public void setSegId(Long segId) {
        this.segId = segId;
    }

    public LocalDate getSegFecha() {
        return segFecha;
    }

    public void setSegFecha(LocalDate segFecha) {
        this.segFecha = segFecha;
    }

    public Integer getSegAvance() {
        return segAvance;
    }

    public void setSegAvance(Integer segAvance) {
        this.segAvance = segAvance;
    }

    public Long getSegVersion() {
        return segVersion;
    }

    public void setSegVersion(Long segVersion) {
        this.segVersion = segVersion;
    }

    public ProyectoDto getSegProyecto() {
        return segProyecto;
    }

    public void setSegProyecto(ProyectoDto segProyecto) {
        this.segProyecto = segProyecto;
    }
    
}
