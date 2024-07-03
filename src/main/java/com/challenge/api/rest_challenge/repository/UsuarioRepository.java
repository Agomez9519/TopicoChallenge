package com.challenge.api.rest_challenge.repository;

import com.challenge.api.rest_challenge.model.Topico;
import com.challenge.api.rest_challenge.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
}
