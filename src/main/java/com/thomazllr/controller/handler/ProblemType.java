package com.thomazllr.controller.handler;

import lombok.Getter;

@Getter
public enum ProblemType {

    RESOURCE_NOT_FOUND("/resource-not-found", "Resource not found"),
    BUSINESS_ERROR("/business-error", "Business rule violation");

    private String title;
    private String uri;

    ProblemType(String path, String title) {
        this.uri = "https://forkify-client.com" + path;
        this.title = title;
    }
}