package br.edu.fafic.ppi.domain;



import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class Login {

	
	
	@Column(unique = true, length = 6)
	private int matricula;
	
	private String senha;
	
	public Login(int matricula, String senha) {
		super();
		this.matricula = matricula;
		this.senha = senha;
	}
	
	public Login() {
		
	}

	public int getMatricula() {
		return matricula;
	}


	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
