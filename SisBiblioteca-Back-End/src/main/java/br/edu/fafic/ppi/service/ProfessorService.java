package br.edu.fafic.ppi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.fafic.ppi.domain.Professor;
import br.edu.fafic.ppi.repository.ProfessorRepository;


@Service
public class ProfessorService {
	
	
	@Autowired
	private ProfessorRepository pr;

	public Professor findByNome(String nome) throws Exception {
		Optional<Professor> al = pr.findByNome(nome);

		return al.orElseThrow(() -> new Exception("Erro ao consultar aluno"));

	}

	
	  public Professor findByMatricula(Integer matricula)throws Exception{
	  Optional<Professor> al = pr.findByMatricula(matricula);
	  
	  return al.orElseThrow(()-> new Exception("Erro ao consultar aluno"));
	  
	  }
	 

	public Professor save(Professor professor) {
		Professor a = pr.save(professor);

		return a;
	}
	
	
	public void deleteById(Long id) {
		pr.deleteById(id);
		
	}

}
