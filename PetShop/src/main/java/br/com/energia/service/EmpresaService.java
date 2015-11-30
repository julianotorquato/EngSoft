package br.com.energia.service;

import br.com.energia.model.Empresa;

public interface EmpresaService {
	public void salvar(Boolean isEdicao, Empresa empresa);
	
	public void excluir(Empresa empresa);
}
