package com.challenge.api.rest_challenge.dto;

import java.time.LocalDate;

public record RespuestaTopicoDTO (String titulo, String mensaje, LocalDate fecha, Boolean estado, String autor, String curso){
}
