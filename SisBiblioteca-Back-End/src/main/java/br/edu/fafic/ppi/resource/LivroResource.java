package br.edu.fafic.ppi.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import br.edu.fafic.ppi.domain.Livro;
import br.edu.fafic.ppi.service.LivroService;

@RestController
@RequestMapping(value = "/livro")
@CrossOrigin("*")
public class LivroResource {


	
	@Autowired
	private LivroService ls;
	
	
//	
//	@RequestMapping(method = RequestMethod.POST)
//	public ResponseEntity<Livro> save(@RequestBody Livro l){
//		lr.save(l);
//		
//		return ResponseEntity.ok().body(l);
//		
//	}
	
	//
	@PostMapping
	public ResponseEntity<?> inserir(@RequestBody Livro livro) {
		return new ResponseEntity<>(ls.inserir(livro), HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<?> update(@RequestBody Livro livro) throws Exception {
		return new ResponseEntity<>(ls.update(livro), HttpStatus.OK);
	}

	
//	@RequestMapping(value = "/update",method = RequestMethod.PUT)
//	public ResponseEntity<Livro> update(@RequestBody Livro l){
//		lr.save(l);
//		
//		return ResponseEntity.ok().body(l);
//		
//	}
	
	
//	@RequestMapping(value = "/isbn/{isbn}", method = RequestMethod.GET)
//	public ResponseEntity<Livro> findByLivroByIsbn(@PathVariable String isbn) throws Exception {
//		Livro l = ls.findByIsbn(isbn);
//
//		return ResponseEntity.ok().body(l);
//	}
	
	@GetMapping(path = "/isbn/{isbn}")
	public ResponseEntity<Livro> findByLivroByIsbn(@PathVariable String isbn) throws Exception {
		return new ResponseEntity<>(ls.findByIsbn(isbn), HttpStatus.OK);
	}

	
	@RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
	public ResponseEntity<Livro> findByLivroById(@PathVariable Long id) throws Exception {
		Livro l = ls.findById(id);

		return ResponseEntity.ok().body(l);
	}
	
	

	@RequestMapping(value = "/area/{area}", method = RequestMethod.GET)
	public ResponseEntity<Livro> findByLivroByArea(@PathVariable String area) throws Exception {
		Livro l = ls.findByArea(area);

		return ResponseEntity.ok().body(l);
	}
	
	
	@GetMapping("/all")
	public ResponseEntity<List<Livro>> findByAll() throws Exception {

		return ResponseEntity.ok().body(ls.findByAll());
	}

	@RequestMapping(value = "/nome/{nome}", method = RequestMethod.GET)
	public ResponseEntity<Livro> findByLivroByNome(@PathVariable String nome) throws Exception {
		Livro l = ls.findByNome(nome);

		return ResponseEntity.ok().body(l);
	}

	@RequestMapping(value = "/quant", method = RequestMethod.GET)
	public ResponseEntity<List<Livro>> findByLivroQuantDisponivel() throws Exception {

		return ResponseEntity.ok().body(ls.findByLivroQuantDisponivel());
	}
	
	
	
//	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
//	public ResponseEntity<List<Livro>> findByLivroQuantDisponivel(@PathVariable Long id) {
//		
//		
//		ls.deleteById(id);
//		
//		return ResponseEntity.ok().build();
//	}
	
	@RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<Livro> deleteById(@PathVariable Long id) {
		ls.deleteById(id);
		return ResponseEntity.ok().build();
	}
	
	
	
}
