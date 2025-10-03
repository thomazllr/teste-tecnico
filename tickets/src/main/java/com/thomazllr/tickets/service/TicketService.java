package com.thomazllr.tickets.service;

import com.thomazllr.tickets.controller.dto.response.ClientDashboardResponse;
import com.thomazllr.tickets.controller.dto.response.ModuleDashboardResponse;
import com.thomazllr.tickets.controller.dto.response.TicketDashboardResponse;
import com.thomazllr.tickets.controller.dto.response.TicketResponse;
import com.thomazllr.tickets.model.Ticket;
import com.thomazllr.tickets.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TicketService {

    private final TicketRepository repository;

    private final ClientService clientService;
    private final ModuleService moduleService;

    @Transactional
    public Ticket save(Ticket ticket) {
        var client = clientService.findById(ticket.getClient().getId());
        var module = moduleService.findById(ticket.getModule().getId());
        ticket.setClient(client);
        ticket.setModule(module);
        ticket.setOpeningDate(LocalDate.now());
        return repository.save(ticket);
    }

    public TicketDashboardResponse getDashboardStats(Integer year, Integer month) {

        LocalDate startDate = LocalDate.of(year, month, 1);
        LocalDate endDate = LocalDate.of(year, month, startDate.lengthOfMonth());

        var tickets = repository.findAllByMonthAndYear(startDate, endDate);

        var ticketsResponse = toTicketResponse(tickets);
        var clientsResponse = summarizeTicketsByClient(tickets);
        var modulesResponse = summarizeTicketsByModule(tickets);

        return TicketDashboardResponse.builder()
                .tickets(ticketsResponse)
                .clients(clientsResponse)
                .modules(modulesResponse)
                .build();
    }

    private List<TicketResponse> toTicketResponse(List<Ticket> tickets) {
        return tickets.stream()
                .map(TicketResponse::toResponse)
                .toList();
    }

    private List<ClientDashboardResponse> summarizeTicketsByClient(List<Ticket> tickets) {
        return tickets.stream()
                .collect(Collectors.groupingBy(Ticket::getClient, Collectors.counting()))
                .entrySet().stream()
                .map(entry -> ClientDashboardResponse.from(entry.getKey(), entry.getValue()))
                .toList();
    }

    private List<ModuleDashboardResponse> summarizeTicketsByModule(List<Ticket> tickets) {
        return tickets.stream()
                .collect(Collectors.groupingBy(Ticket::getModule, Collectors.counting()))
                .entrySet().stream()
                .map(entry -> ModuleDashboardResponse.from(entry.getKey(), entry.getValue()))
                .toList();
    }


}
