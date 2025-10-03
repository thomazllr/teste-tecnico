package com.thomazllr.tickets.service;

import com.thomazllr.tickets.exception.ModuleNotFoundException;
import com.thomazllr.tickets.model.Module;
import com.thomazllr.tickets.repository.ModuleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ModuleService {

    private final ModuleRepository repository;

    public Module findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ModuleNotFoundException(id));
    }
}
