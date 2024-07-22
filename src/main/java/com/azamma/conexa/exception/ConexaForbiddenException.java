package ar.com.sancorsalud.grillasneoapi.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Alejandro Moya
 */
@Getter
@Setter
@ResponseStatus(value = HttpStatus.FORBIDDEN)
public class ResourceForbiddenException extends RuntimeException {
    private String errorCode;

    /**
     * ResourceForbiddenException
     *
     * @param message
     */
    public ResourceForbiddenException(String message) {
        super(message);
    }

    /**
     * ResourceForbiddenException
     *
     * @param message
     * @param errorCode
     */
    public ResourceForbiddenException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    /**
     * 
     */
    private static final long serialVersionUID = -2443265758007170938L;

}
