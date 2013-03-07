package br.com.mendes.model;

public enum TipoAtendimento {

	TELEFONE("Telefone"),
	EMAIL("Email");
	
	private String descricao;
	
	private TipoAtendimento(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
}
