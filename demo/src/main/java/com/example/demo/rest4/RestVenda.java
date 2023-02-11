package com.example.demo.rest4;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/venda")
public class RestVenda {
    @GET()
    @Produces(MediaType.TEXT_PLAIN)
    public String processarNotaFiscal(@QueryParam("nome") String nome,
                                      @QueryParam("produto") String produto,
                                      @QueryParam("tipo") @DefaultValue("pdf") String tipo) {

        return "NOTA FISCAL="+nome+" - "+produto+" - "+tipo;
    }
}
