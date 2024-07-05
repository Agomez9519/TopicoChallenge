package com.challenge.api.rest_challenge.dto;

import com.challenge.api.rest_challenge.model.Topico;

import java.time.LocalDate;

public record TopicoDTO(Long idUsuario , String titulo, String mensaje, LocalDate fechaCreacion ) {

    public TopicoDTO(Topico topico){
        this(topico.getUsuario().getId(),topico.getTitulo(), topico.getMensaje(), LocalDate.now());
    }
}
