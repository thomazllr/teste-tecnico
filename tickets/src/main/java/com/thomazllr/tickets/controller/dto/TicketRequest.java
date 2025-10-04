package com.thomazllr.tickets.controller.dto;

import com.thomazllr.tickets.model.Client;
import com.thomazllr.tickets.model.Module;
import com.thomazllr.tickets.model.Ticket;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class TicketRequest {

    @Schema(description = "Error accessing the reports module", example = "Error accessing the reports module")
    @NotBlank(message = "Title is required")
    private String title;

    @Schema(description = "ID of the client who created the ticket", example = "1")
    @NotNull(message = "Client ID is required")
    private Long clientId;

    @Schema(description = "ID of the module associated with the ticket", example = "3")
    @NotNull(message = "Module ID is required")
    private Long moduleId;

    public Ticket toEntity() {

        Client client = new Client(clientId);
        Module module = new Module(moduleId);

        return Ticket.builder()
                .title(title)
                .client(client)
                .module(module)
                .build();
    }
}
