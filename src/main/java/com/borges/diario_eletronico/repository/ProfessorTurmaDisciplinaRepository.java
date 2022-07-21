package com.borges.diario_eletronico.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.borges.diario_eletronico.domain.Professor;
import com.borges.diario_eletronico.domain.ProfessorTurmaDisciplina;

@Repository
public interface ProfessorTurmaDisciplinaRepository extends JpaRepository<ProfessorTurmaDisciplina, Integer> {
	/*@Query("select * ProfessorTurmaDisciplina p inner join p.professor pro where pro.email= :admin@gmail.com")
	Optional<ProfessorTurmaDisciplina> buscarProfessorTurma(@Param("professor") Integer professor);*/
		
	List<ProfessorTurmaDisciplina> findByProfessor(Professor professor);
}
