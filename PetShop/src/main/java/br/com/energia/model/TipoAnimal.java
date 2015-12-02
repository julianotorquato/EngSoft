package br.com.energia.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class TipoAnimal {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idTipoAnimal;
	
	@NotEmpty
	@Column(name = "descricaoTipo", nullable = false, length = 150)
	private String descricaoTipo;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinColumn(name="RACA_IDRACA")
	private Set<Raca> racas;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinColumn(name="ANIMAL_IDANIMAL")
	private List<Animal> animal;

	public TipoAnimal(){

	}

	public Long getIdTipoAnimal() {
		return idTipoAnimal;
	}

	public void setIdTipoAnimal(Long idTipoAnimal) {
		this.idTipoAnimal = idTipoAnimal;
	}

	public String getDescricaoTipo() {
		return descricaoTipo;
	}

	public void setDescricaoTipo(String descricaoTipo) {
		this.descricaoTipo = descricaoTipo;
	}

	public Set<Raca> getRacas() {
		return racas;
	}

	public void setRacas(Set<Raca> racas) {
		this.racas = racas;
	}

	public List<Animal> getAnimal() {
		return animal;
	}

	public void setAnimal(List<Animal> animal) {
		this.animal = animal;
	}
	
	

}