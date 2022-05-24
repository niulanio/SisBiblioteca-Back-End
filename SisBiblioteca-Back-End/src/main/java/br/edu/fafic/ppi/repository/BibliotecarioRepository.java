package br.edu.fafic.ppi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.fafic.ppi.domain.Bibliotecario;

@Repository
public interface BibliotecarioRepository extends JpaRepository<Bibliotecario, Long>{
	
	
	

}
