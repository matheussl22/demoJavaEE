package com.example.demo.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.awt.*;
import java.util.Date;

@Path("/Ola")
public class OlaImpl implements Ola{
    @Override
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String servico() {
        return "Olá Mundo" + new Date();
    }



}
