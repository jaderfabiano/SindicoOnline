/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.univali.resource;



import br.univali.controller.Morador;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;


import org.json.JSONObject;


/**
 * REST Web Service
 *
 * @author jader fabiano
 */
@Path("morador")
public class MoradorResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of MoradorResource
     */
    public MoradorResource() {
    }
    
    @GET
    @Produces("application/json")    
   // @Consumes("application/json")
    @Path("/{id}")
    public String getMorador(@PathParam("id") int userId ){
        Morador morador = new Morador();
        System.out.println("Teste paramentro " + userId     );
        String result = morador.getMorador(userId);
        
        return result;
    }

    
    /**
     * Retrieves representation of an instance of br.univali.resource.MoradorResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    @Path("/all")
    public String getMoradores() {        
        Morador morador = new Morador();
        String list = morador.getListMoradores();
        
        System.out.println("Chegou um Get");
        return list;
    }

    /**
     * PUT method for updating or creating an instance of MoradorResource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }
    
    @POST
    @Consumes("application/json")
    public String novoMorador(String content) {
      Morador morador = new Morador();
      morador.novoMorador(content);
   
       
        //System.out.println("Chegou comando post " + content);
        return "OK";
        
    }
}
