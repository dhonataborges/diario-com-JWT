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

import com.borges.diario_eletronico.domain.Disciplina;
import com.borges.diario_eletronico.service.DisciplinaService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/disciplinas")
public class DisciplinaController {
	
	@Autowired
	private DisciplinaService service;
	
	
	/**
	 * Buscar Disciplina pelo ID
	 */
	@GetMapping(value = "/{id}")
	public ResponseEntity<Disciplina> findById(@PathVariable Integer id) {
		
		Disciplina obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	/*
	 * Busca todos os Disciplina da base de dados
	 */
	@GetMapping
	public ResponseEntity<List<Disciplina>> findAll() {
		List<Disciplina> listDisciplina = service.findAll().stream().map(obj -> new Disciplina(obj))
				.collect(Collectors.toList());
		return ResponseEntity.ok().body(listDisciplina);

	}
	
	/*
	 * Atualizar um Disciplina
	 */
	@PutMapping(value = "/{id}")
	public ResponseEntity<Disciplina> update(@PathVariable Integer id, @RequestBody Disciplina obj) {
		Disciplina newObj = new Disciplina(service.update(id, obj));
		
		return ResponseEntity.ok().body(newObj);
	}
	
	/*
	 * Cria um Disciplina
	 */
	@PostMapping
	public ResponseEntity<Disciplina> create(@Valid @RequestBody Disciplina obj) {
		Disciplina newObj = service.create(obj);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();

		return ResponseEntity.created(uri).build();
	}
	
	/*
	 *  Delete um Disciplina
	 */
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		
		return ResponseEntity.noContent().build();
	}
	
	
	
	
}