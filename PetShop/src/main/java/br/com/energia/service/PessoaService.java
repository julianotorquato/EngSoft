package br.com.energia.service;

import br.com.energia.model.Pessoa;

public interface PessoaService {
	public void salvar(Boolean isEdicao, Pessoa pessoa);
	
	public void excluir(Pessoa pessoa);
}
