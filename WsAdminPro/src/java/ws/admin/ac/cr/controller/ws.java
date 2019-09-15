/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.admin.ac.cr.controller;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author kelor
 */
@WebService(serviceName = "ws")
public class ws {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "hola")
    public String hola(@WebParam(name = "Usuarios") String Usuarios) {
        //TODO write your implementation code here:
        return Usuarios;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getUsuario")
    public String getUsuario(@WebParam(name = "Usuario") String Usuario, @WebParam(name = "contrasenna") String contrasenna) {
        //TODO write your implementation code here:
        return "Usuario: "+ Usuario+" Contraseña: "+ contrasenna;
    }

    /**
     * This is a sample web service operation
     */
    
}
