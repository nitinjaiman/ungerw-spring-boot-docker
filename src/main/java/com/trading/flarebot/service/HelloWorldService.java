package com.trading.flarebot.service;

import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 * @author UNGERW
 */
@Component
@Path("/spring-docker/")
public class HelloWorldService {

    @GET
    @Path("/hello")
    public Response test() {
        System.out.println("logged");
        return Response.status(200).entity("Hello from Nitin jaiman ").build();
    }

}
