package br.edu.fafic.ppi.enuns;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;


@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Periodo {

	P1(1, "p1"),
	P2(2, "p2"),
	P3(3, "p3"),
	P4(4, "p4"),
	P5(5, "p5"),
	P6(6, "p6"),
	P7(7, "p7"),
	P8(8, "p8");
	
	private Integer chave;
	private String valor;
	
	private Periodo(Integer chave, String valor) {
		this.chave = chave;
		this.valor = valor;
	}
	
	private Periodo() {
		
	}
	
	public Integer getChave() {
		return chave;
	}
	public void setChave(Integer chave) {
		this.chave = chave;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	
	@JsonCreator(mode = JsonCreator.Mode.DELEGATING)
	public static Periodo toEnum(Integer codigo) {
		for (Periodo p : Periodo.values()) {
			if(codigo.equals(p.getChave())) {
				return p;
			}
		}
		return null;
	}
	
	@JsonCreator(mode = JsonCreator.Mode.DELEGATING)
	public static Periodo toEnum(String valor) {
		for (Periodo p : Periodo.values()) {
			if (valor.equals(p.valor)) {
				return p;
			}
		}
		return null;
	}
}
