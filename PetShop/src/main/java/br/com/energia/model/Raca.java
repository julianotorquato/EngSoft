package br.com.energia.model;

import java.io.Serializable;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Raca implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_raca")
	private Long idRaca;
	
	@NotEmpty
	@Column(nullable = false, length = 150)
	private String nome;
	
	@ManyToOne
    @JoinColumn(name = "id_tipo_animal")
	private TipoAnimal tipoAnimal;

	public Raca(){
	}

	public Long getIdRaca() {
		return idRaca;
	}

	public void setIdRaca(Long idRaca) {
		this.idRaca = idRaca;
	}

	public String getRacaTipo() {
		return nome;
	}

	public void setRacaTipo(String racaTipo) {
		this.nome = racaTipo;
	}

	public TipoAnimal getTipoAnimal() {
		return tipoAnimal;
	}

	public void setTipoAnimal(TipoAnimal tipoAnimal) {
		this.tipoAnimal = tipoAnimal;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idRaca == null) ? 0 : idRaca.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Raca other = (Raca) obj;
		if (idRaca == null) {
			if (other.idRaca != null)
				return false;
		} else if (!idRaca.equals(other.idRaca))
			return false;
		return true;
	}


}