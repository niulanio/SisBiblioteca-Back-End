package br.edu.fafic.ppi.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.edu.fafic.ppi.enuns.Genero;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 50)
	private String nome;

	@Column(unique = true)
	private String cpf;


	private Integer genero;

	@Embedded
	private Endereco endereco;

	@Embedded
	private Contato contato;

	@Embedded
	private Login login;

	private String perfil;
	
	@ManyToMany(mappedBy = "usuario")
	private List<Emprestimo> emprestimo;
	

	public Usuario(String nome, String cpf, Genero genero, Endereco endereco, Contato contato, Login login, String perfil) {
		super();

		this.nome = nome;
		this.cpf = cpf;
		this.genero = genero.getCodigo();
		this.endereco = endereco;
		this.contato = contato;
		this.login = login;
		this.perfil= perfil;
	}

	public Usuario() {

	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
	
	@Override
	public String toString() {
		
		return "Usuario [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", genero=" + genero + ", endereco=" + endereco
				+ ", contato=" + contato + ", login=" + login + ", emprestimos=" + emprestimo + "]";
	}
	@JsonIgnore
	public List<Emprestimo> getEmprestimos() {
		return emprestimo;
	}

	public void setEmprestimos(List<Emprestimo> emprestimos) {
		this.emprestimo = emprestimos;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Genero getGenero() {
		return Genero.toEnum(genero);
	}

	public void setGenero(Genero genero) {
		this.genero = genero.getCodigo();
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
	
	
}