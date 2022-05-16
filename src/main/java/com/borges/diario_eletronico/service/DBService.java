package com.borges.diario_eletronico.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.borges.diario_eletronico.domain.Aluno;
import com.borges.diario_eletronico.domain.Disciplina;
import com.borges.diario_eletronico.domain.Professor;
import com.borges.diario_eletronico.domain.ProfessorTurma;
import com.borges.diario_eletronico.domain.SerieNivelSubnivel;
import com.borges.diario_eletronico.domain.Turma;
import com.borges.diario_eletronico.domain.enums.Perfil;
import com.borges.diario_eletronico.repository.AlunoRepository;
import com.borges.diario_eletronico.repository.DisciplinaRepository;
import com.borges.diario_eletronico.repository.ProfessorRepository;
import com.borges.diario_eletronico.repository.ProfessorTurmaRepository;
import com.borges.diario_eletronico.repository.SerieNivelSubnivelRepository;
import com.borges.diario_eletronico.repository.TurmaRepository;

@Service
public class DBService {
	
	//LocalDateTime agora = LocalDateTime.now();
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	@Autowired
	private DisciplinaRepository disciplinaRepository;
	
	@Autowired
	private ProfessorRepository profissionalRepository;
		
	@Autowired
	private TurmaRepository turmaRepository;
	
	@Autowired
	private SerieNivelSubnivelRepository serieRepository;
	
	@Autowired
	private ProfessorTurmaRepository professorTurmaRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	public void instanciaDB() throws ParseException {
		Date date = new Date();
		//LocalDate localDate = LocalDate.now();
		LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		int ano = localDate.getYear();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		/*DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
		LocalDateTime dateTime = LocalDateTime.parse("2016-09-21 13:43:27.000", formatter);*/
		
		Aluno a1 = new Aluno(null, "João Borges", sdf.parse("25/06/1995"),"masculino", "133.120.446-18", "mg19.599.003", "Maria Aparecida do Santos",
							"(38)99927-6907", "rua: batista", "urbana", "1° serie");
			
		Professor p1 = new Professor(null, "Mateus Oliver",sdf.parse("25/06/1995"), "feminino","787.352.100-10", "mg19.599.003", 
							"(38)99927-6907",  "rua: batista", "urbana","admin@gmail.com", encoder.encode("123"));
		p1.addPerfil(Perfil.ADMIN);
		
		
		Professor p2 = new Professor(null, "Joana Marques",sdf.parse("25/06/1995"), "feminino","957.443.730-20", "mg19.599.003", 
				"(38)99927-6907",  "rua: batista","rural","","");
				
		SerieNivelSubnivel s1 = new SerieNivelSubnivel(null, 2, 4, "Segunda Serie");
		
		Disciplina d1 = new Disciplina(null, "Português", "A Língua Portuguesa como fonte de comunicação ",null, null);
				
	    Turma t1 = new Turma(null, ano, 520, s1);
		
		ProfessorTurma pf1 = new ProfessorTurma(null, t1, p2, sdf.parse("25/06/1995"), true);
	    
        disciplinaRepository.saveAll(Arrays.asList(d1));
		
	    profissionalRepository.saveAll(Arrays.asList(p1,p2));
	    
	    alunoRepository.saveAll(Arrays.asList(a1));
	    
		turmaRepository.saveAll(Arrays.asList(t1));
		
		serieRepository.saveAll(Arrays.asList(s1));
		
		professorTurmaRepository.saveAll(Arrays.asList(pf1));

	}

	
}