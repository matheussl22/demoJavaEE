package com.example.demo.rest7;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.core.UriBuilder;
import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor {

    private static final Logger LOGGER = Logger.getLogger(Servidor.class.getName());

    public static void main(String[] args) {
        URI uri = UriBuilder.fromUri("http://localhost/").port(8080).build();
        ResourceConfig config = new ResourceConfig();
        config.packages("com.example.demo.rest7");
        try {
            HttpServer server = GrizzlyHttpServerFactory.createHttpServer(uri, config);
            LOGGER.info("Servidor no ar");
            server.start();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro na execução do servidor JSE.", e);
        }
    }
}