package com.thomazllr.tickets.controller.handler;

import lombok.Getter;

@Getter
public enum ProblemType {

    INVALID_DATA("/invalid-data", "Invalid data"),
    RESOURCE_NOT_FOUND("/resource-not-found", "Resource not found"),
    BUSINESS_ERROR("/business-error", "Business rule violation"),
    INVALID_PARAMETER("/invalid-parameter", "Invalid parameter");

    private String title;
    private String uri;

    ProblemType(String path, String title) {
        this.uri = "https://api.chamados.com" + path;
        this.title = title;
    }
}
