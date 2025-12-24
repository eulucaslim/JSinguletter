package com.eulucaslim.Singuletter.dto.responses;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record UserResponseDTO(
        @NotEmpty
        Long id,
        @NotNull
        String username,
        @Email
        String email
) {}
