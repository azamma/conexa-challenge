package ar.com.sancorsalud.grillasneoapi.clients.exception;

import feign.Response;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@Setter
@ResponseStatus(value = HttpStatus.HTTP_VERSION_NOT_SUPPORTED)
public class FeignNotSupportedException extends RuntimeException {

    private Response response;
    private String message;

    public FeignNotSupportedException(Response response, String message) {
        this.response = response;
        this.message = message;
    }
}
