package br.edu.fafic.ppi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.edu.fafic.ppi.domain.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long>{
	
	
	
	public Optional<Aluno> findByNome(String nome);
	
	@Query("select a from Aluno a join a.login l where l.matricula= :matricula")
	public Optional<Aluno> findByMatricula(Integer matricula);

}
