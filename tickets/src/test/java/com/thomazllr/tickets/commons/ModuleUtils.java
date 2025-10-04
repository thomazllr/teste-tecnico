package com.thomazllr.tickets.commons;

import com.thomazllr.tickets.model.Module;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ModuleUtils {

    public Module createModule() {
        return Module.builder()
                .id(1L)
                .name("Module X")
                .build();
    }

    public List<Module> createModules() {
        var module1 = Module.builder().id(1L).name("Module X").build();
        var module2 = Module.builder().id(2L).name("Module Y").build();
        var module3 = Module.builder().id(3L).name("Module Z").build();
        return new ArrayList<>(List.of(module1, module2, module3));
    }
}