package br.edu.fafic.ppi.enuns;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Area {

	EXATAS(1, "Exatas"), HUMANAS(2, "Humanas");

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

	private Area(Integer codigo, String valor) {
		this.codigo = codigo;
		this.valor = valor;
	}

	@JsonCreator(mode = JsonCreator.Mode.DELEGATING)
	public static Area toEnum(Integer codigo) {
		for (Area a : Area.values()) {
			if (codigo.equals(a.codigo)) {
				return a;
			}
		}
		return null;
	}
	@JsonCreator(mode = JsonCreator.Mode.DELEGATING)
	public static Area toEnum(String valor) {
		for (Area a : Area.values()) {
			if (valor.equals(a.valor)) {
				return a;
			}
		}
		return null;
	}
}
