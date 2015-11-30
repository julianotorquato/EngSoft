package br.com.energia.repository.impl;

import java.io.Serializable;
import java.util.List;

import br.com.energia.model.Empresa;
import br.com.energia.repository.EmpresaRepository;

public class EmpresaRepositoryImpl extends GenericRepositoryImpl<Empresa, Serializable> implements EmpresaRepository,  Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	public List<Empresa> getTodos() {
		return super.getTodos(Empresa.class);
	}
}