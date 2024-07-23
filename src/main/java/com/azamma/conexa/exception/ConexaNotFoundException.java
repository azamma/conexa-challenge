package com.azamma.conexa.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@Setter
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ConexaNotFoundException extends RuntimeException {
    private String errorCode;

    /**
     * ConexaNotFoundException
     *
     * @param message
     */
    public ConexaNotFoundException(String message) {
        super(message);
    }

    /**
     * ResourceNotFoundException
     *
     * @param message
     * @param errorCode
     */
    public ConexaNotFoundException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    /**
     *
     */
    private static final long serialVersionUID = 5384148963002189453L;

}
