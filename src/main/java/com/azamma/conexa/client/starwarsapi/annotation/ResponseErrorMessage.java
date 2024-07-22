package ar.com.sancorsalud.grillasneoapi.clients.annotation;

import java.lang.annotation.*;

/**
 * Anotación creada para crear mensajes personalizados en los métodos
 * de los clients creados con Feign
 *
 * @author Agustín Zammarrelli
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ResponseErrorMessage {

    String FEIGN_API_ERROR_MESSAGE_HEADER = "X-Feign-Api-Error-Message";
    String DEFAULT_FEIGN_API_ERROR_MESSAGE = "Error al consultar la api";

    String value() default DEFAULT_FEIGN_API_ERROR_MESSAGE;

    String headerName() default FEIGN_API_ERROR_MESSAGE_HEADER;

}