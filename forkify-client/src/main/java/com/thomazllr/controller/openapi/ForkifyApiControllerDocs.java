package com.thomazllr.controller.openapi;

import com.thomazllr.controller.dto.ForkifySearchResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@Tag(name = "Forkify API", description = "Endpoints para buscar receitas usando a API Forkify")
public interface ForkifyApiControllerDocs {

    @GetMapping
    @Operation(
            summary = "Find recipes",
            description = "Perform a recipe search on the Forkify API based on a query"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Search with success",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ForkifySearchResponse.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Invalid Parameters",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Internal Server Error",
                    content = @Content
            )
    })
    ResponseEntity<ForkifySearchResponse> search(
            @Parameter(description = "Termo de busca para receitas", example = "pizza", required = true)
            String query);
}