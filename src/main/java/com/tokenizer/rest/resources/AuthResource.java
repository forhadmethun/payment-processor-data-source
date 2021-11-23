package com.tokenizer.rest.resources;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.tokenizer.rest.producer.CardInfoProducer;
import com.tokenizer.rest.request.AuthRequest;
import com.tokenizer.rest.response.AuthResponse;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/api")
@Produces(MediaType.APPLICATION_JSON)
public class AuthResource {

    CardInfoProducer cardInfoProducer = new CardInfoProducer();

    @POST
    @Path("/auth")
    public AuthResponse auth(AuthRequest authRequest) throws JsonProcessingException {
        try {
            return new AuthResponse()
                .setSuccess(true)
                .setTransactionId(
                    cardInfoProducer.createProducerAndSendMessage(authRequest)
                );
        } catch (Exception e){
            return new AuthResponse().setSuccess(false);
        }
    }

}
