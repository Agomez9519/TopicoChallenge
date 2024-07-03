package com.challenge.api.rest_challenge.controller;

import com.challenge.api.rest_challenge.dto.IngresarTopicoDTO;
import com.challenge.api.rest_challenge.dto.TopicoDTO;
import com.challenge.api.rest_challenge.model.Topico;
import com.challenge.api.rest_challenge.repository.CursoRepository;
import com.challenge.api.rest_challenge.repository.UsuarioRepository;
import com.challenge.api.rest_challenge.service.TopicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoService topicoService;


    @GetMapping()
    public List<TopicoDTO> obtenerTopicos(){
        return topicoService.obtenerTodosLosTopicos();
    }

    @PostMapping
    public ResponseEntity<TopicoDTO> registrarTopico(@RequestBody @Valid IngresarTopicoDTO topicoDTO, UriComponentsBuilder uriComponentsBuilder){
        var topicoGuardado = topicoService.agregarTopico(topicoDTO);
        TopicoDTO respuestaDto = new TopicoDTO(topicoGuardado.getUsuario().getId(),topicoGuardado.getTitulo(),topicoGuardado.getMensaje(),topicoGuardado.getFechaCreacion());
        URI url = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topicoGuardado.getId()).toUri();
        return ResponseEntity.created(url).body(respuestaDto);
    }
}
