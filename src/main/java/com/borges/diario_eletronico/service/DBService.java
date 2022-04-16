package com.borges.diario_eletronico.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.borges.diario_eletronico.domain.Aluno;
import com.borges.diario_eletronico.domain.AtividadesAvaliativas;
import com.borges.diario_eletronico.domain.AulasLecionadas;
import com.borges.diario_eletronico.domain.Cargo;
import com.borges.diario_eletronico.domain.Frequencia;
import com.borges.diario_eletronico.domain.ObservacoesGerais;
import com.borges.diario_eletronico.domain.Professor;
import com.borges.diario_eletronico.domain.ResultadoFinal;
import com.borges.diario_eletronico.domain.Turma;
import com.borges.diario_eletronico.domain.enums.Perfil;
import com.borges.diario_eletronico.repository.AlunoRepository;
import com.borges.diario_eletronico.repository.AtividadesAvaliativasRepository;
import com.borges.diario_eletronico.repository.AulasLecionadasRepository;
import com.borges.diario_eletronico.repository.CargoRepository;
import com.borges.diario_eletronico.repository.FrequenciaRepository;
import com.borges.diario_eletronico.repository.ObservacoesGeraisRepository;
import com.borges.diario_eletronico.repository.ProfessorRepository;
import com.borges.diario_eletronico.repository.ResultadoFinalRepository;
import com.borges.diario_eletronico.repository.TurmaRepository;

@Service
public class DBService {
	
	//LocalDateTime agora = LocalDateTime.now();
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	@Autowired
	private ProfessorRepository profissionalRepository;
	
	@Autowired
	private ObservacoesGeraisRepository observacoesRepository;
	
	@Autowired
	private AulasLecionadasRepository aulasLecionadasRepository;
	
	@Autowired
	private FrequenciaRepository frequenciaRepository;
	
	@Autowired
	private AtividadesAvaliativasRepository  atividadesAvaliativasRepository;
	
	@Autowired
	private ResultadoFinalRepository  resultadoFinalRepository;
	
	@Autowired
	private TurmaRepository turmaRepository;
		
	@Autowired
	private CargoRepository cargoRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	public void instanciaDB() throws ParseException {	
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		/*DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
		LocalDateTime dateTime = LocalDateTime.parse("2016-09-21 13:43:27.000", formatter);*/
		
		Aluno a1 = new Aluno(null, "João Borges", sdf.parse("25/06/1995"),"masculino", "133.120.446-18", "mg19.599.003", "Maria Aparecida do Santos",
							"(38)99927-6907", "rua: batista", "urbana");
			
		Professor p1 = new Professor(null, "Mateus Oliver",sdf.parse("25/06/1995"), "feminino","787.352.100-10", "mg19.599.003", 
							"(38)99927-6907",  "rua: batista", "urbana","admin@gmail.com", encoder.encode("123"));
		p1.addPerfil(Perfil.ADMIN);
		
		
		Professor p2 = new Professor(null, "Joana Marques",sdf.parse("25/06/1995"), "feminino","957.443.730-20", "mg19.599.003", 
				"(38)99927-6907",  "rua: batista","rural","","");
		
		ObservacoesGerais obs1 = new ObservacoesGerais(null, sdf.parse("25/06/1995"), "Campo de Obs.....");
		
		AulasLecionadas al1 = new AulasLecionadas(null, sdf.parse("25/06/1995"), "oitavo", "matematica", "Campo de Obs.....");
		
		Frequencia f1 = new Frequencia(null, "Josias Barbosa", "inglês", 10.0, 5.0, "f", 25);
		
		AtividadesAvaliativas at1 = new AtividadesAvaliativas(null, "João Batista", 65.40, "sexto bimestre", 40.0, 50.0, 5.0, 95.0);
		
		ResultadoFinal r1 = new ResultadoFinal(null, "João Batista", "oitado ano", 78.0, 65.0, 25, 78.0, 1 );
	
		/*Disciplina d1 = new Disciplina(null, "Português", null, null);
		Disciplina d2 = new Disciplina(null, "Matematica", null, null);
		Disciplina d3 = new Disciplina(null, "Geografia", null, null);*/
		
		Cargo c1 = new Cargo(null, "Diretor", null);
		Cargo c2 = new Cargo(null, "Supervisor", null);
		Cargo c3 = new Cargo(null, "Professor", null);
		Cargo c4 = new Cargo(null, "Secretario", null);
		
		Turma t1 = new Turma(null,"202201MA", "Dom Pedro 2", "matutino", sdf.parse("01/02/2022"), p1);
		Turma t2 = new Turma(null,"202201VE", "Guimarães Rosa", "vespertino", sdf.parse("01/02/2022"), p2);
		
		alunoRepository.saveAll(Arrays.asList(a1));
		
		profissionalRepository.saveAll(Arrays.asList(p1,p2));
		
		observacoesRepository.saveAll(Arrays.asList(obs1));
		
		aulasLecionadasRepository.saveAll(Arrays.asList(al1));
		
		frequenciaRepository.saveAll(Arrays.asList(f1));
		
		atividadesAvaliativasRepository.saveAll(Arrays.asList(at1));
		
		resultadoFinalRepository.saveAll(Arrays.asList(r1));
		
		//enturmacaoRepository.saveAll(Arrays.asList(e1));
		
	//	disciplinaRepository.saveAll(Arrays.asList(d1,d2,d3));
		
		cargoRepository.saveAll(Arrays.asList(c4,c3,c2,c1));
		
		turmaRepository.saveAll(Arrays.asList(t2,t1));

	}

	
}