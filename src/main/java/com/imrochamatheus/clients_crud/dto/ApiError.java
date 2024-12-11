package com.imrochamatheus.clients_crud.dto;

import java.time.Instant;

public class ApiError {

    private Integer status;
    private String error;
    private String path;
    private Instant timestamp;

    public ApiError(Instant timestamp, Integer status, String error, String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.path = path;
    }

    public Integer getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public String getPath() {
        return path;
    }

    public Instant getTimestamp() {
        return timestamp;
    }
}
