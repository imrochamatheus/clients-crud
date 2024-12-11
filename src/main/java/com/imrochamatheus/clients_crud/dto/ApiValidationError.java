package com.imrochamatheus.clients_crud.dto;

import java.time.Instant;
import java.util.List;
import java.util.Map;

public class ApiValidationError extends ApiError {

    private Map<String, List<String>> errors;

    public ApiValidationError(
            Instant timestamp,
            Integer status,
            String error,
            String path,
            Map<String, List<String>> errors
    ) {
        super(timestamp, status, error, path);
        this.errors = errors;
    }

    public Map<String, List<String>> getErrors() {
        return errors;
    }
}
