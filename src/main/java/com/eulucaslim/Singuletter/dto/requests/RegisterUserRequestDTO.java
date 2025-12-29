package com.eulucaslim.Singuletter.dto.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record RegisterUserRequestDTO(
        @NotNull
        @NotEmpty
        String username,
        @NotEmpty
        @NotNull
        String password,
        @NotEmpty
        @Email
        String email
) {}
