package com.borges.diario_eletronico.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.borges.diario_eletronico.domain.Disciplina;
import com.borges.diario_eletronico.domain.ProfessorTurma;
import com.borges.diario_eletronico.domain.ProfessorTurmaDisciplina;
import com.borges.diario_eletronico.domain.dtos.ProfessorTurmaDisciplinaDTO;
import com.borges.diario_eletronico.repository.ProfessorTurmaDisciplinaRepository;
import com.borges.diario_eletronico.service.execeptions.DataIntegratyViolationException;
import com.borges.diario_eletronico.service.execeptions.ObjectNotFoundException;


@Service
public class ProfessorTurmaDisciplinaService{
	
	@Autowired
	private ProfessorTurmaDisciplinaRepository repository;
	
	@Autowired
	private ProfessorTurmaService professorTurmaService;
	
	@Autowired
	private DisciplinaService disciplinaService;
	
	public ProfessorTurmaDisciplina findById(Integer id) {
		Optional<ProfessorTurmaDisciplina> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id));
	}

	public List<ProfessorTurmaDisciplina> findAll() {
		return repository.findAll();
	}

	public ProfessorTurmaDisciplina create(ProfessorTurmaDisciplinaDTO objDTO) {
		return repository.save(newProfessorTurmaDisciplina(objDTO));
	}
	
	public ProfessorTurmaDisciplina update(Integer id, @Valid ProfessorTurmaDisciplinaDTO objDTO) {
		objDTO.setId(id);
		ProfessorTurmaDisciplina oldObj = findById(id);
		oldObj = newProfessorTurmaDisciplina(objDTO);
		return repository.save(oldObj);
	}
	
	private ProfessorTurmaDisciplina newProfessorTurmaDisciplina(ProfessorTurmaDisciplinaDTO obj) {
		
		ProfessorTurma profTurma = professorTurmaService.findById(obj.getProfessorTurma());
		
		Disciplina disciplina = disciplinaService.findById(obj.getDisciplina());
		
		ProfessorTurmaDisciplina professorTurmaDisciplina = new ProfessorTurmaDisciplina();
		
		if(obj.getId() != null) {
			professorTurmaDisciplina.setId(obj.getId());
		}
		
		professorTurmaDisciplina.setProfessorTurma(profTurma);
		professorTurmaDisciplina.setDisciplina(disciplina);;
		professorTurmaDisciplina.setBimestre(obj.getBimestre());
		professorTurmaDisciplina.setAnoLetivo(obj.getAnoLetivo());
		
		return professorTurmaDisciplina;
	}
	
	public void delete(Integer id) {
		
		ProfessorTurmaDisciplina obj = findById(id);

		if (obj.getAula().size() > 0) {

			throw new DataIntegratyViolationException("Professor possui aulas, não pode ser deletado!");

		}
		repository.deleteById(id);
	}
	
}
