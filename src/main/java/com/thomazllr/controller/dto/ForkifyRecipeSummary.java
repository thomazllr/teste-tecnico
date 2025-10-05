package com.thomazllr.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ForkifyRecipeSummary {
    private String publisher;
    private String title;

    @JsonProperty("source_url")
    private String sourceUrl;

    @JsonProperty("recipe_id")
    private String recipeId;

    @JsonProperty("image_url")
    private String imageUrl;

    @JsonProperty("social_rank")
    private Double socialRank;

    @JsonProperty("publisher_url")
    private String publisherUrl;
}