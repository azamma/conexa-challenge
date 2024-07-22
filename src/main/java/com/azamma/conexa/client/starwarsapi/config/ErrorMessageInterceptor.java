package com.azamma.conexa.client.starwarsapi.config;

import com.azamma.conexa.client.starwarsapi.annotation.ResponseErrorMessage;
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
            template.header("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        }
    }
}
