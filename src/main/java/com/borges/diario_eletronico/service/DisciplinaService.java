package com.borges.diario_eletronico.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.borges.diario_eletronico.domain.Disciplina;
import com.borges.diario_eletronico.repository.DisciplinaRepository;
import com.borges.diario_eletronico.service.execeptions.ObjectNotFoundException;


@Service
public class DisciplinaService{
	
	@Autowired
	private DisciplinaRepository disciplinaRepository;
	
	/**
	 * Buscar Disciplina pelo ID
	 */
	public Disciplina findById(Integer id) {
		
		Optional<Disciplina> obj = disciplinaRepository.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id:" + id + ", Tipo:" + Disciplina.class.getName()));
	}
	
	/*
	 * Busca todos os Usuarios da base de dados
	 */
	public List<Disciplina> findAll(){
		return disciplinaRepository.findAll();
	}
	
	/*
	 * Atualizar um Disciplina
	 */
	public Disciplina update(Integer id, Disciplina obj) {
		
		Disciplina oldObj = findById(id);

			
		oldObj.setId(obj.getId());
		oldObj.setNomeDisciplina(obj.getNomeDisciplina());
		oldObj.setProfessores(obj.getProfessores());
		oldObj.setAlunos(obj.getAlunos());
		
		return disciplinaRepository.save(oldObj);
	
	}
	
	/*
	 * Cria um Disciplina
	 */
	public Disciplina create(Disciplina obj) {
		
		return disciplinaRepository.save(new Disciplina(null, obj.getNomeDisciplina(), obj.getProfessores(), obj.getAlunos()));

	}
	
	/*
	 * Delete um Disciplina pelo ID
	 */
	public void delete(Integer id) {
		
		disciplinaRepository.deleteById(id);
		
	}
	
}
