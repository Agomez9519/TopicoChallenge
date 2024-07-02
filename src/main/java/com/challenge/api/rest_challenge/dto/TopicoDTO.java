package com.challenge.api.rest_challenge.dto;

import java.time.LocalDate;

public record TopicoDTO(Long idUsuario , String titulo, String mensaje, LocalDate fechaCreacion ) {
}
