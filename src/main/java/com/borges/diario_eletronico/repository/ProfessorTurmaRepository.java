package com.borges.diario_eletronico.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.borges.diario_eletronico.domain.ProfessorTurma;

@Repository
public interface ProfessorTurmaRepository extends JpaRepository<ProfessorTurma, Integer> {
	
	/*@Query(value = "SELECT * FROM `professor_turma` WHERE professor_id = turma_id", nativeQuery = true)
	List<ProfessorTurma> findAllTurmas();*/

}
