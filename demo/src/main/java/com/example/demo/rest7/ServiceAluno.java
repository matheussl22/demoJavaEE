package com.example.demo.rest7;

import java.util.List;

public interface ServiceAluno {
    void gravar(Aluno aluno) throws NegocioException;
    void deletar(String aluno) throws NegocioException;
    List<Aluno> listar() throws NegocioException;
}