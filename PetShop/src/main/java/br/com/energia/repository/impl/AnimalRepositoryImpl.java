package br.com.energia.repository.impl;

import java.io.Serializable;
import java.util.List;

import br.com.energia.model.Animal;
import br.com.energia.repository.AnimalRepository;

public class AnimalRepositoryImpl extends GenericRepositoryImpl<Animal, Serializable> implements AnimalRepository, Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	public List<Animal> getTodos() {
		return super.getTodos(Animal.class);
	}

}
