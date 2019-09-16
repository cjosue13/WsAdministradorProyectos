/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.admin.ac.cr.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Carlos Olivares
 */
@XmlRootElement(name = "AdminPorProyectoDto")
@XmlAccessorType(XmlAccessType.FIELD)
public class AdminPorProyectoDto {
    private Long axpId;
    private String axpTipo;
    private Long axpVersion;
    private AdministradorDto adnId;
    private ProyectoDto proId;
    
    public AdminPorProyectoDto() {
    }
    //Rellenar datos
    public AdminPorProyectoDto(AdminiPorProyecto adminPro) {
    }
    public Long getAxpId() {
        return axpId;
    }

    public void setAxpId(Long axpId) {
        this.axpId = axpId;
    }

    public String getAxpTipo() {
        return axpTipo;
    }

    public void setAxpTipo(String axpTipo) {
        this.axpTipo = axpTipo;
    }

    public Long getAxpVersion() {
        return axpVersion;
    }

    public void setAxpVersion(Long axpVersion) {
        this.axpVersion = axpVersion;
    }

    public AdministradorDto getAdnId() {
        return adnId;
    }

    public void setAdnId(AdministradorDto adnId) {
        this.adnId = adnId;
    }

    public ProyectoDto getProId() {
        return proId;
    }

    public void setProId(ProyectoDto proId) {
        this.proId = proId;
    }
    
}
