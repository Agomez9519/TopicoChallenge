package com.challenge.api.rest_challenge.repository;

import com.challenge.api.rest_challenge.model.Topico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicoRepository extends JpaRepository<Topico,Long> {
}