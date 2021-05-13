package com.accenture.sats.server.response;

import com.accenture.sats.server.exception.AttendanceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ErrorResponseHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleAttendanceException(AttendanceException e, WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse();
        HttpStatus httpStatus = null;


        if (e.getMessage() == AttendanceException.NO_TIMED_IN) {
            errorResponse.setError(HttpStatus.NOT_FOUND.getReasonPhrase());
            errorResponse.setMessage(e.getMessage());
            errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
            errorResponse.setTimestamp(LocalDateTime.now());

            httpStatus = HttpStatus.NOT_FOUND;
        } else {
            errorResponse.setError(HttpStatus.CONFLICT.getReasonPhrase());
            errorResponse.setMessage(e.getMessage());
            errorResponse.setStatus(HttpStatus.CONFLICT.value());
            errorResponse.setTimestamp(LocalDateTime.now());

            httpStatus = HttpStatus.CONFLICT;
        }

        return new ResponseEntity<>(errorResponse, httpStatus);
    }
}
