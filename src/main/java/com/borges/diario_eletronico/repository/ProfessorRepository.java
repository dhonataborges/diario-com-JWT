package com.borges.diario_eletronico.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.borges.diario_eletronico.domain.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Integer> {
	// Metodo findByCPF da camada de acesso a dados
	
	/*	@Query("SELECT obj FROM Professor obj WHERE obj.cpf =:cpf ")
		Professor findByCPF(@Param("cpf") String cpf);*/

}
