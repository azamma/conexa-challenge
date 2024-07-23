package com.azamma.conexa.exception;

import com.azamma.conexa.client.starwarsapi.exception.*;
import feign.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(ConexaBadRequestException.class)
    public ResponseEntity<?> handleConexaBadRequestException(ConexaBadRequestException exception) {
        ErrorDetails errorDetails = new ErrorDetails(
                LocalDateTime.now(),
                exception.getMessage(),
                HttpStatus.BAD_REQUEST.value(),
                HttpStatus.BAD_REQUEST,
                "400"
        );
        logException(exception, errorDetails.getMessage(), errorDetails.getErrorCode());
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConexaForbiddenException.class)
    public ResponseEntity<?> handleConexaForbiddenException(ConexaForbiddenException exception) {
        ErrorDetails errorDetails = new ErrorDetails(
                LocalDateTime.now(),
                exception.getMessage(),
                HttpStatus.FORBIDDEN.value(),
                HttpStatus.FORBIDDEN,
                "403"
        );
        logException(exception, errorDetails.getMessage(), errorDetails.getErrorCode());
        return new ResponseEntity<>(errorDetails, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(ConexaNotFoundException.class)
    public ResponseEntity<?> handleConexaNotFoundException(ConexaNotFoundException exception) {
        ErrorDetails errorDetails = new ErrorDetails(
                LocalDateTime.now(),
                exception.getMessage(),
                HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND,
                "404"
        );
        logException(exception, errorDetails.getMessage(), errorDetails.getErrorCode());
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ConexaNotSupportedException.class)
    public ResponseEntity<?> handleConexaNotSupportedException(ConexaNotSupportedException exception) {
        ErrorDetails errorDetails = new ErrorDetails(
                LocalDateTime.now(),
                exception.getMessage(),
                HttpStatus.HTTP_VERSION_NOT_SUPPORTED.value(),
                HttpStatus.HTTP_VERSION_NOT_SUPPORTED,
                "505"
        );
        logException(exception, errorDetails.getMessage(), errorDetails.getErrorCode());
        return new ResponseEntity<>(errorDetails, HttpStatus.HTTP_VERSION_NOT_SUPPORTED);
    }

    @ExceptionHandler(ConexaUnauthorizedException.class)
    public ResponseEntity<?> handleConexaUnauthorizedException(ConexaUnauthorizedException exception) {
        ErrorDetails errorDetails = new ErrorDetails(
                LocalDateTime.now(),
                exception.getMessage(),
                HttpStatus.UNAUTHORIZED.value(),
                HttpStatus.UNAUTHORIZED,
                "401"
        );
        logException(exception, errorDetails.getMessage(), errorDetails.getErrorCode());
        return new ResponseEntity<>(errorDetails, HttpStatus.UNAUTHORIZED);
    }


    @ExceptionHandler(FeignNotFoundException.class)
    public ResponseEntity<?> handleFeignNotFoundException(FeignNotFoundException exception) {
        ErrorDetails errorDetails = new ErrorDetails(
                LocalDateTime.now(),
                exception.getMessage(),
                HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND,
                "404",
                createClientDetails(exception.getResponse())
        );
        logException(exception, errorDetails.getMessage(), errorDetails.getErrorCode());
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(FeignBadRequestException.class)
    public ResponseEntity<?> handleFeignBadRequestException(FeignBadRequestException exception) {
        ErrorDetails errorDetails = new ErrorDetails(
                LocalDateTime.now(),
                exception.getMessage(),
                HttpStatus.BAD_REQUEST.value(),
                HttpStatus.BAD_REQUEST,
                "400",
                createClientDetails(exception.getResponse())
        );
        logException(exception, errorDetails.getMessage(), errorDetails.getErrorCode());
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(FeignForbiddenException.class)
    public ResponseEntity<?> handleFeignForbiddenException(FeignForbiddenException exception) {
        ErrorDetails errorDetails = new ErrorDetails(
                LocalDateTime.now(),
                exception.getMessage(),
                HttpStatus.FORBIDDEN.value(),
                HttpStatus.FORBIDDEN,
                "403",
                createClientDetails(exception.getResponse())
        );
        logException(exception, errorDetails.getMessage(), errorDetails.getErrorCode());
        return new ResponseEntity<>(errorDetails, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(FeignUnauthorizedException.class)
    public ResponseEntity<?> handleFeignUnauthorizedException(FeignUnauthorizedException exception) {
        ErrorDetails errorDetails = new ErrorDetails(
                LocalDateTime.now(),
                exception.getMessage(),
                HttpStatus.UNAUTHORIZED.value(),
                HttpStatus.UNAUTHORIZED,
                "401",
                createClientDetails(exception.getResponse())
        );
        logException(exception, errorDetails.getMessage(), errorDetails.getErrorCode());
        return new ResponseEntity<>(errorDetails, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(FeignValidationException.class)
    public ResponseEntity<?> handleFeignValidationException(FeignValidationException exception) {
        ErrorDetails errorDetails = new ErrorDetails(
                LocalDateTime.now(),
                exception.getMessage(),
                HttpStatus.UNPROCESSABLE_ENTITY.value(),
                HttpStatus.UNPROCESSABLE_ENTITY,
                "422",
                createClientDetails(exception.getResponse())
        );
        logException(exception, errorDetails.getMessage(), errorDetails.getErrorCode());
        return new ResponseEntity<>(errorDetails, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(FeignNotSupportedException.class)
    public ResponseEntity<?> handleFeignNotSupportedException(FeignNotSupportedException exception) {
        ErrorDetails errorDetails = new ErrorDetails(
                LocalDateTime.now(),
                exception.getMessage(),
                HttpStatus.HTTP_VERSION_NOT_SUPPORTED.value(),
                HttpStatus.HTTP_VERSION_NOT_SUPPORTED,
                "505",
                createClientDetails(exception.getResponse())
        );
        logException(exception, errorDetails.getMessage(), errorDetails.getErrorCode());
        return new ResponseEntity<>(errorDetails, HttpStatus.HTTP_VERSION_NOT_SUPPORTED);
    }

    @ExceptionHandler(FeignDefaultException.class)
    public ResponseEntity<?> handleFeignDefaultException(FeignDefaultException exception) {
        ErrorDetails errorDetails = new ErrorDetails(
                LocalDateTime.now(),
                exception.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                HttpStatus.INTERNAL_SERVER_ERROR,
                "500",
                createClientDetails(exception.getResponse())
        );
        logException(exception, errorDetails.getMessage(), errorDetails.getErrorCode());
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidationErrors(MethodArgumentNotValidException exception, WebRequest request) {
        Map<String, String> errors = new HashMap<>();
        exception.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        ErrorDetails errorDetails = new ErrorDetails(
                LocalDateTime.now(),
                errors.toString(),
                HttpStatus.BAD_REQUEST.value(),
                HttpStatus.BAD_REQUEST,
                "BAD_REQUEST",
                "Validation errors"
        );
        logException(exception, errorDetails.getMessage(), errorDetails.getErrorCode());
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IOException.class)
    public ResponseEntity<?> handleIOException(IOException exception, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(
                LocalDateTime.now(),
                exception.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                HttpStatus.INTERNAL_SERVER_ERROR,
                "IO_EXCEPTION"
        );
        logException(exception, errorDetails.getMessage(), errorDetails.getErrorCode());
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGlobalException(Exception exception, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(
                LocalDateTime.now(),
                exception.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                HttpStatus.INTERNAL_SERVER_ERROR,
                "INTERNAL_SERVER_ERROR"
        );
        logException(exception, errorDetails.getMessage(), errorDetails.getErrorCode());
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private ClientDetails createClientDetails(Response response) {
        String clientName = response.request().requestTemplate().feignTarget().name();
        String clientUrl = response.request().url();
        String clientMethod = response.request().httpMethod().toString();

        return new ClientDetails(clientName, clientUrl, clientMethod);
    }

    private void logException(Exception e, String message, String errorCode) {
        log.error(errorCode.concat(": ").concat(message), e);
    }
}
