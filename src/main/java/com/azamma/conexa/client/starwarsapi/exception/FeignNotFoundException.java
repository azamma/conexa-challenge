package com.azamma.conexa.client.starwarsapi.exception;

import feign.Response;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@Setter
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class FeignNotFoundException extends RuntimeException {

    private Response response;
    private String message;

    public FeignNotFoundException(Response response, String message) {
        this.response = response;
        this.message = message;
    }
}
