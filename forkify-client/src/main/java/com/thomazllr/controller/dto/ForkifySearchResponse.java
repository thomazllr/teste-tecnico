package com.thomazllr.controller.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ForkifySearchResponse {
    private Integer count;
    private List<ForkifyRecipeSummary> recipes;
}
