package br.org.adfego.cadastro.model.enums;

public enum Situation {

	ATIVADO (1, "Ativo"),
	DESATIVADO (0, "Desativado");

	private int cod;
	private String descricao;

	Situation(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	public int getCod() {
		return cod;
	}

	public String getDescricao () {
		return descricao;
	}

	public static Situation toEnum(Integer cod) {

		if (cod == null) {
			return null;
		}

		for (Situation x : Situation.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}

		throw new IllegalArgumentException("Id inválido: " + cod);
	}
}
