package com.example.demo.rest3;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/notaFiscal/{id: [0-9]}")
public class RestNotaFiscal {
    @GET()
    @Produces(MediaType.TEXT_PLAIN)
    public String processarNotaFiscal(@PathParam("id") Long nome) {
        return "nota fiscal processada com sucesso " + nome;
    }
}
