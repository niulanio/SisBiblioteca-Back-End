package br.edu.fafic.ppi.enuns;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;


@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Genero {

	MASCULINO(1, "Masculino"), FEMININO(2, "Feminino");

	private Integer codigo;
	private String valor;
	
	
	
	@JsonValue
	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	private Genero(Integer codigo, String valor) {
		this.codigo = codigo;
		this.valor = valor;
	}

	@JsonCreator(mode = JsonCreator.Mode.DELEGATING)
	public static Genero toEnum(Integer codigo) {
		for (Genero g : Genero.values()) {
			if (codigo.equals(g.codigo)) {
				return g;
			}
		}
		return null;
	}
	
//	@JsonCreator(mode = JsonCreator.Mode.DELEGATING)
//	public static Genero toEnum(String valor) {
//		for (Genero g : Genero.values()) {
//			if (valor.equals(g.valor)) {
//				return g;
//			}
//		}
//		return null;
//	}
}
