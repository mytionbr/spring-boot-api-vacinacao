package com.vacinacao.apirest.resources;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.vacinacao.apirest.models.Aplicacao;
import com.vacinacao.apirest.models.Usuario;
import com.vacinacao.apirest.repositories.AplicacaoRepository;
import com.vacinacao.apirest.repositories.UsuarioRepository;

@RestController
@RequestMapping("/aplicacoes")
public class AplicacaoResource {
	
	@Autowired
	private AplicacaoRepository aplicacaoRepository;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Aplicacao cadastrar(@Valid @RequestBody Aplicacao aplicacao) {
		return aplicacaoRepository.save(aplicacao);
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> lidarValidacoes(
	  MethodArgumentNotValidException ex) {
	    Map<String, String> errors = new HashMap<>();
	    ex.getBindingResult().getAllErrors().forEach((error) -> {
	        String fieldName = ((FieldError) error).getField();
	        String errorMessage = error.getDefaultMessage();
	        errors.put(fieldName, errorMessage);
	    });
	    return errors;
	}
}
