package com.borges.diario_eletronico.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.borges.diario_eletronico.domain.Cargo;
import com.borges.diario_eletronico.repository.CargoRepository;
import com.borges.diario_eletronico.service.execeptions.ObjectNotFoundException;


@Service
public class CargoService{
	
	@Autowired
	private CargoRepository cargoRepository;
	
	/**
	 * Buscar Cargo pelo ID
	 */
	public Cargo findById(Integer id) {
		
		Optional<Cargo> obj = cargoRepository.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id:" + id + ", Tipo:" + Cargo.class.getName()));
	}
	
	/*
	 * Busca todos os Cargos da base de dados
	 */
	public List<Cargo> findAll(){
		return cargoRepository.findAll();
	}
	
	/*
	 * Atualizar um Cargo
	 */
	public Cargo update(Integer id, Cargo obj) {
		
		Cargo oldObj = findById(id);

			
		oldObj.setId(obj.getId());
		oldObj.setNomeCargo(obj.getNomeCargo());
		oldObj.setProfissionais(obj.getProfissionais());
		
		return cargoRepository.save(oldObj);
	
	}
	
	/*
	 * Cria um Cargo
	 */
	public Cargo create(Cargo obj) {
		
		return cargoRepository.save(new Cargo(null, obj.getNomeCargo(), obj.getProfissionais()));

	}
	
	/*
	 * Delete um Cargo pelo ID
	 */
	public void delete(Integer id) {
		
		cargoRepository.deleteById(id);
		
	}
	
}
