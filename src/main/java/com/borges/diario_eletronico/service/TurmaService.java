package com.borges.diario_eletronico.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.borges.diario_eletronico.domain.SerieNivelSubnivel;
import com.borges.diario_eletronico.domain.Turma;
import com.borges.diario_eletronico.domain.dtos.TurmaDTO;
import com.borges.diario_eletronico.repository.TurmaRepository;
import com.borges.diario_eletronico.service.execeptions.ObjectNotFoundException;


@Service
public class TurmaService{
	
	@Autowired
	private TurmaRepository repository;
	@Autowired
	private SerieNivelSubnivelService serieService;
	
	public Turma findById(Integer id) {
		Optional<Turma> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id));
	}

	public List<Turma> findAll() {
		return repository.findAll();
	}

	public Turma create(TurmaDTO objDTO) {
		return repository.save(newTurma(objDTO));
	}
	
	public Turma update(Integer id, @Valid TurmaDTO objDTO) {
		objDTO.setId(id);
		Turma oldObj = findById(id);
		oldObj = newTurma(objDTO);
		return repository.save(oldObj);
	}
	
	private Turma newTurma(TurmaDTO obj) {
		SerieNivelSubnivel serie = serieService.findById(obj.getSerieNivelSubnivel());
		
		Turma turma = new Turma();
		if(obj.getId() != null) {
			turma.setId(obj.getId());
		}
		
		turma.setAno_letivo(obj.getAno_letivo());
		turma.setSala(obj.getSala());
		turma.setSerieNivelSubnivel(serie);
		
		return turma;
	}
	
	public void delete(Integer id) {
		
		repository.deleteById(id);
	}
	
}
