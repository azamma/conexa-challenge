package com.azamma.conexa.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author azamma
 */
@Getter
@Setter
@ResponseStatus(value = HttpStatus.FORBIDDEN)
public class ConexaForbiddenException extends RuntimeException {
    private String errorCode;

    /**
     * ResourceForbiddenException
     *
     * @param message
     */
    public ConexaForbiddenException(String message) {
        super(message);
    }

    /**
     * ConexaForbiddenException
     *
     * @param message
     * @param errorCode
     */
    public ConexaForbiddenException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    /**
     *
     */
    private static final long serialVersionUID = -2443265758007170938L;

}
