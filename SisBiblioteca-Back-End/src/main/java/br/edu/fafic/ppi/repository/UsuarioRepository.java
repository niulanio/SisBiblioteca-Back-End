package br.edu.fafic.ppi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import br.edu.fafic.ppi.domain.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	//public Optional<Usuario> findByMatriculaAndSenha(int matricula, String senha);
	
	public Optional<Usuario> findByNome(String nome);
	
	@Query("SELECT u FROM Usuario u WHERE u.login.matricula= :matricula AND u.login.senha= :senha")
	public Optional<Usuario> autenticacao(@Param("matricula")int matricula, @Param("senha")String senha);

}
