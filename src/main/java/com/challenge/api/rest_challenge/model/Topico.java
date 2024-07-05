package com.challenge.api.rest_challenge.model;

import com.challenge.api.rest_challenge.dto.ActualizarTopicoDTO;
import com.challenge.api.rest_challenge.dto.IngresarTopicoDTO;
import com.challenge.api.rest_challenge.dto.TopicoDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String mensaje;

    @Column(name = "fecha")
    private LocalDate fechaCreacion;

    private Boolean status;


    @ManyToOne
    @JoinColumn(name = "id_curso")
    private Curso curso;


    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;


    @OneToMany(mappedBy = "topico", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Respuesta> respuestas;


    public Topico(IngresarTopicoDTO topicoDTO) {
        this.titulo = topicoDTO.titulo();
        this.mensaje = topicoDTO.mensaje();
        this.fechaCreacion = LocalDate.now();
        this.status = true;
        this.curso = null;
        this.usuario=null;
    }

    public List<Respuesta> getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(List<Respuesta> respuestas) {
        this.respuestas = respuestas;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public void desactivarTopico(){
        this.status = false;
    }
    
    public void actualizarTopico(ActualizarTopicoDTO topicoActualizar){
        if (topicoActualizar.titulo() != null) {
            this.titulo = topicoActualizar.titulo();
        }

        if (topicoActualizar.mensaje() != null) {
            this.mensaje = topicoActualizar.mensaje();
        }

    }
}
