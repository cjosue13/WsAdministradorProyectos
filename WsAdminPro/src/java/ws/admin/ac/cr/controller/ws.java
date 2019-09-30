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
import ws.admin.ac.cr.model.AdministradorDto;
import ws.admin.ac.cr.model.ProyectoDto;
import ws.admin.ac.cr.model.SeguimientoDto;
import ws.admin.ac.cr.service.ActividadService;
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
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Error al obtener el Usuario", "getUsuario:" + ex.getMessage());
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
            return new Respuesta(false, CodigoRespuesta.ERROR_CLIENTE, "Error al eliminar el Administrador", ex.getMessage());
        }
    }

    /**
     * Web service operation
     *
     * @param ID
     * @return
     */
    @WebMethod(operationName = "getAdministrador")
    public Respuesta getAdministrador(@WebParam(name = "ID") Long ID) {
        try {
            Respuesta respuesta = administradorService.getAdministrador(ID);
            return respuesta;
        } catch (Exception ex) {
            Logger.getLogger(ws.class.getName()).log(Level.SEVERE, null, ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Error guardando usuario", ex.getMessage());
        }
    }

    /**
     * Web service operation
     *
     * @param proyecto
     * @return
     */
    @WebMethod(operationName = "guardarProyecto")
    public Respuesta guardarProyecto(@WebParam(name = "proyecto") ProyectoDto proyecto) {
        //TODO write your implementation code here:
        try {
            Respuesta respuesta = proyectoService.guardarProyecto(proyecto);
            return respuesta;
        } catch (Exception ex) {
            Logger.getLogger(ws.class.getName()).log(Level.SEVERE, null, ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Error guardando Proyecto", ex.getMessage());
        }
    }

    /**
     * Web service operation
     *
     * @param ID
     * @return
     */
    @WebMethod(operationName = "eliminarProyecto")
    public Respuesta eliminarProyecto(@WebParam(name = "ID") Long ID) {
        try {
            Respuesta respuesta = proyectoService.eliminarProyecto(ID);
            return respuesta;
        } catch (Exception ex) {
            Logger.getLogger(ws.class.getName()).log(Level.SEVERE, null, ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_CLIENTE, "Error al eliminar el proyecto.", ex.getMessage());
        }
    }

    /**
     * Web service operation
     *
     * @param adminPorPro
     * @return
     */
    /**
     * Web service operation
     *
     * @param actividad
     * @return
     */
    @WebMethod(operationName = "guardarActividad")
    public Respuesta guardarActividad(@WebParam(name = "actividad") ActividadDto actividad) {
        //TODO write your implementation code here:
        try {
            Respuesta respuesta = actividadService.guardarActividad(actividad);
            return respuesta;
        } catch (Exception ex) {
            Logger.getLogger(ws.class.getName()).log(Level.SEVERE, null, ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Error guardando la Actividad", ex.getMessage());

        }
    }

    /**
     * Web service operation
     *
     * @param ID
     * @return
     */
    /* @WebMethod(operationName = "elminarActividad")
    public Respuesta elminarActividad(@WebParam(name = "ID") Long ID) {
        try {
            Respuesta respuesta = actividadService.eliminarActividad(ID);
            return respuesta;
        } catch (Exception ex) {
            Logger.getLogger(ws.class.getName()).log(Level.SEVERE, null, ex);
            return new Respuesta(false,CodigoRespuesta.ERROR_CLIENTE, "Error al eliminar la Actividad", ex.getMessage());
        }
    }*/
    /**
     * Web service operation
     *
     * @param seguimiento
     * @return
     */
    @WebMethod(operationName = "guardarSeguimiento")
    public Respuesta guardarSeguimiento(@WebParam(name = "seguimiento") SeguimientoDto seguimiento) {
        //TODO write your implementation code here:
        try {
            Respuesta respuesta = seguimientoService.guardarSeguimiento(seguimiento);
            return respuesta;
        } catch (Exception ex) {
            Logger.getLogger(ws.class.getName()).log(Level.SEVERE, null, ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Error guardando el Seguimiento", ex.getMessage());
        }
    }

    /**
     * Web service operation
     *
     * @param ID
     * @return
     */
    @WebMethod(operationName = "eliminarSeguimiento")
    public Respuesta eliminarSeguimiento(@WebParam(name = "ID") Long ID) {
        try {
            Respuesta respuesta = seguimientoService.eliminarSeguimiento(ID);
            return respuesta;
        } catch (Exception ex) {
            Logger.getLogger(ws.class.getName()).log(Level.SEVERE, null, ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_CLIENTE, "Error al eliminar el seguimiento", ex.getMessage());
        }
    }

    /**
     * Web service operation
     *
     * @param ID
     * @return
     */
    @WebMethod(operationName = "eliminarActividad")
    public Respuesta eliminarActividad(@WebParam(name = "ID") Long ID) {
        //TODO write your implementation code here:
        try {
            Respuesta respuesta = actividadService.eliminarActividad(ID);
            return respuesta;
        } catch (Exception ex) {
            Logger.getLogger(ws.class.getName()).log(Level.SEVERE, null, ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_CLIENTE, "Error al eliminar la Actividad", ex.getMessage());
        }
    }

    /**
     * Web service operation
     * @param ID
     * @return 
     */
    @WebMethod(operationName = "getProyecto")
    public Respuesta getProyecto(@WebParam(name = "ID") Long ID) {
        try {
            Respuesta respuesta = proyectoService.getAdministrador(ID);
            return respuesta;
        } catch (Exception ex) {
            Logger.getLogger(ws.class.getName()).log(Level.SEVERE, null, ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Error guardando usuario", ex.getMessage());
        }
    }
    
    @WebMethod(operationName = "getActividad")
    public Respuesta getActividad(@WebParam(name = "ID") Long ID) {
        try {
            return actividadService.getActividad(ID);
        } catch (Exception e) {
            return new Respuesta(Boolean.FALSE, CodigoRespuesta.ERROR_NOENCONTRADO, "Error", "Error");
        }
    }
    
}
