package org.estudos.Pix_Key_Manager.infracstruture.exceptions.config;

import org.estudos.Pix_Key_Manager.application.domain.exceptions.LimitPixKeysRegisteredException;
import org.estudos.Pix_Key_Manager.application.usecases.exception.CpfAlreadyExistsException;
import org.estudos.Pix_Key_Manager.application.usecases.exception.EmailAlreadyExistsException;
import org.estudos.Pix_Key_Manager.application.usecases.exception.NullUserException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(LimitPixKeysRegisteredException.class)
    protected ResponseEntity<RestResponseError> handlerLimitPixKeysRegisteredException(LimitPixKeysRegisteredException exception) {

        RestResponseError treatReponse = new RestResponseError(HttpStatus.BAD_REQUEST, exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(treatReponse);
    }

    @ExceptionHandler(CpfAlreadyExistsException.class)
    protected ResponseEntity<RestResponseError> handleCpfAlreadyExistsException(CpfAlreadyExistsException exception) {

        RestResponseError treatResponse = new RestResponseError(HttpStatus.CONFLICT, exception.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(treatResponse);
    }

    @ExceptionHandler(EmailAlreadyExistsException.class)
    protected ResponseEntity<RestResponseError> handleEmailAlreadyExistsException(EmailAlreadyExistsException exception) {

        RestResponseError treatResponse = new RestResponseError(HttpStatus.CONFLICT, exception.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(treatResponse);
    }

    @ExceptionHandler(NullUserException.class)
    protected ResponseEntity<RestResponseError> handleNullUserException(NullUserException exception) {

        RestResponseError treatResponse = new RestResponseError(HttpStatus.BAD_REQUEST, exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(treatResponse);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            @NonNull MethodArgumentNotValidException ex,
            @NonNull HttpHeaders headers,
            @NonNull HttpStatusCode status,
            @NonNull WebRequest request) {

        Map<String, String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .collect(Collectors.toMap(
                        FieldError::getField,
                        FieldError::getDefaultMessage,
                        (msg1, msg2) -> msg1 + "; " + msg2 // merge caso o mesmo campo tenha >1 erro
                ));

        return ResponseEntity.status(status).body(errors);
    }
}
