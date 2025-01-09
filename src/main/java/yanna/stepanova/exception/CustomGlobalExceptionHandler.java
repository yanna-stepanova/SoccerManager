package yanna.stepanova.exception;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntityNotFoundCustomException.class)
    protected ResponseEntity<Object> handleEntityNotFoundCustomException(
            EntityNotFoundCustomException ex) {
        return generateErrorResponse(HttpStatus.NOT_FOUND, ex.getLocalizedMessage());
    }

    private ResponseEntity<Object> generateErrorResponse(HttpStatus status, String errorText) {
        Map<String,Object> bodyErrors = new LinkedHashMap<>();
        bodyErrors.put("timestamp", LocalDateTime.now());
        bodyErrors.put("status", status);
        bodyErrors.put("error", errorText);
        return new ResponseEntity<>(bodyErrors, status);
    }
}
