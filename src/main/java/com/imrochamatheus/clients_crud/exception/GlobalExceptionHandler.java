package com.imrochamatheus.clients_crud.exception;

import com.imrochamatheus.clients_crud.dto.ApiError;
import com.imrochamatheus.clients_crud.dto.ApiValidationError;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = ResourceNotFoundException.class)
    public ResponseEntity<ApiError> handleResourceNotFound(
            ResourceNotFoundException ex,
            HttpServletRequest httpServletRequest
    ) {
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        ApiError apiError = new ApiError(
                Instant.now(),
                httpStatus.value(),
                ex.getMessage(),
                httpServletRequest.getRequestURI()
        );

        return ResponseEntity.status(httpStatus).body(apiError);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpServletRequest httpServletRequest
    ) {

        Map<String, List<String>> errors = ex.getBindingResult().getFieldErrors()
                .stream()
                .collect(Collectors.toMap(
                        FieldError::getField,
                        fieldError -> new ArrayList<>(List.of(fieldError.getDefaultMessage())),
                        (existing, replacement) -> {
                            existing.addAll(replacement);
                            return existing;
                        }
                ));

        ApiValidationError apiValidationError = new ApiValidationError(
                Instant.now(),
                HttpStatus.UNPROCESSABLE_ENTITY.value(),
                "Validation error!",
                httpServletRequest.getRequestURI(),
                errors
        );

        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(apiValidationError);
    }
}
