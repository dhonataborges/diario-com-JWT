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

import com.borges.diario_eletronico.domain.Turma;
import com.borges.diario_eletronico.domain.dtos.TurmaDTO;
import com.borges.diario_eletronico.service.TurmaService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/turmas")
public class TurmaController {
	
	@Autowired
	private TurmaService service;
	
	
	/**
	 * Buscar Turma pelo ID
	 
	@GetMapping(value = "/{id}")
	public ResponseEntity<TurmaDTO> findById(@PathVariable Integer id) {
		
		TurmaDTO obj = new TurmaDTO(service.findById(id));
		return ResponseEntity.ok().body(obj);
	}*/
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<TurmaDTO> findById(@PathVariable Integer id) {
		Turma obj = service.findById(id);
		return ResponseEntity.ok().body(new TurmaDTO(obj));
	}
	
	
	/*
	 * Busca todos os Turma da base de dados*/
	 
	/*@GetMapping
	public ResponseEntity<List<TurmaDTO>> findAll() {
		List<TurmaDTO> list = service.findAll().stream().map(obj -> new TurmaDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(list);

	}
	*/
	
	@GetMapping
	public ResponseEntity<List<TurmaDTO>> findAll() {
		List<Turma> list = service.findAll();
		List<TurmaDTO> listDTO = list.stream().map(x -> new TurmaDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}

	/*
	 * Atualizar um Turma
	 
	@PutMapping(value = "/{id}")
	public ResponseEntity<TurmaDTO> update(@PathVariable Integer id, @RequestBody TurmaDTO obj) {
		TurmaDTO newObj = new TurmaDTO(service.update(id, obj));
		
		return ResponseEntity.ok().body(newObj);
	}
	*/
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<TurmaDTO> update(@PathVariable Integer id, @Valid @RequestBody TurmaDTO objDTO) {
		Turma obj = service.update(id, objDTO);
		return ResponseEntity.ok().body(new TurmaDTO(obj));
	}
	
	/*
	 * Cria um Turma
	 */
	@PostMapping
	public ResponseEntity<TurmaDTO> create(@Valid @RequestBody TurmaDTO obj) {
		Turma newObj = service.create(obj);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();

		return ResponseEntity.created(uri).build();
	}
	
	
	/*
	 *  Delete um Turma
	 */
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		
		return ResponseEntity.noContent().build();
	}
	
	
	
	
}