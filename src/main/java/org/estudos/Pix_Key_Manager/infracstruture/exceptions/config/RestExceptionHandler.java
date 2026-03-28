package org.estudos.Pix_Key_Manager.infracstruture.exceptions.config;

import org.estudos.Pix_Key_Manager.application.domain.exceptions.LimitPixKeysRegisteredException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(LimitPixKeysRegisteredException.class)
    protected ResponseEntity<RestResponseError> handlerLimitPixKeysRegisteredException(LimitPixKeysRegisteredException exception) {

        RestResponseError treatReponse = new RestResponseError(HttpStatus.BAD_REQUEST, exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(treatReponse);
    }

}
