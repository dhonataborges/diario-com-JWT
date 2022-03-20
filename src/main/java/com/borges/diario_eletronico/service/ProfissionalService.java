package com.borges.diario_eletronico.service;

import java.util.Arrays;
/*import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;*/
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.borges.diario_eletronico.domain.Aluno;
import com.borges.diario_eletronico.domain.Profissional;
import com.borges.diario_eletronico.domain.Turma;
import com.borges.diario_eletronico.domain.dtos.ProfissionalDTO;
import com.borges.diario_eletronico.domain.dtos.TurmaDTO;
import com.borges.diario_eletronico.repository.DisciplinaRepository;
import com.borges.diario_eletronico.repository.ProfissionalRepository;
import com.borges.diario_eletronico.repository.TurmaRepository;
import com.borges.diario_eletronico.service.execeptions.DataIntegratyViolationException;
import com.borges.diario_eletronico.service.execeptions.ObjectNotFoundException;
//import com.google.gson.Gson;

@Service
public class ProfissionalService {

	@Autowired
	private ProfissionalRepository profissionalRepository;
	
	@Autowired
	private TurmaService turmaService;
	
	@Autowired
	DisciplinaRepository disciplinaRepository;

	/**
	 * Buscar Profissional pelo ID
	 */
	public Profissional findById(Integer id) {

		Optional<Profissional> obj = profissionalRepository.findById(id);

		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id:" + id + ", Tipo:" + Profissional.class.getName()));
	}

	/*
	 * Busca todos os Profissional da base de dados
	 */
	public List<Profissional> findAll() {
		return profissionalRepository.findAll();
	}

	/*
	 * Atualizar um Profissional
	 */
	/*
	 * public Profissional update(Integer id, Profissional obj) {
	 * 
	 * Profissional oldObj = findById(id);
	 * 
	 * if (findByCPF(obj) != null && findByCPF(obj).getId() != id) {
	 * 
	 * throw new
	 * DataIntegratyViolationException("CPF já cadastrado na base de dados!");
	 * 
	 * }
	 * 
	 * oldObj.setNome(obj.getNome()); oldObj.setNascimento(obj.getNascimento());
	 * oldObj.setSexo(obj.getSexo()); oldObj.setCpf(obj.getCpf());
	 * oldObj.setRg(obj.getRg()); oldObj.setTelefone(obj.getTelefone());
	 * oldObj.setEndereco(obj.getEndereco()); oldObj.setNumero(obj.getNumero());
	 * oldObj.setBairro(obj.getBairro()); oldObj.setCep(obj.getCep());
	 * oldObj.setCidade(obj.getCidade()); oldObj.setEstado(obj.getEstado());
	 * oldObj.setZona(obj.getZona());
	 * 
	 * return profissionalRepository.save(oldObj);
	 * 
	 * }
	 */

	/*
	 * Atualizar um Turma
	 */
	public Profissional update(Integer id, @Valid ProfissionalDTO objDTO) {
		objDTO.setId(id);
		Profissional oldObj = findById(id);
		oldObj = newProfissional(objDTO);
		return profissionalRepository.save(oldObj);
	}

	private Profissional newProfissional(ProfissionalDTO obj) {

		Profissional profissional = new Profissional();
		Turma turma = turmaService.findById(obj.getTurma());

		if (obj.getId() != null) {
			profissional.setId(obj.getId());
		}
		
		profissional.setNome(obj.getNome());
		profissional.setNascimento(obj.getNascimento());
		profissional.setSexo(obj.getSexo());
		profissional.setCpf(obj.getCpf());
		profissional.setRg(obj.getRg());
		profissional.setTelefone(obj.getTelefone());
		profissional.setEndereco(obj.getEndereco());
		profissional.setNumero(obj.getNumero());
		profissional.setBairro(obj.getBairro());
		profissional.setCep(obj.getCep());
		profissional.setCidade(obj.getCidade());
		profissional.setEstado(obj.getEstado());
		profissional.setZona(obj.getZona());
		profissional.setTurma(Arrays.asList(turma));

		return profissional;
	}

	/*
	 * Cria um Profissional

	public Profissional create(Profissional obj) {
		if (findByCPF(obj) != null) {
			throw new DataIntegratyViolationException("CPF já cadastrado na base de dados!");
		}

		return profissionalRepository.save(new Profissional(null, obj.getNome(), obj.getNascimento(), obj.getSexo(), obj.getCpf(),
				obj.getRg(), obj.getTelefone(), obj.getEndereco(), obj.getNumero(), obj.getBairro(), obj.getCep(),
				obj.getCidade(), obj.getEstado(), obj.getZona()));

	}
*/
	
	/*
	 * Cria um Turma
	 */
	public Profissional create(ProfissionalDTO objDTO) {
		return profissionalRepository.save(newProfissional(objDTO));
	}
	
	/*
	 * Delete um Profissional pelo ID
	 */
	public void delete(Integer id) {

		profissionalRepository.deleteById(id);

	}

	/*
	 * Busca o Aluno pelo CPF
	 */
	private Profissional findByCPF(Profissional obj1) {
		Profissional obj = profissionalRepository.findByCPF(obj1.getCpf());
		if (obj != null) {
			return obj;
		}
		return null;
	}

}
