package com.thomazllr.tickets.controller.dto.response;

import com.thomazllr.tickets.model.Module;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ModuleDashboardResponse {
    private Long id;
    private String name;
    private Long totalTickets;

    public static ModuleDashboardResponse from(Module module, long totalTickets) {
        return ModuleDashboardResponse.builder()
                .id(module.getId())
                .name(module.getName())
                .totalTickets(totalTickets)
                .build();
    }
}
