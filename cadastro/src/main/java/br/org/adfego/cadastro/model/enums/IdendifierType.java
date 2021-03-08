package br.org.adfego.cadastro.model.enums;

public enum IdendifierType {

	CPF (0, "CPF"),
	RG (1, "RG");

	private int cod;
	private String descricao;

	IdendifierType(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	public int getCod() {
		return cod;
	}

	public String getDescricao () {
		return descricao;
	}

	public static IdendifierType toEnum(Integer cod) {

		if (cod == null) {
			return null;
		}

		for (IdendifierType x : IdendifierType.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}

		throw new IllegalArgumentException("Id inválido: " + cod);
	}
}
