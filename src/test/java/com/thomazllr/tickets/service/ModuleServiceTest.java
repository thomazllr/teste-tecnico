package com.thomazllr.tickets.service;

import com.thomazllr.tickets.commons.ModuleUtils;
import com.thomazllr.tickets.exception.InvalidModuleInputException;
import com.thomazllr.tickets.model.Module;
import com.thomazllr.tickets.repository.ModuleRepository;
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
class ModuleServiceTest {

    @Mock
    private ModuleRepository moduleRepository;

    @InjectMocks
    private ModuleService moduleService;

    private ModuleUtils moduleUtils;

    @BeforeEach
    void setUp() {
        moduleUtils = new ModuleUtils();
    }


    @Test
    @Order(1)
    @DisplayName("findByIdOrThrowBadRequest returns module when successful")
    void findByIdOrThrowBadRequest_ReturnsModule_WhenSuccessful() {
        Module expectedModule = moduleUtils.createModule();

        BDDMockito.given(moduleRepository.findById(expectedModule.getId()))
                .willReturn(Optional.of(expectedModule));

        Module foundModule = moduleService.findByIdOrThrowBadRequest(expectedModule.getId());

        assertThat(foundModule).isNotNull();
        assertThat(foundModule.getId()).isEqualTo(expectedModule.getId());
        assertThat(foundModule.getName()).isEqualTo(expectedModule.getName());
    }

    @Test
    @Order(2)
    @DisplayName("findByIdOrThrowBadRequest throws InvalidModuleInputException when module is not found")
    void findByIdOrThrowBadRequest_ThrowsInvalidModuleInputException_WhenModuleIsNotFound() {
        Long invalidId = 999L;

        BDDMockito.given(moduleRepository.findById(invalidId))
                .willReturn(Optional.empty());

        assertThatThrownBy(() -> moduleService.findByIdOrThrowBadRequest(invalidId))
                .isInstanceOf(InvalidModuleInputException.class);
    }
}