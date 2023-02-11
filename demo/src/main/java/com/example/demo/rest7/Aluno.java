package com.example.demo.rest7;


import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class Aluno {

    String nome;
    String matricula;

    List<Integer> notas;

    public Aluno(){}

    public Aluno(String nome, String matricula, List<Integer> notas) {
        this.nome = nome;
        this.matricula = matricula;
        this.notas = notas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public List<Integer> getNotas() {
        return notas;
    }

    public void setNotas(List<Integer> notas) {
        this.notas = notas;
    }

    public void validate() throws NegocioException {
        List<String> erros = new ArrayList<>();

        if (nome == null || nome.trim().isEmpty()) {
            erros.add("Nome é obrigatório");
        }

        if (matricula == null || matricula.trim().isEmpty()) {
            erros.add("Matrícula é obrigatória");
        }

        if (notas.isEmpty()) {
            erros.add("Notas são obrigatórias");
        }

        if (!erros.isEmpty()) {
            throw new NegocioException(String.join("; ", erros));
        }
    }
}
