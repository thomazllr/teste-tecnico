package com.thomazllr.tickets.controller.dto.response;

import com.thomazllr.tickets.model.Client;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ClientDashboardResponse {
    private Long id;
    private String name;
    private Long totalTickets;

    public static ClientDashboardResponse from(Client client, long totalTickets) {
        return ClientDashboardResponse.builder()
                .id(client.getId())
                .name(client.getName())
                .totalTickets(totalTickets)
                .build();
    }

}
