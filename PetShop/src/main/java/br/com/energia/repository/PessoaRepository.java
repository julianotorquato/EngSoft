package br.com.energia.repository;

import java.util.List;

import br.com.energia.model.Pessoa;
import br.com.energia.repository.filter.PessoaFilter;

public interface PessoaRepository extends GenericRepository<Pessoa, Long> {

    public List<Pessoa> getTodos();
    public List<Pessoa> listarPorCliente();
    public List<Pessoa> filtrados(PessoaFilter filtro);
}
