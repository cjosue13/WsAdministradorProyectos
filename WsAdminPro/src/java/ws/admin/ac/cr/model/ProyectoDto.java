/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.admin.ac.cr.model;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
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
    private AdministradorDto proAdmin;
    private Long proVersion;
    
    private List<ActividadDto> actividades;
    private List<SeguimientoDto> seguimientos;

    public ProyectoDto() {
        actividades = new ArrayList<>();
        seguimientos = new ArrayList<>();
    }

    public ProyectoDto(Proyecto proyecto) {
        this();
        this.proCorreopatrocinador = proyecto.getProCorreopatrocinador();
        this.proCorreotecnico = proyecto.getProCorreotecnico();
        this.proCorreousuario = proyecto.getProCorreousuario();
        this.proEstado = proyecto.getProEstado();
        this.proFechafinreal = proyecto.getProFechafinreal() == null ? null : proyecto.getProFechafinreal().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().toString();
        this.proFechainireal = proyecto.getProFechainireal() == null ? null : proyecto.getProFechainireal().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().toString();
        this.proFechainicio = proyecto.getProFechainicio() == null ? null : proyecto.getProFechainicio().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().toString();
        this.proFechafinal = proyecto.getProFechafinal() == null ? null : proyecto.getProFechafinal().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().toString();
        this.proId = proyecto.getProId();
        this.proLidertecnico = proyecto.getProLidertecnico();
        this.proLiderusuario = proyecto.getProLiderusuario();
        this.proNombre = proyecto.getProNombre();
        this.proPatrocinador = proyecto.getProPatrocinador();
        //this.proAdmin = new AdministradorDto(proyecto.getProAdministrador());
        this.proVersion = proyecto.getProVersion();
        setActividadesFromDB(proyecto.getActividadList());
        setSeguimientosFromDB(proyecto.getSeguimientoList());
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

    public AdministradorDto getProAdmin() {
        return proAdmin;
    }

    public void setProAdmin(AdministradorDto proAdmin) {
        this.proAdmin = proAdmin;
    }

    public List<ActividadDto> getActividades() {
        return actividades;
    }
    
    public List<Actividad> getActividadesToDB(){
        List<Actividad> acts = new ArrayList<>();
        for (ActividadDto a : this.actividades){
            Actividad act = new Actividad(a);
            acts.add(act);
        }
        return acts;
    }

    public void setActividades(List<ActividadDto> actividades) {
        this.actividades = actividades;
    }
    
    public void setActividadesFromDB(List<Actividad> actividades){
        if(actividades != null){
            for (Actividad a : actividades){
                ActividadDto act = new ActividadDto(a);
                //act.setActProyecto(this);
                this.actividades.add(act);
            }
        }
    }

    public List<SeguimientoDto> getSeguimientos() {
        return seguimientos;
    }
    
    public List<Seguimiento> getSeguimientoToDB(){
        List<Seguimiento> segs = new ArrayList<>();
        for (SeguimientoDto s : this.seguimientos){
            Seguimiento se = new Seguimiento(s);
            segs.add(se);
        }
        return segs;
    }

    public void setSeguimientos(List<SeguimientoDto> seguimientos) {
        this.seguimientos = seguimientos;
    }
    
    public void setSeguimientosFromDB(List<Seguimiento> seguimientos){
        if(seguimientos != null){
            for (Seguimiento s : seguimientos){
                SeguimientoDto seg = new SeguimientoDto(s);
                //seg.setSegProyecto(this);
                this.seguimientos.add(seg);
            }
        }
    }
    
}
