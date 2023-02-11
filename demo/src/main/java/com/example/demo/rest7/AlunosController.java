package com.example.demo.rest7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/alunos")
public class AlunosController implements ServiceAluno {

    // simulador de um banco de dados.
    private static final List<Aluno> banco = new ArrayList<>();
    static {
        banco.add(new Aluno("Matheus", "Matematica", Arrays.asList(10,9,8)));
        banco.add(new Aluno("Jonas", "Ciencia", Arrays.asList(10,10,10)));
    }

    @Path("/gravar")
    @POST
    @Override
    @Consumes(MediaType.APPLICATION_JSON)
    public void gravar(Aluno aluno) throws NegocioException {
        aluno.validate();
        banco.add(aluno);
    }

    @Path("/media")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public AlunoDto media(@QueryParam("nome") String nome) throws NegocioException {
        Optional<Aluno> aluno = banco.stream().filter(t -> t.getNome().equals(nome)).findFirst();
        if (!aluno.isPresent()) {
            throw new NegocioException("aluno inexistente.");
        }

        AlunoDto response = alunoDtoBuild(aluno);

        return response;
    }

    private static AlunoDto alunoDtoBuild(Optional<Aluno> aluno) {
        int soma = aluno.get().getNotas().stream().mapToInt(Integer::intValue).sum();
        Double media = soma / (double) aluno.get().getNotas().size();
        AlunoDto response = new AlunoDto();
        response.setNome(aluno.get().getNome());
        response.setMedia(media);
        if (media > 7) {
            response.setStatus("Aprovado");
        } else {
            response.setStatus("Reprovado");
        }
        return response;
    }

    @Path("/deletar")
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Override
    public void deletar(@QueryParam("nome") String nome) throws NegocioException {
        if (nome == null) {
            throw new NegocioException("aluno é obrigatório para deleção.");
        }
        Optional<Aluno> deletar = banco.stream().filter(t -> t.getNome().equals(nome)).findFirst();
        if (!deletar.isPresent()) {
            throw new NegocioException("aluno inexistente.");
        }
        banco.remove(deletar.get());
    }

    @Path("/listar")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public List<Aluno> listar() throws NegocioException {
        return banco;
    }


    @Path("/aluno")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public AlunoDto buscarPorAluno(@QueryParam("nome") String nome) throws NegocioException {
        if (nome == null) {
            throw new NegocioException("aluno é obrigatório para deleção.");
        }
        Optional<Aluno> aluno = banco.stream().filter(t -> t.getNome().equals(nome)).findFirst();
        if (!aluno.isPresent()) {
            throw new NegocioException("aluno inexistente.");
        }

        AlunoDto response = alunoDtoBuild(aluno);

        return response;
    }


}