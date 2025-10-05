package com.thomazllr.tickets.service;

import com.thomazllr.tickets.commons.ClientUtils;
import com.thomazllr.tickets.exception.InvalidClientInputException;
import com.thomazllr.tickets.model.Client;
import com.thomazllr.tickets.repository.ClientRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ClientServiceTest {

    @Mock
    private ClientRepository clientRepository;

    @InjectMocks
    private ClientService clientService;

    private ClientUtils clientUtils;

    @BeforeEach
    void setUp() {
        clientUtils = new ClientUtils();
    }

    @Test
    @Order(1)
    @DisplayName("findByIdOrThrowBadRequest returns client when successful")
    void findByIdOrThrowBadRequest_ReturnsClient_WhenSuccessful() {
        Client expectedClient = clientUtils.createClient();

        BDDMockito.given(clientRepository.findById(expectedClient.getId()))
                .willReturn(Optional.of(expectedClient));

        Client foundClient = clientService.findByIdOrThrowBadRequest(expectedClient.getId());

        assertThat(foundClient).isNotNull();
        assertThat(foundClient.getId()).isEqualTo(expectedClient.getId());
        assertThat(foundClient.getName()).isEqualTo(expectedClient.getName());
    }

    @Test
    @Order(2)
    @DisplayName("findByIdOrThrowBadRequest throws InvalidClientInputException when client is not found")
    void findByIdOrThrowBadRequest_ThrowsInvalidClientInputException_WhenClientIsNotFound() {
        Long invalidId = 999L;

        BDDMockito.given(clientRepository.findById(invalidId))
                .willReturn(Optional.empty());

        assertThatThrownBy(() -> clientService.findByIdOrThrowBadRequest(invalidId))
                .isInstanceOf(InvalidClientInputException.class);
    }

}