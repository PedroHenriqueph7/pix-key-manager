package org.estudos.Pix_Key_Manager.infracstruture.exceptions.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public class RestResponseError {

    private HttpStatus httpStatus;
    private String message;

}
