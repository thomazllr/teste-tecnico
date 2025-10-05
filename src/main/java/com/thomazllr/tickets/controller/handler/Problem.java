package com.thomazllr.tickets.controller.handler;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.List;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Schema(
        name = "Problem",
        description = "Standard error response body following RFC 7807"
)
@JsonInclude(NON_NULL)
@Getter
@Setter
@Builder
public class Problem {

    @Schema(description = "HTTP Status code", example = "400")
    private Integer status;

    @Schema(description = "URI identifier for the problem type", example = "https://api.chamados.com/business-error")
    private String type;

    @Schema(description = "Human-readable title of the error type", example = "Business rule violation")
    private String title;

    @Schema(description = "Detailed explanation of the error", example = "Cannot create ticket: client 5 does not exist.")
    private String detail;

    @Schema(description = "User-friendly message for display", example = "The client you selected could not be found.")
    private String userMessage;

    @Schema(description = "Timestamp", example = "2025-10-04T01:23:45Z")
    private OffsetDateTime timestamp;

    @Schema(description = "List of validation errors (if any)")
    private List<Object> objects;

    @Builder
    @Getter
    public static class Object {

        @Schema(description = "Field name", example = "clientId")
        private String name;

        @Schema(description = "Validation message for the field", example = "Client ID is required")
        private String userMessage;

    }
}