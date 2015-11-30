package br.com.energia.service.impl;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.energia.model.Empresa;
import br.com.energia.repository.EmpresaRepository;
import br.com.energia.service.EmpresaService;

public class EmpresaServiceImpl implements EmpresaService, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EmpresaRepository empresas;
	
	//@Transacional
	public void salvar(Boolean isEdicao, Empresa empresa) {
		if (isEdicao) {
			empresas.atualizar(empresa);
		}else{
			empresas.salvar(empresa);
		}
	}
	
	//@Transacional
	public void excluir(Empresa empresa) {
		empresas.remover(empresa);
	}

}