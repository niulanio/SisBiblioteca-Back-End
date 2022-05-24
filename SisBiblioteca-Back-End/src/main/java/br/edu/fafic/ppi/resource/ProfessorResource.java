package br.edu.fafic.ppi.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.edu.fafic.ppi.domain.Professor;
import br.edu.fafic.ppi.service.ProfessorService;

@RestController
@RequestMapping(value = "/professor")
public class ProfessorResource {
	
	
	@Autowired
	ProfessorService ps;

	@RequestMapping(value = "/nome/{nome}", method = RequestMethod.GET)
	public ResponseEntity<Professor> findByProfessorByNome(@PathVariable String nome) throws Exception {

		Professor a = ps.findByNome(nome);

		return ResponseEntity.ok().body(a);
	}

	@RequestMapping(value = "/matricula/{matricula}", method = RequestMethod.GET)
	public ResponseEntity<Professor> findByProfesorByMatricula(@PathVariable Integer matricula) throws Exception {

		Professor a = ps.findByMatricula(matricula);

		return ResponseEntity.ok().body(a);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Professor> saveProfessor(@RequestBody Professor professor) {

		Professor a = ps.save(professor);

		return ResponseEntity.ok().body(a);
	}
	
	@RequestMapping(value = "/update",method = RequestMethod.PUT)
	public ResponseEntity<Professor> updateProfessor(@RequestBody Professor professor) {

		Professor a = ps.save(professor);

		return ResponseEntity.ok().body(a);
	}
	
	
	@RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<Professor> deleteById(@PathVariable Long id) {

		ps.deleteById(id);

		return ResponseEntity.ok().build();
	}

}
