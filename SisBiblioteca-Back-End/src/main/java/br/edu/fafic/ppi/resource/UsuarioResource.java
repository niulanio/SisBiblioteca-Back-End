package br.edu.fafic.ppi.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import br.edu.fafic.ppi.domain.Usuario;
import br.edu.fafic.ppi.service.UsuarioService;

@RestController
@RequestMapping("/Usuario")
public class UsuarioResource {

	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/login/{matricula}/{senha}")
	public ResponseEntity<Usuario> logByMatriculaSenha(@PathVariable("matricula")int matricula, @PathVariable("senha")String senha) throws Exception {
		
		return ResponseEntity.ok().body(usuarioService.loginUsuario(matricula, senha));
	}
	
	@RequestMapping(value = "/nome/{nome}", method = RequestMethod.GET)
	public ResponseEntity<Usuario> findByUsuarioByNome(@PathVariable String nome) throws Exception {

		Usuario u = usuarioService.findByNome(nome);

		return ResponseEntity.ok().body(u);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Usuario>> findByAllUsuario(){
		return ResponseEntity.ok().body(usuarioService.findAll());
	}
	
	@GetMapping(path = "/busca/{id}")
	public ResponseEntity<Usuario> findById(@PathVariable Long id) throws Exception {
		return new ResponseEntity<>(usuarioService.findById(id), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<Usuario> deleteById(@PathVariable Long id) {
		usuarioService.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
