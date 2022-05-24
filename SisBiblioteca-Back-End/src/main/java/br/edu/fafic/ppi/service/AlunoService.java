package br.edu.fafic.ppi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.fafic.ppi.domain.Aluno;
import br.edu.fafic.ppi.repository.AlunoRepository;

@Service
public class AlunoService {

	
	@Autowired
	private AlunoRepository ar;
	
	
	
	public Aluno findByNome(String nome)throws Exception{
		Optional<Aluno> al = ar.findByNome(nome);
		
		return al.orElseThrow(()-> new Exception("Erro ao consultar aluno"));
		
	}
	

	
	public Aluno findByMatricula(Integer matricula)throws Exception{
		  
	  Optional<Aluno> al = ar.findByMatricula(matricula);
	  
	  return al.orElseThrow(()-> new Exception("Erro ao consultar aluno"));
	  
	  }
	 
	
	public Aluno save(Aluno aluno) {
		Aluno a = ar.save(aluno);
		
		return a;
	}
	
	public void deleteById(Long id) {
		ar.deleteById(id);
		
	}
	
	
	
}
