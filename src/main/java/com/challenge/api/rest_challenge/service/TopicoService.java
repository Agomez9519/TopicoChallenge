package com.challenge.api.rest_challenge.service;

import com.challenge.api.rest_challenge.dto.TopicoDTO;
import com.challenge.api.rest_challenge.model.Topico;
import com.challenge.api.rest_challenge.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository topicoRepository;

    public List<TopicoDTO> obtenerTodosLosTopicos(){
        return convertirDatos(topicoRepository.findAll());
    }

    public List<TopicoDTO> convertirDatos(List<Topico> topico){
        return topico.stream()
                .map(t -> new TopicoDTO( t.getUsuario().getId(), t.getTitulo(), t.getMensaje(),t.getFechaCreacion())).collect(Collectors.toList());
    }

}
