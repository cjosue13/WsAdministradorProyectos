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
import ws.admin.ac.cr.model.AdminPorPro;
import ws.admin.ac.cr.model.AdminPorProyectoDto;
import ws.admin.ac.cr.util.CodigoRespuesta;
import ws.admin.ac.cr.util.Respuesta;

/**
 *
 * @author Carlos Olivares
 */
@Stateless
@LocalBean
public class AdminiPorProService {

    private static final Logger LOG = Logger.getLogger(AdminiPorProService.class.getName());//imprime el error en payara
    @PersistenceContext(unitName = "WsAdminProPU")
    private EntityManager em;


    public Respuesta getAdminPorPros() {
        try {
            Query qryAdminPorPro = em.createNamedQuery("AdminPorPro.findAll", AdminPorPro.class);
            List<AdminPorPro> AdminPorPro = qryAdminPorPro.getResultList();
            List<AdminPorProyectoDto> lista = new ArrayList<>();
            for (AdminPorPro AdminPorProes : AdminPorPro) {
                lista.add(new AdminPorProyectoDto(AdminPorProes));
            }

            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", "AdminPorPros", lista);

        } catch (NoResultException ex) {
            return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "No existen AdminPorPros con los criterios ingresados.", "getAdminPorPros NoResultException");
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al consultar el AdminPorPro.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al consultar el AdminPorPro.", "getAdminPorPro " + ex.getMessage());
        }
    }

    public Respuesta guardarAdminPorPro(AdminPorProyectoDto AdminPorProDto) {
        try {
            AdminPorPro AdminPorPro;
            if (AdminPorProDto.getAxpId() != null && AdminPorProDto.getAxpId() > 0) {
                AdminPorPro = em.find(AdminPorPro.class, AdminPorProDto.getAxpId());

                if (AdminPorPro == null) {
                    return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "No se encrontró el AdminPorPro a modificar.", "guardarAdminPorPro NoResultException");
                }

                AdminPorPro.actualizar(AdminPorProDto);
                AdminPorPro = em.merge(AdminPorPro);

            } else {
                AdminPorPro = new AdminPorPro(AdminPorProDto);
                em.persist(AdminPorPro);
            }

            em.flush();

            return new Respuesta(true, CodigoRespuesta.CORRECTO, "AdminPorPro guardado exitosamente", "", "AdminPorPro", new AdminPorProyectoDto(AdminPorPro));
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al guardar el AdminPorPro.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al guardar el AdminPorPro.", "guardarAdminPorPro " + ex.getMessage());
        }
    }

    public Respuesta eliminarAdminPorPro(Long id) {
        try {
            //Empleado empleado;
            AdminPorPro AdminPorPro;
            if (id != null && id > 0) {
                AdminPorPro = em.find(AdminPorPro.class, id);
                if (AdminPorPro == null) {
                    return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "No se encontró el AdminPorPro a eliminar.", "EliminarAdminPorPro NoResultException");
                }
                em.remove(AdminPorPro);
            } else {
                return new Respuesta(false, CodigoRespuesta.ERROR_CLIENTE, "Debe cargar el AdminPorPro a eliminar.", "EliminarAdminPorPro NoResultException");
            }
            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "");
        } catch (Exception ex) {
            if (ex.getCause() != null && ex.getCause().getCause().getClass() == SQLIntegrityConstraintViolationException.class) {
                return new Respuesta(false, CodigoRespuesta.ERROR_PERMISOS, "No se puede eliminar el AdminPorPro porque tiene relaciones con otros registros.", "EliminarAdminPorPro " + ex.getMessage());
            }
            Logger.getLogger(AdminiPorProService.class.getName()).log(Level.SEVERE, "Ocurrio un error al guardar el AdminPorPro.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al eliminar el AdminPorPro.", "EliminarAdminPorPro " + ex.getMessage());
        }
    }
}
