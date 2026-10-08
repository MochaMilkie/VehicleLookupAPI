package me.mochamilkie.vehiclelookupapi.Exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidVinException.class)
    public ResponseEntity<ErrorCodes> handleInvalidVinException(InvalidVinException e) {
        return ResponseEntity.badRequest().body(ErrorCodes.INVALID_VIN);
    }
    @ExceptionHandler(InvalidResponseFromNHTSAException.class)
    public ResponseEntity<ErrorCodes> handleInvalidResponseFromNHTSAException(InvalidResponseFromNHTSAException e) {
        return ResponseEntity.badRequest().body(ErrorCodes.INVALID_NHTSA_RESPONSE);
    }
}
