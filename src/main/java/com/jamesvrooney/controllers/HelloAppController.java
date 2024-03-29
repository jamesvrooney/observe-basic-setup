package com.jamesvrooney.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
public class HelloAppController {

    private static final Logger log = LoggerFactory.getLogger(HelloAppController.class);

    @GetMapping("/hello")
    public Response hello() {
        Response response = buildResponse();

        if (response.isValid()) {
            log.info("The response is valid.");
        }

        return response;
    }

    private Response buildResponse() {
        return new Response("Hello World");
    }

    private record Response (String message) {
        private Response {
            Objects.requireNonNull(message);
        }

        private boolean isValid() {
            return true;
        }
    }

}
