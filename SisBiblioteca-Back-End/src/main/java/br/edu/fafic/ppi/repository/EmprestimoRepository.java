package br.edu.fafic.ppi.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.edu.fafic.ppi.domain.Emprestimo;

@Repository
public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long>{

	@Query("select e from Emprestimo e join e.usuario u where u.nome=:nome")
	public List<Emprestimo> findByEmprestimoAluno(String nome);
	
	@Query("select d.dataDevolucao from Devolucao d where d.emprestimo.id=:idEmprestimo")
	public Date  verificaDevolucao(Long idEmprestimo);

	
	
}
