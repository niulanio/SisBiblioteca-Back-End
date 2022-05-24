package br.edu.fafic.ppi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.fafic.ppi.domain.Bibliotecario;
import br.edu.fafic.ppi.repository.BibliotecarioRepository;


@Service
public class BibliotecarioService {
	
	@Autowired
	private BibliotecarioRepository repository;
	
	
	public Bibliotecario inserir(Bibliotecario bibliotecario) {
		return repository.save(bibliotecario);
	}
	
	public Bibliotecario findById(Long id) throws Exception {
		Optional<Bibliotecario> b = repository.findById(id);
		return b.orElseThrow(() -> new Exception("Erro ao consultar o bibliotecario"));
	}
	
	public Bibliotecario update(Bibliotecario bibliotecario) {
		return repository.save(bibliotecario);
	}


}
