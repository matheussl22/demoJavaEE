package com.example.demo.rest7;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.logging.Level;
import java.util.logging.Logger;

@Provider
public class GlobalExceptionHandler implements ExceptionMapper<Exception> {

    private static final Logger logger = Logger.getLogger(GlobalExceptionHandler.class.getName());

    @Override
    public Response toResponse(Exception exception) {
        int status = 500;
        String message = "Erro inesperado. Por favor, tente novamente mais tarde.";

        if (exception instanceof NegocioException) {
            NegocioException negocioException = (NegocioException) exception;
            status = 400;
            message = negocioException.getMessage();
        }

        logger.log(Level.SEVERE, exception.getMessage(), exception);

        return Response.status(status).entity(message).type(MediaType.TEXT_PLAIN).build();
    }
}