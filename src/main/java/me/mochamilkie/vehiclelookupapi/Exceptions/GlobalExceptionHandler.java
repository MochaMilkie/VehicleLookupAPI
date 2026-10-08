package me.mochamilkie.vehiclelookupapi.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidVinException.class)
    public ResponseEntity<ErrorResponse> handleInvalidVinException(InvalidVinException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(ErrorCodes.INVALID_VIN, e.getMessage()));
    }
    @ExceptionHandler(InvalidResponseFromNHTSAException.class)
    public ResponseEntity<ErrorResponse> handleInvalidResponseFromNHTSAException(InvalidResponseFromNHTSAException e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErrorResponse(ErrorCodes.INVALID_NHTSA_RESPONSE, e.getMessage()));
    }
}
