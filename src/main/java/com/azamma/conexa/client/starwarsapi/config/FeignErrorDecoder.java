package com.azamma.conexa.client.starwarsapi.config;

import com.azamma.conexa.client.starwarsapi.exception.*;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.stereotype.Component;

import static com.azamma.conexa.client.starwarsapi.annotation.ResponseErrorMessage.DEFAULT_FEIGN_API_ERROR_MESSAGE;
import static com.azamma.conexa.client.starwarsapi.annotation.ResponseErrorMessage.FEIGN_API_ERROR_MESSAGE_HEADER;

/**
 * {@code FeignErrorDecoder}
 * Implementa la interfaz {@link ErrorDecoder} para interceptar errores de clientes Feign y lanzar
 * excepciones personalizadas. La clase maneja los errores de la API proporcionando mensajes de error
 * configurados y detalles específicos de la solicitud como la URL y el método.
 *
 * <p>Esta implementación permite personalizar el manejo de errores en función del código de estado HTTP
 * devuelto por la API Feign y la configuración del mensaje de error.</p>
 *
 * <p>La clase soporta distintos códigos de estado HTTP y lanza excepciones específicas para cada caso.
 * También proporciona un mensaje de error predeterminado si no se encuentra uno en los encabezados de la
 * respuesta.</p>
 *
 * @author Agustin Zammarrelli
 */
@Component
public class FeignErrorDecoder implements ErrorDecoder {

    /**
     * Decodifica los errores de la respuesta de Feign y lanza una excepción personalizada basada en el
     * código de estado HTTP y el mensaje de error configurado.
     *
     * <p>El mensaje de error se extrae del encabezado de la respuesta. Si no está presente, se utiliza
     * un mensaje de error predeterminado. Dependiendo del código de estado de la respuesta, se lanzan
     * diferentes tipos de excepciones.</p>
     *
     * @param methodKey La clave del método que identifica la solicitud de la API Feign.
     * @param response  La {@link Response} de Feign que contiene el código de estado y los encabezados de la respuesta.
     * @return Una excepción personalizada correspondiente al código de estado de la respuesta.
     */
    @Override
    public Exception decode(String methodKey, Response response) {

        // Se obtiene el mensaje de error configurado en el método de la API
        String responseErrorMessage =
                response.request()
                        .headers()
                        .get(FEIGN_API_ERROR_MESSAGE_HEADER)
                        .stream()
                        .findFirst()
                        .orElse(DEFAULT_FEIGN_API_ERROR_MESSAGE);

        // Se pueden ir agregando más casos de acuerdo con los códigos de respuesta de las nuevas APIs
        switch (response.status()) {
            case 400:
                return new FeignBadRequestException(response, responseErrorMessage);
            case 401:
                return new FeignValidationException(response, responseErrorMessage);
            case 403:
                return new FeignForbiddenException(response, responseErrorMessage);
            case 404:
                return new FeignNotFoundException(response, responseErrorMessage);
            case 422:
                return new FeignValidationException(response, responseErrorMessage);
            case 505:
                return new FeignNotSupportedException(response, responseErrorMessage);
            default:
                return new FeignDefaultException(response, responseErrorMessage);
        }
    }
}
