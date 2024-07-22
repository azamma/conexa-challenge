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
@ResponseStatus(value = HttpStatus.HTTP_VERSION_NOT_SUPPORTED)
public class ResourceNotSupportedException extends RuntimeException {
    private String errorCode;

    /**
     * ResourceNotFoundException
     *
     * @param message
     */
    public ResourceNotSupportedException(String message) {
        super(message);
    }

    /**
     * ResourceNotFoundException
     *
     * @param message
     * @param errorCode
     */
    public ResourceNotSupportedException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    /**
     * 
     */
    private static final long serialVersionUID = -2858918579477309808L;

}
