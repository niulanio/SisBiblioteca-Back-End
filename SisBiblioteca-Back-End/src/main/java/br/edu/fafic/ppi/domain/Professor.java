package br.edu.fafic.ppi.domain;


import javax.persistence.Entity;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import br.edu.fafic.ppi.enuns.Area;
import br.edu.fafic.ppi.enuns.Genero;

@Entity
public class Professor extends Usuario{


	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	@OneToOne
	@Cascade(CascadeType.ALL)
	private Curso curso;
	
	

	private Integer area;
	
	
	

	public Professor() {
	}




	public Professor(String nome, String cpf, Genero genero, Endereco endereco,Contato contato, Login login, Curso curso, Area area, String perfil) {
		super(nome, cpf, genero, endereco, contato, login, perfil);
		this.curso = curso;
		this.area = area.getCodigo();
	}




	public Curso getCurso() {
		return curso;
	}




	public void setCurso(Curso curso) {
		this.curso = curso;
	}




	public Area getArea() {
		return Area.toEnum(area);
	}




	public void setArea(Area area) {
		this.area = area.getCodigo();
	}




	@Override
	public String toString() {
		return "Professor [curso=" + curso + ", area=" + area + "]";
	}



	
	
	
	
	

}
