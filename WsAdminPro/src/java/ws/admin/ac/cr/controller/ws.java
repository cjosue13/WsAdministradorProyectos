/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.admin.ac.cr.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ws.rs.core.GenericEntity;
import ws.admin.ac.cr.model.AdministradorDto;
import ws.admin.ac.cr.service.ActividadService;
import ws.admin.ac.cr.service.AdminiPorProService;
import ws.admin.ac.cr.service.AdministradorService;
import ws.admin.ac.cr.service.ProyectoService;
import ws.admin.ac.cr.service.SeguimientoService;
import ws.admin.ac.cr.util.CodigoRespuesta;
import ws.admin.ac.cr.util.Respuesta;

/**
 *
 * @author kelor
 */
@WebService(serviceName = "ws")
public class ws {

    @EJB
    ActividadService actividadService;
    @EJB
    AdminiPorProService adminiPorProService;
    @EJB
    AdministradorService administradorService;
    @EJB
    ProyectoService proyectoService;
    @EJB
    SeguimientoService seguimientoService;

    @WebMethod(operationName = "getAdministrador")
    public String getAdministrador(@WebParam(name = "Administrador") String Administrador, @WebParam(name = "contrasenna") String contrasenna) {
        //TODO write your implementation code here:
        return "Administrador: " + Administrador + " Contraseña: " + contrasenna;
    }

    @WebMethod(operationName = "getUsuario")
    public String getUsuario(@WebParam(name = "usuario") String usuario, @WebParam(name = "clave") String clave) {
        try {
            Respuesta respuesta = administradorService.validarAdministrador(usuario, clave);
            if (!respuesta.getEstado()) {
                return String.valueOf(respuesta.getCodigoRespuesta().getValue());
            }
            //return String.ok((AdministradorDto) respuesta.getResultado("Administrador")).build();
            return "Usuario guardado exitosamente";
        } catch (Exception ex) {
            Logger.getLogger(ws.class.getName()).log(Level.SEVERE, null, ex);
            return String.valueOf(CodigoRespuesta.ERROR_INTERNO.getValue());
        }
    }
/*
    @WebMethod(operationName = "getAdministradores")
    public String getAdministradors() {
        try {
            Respuesta respuesta = administradorService.getAdministradors();
            if (!respuesta.getEstado()) {
                return String.status(respuesta.getCodigoRespuesta().getValue()).entity(respuesta.getMensaje()).build();
            }
            ArrayList<AdministradorDto> AdministradorsDto = (ArrayList<AdministradorDto>) respuesta.getResultado("Administradors");

            return String.ok(new GenericEntity<List<AdministradorDto>>(AdministradorsDto) {
            }).build();

        } catch (Exception ex) {
            Logger.getLogger(ws.class.getName()).log(Level.SEVERE, null, ex);
            return String.status(CodigoRespuesta.ERROR_INTERNO.getValue()).entity("Error obteniendo el Administrador").build();
        }
    }

    @WebMethod(operationName = "guardarAdministrador")
    public String guardarAdministrador(@WebParam(name = "Administrador") AdministradorDto Administrador) {
        try {
            Respuesta respuesta = administradorService.guardarAdministrador(Administrador);
            if (!respuesta.getEstado()) {
                return String.status(respuesta.getCodigoRespuesta().getValue()).entity(respuesta.getMensaje()).build();
            }
            return String.ok((AdministradorDto) respuesta.getResultado("Administrador")).build();
        } catch (Exception ex) {
            Logger.getLogger(ws.class.getName()).log(Level.SEVERE, null, ex);
            return String.status(CodigoRespuesta.ERROR_INTERNO.getValue()).entity("Error guardando el Administrador").build();
        }
    }

    @WebMethod(operationName = "eliminarAdministrador")
    public String EliminarAdministrador(@WebParam(name = "ID") Long ID) {
        try {
            Respuesta respuesta = administradorService.eliminarAdministrador(ID);
            if (!respuesta.getEstado()) {
                return String.status(respuesta.getCodigoRespuesta().getValue()).entity(respuesta.getMensaje()).build();
            }
            return String.ok((AdministradorDto) respuesta.getResultado("Administrador")).build();
        } catch (Exception ex) {
            Logger.getLogger(ws.class.getName()).log(Level.SEVERE, null, ex);
            return String.status(CodigoRespuesta.ERROR_INTERNO.getValue()).entity("Error Eliminar el Administrador").build();
        }
    }
    /**
     * This is a sample web service operation
     */

}
