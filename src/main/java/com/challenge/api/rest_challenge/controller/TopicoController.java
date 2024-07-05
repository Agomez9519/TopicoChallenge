package com.challenge.api.rest_challenge.controller;

import com.challenge.api.rest_challenge.dto.ActualizarTopicoDTO;
import com.challenge.api.rest_challenge.dto.IngresarTopicoDTO;
import com.challenge.api.rest_challenge.dto.RespuestaTopicoDTO;
import com.challenge.api.rest_challenge.dto.TopicoDTO;
import com.challenge.api.rest_challenge.model.Topico;
import com.challenge.api.rest_challenge.repository.CursoRepository;
import com.challenge.api.rest_challenge.repository.UsuarioRepository;
import com.challenge.api.rest_challenge.service.TopicoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
    public ResponseEntity<Page<TopicoDTO>> obtenerTopicos(@PageableDefault(size = 5) Pageable paginacion){
        return ResponseEntity.ok(topicoService.obtenerTopicosActivos(paginacion));
    }

    @PostMapping
    public ResponseEntity<TopicoDTO> registrarTopico(@RequestBody @Valid IngresarTopicoDTO topicoDTO, UriComponentsBuilder uriComponentsBuilder){
        var topicoGuardado = topicoService.agregarTopico(topicoDTO);
        TopicoDTO respuestaDto = new TopicoDTO(topicoGuardado.getUsuario().getId(),topicoGuardado.getTitulo(),topicoGuardado.getMensaje(),topicoGuardado.getFechaCreacion());
        URI url = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topicoGuardado.getId()).toUri();
        return ResponseEntity.created(url).body(respuestaDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RespuestaTopicoDTO> retornarDatosTopicoPorId(@PathVariable Long id){
           RespuestaTopicoDTO respuesta = topicoService.obtenerTopico(id);
            return ResponseEntity.ok(respuesta);

    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity actualizarTopico(@RequestBody @Valid ActualizarTopicoDTO actualizarTopico, @PathVariable Long id){
            return ResponseEntity.ok(topicoService.actualizarTopico(actualizarTopico,id));
    }

    //Delete logico
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarMedico(@PathVariable Long id){
        topicoService.eliminarLogicoMedico(id);
        return ResponseEntity.noContent().build();
    }
}
