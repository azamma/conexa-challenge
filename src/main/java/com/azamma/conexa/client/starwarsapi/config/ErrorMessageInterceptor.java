package com.azamma.conexa.client.starwarsapi.config;

import com.azamma.conexa.client.starwarsapi.annotation.ResponseErrorMessage;
import feign.RequestTemplate;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * Intercepta las solicitudes (requests) realizadas por Feign para incluir un mensaje de error personalizado
 * en el encabezado de la solicitud, basado en la anotación {@link ResponseErrorMessage}.
 * También agrega un encabezado "User-Agent" estándar a las solicitudes.
 * <p>
 * La anotación {@link ResponseErrorMessage} permite definir un mensaje de error personalizado y el nombre
 * del encabezado a ser incluido en la solicitud.
 *
 * <p>Esta clase implementa la interfaz {@link feign.RequestInterceptor} para modificar los encabezados
 * de las solicitudes antes de que sean enviadas.</p>
 *
 * @author Agustin Zammarrelli
 */
@Component
public class ErrorMessageInterceptor implements feign.RequestInterceptor {

    /**
     * Aplica la configuración de encabezado personalizada a la solicitud Feign.
     *
     * <p>Si el método de la solicitud Feign está anotado con {@link ResponseErrorMessage}, se extrae el mensaje
     * de error y el nombre del encabezado especificado en la anotación y se agrega a los encabezados de la solicitud.
     * Además, se agrega un encabezado "User-Agent" estándar para la solicitud.</p>
     *
     * @param template El {@link RequestTemplate} que representa la solicitud Feign que está siendo interceptada.
     */
    @Override
    public void apply(RequestTemplate template) {
        Method method = template.methodMetadata().method();
        ResponseErrorMessage annotation = method.getAnnotation(ResponseErrorMessage.class);
        if (annotation != null) {
            String message = annotation.value();
            String headerName = annotation.headerName();
            template.header(headerName, message);
            template.header("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        }
    }
}
