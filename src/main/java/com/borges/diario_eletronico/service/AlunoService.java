package com.borges.diario_eletronico.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.borges.diario_eletronico.domain.Aluno;
import com.borges.diario_eletronico.domain.dtos.AlunoDTO;
import com.borges.diario_eletronico.repository.AlunoRepository;
import com.borges.diario_eletronico.service.execeptions.DataIntegratyViolationException;
import com.borges.diario_eletronico.service.execeptions.ObjectNotFoundException;

@Service
public class AlunoService {
	
	@Autowired
	private AlunoRepository repository;

	/*
	 * Busca Aluno pelo ID
	 */
	public Aluno findbyId(Integer id) {
		
		Optional<Aluno> obj = repository.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id:" + id + ", Tipo:" + Aluno.class.getName()));
	}

	/*
	 * Busca todos os clientes da base de dados
	 */
	public List<Aluno> findAll() {
		return repository.findAll();
	}

	/*
	 * Cria um Aluno
	 */
	public Aluno create(AlunoDTO objDTO) {

		if (findByCPF(objDTO) != null) {
			throw new DataIntegratyViolationException("CPF já cadastrado na base de dados!");
		}

		return repository.save(new Aluno(null, objDTO.getNome(), objDTO.getNascimento(), objDTO.getSexo(), objDTO.getCpf()
				, objDTO.getRg(), objDTO.getResponsavel(), objDTO.getTelefone(), objDTO.getEndereco(), objDTO.getZona(), objDTO.getSerie()));

	}

	/*
	 * Atualizar um Aluno
	 */
	public Aluno update(Integer id, @Valid AlunoDTO objDTO) {
		
		Aluno oldObj = findbyId(id);

		if (findByCPF(objDTO) != null && findByCPF(objDTO).getId() != id) {
			
			throw new DataIntegratyViolationException("CPF já cadastrado na base de dados!");
			
		}

		oldObj.setNome(objDTO.getNome());
		oldObj.setNascimento(objDTO.getNascimento());
		oldObj.setSexo(objDTO.getSexo());
		oldObj.setCpf(objDTO.getCpf());
		oldObj.setRg(objDTO.getRg());
		oldObj.setResponsavel(objDTO.getResponsavel());
		oldObj.setTelefone(objDTO.getTelefone());
		oldObj.setEndereco(objDTO.getEndereco());
		oldObj.setZona(objDTO.getZona());
		oldObj.setSerie(objDTO.getSerie());
		return repository.save(oldObj);
	}

	/*
	 * Delete um Aluno pelo ID
	 */
	public void delete(Integer id) {
		repository.deleteById(id);
	}

	/*
	 * Busca o Aluno pelo CPF
	 */
	private Aluno findByCPF(AlunoDTO objDTO) {
		Aluno obj = repository.findByCPF(objDTO.getCpf());

		if (obj != null) {
			return obj;
		}
		return null;
	}
}