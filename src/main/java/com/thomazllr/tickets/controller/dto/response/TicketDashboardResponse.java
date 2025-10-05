package com.thomazllr.tickets.controller.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class TicketDashboardResponse {

    private List<TicketResponse> tickets;
    private List<ClientDashboardResponse> clients;
    private List<ModuleDashboardResponse> modules;
}
