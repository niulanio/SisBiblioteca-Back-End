package br.edu.fafic.ppi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.edu.fafic.ppi.domain.Livro;
import br.edu.fafic.ppi.enuns.Area;
import br.edu.fafic.ppi.repository.LivroRepository;

@Service
public class LivroService {

	@Autowired
	private LivroRepository lr;
	
	//
	public Livro inserir(Livro livro) {
		return lr.save(livro);
	}
	
	//
	public Livro update(Livro livro) {
		return lr.save(livro);
	}

	
	
	public Livro findByIsbn(String isbn) throws Exception {
		Optional<Livro> l = lr.findByIsbn(isbn);
		return l.orElseThrow(()-> new Exception("Erro ao consultar livro"));
	}
	
	public Livro findById(Long id) throws Exception {
		Optional<Livro> l = lr.findById(id);
		
		return l.orElseThrow(()-> new Exception("Erro ao consultar livro"));
	}
	
	
	public Livro findByArea(String area) throws Exception {
		Livro l = lr.findByArea(Area.toEnum(area));
		return l;
	}
	
	
	public Livro findByNome(String nome) throws Exception {
		Optional<Livro> l = lr.findByNome(nome);
		
		return l.orElseThrow(()-> new Exception("Erro ao consultar livro"));
	}
	
	
	public List<Livro> findByLivroQuantDisponivel() throws Exception {
		Optional<List<Livro>> l = lr.findByLivroQuantDisponivel();
		
		return l.orElseThrow(()-> new Exception("Erro ao consultar livro"));
	}
	
	
	public List<Livro> findByAll() throws Exception {
		List<Livro> l = lr.findAll();
		
		return l;
	}
	
	
	
	public void deleteById(Long id) {
		
		
		lr.deleteById(id);
	}
	
}
