package com.thomazllr.tickets.service;

import com.thomazllr.tickets.exception.InvalidModuleInputException;
import com.thomazllr.tickets.exception.ModuleNotFoundExceptionException;
import com.thomazllr.tickets.model.Module;
import com.thomazllr.tickets.repository.ModuleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ModuleService {

    private final ModuleRepository repository;

    public Module findByIdOrThrowNotFound(Long id) {
        return repository.findById(id).orElseThrow(() -> new ModuleNotFoundExceptionException(id));
    }

    public Module findByIdOrThrowBadRequest(Long id) {
        return repository.findById(id).orElseThrow(() -> new InvalidModuleInputException(id));
    }
}
