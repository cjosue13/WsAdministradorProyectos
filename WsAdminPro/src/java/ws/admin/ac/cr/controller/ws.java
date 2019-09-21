/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.admin.ac.cr.controller;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import ws.admin.ac.cr.model.ActividadDto;
import ws.admin.ac.cr.model.AdminPorProyectoDto;
import ws.admin.ac.cr.model.AdministradorDto;
import ws.admin.ac.cr.model.ProyectoDto;
import ws.admin.ac.cr.model.SeguimientoDto;
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

    @WebMethod(operationName = "getUsuario")
    public Respuesta getUsuario(@WebParam(name = "usuario") String usuario, @WebParam(name = "clave") String clave) {
        try {
            // Consulto el service del Administrador y devuelvo la respuesta al cliente
            Respuesta respuesta = administradorService.validarAdministrador(usuario, clave);
            return respuesta;
        } catch (Exception ex) {
            Logger.getLogger(ws.class.getName()).log(Level.SEVERE, null, ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Error al obtener el Usuario", "getUsuario:"+ex.getMessage());
        }
    }

    @WebMethod(operationName = "guardarAdministrador")
    public Respuesta guardarAdministrador(@WebParam(name = "Administrador") AdministradorDto Administrador) {
        try {
            Respuesta respuesta = administradorService.guardarAdministrador(Administrador);
            return respuesta;
        } catch (Exception ex) {
            Logger.getLogger(ws.class.getName()).log(Level.SEVERE, null, ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Error guardando usuario", ex.getMessage());
        }
    }

    @WebMethod(operationName = "eliminarAdministrador")
    public Respuesta EliminarAdministrador(@WebParam(name = "ID") Long ID) {
        try {
            Respuesta respuesta = administradorService.eliminarAdministrador(ID);
            return respuesta;
        } catch (Exception ex) {
            Logger.getLogger(ws.class.getName()).log(Level.SEVERE, null, ex);
            return new Respuesta(false,CodigoRespuesta.ERROR_CLIENTE, "Error al eliminar el Administrador", ex.getMessage());
        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "guardarProyecto")
    public Respuesta guardarProyecto(@WebParam(name = "proyecto") ProyectoDto proyecto) {
        //TODO write your implementation code here:
        try {
            Respuesta respuesta = proyectoService.guardarProyecto(proyecto);
            return respuesta;
        } catch (Exception ex) {
            Logger.getLogger(ws.class.getName()).log(Level.SEVERE, null, ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Error guardando usuario", ex.getMessage());
        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "eliminarProyecto")
    public Respuesta eliminarProyecto(@WebParam(name = "ID") Long ID) {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "guardarAdminPorProyecto")
    public Respuesta guardarAdminPorProyecto(@WebParam(name = "adminPorPro") AdminPorProyectoDto adminPorPro) {
        //TODO write your implementation code here:
        try {
            Respuesta respuesta = adminiPorProService.guardarAdminPorPro(adminPorPro);
            return respuesta;
        } catch (Exception ex) {
            Logger.getLogger(ws.class.getName()).log(Level.SEVERE, null, ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Error guardando usuario", ex.getMessage());
        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "eliminarAdminPorProyecto")
    public Respuesta eliminarAdminPorProyecto(@WebParam(name = "ID") Long ID) {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "guardarActividad")
    public Respuesta guardarActividad(@WebParam(name = "actividad") ActividadDto actividad) {
        //TODO write your implementation code here:
        try {
            Respuesta respuesta = actividadService.guardarActividad(actividad);
            return respuesta;
        } catch (Exception ex) {
            Logger.getLogger(ws.class.getName()).log(Level.SEVERE, null, ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Error guardando usuario", ex.getMessage());
        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "elminarActividad")
    public Respuesta elminarActividad(@WebParam(name = "ID") Long ID) {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "guardarSeguimiento")
    public Respuesta guardarSeguimiento(@WebParam(name = "seguimiento") SeguimientoDto seguimiento) {
        //TODO write your implementation code here:
        try {
            Respuesta respuesta = seguimientoService.guardarSeguimiento(seguimiento);
            return respuesta;
        } catch (Exception ex) {
            Logger.getLogger(ws.class.getName()).log(Level.SEVERE, null, ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Error guardando usuario", ex.getMessage());
        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "eliminarSeguimiento")
    public Respuesta eliminarSeguimiento(@WebParam(name = "ID") Long ID) {
        //TODO write your implementation code here:
        return null;
    }
    
}
