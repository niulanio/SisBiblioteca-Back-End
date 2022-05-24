package br.edu.fafic.ppi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import br.edu.fafic.ppi.domain.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long>{
	
	
	public Optional<Professor> findByNome(String nome);
	
	
	@Query("select a from Professor a join a.login l where l.matricula= :matricula")
	public Optional<Professor> findByMatricula(Integer matricula);
}
