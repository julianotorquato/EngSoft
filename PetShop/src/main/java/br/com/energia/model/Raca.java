package br.com.energia.model;

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
import javax.validation.constraints.NotNull;

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
	private Animal animal;

	public Raca(){

	}

}