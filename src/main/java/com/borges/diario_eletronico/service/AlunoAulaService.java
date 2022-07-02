package com.borges.diario_eletronico.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.borges.diario_eletronico.domain.Aluno;
import com.borges.diario_eletronico.domain.AlunoAula;
import com.borges.diario_eletronico.domain.Aula;
import com.borges.diario_eletronico.domain.dtos.AlunoAulaDTO;
import com.borges.diario_eletronico.repository.AlunoAulaRepository;
import com.borges.diario_eletronico.service.execeptions.ObjectNotFoundException;

@Service
public class AlunoAulaService {

	@Autowired
	private AlunoAulaRepository repository;
	
	@Autowired	
	private AulaService aulaService;
	
	private AlunoService alunoService;

	public AlunoAula findById(Integer id) {
		Optional<AlunoAula> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id));
	}

	public List<AlunoAula> findAll() {
		return repository.findAll();
	}

	public AlunoAula create(AlunoAulaDTO objDTO) {
		return repository.save(newAlunoAula(objDTO));
	}

	public AlunoAula update(Integer id, @Valid AlunoAulaDTO objDTO) {
		
		objDTO.setId(id);
		AlunoAula oldObj = findById(id);
		
		/* if (oldObj.getProfessorAlunoAula().size() > 0) {

			throw new DataIntegratyViolationException("AlunoAula possui professor, não pode ser Atulaizada!");

		} */
		

		oldObj = newAlunoAula(objDTO);
		
		return repository.save(oldObj);
	}

	private AlunoAula newAlunoAula(AlunoAulaDTO objDTO) {
		
		Aula aula = aulaService.findById(objDTO.getAula());
		Aluno aluno = alunoService.findById(objDTO.getAluno());
		AlunoAula alunoAula = new AlunoAula();
		
		if (objDTO.getId() != null) {
			alunoAula.setId(objDTO.getId());
		}

		alunoAula.setFrequencia(objDTO.getFrequencia());
		alunoAula.setAula(aula);
		alunoAula.setAluno(aluno);

		return alunoAula;
	}

	public void delete(Integer id) {

		AlunoAula obj = findById(id);

		/* if (obj.getProfessorTurmaDisciplina().size() > 0) {

			throw new DataIntegratyViolationException("AlunoAula possui professor, não pode ser deletad!");

		} */
		repository.deleteById(id);
	}

}
