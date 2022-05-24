package br.edu.fafic.ppi.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
public class Emprestimo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	
	
	@ManyToOne//(cascade = CascadeType.MERGE)
	@JoinTable(name = "Emprestimos_Usuarios", joinColumns = {
			@JoinColumn(name = "Emprestimo_id") }, inverseJoinColumns = { @JoinColumn(name = "Usuario_id") })
	private Usuario usuario;

	@Temporal(TemporalType.DATE)
	private Date dataEmprestimo;

	@Column(length = 3)
	@ManyToMany(cascade = CascadeType.MERGE)
	private List<Livro> livrosLocados;

	public Emprestimo() {
		
	}

	public Emprestimo(Date dataEmprestimo, List<Livro> livrosLocados) {
		super();

		this.dataEmprestimo = dataEmprestimo;
		this.livrosLocados = livrosLocados;
	}

	public Date getDataEmprestimo() {
		return dataEmprestimo;
	}

	public void setDataEmprestimo(Date dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Livro> getLivrosLocados() {
		return livrosLocados;
	}

	public void setLivrosLocados(List<Livro> livrosLocados) {
		this.livrosLocados = livrosLocados;

	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Emprestimo [id=" + id + ", usuario=" + usuario + ", dataEmprestimo=" + dataEmprestimo
				+ ", livrosLocados=" + livrosLocados + "]";
	}

}
