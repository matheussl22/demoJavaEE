package com.example.demo.rest7;

public class NegocioException extends Exception {
    public NegocioException(String erro) {
        super(erro);
    }
}