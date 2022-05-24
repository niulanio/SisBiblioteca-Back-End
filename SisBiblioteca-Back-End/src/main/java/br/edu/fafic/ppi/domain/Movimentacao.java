package br.edu.fafic.ppi.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Movimentacao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne
	private Emprestimo emprestimo;
	
	@OneToOne
	private Devolucao devolucao;
	
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinTable(name = "Movimentacao_Usuarios", 
		joinColumns = {
		@JoinColumn(name = "Movimentacao_id")},
		inverseJoinColumns = {
		@JoinColumn(name = "Usuario_id")})
	private Usuario usuario;

	public Movimentacao(Emprestimo emprestimo, Devolucao devolucao) {
		super();

		this.emprestimo = emprestimo;
		this.devolucao = devolucao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Emprestimo getEmprestimo() {
		return emprestimo;
	}

	public void setEmprestimo(Emprestimo emprestimo) {
		this.emprestimo = emprestimo;
	}

	public Devolucao getDevolucao() {
		return devolucao;
	}

	public void setDevolucao(Devolucao devolucao) {
		this.devolucao = devolucao;
	}

	@Override
	public String toString() {
		return "Movimentacao [id=" + id + ", emprestimo=" + emprestimo + ", devolucao=" + devolucao + "]";
	}


}
