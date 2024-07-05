package com.challenge.api.rest_challenge.dto;

import jakarta.validation.constraints.NotNull;

public record ActualizarTopicoDTO( @NotNull String titulo, @ NotNull String mensaje) {
}
