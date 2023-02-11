package com.example.demo.rest2;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


@Path("/cadastro/{username: [a-zA-Z]}")
public class RestCalculadora {
    @GET()
    @Produces(MediaType.TEXT_PLAIN)
    public String processarCadastro(@PathParam("username") String nome) {
        return "cadastro feito com sucesso para " + nome;
    }
}
