package br.edu.fafic.ppi.repository;


import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import br.edu.fafic.ppi.domain.Livro;
import br.edu.fafic.ppi.enuns.Area;




@Repository
public interface LivroRepository extends JpaRepository<Livro, Long>{
	
	
	public Optional<Livro> findByIsbn(String isbn);
	
	
	//@Query("select l FROM Livro l WHERE l.area= :area")
	public Livro findByArea(Area area);
	
	public Optional<Livro> findByNome(String nome);
	
	
	@Query("select l FROM Livro l WHERE l.quantLivro!= 0")
	public Optional<List<Livro>> findByLivroQuantDisponivel();
	
}
