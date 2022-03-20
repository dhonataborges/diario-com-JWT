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

import com.borges.diario_eletronico.domain.Cargo;
import com.borges.diario_eletronico.service.CargoService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/cargos")
public class CargoController {
	
	@Autowired
	private CargoService service;
	
	
	/**
	 * Buscar Cargo pelo ID
	 */
	@GetMapping(value = "/{id}")
	public ResponseEntity<Cargo> findById(@PathVariable Integer id) {
		
		Cargo obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	/*
	 * Busca todos os Cargo da base de dados
	 */
	@GetMapping
	public ResponseEntity<List<Cargo>> findAll() {
		List<Cargo> listCargo = service.findAll().stream().map(obj -> new Cargo(obj))
				.collect(Collectors.toList());
		return ResponseEntity.ok().body(listCargo);

	}
	
	/*
	 * Atualizar um Cargo
	 */
	@PutMapping(value = "/{id}")
	public ResponseEntity<Cargo> update(@PathVariable Integer id, @RequestBody Cargo obj) {
		Cargo newObj = new Cargo(service.update(id, obj));
		
		return ResponseEntity.ok().body(newObj);
	}
	
	/*
	 * Cria um Cargo
	 */
	@PostMapping
	public ResponseEntity<Cargo> create(@Valid @RequestBody Cargo obj) {
		Cargo newObj = service.create(obj);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();

		return ResponseEntity.created(uri).build();
	}
	
	/*
	 *  Delete um Cargo
	 */
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		
		return ResponseEntity.noContent().build();
	}
	
	
	
	
}