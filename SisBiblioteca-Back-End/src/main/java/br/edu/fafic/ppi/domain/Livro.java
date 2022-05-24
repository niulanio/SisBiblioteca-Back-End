package br.edu.fafic.ppi.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import br.edu.fafic.ppi.enuns.Area;

@Entity
public class Livro implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 100)
	private String nome;
	
	@Column(unique = true,length = 10)
	private String isbn;
	

	private Integer area;
	
	private Integer quantLivro;

	
	
	public Livro() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Livro(String nome, String isbn, Area area,int quantLivro) {
		super();
		this.nome = nome;
		this.isbn = isbn;
		this.area = area.getCodigo();
		this.quantLivro = quantLivro;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public Integer getQuantLivro() {
		return quantLivro;
	}

	public void setQuantLivro(Integer quantLivro) {
		this.quantLivro = quantLivro;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getIsbn() {
		return isbn;
	}


	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}


	public Area getArea() {
		return Area.toEnum(area);
	}


	public void setArea(Area area) {
		this.area = area.getCodigo();
	}


	@Override
	public String toString() {
		return "Livro [id=" + id + ", nome=" + nome + ", isbn=" + isbn + ", area=" + area + "]";
	}
	
	
	
	

}
