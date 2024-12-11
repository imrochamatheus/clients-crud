package com.imrochamatheus.clients_crud.dto;

import java.time.Instant;

public class ValidationApiError extends ApiError {
    private 


    public ValidationApiError(
            Instant timestamp,
            Integer status,
            String error,
            String path

    ) {
        super(timestamp, status, error, path);


    }
}
