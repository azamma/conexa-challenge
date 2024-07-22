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
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ResourceBadRequestException extends RuntimeException {
    private String errorCode;

    /**
     * ResourceBadRequestException
     *
     * @param message
     */
    public ResourceBadRequestException(String message) {
        super(message);
    }

    /**
     * ResourceBadRequestException
     *
     * @param message
     * @param errorCode
     */
    public ResourceBadRequestException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    /**
     * 
     */
    private static final long serialVersionUID = -5059364464799202094L;

}
