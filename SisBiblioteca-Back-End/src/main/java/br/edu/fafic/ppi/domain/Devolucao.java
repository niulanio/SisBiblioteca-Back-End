package br.edu.fafic.ppi.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Devolucao implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne
	private Emprestimo emprestimo;

	@Temporal(TemporalType.DATE)
	private Date dataDevolucao;

	private Double multa;

	public Devolucao(Emprestimo emprestimo, Date dataDevolucao) {
		super();
		this.emprestimo = emprestimo;
		this.dataDevolucao = dataDevolucao;
	}

	public Devolucao() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Devolucao [id=" + id + ", emprestimo=" + emprestimo + ", dataDevolucao=" + dataDevolucao + ", multa="
				+ multa + "]";
	}

	public Emprestimo getEmprestimo() {
		return emprestimo;
	}

	public void setEmprestimo(Emprestimo emprestimo) {
		this.emprestimo = emprestimo;
	}

	public Date getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(Date dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	public Double getMulta() {
		return multa;
	}

	public void setMulta(Double multa) {
		this.multa = multa;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	

}
