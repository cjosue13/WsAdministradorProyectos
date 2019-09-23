/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.admin.ac.cr.model;

import java.time.ZoneId;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Carlos Olivares
 */
@XmlRootElement(name = "ProyectoDto")
@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
public class ProyectoDto {
    private Long proId;
    private String proNombre;
    private String proPatrocinador;
    private String proLiderusuario;
    private String proLidertecnico;
    private String proCorreopatrocinador;
    private String proCorreousuario;
    private String proCorreotecnico;
    private String proFechainireal;
    private String proFechafinreal;
    private String proFechainicio;
    private String proFechafinal;
    private String proEstado;
    private Long proVersion;

    public ProyectoDto() {
    }

    
    public ProyectoDto(Proyecto proyecto) {
        this.proCorreopatrocinador = proyecto.getProCorreopatrocinador();
        this.proCorreotecnico = proyecto.getProCorreotecnico();
        this.proCorreousuario = proyecto.getProCorreousuario();
        this.proEstado = proyecto.getProEstado();
        this.proFechafinreal = proyecto.getProFechafinreal().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().toString();
        this.proFechainireal = proyecto.getProFechainireal().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().toString();
        this.proFechainicio = proyecto.getProFechainicio().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().toString();
        this.proFechafinal = proyecto.getProFechafinal().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().toString();
        this.proId = proyecto.getProId();
        this.proLidertecnico = proyecto.getProLidertecnico();
        this.proLiderusuario = proyecto.getProLiderusuario();
        this.proNombre = proyecto.getProNombre();
        this.proPatrocinador = proyecto.getProPatrocinador();
        this.proVersion = proyecto.getProVersion();
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

    public String getProFechainireal() {
        return proFechainireal;
    }

    public void setProFechainireal(String proFechainireal) {
        this.proFechainireal = proFechainireal;
    }

    public String getProFechafinreal() {
        return proFechafinreal;
    }

    public void setProFechafinreal(String proFechafinreal) {
        this.proFechafinreal = proFechafinreal;
    }

    public String getProEstado() {
        return proEstado;
    }

    public void setProEstado(String proEstado) {
        this.proEstado = proEstado;
    }

    public String getProFechainicio() {
        return proFechainicio;
    }

    public void setProFechainicio(String proFechainicio) {
        this.proFechainicio = proFechainicio;
    }

    public String getProFechafinal() {
        return proFechafinal;
    }

    public void setProFechafinal(String proFechafinal) {
        this.proFechafinal = proFechafinal;
    }
    
    public Long getProVersion() {
        return proVersion;
    }

    public void setProVersion(Long proVersion) {
        this.proVersion = proVersion;
    }

    
}
