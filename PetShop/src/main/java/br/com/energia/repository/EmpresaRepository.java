package br.com.energia.repository;

import java.util.List;

import br.com.energia.model.Empresa;

public interface EmpresaRepository extends GenericRepository<Empresa, Long> {

    public List<Empresa> getTodos();
}
