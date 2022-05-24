package br.edu.fafic.ppi.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.edu.fafic.ppi.domain.Aluno;
import br.edu.fafic.ppi.service.AlunoService;

@RestController
@RequestMapping(value = "/aluno")
public class AlunoResource {

	@Autowired
	private AlunoService as;

	@RequestMapping(value = "/nome/{nome}", method = RequestMethod.GET)
	public ResponseEntity<Aluno> findByAlunoByNome(@PathVariable String nome) throws Exception {

		Aluno a = as.findByNome(nome);

		return ResponseEntity.ok().body(a);
	}

	@RequestMapping(value = "/matricula/{matricula}", method = RequestMethod.GET)
	public ResponseEntity<Aluno> findByAlunoByMatricula(@PathVariable Integer matricula) throws Exception {

		Aluno a = as.findByMatricula(matricula);

		return ResponseEntity.ok().body(a);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Aluno> saveAluno(@RequestBody Aluno aluno) {

		Aluno a = as.save(aluno);

		return ResponseEntity.ok().body(a);
	}
	
	
	@RequestMapping(value = "/update",method = RequestMethod.PUT)
	public ResponseEntity<Aluno> updateAluno(@RequestBody Aluno aluno) {

		Aluno a = as.save(aluno);

		return ResponseEntity.ok().body(a);
	}
	
	
	@RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<Aluno> deleteById(@PathVariable Long id) {

		as.deleteById(id);

		return ResponseEntity.ok().build();
	}

}
