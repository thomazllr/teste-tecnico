package com.thomazllr.tickets.controller;

import com.thomazllr.tickets.controller.dto.TicketRequest;
import com.thomazllr.tickets.controller.dto.response.TicketDashboardResponse;
import com.thomazllr.tickets.controller.dto.response.TicketResponse;
import com.thomazllr.tickets.service.TicketService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/v1/tickets")
@RequiredArgsConstructor
public class TicketController {

    private final TicketService service;

    @PostMapping
    public ResponseEntity<TicketResponse> save(@RequestBody @Valid TicketRequest request) {
        var ticket = request.toEntity();
        ticket = service.save(ticket);
        var response = TicketResponse.toResponse(ticket);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


    @GetMapping
    public ResponseEntity<TicketDashboardResponse> findAll(@RequestParam(required = false) Integer year,
                                                           @RequestParam(required = false) Integer month) {

        LocalDate now = LocalDate.now();
        year = year != null ? year : now.getYear();
        month = month != null ? month : now.getMonthValue();

        var ticketsDashboardStats = service.getDashboardStats(year, month);
        return ResponseEntity.ok(ticketsDashboardStats);
    }
}
