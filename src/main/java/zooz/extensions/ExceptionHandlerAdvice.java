package zooz.extensions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import zooz.exceptions.BaseZoozServiceException;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(BaseZoozServiceException.class)
    public ResponseEntity handleException(BaseZoozServiceException e) {
        Map<String, String> responseBody = new HashMap<>();
        responseBody.put("message", e.getMessage());
        responseBody.put("code", e.getCode());
        return ResponseEntity.status(e.getHttpStatus()).body(responseBody);
    }
}
