/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.univali.resource;

import br.univali.controller.Apartamento;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;

/**
 * REST Web Service
 *
 * @author jader
 */
@Path("apartamento")
public class ApartamentoResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ApartamentoResource
     */
    public ApartamentoResource() {
    }

    /**
     * Retrieves representation of an instance of br.univali.resource.ApartamentoResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public String getApartamentos() {
        Apartamento ap = new Apartamento();
        return ap.getListaApartamento();
    }

    /**
     * PUT method for updating or creating an instance of ApartamentoResource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }
}
