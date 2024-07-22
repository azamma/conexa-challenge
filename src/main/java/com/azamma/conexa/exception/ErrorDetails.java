package com.azamma.conexa.exception;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class ErrorDetails {

    private LocalDateTime timestamp;
    private String message;
    private int status;
    private HttpStatus error;
    private String errorCode;
    private String path;
    private String cause;
    private ClientDetails clientDetails;

    /**
     * ErrorDetails
     *
     * @param timestamp
     * @param message
     * @param status
     * @param error
     * @param errorCode
     */
    public ErrorDetails(LocalDateTime timestamp, String message, int status, HttpStatus error, String errorCode) {
        super();
        this.timestamp = timestamp;
        this.message = message;
        this.status = status;
        this.error = error;
        this.errorCode = errorCode;
    }

    /**
     * ErrorDetails
     * <p>
     * Constructor para excepciones de client Feign
     *
     * @param timestamp
     * @param message
     * @param status
     * @param error
     * @param errorCode
     * @param clientDetails
     */
    public ErrorDetails(LocalDateTime timestamp, String message, int status, HttpStatus error, String errorCode, ClientDetails clientDetails) {
        super();
        this.timestamp = timestamp;
        this.message = message;
        this.status = status;
        this.error = error;
        this.errorCode = errorCode;
        this.clientDetails = clientDetails;
    }

    /**
     * ErrorDetails
     *
     * @param timestamp
     * @param message
     * @param status
     * @param error
     * @param errorCode
     * @param cause
     */
    public ErrorDetails(LocalDateTime timestamp, String message, int status, HttpStatus error, String errorCode, String cause) {
        super();
        this.timestamp = timestamp;
        this.message = message;
        this.status = status;
        this.error = error;
        this.errorCode = errorCode;
        this.cause = cause;
    }
}
