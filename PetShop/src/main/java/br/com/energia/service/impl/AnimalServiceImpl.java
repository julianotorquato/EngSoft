package br.com.energia.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.energia.model.Animal;
import br.com.energia.repository.AnimalRepository;
import br.com.energia.service.AnimalService;

public class AnimalServiceImpl implements AnimalService, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private AnimalRepository animalRepository;
	

	@Override
	public void salvar(Animal entity) {
		animalRepository.salvar(entity);
	}

	@Override
	public void atualizar(Animal entity) {
		animalRepository.atualizar(entity);
	}

	@Override
	public void remover(Animal entity) {
		animalRepository.remover(entity);
	}

	@Override
	public Animal getPorId(Class<Animal> classe, Long id) {
		return animalRepository.getPorId(Animal.class, id);
	}

	@Override
	public List<Animal> getTodos(Class<Animal> classe) {
		return animalRepository.getTodos(Animal.class);
	}
}
