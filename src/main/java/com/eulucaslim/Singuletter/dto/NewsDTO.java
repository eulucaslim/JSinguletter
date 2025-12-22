package com.eulucaslim.Singuletter.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record NewsDTO(
        Long id,
        String title,
        String content,
        @JsonProperty("category_name")
        String categoryName
) {}
