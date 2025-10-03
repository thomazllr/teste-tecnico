package com.thomazllr.tickets.controller.dto.response;

import com.thomazllr.tickets.model.Ticket;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class TicketResponse {
    private Long id;
    private String title;
    private String clientName;
    private String moduleName;
    private String openingDate;
    private String closingDate;

    public static TicketResponse toResponse(Ticket ticket) {
        return TicketResponse.builder()
                .id(ticket.getId())
                .title(ticket.getTitle())
                .clientName(ticket.getClient().getName())
                .moduleName(ticket.getModule().getName())
                .openingDate(ticket.getOpeningDate().toString())
                .closingDate(ticket.getClosingDate().toString())
                .build();
    }
}
