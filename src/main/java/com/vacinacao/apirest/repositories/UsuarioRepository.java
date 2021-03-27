package com.vacinacao.apirest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vacinacao.apirest.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
