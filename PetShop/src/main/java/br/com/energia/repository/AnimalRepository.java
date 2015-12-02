package br.com.energia.repository;

import java.util.List;
import br.com.energia.model.Animal;

public interface AnimalRepository extends GenericRepository<Animal, Long> {

	public List<Animal> getTodos();
}
