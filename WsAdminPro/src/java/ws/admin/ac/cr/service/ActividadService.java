/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.admin.ac.cr.service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import ws.admin.ac.cr.model.Actividad;
import ws.admin.ac.cr.model.ActividadDto;
import ws.admin.ac.cr.model.Proyecto;
import ws.admin.ac.cr.util.CodigoRespuesta;
import ws.admin.ac.cr.util.Respuesta;

/**
 *
 * @author Carlos Olivares
 */
@Stateless
@LocalBean
public class ActividadService {

    private static final Logger LOG = Logger.getLogger(ActividadService.class.getName());//imprime el error en payara
    @PersistenceContext(unitName = "WsAdminProPU")
    private EntityManager em;

    public Respuesta getActividades() {
        try {
            Query qryActividad = em.createNamedQuery("Actividad.findAll", Actividad.class);
            List<Actividad> Actividad = qryActividad.getResultList();
            List<ActividadDto> actividades = new ArrayList<>();
            for (Actividad Actividades : Actividad) {
                actividades.add(new ActividadDto(Actividades));
            }

            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", "Actividad", actividades);

        } catch (NoResultException ex) {
            return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "No existen Actividads con los criterios ingresados.", "getActividads NoResultException");
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al consultar el Actividad.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al consultar el Actividad.", "getActividad " + ex.getMessage());
        }
    }

    public Respuesta guardarActividad(ActividadDto ActividadDto) {
        try {
            Actividad Actividad;
            Proyecto proyecto = em.find(Proyecto.class, ActividadDto.getActProyecto().getProId());
            if (proyecto != null) {
                if (ActividadDto.getActId() != null && ActividadDto.getActId() > 0) {
                    Actividad = em.find(Actividad.class, ActividadDto.getActId());

                    if (Actividad == null) {
                        return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "No se encrontró la Actividad a modificar.", "guardarActividad NoResultException");
                    }

                    Actividad.actualizar(ActividadDto);
                    Actividad.setActProyecto(proyecto);
                    Actividad = em.merge(Actividad);

                } else {
                    Actividad = new Actividad(ActividadDto);
                    Actividad.setActProyecto(proyecto);
                    em.persist(Actividad);
                }

                em.flush();

                return new Respuesta(true, CodigoRespuesta.CORRECTO, "Actividad guardada exitosamente", "", "Actividad", new ActividadDto(Actividad));
            } else {
                return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "No se encrontró la Actividad a modificar.", "guardarActividad NoResultException");
            }

        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al guardar la Actividad.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error la guardar el Actividad.", "guardarActividad " + ex.getMessage());
        }
    }

    public Respuesta eliminarActividad(Long id) {
        try {
            //Empleado empleado;
            Actividad Actividad;
            if (id != null && id > 0) {
                Actividad = em.find(Actividad.class, id);
                if (Actividad == null) {
                    return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "No se encontró el Actividad a eliminar.", "EliminarActividad NoResultException");
                }
                em.remove(Actividad);
            } else {
                return new Respuesta(false, CodigoRespuesta.ERROR_CLIENTE, "Debe cargar el Actividad a eliminar.", "EliminarActividad NoResultException");
            }
            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "");
        } catch (Exception ex) {
            if (ex.getCause() != null && ex.getCause().getCause().getClass() == SQLIntegrityConstraintViolationException.class) {
                return new Respuesta(false, CodigoRespuesta.ERROR_PERMISOS, "No se puede eliminar el Actividad porque tiene relaciones con otros registros.", "EliminarActividad " + ex.getMessage());
            }
            Logger.getLogger(ActividadService.class.getName()).log(Level.SEVERE, "Ocurrio un error al guardar el Actividad.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al eliminar el Actividad.", "EliminarActividad " + ex.getMessage());
        }
    }
}
