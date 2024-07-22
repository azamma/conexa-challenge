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
@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
public class ResourceUnauthorizedException extends RuntimeException {
    private String errorCode;

    /**
     * ResourceUnauthorizedException
     *
     * @param message
     */
    public ResourceUnauthorizedException(String message) {
        super(message);
    }

    /**
     * ResourceUnauthorizedException
     *
     * @param message
     * @param errorCode
     */
    public ResourceUnauthorizedException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    /**
     * 
     */
    private static final long serialVersionUID = 810150369154618006L;

}
