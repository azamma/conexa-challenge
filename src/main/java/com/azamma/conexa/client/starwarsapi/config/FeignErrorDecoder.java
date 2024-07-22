package ar.com.sancorsalud.grillasneoapi.clients.config;

import ar.com.sancorsalud.grillasneoapi.clients.exception.*;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.stereotype.Component;

import static ar.com.sancorsalud.grillasneoapi.clients.annotation.ResponseErrorMessage.DEFAULT_FEIGN_API_ERROR_MESSAGE;
import static ar.com.sancorsalud.grillasneoapi.clients.annotation.ResponseErrorMessage.FEIGN_API_ERROR_MESSAGE_HEADER;

/**
 * {@code FeignErrorDecoder}
 * Intercepta errores de clientes Feign y dispara excepciones personalizadas
 * con datos de cliente como el nombre de la api, la url y el método
 *
 * @author Agustin Zammarrelli
 */
@Component
public class FeignErrorDecoder implements ErrorDecoder {

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

