package com.thomazllr.tickets.service;

import com.thomazllr.tickets.commons.TicketUtils;
import com.thomazllr.tickets.controller.dto.response.TicketDashboardResponse;
import com.thomazllr.tickets.exception.InvalidClientInputException;
import com.thomazllr.tickets.exception.InvalidModuleInputException;
import com.thomazllr.tickets.model.Client;
import com.thomazllr.tickets.model.Module;
import com.thomazllr.tickets.model.Ticket;
import com.thomazllr.tickets.repository.TicketRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TicketServiceTest {

    @Mock
    private TicketRepository ticketRepository;

    @Mock
    private ClientService clientService;

    @Mock
    private ModuleService moduleService;

    @InjectMocks
    private TicketService ticketService;

    private TicketUtils ticketUtils;

    private List<Ticket> ticketsList;

    @BeforeEach
    void setup() {
        ticketUtils = new TicketUtils();
        ticketsList = ticketUtils.createTickets();
    }

    @Test
    @Order(1)
    @DisplayName("getDashboardStats returns the correct ticket dashboard response when data is provided")
    void getDashboardStats_ReturnsCorrectTicketDashboardResponse_WhenDataIsProvided() {
        Integer year = 2025;
        Integer month = 10;

        BDDMockito.given(ticketRepository.findAllByMonthAndYear(
                LocalDate.of(year, month, 1),
                LocalDate.of(year, month, LocalDate.of(year, month, 1).lengthOfMonth())
        )).willReturn(ticketsList);

        TicketDashboardResponse dashboardResponse = ticketService.getDashboardStats(year, month);

        assertThat(dashboardResponse).isNotNull();

        assertThat(dashboardResponse.getTickets())
                .isNotNull()
                .hasSize(2);

        assertThat(dashboardResponse.getClients())
                .isNotNull()
                .hasSize(2);

        assertThat(dashboardResponse.getModules())
                .isNotNull()
                .hasSize(2);
    }

    @Test
    @Order(2)
    @DisplayName("save returns ticket when successful")
    void save_ReturnsTicket_WhenSuccessful() {
        Ticket ticketToBeSaved = ticketUtils.createTicket();
        ticketToBeSaved.setId(null);
        ticketToBeSaved.setOpeningDate(null);

        Client client = ticketToBeSaved.getClient();
        Module module = ticketToBeSaved.getModule();

        BDDMockito.given(clientService.findByIdOrThrowBadRequest(client.getId()))
                .willReturn(client);

        BDDMockito.given(moduleService.findByIdOrThrowBadRequest(module.getId()))
                .willReturn(module);

        BDDMockito.given(ticketRepository.save(BDDMockito.any(Ticket.class)))
                .willReturn(ticketToBeSaved);

        Ticket savedTicket = ticketService.save(ticketToBeSaved);

        assertThat(savedTicket).isNotNull();
        assertThat(savedTicket.getClient()).isEqualTo(client);
        assertThat(savedTicket.getModule()).isEqualTo(module);
        assertThat(savedTicket.getOpeningDate()).isNotNull();
    }

    @Test
    @Order(3)
    @DisplayName("save throws InvalidClientInputException when client does not exist")
    void save_ThrowsInvalidClientInputException_WhenClientDoesNotExist() {
        Ticket ticketToBeSaved = ticketUtils.createTicket();
        Long invalidClientId = 999L;
        ticketToBeSaved.getClient().setId(invalidClientId);

        BDDMockito.given(clientService.findByIdOrThrowBadRequest(invalidClientId))
                .willThrow(new InvalidClientInputException(invalidClientId));

        assertThatThrownBy(() -> ticketService.save(ticketToBeSaved))
                .isInstanceOf(InvalidClientInputException.class)
                .hasMessageContaining("Cannot create ticket: client '999' is invalid or does not exist.");

        BDDMockito.verify(moduleService, BDDMockito.never())
                .findByIdOrThrowBadRequest(BDDMockito.anyLong());
        BDDMockito.verify(ticketRepository, BDDMockito.never())
                .save(BDDMockito.any(Ticket.class));
    }

    @Test
    @Order(4)
    @DisplayName("save throws InvalidModuleInputException when module does not exist")
    void save_ThrowsInvalidModuleInputException_WhenModuleDoesNotExist() {
        Ticket ticketToBeSaved = ticketUtils.createTicket();
        Long invalidModuleId = 999L;
        ticketToBeSaved.getModule().setId(invalidModuleId);

        Client client = ticketToBeSaved.getClient();

        BDDMockito.given(clientService.findByIdOrThrowBadRequest(client.getId()))
                .willReturn(client);

        BDDMockito.given(moduleService.findByIdOrThrowBadRequest(invalidModuleId))
                .willThrow(new InvalidModuleInputException(invalidModuleId));

        assertThatThrownBy(() -> ticketService.save(ticketToBeSaved))
                .isInstanceOf(InvalidModuleInputException.class)
                .hasMessageContaining("Cannot create ticket: module '999' is invalid or does not exist.");

        BDDMockito.verify(ticketRepository, BDDMockito.never())
                .save(BDDMockito.any(Ticket.class));
    }
}