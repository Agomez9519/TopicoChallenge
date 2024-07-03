package com.challenge.api.rest_challenge.repository;

import com.challenge.api.rest_challenge.model.Curso;
import com.challenge.api.rest_challenge.model.Topico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso,Long> {
}
