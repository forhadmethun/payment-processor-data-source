package com.tokenizer.rest.resources;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.tokenizer.rest.config.Producer;
import com.tokenizer.rest.request.AuthRequest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/api")
@Produces(MediaType.APPLICATION_JSON)
public class AuthResource {

    Producer producer = new Producer();

    @POST
    @Path("/auth")
    public void auth(AuthRequest authRequest) throws JsonProcessingException {
        producer.createProducerAndSendMessage(authRequest);
    }

}
