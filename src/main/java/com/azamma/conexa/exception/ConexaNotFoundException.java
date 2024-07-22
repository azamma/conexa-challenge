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
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    private String errorCode;

    /**
     * ResourceNotFoundException
     *
     * @param message
     */
    public ResourceNotFoundException(String message) {
        super(message);
    }

    /**
     * ResourceNotFoundException
     *
     * @param message
     * @param errorCode
     */
    public ResourceNotFoundException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    /**
     * 
     */
    private static final long serialVersionUID = 5384148963002189453L;

}
