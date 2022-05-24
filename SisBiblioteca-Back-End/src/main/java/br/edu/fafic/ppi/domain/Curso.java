package br.edu.fafic.ppi.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.edu.fafic.ppi.enuns.Periodo;

@Entity
public class Curso implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Override
	public String toString() {
		return "Curso [id=" + id + ", nome=" + nome + ", periodo=" + periodo + "]";
	}

	private String nome;

	@Enumerated(EnumType.ORDINAL)
	private Periodo periodo;

	public Curso(String nome, Periodo periodo) {
		super();
		this.nome = nome;
		this.periodo = periodo;
	}

	public Curso() {

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Periodo getPeriodo() {
		return periodo;
	}

	public void setPeriodo(Periodo periodo) {
		this.periodo = periodo;
	}

}
