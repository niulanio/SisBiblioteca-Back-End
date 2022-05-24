package br.edu.fafic.ppi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.edu.fafic.ppi.domain.Usuario;
import br.edu.fafic.ppi.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	public Usuario loginUsuario(int matricula, String senha) throws Exception{
	    Optional<Usuario> u = usuarioRepository.autenticacao(matricula, senha);
	    
	    return u.orElseThrow(()-> new Exception("Matricula ou Senha inválidos"));
	    
	}
	
	public List<Usuario>findAll(){
		List<Usuario> u = usuarioRepository.findAll();
		return u;
	}
	
	public Usuario findById(Long id) throws Exception {
		 Optional<Usuario> u = usuarioRepository.findById(id);
		 return u.orElseThrow(() -> new  Exception("Erro ao buscar pelo ID"));
	}
	
	public void deleteById(Long id) {
		usuarioRepository.deleteById(id);
		
	}
	
	public Usuario findByNome(String nome)throws Exception{
		Optional<Usuario> u = usuarioRepository.findByNome(nome);
		
		return u.orElseThrow(()-> new Exception("Erro ao consultar aluno"));
		
	}

}
