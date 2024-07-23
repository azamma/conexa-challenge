package com.azamma.conexa.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@Setter
@ResponseStatus(value = HttpStatus.HTTP_VERSION_NOT_SUPPORTED)
public class ConexaNotSupportedException extends RuntimeException {
    private String errorCode;

    /**
     * ConexaNotSupportedException
     *
     * @param message
     */
    public ConexaNotSupportedException(String message) {
        super(message);
    }

    /**
     * ResourceNotFoundException
     *
     * @param message
     * @param errorCode
     */
    public ConexaNotSupportedException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    /**
     *
     */
    private static final long serialVersionUID = -2858918579477309808L;

}
