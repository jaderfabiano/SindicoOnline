/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.univali.resource;

import br.univali.controller.Login;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import org.json.JSONObject;

/**
 * REST Web Service
 *
 * @author jader
 */
@Path("login")
public class LoginResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of LoginResource
     */
    public LoginResource() {
    }

    /**
     * Retrieves representation of an instance of br.univali.resource.LoginResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public String getXml() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of LoginResource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putXml(String content) {
    }
    
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public String login(String dados){
       JSONObject object = new JSONObject(dados);
        System.out.println("Login Requisicao");
       String user = object.get("login").toString();
       String senha = object.get("senha").toString();        
       Login login = new Login(user, senha);       
       if ( login.validateLogin() == true) {
           String resp = "{\"user\": \"OK\" } ";
           return resp;
       }else {
           String resp =  "{\"user\": \"NOK\" } ";           
           return resp;        
       }
    }
}
