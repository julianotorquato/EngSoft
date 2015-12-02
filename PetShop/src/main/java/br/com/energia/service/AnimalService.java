package br.com.energia.service;

import java.util.List;

import br.com.energia.model.Animal;

public interface AnimalService {

	 public void salvar(Animal entity);

	    public void atualizar(Animal entity);
	    
	    public void remover(Animal entity);
	       
	    public Animal getPorId(Class<Animal> classe, Long id);
	    
	    public List<Animal> getTodos(Class<Animal> classe);
}
