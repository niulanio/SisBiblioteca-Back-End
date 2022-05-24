package br.edu.fafic.ppi.resource;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import br.edu.fafic.ppi.domain.Bibliotecario;

import br.edu.fafic.ppi.service.BibliotecarioService;

@RestController
@RequestMapping(path = "/bibliotecario")
public class BibliotecarioResource {

	@Autowired
	private BibliotecarioService service;

	@PostMapping
	public ResponseEntity<?> inserir(@RequestBody Bibliotecario bibliotecario) {
		return new ResponseEntity<>(service.inserir(bibliotecario), HttpStatus.OK);
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id) throws Exception {
		return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<?> update(@RequestBody Bibliotecario bibliotecario) throws Exception {
		return new ResponseEntity<>(service.update(bibliotecario), HttpStatus.OK);
	}

}
