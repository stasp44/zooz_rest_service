package zooz.exceptions;

import org.springframework.http.HttpStatus;

/**
 * Created by stas.panchenko on 24/06/2017.
 */
public class ValidationException extends BaseZoozServiceException{
    public static final HttpStatus STATUS_CODE = HttpStatus.BAD_REQUEST;

    public ValidationException(String code) {
        super(STATUS_CODE, code);
    }

    public ValidationException(String code, String message) {
        super(STATUS_CODE, code, message);
    }
}
