package br.com.energia.service.impl;

import java.io.Serializable;
import java.util.Date;

import javax.inject.Inject;

import br.com.energia.model.Pessoa;
import br.com.energia.model.TipoPessoa;
import br.com.energia.repository.PessoaRepository;
import br.com.energia.service.PessoaService;

public class PessoaServiceImpl implements PessoaService, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private PessoaRepository pessoaRepository;
	
	public void salvar(Boolean isEdicao, Pessoa pessoa) {
		if (isEdicao) {
			pessoaRepository.atualizar(pessoa);
		}else{
			pessoa.setTipoPessoa(TipoPessoa.CLIENTE);
			pessoa.setDtCadastro(new Date());
			pessoaRepository.salvar(pessoa);
		}
	}

	@Override
	public void excluir(Pessoa pessoa) {
		pessoaRepository.remover(pessoa);
	}

}