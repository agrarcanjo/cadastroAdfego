package br.org.adfego.cadastro.model.enums;

public enum PhoneType {

	CELULAR (0, "Celular"),
	TRABALHO (1, "Trabalho"),
	RESIDENCIA (2, "Residência"),
	CONTATO (3, "Contato");

	private int cod;
	private String descricao;

	private PhoneType(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	public int getCod() {
		return cod;
	}

	public String getDescricao () {
		return descricao;
	}

	public static PhoneType toEnum(Integer cod) {

		if (cod == null) {
			return null;
		}

		for (PhoneType x : PhoneType.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}

		throw new IllegalArgumentException("Id inválido: " + cod);
	}
}
