package com.borges.diario_eletronico.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.borges.diario_eletronico.domain.Aluno;
import com.borges.diario_eletronico.domain.Profissional;
import com.borges.diario_eletronico.domain.Turma;
import com.borges.diario_eletronico.domain.dtos.TurmaDTO;
import com.borges.diario_eletronico.repository.TurmaRepository;
import com.borges.diario_eletronico.service.execeptions.ObjectNotFoundException;
import com.sun.xml.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;


@Service
public class TurmaService{
	
	@Autowired
	private TurmaRepository turmaRepository;
	
	@Autowired
	private ProfissionalService profissionalService;

	@Autowired
	private AlunoService alunoService;

	
	/**
	 * Buscar Turma pelo ID
	 *
	public Turma findById(Integer id) {
		
		Optional<Turma> obj = turmaRepository.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id:" + id + ", Tipo:" + Turma.class.getName()));
	}
	/**/
	
	public Turma findById(Integer id) {
		Optional<Turma> obj = turmaRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id));
	}
	
	/*
	 * Busca todos os Cargos da base de dados
	 */
	public List<Turma> findAll(){
		return turmaRepository.findAll();
	}
	
	/*
	 * Atualizar um Turma
	 */
	public Turma update(Integer id, @Valid TurmaDTO objDTO) {
		objDTO.setId(id);
		Turma oldObj = findById(id);
		oldObj = newTurma(objDTO);
		return turmaRepository.save(oldObj);
	}
	
	private Turma newTurma(TurmaDTO obj) {
		
		Turma turma = new Turma();
		Profissional professores = profissionalService.findById(obj.getProfessores());
		Aluno aluno = alunoService.findById(obj.getAluno());
		
		if(obj.getId() != null) {
			turma.setId(obj.getId());
		}
		
		turma.setId(obj.getId());
		turma.setNomeTurma(obj.getNomeTurma());
		turma.setProfessor(Arrays.asList(professores));
		turma.setAluno(aluno);
		
		return turma;
	}
	
	/*
	 * Cria um Turma
	 */
	public Turma create(TurmaDTO objDTO) {
		return turmaRepository.save(newTurma(objDTO));
	}
	
	/*
	 * Delete um Turma pelo ID
	 */
	public void delete(Integer id) {
		
		turmaRepository.deleteById(id);
	}
	
	
		
}
