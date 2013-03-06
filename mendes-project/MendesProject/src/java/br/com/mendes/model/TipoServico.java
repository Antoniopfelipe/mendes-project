package br.com.mendes.model;

public enum TipoServico {

	TIPO_1("Tipo 1"),
	TIPO_2("Tipo 2");
	
	private String descricao;
	
	private TipoServico(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
