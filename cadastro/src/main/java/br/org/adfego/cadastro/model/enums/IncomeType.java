package br.org.adfego.cadastro.model.enums;

public enum IncomeType {

	RENDA1 (0, "Celular"),
	RENDA2 (1, "Trabalho"),
	RENDA3 (2, "Residência"),
	RENDA4 (3, "Contato");

	private int cod;
	private String descricao;

	private IncomeType(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	public int getCod() {
		return cod;
	}

	public String getDescricao () {
		return descricao;
	}

	public static IncomeType toEnum(Integer cod) {

		if (cod == null) {
			return null;
		}

		for (IncomeType x : IncomeType.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}

		throw new IllegalArgumentException("Id inválido: " + cod);
	}
}
