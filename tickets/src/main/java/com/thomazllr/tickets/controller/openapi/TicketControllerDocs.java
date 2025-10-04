package com.thomazllr.tickets.controller.openapi;

import com.thomazllr.tickets.controller.dto.TicketRequest;
import com.thomazllr.tickets.controller.dto.response.TicketDashboardResponse;
import com.thomazllr.tickets.controller.dto.response.TicketResponse;
import com.thomazllr.tickets.controller.handler.Problem;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

@Tag(name = "Tickets", description = "Ticket management and statistics")
public interface TicketControllerDocs {

    @Operation(
            summary = "Create a new ticket",
            description = "Receives the ticket data, validates it, and saves it to the database.",
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Ticket successfully created",
                            content = @Content(schema = @Schema(implementation = TicketResponse.class))
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Validation error or invalid input data",
                            content = @Content(schema = @Schema(implementation = Problem.class))
                    )
            }
    )
    ResponseEntity<TicketResponse> save(
            @RequestBody(
                    required = true,
                    description = "Ticket creation data",
                    content = @Content(schema = @Schema(implementation = TicketRequest.class))
            )
            TicketRequest request
    );

    @Operation(
            summary = "Retrieve ticket statistics",
            description = "Returns ticket statistics and grouped information filtered by year and month.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Statistics successfully retrieved",
                            content = @Content(schema = @Schema(implementation = TicketDashboardResponse.class))
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Invalid parameters or input data",
                            content = @Content(schema = @Schema(ref = "#/components/schemas/Problem"))
                    )
            }
    )
    ResponseEntity<TicketDashboardResponse> findAll(
            @Parameter(description = "Reference year (default: current year)", example = "2025") Integer year,
            @Parameter(description = "Reference month (default: current month)", example = "10") Integer month
    );
}
