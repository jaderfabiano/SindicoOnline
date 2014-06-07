/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.univali.resource;

import br.univali.controller.AcessoCondominio;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;

/**
 * REST Web Service
 *
 * @author jader
 */
@Path("portaria")
public class PortariaResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of PortariaResource
     */
    public PortariaResource() {
    }

    /**
     * Retrieves representation of an instance of br.univali.resource.PortariaResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public String getListaEntrada() {
        AcessoCondominio acesso = new AcessoCondominio();
        return acesso.getListaEntrada();        
    }
    
    @GET
    @Produces("application/json")
    @Path("/saida")
    public String getListaSaida() {
        AcessoCondominio acesso = new AcessoCondominio();
        return acesso.getLisSaida(); 
    }

    /**
     * PUT method for updating or creating an instance of PortariaResource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public String registraSaida(String content) {
        return "";
    }
}
