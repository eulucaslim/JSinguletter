package com.eulucaslim.Singuletter.dto.requests;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record LoginUserRequestDTO(
        @NotNull
        @NotEmpty
        String username,
        @NotEmpty
        @NotNull
        String password
) {}
