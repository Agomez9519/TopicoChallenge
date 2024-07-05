package com.challenge.api.rest_challenge.service;

import com.challenge.api.rest_challenge.dto.ActualizarTopicoDTO;
import com.challenge.api.rest_challenge.dto.IngresarTopicoDTO;
import com.challenge.api.rest_challenge.dto.RespuestaTopicoDTO;
import com.challenge.api.rest_challenge.dto.TopicoDTO;
import com.challenge.api.rest_challenge.model.Curso;
import com.challenge.api.rest_challenge.model.Topico;
import com.challenge.api.rest_challenge.model.Usuario;
import com.challenge.api.rest_challenge.repository.CursoRepository;
import com.challenge.api.rest_challenge.repository.TopicoRepository;
import com.challenge.api.rest_challenge.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    //se convierte el objeto Page con los topicos a un Page de TopicoDTO el cual el controlador pedira
    // El parametro paginacion formateara nuestra respuesta con del payload de respuesta predefinido de la clase Pageable
    public Page<TopicoDTO> obtenerTopicosActivos(Pageable paginacion){
        //Devuelve un objeto Page cambiando el tipo de Clase de Topico a un Record TopicoDTO
        return topicoRepository.findByStatusTrue(paginacion).map(TopicoDTO::new);
    }

    public RespuestaTopicoDTO obtenerTopico(Long id){
        Topico topico = topicoRepository.findById(id).get();
        Curso curso = cursoRepository.findById(topico.getCurso().getId()).get();
        Usuario usuario = usuarioRepository.findById(topico.getUsuario().getId()).get();

        RespuestaTopicoDTO respuesta = new RespuestaTopicoDTO(topico.getTitulo(),topico.getMensaje(),topico.getFechaCreacion(),topico.getStatus(),usuario.getNombre(),curso.getNombre());

        return respuesta;
    }

    public TopicoDTO actualizarTopico(ActualizarTopicoDTO actualizarTopicoDTO,Long id){
      Topico topico = topicoRepository.findById(id).get();

        if (topico !=null) {
            topico.actualizarTopico(actualizarTopicoDTO);
            return new TopicoDTO(topico.getUsuario().getId(),topico.getTitulo(),topico.getMensaje(),topico.getFechaCreacion());
        }

        return null;
    }

    public void eliminarLogicoMedico(Long id){
        Topico topico = topicoRepository.findById(id).get();
        topico.desactivarTopico();
    }



//    public List<TopicoDTO> obtenerTodosLosTopicos(){
//        return convertirDatos(topicoRepository.findAll());
//    }

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
