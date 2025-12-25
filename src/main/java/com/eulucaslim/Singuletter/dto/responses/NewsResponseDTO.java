package com.eulucaslim.Singuletter.dto.responses;

import com.eulucaslim.Singuletter.entity.Category;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;

public record NewsResponseDTO(
        Long id,
        String title,
        String content,
        Category category,
        @JsonProperty("created_at")
        Instant createdAt

) {}
