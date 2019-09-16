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
@XmlRootElement(name = "SeguimientoDto")
@XmlAccessorType(XmlAccessType.FIELD)
public class SeguimientoDto {
    private Long segId;
    private LocalDate segFecha;
    private Long segAvance;
    private Long segVersion;
    private ProyectoDto proId;

    public SeguimientoDto() {
    }
    //Rellenar datos
    public SeguimientoDto(Seguimiento seguimiento) {
        
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

    public Long getSegAvance() {
        return segAvance;
    }

    public void setSegAvance(Long segAvance) {
        this.segAvance = segAvance;
    }

    public Long getSegVersion() {
        return segVersion;
    }

    public void setSegVersion(Long segVersion) {
        this.segVersion = segVersion;
    } 

    public ProyectoDto getProId() {
        return proId;
    }

    public void setProId(ProyectoDto proId) {
        this.proId = proId;
    }
    
    
}
