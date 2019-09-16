/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.admin.ac.cr.service;

import java.util.logging.Logger;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Carlos Olivares
 */
@Stateless
@LocalBean
public class ProyectoService {
    private static final Logger LOG = Logger.getLogger(ProyectoService.class.getName());//imprime el error en payara
    @PersistenceContext(unitName = "WsAdminProPU")
    private EntityManager em;
}
