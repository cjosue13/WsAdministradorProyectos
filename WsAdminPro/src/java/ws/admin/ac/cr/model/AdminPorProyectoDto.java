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
@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
public class AdminPorProyectoDto {
    private Long axpId;
    private String axpTipo;
    private Long axpVersion;
    private AdministradorDto axpAdministrador;
    private ProyectoDto axpProyecto;
    
    public AdminPorProyectoDto() {
    }

    public AdminPorProyectoDto(Long axpId, String axpTipo, Long axpVersion, AdministradorDto axpAdministrador, ProyectoDto axpProyecto) {
        this.axpId = axpId;
        this.axpTipo = axpTipo;
        this.axpVersion = axpVersion;
        this.axpAdministrador = axpAdministrador;
        this.axpProyecto = axpProyecto;
    }
    
    //Rellenar datos
    public AdminPorProyectoDto(AdminPorPro adminPro) {
        this.axpId = adminPro.getAxpId();
        this.axpAdministrador = new AdministradorDto(adminPro.getAxpAdministrador());
        this.axpProyecto = new ProyectoDto(adminPro.getAxpProyecto());
        this.axpTipo = adminPro.getAxpTipo();
        this.axpVersion = adminPro.getAxpVersion();
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

    public AdministradorDto getAxpAdministrador() {
        return axpAdministrador;
    }

    public void setAxpAdministrador(AdministradorDto axpAdministrador) {
        this.axpAdministrador = axpAdministrador;
    }

    public ProyectoDto getAxpProyecto() {
        return axpProyecto;
    }

    public void setAxpProyecto(ProyectoDto axpProyecto) {
        this.axpProyecto = axpProyecto;
    }
    
    
}
