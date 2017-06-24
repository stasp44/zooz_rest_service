package zooz.exceptions;


import org.springframework.http.HttpStatus;

public class BaseZoozServiceException extends RuntimeException{
    private HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
    private String code;

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public BaseZoozServiceException(HttpStatus httpStatus, String code) {
        super(code);
        this.httpStatus = httpStatus;
        this.code = code;
    }

    public BaseZoozServiceException(HttpStatus httpStatus, String code, String message) {
        super(message);
        this.code = code;
        this.httpStatus = httpStatus;
    }

    public String getCode() {
        return code;
    }
}
