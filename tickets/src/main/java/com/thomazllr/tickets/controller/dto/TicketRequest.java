package com.thomazllr.tickets.controller.dto;

import com.thomazllr.tickets.model.Client;
import com.thomazllr.tickets.model.Module;
import com.thomazllr.tickets.model.Ticket;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class TicketRequest {
    @NotBlank(message = "Title is required")
    private String title;

    @NotNull(message = "Client ID is required")
    private Long clientId;

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
