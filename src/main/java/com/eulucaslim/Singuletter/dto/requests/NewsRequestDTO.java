package com.eulucaslim.Singuletter.dto.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

public record NewsRequestDTO (
        String title,
        String content,
        @JsonProperty("category_name")
        String categoryName
) {}