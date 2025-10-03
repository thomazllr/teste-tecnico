package com.thomazllr.tickets.controller;

import com.thomazllr.tickets.controller.dto.response.TicketDashboardResponse;
import com.thomazllr.tickets.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/tickets")
@RequiredArgsConstructor
public class TicketController {

    private final TicketService service;

    @GetMapping
    public ResponseEntity<TicketDashboardResponse> findAll() {
        var ticketsDashboardStats = service.getDashboardStats();
        return ResponseEntity.ok(ticketsDashboardStats);
    }
}
