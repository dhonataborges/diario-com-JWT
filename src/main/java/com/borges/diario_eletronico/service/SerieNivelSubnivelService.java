package com.borges.diario_eletronico.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.borges.diario_eletronico.domain.SerieNivelSubnivel;
import com.borges.diario_eletronico.domain.dtos.SerieNivelSubnivelDTO;
import com.borges.diario_eletronico.repository.SerieNivelSubnivelRepository;
import com.borges.diario_eletronico.service.execeptions.ObjectNotFoundException;

@Service
public class SerieNivelSubnivelService {
	
	
	@Autowired
	private SerieNivelSubnivelRepository repository;
		
	/**
	 * Buscar SerieNivelSubnivel pelo ID
	 **/	
	public SerieNivelSubnivel findById(Integer id) {
		Optional<SerieNivelSubnivel> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id));
	}
	
	/*
	 * Busca todos os Cargos da base de dados
	 */
	public List<SerieNivelSubnivel> findAll(){
		return repository.findAll();
	}
	
	/*
	 * 	Cria um tecnico
	 */
	public SerieNivelSubnivel create(SerieNivelSubnivelDTO objDTO) {
		
		return repository.save(new SerieNivelSubnivel(null, objDTO.getNivel(), objDTO.getSubnivel(), objDTO.getDescricao()));
		
	}
/*
 * 	Atualiza um SerieNivelSubnivel
 */
	public SerieNivelSubnivel update(Integer id, @Valid SerieNivelSubnivelDTO objDto) {
		
		SerieNivelSubnivel oldObj = findById(id);
		
		oldObj.setNivel(objDto.getNivel());
		oldObj.setSubnivel(objDto.getSubnivel());
		oldObj.setDescricao(objDto.getDescricao());
		return repository.save(oldObj);
		
	}
	
	/*
	 * Delete um SerieNivelSubnivel pelo ID
	 */
	public void delete(Integer id) {
		
		repository.deleteById(id);
	}
		
}
