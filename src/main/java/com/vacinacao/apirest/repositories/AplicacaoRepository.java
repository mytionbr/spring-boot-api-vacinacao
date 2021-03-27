package com.vacinacao.apirest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vacinacao.apirest.models.Aplicacao;

public interface AplicacaoRepository extends JpaRepository<Aplicacao, Long> {

}
