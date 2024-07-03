package com.challenge.api.rest_challenge.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Table(name = "respuestas")
@Entity(name = "Respuesta")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Respuesta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mensaje;

    @Column(name = "fecha")
    private LocalDate fechaCreacion;


    @ManyToOne
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_topico")
    private Topico topico;



}
