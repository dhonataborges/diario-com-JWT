package com.borges.diario_eletronico.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.borges.diario_eletronico.domain.Aluno;
import com.borges.diario_eletronico.domain.Turma;
import com.borges.diario_eletronico.domain.dtos.AlunoDTO;
import com.borges.diario_eletronico.repository.AlunoRepository;
import com.borges.diario_eletronico.service.execeptions.ObjectNotFoundException;

@Service
public class AlunoService {
	
	@Autowired
	private AlunoRepository repository;

	@Autowired
	private TurmaService turmaService;
	
	public Aluno findById(Integer id) {
		Optional<Aluno> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id));
	}

	public List<Aluno> findAll() {
		return repository.findAll();
	}

	public Aluno create(AlunoDTO objDTO) {
		return repository.save(newAluno(objDTO));
	}
	
	public Aluno update(Integer id, @Valid AlunoDTO objDTO) {
		objDTO.setId(id);
		Aluno oldObj = findById(id);
		oldObj = newAluno(objDTO);
		return repository.save(oldObj);
	}
	
	private Aluno newAluno(AlunoDTO obj) {
		Turma turma = turmaService.findById(obj.getTurma());
		
		Aluno aluno = new Aluno();
		if(obj.getId() != null) {
			turma.setId(obj.getId());
		}
		
		aluno.setNome(obj.getNome());
		aluno.setNascimento(obj.getNascimento());
		aluno.setSexo(obj.getSexo());
		aluno.setCpf(obj.getCpf());
		aluno.setRg(obj.getRg());
		aluno.setResponsavel(obj.getResponsavel());
		aluno.setTelefone(obj.getTelefone());
		aluno.setEndereco(obj.getEndereco());
		aluno.setZona(obj.getZona());
		aluno.setTurma(turma);
		
		return aluno;
	}
	
	public void delete(Integer id) {
		
		repository.deleteById(id);
	}
	
}