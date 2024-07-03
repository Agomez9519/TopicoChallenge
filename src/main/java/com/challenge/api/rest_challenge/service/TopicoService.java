package com.challenge.api.rest_challenge.service;

import com.challenge.api.rest_challenge.dto.IngresarTopicoDTO;
import com.challenge.api.rest_challenge.dto.TopicoDTO;
import com.challenge.api.rest_challenge.model.Topico;
import com.challenge.api.rest_challenge.repository.CursoRepository;
import com.challenge.api.rest_challenge.repository.TopicoRepository;
import com.challenge.api.rest_challenge.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;


    public List<TopicoDTO> obtenerTodosLosTopicos(){
        return convertirDatos(topicoRepository.findAll());
    }

    public List<TopicoDTO> convertirDatos(List<Topico> topico){
        return topico.stream()
                .map(t -> new TopicoDTO( t.getUsuario().getId(), t.getTitulo(), t.getMensaje(),t.getFechaCreacion())).collect(Collectors.toList());
    }


    public Topico agregarTopico(IngresarTopicoDTO topicoDTO){
        var curso = cursoRepository.findById(topicoDTO.idCurso()).get();
        var usuario = usuarioRepository.findById(topicoDTO.idUsuario()).get();

        var topico = new Topico(topicoDTO);
        topico.setCurso(curso);
        topico.setUsuario(usuario);

        topicoRepository.save(topico);

        return topico;
    }

}
