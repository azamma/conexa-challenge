package ar.com.sancorsalud.grillasneoapi.clients.config;

import ar.com.sancorsalud.grillasneoapi.clients.annotation.ResponseErrorMessage;
import feign.RequestTemplate;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * Intercepta el request para incluir el mensaje de error personalizado
 * con la anotación ResponseErrorMessage y lo envía como header.
 *
 * @author Agustin Zammarrelli
 */
@Component
public class ErrorMessageInterceptor implements feign.RequestInterceptor {

    @Override
    public void apply(RequestTemplate template) {
        Method method = template.methodMetadata().method();
        ResponseErrorMessage annotation = method.getAnnotation(ResponseErrorMessage.class);
        if (annotation != null) {
            String message = annotation.value();
            String headerName = annotation.headerName();
            template.header(headerName, message);
        }
    }
}
