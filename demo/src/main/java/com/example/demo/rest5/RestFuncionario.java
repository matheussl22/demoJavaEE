package com.example.demo.rest5;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.math.BigDecimal;

@Path("/funcionario")
public class RestFuncionario {


    private Funcionario criar(){
        Funcionario funcionario
                 =new Funcionario();

        funcionario.setCpf(500l);
        funcionario.setNome("Matheus");
        funcionario.setSalario(new BigDecimal(1500.00));

        return funcionario;
    }

    @GET()
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/xml")
    public Funcionario servicoXml() {
        return criar();
    }


}
