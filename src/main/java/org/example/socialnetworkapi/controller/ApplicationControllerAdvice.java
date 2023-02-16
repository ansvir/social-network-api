package org.example.socialnetworkapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.reactive.result.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Controller for handling generic API exceptions
 *
 * @since 0.0.1-SNAPSHOT
 */
@RestControllerAdvice
public class ApplicationControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Object> handleRuntimeException(RuntimeException ex) {
        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", "Unknown error occurred in runtime. Message: " + ex.getMessage()
                + ". Stacktrace: " + Arrays.stream(ex.getStackTrace())
                .map(StackTraceElement::toString)
                .collect(Collectors.joining("\n")));
        return new ResponseEntity<>(body, HttpStatus.OK);
    }

}
