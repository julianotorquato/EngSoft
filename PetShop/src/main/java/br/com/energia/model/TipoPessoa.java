package br.com.energia.model;

public enum TipoPessoa {
	FUNCIONARIO("Funcionário"), 
	CLIENTE("Cliente");
	
	private String descricao;

	TipoPessoa(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
