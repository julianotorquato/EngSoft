package br.com.energia.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Raca {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idRaca;
	
	@NotEmpty
	@Column(name = "racaTipo", nullable = false, length = 150)
	private String racaTipo;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private TipoAnimal tipoAnimal;
	
	@NotEmpty
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinColumn(name="ANIMAL_IDANIMAL")
	private List<Animal> animal;

	public Raca(){

	}

	public Long getIdRaca() {
		return idRaca;
	}

	public void setIdRaca(Long idRaca) {
		this.idRaca = idRaca;
	}

	public String getRacaTipo() {
		return racaTipo;
	}

	public void setRacaTipo(String racaTipo) {
		this.racaTipo = racaTipo;
	}

	public TipoAnimal getTipoAnimal() {
		return tipoAnimal;
	}

	public void setTipoAnimal(TipoAnimal tipoAnimal) {
		this.tipoAnimal = tipoAnimal;
	}

	public List<Animal> getAnimal() {
		return animal;
	}

	public void setAnimal(List<Animal> animal) {
		this.animal = animal;
	}
	
}