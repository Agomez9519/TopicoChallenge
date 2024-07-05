package com.challenge.api.rest_challenge.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record IngresarTopicoDTO(@NotBlank String titulo, @NotBlank String mensaje, @NotNull Long idUsuario, @NotNull Long idCurso ) {
}
