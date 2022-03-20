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

import com.borges.diario_eletronico.domain.Profissional;
import com.borges.diario_eletronico.domain.dtos.ProfissionalDTO;
import com.borges.diario_eletronico.service.ProfissionalService;


@CrossOrigin("*")
@RestController
@RequestMapping(value = "/profissionais")
public class ProfissionalController {
	
	@Autowired
	private ProfissionalService service;
		
	/**
	 * Buscar Profissional pelo ID
	 
	@GetMapping(value = "/{id}")
	public ResponseEntity<Profissional> findById(@PathVariable Integer id) {
		
		Profissional obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}*/
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ProfissionalDTO> findById(@PathVariable Integer id) {
		Profissional obj = service.findById(id);
		return ResponseEntity.ok().body(new ProfissionalDTO(obj));
	}
		
	/*
	 * Busca todos os Profissional da base de dados
	 
	@GetMapping
	public ResponseEntity<List<Profissional>> findAll() {
		List<Profissional> listProfissional = service.findAll().stream().map(obj -> new Profissional(obj))
				.collect(Collectors.toList());
		return ResponseEntity.ok().body(listProfissional);

	}*/
	
	@GetMapping
	public ResponseEntity<List<ProfissionalDTO>> findAll() {
		List<Profissional> list = service.findAll();
		List<ProfissionalDTO> listDTO = list.stream().map(x -> new ProfissionalDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}

	
	/*
	 * Atualizar um Profissional
	 */
	@PutMapping(value = "/{id}")
	public ResponseEntity<ProfissionalDTO> update(@PathVariable Integer id, @RequestBody ProfissionalDTO objDTO) {
		Profissional obj =  service.update(id, objDTO);
		
		return ResponseEntity.ok().body(new ProfissionalDTO(obj));
	}
	
	/*
	 * Cria um Profissional
	 */
	@PostMapping
	public ResponseEntity<ProfissionalDTO> create(@Valid @RequestBody ProfissionalDTO obj) throws Exception {
		
		Profissional newObj = service.create(obj);
							
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();

		return ResponseEntity.created(uri).build();
	}
	
/*	@PostMapping("/associarCursoProfessor")
    public String associarCurso(@ModelAttribute Disciplina curso, @RequestParam Integer codigoProfessor) {
        

        Profissional obj = service.findById(codigoProfessor);
        curso = disciplinaService.findById(curso.getId());
        

        obj.getDisciplinas().add(curso);
        service.create(obj);

        return "redirect:/detalhesProfessor/" + codigoProfessor;
    }*/

	
	/*
	 *  Delete um Profissional
	 */
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		
		return ResponseEntity.noContent().build();
	}
	
	
}