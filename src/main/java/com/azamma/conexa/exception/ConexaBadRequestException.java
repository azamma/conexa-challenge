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
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ConexaBadRequestException extends RuntimeException {
    private String errorCode;

    /**
     * ConexaBadRequestException
     *
     * @param message
     */
    public ConexaBadRequestException(String message) {
        super(message);
    }

    /**
     * ResourceBadRequestException
     *
     * @param message
     * @param errorCode
     */
    public ConexaBadRequestException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    /**
     *
     */
    private static final long serialVersionUID = -5059364464799202094L;

}
