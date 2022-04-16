package com.borges.diario_eletronico.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.borges.diario_eletronico.domain.Aluno;
import com.borges.diario_eletronico.domain.dtos.AlunoDTO;
import com.borges.diario_eletronico.service.AlunoService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/alunos")
public class AlunoController {
	
	@Autowired
	private AlunoService service;
	
	/**
	 * Buscar Aluno pelo ID
	 */
	@GetMapping(value = "/{id}")
	public ResponseEntity<AlunoDTO> findById(@PathVariable Integer id) {
		
		AlunoDTO objDTO = new AlunoDTO(service.findbyId(id));
		return ResponseEntity.ok().body(objDTO);
	}
	
	/*
	 * Busca todos os Aluno da base de dados
	 */
	@GetMapping
	public ResponseEntity<List<AlunoDTO>> findAll() {
		List<AlunoDTO> listAluno = service.findAll().stream().map(obj -> new AlunoDTO(obj))
				.collect(Collectors.toList());
		return ResponseEntity.ok().body(listAluno);

	}

	/*
	 * Cria um Aluno
	 */
	@PostMapping
	public ResponseEntity<AlunoDTO> create(@Valid @RequestBody AlunoDTO objDTO) {
		Aluno newObj = service.create(objDTO);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();

		return ResponseEntity.created(uri).build();
	}
	
	/*
	 * Atualizar um Aluno
	 */
	@PutMapping(value = "/{id}")
	public ResponseEntity<AlunoDTO> update(@PathVariable Integer id,  @Valid @RequestBody AlunoDTO objDTO) {
		AlunoDTO newObj = new AlunoDTO(service.update(id, objDTO));
		
		return ResponseEntity.ok().body(newObj);
	}
		
	/*
	 *  Delete um Aluno
	 */
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		
		return ResponseEntity.noContent().build();
	}
	
	
}