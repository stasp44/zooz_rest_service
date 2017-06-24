package zooz.exceptions;

import org.springframework.http.HttpStatus;

/**
 * Created by stas.panchenko on 24/06/2017.
 */
public class ForbiddenException extends BaseZoozServiceException{
    public static final HttpStatus STATUS_CODE = HttpStatus.FORBIDDEN;

    public ForbiddenException(String code) {
        super(STATUS_CODE, code);
    }

    public ForbiddenException(String code, String message) {
        super(STATUS_CODE, code, message);
    }
}
